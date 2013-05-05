package cn.sunn.forensiclion.action;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

import cn.sunn.forensiclion.action.base.CaseInforBaseAction;
import cn.sunn.forensiclion.domain.CaseCharge;
import cn.sunn.forensiclion.domain.CaseCheckInfor;
import cn.sunn.forensiclion.domain.CaseIdentifiedInfo;
import cn.sunn.forensiclion.domain.CaseInfor;
import cn.sunn.forensiclion.domain.CaseInternalStatistics;

public class CaseInforAction extends CaseInforBaseAction {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(CaseInforAction.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = -168703567335144678L;

	private CaseInfor caseinfor = new CaseInfor();
	private List<CaseCharge> casecharges = new ArrayList<CaseCharge>();
	private List<CaseIdentifiedInfo> caseidentifiedinfos = new ArrayList<CaseIdentifiedInfo>();
	private List<CaseCheckInfor> casecheckinfors = new ArrayList<CaseCheckInfor>();
	private CaseInternalStatistics caseinternalstatistics = new CaseInternalStatistics();
	
	
	public CaseInfor getCaseinfor() {
		return caseinfor;
	}


	public void setCaseinfor(CaseInfor caseinfor) {
		this.caseinfor = caseinfor;
	}


	

	public List<CaseCharge> getCasecharges() {
	return casecharges;
	}


	public void setCasecharges(List<CaseCharge> casecharges) {
		this.casecharges = casecharges;
	}


	public List<CaseIdentifiedInfo> getCaseidentifiedinfos() {
		return caseidentifiedinfos;
	}


	public void setCaseidentifiedinfos(List<CaseIdentifiedInfo> caseidentifiedinfos) {
		this.caseidentifiedinfos = caseidentifiedinfos;
	}


	public List<CaseCheckInfor> getCasecheckinfors() {
		return casecheckinfors;
	}


	public void setCasecheckinfors(List<CaseCheckInfor> casecheckinfors) {
		this.casecheckinfors = casecheckinfors;
	}


	public CaseInternalStatistics getCaseinternalstatistics() {
		return caseinternalstatistics;
	}


	public void setCaseinternalstatistics(
			CaseInternalStatistics caseinternalstatistics) {
		this.caseinternalstatistics = caseinternalstatistics;
	}
	public String newcase()throws Exception{
	if (caseinfor != null){
		caseinfor.setCaseId("200404");
		caseinfor.setCaseCharges(new HashSet( casecharges));
			if (caseinformgr.saveCase(caseinfor) == 1){
				this.getResult().put("result", "SUCCESS");
				logger.info("SUCCESS");
			}else{
				this.getResult().put("result", "ERROR");
				logger.info("ERROR");
			}			
		}else{
			this.getResult().put("result", "ERROR");
		}
		return SUCCESS;
	}
}
