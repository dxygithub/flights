package cn.bdqn.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
/**
 * 声明事务并开启事务管理器
 * @author DELL
 *
 */
//@Configuration
//@EnableTransactionManagement//开启对事务的支持
public class TransactionManagerConfiguration implements TransactionManagementConfigurer {
	
	//注入dataSource
	//@Resource(name="dataSource")
	private DataSource dataSource;
	
	/**
	 * 关于事务管理，需要返回PlatformTransactionManager的实现
	 */
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return new DataSourceTransactionManager(dataSource);
	}	

}
