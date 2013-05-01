package cn.sunn.forensiclion.domain;

/**
 * CaseInternalStatistics entity. @author MyEclipse Persistence Tools
 */

public class CaseInternalStatistics implements java.io.Serializable {

	// Fields

	private Long id;
	private String caseId;
	private String payee;
	private String identifyAssistant;
	private String appraiser1;
	private String appraiser2;
	private String signer;
	private String sources;
	private String operationMaintain;
	private String vip;
	private String operationsOwner;
	private String remark;

	// Constructors

	/** default constructor */
	public CaseInternalStatistics() {
	}

	/** full constructor */
	public CaseInternalStatistics(String caseId, String payee,
			String identifyAssistant, String appraiser1, String appraiser2,
			String signer, String sources, String operationMaintain,
			String vip, String operationsOwner, String remark) {
		this.caseId = caseId;
		this.payee = payee;
		this.identifyAssistant = identifyAssistant;
		this.appraiser1 = appraiser1;
		this.appraiser2 = appraiser2;
		this.signer = signer;
		this.sources = sources;
		this.operationMaintain = operationMaintain;
		this.vip = vip;
		this.operationsOwner = operationsOwner;
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

	public String getPayee() {
		return this.payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public String getIdentifyAssistant() {
		return this.identifyAssistant;
	}

	public void setIdentifyAssistant(String identifyAssistant) {
		this.identifyAssistant = identifyAssistant;
	}

	public String getAppraiser1() {
		return this.appraiser1;
	}

	public void setAppraiser1(String appraiser1) {
		this.appraiser1 = appraiser1;
	}

	public String getAppraiser2() {
		return this.appraiser2;
	}

	public void setAppraiser2(String appraiser2) {
		this.appraiser2 = appraiser2;
	}

	public String getSigner() {
		return this.signer;
	}

	public void setSigner(String signer) {
		this.signer = signer;
	}

	public String getSources() {
		return this.sources;
	}

	public void setSources(String sources) {
		this.sources = sources;
	}

	public String getOperationMaintain() {
		return this.operationMaintain;
	}

	public void setOperationMaintain(String operationMaintain) {
		this.operationMaintain = operationMaintain;
	}

	public String getVip() {
		return this.vip;
	}

	public void setVip(String vip) {
		this.vip = vip;
	}

	public String getOperationsOwner() {
		return this.operationsOwner;
	}

	public void setOperationsOwner(String operationsOwner) {
		this.operationsOwner = operationsOwner;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}