package eTrade.business.auth;

import eTrade.entities.concretes.User;

public class GoogleAuthorizationAdapter implements Authorization{
	GoogleAuthorizationManager googleAuthManager;

	public GoogleAuthorizationAdapter() {

		googleAuthManager = new GoogleAuthorizationManager();

	}

	@Override
	public void register(User user) {

		this.googleAuthManager.register(user.getEmail(), user.getPassword());

	}

	@Override
	public void login(String email, String password) {

		this.googleAuthManager.login(email, password);
		
	}
}
