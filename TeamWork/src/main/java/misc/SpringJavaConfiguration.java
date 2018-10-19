package misc;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import model.bean.Achievement;
import model.bean.CommitAchievement;

@Configuration
@ComponentScan(basePackages={"model"})
@EnableTransactionManagement
public class SpringJavaConfiguration {
	@Bean
	public DataSource dataSource() {
		//java測試用
		DriverManagerDataSource dataSourece = new DriverManagerDataSource();
		dataSourece.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		dataSourece.setUrl("jdbc:sqlserver://localhost:1433;databaseName=FinalShop");
		dataSourece.setUsername("sa");
		dataSourece.setPassword("passw0rd");
		return dataSourece;
//		//Contorller用
//		JndiObjectFactoryBean factory = new JndiObjectFactoryBean();
//		factory.setJndiName("java:comp/env/jdbc/context");
//		factory.setProxyInterface(javax.sql.DataSource.class);
//		try {
//			factory.afterPropertiesSet();
//		} catch (IllegalArgumentException e) {
//			e.printStackTrace();
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//		return (DataSource) factory.getObject();
	}
	
	@Bean
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBuilder builder =
				new LocalSessionFactoryBuilder(dataSource());

		Properties props = new Properties();
		props.put("hibernate.dialect", "org.hibernate.dialect.SQLServer2012Dialect");
		props.put("hibernate.current_session_context_class", "thread");
		props.put("hibernate.show_sql", "true");	
		props.put("hibernate.format_sql", "true");	
		builder.addProperties(props);
		
		builder.addAnnotatedClass(Achievement.class);
//		builder.addAnnotatedClass(Member.class);
		builder.addAnnotatedClass(CommitAchievement.class);
	
		return builder.buildSessionFactory();
	}

}
