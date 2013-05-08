package cn.sunn.forensiclion.dao.impl;

import java.util.List;

import cn.sunn.forensiclion.dao.ICaseInforDao;
import cn.sunn.forensiclion.domain.CaseInfor;

public class CaseInforDAOHibernate extends GenericHibernateDao<CaseInfor, Long>
		implements ICaseInforDao {

	public String findMxCaseid() {
		// TODO Auto-generated method stub
		List max =  getHibernateTemplate().find(
				"select max(c.caseId) From CaseInfor c ");
		if (max.get(0) != null)
			return max.get(0).toString();
		else
			return null;
	}

}
