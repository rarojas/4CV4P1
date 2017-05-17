package com.escom.distribuidos.p2.core.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service("emailServices")
public class EmailServices {

	@Autowired
	private MailSender mailSender;

	public void sendEmail(String toAddress, String fromAddress, String subject, String msgBody) {

		SimpleMailMessage email = new SimpleMailMessage();
		email.setFrom(fromAddress);
		email.setTo(toAddress);
		email.setSubject(subject);
		email.setText(msgBody);
		mailSender.send(email);
	}
}
