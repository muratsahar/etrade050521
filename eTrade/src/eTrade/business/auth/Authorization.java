package eTrade.business.auth;

import eTrade.entities.concretes.User;

public interface Authorization {
	void register(User user);

	void login(String email, String password);
}
