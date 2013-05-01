package cn.sunn.forensiclion.domain;

import java.util.Date;

/**
 * CaseCheckInfor entity. @author MyEclipse Persistence Tools
 */

public class CaseCheckInfor implements java.io.Serializable {

	// Fields

	private Long id;
	private String caseId;
	private String checkName;
	private String checkClass;
	private Integer num;
	private String unit;
	private Date getDate;
	private String barcode;
	private String remark;

	// Constructors

	/** default constructor */
	public CaseCheckInfor() {
	}

	/** full constructor */
	public CaseCheckInfor(String caseId, String checkName, String checkClass,
			Integer num, String unit, Date getDate, String barcode,
			String remark) {
		this.caseId = caseId;
		this.checkName = checkName;
		this.checkClass = checkClass;
		this.num = num;
		this.unit = unit;
		this.getDate = getDate;
		this.barcode = barcode;
		this.remark = remark;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCaseId() {
		return this.caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getCheckName() {
		return this.checkName;
	}

	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}

	public String getCheckClass() {
		return this.checkClass;
	}

	public void setCheckClass(String checkClass) {
		this.checkClass = checkClass;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Date getGetDate() {
		return this.getDate;
	}

	public void setGetDate(Date getDate) {
		this.getDate = getDate;
	}

	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}