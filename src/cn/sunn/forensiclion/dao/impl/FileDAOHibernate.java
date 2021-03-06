package cn.sunn.forensiclion.dao.impl;

import java.util.List;

import cn.sunn.forensiclion.dao.IFileDAO;
import cn.sunn.forensiclion.domain.Mfile;

public class FileDAOHibernate extends GenericHibernateDao<Mfile, Long>
		implements IFileDAO {

	
	public List listDoctempletes() {
		// TODO Auto-generated method stub
		return getHibernateTemplate()
				.find("select f.id,f.filename,f.datetime from Mfile f where f.class_ = ? order by f.datetime",
						"doctemplete");
	}

	
	public List listCasepics() {
		// TODO Auto-generated method stub
		return getHibernateTemplate()
				.find("select f.id,f.filename,f.datetime from Mfile f where f.class_ = ? order by f.datetime",
						"casepic");
	}

	
	public List listCasedocs() {
		// TODO Auto-generated method stub
		return getHibernateTemplate()
				.find("select f.id,f.filename,f.datetime from Mfile f where f.class_ = ? order by f.datetime",
						"casedoc");

	}

}
