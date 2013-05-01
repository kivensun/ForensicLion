package cn.sunn.forensiclion.service.impl;

import cn.sunn.forensiclion.dao.impl.CaseInforDAOHibernate;
import cn.sunn.forensiclion.domain.CaseInfor;
import cn.sunn.forensiclion.service.ICaseInforManager;

public class CaseInforManagerImpl implements ICaseInforManager {

	private CaseInforDAOHibernate caseinfordao;
	
	
	public CaseInforDAOHibernate getCaseinfordao() {
		return caseinfordao;
	}


	public void setCaseinfordao(CaseInforDAOHibernate caseinfordao) {
		this.caseinfordao = caseinfordao;
	}


	public int saveCase(CaseInfor caseinfor)  {
		// TODO Auto-generated method stub
		try{
			caseinfordao.save(caseinfor);
			return SUCCESS;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return ERROR;
		}
		
	}

}
