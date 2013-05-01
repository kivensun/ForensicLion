package cn.sunn.forensiclion.domain;

import java.util.Date;

/**
 * CaseInfor entity. @author MyEclipse Persistence Tools
 */

public class CaseInfor implements java.io.Serializable {

	// Fields

	private Long id;
	private String caseId;
	private String identifyMajor;
	private Date entrustDate;
	private String identifyRequest;
	private String entrusterAddress;
	private String reportGetway;
	private String receiverName;
	private String receiverAddress;
	private String receiverCode;
	private String receiverEmail;
	private String entruster;
	private String entrusterRelation;
	private String entrusterNum;
	private String linkman;
	private String linkmanTel;
	private String linkmanFax;
	private String identifySender;
	private String insuranceUnit;
	private String insuranceLinkman;
	private String insuranceTel;
	private String insuranceEmail;
	private Date caseDate;
	private String caseClass;
	private Integer caseIdentifyTimes;
	private String caseProgress;
	private String caseRemark;
	private String status;

	// Constructors

	/** default constructor */
	public CaseInfor() {
	}

	/** minimal constructor */
	public CaseInfor(String caseId) {
		this.caseId = caseId;
	}

	/** full constructor */
	public CaseInfor(String caseId, String identifyMajor, Date entrustDate,
			String identifyRequest, String entrusterAddress,
			String reportGetway, String receiverName, String receiverAddress,
			String receiverCode, String receiverEmail, String entruster,
			String entrusterRelation, String entrusterNum, String linkman,
			String linkmanTel, String linkmanFax, String identifySender,
			String insuranceUnit, String insuranceLinkman, String insuranceTel,
			String insuranceEmail, Date caseDate, String caseClass,
			Integer caseIdentifyTimes, String caseProgress, String caseRemark,
			String status) {
		this.caseId = caseId;
		this.identifyMajor = identifyMajor;
		this.entrustDate = entrustDate;
		this.identifyRequest = identifyRequest;
		this.entrusterAddress = entrusterAddress;
		this.reportGetway = reportGetway;
		this.receiverName = receiverName;
		this.receiverAddress = receiverAddress;
		this.receiverCode = receiverCode;
		this.receiverEmail = receiverEmail;
		this.entruster = entruster;
		this.entrusterRelation = entrusterRelation;
		this.entrusterNum = entrusterNum;
		this.linkman = linkman;
		this.linkmanTel = linkmanTel;
		this.linkmanFax = linkmanFax;
		this.identifySender = identifySender;
		this.insuranceUnit = insuranceUnit;
		this.insuranceLinkman = insuranceLinkman;
		this.insuranceTel = insuranceTel;
		this.insuranceEmail = insuranceEmail;
		this.caseDate = caseDate;
		this.caseClass = caseClass;
		this.caseIdentifyTimes = caseIdentifyTimes;
		this.caseProgress = caseProgress;
		this.caseRemark = caseRemark;
		this.status = status;
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

	public String getIdentifyMajor() {
		return this.identifyMajor;
	}

	public void setIdentifyMajor(String identifyMajor) {
		this.identifyMajor = identifyMajor;
	}

	public Date getEntrustDate() {
		return this.entrustDate;
	}

	public void setEntrustDate(Date entrustDate) {
		this.entrustDate = entrustDate;
	}

	public String getIdentifyRequest() {
		return this.identifyRequest;
	}

	public void setIdentifyRequest(String identifyRequest) {
		this.identifyRequest = identifyRequest;
	}

	public String getEntrusterAddress() {
		return this.entrusterAddress;
	}

	public void setEntrusterAddress(String entrusterAddress) {
		this.entrusterAddress = entrusterAddress;
	}

	public String getReportGetway() {
		return this.reportGetway;
	}

	public void setReportGetway(String reportGetway) {
		this.reportGetway = reportGetway;
	}

	public String getReceiverName() {
		return this.receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverAddress() {
		return this.receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public String getReceiverCode() {
		return this.receiverCode;
	}

	public void setReceiverCode(String receiverCode) {
		this.receiverCode = receiverCode;
	}

	public String getReceiverEmail() {
		return this.receiverEmail;
	}

	public void setReceiverEmail(String receiverEmail) {
		this.receiverEmail = receiverEmail;
	}

	public String getEntruster() {
		return this.entruster;
	}

	public void setEntruster(String entruster) {
		this.entruster = entruster;
	}

	public String getEntrusterRelation() {
		return this.entrusterRelation;
	}

	public void setEntrusterRelation(String entrusterRelation) {
		this.entrusterRelation = entrusterRelation;
	}

	public String getEntrusterNum() {
		return this.entrusterNum;
	}

	public void setEntrusterNum(String entrusterNum) {
		this.entrusterNum = entrusterNum;
	}

	public String getLinkman() {
		return this.linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getLinkmanTel() {
		return this.linkmanTel;
	}

	public void setLinkmanTel(String linkmanTel) {
		this.linkmanTel = linkmanTel;
	}

	public String getLinkmanFax() {
		return this.linkmanFax;
	}

	public void setLinkmanFax(String linkmanFax) {
		this.linkmanFax = linkmanFax;
	}

	public String getIdentifySender() {
		return this.identifySender;
	}

	public void setIdentifySender(String identifySender) {
		this.identifySender = identifySender;
	}

	public String getInsuranceUnit() {
		return this.insuranceUnit;
	}

	public void setInsuranceUnit(String insuranceUnit) {
		this.insuranceUnit = insuranceUnit;
	}

	public String getInsuranceLinkman() {
		return this.insuranceLinkman;
	}

	public void setInsuranceLinkman(String insuranceLinkman) {
		this.insuranceLinkman = insuranceLinkman;
	}

	public String getInsuranceTel() {
		return this.insuranceTel;
	}

	public void setInsuranceTel(String insuranceTel) {
		this.insuranceTel = insuranceTel;
	}

	public String getInsuranceEmail() {
		return this.insuranceEmail;
	}

	public void setInsuranceEmail(String insuranceEmail) {
		this.insuranceEmail = insuranceEmail;
	}

	public Date getCaseDate() {
		return this.caseDate;
	}

	public void setCaseDate(Date caseDate) {
		this.caseDate = caseDate;
	}

	public String getCaseClass() {
		return this.caseClass;
	}

	public void setCaseClass(String caseClass) {
		this.caseClass = caseClass;
	}

	public Integer getCaseIdentifyTimes() {
		return this.caseIdentifyTimes;
	}

	public void setCaseIdentifyTimes(Integer caseIdentifyTimes) {
		this.caseIdentifyTimes = caseIdentifyTimes;
	}

	public String getCaseProgress() {
		return this.caseProgress;
	}

	public void setCaseProgress(String caseProgress) {
		this.caseProgress = caseProgress;
	}

	public String getCaseRemark() {
		return this.caseRemark;
	}

	public void setCaseRemark(String caseRemark) {
		this.caseRemark = caseRemark;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}