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
 * CaseIdentifiedInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "case_identified_info", catalog = "ForensicLion")
public class CaseIdentifiedInfo implements java.io.Serializable {

	// Fields

	private long id;
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
	public CaseIdentifiedInfo( String name, String sex,
			String idcard, String education, String nation, String address,
			String remark) {
	
		this.name = name;
		this.sex = sex;
		this.idcard = idcard;
		this.education = education;
		this.nation = nation;
		this.address = address;
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
	
	@Column(name = "name", length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "sex", length = 100)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "idcard", length = 20)
	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	@Column(name = "education", length = 100)
	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	@Column(name = "nation", length = 100)
	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	@Column(name = "address", length = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "remark", length = 100)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}