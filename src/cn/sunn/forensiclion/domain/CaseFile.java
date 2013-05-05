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
 * CaseFile entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "case_file", catalog = "ForensicLion")
public class CaseFile implements java.io.Serializable {

	// Fields

	private long id;
	private CaseInfor caseInfor;
	private Mfile file;

	// Constructors

	/** default constructor */
	public CaseFile() {
	}

	/** full constructor */
	public CaseFile(CaseInfor caseInfor, Mfile file) {
		this.caseInfor = caseInfor;
		this.file = file;
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
	@JoinColumn(name = "case_id", nullable = false)
	public CaseInfor getCaseInfor() {
		return this.caseInfor;
	}

	public void setCaseInfor(CaseInfor caseInfor) {
		this.caseInfor = caseInfor;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "file_id", nullable = false)
	public Mfile getFile() {
		return this.file;
	}

	public void setFile(Mfile file) {
		this.file = file;
	}

}