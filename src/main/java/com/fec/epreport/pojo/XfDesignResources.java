package com.fec.epreport.pojo;

import java.io.Serializable;
import java.util.Date;

public class XfDesignResources implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String title;		// 素材标题
	private String company;		// 企业
	private String content;		// 内容
	private Date createTime;		// 创建时间
	private Integer auditStatus;		// 审核状态0是未审核，1是已通过，2是未通过
	private Integer delFlag;		// 删除标志位，0未删除，1已删除
	private Long seq;		// 排序字段，值越大排序越往前
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public Integer getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	public Long getSeq() {
		return seq;
	}
	public void setSeq(Long seq) {
		this.seq = seq;
	}
	
}
