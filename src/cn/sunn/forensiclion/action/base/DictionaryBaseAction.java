package cn.sunn.forensiclion.action.base;

import com.opensymphony.xwork2.ActionSupport;

import cn.sunn.forensiclion.service.IDictionaryManager;

public class DictionaryBaseAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1771013472078782530L;
	protected IDictionaryManager dictmgr;

	public void setDictmgr(IDictionaryManager dictmgr) {
		this.dictmgr = dictmgr;
	}
	
	

}
