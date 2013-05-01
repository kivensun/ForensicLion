package cn.sunn.forensiclion.domain;

/**
 * CaseCharge entity. @author MyEclipse Persistence Tools
 */

public class CaseCharge implements java.io.Serializable {

	// Fields

	private Long chargeId;
	private String caseId;
	private String chargeClass;
	private String chargeStandardType;
	private Long chargeAmount;
	private String chargeRemark;

	// Constructors

	/** default constructor */
	public CaseCharge() {
	}

	/** full constructor */
	public CaseCharge(String caseId, String chargeClass,
			String chargeStandardType, Long chargeAmount, String chargeRemark) {
		this.caseId = caseId;
		this.chargeClass = chargeClass;
		this.chargeStandardType = chargeStandardType;
		this.chargeAmount = chargeAmount;
		this.chargeRemark = chargeRemark;
	}

	// Property accessors

	public Long getChargeId() {
		return this.chargeId;
	}

	public void setChargeId(Long chargeId) {
		this.chargeId = chargeId;
	}

	public String getCaseId() {
		return this.caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getChargeClass() {
		return this.chargeClass;
	}

	public void setChargeClass(String chargeClass) {
		this.chargeClass = chargeClass;
	}

	public String getChargeStandardType() {
		return this.chargeStandardType;
	}

	public void setChargeStandardType(String chargeStandardType) {
		this.chargeStandardType = chargeStandardType;
	}

	public Long getChargeAmount() {
		return this.chargeAmount;
	}

	public void setChargeAmount(Long chargeAmount) {
		this.chargeAmount = chargeAmount;
	}

	public String getChargeRemark() {
		return this.chargeRemark;
	}

	public void setChargeRemark(String chargeRemark) {
		this.chargeRemark = chargeRemark;
	}

}