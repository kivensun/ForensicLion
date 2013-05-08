package cn.sunn.forensiclion.service.impl;

import java.util.Calendar;
import java.util.Date;

import cn.sunn.forensiclion.dao.ICaseInforDao;
import cn.sunn.forensiclion.dao.impl.CaseInforDAOHibernate;
import cn.sunn.forensiclion.domain.CaseInfor;
import cn.sunn.forensiclion.service.ICaseInforManager;

public class CaseInforManagerImpl implements ICaseInforManager {

	private ICaseInforDao caseinfordao;
	
	public void setCaseinfordao(ICaseInforDao caseinfordao) {
		this.caseinfordao = caseinfordao;
	}

   private String findCaseID(){
	   String now = caseinfordao.findMxCaseid();
	   Calendar cal = Calendar.getInstance();
	   int nowYear =  cal.get(Calendar.YEAR);
	   if (now == null){
		   return  Integer.toString(nowYear) + "001";
	   }
	   int year = Integer.parseInt(now.substring(0, 4));
	   int num =Integer.parseInt(now.substring(4));
	   if (nowYear == year){
		   num = num + 1;
		   String num_str = Integer.toString(num);
		   if (num_str.length() < 3){
			   for (int i =num_str.length(); i < 3 ; i++){
				   num_str = "0" + num_str;
			   }
		   }
		   return nowYear + num_str;
	   }else{
		   return  Integer.toString(nowYear) + "001";
	   }
   }
	public int saveCase(CaseInfor caseinfor)  {
		// TODO Auto-generated method stub
		try{
			caseinfor.setCaseId(findCaseID());
			caseinfordao.save(caseinfor);
			return SUCCESS;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return ERROR;
		}
		
	}

}
