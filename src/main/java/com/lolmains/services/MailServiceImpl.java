package com.lolmains.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.lolmains.domains.CreateMessage;


@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private JavaMailSender  mailSender;
	
	
	private SimpleMailMessage templateMessage;

	
	

	public void setTemplateMessage(SimpleMailMessage templateMessage) {
		this.templateMessage = templateMessage;
	}

		
	

	@Override
	public void sendMail(CreateMessage createMessage) {
		// TODO Auto-generated method stub
	
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("valentino.kusec.rb@gmail.com");
		msg.setText(createMessage.getMessage());
		try {
			this.mailSender.send(msg);
		} catch (MailException ex) {
			// simply log it and go on...
			System.err.println(ex.getMessage());
		}
	}

}
