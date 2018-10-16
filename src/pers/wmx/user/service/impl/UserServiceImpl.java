package pers.wmx.user.service.impl;

import pers.wmx.user.dao.UserDao;
import pers.wmx.user.domain.User;
import pers.wmx.user.service.UserService;
import pers.wmx.utils.SendJMail;

public class UserServiceImpl implements UserService{
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void register(User user) {
		userDao.add(user);
		
		String emailMsg="ע��ɹ�����<a href='http://localhost:8080/HostGameStoreCenter/UserAction_active.action?activeCode="+user.getActiveCode()+"'>����</a> ";
		SendJMail.sendMail(user.getEmail(), emailMsg);
		
		
	}

	@Override
	public User findUserByName(String username) {
		
		return userDao.findUser(username);
	}

	@Override
	public void active(String activeCode) {
		User findUser=userDao.findUserByActiveCode(activeCode);  //���ݼ������ҵ��û�
		
		
		if(findUser!=null){
			System.out.println("id"+findUser.getId());
			userDao.active(findUser.getId());
		}
		
	}

	
	public User findUser(String username, String password) {
		
		return userDao.selectUser(username,password);
	}
	
	
}
