package eTrade.business.abstracts;

import java.util.ArrayList;

import eTrade.entities.concretes.User;

public interface UserService {
	boolean add(User user);

	ArrayList<User> getAll();

	User getByEmail(String email);
}
