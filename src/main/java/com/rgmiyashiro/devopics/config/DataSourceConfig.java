package com.rgmiyashiro.devopics.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {


    @Bean
    public DataSource getDataSource() {
        Dotenv dotenv = Dotenv.load();


        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();

        dataSourceBuilder.driverClassName(System.getenv("devopics_db_driver"));
        dataSourceBuilder.url(System.getenv("devopics_db_url"));
        dataSourceBuilder.username(System.getenv("devopics_db_username"));
        dataSourceBuilder.password(System.getenv("devopics_db_password"));


//        dataSourceBuilder.driverClassName(dotenv.get("devopics_db_driver"));
//        dataSourceBuilder.url(dotenv.get("devopics_db_url"));
//        dataSourceBuilder.username(dotenv.get("devopics_db_username"));
//        dataSourceBuilder.password(dotenv.get("devopics_db_password"));
        return dataSourceBuilder.build();
    }
}
