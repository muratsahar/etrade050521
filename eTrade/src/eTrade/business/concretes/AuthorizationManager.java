package eTrade.business.concretes;

import eTrade.business.abstracts.AuthorizationService;
import eTrade.business.auth.Authorization;
import eTrade.entities.concretes.User;

public class AuthorizationManager implements AuthorizationService{
	
	Authorization authorization;
	public AuthorizationManager(Authorization authorization) {
		
		this.authorization = authorization;
		
	}
	@Override
	public void register(User user) {
		this.authorization.register(user);
		
	}

	@Override
	public void login(String email, String password) {
		this.authorization.login(email, password);
		
	}

}
