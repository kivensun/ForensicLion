package cn.sunn.forensiclion.domain;

/**
 * CaseFile entity. @author MyEclipse Persistence Tools
 */

public class CaseFile implements java.io.Serializable {

	// Fields

	private Long id;
	private Long caseId;
	private Long fileId;

	// Constructors

	/** default constructor */
	public CaseFile() {
	}

	/** full constructor */
	public CaseFile(Long caseId, Long fileId) {
		this.caseId = caseId;
		this.fileId = fileId;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCaseId() {
		return this.caseId;
	}

	public void setCaseId(Long caseId) {
		this.caseId = caseId;
	}

	public Long getFileId() {
		return this.fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

}