package lk.ijse.gdse.gradle.appConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
@Configuration
@EnableJpaRepositories("lk.ijse.gdse.gradle.repo")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class JPAConfig {
    @Autowired
    Environment env;


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter vendorAdapter) {
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setJpaVendorAdapter(vendorAdapter);
        bean.setDataSource(dataSource);
        bean.setPackagesToScan(env.getRequiredProperty("entity.package.scan"));
        return bean;
    }
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("SEIndustry.Driver"));
        dataSource.setUrl(env.getRequiredProperty("SEIndustry.url"));
        dataSource.setUsername(env.getRequiredProperty("SEIndustry.userName"));
        dataSource.setPassword(env.getRequiredProperty("SEIndustry.password"));
        return dataSource;
    }
    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabasePlatform(env.getRequiredProperty("SEIndustry.dbPlatform"));
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true);
        return adapter;
    }
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(emf);
        return jpaTransactionManager;
    }

}
