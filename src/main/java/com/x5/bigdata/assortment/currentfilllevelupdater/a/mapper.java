package com.x5.bigdata.assortment.currentfilllevelupdater.a;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class mapper implements RowMapper {


    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        DTO dt = new DTO();

        dt.assortment_id = rs.getInt("assortment_id");
        dt.ui3_code = rs.getString("ui3_code");
        dt.code = rs.getString("code");
        dt.name = rs.getString("name");
        dt.exclude = rs.getInt("exclude");
        dt.ui4_code = rs.getString("ui4_code");
        dt.rto = rs.getDouble("rto");
        dt.margin = rs.getDouble("margin");
        dt.stm = rs.getBoolean("stm");
        dt.price_segment_id = rs.getInt("price_segment_id");
        dt.is_federal = rs.getBoolean("is_federal");
        dt.brand_code = rs.getString("brand_code");
        dt.is_dendrogram = rs.getBoolean("is_dendrogram");
        dt.is_cdt = rs.getBoolean("is_cdt");

        dt.ui3_name = rs.getString("ui3_name");
        dt.ui4_name = rs.getString("ui4_name");
        return dt;
    }
}
