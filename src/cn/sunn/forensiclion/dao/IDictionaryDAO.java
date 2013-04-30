package cn.sunn.forensiclion.dao;

import cn.sunn.forensiclion.domain.Dictionary;

public interface IDictionaryDAO extends GenericDao<Dictionary, Long> {
	
	/**
	 * 根据名字获得Dictionary
	 * @param name
	 * @return Dictionary实例
	 */
	Dictionary listDictionary(String name);

}
