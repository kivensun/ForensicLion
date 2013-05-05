package cn.sunn.forensiclion.action;

import java.util.Iterator;
import java.util.Set;

import cn.sunn.forensiclion.domain.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RightAction extends ActionSupport {
	
	//对用户是否有系统管理权限进行判断
	public String systemmgr() throws Exception
	{
		ActionContext ctx = ActionContext.getContext();
		System.out.println((User)ctx.getSession().get("user"));
		Set<Dictionary> functions = ((User)ctx.getSession().get("user")).getDictionaries();
		Iterator it = functions.iterator();
		while (it.hasNext())
		{
			Dictionary fuc = (Dictionary)it.next();
		    if (fuc.getCode().equals( "systemmanage"))
		    {
		    	return SUCCESS;
		    }
		}
		return ERROR;
	}
	
	//对用户是否有案件管理权限进行判断
	public String casemgr() throws Exception
	{
		ActionContext ctx = ActionContext.getContext();
		System.out.println((User)ctx.getSession().get("user"));
		Set<Dictionary> functions = ((User)ctx.getSession().get("user")).getDictionaries();
		Iterator it = functions.iterator();
		while (it.hasNext())
		{
			Dictionary fuc = (Dictionary)it.next();
		    if (fuc.getCode().equals( "casemanage"))
		    {
		    	return SUCCESS;
		    }
		}
		return ERROR;
	}
	
}
