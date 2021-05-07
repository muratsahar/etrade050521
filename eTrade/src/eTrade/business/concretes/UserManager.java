package eTrade.business.concretes;

import java.util.ArrayList;

import eTrade.business.abstracts.UserService;
import eTrade.dataAccess.abstacts.UserDao;
import eTrade.entities.concretes.User;

public class UserManager implements UserService{
	
	UserDao userDao;

	public UserManager(UserDao userDao) {

		this.userDao = userDao;

	}
	
	@Override
	public boolean add(User user) {
		return this.userDao.add(user);
	}

	@Override
	public ArrayList<User> getAll() {
		return this.userDao.getAll();
	}

	@Override
	public User getByEmail(String email) {
		return this.userDao.get(email);
	}

}
