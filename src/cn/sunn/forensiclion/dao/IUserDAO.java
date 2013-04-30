package cn.sunn.forensiclion.dao;

import java.util.List;
import java.util.Set;

import cn.sunn.forensiclion.domain.Dictionary;
import cn.sunn.forensiclion.domain.User;

/**
 * 
 * @author sundw kivensun@gmail.com
 * @version 0.0.1
 */

public interface IUserDAO extends GenericDao<User, Long> {
	
	/**
	 * 根据用户名和密码返回用户
	 * @param user
	 * @return 
	 */
	List<User> findByNameAndPass(User user);
	
	/**
	 * 根据用户名返回用户
	 * @param name
	 * @return
	 */
	List<User> findByLoginName(User user);
	
	/**
	 * 根据用户姓名返回用户
	 * @param user
	 * @return
	 */
	List<User> findByName(User user);
	
	/**
	 * 根据用户返回其拥有的功能(当登录名存在时则按登录名查,如没有则按用户ID查)
	 * @param user
	 * @return
	 */
	Set<Dictionary> getUserFunction(User user);
	
	
	
	
	
	
}
