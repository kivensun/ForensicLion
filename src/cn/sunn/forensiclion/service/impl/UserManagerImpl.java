package cn.sunn.forensiclion.service.impl;

import java.util.Date;
import java.util.List;

import cn.sunn.forensiclion.dao.IUserDAO;
import cn.sunn.forensiclion.domain.User;
import cn.sunn.forensiclion.service.IUserManager;

public class UserManagerImpl implements IUserManager {

	private IUserDAO userdao;

	public IUserDAO getUserdao() {
		return userdao;
	}

	public void setUserdao(IUserDAO userdao) {
		this.userdao = userdao;
	}

	public int validLogin(User user) {
		// TODO Auto-generated method stub
		if (userdao.findByNameAndPass(user).size() > 0) {
			User us = userdao.findByNameAndPass(user).get(0);
			us.setLogindate(new Date());
			userdao.saveOrUpdate(us);
			return LOGIN_SUCCESS;
		} else {
			return LOGIN_FAIT;
		}
	}

	public int addUser(User user) {
		// TODO Auto-generated method stub
		userdao.save(user);
		return 1;
	}

	public int delUser(long userid) {
		// TODO Auto-generated method stub
		userdao.deleteByKey(userid);
		return 1;
	}

	public User getUser(User user) {
		// TODO Auto-generated method stub
		if (userdao.findByLoginName(user).size() > 0)
			return userdao.findByLoginName(user).get(0);
		else
			return null;
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userdao.loadAll();
	}

	public List findByPage(int offset, int pageSize) {
		// TODO Auto-generated method stub
		return userdao.findByPage(" from User ", offset, pageSize);
	}

	public User getUser(Long id) {
		// TODO Auto-generated method stub
		return userdao.get(id);
	}

	public int updateUser(User user) {
		// TODO Auto-generated method stub
		userdao.update(user);
		return 1;
	}

	public int checkExist(String[] paramNames, Object[] values) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<User> users = userdao.findByNamedParam("from User", paramNames,
				values);
		if (users.size() > 0)
			return 1;
		else
			return 0;
	}

}
