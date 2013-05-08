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
 * CaseCharge entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "case_charge", catalog = "ForensicLion")
public class CaseCharge implements java.io.Serializable {

	// Fields

	private long chargeId;
	private String chargeClass;
	private String chargeStandardType;
	private long chargeAmount;
	private String chargeRemark;

	// Constructors

	/** default constructor */
	public CaseCharge() {
	}

	/** full constructor */
	public CaseCharge(String chargeClass,
			String chargeStandardType, long chargeAmount, String chargeRemark) {	
		this.chargeClass = chargeClass;
		this.chargeStandardType = chargeStandardType;
		this.chargeAmount = chargeAmount;
		this.chargeRemark = chargeRemark;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "charge_id", unique = true, nullable = false)
	public long getChargeId() {
		return this.chargeId;
	}

	public void setChargeId(long chargeId) {
		this.chargeId = chargeId;
	}

	@Column(name = "charge_class", length = 100)
	public String getChargeClass() {
		return this.chargeClass;
	}

	public void setChargeClass(String chargeClass) {
		this.chargeClass = chargeClass;
	}

	@Column(name = "charge_standard_type", length = 100)
	public String getChargeStandardType() {
		return this.chargeStandardType;
	}

	public void setChargeStandardType(String chargeStandardType) {
		this.chargeStandardType = chargeStandardType;
	}

	@Column(name = "charge_amount", precision = 10, scale = 0)
	public long getChargeAmount() {
		return this.chargeAmount;
	}

	public void setChargeAmount(long chargeAmount) {
		this.chargeAmount = chargeAmount;
	}

	@Column(name = "charge_remark", length = 300)
	public String getChargeRemark() {
		return this.chargeRemark;
	}

	public void setChargeRemark(String chargeRemark) {
		this.chargeRemark = chargeRemark;
	}

}