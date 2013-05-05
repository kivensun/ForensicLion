package cn.sunn.forensiclion.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CaseInfor entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "case_infor", catalog = "ForensicLion")
public class CaseInfor implements java.io.Serializable {

	// Fields

	private long id;
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
	private Set<CaseCheckInfor> caseCheckInfors = new HashSet<CaseCheckInfor>(0);
	private Set<CaseFile> caseFiles = new HashSet<CaseFile>(0);
	private Set<CaseIdentifiedInfo> caseIdentifiedInfos = new HashSet<CaseIdentifiedInfo>(
			0);
	private Set<CaseCharge> caseCharges = new HashSet<CaseCharge>(0);
	private Set<CaseInternalStatistics> caseInternalStatisticses = new HashSet<CaseInternalStatistics>(
			0);

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
			String status, Set<CaseCheckInfor> caseCheckInfors,
			Set<CaseFile> caseFiles,
			Set<CaseIdentifiedInfo> caseIdentifiedInfos,
			Set<CaseCharge> caseCharges,
			Set<CaseInternalStatistics> caseInternalStatisticses) {
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
		this.caseCheckInfors = caseCheckInfors;
		this.caseFiles = caseFiles;
		this.caseIdentifiedInfos = caseIdentifiedInfos;
		this.caseCharges = caseCharges;
		this.caseInternalStatisticses = caseInternalStatisticses;
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

	@Column(name = "case_id", nullable = false, length = 10)
	public String getCaseId() {
		return this.caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	@Column(name = "identify_major", length = 60)
	public String getIdentifyMajor() {
		return this.identifyMajor;
	}

	public void setIdentifyMajor(String identifyMajor) {
		this.identifyMajor = identifyMajor;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "entrust_date", length = 10)
	public Date getEntrustDate() {
		return this.entrustDate;
	}

	public void setEntrustDate(Date entrustDate) {
		this.entrustDate = entrustDate;
	}

	@Column(name = "identify_request", length = 300)
	public String getIdentifyRequest() {
		return this.identifyRequest;
	}

	public void setIdentifyRequest(String identifyRequest) {
		this.identifyRequest = identifyRequest;
	}

	@Column(name = "entruster_address", length = 300)
	public String getEntrusterAddress() {
		return this.entrusterAddress;
	}

	public void setEntrusterAddress(String entrusterAddress) {
		this.entrusterAddress = entrusterAddress;
	}

	@Column(name = "report_getway", length = 30)
	public String getReportGetway() {
		return this.reportGetway;
	}

	public void setReportGetway(String reportGetway) {
		this.reportGetway = reportGetway;
	}

	@Column(name = "receiver_name", length = 20)
	public String getReceiverName() {
		return this.receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	@Column(name = "receiver_address", length = 300)
	public String getReceiverAddress() {
		return this.receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	@Column(name = "receiver_code", length = 10)
	public String getReceiverCode() {
		return this.receiverCode;
	}

	public void setReceiverCode(String receiverCode) {
		this.receiverCode = receiverCode;
	}

	@Column(name = "receiver_email", length = 50)
	public String getReceiverEmail() {
		return this.receiverEmail;
	}

	public void setReceiverEmail(String receiverEmail) {
		this.receiverEmail = receiverEmail;
	}

	@Column(name = "entruster", length = 100)
	public String getEntruster() {
		return this.entruster;
	}

	public void setEntruster(String entruster) {
		this.entruster = entruster;
	}

	@Column(name = "entruster_relation", length = 100)
	public String getEntrusterRelation() {
		return this.entrusterRelation;
	}

	public void setEntrusterRelation(String entrusterRelation) {
		this.entrusterRelation = entrusterRelation;
	}

	@Column(name = "entruster_num", length = 30)
	public String getEntrusterNum() {
		return this.entrusterNum;
	}

	public void setEntrusterNum(String entrusterNum) {
		this.entrusterNum = entrusterNum;
	}

	@Column(name = "linkman", length = 30)
	public String getLinkman() {
		return this.linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	@Column(name = "linkman_tel", length = 30)
	public String getLinkmanTel() {
		return this.linkmanTel;
	}

	public void setLinkmanTel(String linkmanTel) {
		this.linkmanTel = linkmanTel;
	}

	@Column(name = "linkman_fax", length = 30)
	public String getLinkmanFax() {
		return this.linkmanFax;
	}

	public void setLinkmanFax(String linkmanFax) {
		this.linkmanFax = linkmanFax;
	}

	@Column(name = "identify_sender", length = 30)
	public String getIdentifySender() {
		return this.identifySender;
	}

	public void setIdentifySender(String identifySender) {
		this.identifySender = identifySender;
	}

	@Column(name = "insurance_unit", length = 100)
	public String getInsuranceUnit() {
		return this.insuranceUnit;
	}

	public void setInsuranceUnit(String insuranceUnit) {
		this.insuranceUnit = insuranceUnit;
	}

	@Column(name = "insurance_linkman", length = 30)
	public String getInsuranceLinkman() {
		return this.insuranceLinkman;
	}

	public void setInsuranceLinkman(String insuranceLinkman) {
		this.insuranceLinkman = insuranceLinkman;
	}

	@Column(name = "insurance_tel", length = 30)
	public String getInsuranceTel() {
		return this.insuranceTel;
	}

	public void setInsuranceTel(String insuranceTel) {
		this.insuranceTel = insuranceTel;
	}

	@Column(name = "insurance_email", length = 50)
	public String getInsuranceEmail() {
		return this.insuranceEmail;
	}

	public void setInsuranceEmail(String insuranceEmail) {
		this.insuranceEmail = insuranceEmail;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "case_date", length = 10)
	public Date getCaseDate() {
		return this.caseDate;
	}

	public void setCaseDate(Date caseDate) {
		this.caseDate = caseDate;
	}

	@Column(name = "case_class", length = 100)
	public String getCaseClass() {
		return this.caseClass;
	}

	public void setCaseClass(String caseClass) {
		this.caseClass = caseClass;
	}

	@Column(name = "case_identify_times")
	public Integer getCaseIdentifyTimes() {
		return this.caseIdentifyTimes;
	}

	public void setCaseIdentifyTimes(Integer caseIdentifyTimes) {
		this.caseIdentifyTimes = caseIdentifyTimes;
	}

	@Column(name = "case_progress", length = 100)
	public String getCaseProgress() {
		return this.caseProgress;
	}

	public void setCaseProgress(String caseProgress) {
		this.caseProgress = caseProgress;
	}

	@Column(name = "case_remark", length = 3000)
	public String getCaseRemark() {
		return this.caseRemark;
	}

	public void setCaseRemark(String caseRemark) {
		this.caseRemark = caseRemark;
	}

	@Column(name = "status", length = 100)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "caseInfor")
	public Set<CaseCheckInfor> getCaseCheckInfors() {
		return this.caseCheckInfors;
	}

	public void setCaseCheckInfors(Set<CaseCheckInfor> caseCheckInfors) {
		this.caseCheckInfors = caseCheckInfors;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "caseInfor")
	public Set<CaseFile> getCaseFiles() {
		return this.caseFiles;
	}

	public void setCaseFiles(Set<CaseFile> caseFiles) {
		this.caseFiles = caseFiles;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "caseInfor")
	public Set<CaseIdentifiedInfo> getCaseIdentifiedInfos() {
		return this.caseIdentifiedInfos;
	}

	public void setCaseIdentifiedInfos(
			Set<CaseIdentifiedInfo> caseIdentifiedInfos) {
		this.caseIdentifiedInfos = caseIdentifiedInfos;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "caseInfor")
	public Set<CaseCharge> getCaseCharges() {
		return this.caseCharges;
	}

	public void setCaseCharges(Set<CaseCharge> caseCharges) {
		this.caseCharges = caseCharges;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "caseInfor")
	public Set<CaseInternalStatistics> getCaseInternalStatisticses() {
		return this.caseInternalStatisticses;
	}

	public void setCaseInternalStatisticses(
			Set<CaseInternalStatistics> caseInternalStatisticses) {
		this.caseInternalStatisticses = caseInternalStatisticses;
	}

}