package cn.bdqn.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
/**
 * 开启mvc自动注入，并配置视图解析器
 * @author DELL
 *
 */
//@Configuration
public class MvcConfiguration implements ApplicationContextAware{

	//spring容器
	private ApplicationContext applicationContext;
	/**
	 * 注入spring
	 */
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}

	/**
	 * 创建ViewResolver
	 * @return
	 */
	//@Bean(name="viewResolver")
	public ViewResolver createViewResolver() {
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		//设置spring容器
		viewResolver.setApplicationContext(this.applicationContext);
		//取消缓存
		viewResolver.setCache(false);
		//设置解析前缀
		viewResolver.setPrefix("/WEB-INF/jsp/");
		//设置解析后缀
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	/**
	 * 创建文件上传解析器
	 * @return
	 */
	//@Bean(name="multipartResolver")
	public CommonsMultipartResolver createCommonsMultipartResolver() {
		CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(104857600);
		multipartResolver.setMaxInMemorySize(104857600);
		multipartResolver.setDefaultEncoding("UTF-8");
		return multipartResolver;
	}

}
