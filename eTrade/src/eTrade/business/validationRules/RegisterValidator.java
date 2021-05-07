package eTrade.business.validationRules;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eTrade.entities.concretes.User;

public class RegisterValidator implements Validator{
	
	public RegisterValidator(User user) throws Exception {

		checkIfShorterPasswordThanSix(user.getPassword());

		checkIfEmailForm(user.getEmail());

		checkIfFirstNameLongerThanTwo(user.getFirstName());

		checkIfLastNameLongerThanTwo(user.getLastName());

	}

	public void checkIfShorterPasswordThanSix(String password) throws Exception {

		if (password.length() < 6) {

			throw new Exception("Parola en az 6 haneli olmalıdır");

		}

	}

	public void checkIfEmailForm(String email) throws Exception {

		String regex = "^(.+)@(.+)$";

		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(email);

		if (!matcher.matches()) {

			throw new Exception("Giriş, E-Posta formatında olmalıdır");

		}

	}

	public void checkIfFirstNameLongerThanTwo(String firstName) throws Exception {

		if (firstName.length() < 2) {

			throw new Exception("İsim en az 2 karakterden oluşmalıdır");

		}

	}

	public void checkIfLastNameLongerThanTwo(String lastName) throws Exception {

		if (lastName.length() < 2) {

			throw new Exception("Soyisim en az 2 karakterden oluşmalıdır");

		}

	}
}
