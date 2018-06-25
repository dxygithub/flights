package cn.bdqn.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * dataSource配置
 * @author DELL
 *
 */
//@Configuration
//自动扫描dao并生成相应的动态实现类
//@MapperScan("cn.bdqn.flight.dao")
public class DataSourceConfiguration {
	
	//注入数据库连接属性
	@Value("${jdbc.driver}")
	private String driver;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
	@Value("${jdbc.url}")
	private String url;
	
	/**
	 * 创建数据源与applicationContext.xml中的datasources对应
	 * @return
	 */
	//@Bean(name="dataSource")
	public BasicDataSource createDataSource() {
		//生成datasource实例
		BasicDataSource basicDataSource=new BasicDataSource();
		basicDataSource.setDriverClassName(driver);//设置数据库驱动
		basicDataSource.setUrl(url);//设置数据库连接
		basicDataSource.setUsername(username);//设置用户名
		basicDataSource.setPassword(password);//设置密码
		return basicDataSource;
	}
	
}
