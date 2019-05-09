package com.x5.bigdata.assortment.currentfilllevelupdater.a;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Service;

import java.util.List;

//import com.example.demo.config.Prod;

@Service
public class insert implements ApplicationListener<ContextRefreshedEvent> {
NamedParameterJdbcTemplate prod;
JdbcTemplate test;

    public insert(test testjdb,Prod prod){
this.prod=prod.cl();
this.test=testjdb.jt();
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
List<DTO> l =test.query("select * from public.products where assortment_id in(57, 75, 115, 32, 38, 41, 60, 112, 47, 33, 39, 59, 42, 58, 117\n" +
         "\n" +
         ",139, 207, 59, 109, 165) ",new mapper());

        List<DTO> l2 =prod.query("select * from public.products where assortment_id in(57, 75, 115, 32, 38, 41, 60, 112, 47, 33, 39, 59, 42, 58, 117\n" +
                "\n" +
                ",139, 207, 59, 109, 165) ",new mapper());
System.out.println( l.containsAll(l2));
l.removeAll(l2);
        SqlParameterSource[] pluBatch = SqlParameterSourceUtils.createBatch(l.toArray());

prod.batchUpdate("insert into public.products values(    :assortment_id\n" +
        ":ui3_code\n" +
        ":code\n" +
        ":name\n" +
        ":exclude\n" +
        ":ui4_code\n" +
        ":rto\n" +
        ":margin\n" +
        ":stm\n" +
        ":price_segment_id\n" +
        ":is_federal\n" +
        ":brand_code\n" +
        ":is_dendrogram\n" +
        ":is_cdt\n" +
        ":ui3_name\n" +
        ":ui4_name)",pluBatch);

    }
}
