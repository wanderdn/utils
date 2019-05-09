package com.x5.bigdata.assortment.currentfilllevelupdater;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PluRowMapper implements RowMapper {
    @Override
    public PluCurrent_Fill mapRow(ResultSet rs, int rowNum) throws SQLException {
        PluCurrent_Fill plu = new PluCurrent_Fill();
        plu.plu = rs.getString("plu");

        plu.assortment_cluster = rs.getString("assortment_cluster");
        plu.assortment_level = rs.getInt("assortment_level");
        plu.macro_code = rs.getString("macro_code");

        plu.can_be_through_plu = rs.getBoolean("can_be_through_plu");
        plu.through_plu_part = rs.getDouble("through_plu_part");
        plu.can_be_through_plu_part = rs.getDouble("can_be_through_plu_part");
        plu.through = rs.getBoolean("through");
        plu.cluster_id = rs.getInt("cluster_id");
        plu.version = rs.getInt("version");
        plu.assortment_id = rs.getInt("assortment_id");
        plu.necessarily_code = rs.getInt("necessarily_code");
        plu.partly_through = rs.getInt("partly_through");
        return plu;
    }
}
