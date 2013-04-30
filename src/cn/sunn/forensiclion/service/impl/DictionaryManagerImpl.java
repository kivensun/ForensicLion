package cn.sunn.forensiclion.service.impl;

import java.util.List;

import javax.validation.OverridesAttribute;

import cn.sunn.forensiclion.dao.IDictionaryDAO;
import cn.sunn.forensiclion.domain.Dictionary;
import cn.sunn.forensiclion.service.IDictionaryManager;

public class DictionaryManagerImpl implements IDictionaryManager {

	private IDictionaryDAO dictionarydao;

	public void setDictionarydao(IDictionaryDAO dictionarydao) {
		this.dictionarydao = dictionarydao;
	}

	public int addDictionary(Dictionary dic) {
		// TODO Auto-generated method stub
		dictionarydao.save(dic);
		return 0;
	}

	public int delDictionary(Dictionary dic) {
		// TODO Auto-generated method stub
		dictionarydao.delete(dic);
		return 0;
	}

	public int editDictionary(Dictionary dic) {
		// TODO Auto-generated method stub
		dictionarydao.update(dic);
		return 0;
	}

	private String listDictionaryChilds(List<Dictionary> dictionarys,
			Dictionary parent) {
		String result = "";
		for (int i = 0; i < dictionarys.size(); i++) {
			Dictionary now = dictionarys.get(i);
			if (now.getParentid() == parent.getId()) {
				if (result == "") {
					result = ",\"children\":[";
					result += "{\"id\":\"" + now.getId() + "\",";
					result += "\"text\":\"" + now.getName() + "\",";
					result += "\"code\":\"" + now.getCode() + "\",";
					result += "\"content\":\"" + now.getContent() + "\",";
					result += "\"remark\":\"" + now.getRemark() + "\",";
					result += "\"state\": \"open\"";
					result += listDictionaryChilds(dictionarys, now) + "}";
				} else {
					result += ",{\"id\":\"" + now.getId() + "\",";
					result += "\"text\":\"" + now.getName() + "\",";
					result += "\"code\":\"" + now.getCode() + "\",";
					result += "\"content\":\"" + now.getContent() + "\",";
					result += "\"remark\":\"" + now.getRemark() + "\",";
					result += "\"state\": \"open\"";
					result += listDictionaryChilds(dictionarys, now) + "}";
				}

			}

		}
		if (result != "")
			result += "]";
		return result;

	}

	public String getDictionaryTree(Long id) {
		// TODO Auto-generated method stub
		String result = "[";
		List<Dictionary> dictionarys = dictionarydao.loadAll();
		for (int i = 0; i < dictionarys.size(); i++) {
			Dictionary now = dictionarys.get(i);
			if (now.getParentid() == id) {
				if (result == "[") {
					result += "{\"id\":\"" + now.getId() + "\",";
					result += "\"text\":\"" + now.getName() + "\",";
					result += "\"code\":\"" + now.getCode() + "\",";
					result += "\"content\":\"" + now.getContent() + "\",";
					result += "\"remark\":\"" + now.getRemark() + "\",";
					result += "\"state\": \"open\"";
					result += listDictionaryChilds(dictionarys, now) + "}";
				} else {
					result += ",{\"id\":\"" + now.getId() + "\",";
					result += "\"text\":\"" + now.getName() + "\",";
					result += "\"code\":\"" + now.getCode() + "\",";
					result += "\"content\":\"" + now.getContent() + "\",";
					result += "\"remark\":\"" + now.getRemark() + "\",";
					result += "\"state\": \"open\"";
					result += listDictionaryChilds(dictionarys, now) + "}";
				}
			}
		}
		result += "]";
		return result;
	}

	public Dictionary findDictionaryById(Long id) {
		// TODO Auto-generated method stub
		return dictionarydao.get(id);
	}

	public Dictionary findDictionaryByName(String name) {
		// TODO Auto-generated method stub
		return dictionarydao.listDictionary(name);
	}

	public int addorupdateDictionary(Dictionary dic) {
		// TODO Auto-generated method stub
		dictionarydao.saveOrUpdate(dic);
		return 0;
	}

	public int delDictionaryByKey(Long id) {
		// TODO Auto-generated method stub
		dictionarydao.deleteByKey(id);
		return 0;
	}

}
