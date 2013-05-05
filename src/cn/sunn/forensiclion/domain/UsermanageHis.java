package cn.sunn.forensiclion.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UsermanageHis entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "usermanageHis", catalog = "ForensicLion")
public class UsermanageHis implements java.io.Serializable {

	// Fields

	private long id;
	private Integer userId;
	private Date opdate;
	private String opip;
	private String opcd;
	private String content;

	// Constructors

	/** default constructor */
	public UsermanageHis() {
	}

	/** full constructor */
	public UsermanageHis(Integer userId, Date opdate, String opip, String opcd,
			String content) {
		this.userId = userId;
		this.opdate = opdate;
		this.opip = opip;
		this.opcd = opcd;
		this.content = content;
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

	@Column(name = "user_id", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "opdate", nullable = false, length = 19)
	public Date getOpdate() {
		return this.opdate;
	}

	public void setOpdate(Date opdate) {
		this.opdate = opdate;
	}

	@Column(name = "opip", nullable = false, length = 20)
	public String getOpip() {
		return this.opip;
	}

	public void setOpip(String opip) {
		this.opip = opip;
	}

	@Column(name = "opcd", nullable = false, length = 30)
	public String getOpcd() {
		return this.opcd;
	}

	public void setOpcd(String opcd) {
		this.opcd = opcd;
	}

	@Column(name = "content", nullable = false)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}