package cn.sunn.forensiclion.action;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.sunn.forensiclion.action.base.DictionaryBaseAction;
import cn.sunn.forensiclion.domain.Dictionary;

public class DictionaryAction extends DictionaryBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2128687128390406273L;
	private Long id;
	private Dictionary dict;
	private Map<String,Object> param = new HashMap();
	private Map<String,Object> result = new HashMap();
	public Map<String, Object> getParam() {
		return param;
	}
	public void setParam(Map<String, Object> param) {
		this.param = param;
	}
	public Map<String, Object> getResult() {
		return result;
	}
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Dictionary getDict() {
		return dict;
	}
	public void setDict(Dictionary dict) {
		this.dict = dict;
	}
	public void listDictionarys() throws Exception {	
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if (param.isEmpty()){
			System.out.println("Print All Dictionary");
			out.println(dictmgr.getDictionaryTree(-1l));
		}else{
		    String name = param.get("name").toString();
		    System.out.println("Print Dictionary Where Parent is " + name);
		    Dictionary dict = dictmgr.findDictionaryByName(name);
		    out.println(dictmgr.getDictionaryTree(dict.getId()));
		}
		out.flush();
		out.close();
	}
	public String listDictionary() throws Exception {
		if (id == null){
			result.put("error", "服务器数据没有赋值");
		}else{
			Dictionary dict =  dictmgr.findDictionaryById(id);
			result.put("node", dict);
		}
		return SUCCESS;
	}
	public String addorupdate() throws Exception {
		if (dict == null){
			result.put("error", "服务器数据没有赋值");
		}else{
			dictmgr.addorupdateDictionary(dict);
			result.put("node", dict);
		}
		return SUCCESS;
	}
	public String deldictionary() throws Exception {
		if (id == null){
			result.put("result", "服务器数据没有赋值");
		}else{
			dictmgr.delDictionaryByKey(id);
			result.put("result", "success");
		}
		return SUCCESS;
	}
}
