package cn.sunn.forensiclion.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import cn.sunn.forensiclion.action.base.UserBaseAction;
import cn.sunn.forensiclion.domain.User;

public class UserAction extends UserBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2500085904778056158L;
	// 封装请求参数
	private User user;
	// 验证码
	private String vercode;
	// 登陆后提示
	private String Tip;
	// json回传参数
	//private Map<String,Object> result = new HashMap<String, Object>();
	//id数据
	private Long id;
	//传入参数
    private Map<String,Object> param;
	//private String rows;// 每页显示的记录数

	//private String page;// 当前第几页
	

	public Map<String, Object> getParam() {
		return param;
	}

	public void setParam(Map<String, Object> param) {
		this.param = param;
	}

	public User getUser() {

		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getVercode() {
		return vercode;
	}

	public void setVercode(String vercode) {
		this.vercode = vercode;
	}

	public String getTip() {
		return Tip;
	}

	public void setTip(String tip) {
		Tip = tip;
	}

	//public Map<String, Object> getResult() {
	//	return result;
	//}

	//public void setResult(Map<String, Object> result) {
	//	this.result = result;
	//}

	//public String getRows() {
	//	return rows;
	//}

	//public void setRows(String rows) {
	//	this.rows = rows;
	//}

	//public String getPage() {
	//	return page;
	//}

	//public void setPage(String page) {
	//	this.page = page;
	//}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String Login() throws Exception {
		// 把验证码暂时取消掉
		// TODO Auto-generated method stub
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		// 获取HttpSession中的rand属性
		String ver2 = (String) ctx.getSession().get("rand");
		// if (vercode.equalsIgnoreCase(ver2))
		// {
		// 调用业务逻辑方法来处理登录请求
		int result = userMgr.validLogin(getUser());
		// 登录结果为普通员工
		if (result == userMgr.LOGIN_SUCCESS) {
			ctx.getSession().put("user", userMgr.getUser(getUser()));
			setTip("您已经成功登录系统");
			return SUCCESS;
		}
		// 用户名和密码不匹配
		else {
			setTip("用户名/密码不匹配");
			return ERROR;
		}
		// }
		// 验证码不匹配
		// else
		// {
		// setTip("验证码不匹配,请重新输入");
		// return ERROR;
		// }

	}

	@SuppressWarnings("unchecked")
	public String listUsers() throws Exception{
		System.out.println("----ListUser----");
		 //当前页  
        int intPage = Integer.parseInt((this.getPage() == null || this.getPage() == "0") ? "1":this.getPage());  
        //每页显示条数  
        int number = Integer.parseInt((this.getRows() == null || this.getRows() == "0") ? "20":this.getRows());  
        //每页的开始记录  第一页为1  第二页为number +1   
        int start = (intPage-1)*number;  
		List<User> users = userMgr.findByPage(start,number);//每页的数据，放入list 
        this.getResult().put("total", userMgr.findAll().size());
        this.getResult().put("rows", users);    
       
		return SUCCESS;		
	}
	
	public String listUser() throws Exception{
		this.getResult().put("user", userMgr.getUser(getId()));
		return SUCCESS;
	}

	public String editUser() throws Exception{
		System.out.println(getUser().getId());
		userMgr.updateUser(getUser());
		this.getResult().put("result", "SUCCESS");  
		return SUCCESS;
	}
	public String addUser() throws Exception{
		getUser().setPasswd("123456");
		userMgr.addUser(getUser());
		this.getResult().put("result", "SUCCESS");  
		return SUCCESS;
	}
	public String lockUser() throws Exception{
		User _user = userMgr.getUser(getId());
		_user.setStatus(0);
		userMgr.updateUser(_user);
		return SUCCESS;
	}
	public String unlockUser() throws Exception{
		User _user = userMgr.getUser(getId());
		_user.setStatus(1);
		userMgr.updateUser(_user);
		return SUCCESS;
	}
	
	public String checkParamExist() throws Exception{
		String[] popr = {param.get("param").toString()};
		String[] values = {param.get("value").toString()};
		if (userMgr.checkExist(popr, values) == 1)
			this.getResult().put("result", "true");
		else
			this.getResult().put("result", "false");
		return SUCCESS;
	}
	public String changePwd() throws Exception{
		ActionContext ctx = ActionContext.getContext();
		User nowuser = (User)ctx.getSession().get("user");
		String oldpwd =param.get("oldpwd").toString();
		String newpwd = param.get("newpwd").toString();
		if (oldpwd.equals(nowuser.getPasswd()))
		{
			nowuser.setPasswd(newpwd);
			userMgr.updateUser(nowuser);
			ctx.getSession().put("user", nowuser);
			this.getResult().put("result", "success");
		}else{
			this.getResult().put("result", "fail");
		}
		return SUCCESS;
	}
}



























