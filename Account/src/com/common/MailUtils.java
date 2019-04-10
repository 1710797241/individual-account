package com.common;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.UUID;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage.RecipientType;

public class MailUtils {

	//email:邮件发给谁  subject:主题  emailMsg：邮件的内容
	public static String sendMail(String email, String subject, String url)
			throws AddressException, MessagingException {
		
		// 1.创建一个程序与邮件服务器会话对象 Session
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "SMTP");//发邮件的协议
		props.setProperty("mail.host", "smtp.qq.com");//发送邮件的服务器地址
		props.setProperty("mail.smtp.auth", "true");// 指定验证为true
//
//		// 创建验证器
//		Authenticator auth = new Authenticator() {
//			public PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication("18851738520", "leimeng03");//发邮件的账号的验证
//			}
//		};


//		axkuqdwquhvmbgdf
		// 创建验证器
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("136239138", "axkuqdwquhvmbgdf");//发邮件的账号的验证
			}
		};

		Session session = Session.getInstance(props, auth);

		// 2.创建一个Message，它相当于是邮件内容
		Message message = new MimeMessage(session);
		MimeMultipart msgMultipart  = new MimeMultipart("mixed");


		MimeBodyPart content = new MimeBodyPart();
		msgMultipart.addBodyPart(content);
		//正文（图片和文字部分）
		MimeMultipart bodyMultipart  = new MimeMultipart("related");
		//设置内容为正文

		//html代码部分
		MimeBodyPart htmlPart = new MimeBodyPart();

		
		String token = null;
		try {
			String uuid = UUID.randomUUID().toString();
			String repUuid = uuid.replaceAll("-", "");
			byte[] bytes = repUuid.getBytes("ISO8859-1");
			token = new String(bytes,"ISO8859-1");
			System.out.println(token);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String htmlBody = "<div style=\"width:100%\"><div style=\"padding:50px;\"><div style=\"margin:auto atuo;text-align:center;\"><span style=\"color:red;font-size:18px;font-weight:bold;\">你忘记了密码？</span></div>" +
				"<div style=\"text-align:center;\"><a href=\"http://localhost:8080/"+url+"&token="+token+"\">重置密码</a></div>" +
				"<div><img style=\"width:1000px;\" src=\"\"></div></div></div>";
		htmlPart.setContent(htmlBody,"text/html;charset=utf-8");
		//正文添加图片和html代码
		bodyMultipart.addBodyPart(htmlPart);

		content.setContent(bodyMultipart);

		message.saveChanges();
		message.setSubject(subject);//邮件的主题
		message.setContent(msgMultipart);
		message.setFrom(new InternetAddress("136239138@qq.com")); // 设置发送者

		message.setRecipient(RecipientType.TO, new InternetAddress(email)); // 设置发送方式与接收者

		// 3.创建 Transport用于将邮件发送
		Transport.send(message);
		return token;
	}
}
