package net.coderchen.springboot.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Liuyuchen
 * @Date 2018/11/26
 * @Description druid配置类
 * 访问路径：127.0.0.1:8080/druid/login.html
 */
@Configuration
public class DruidConfiguration {

    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //ip白名单
        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
        //ip黑名单，若deny与allow同时存在，deny优先
        servletRegistrationBean.addInitParameter("deny", "192.168.0.1");
        //控制台账号密码
        servletRegistrationBean.addInitParameter("loginUsername", "druid");
        servletRegistrationBean.addInitParameter("loginPassword", "123456");
        //是否可以重置数据
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }

    public FilterRegistrationBean statFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //过滤器过滤路径
        filterRegistrationBean.addUrlPatterns("/*");
        //忽略过滤的形式
        filterRegistrationBean.addInitParameter("exclusions", "*.js, *.gif, *.css, *.jpg, *.png, *.ico, /druid/*");
        return filterRegistrationBean;
    }
}
