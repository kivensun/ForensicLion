package cn.sunn.forensiclion.service;

import cn.sunn.forensiclion.domain.Dictionary;

public interface IDictionaryManager {
	public static final int FAIT = 0;
	public static final int SUCCESS = 1;
	/**
	 * 增加Dictionary
	 * @param fun
	 * @return
	 */
    public int addDictionary(Dictionary dic);
    /**
     * 删除Dictionary
     * @param fun
     * @return
     */
    int delDictionary(Dictionary dic);
    /**
     * 删除Dictionary
     * @param fun
     * @return
     */
    int delDictionaryByKey(Long id);
    
    /**
     * 更新Dictionary
     * @param fun
     * @return
     */
    int editDictionary(Dictionary dic);
    /**
     * 添加或者更新Dictionary
     * @param fun
     * @return
     */
    int addorupdateDictionary(Dictionary dic);
    
    /**
     * 获得整个Dictionary树
     * @return
     */
    public String getDictionaryTree(Long id);
    /**
     * 根据ID获得Dictionary
     * @param id
     * @return
     */
    Dictionary findDictionaryById(Long id);
    /**
     * 根据名字获得Dictionary实例
     * @param name
     * @return
     */
    Dictionary findDictionaryByName(String name);
}