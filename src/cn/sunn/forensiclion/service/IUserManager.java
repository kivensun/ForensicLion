package cn.sunn.forensiclion.service;

import java.util.List;
import cn.sunn.forensiclion.domain.*;

public interface IUserManager {
	
	public static final int LOGIN_FAIT = 0;
	public static final int LOGIN_SUCCESS = 1;
	/**
	 * 用户登录
	 * @param user
	 * @return 1登录成功 0 登录失败
	 */
	int validLogin(User user);
	
	/**
	 * 增加用户
	 * @param user
	 * @return 1增加成功 0增加失败
	 */
	int addUser(User user);
	/**
	 * 更新用户
	 * @param user
	 * @return 1增加成功 0增加失败
	 */
	int updateUser(User user);
	
	/**
	 * 删除用户
	 * @param user
	 * @return 1删除成功 0删除失败
	 */
	int delUser(long userid);
	
	/**
	 * 获得当前用户的所有信息
	 * @param user
	 * @return
	 */
	User getUser(User user);
	
	
	/**
	 * 获得当前用户的所有信息
	 * @param id
	 * @return
	 */
	User getUser(Long id);
	
	/**
	 * 获得所有用户数据
	 * @return
	 */
	List<User> findAll();

	/**
	 * 获得分页数据
	 * @param offset 第一条记录索引
	 * @param pageSize 一页多少大
	 * @return
	 */
	List findByPage(final int offset, final int pageSize);
	
	/**
	 * 查看登录名是否存在
	 * @param popr 属性名   value值
	 * @return
	 */
	int checkExist(String[] popr, Object[] value);
}
