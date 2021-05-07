package eTrade.dataAccess.concretes;

import java.util.ArrayList;

import eTrade.dataAccess.abstacts.UserDao;
import eTrade.entities.concretes.User;

public class InMemoryUserDao implements UserDao {
		ArrayList<User> users;

		public InMemoryUserDao() {
			this.users = new ArrayList<User>();
		}

		@Override
		public boolean add(User user) {
			return this.users.add(user);

		}

		@Override
		public ArrayList<User> getAll() {
			return this.users;
		}

		@Override
		public User get(String email) {
			for (User user : this.users) {
				if (user.getEmail() == email) {
					return user;
				}
			}
			return null;
		}
}
