package com.x5.bigdata.assortment.currentfilllevelupdater.Client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JdbcClient {


    @Value("${postgers.url}")
    private String url;
    @Value("${postgres.user}")
    private String user;
    @Value("${password}")
    private String password;

    private DataSource getds() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setPassword(password);
        dataSource.setUsername(user);
        dataSource.setUrl(url);

        return dataSource;
    }


    public NamedParameterJdbcTemplate jt() {
        return new NamedParameterJdbcTemplate(getds());
    }
}
