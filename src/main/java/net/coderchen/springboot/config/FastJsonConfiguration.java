package net.coderchen.springboot.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Liuyuchen
 * @Date 2018/11/28
 * @Description fastjson配置类
 */
@Configuration
public class FastJsonConfiguration extends WebMvcConfigurationSupport {

    /**
     * 修改自定义消息转换器
     * @param converters 消息转换器列表
     */
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //调用父类配置
        super.configureMessageConverters(converters);
        //FastJson消息转换器
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        //FastJson 配置
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //修改返回内容的过滤
        /**
         *         FastJson SerializerFeatures
         *         WriteNullListAsEmpty  ：List字段如果为null,输出为[],而非null
         *         WriteNullStringAsEmpty ： 字符类型字段如果为null,输出为"",而非null
         *         DisableCircularReferenceDetect ：消除对同一对象循环引用的问题，默认为false（如果不配置有可能会进入死循环）
         *         WriteNullBooleanAsFalse：Boolean字段如果为null,输出为false,而非null
         *         WriteMapNullValue：是否输出值为null的字段,默认为false。
         */
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty
        );
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        //处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);
        //添加到转换器列表内
        converters.add(fastJsonHttpMessageConverter);
    }
}
