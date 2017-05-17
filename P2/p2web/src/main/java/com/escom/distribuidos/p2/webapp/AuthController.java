package com.escom.distribuidos.p2.webapp;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.escom.distribuidos.p2.webapp.dto.UserLogin;
import com.escom.distribuidos.p2.webapp.dto.UserLoginOut;

@RestController
@RequestMapping("auth")
public class AuthController {

	@RequestMapping(path = "login", method = RequestMethod.POST)
	public UserLoginOut login(@RequestBody UserLogin login) {
		UserLoginOut userLoginOut = new UserLoginOut();
		userLoginOut.setToken("also");
		return userLoginOut;
	}
}
