//package com.x5.bigdata.assortment.currentfilllevelupdater.service;
//
//import com.x5.bigdata.assortment.currentfilllevelupdater.Client.JdbcClient;
//import com.x5.bigdata.assortment.currentfilllevelupdater.PluCurrent_Fill;
//import com.x5.bigdata.assortment.currentfilllevelupdater.PluRowMapper;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.jdbc.core.namedparam.SqlParameterSource;
//import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class UpdateService implements ApplicationListener<ContextRefreshedEvent> {
//
//    private NamedParameterJdbcTemplate client;
//
//    public UpdateService(JdbcClient client) {
//        this.client = client.jt();
//
//    }
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent event) {
//
//        final List<Integer> assortment_levels = client.query("select id from voc.assortment_level", (rs, rowNum) -> rs.getInt("id"));
//        List<String> isnertParams =
//                Arrays.asList("plu", "min(assortment_level) as assortment_level", "cluster_id", "version", "assortment_id",
//                        "macro_code", "through", "can_be_through_plu", "through_plu_part", "can_be_through_plu_part",
//                        "necessarily_code", "assortment_cluster", "partly_through");
//        List<PluCurrent_Fill> plu = client.query("SELECT " + String.join(",", isnertParams) +
//                " FROM public.assortment_recommendation\n" +
//                "where version=-1\n" +
//                "                        group by " + String.join(", ", isnertParams.stream().filter(x -> !x.contains("min")).collect(Collectors.toList())) +
//                ";\n", new PluRowMapper()
//
//        );
//        List<PluCurrent_Fill> pluCurrentFills = new ArrayList<>();
//        plu.forEach(x ->
//                assortment_levels.stream().filter(s -> s > x.assortment_level).forEach(as -> {
//                            PluCurrent_Fill plu_clone = x.clone();
//                            plu_clone.assortment_level = as;
//                            pluCurrentFills.add(plu_clone);
//                        }
//                ));
//        SqlParameterSource[] pluBatch = SqlParameterSourceUtils.createBatch(pluCurrentFills.toArray());
//            client.batchUpdate("insert into  public.assortment_recommendation  values (" + " " + String.join(",", isnertParams.stream()
//                .map(s -> s.replace("max(assortment_level) as assortment_level", "assortment_level"))
//                .map(param -> ":" + param).collect(Collectors.toList())) + ") on conflict DO NOTHING ;", pluBatch);
//
//    }
//}