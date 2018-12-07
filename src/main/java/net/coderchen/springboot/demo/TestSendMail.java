package net.coderchen.springboot.demo;

import net.coderchen.springboot.util.MailContentEnum;
import net.coderchen.springboot.util.MailSender;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * @Author Liuyuchen
 * @Date 2018/11/30
 * @Description
 */
public class TestSendMail {

    public static void main(String[] args) throws UnsupportedEncodingException, MessagingException {
        new MailSender().send("标题", "内容aaaaaaaaaa", MailContentEnum.TEXT.getValue(), new ArrayList<String>(){{add("");}});
    }
}
