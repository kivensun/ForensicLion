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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "ForensicLion")
public class User implements java.io.Serializable {

	// Fields

	private long id;
	private String loginname;
	private String passwd;
	private String name;
	private String major;
	private String jobtitle;
	private String practiceNum;
	private String remark;
	private Date registdate;
	private Date logindate;
	private Integer status;
	private Set<Dictionary> dictionaries = new HashSet<Dictionary>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String loginname, String passwd, String name, String major,
			String jobtitle, String practiceNum, String remark,
			Date registdate, Date logindate, Integer status,
			Set<Dictionary> dictionaries) {
		this.loginname = loginname;
		this.passwd = passwd;
		this.name = name;
		this.major = major;
		this.jobtitle = jobtitle;
		this.practiceNum = practiceNum;
		this.remark = remark;
		this.registdate = registdate;
		this.logindate = logindate;
		this.status = status;
		this.dictionaries = dictionaries;
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

	@Column(name = "loginname", length = 10)
	public String getLoginname() {
		return this.loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	@Column(name = "passwd", length = 20)
	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Column(name = "name", length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "major", length = 60)
	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Column(name = "jobtitle", length = 60)
	public String getJobtitle() {
		return this.jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	@Column(name = "practice_num", length = 30)
	public String getPracticeNum() {
		return this.practiceNum;
	}

	public void setPracticeNum(String practiceNum) {
		this.practiceNum = practiceNum;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "registdate", length = 19)
	public Date getRegistdate() {
		return this.registdate;
	}

	public void setRegistdate(Date registdate) {
		this.registdate = registdate;
	}

	@Column(name = "logindate", length = 19)
	public Date getLogindate() {
		return this.logindate;
	}

	public void setLogindate(Date logindate) {
		this.logindate = logindate;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name = "user_function", catalog = "ForensicLion", joinColumns = {@JoinColumn(name = "user_id", nullable = false, updatable = false)}, inverseJoinColumns = {@JoinColumn(name = "function_id", nullable = false, updatable = false)})
	public Set<Dictionary> getDictionaries() {
		return this.dictionaries;
	}

	public void setDictionaries(Set<Dictionary> dictionaries) {
		this.dictionaries = dictionaries;
	}

}