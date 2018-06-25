package cn.bdqn.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * sessionFactory配置
 * @author DELL
 *
 */
//@Configuration
public class SessionFactoryConfiguration {
	
	//注入datasource
	//@Resource(name="dataSource")
	private DataSource dataSource;
	
	//mybatis-config.xml路径
	private static String mybatisconfigfile;
	//@Value("${mybatis_config_file}")
	public void setMybatisconfigfile(String mybatisconfigfile) {
		SessionFactoryConfiguration.mybatisconfigfile = mybatisconfigfile;
	}


	/**
	 * 创建SqlSessionFactoryBean，并设置mapper映射路径及数据源
	 * @return
	 */
	//@Bean(name="sqlSessionFactory")
	public SqlSessionFactoryBean createSqlSessionFactoryBean() {
		SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
		//设置数据源
		sqlSessionFactoryBean.setDataSource(dataSource);
		//设置mybatis-config.xml映射路径
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisconfigfile));
		return sqlSessionFactoryBean;
	}
}
