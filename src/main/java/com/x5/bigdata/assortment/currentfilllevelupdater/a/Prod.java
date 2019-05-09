package com.x5.bigdata.assortment.currentfilllevelupdater.a;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class Prod {

    @Value("${prod.url}")
    private String url;
    @Value("${postgres.user}")
    private String user;
    @Value("${password}")
    private String password;

    private DataSource getds() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource() ;

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setPassword(password);
        dataSource.setUsername(user);
        dataSource.setUrl(url);

        return dataSource;
    }


    public NamedParameterJdbcTemplate cl() {
        return new NamedParameterJdbcTemplate(getds());
    }
}
