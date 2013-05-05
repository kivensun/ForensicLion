package cn.sunn.forensiclion.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Mfile entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "mfile", catalog = "ForensicLion")
public class Mfile implements java.io.Serializable {

	// Fields

	private long id;
	private String class_;
	private String filename;
	private byte[] data;
	private Date datetime;

	// Constructors

	/** default constructor */
	public Mfile() {
	}

	/** full constructor */
	public Mfile(String class_, String filename, byte[] data, Date datetime) {
		this.class_ = class_;
		this.filename = filename;
		this.data = data;
		this.datetime = datetime;
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

	@Column(name = "class",length=360)
	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	@Column(name = "filename" ,length=360)
	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Column(name = "data")
	public byte[] getData() {
		return this.data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	@Column(name = "datetime", length = 19)
	public Date getDatetime() {
		return this.datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

}