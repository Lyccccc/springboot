package net.coderchen.springboot.util;

import net.coderchen.springboot.entity.MailEntity;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;

/**
 * @Author Liuyuchen
 * @Date 2018/12/07
 * @Description
 */
public class MailSender {
    private static final String STMP_SERVICE = "smtp.163.com";
    private static final String SMTP_PORT = "25";
    private static final String FROM_MAIL_ADDRESS = "";
    private static final String FROM_MAIL_SMTPPWD = "";

    public void send(String title, String content, String contentType, List<String> toMailList) throws UnsupportedEncodingException, MessagingException {
        MailEntity mailEntity = new MailEntity.Builder().title(title)
                .content(content)
                .contentType(contentType)
                .toMailList(toMailList)
                .build();
        //邮箱属性
        Properties properties = new Properties();
        //身份验证
        properties.put("mail.smtp.auth", "true");
        //smtp服务器
        properties.put("mail.smtp.host", STMP_SERVICE);
        //端口
        properties.put("mail.smtp.port", SMTP_PORT);
        //发送邮箱
        properties.put("mail.user", FROM_MAIL_ADDRESS);
        //发送邮箱的smtp口令
        properties.put("mail.password", FROM_MAIL_SMTPPWD);
        //授权信息，用于SMTP身份验证
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(properties.getProperty("mail.user"), properties.getProperty("mail.password"));
            }
        };
        //邮件会话
        Session mailSession = Session.getInstance(properties, authenticator);
        //消息体
        MimeMessage mimeMessage = new MimeMessage(mailSession);
        //设置发件人
        String nickName = MimeUtility.encodeText("");
        InternetAddress from = new InternetAddress(nickName + "<" + properties.getProperty("mail.user") + ">");
        mimeMessage.setFrom(from);
        //设置标题
        mimeMessage.setSubject(mailEntity.getTitle());
        if(MailContentEnum.HTML.getValue().equals(mailEntity.getContentType())){
            //html格式
            mimeMessage.setContent(mailEntity.getContent(), mailEntity.getContentType());
        }else if(MailContentEnum.TEXT.getValue().equals(mailEntity.getContentType())){
            //文本格式
            mimeMessage.setText(mailEntity.getContent());
        }
        for (String s : mailEntity.getToMailList()) {
            try {
                //设置收件人邮箱
                InternetAddress to = new InternetAddress(s);
                mimeMessage.setRecipients(Message.RecipientType.TO, to.getAddress());
                System.out.println("准备发邮件……");
                Transport.send(mimeMessage);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
