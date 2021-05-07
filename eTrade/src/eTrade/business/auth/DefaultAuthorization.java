package eTrade.business.auth;

import eTrade.business.abstracts.UserService;
import eTrade.business.validationRules.LoginValidator;
import eTrade.business.validationRules.RegisterValidator;
import eTrade.business.validationRules.ValidationTool;
import eTrade.business.verification.EmailVerification;
import eTrade.business.verification.VerificationTool;
import eTrade.entities.concretes.User;

public class DefaultAuthorization implements Authorization{

	UserService userService;

	public DefaultAuthorization(UserService userService) {

		this.userService = userService;
		
	}
	
	@Override
	public void register(User user) {

		try {

			ValidationTool.validate(new RegisterValidator(user));

			checkIfAlreadyExistsEmail(user.getEmail());

			boolean result = this.userService.add(user);

			if (result) {

				System.out.println("Kaydınız başarıyla gerçekleşti, " + user.getFirstName() + " " + user.getLastName());

			}

			VerificationTool.verify(new EmailVerification(result, user));

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

	}

	@Override
	public void login(String email, String password) {

		try {

			ValidationTool.validate(new LoginValidator(email, password));

			checkIfExistsUser(email);

			User user = getUser(email);

			boolean checkPassword = user.getPassword() == password;

			if (checkPassword) {

				System.out.println("Baþarýyla giriþ yapýldý, " + user.getFirstName() + " " + user.getLastName());
				
			} else {

				System.out.println("Parola hatalý");
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

	}

	private void checkIfAlreadyExistsEmail(String email) throws Exception {

		for (User user : this.userService.getAll()) {

			if (user.getEmail() == email) {

				throw new Exception("E-posta zaten kullanýlýyor");

			}

		}
	}

	private void checkIfExistsUser(String email) throws Exception {

		User user = this.userService.getByEmail(email);

		if (user == null) {

			throw new Exception("Kullanıcı bulunamadı");

		}
	}

	private User getUser(String email) throws Exception {

		checkIfExistsUser(email);

		return this.userService.getByEmail(email);
	}

}
