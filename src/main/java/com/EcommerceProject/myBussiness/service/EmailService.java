package com.EcommerceProject.myBussiness.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.EcommerceProject.myBussiness.dto.EmailDto;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String from;

	public void sendEmail(EmailDto emailDto) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		 helper.setFrom(from);
	        helper.setTo(emailDto.to());            
	        helper.setSubject(emailDto.subject());  
	        helper.setText(emailDto.body());
	
	        javaMailSender.send(message);
	}
}
