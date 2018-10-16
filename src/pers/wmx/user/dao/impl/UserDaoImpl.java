package pers.wmx.user.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pers.wmx.user.dao.UserDao;
import pers.wmx.user.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	@Override
	public void add(User user) {
		this.getHibernateTemplate().save(user);
		
	}

	@Override
	public User findUser(String username) {
		
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where username=?", username);
		if(list.size()==1){
			return list.get(0);
		}
		return null;
	}

	@Override
	public User findUserByActiveCode(String activeCode) {
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where activeCode=?", activeCode);
		if(list.size()==1){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void active(int id) {
		User user = this.getHibernateTemplate().get(User.class, id);
		System.out.println("userState"+user.getState());
		user.setState(1);
		System.out.println("userState"+user.getState());
		this.getHibernateTemplate().update(user);
	}

	@Override
	public User selectUser(String username, String password) {
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where username=? and password=?", username,password);
		if(list.size()==1){
			return list.get(0);
		}
		return null;
	}
	
}
