package com.java.main;

import java.util.Properties;
import java.util.Random;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail {

	public void sendMail(String toUser, String subject, String bodyText){
		String host="172.0.0.0";//Set host  
		  final String user=new User().loadProperties().getProperty("USER");//change accordingly in the constants.properties file
		  final String password=new User().loadProperties().getProperty("PASSWORD");//change accordingly in the constants.properties file 
		    
		  String to=toUser;
		  
		   //Get the session object  
		   Properties props = new Properties();  
		   props.put("mail.smtp.host",host);  
		   props.put("mail.smtp.auth", "true");  
		     
		   Session session = Session.getDefaultInstance(props,  
		    new javax.mail.Authenticator() {
			   @Override
		      protected PasswordAuthentication getPasswordAuthentication() {  
		    return new PasswordAuthentication(user,password);  
		      }  
		    });  
		  
		   //Compose the message  
		    try {  
		     MimeMessage message = new MimeMessage(session);
		     message.setFrom(new InternetAddress(user));  
		     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  // Adding recipient mail id
		     message.addRecipient(Message.RecipientType.CC, new InternetAddress("abc1@mail.com")); // Adding mail ids to CC
		     message.addRecipient(Message.RecipientType.CC, new InternetAddress("abc2@mail.com")); // Adding mail ids to CC
		     
		     message.setSubject(subject);  //Set Subject to the mail
		     message.setContent(bodyText, "text/html");  
		     
		     MimeMultipart multipart = new MimeMultipart("related");
		     BodyPart messageBodyPart = new MimeBodyPart();
		     messageBodyPart.setContent(bodyText, "text/html");
		     multipart.addBodyPart(messageBodyPart); //Enter message to the mail body
		     int r=new Random().nextInt(4);
		     messageBodyPart = new MimeBodyPart();
		     DataSource fds = new FileDataSource(
		    		 "com//java//resources//dataFile//img//img_"+r+".jpg");

		     messageBodyPart.setDataHandler(new DataHandler(fds)); //Attaching image to the mail body
		     messageBodyPart.setHeader("Content-ID", "<image>");
		     multipart.addBodyPart(messageBodyPart);
		     message.setContent(multipart);
		 
		       
		    //send the message  
		     Transport.send(message);  
		  
		     Log.info("message sent successfully...");  
		   
		     } catch (MessagingException e) {Log.writeStackTrace(e);}  
		 }  
	
	
}
