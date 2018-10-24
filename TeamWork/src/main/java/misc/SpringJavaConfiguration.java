package misc;

import java.util.Properties;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "model" })
@EnableTransactionManagement
public class SpringJavaConfiguration {
	@Bean
	public DataSource dataSource() {
//		//java測試用
//		DriverManagerDataSource dataSourece = new DriverManagerDataSource();
//		dataSourece.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		dataSourece.setUrl("jdbc:sqlserver://localhost:1433;databaseName=FinalShop");
//		dataSourece.setUsername("sa");
//		dataSourece.setPassword("passw0rd");
//		return dataSourece;
		// Contorller用
		JndiObjectFactoryBean factory = new JndiObjectFactoryBean();
		factory.setJndiName("java:comp/env/jdbc/context");
		factory.setProxyInterface(javax.sql.DataSource.class);
		try {
			factory.afterPropertiesSet();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return (DataSource) factory.getObject();
	}
	
////不自動開交易	properties()需加入 ("hibernate.current_session_context_class" , "thread")
//	@Bean
//	public SessionFactory sessionFactory() {
//		LocalSessionFactoryBuilder builder =
//				new LocalSessionFactoryBuilder(dataSource());
//		builder.addProperties(properties());
//		builder.addAnnotatedClass(State.class);
//		builder.addAnnotatedClass(Member.class);
//		builder.addAnnotatedClass(Conversation.class);
//		builder.addAnnotatedClass(Achievement.class);
//		builder.addAnnotatedClass(Seller.class);
//		builder.addAnnotatedClass(Product.class);
//		builder.addAnnotatedClass(CommitAchievement.class);
//		builder.addAnnotatedClass(Store.class);
//		builder.addAnnotatedClass(StoreProduct.class);
//		builder.addAnnotatedClass(StoreOrder.class);
//		builder.addAnnotatedClass(StoreReport.class);
//		builder.addAnnotatedClass(StoreAssess.class);
//		builder.addAnnotatedClass(DistrictType.class);	
//		builder.addAnnotatedClass(Wish.class);	
//		builder.addAnnotatedClass(WishProduct.class);	
//		builder.addAnnotatedClass(WishMessage.class);	
//		builder.addAnnotatedClass(WishReport.class);	
//		builder.addAnnotatedClass(WishAssess.class);	
//		builder.addAnnotatedClass(Group.class);	
//		builder.addAnnotatedClass(GroupProduct.class);	
//		builder.addAnnotatedClass(GroupService.class);	
//		builder.addAnnotatedClass(GroupMessage.class);	
//		builder.addAnnotatedClass(GroupReport.class);	
//		builder.addAnnotatedClass(GroupAssess.class);	
//		builder.addAnnotatedClass(Images.class);			
//		return builder.buildSessionFactory();
//	}
	
//自動開交易	properties()絕對不可加入 ("hibernate.current_session_context_class" , "thread")
//並且加入		@EnableTransactionManagement
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(dataSource());
		factory.setPackagesToScan(new String[] { "model" });
		factory.setHibernateProperties(properties());
		return factory;
	}

	private Properties properties() {
		Properties props = new Properties();
		props.put("hibernate.dialect", "org.hibernate.dialect.SQLServer2012Dialect");
////		props.put("hibernate.current_session_context_class", "thread");
////		props.put("hibernate.show_sql", "true");	
////		props.put("hibernate.format_sql", "true");
		return props;
	}

	@Bean(name = "transactionManager")
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory);
		return hibernateTransactionManager;
	}
}
