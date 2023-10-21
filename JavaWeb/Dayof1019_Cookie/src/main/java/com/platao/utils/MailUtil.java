//package com.platao.utils;
//
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.util.Properties;
//
//
//public class MailUtil {
//
//    static String mailSender = "jplatao@qq.com";
//    private static Session session = null;
//
//    /**
//     * 发送邮件
//     * @param recipients 收件人
//     * @param subject 主题
//     * @param content 内容
//     */
//    public static void sendMail(String recipients,String subject,String content) {
//        // 创建邮件对象
//        MimeMessage message = new MimeMessage(getSession());
//        try {
//            // 设置发件人
//            message.setFrom(new InternetAddress(mailSender));
//            // 设置收件人
//            message.addRecipients(Message.RecipientType.TO,
//                    String.valueOf(new InternetAddress(recipients)));
//            // 设置主题
//            message.setSubject(subject);
//            // 设置内容
//            message.setText(content);
//            Transport.send(message);
//        } catch (MessagingException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    private static Session getSession() {
//        if (session == null) {
//
//            // 获取系统配置
//            Properties properties = System.getProperties();
//
//            // 设置邮件服务器
//            String host = "smtp.qq.com";
//            properties.setProperty("mail.smtp.host", host);
//
//            // 设置邮件服务器需要验证
//            properties.put("mail.smtp.auth", "true");
//
//            // 获取session
//            session = Session.getDefaultInstance(properties,
//                    new Authenticator() {
//                @Override
//                protected PasswordAuthentication getPasswordAuthentication() {
//                    // 设置发件人邮箱账户、授权码
//                    return new PasswordAuthentication("jplatao@qq.com",
//                            "jbhenomqfdfzebed");
//                }
//            });
//        }
//        return session;
//    }
//}
