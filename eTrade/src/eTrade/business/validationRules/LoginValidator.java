package eTrade.business.validationRules;

public class LoginValidator implements Validator{
	
	public LoginValidator(String email, String password) throws Exception {
		checkIfEmptyEmail(email);
		checkIfEmptyPassword(password);
	}

	private void checkIfEmptyEmail(String email) throws Exception {
		if (email.isEmpty()) {
			throw new Exception("E-Posta boş olamaz");
		}
	}

	private void checkIfEmptyPassword(String password) throws Exception {
		if (password.isEmpty()) {
			throw new Exception("Parola boş olamaz");
		}
	}

}
