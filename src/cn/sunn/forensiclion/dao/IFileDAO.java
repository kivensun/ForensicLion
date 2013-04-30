package cn.sunn.forensiclion.dao;

import java.util.List;

import cn.sunn.forensiclion.domain.MFile;

public interface IFileDAO extends GenericDao<MFile, Long> {
	public List listDoctempletes();
	
	
	public List listCasepics();
	

	
	public List listCasedocs();
	


}
