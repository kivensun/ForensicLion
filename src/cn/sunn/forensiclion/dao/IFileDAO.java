package cn.sunn.forensiclion.dao;

import java.util.List;

import cn.sunn.forensiclion.domain.Mfile;


public interface IFileDAO extends GenericDao<Mfile, Long> {
	public List listDoctempletes();
	
	
	public List listCasepics();
	

	
	public List listCasedocs();
	


}
