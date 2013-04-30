package cn.sunn.forensiclion.dao.impl;

import java.util.List;
import java.util.Set;

import cn.sunn.forensiclion.dao.IUserDAO;
import cn.sunn.forensiclion.domain.Dictionary;
import cn.sunn.forensiclion.domain.User;


@SuppressWarnings("unchecked")
public class UserDAOHibernate extends GenericHibernateDao<User, Long> implements
		IUserDAO {

	

	
	public UserDAOHibernate() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public List<User> findByNameAndPass(User user) {
		// TODO Auto-generated method stub
		return ((List<User>) getHibernateTemplate().find(
				"from User u where u.loginname = ? and u.passwd=?",
				user.getLoginname(), user.getPasswd()));
	}

	
	public List<User> findByLoginName(User user) {
		// TODO Auto-generated method stub
		return (List<User>) getHibernateTemplate().find(
				"from User u where u.loginname = ?", user.getLoginname());
	}

	
	public List<User> findByName(User user) {
		// TODO Auto-generated method stub
		return (List<User>) getHibernateTemplate().find(
				"from User u where u.name = ?", user.getName());
	}

	
	public Set<Dictionary> getUserFunction(User user) {
		// TODO Auto-generated method stub
		if (!user.getLoginname().isEmpty())
		{
			return ((User)(getHibernateTemplate().find(
					"from User u where u.loginname = ?", 
					user.getLoginname()).get(0)))
					.getMyfuns();
		}
		else
		{
			return(((User) (getHibernateTemplate().find(
					"from User u where u.id = ?", user.getId())).get(0))
					.getMyfuns());
		}
		

	}

}
