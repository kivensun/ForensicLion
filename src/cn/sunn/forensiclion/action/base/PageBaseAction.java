package cn.sunn.forensiclion.action.base;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class PageBaseAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3691210507073986297L;

	private String rows;// 每页显示的记录数

	private String page;// 当前第几页

	// json回传参数
	private Map<String, Object> result = new HashMap<String, Object>();

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

}
