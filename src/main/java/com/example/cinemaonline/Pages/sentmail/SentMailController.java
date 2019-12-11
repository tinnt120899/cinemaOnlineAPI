package com.example.cinemaonline.Pages.sentmail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/sentgmail")
@RestController
public class SentMailController {
	
	@GetMapping()
	public String sendMail(
			@RequestParam("gmail") String gmail,
			@RequestParam("noiDung") String noiDung
	) throws AddressException, MessagingException {


		Properties mailServerProperties;
	    Session getMailSession;
	    MimeMessage mailMessage;
	    // Step1: setup Mail Server
	    mailServerProperties = System.getProperties();
	    mailServerProperties.put("mail.smtp.port", "587");
	    mailServerProperties.put("mail.smtp.auth", "true");
	    mailServerProperties.put("mail.smtp.starttls.enable", "true");
	 
	    // Step2: get Mail Session
	    getMailSession = Session.getDefaultInstance(mailServerProperties, null);
	    mailMessage = new MimeMessage(getMailSession);
	 
	    mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(gmail));
	 
	    // CC and BCC
//	    generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("cc@gmail.com")); //Địa chỉ cc gmail
	 
	 
	    mailMessage.setSubject("Đặt vé thành công!!!");
	    String emailBody = noiDung;
	    mailMessage.setContent(emailBody, "text/html; charset=utf-8");
	 
	    // Step3: Send mail
	    Transport transport = getMailSession.getTransport("smtp");
	 
	    // Thay your_gmail thành gmail của bạn, thay your_password thành mật khẩu gmail của bạn
	    transport.connect("smtp.gmail.com", "nguyentrungtin120899@gmail.com", "Tin01208687169");
	    transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
	    transport.close();
	    return "Success";
	  }
}
