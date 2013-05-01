package cn.sunn.forensiclion.action;

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
	 * 
	 */
	private static final long serialVersionUID = -168703567335144678L;

	private CaseInfor caseinfor = new CaseInfor();
	private Set<CaseCharge> casecharges = new HashSet<CaseCharge>();
	private Set<CaseIdentifiedInfo> caseidentifiedinfos = new HashSet<CaseIdentifiedInfo>();
	private Set<CaseCheckInfor> casecheckinfors = new HashSet<CaseCheckInfor>();
	private CaseInternalStatistics caseinternalstatistics = new CaseInternalStatistics();
	
	
	public CaseInfor getCaseinfor() {
		return caseinfor;
	}


	public void setCaseinfor(CaseInfor caseinfor) {
		this.caseinfor = caseinfor;
	}


	public Set<CaseCharge> getCasecharges() {
		return casecharges;
	}


	public void setCasecharges(Set<CaseCharge> casecharges) {
		this.casecharges = casecharges;
	}


	public Set<CaseIdentifiedInfo> getCaseidentifiedinfos() {
		return caseidentifiedinfos;
	}


	public void setCaseidentifiedinfos(Set<CaseIdentifiedInfo> caseidentifiedinfos) {
		this.caseidentifiedinfos = caseidentifiedinfos;
	}


	public Set<CaseCheckInfor> getCasecheckinfors() {
		return casecheckinfors;
	}


	public void setCasecheckinfors(Set<CaseCheckInfor> casecheckinfors) {
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
			if (caseinforMgr.saveCase(caseinfor) == 1){
				this.getResult().put("result", "SUCCESS");
			}else{
				this.getResult().put("result", "ERROR");
			}			
		}else{
			this.getResult().put("result", "ERROR");
		}
		return SUCCESS;
	}
}
