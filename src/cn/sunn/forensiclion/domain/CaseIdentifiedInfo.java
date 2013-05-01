package cn.sunn.forensiclion.domain;

/**
 * CaseIdentifiedInfo entity. @author MyEclipse Persistence Tools
 */

public class CaseIdentifiedInfo implements java.io.Serializable {

	// Fields

	private Long id;
	private String caseId;
	private String name;
	private String sex;
	private String idcard;
	private String education;
	private String nation;
	private String address;
	private String remark;

	// Constructors

	/** default constructor */
	public CaseIdentifiedInfo() {
	}

	/** full constructor */
	public CaseIdentifiedInfo(String caseId, String name, String sex,
			String idcard, String education, String nation, String address,
			String remark) {
		this.caseId = caseId;
		this.name = name;
		this.sex = sex;
		this.idcard = idcard;
		this.education = education;
		this.nation = nation;
		this.address = address;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}