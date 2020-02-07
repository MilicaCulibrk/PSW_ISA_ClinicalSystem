package main.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


import main.model.AdministratorKlinickogCentra;
import main.model.AdministratorKlinike;
import main.model.Lekar;
import main.model.MedicinskaSestra;
import main.model.Pacijent;

@Service
public class MailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private Environment env;

	@Async
	public void sendNotificaitionAsync(AdministratorKlinike user, String poruka)  {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Klinicki centar");
		mail.setText(poruka);
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}
	
	@Async
	public void sendNotificaitionAsync(AdministratorKlinickogCentra user, String poruka) throws MailException, InterruptedException {


		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Klinički centar");
		mail.setText(poruka);
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}
	
	@Async
	public void sendNotificaitionAsync(Lekar user, String poruka) throws MailException, InterruptedException {


		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Klinički centar");
		mail.setText(poruka);
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}
	
	@Async
	public void sendNotificaitionAsync(MedicinskaSestra user, String poruka) throws MailException, InterruptedException {


		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Klinički centar");
		mail.setText(poruka);
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}
	

	@Async
	public void sendNotificaitionAsync(Pacijent user, String poruka) throws MailException, InterruptedException {


		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Klinički centar");
		mail.setText(poruka);
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}

}
