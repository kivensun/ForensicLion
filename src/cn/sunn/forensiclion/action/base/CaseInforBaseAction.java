package cn.sunn.forensiclion.action.base;

import cn.sunn.forensiclion.service.ICaseInforManager;

public class CaseInforBaseAction extends PageBaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5014338923238032671L;
	protected ICaseInforManager caseinforMgr;
	public void setCaseinforMgr(ICaseInforManager caseinformgr) {
		this.caseinforMgr = caseinformgr;
	}
	
	

}
