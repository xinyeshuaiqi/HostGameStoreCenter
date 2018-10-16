package pers.wmx.user.dao;

import pers.wmx.user.domain.User;

public interface UserDao {

	void add(User user);

	User findUser(String username);

	User findUserByActiveCode(String activeCode);

	void active(int id);

	User selectUser(String username, String password);

}
