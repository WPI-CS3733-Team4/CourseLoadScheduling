package org.dselent.scheduling.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

/**
 * AppConfig class functions as a standard Spring configuration class.
 * Configuration for the database connections are specified here.
 * These configurations are read through the environment variables ("env" variable).
 * This object is populated with the current environment AND the data in the application.properties file.
 * The properties file is automatically read with the location specified by the "@PropertySource" annotation.
 * It is expected to be in the resources folder.
 * 
 * @author dselent
 *
 */

@Configuration
@PropertySource("classpath:/application.properties")
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages="org.dselent.scheduling.server")
public class AppConfig
{

    public static String DATABASE_URL = "jdbc:postgresql://localhost:5432/test";
    public static String DATABASE_USER = "postgres";
    public static String DATABASE_PASSWORD = "yyzzxx999";
    public static String DATABASE_DRIVER = "org.postgresql.Driver";

	@Autowired
	private Environment env;
		
	@Bean
	public DataSource dataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setUrl(DATABASE_URL);
        dataSource.setUsername(DATABASE_USER);
        dataSource.setPassword(DATABASE_PASSWORD);
        dataSource.setDriverClassName(DATABASE_DRIVER);
		
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource)
	{
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource)
	{
		return new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Bean
    public PlatformTransactionManager txManager()
	{
        return new DataSourceTransactionManager(dataSource());
    }
}
