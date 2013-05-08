package cn.sunn.forensiclion.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CaseCheckInfor entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "case_check_infor", catalog = "ForensicLion")
public class CaseCheckInfor implements java.io.Serializable {

	// Fields

	private long id;
	private String checkName;
	private String checkClass;
	private Integer num;
	private String unit;
	private Date getDate;
	private String barcode;
	private String remark;

	// Constructors

	/** default constructor */
	public CaseCheckInfor() {
	}

	/** full constructor */
	public CaseCheckInfor(String checkName,
			String checkClass, Integer num, String unit, Date getDate,
			String barcode, String remark) {
		this.checkName = checkName;
		this.checkClass = checkClass;
		this.num = num;
		this.unit = unit;
		this.getDate = getDate;
		this.barcode = barcode;
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

	@Column(name = "check_name", length = 360)
	public String getCheckName() {
		return this.checkName;
	}

	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}

	@Column(name = "check_class", length = 360)
	public String getCheckClass() {
		return this.checkClass;
	}

	public void setCheckClass(String checkClass) {
		this.checkClass = checkClass;
	}

	@Column(name = "num")
	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	@Column(name = "unit", length = 20)
	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "get_date", length = 10)
	public Date getGetDate() {
		return this.getDate;
	}

	public void setGetDate(Date getDate) {
		this.getDate = getDate;
	}

	@Column(name = "barcode", length = 300)
	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	@Column(name = "remark", length = 300)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}