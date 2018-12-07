package net.coderchen.springboot.util;

/**
 * @Author Liuyuchen
 * @Date 2018/12/07
 * @Description
 */
public enum MailContentEnum {
    HTML("text/html;charset=UTF-8"),
    TEXT("text");

    private String value;

    MailContentEnum(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
