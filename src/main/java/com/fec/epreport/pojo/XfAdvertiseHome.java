package com.fec.epreport.pojo;

import java.io.Serializable;
import java.util.Date;

public class XfAdvertiseHome implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String title; // 广告标题
	private String company; // 企业
	private String pic; // 广告图片
	private String designId; // 广告关联素材id
	private Date createTime; // 创建时间
	private Integer auditStatus; // 审核状态0未审核1已通过2未通过
	private Long seq; // 排序字段数值越大越往前
	private Integer delFlag; // 删除标志位0未删除1已删除
	private String province; // 省
	private String city;// 市

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

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public XfAdvertiseHome() {
		super();
		// TODO Auto-generated constructor stub
	}

	public XfAdvertiseHome(String id, String title, String company, String pic, String designId, Date createTime,
			Integer auditStatus, Long seq, Integer delFlag, String province, String city) {
		super();
		this.id = id;
		this.title = title;
		this.company = company;
		this.pic = pic;
		this.designId = designId;
		this.createTime = createTime;
		this.auditStatus = auditStatus;
		this.seq = seq;
		this.delFlag = delFlag;
		this.province = province;
		this.city = city;
	}

	@Override
	public String toString() {
		return "XfAdvertiseHome [id=" + id + ", title=" + title + ", company=" + company + ", pic=" + pic
				+ ", designId=" + designId + ", createTime=" + createTime + ", auditStatus=" + auditStatus + ", seq="
				+ seq + ", delFlag=" + delFlag + ", province=" + province + ", city=" + city + "]";
	}

}
