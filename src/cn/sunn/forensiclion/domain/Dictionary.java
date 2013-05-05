package cn.sunn.forensiclion.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Dictionary entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "dictionary", catalog = "ForensicLion")
public class Dictionary implements java.io.Serializable {

	// Fields

	private long id;
	private long parentid;
	private String name;
	private String code;
	private String content;
	private String remark;

	// Constructors

	/** default constructor */
	public Dictionary() {
	}

	/** minimal constructor */
	public Dictionary(long parentid, String name, String code) {
		this.parentid = parentid;
		this.name = name;
		this.code = code;
	}

	/** full constructor */
	public Dictionary(long parentid, String name, String code, String content,
			String remark) {
		this.parentid = parentid;
		this.name = name;
		this.code = code;
		this.content = content;
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

	@Column(name = "parentid", nullable = false)
	public long getParentid() {
		return this.parentid;
	}

	public void setParentid(long parentid) {
		this.parentid = parentid;
	}

	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "code", nullable = false, length = 100)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "content", length = 100)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	

}