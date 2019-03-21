package com.fec.epreport.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/** TCP接收文件例子 */
@Controller
@RequestMapping(value = "/image")
public class ImageFaceController {
	public static ServerSocket server; //用于接收
	public static Socket socket;
	public static int port = 9999; //要监听的本地端口
	
   @RequestMapping(value = "/ImageSave.htm", method = RequestMethod.GET)
	public String ImageSave() {
		try {
			System.out.println("执行完毕");
			server = new ServerSocket(port);
			System.out.println("开始监听");
            while(true){
                Socket s = server.accept(); //阻塞
                new ReceiveThread(s).start();
            }
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("执行完毕");
		return null;
		
	}
	
	/** 接收的线程 */
	private static class ReceiveThread extends Thread {
		
		private Socket s;
		private InputStream socketIs;
        private OutputStream fos;
        /** 决定本线程是否要继续的标志 */
        private boolean isConnected;
        
	    public ReceiveThread(Socket s) {
	        this.s = s;
	        isConnected = true;
	    }
 
	    @Override
	    public void run() {
	    	
	    	while(isConnected) {
	    		
	    		String ip = s.getInetAddress().getHostAddress();
		        System.out.println("对方是" + ip + " 等待读取");
 
		        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmsssss");
		        String filePath = "E:\\" + simpleDateFormat.format(new Date()) + ".jpg";
 
		        try {
		        	socketIs = s.getInputStream();
		            
		            byte buf[] = new byte[1024];
		            int len = 0;
		            while((len = socketIs.read(buf)) != -1){  //阻塞
		            	if(fos == null) { fos = new FileOutputStream(filePath); }
		                fos.write(buf, 0, len);
		                //怎样判断文件接收完成？
		                //1. 如果对方断开连接，本循环自动退出
		                //2. 如果对方保持连接，用超时进行判断
		                s.setSoTimeout(500); //设置500ms超时
		            }
		       
		            System.out.println("【情况 1】连接断开，传输结束");
		            
		            isConnected = false; //此处是正常断开，要结束本线程
		            
		            if(fos != null) { fos.close(); } 
		            socketIs.close();
		            s.close();
		        } catch (SocketTimeoutException eTimeout) {
		            try {
		            	/*向对方返回消息*/
			            OutputStream out = s.getOutputStream();
			            out.write( "接收完成".getBytes() );
			            
			            s.setSoTimeout(0); //重新设回不超时
			            fos.close(); //关闭文件输出流，生成正常大小的文件
			            fos = null; //重新置null，防止目录中生成一个大小为0KB的文件
			            System.out.println("【情况2】超时，本次传输结束");
		            }catch(IOException eIO) { eIO.printStackTrace(); }
		
		        }catch(IOException eIO) { eIO.printStackTrace(); }
	    		
	    	}
	    	
	    }
		 
	}
	
 
}