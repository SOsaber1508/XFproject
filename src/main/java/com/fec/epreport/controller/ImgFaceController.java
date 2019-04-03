package com.fec.epreport.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fec.epreport.service.InterFaceService;
import com.fec.epreport.util.http.HttpClientPoolHelper;

/**
 * Servlet implementation class FileDemo zcy
 */
@Controller
@RequestMapping(value = "/FileDemo")
public class ImgFaceController extends HttpServlet {

	private final static String username = "xfadmin";
	private final static String password = "xfpassword";
	private final static String adminname = "username";
	private final static String adminpassword = "password";
	private final static String idcard = "身份证";
	private final static String phone = "手机号";
	private final static String wx_name = "微信号";
	private final static String wx_nickname = "姓名";
	private final static String user_id = "wx_id";
	private static HttpClientPoolHelper hcph = HttpClientPoolHelper.getInstance();
	/**
	   * 
	   */
	private static final long serialVersionUID = 564190060577130813L;
	private static Logger logger = LoggerFactory.getLogger(ImgFaceController.class);

	@Autowired
	InterFaceService interFaceService;
	@Resource
	HttpServletRequest request;
	
	@ResponseBody
	@RequestMapping(value = "/imageFile.htm", method = RequestMethod.POST)
	public JSONObject imageFile(HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("进入/FileDemo/imageFile.htm");
		//String path = request.getServletContext().getContextPath();
		// 微信id
		String wx_id = "";
		// 身份证号
		String wx_idcard = "";
		// 文件拓展名
		String fileExtName = "";
		// 手机号
		String phoneNumber = "";
		// 微信号
		String wxName = "";
		// 真实姓名
		String wxNickname = "";
		JSONObject resultJson = new JSONObject();
		//System.out.println(path);
		// 得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全//身份证用
		String savePath = request.getServletContext().getRealPath("/WEB-INF/upload");
		System.out.println("savePath" + savePath);
		// 上传时生成的临时文件保存目录
		String tempPath = request.getServletContext().getRealPath("/WEB-INF/temp");
		//String tempPath = request.getServletContext().getRealPath("/") +"WEB-INF"+"/"+"temp";
		System.out.println("tempPath" + tempPath);
 		File tmpFile = new File(tempPath);
		if (!tmpFile.exists()) {
			// 创建临时目录
			tmpFile.mkdir();
		}
		// 消息提示
		String message = "";
		try {
			// 使用Apache文件上传组件处理文件上传步骤：
			// 1、创建一个DiskFileItemFactory工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 设置工厂的缓冲区的大小，当上传的文件大小超过缓冲区的大小时，就会生成一个临时文件存放到指定的临时目录当中。
			factory.setSizeThreshold(1024 * 100);// 设置缓冲区的大小为100KB，如果不指定，那么缓冲区的大小默认是10KB
			// 设置上传时生成的临时文件的保存目录
			factory.setRepository(tmpFile);
			// 2、创建一个文件上传解析器
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 监听文件上传进度
			upload.setProgressListener(new ProgressListener() {
				public void update(long pBytesRead, long pContentLength, int arg2) {
					System.out.println("文件大小为：" + pContentLength + ",当前已处理：" + pBytesRead);
					/**
					 * 文件大小为：14608,当前已处理：4096 文件大小为：14608,当前已处理：7367 文件大小为：14608,当前已处理：11419
					 * 文件大小为：14608,当前已处理：14608
					 */
//					float f = pBytesRead / pContentLength;
//					try {
//						response.getWriter().write(f + "");
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}

				}
			});
			// 解决上传文件名的中文乱码
			upload.setHeaderEncoding("UTF-8");
			// 3、判断提交上来的数据是否是上传表单的数据
			if (!ServletFileUpload.isMultipartContent(request)) {
				// 按照传统方式获取数据
				logger.info("上传的只有表单数据");
				resultJson.put("code", "204");
				return resultJson;
			}
			// 设置上传单个文件的大小的最大值，目前是设置为1024*1024字节，也就是1MB
			upload.setFileSizeMax(1024 * 1024*10);
			// 设置上传文件总量的最大值，最大值=同时上传的多个文件的大小的最大值的和，目前设置为10MB
			upload.setSizeMax(1024 * 1024 * 20);
			// 4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem item : list) {
				// 如果fileitem中封装的是普通输入项的数据
				if (item.isFormField()) {
					String name = item.getFieldName();
					String value = item.getString("utf-8");
					System.out.println(name+" = "+value);
					// String value = item.getString("utf-8");
					// 解决普通输入项的数据的中文乱码问题
					if ((name.equals(adminname) && !item.getString("utf-8").equals(username))
							|| (name.equals(adminpassword) && !item.getString("utf-8").equals(password))) {
						//request.setAttribute("message", "账户密码不对失敗！");
						resultJson.put("code", "205");
						return resultJson;
					}
					if (name.equals(idcard)) {
						wx_idcard = item.getString("utf-8");
					}
					if (name.equals(phone)) {
						phoneNumber = item.getString("utf-8");
					}
					if (name.equals(wx_name)) {
						wxName = item.getString("utf-8");
					}
					if (name.equals(wx_nickname)) {
						wxNickname = item.getString("utf-8");
					}
					if (name.equals(user_id)) {
						wx_id = item.getString("utf-8");
						//已放开用户修改资料
//						String user_authentication = interFaceService.selectidentityAuthentication(wx_id);
//						if (user_authentication.equals("1")) {
//							//request.setAttribute("message", "此用户已认证过资料！");
//							resultJson.put("code", "201");
//							return resultJson;
//						}
						
					}
					// System.out.println(wxObject.getString("身份证"));
					// value = new String(value.getBytes("iso8859-1"),"UTF-8");
				} 
				
				//判断字段唯一性
				//int count =interFaceService.selectAllInfoOne(idcard,phone,wx_name,wx_nickname);
				//if(count>0) {
					//resultJson.put("code", "201");//资料重复
				//return resultJson;
				//}
				else {// 如果fileitem中封装的是上传文件
						// 得到上传的文件名称，
					String filename = item.getName();
					System.out.println(filename);
					if (filename == null || filename.trim().equals("")) {
						continue;
					}
					// 注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如： c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
					// 处理获取到的上传文件的文件名的路径部分，只保留文件名部分
					//filename = filename.substring(filename.lastIndexOf("\\") + 1);
					System.out.println("filename++" + filename);
					// 得到上传文件的扩展名
					fileExtName = filename.substring(filename.lastIndexOf(".") + 1);
					System.out.println("fileExtName++" + fileExtName);
					// 如果需要限制上传的文件类型，那么可以通过文件的扩展名来判断上传的文件类型是否合法
					System.out.println("上传的文件的扩展名是：" + fileExtName);
					// 获取item中的上传文件的输入流
					InputStream in = item.getInputStream();
					// 得到文件保存的名称
					// String saveFilename = makeFileName(filename);
					// 将用户id 作为文件名字
					String saveFilename = wx_id;
					// 得到文件的保存目录
					// String realSavePath = makePath(saveFilename, savePath);
					if (filename.equals(wx_id+"."+fileExtName)) {
						savePath = request.getServletContext().getRealPath("/imageFace");
						//savePath=request.getServletContext().getRealPath("/")+"imageFace";
						System.out.println("头像图片路径:"+savePath);
					}
					String realSavePath = savePath;
					System.out.println("存储的图片路径:"+realSavePath);
					// 创建一个文件输出流
					//windows路径
					//FileOutputStream out = new FileOutputStream(realSavePath + "\\" + saveFilename+"."+fileExtName);
					FileOutputStream out = new FileOutputStream(realSavePath + File.separator + saveFilename+"."+fileExtName);
					System.out.println("存储的图片路径2:"+realSavePath + "/" + saveFilename+fileExtName);
					//System.out.println("filename+++++++"+filename);
					//System.out.println("realSavePath + \"\\\\\" + saveFilename++++"+realSavePath+ ".jpg");
					//System.out.println("realSavePath + \"\\\\\" + saveFilename++++"+realSavePath + "\\" + saveFilename);
					// 创建一个缓冲区
					byte buffer[] = new byte[1024];
					// 判断输入流中的数据是否已经读完的标识
					int len = 0;
					// 循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
					while ((len = in.read(buffer)) > 0) {
						// 使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
						out.write(buffer, 0, len);
					}
					// 关闭输入流
					in.close();
					// 关闭输出流
					out.close();
					// 删除处理文件上传时生成的临时文件
					item.delete();
					message = "文件上传成功";
				}
			}
		} catch (FileUploadBase.FileSizeLimitExceededException e) {
			e.printStackTrace();
			//request.setAttribute("message", "单个文件超出最大值！！！");
			resultJson.put("code", "206");
			return resultJson;
		} catch (FileUploadBase.SizeLimitExceededException e) {
			e.printStackTrace();
			//request.setAttribute("message", "上传文件的总的大小超出限制的最大值！！！");
			resultJson.put("code", "207");
			return resultJson;
		} catch (Exception e) {
			message = "文件上传失败！";
			e.printStackTrace();
		}
		if (message.equals("文件上传成功")) {
			String targetUrl = "http://47.111.11.27:8080/epreport/baiduIDcard/baidu.htm";
			JSONObject requestJson = new JSONObject();
			// 身份证号
			requestJson.put("wx_idcard", wx_idcard);
			// 微信id
			requestJson.put("wx_id", wx_id);
			// 手机号
			requestJson.put("phone", phoneNumber);
			// 微信号
			requestJson.put("wx_name", wxName);
			// 真实姓名
			requestJson.put("wx_nickname", wxNickname);
			// 文件后缀名
			requestJson.put("fileExtName", fileExtName);
			// 查询是不是库中已有
			try {
				String result = hcph.postRequest(targetUrl, requestJson.toString());
				System.out.println("result" + result);
				JSONObject jsoncode = JSON.parseObject(result);
				if (jsoncode.getString("code").equals("200")) {
					resultJson.put("code", "200");
				} else if(jsoncode.getString("code").equals("202")) {
					resultJson.put("code", "202");
				}else if(jsoncode.getString("code").equals("203")){
					resultJson.put("code", "203");
				}
				else {
					resultJson.put("code", "208");
				}
			} catch (Exception e) {
				resultJson.put("code", "208");
				logger.error(e.getLocalizedMessage(), e);
				e.printStackTrace();
			}
		}
		return resultJson;
	}

	/**
	 * @Method: makeFileName
	 * @Description: 生成上传文件的文件名，文件名以：uuid+"_"+文件的原始名称
	 * @Anthor:孤傲苍狼
	 * @param filename 文件的原始名称
	 * @return uuid+"_"+文件的原始名称
	 * 
	 *         // private String makeFileName(String filename) { // 2.jpg // //
	 *         为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名 // return UUID.randomUUID().toString()
	 *         + "_" + filename; // }
	 */
	/**
	 * 为防止一个目录下面出现太多文件，要使用hash算法打散存储
	 * 
	 * @Method: makePath
	 * @Description:
	 * @param filename 文件名，要根据文件名生成存储目录
	 * @param savePath 文件存储路径
	 * @return 新的存储目录
	 * 
	 *         private String makePath(String filename, String savePath) { //
	 *         得到文件名的hashCode的值，得到的就是filename这个字符串对象在内存中的地址 int hashcode =
	 *         filename.hashCode(); int dir1 = hashcode & 0xf; // 0--15 int dir2 =
	 *         (hashcode & 0xf0) >> 4; // 0-15 // 构造新的保存目录 String dir = savePath +
	 *         "\\" + dir1 + "\\" + dir2; // upload\2\3 upload\3\5 //
	 *         File既可以代表文件也可以代表目录 File file = new File(dir); // 如果目录不存在 if
	 *         (!file.exists()) { // 创建目录 file.mkdirs(); } return dir; }
	 */
//	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		ceshi(request, response);
//	}
}