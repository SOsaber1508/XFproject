package com.fec.epreport.pojo;

import java.io.Serializable;
import java.util.Date;

public class XfAdvertiseHome implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String title;		// 广告标题
	private String company;		// 企业
	private String pic;		// 广告图片
	private String designId;		// 广告关联素材id
	private Date createTime;		// 创建时间
	private Integer auditStatus;		// 审核状态0未审核1已通过2未通过
	private Long seq;		// 排序字段数值越大越往前
	private Integer delFlag;		// 删除标志位0未删除1已删除
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getDesignId() {
		return designId;
	}
	public void setDesignId(String designId) {
		this.designId = designId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}
	public Long getSeq() {
		return seq;
	}
	public void setSeq(Long seq) {
		this.seq = seq;
	}
	public Integer getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
