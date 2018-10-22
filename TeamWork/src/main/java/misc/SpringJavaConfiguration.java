package misc;

import java.awt.Image;
import java.util.Properties;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import model.bean.Achievement;
import model.bean.CommitAchievement;
import model.bean.Conversation;
import model.bean.DistrictType;
import model.bean.Group;
import model.bean.GroupAssess;
import model.bean.GroupMessage;
import model.bean.GroupProduct;
import model.bean.GroupReport;
import model.bean.GroupService;
import model.bean.Member;
import model.bean.Product;
import model.bean.Seller;
import model.bean.State;
import model.bean.Store;
import model.bean.StoreAssess;
import model.bean.StoreOrder;
import model.bean.StoreProduct;
import model.bean.StoreReport;
import model.bean.Wish;
import model.bean.WishAssess;
import model.bean.WishMessage;
import model.bean.WishProduct;
import model.bean.WishReport;

@Configuration
@ComponentScan(basePackages={"model"})
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
		//Contorller用
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
	
	@Bean
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBuilder builder =
				new LocalSessionFactoryBuilder(dataSource());

		Properties props = new Properties();
		props.put("hibernate.dialect", "org.hibernate.dialect.SQLServer2012Dialect");
		props.put("hibernate.current_session_context_class", "thread");
//		props.put("hibernate.show_sql", "true");	
//		props.put("hibernate.format_sql", "true");	
		builder.addProperties(props);
		
		builder.addAnnotatedClass(State.class);
		builder.addAnnotatedClass(Member.class);
		builder.addAnnotatedClass(Conversation.class);
		builder.addAnnotatedClass(Achievement.class);
		builder.addAnnotatedClass(Seller.class);
		builder.addAnnotatedClass(Product.class);
		builder.addAnnotatedClass(CommitAchievement.class);
		builder.addAnnotatedClass(Store.class);
		builder.addAnnotatedClass(StoreProduct.class);
		builder.addAnnotatedClass(StoreOrder.class);
		builder.addAnnotatedClass(StoreReport.class);
		builder.addAnnotatedClass(StoreAssess.class);
		builder.addAnnotatedClass(DistrictType.class);	
		builder.addAnnotatedClass(Wish.class);	
		builder.addAnnotatedClass(WishProduct.class);	
		builder.addAnnotatedClass(WishMessage.class);	
		builder.addAnnotatedClass(WishReport.class);	
		builder.addAnnotatedClass(WishAssess.class);	
		builder.addAnnotatedClass(Group.class);	
		builder.addAnnotatedClass(GroupProduct.class);	
		builder.addAnnotatedClass(GroupService.class);	
		builder.addAnnotatedClass(GroupMessage.class);	
		builder.addAnnotatedClass(GroupReport.class);	
		builder.addAnnotatedClass(GroupAssess.class);	
		builder.addAnnotatedClass(Image.class);	
		
		return builder.buildSessionFactory();
	}

}
