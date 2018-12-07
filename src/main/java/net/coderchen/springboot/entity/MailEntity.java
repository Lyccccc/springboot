package net.coderchen.springboot.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Liuyuchen
 * @Date 2018/11/30
 * @Description 邮件封装类
 */
public class MailEntity implements Serializable {

    /**
     * SMTP服务器
     */
    private String stmpService;
    /**
     * 端口号
     */
    private String smtpPort;
    /**
     * 发送端邮箱
     */
    private String fromMailAddress;
    /**
     * 发送邮箱smtp口令
     */
    private String fromMailSmtpPwd;
    /**
     * 邮件标题
     */
    private String title;
    /**
     * 邮件内容
     */
    private String content;
    /**
     * 邮件内容格式 默认html
     */
    private String contentType;
    /**
     * 收件人邮箱地址
     */
    private List<String> toMailList = new ArrayList<>();

    public MailEntity(){}

    private MailEntity(Builder builder) {
        setStmpService(builder.stmpService);
        setSmtpPort(builder.smtpPort);
        setFromMailAddress(builder.fromMailAddress);
        setFromMailSmtpPwd(builder.fromMailSmtpPwd);
        setTitle(builder.title);
        setContent(builder.content);
        setContentType(builder.contentType);
        setToMailList(builder.toMailList);
    }

    public String getStmpService() {
        return stmpService;
    }

    public void setStmpService(String stmpService) {
        this.stmpService = stmpService;
    }

    public String getSmtpPort() {
        return smtpPort;
    }

    public void setSmtpPort(String smtpPort) {
        this.smtpPort = smtpPort;
    }

    public String getFromMailAddress() {
        return fromMailAddress;
    }

    public void setFromMailAddress(String fromMailAddress) {
        this.fromMailAddress = fromMailAddress;
    }

    public String getFromMailSmtpPwd() {
        return fromMailSmtpPwd;
    }

    public void setFromMailSmtpPwd(String fromMailSmtpPwd) {
        this.fromMailSmtpPwd = fromMailSmtpPwd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public List<String> getToMailList() {
        return toMailList;
    }

    public void setToMailList(List<String> toMailList) {
        this.toMailList = toMailList;
    }

    @Override
    public String toString() {
        return "MailEntity{" +
                "stmpService='" + stmpService + '\'' +
                ", smtpPort='" + smtpPort + '\'' +
                ", fromMailAddress='" + fromMailAddress + '\'' +
                ", fromMailSmtpPwd='" + fromMailSmtpPwd + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", contentType='" + contentType + '\'' +
                ", toMailList=" + toMailList +
                '}';
    }


    public static final class Builder {
        private String stmpService;
        private String smtpPort;
        private String fromMailAddress;
        private String fromMailSmtpPwd;
        private String title;
        private String content;
        private String contentType;
        private List<String> toMailList;

        public Builder() {
        }

        public Builder stmpService(String val) {
            stmpService = val;
            return this;
        }

        public Builder smtpPort(String val) {
            smtpPort = val;
            return this;
        }

        public Builder fromMailAddress(String val) {
            fromMailAddress = val;
            return this;
        }

        public Builder fromMailSmtpPwd(String val) {
            fromMailSmtpPwd = val;
            return this;
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder content(String val) {
            content = val;
            return this;
        }

        public Builder contentType(String val) {
            contentType = val;
            return this;
        }

        public Builder toMailList(List<String> val) {
            toMailList = val;
            return this;
        }

        public MailEntity build() {
            return new MailEntity(this);
        }
    }
}
