package in.nit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "in.nit")
@EnableWebMvc
@EnableTransactionManagement
@PropertySource(value = "classpath:app.properties")
public class AppConfig implements WebMvcConfigurer {

	@Autowired
	private Environment env;

	// datasource properties
	@Bean
	public DataSource creaDataSource() {

		System.out.println(env);
		BasicDataSource bdc = null;
		bdc = new BasicDataSource();
		bdc.setDriverClassName(env.getProperty("db.driver"));
		bdc.setUrl(env.getProperty("db.url"));
		bdc.setUsername(env.getProperty("db.user"));
		bdc.setPassword(env.getProperty("db.pwd"));
		return bdc;
	}

	// SessionFactory
	@Bean
	public LocalSessionFactoryBean sf() {
		LocalSessionFactoryBean s = null;
		s = new LocalSessionFactoryBean();
		s.setDataSource(creaDataSource());
		s.setHibernateProperties(props());
		// s.setAnnotatedClasses(Employee.class);
		s.setPackagesToScan("in.nit");
		return s;
	}

	// Hibernate properties
	@Bean
	public Properties props() {
		Properties prop = null;
		prop = new Properties();
		prop.put("hibernate.dialect", env.getProperty("orm.dialect"));
		prop.put("hibernate.show-sql", env.getProperty("orm.showsql"));
		prop.put("hibernate.format-sql", env.getProperty("orm.fmtsql"));
		prop.put("hibernate.hbm2ddl.auto", env.getProperty("orm.ddlauto"));
		
		return prop;
	}

	// Hibernates Template
	@Bean
	public HibernateTemplate ht() {
		HibernateTemplate ht = null;
		ht = new HibernateTemplate();
		ht.setSessionFactory(sf().getObject());
		return ht;
	}

	// HTXM
	@Bean
	public HibernateTransactionManager htxm() {
		HibernateTransactionManager htxm = null;
		htxm = new HibernateTransactionManager();
		htxm.setSessionFactory(sf().getObject());

		return htxm;
	}

	// view resolver
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver invr = null;
		invr = new InternalResourceViewResolver();
		invr.setPrefix(env.getProperty("mvc.prefix"));
		invr.setSuffix(env.getProperty("mvc.suffix"));
		return invr;
	}

	// active CMF(Common mulltiparts Resolver)
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		return new CommonsMultipartResolver();

	}

	// enable resources folder
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");

	}
}
