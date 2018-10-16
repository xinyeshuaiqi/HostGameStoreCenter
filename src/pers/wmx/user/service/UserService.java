package pers.wmx.user.service;

import pers.wmx.user.domain.User;

public interface UserService {

	void register(User user);

	User findUserByName(String username);

	void active(String activeCode);

	User findUser(String username, String password);

}
