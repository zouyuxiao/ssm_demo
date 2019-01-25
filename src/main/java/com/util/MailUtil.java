package com.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by ${邹} on 2019/1/24.
 * 描述：
 * @param toUser 接收激活码邮箱
 * @param code   激活码
 */
public class MailUtil {
    public static void sendMail(String toUser, String code) throws Exception {

        Properties props = new Properties();
        // 开启debug调试
        props.setProperty("mail.debug", "true");
        // 发送服务器需要身份验证
        props.setProperty("mail.smtp.auth", "true");
        // 设置邮件服务器主机名
        props.setProperty("mail.host", "smtp.qq.com");
        // 发送邮件协议名称
        props.setProperty("mail.transport.protocol", "smtp");

        // 设置环境信息
        Session session = Session.getInstance(props, new Authenticator() {
            // 在session中设置账户信息，Transport发送邮件时会使用
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("1987196944@qq.com", "egayrxjnfmmgbabj");
            }
        });

        // 创建邮件对象
        Message msg = new MimeMessage(session);
        // 发件人
        msg.setFrom(new InternetAddress("1987196944@qq.com"));
        // 多个收件人
        msg.setRecipients( Message.RecipientType.TO, InternetAddress.parse(toUser));
        // 抄送人
        // msg.setRecipient(Message.RecipientType.CC, new InternetAddress("java_mail_001@163.com"));
        // 暗送人
        //msg.setRecipient(Message.RecipientType.BCC, new InternetAddress("java_mail_004@163.com"));

        // 主题
        msg.setSubject("账号激活邮件");
        // HTML内容
        msg.setContent("<div align='center'><h1>潇洒走一回账号激活邮件</h1><h3>" +
                "<a href='http://127.0.0.1:8082/mail/activate?code="+code+"'>点此激活http://127.0.0.1:8082/mail/activate?code="+code+"</a></h3></div>", "text/html;charset=utf-8");

        // 连接邮件服务器、发送邮件、关闭连接，全干了
        Transport.send(msg);

    }
}
