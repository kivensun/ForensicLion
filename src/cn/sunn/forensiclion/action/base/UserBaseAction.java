package cn.sunn.forensiclion.action.base;

import cn.sunn.forensiclion.service.IUserManager;

public class UserBaseAction extends PageBaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7640747018547520505L;
	protected IUserManager userMgr;


	public void setUserMgr(IUserManager userMgr) {
		this.userMgr = userMgr;
	}	
	
}
