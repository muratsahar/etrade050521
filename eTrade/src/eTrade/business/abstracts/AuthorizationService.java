package eTrade.business.abstracts;

import eTrade.entities.concretes.User;

public interface AuthorizationService {
	void register(User user);

	void login(String email, String password);
}
