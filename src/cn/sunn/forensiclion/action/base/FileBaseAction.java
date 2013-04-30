package cn.sunn.forensiclion.action.base;

import cn.sunn.forensiclion.service.IFileManager;

import com.opensymphony.xwork2.ActionSupport;

public class FileBaseAction extends PageBaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6370919362901720495L;
	protected IFileManager filemgr;

	public void setFilemgr(IFileManager filemgr) {
		this.filemgr = filemgr;
	}
	
	

}
