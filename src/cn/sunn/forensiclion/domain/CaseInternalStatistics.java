package cn.sunn.forensiclion.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * CaseInternalStatistics entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "case_internal_statistics", catalog = "ForensicLion")
public class CaseInternalStatistics implements java.io.Serializable {

	// Fields

	private long id;
	private CaseInfor caseInfor;
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
	public CaseInternalStatistics(CaseInfor caseInfor, String payee,
			String identifyAssistant, String appraiser1, String appraiser2,
			String signer, String sources, String operationMaintain,
			String vip, String operationsOwner, String remark) {
		this.caseInfor = caseInfor;
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
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "case_id")
	public CaseInfor getCaseInfor() {
		return this.caseInfor;
	}

	public void setCaseInfor(CaseInfor caseInfor) {
		this.caseInfor = caseInfor;
	}

	@Column(name = "payee", length = 100)
	public String getPayee() {
		return this.payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	@Column(name = "identify_assistant", length = 100)
	public String getIdentifyAssistant() {
		return this.identifyAssistant;
	}

	public void setIdentifyAssistant(String identifyAssistant) {
		this.identifyAssistant = identifyAssistant;
	}

	@Column(name = "appraiser1", length = 100)
	public String getAppraiser1() {
		return this.appraiser1;
	}

	public void setAppraiser1(String appraiser1) {
		this.appraiser1 = appraiser1;
	}

	@Column(name = "appraiser2", length = 100)
	public String getAppraiser2() {
		return this.appraiser2;
	}

	public void setAppraiser2(String appraiser2) {
		this.appraiser2 = appraiser2;
	}

	@Column(name = "signer", length = 100)
	public String getSigner() {
		return this.signer;
	}

	public void setSigner(String signer) {
		this.signer = signer;
	}

	@Column(name = "sources", length = 400)
	public String getSources() {
		return this.sources;
	}

	public void setSources(String sources) {
		this.sources = sources;
	}

	@Column(name = "operation_maintain", length = 400)
	public String getOperationMaintain() {
		return this.operationMaintain;
	}

	public void setOperationMaintain(String operationMaintain) {
		this.operationMaintain = operationMaintain;
	}

	@Column(name = "vip", length = 400)
	public String getVip() {
		return this.vip;
	}

	public void setVip(String vip) {
		this.vip = vip;
	}

	@Column(name = "operations_owner", length = 400)
	public String getOperationsOwner() {
		return this.operationsOwner;
	}

	public void setOperationsOwner(String operationsOwner) {
		this.operationsOwner = operationsOwner;
	}

	@Column(name = "remark", length = 1200)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}