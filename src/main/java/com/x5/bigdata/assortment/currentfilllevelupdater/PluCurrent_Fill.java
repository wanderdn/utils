package com.x5.bigdata.assortment.currentfilllevelupdater;

public class PluCurrent_Fill {
    public String plu;
    public int assortment_level;
    public String macro_code;
    public String assortment_cluster;
    public int cluster_id;
    public int version;
    public int assortment_id;
    public boolean through;
    public boolean can_be_through_plu;
    public double through_plu_part;
    public double can_be_through_plu_part;
    public int necessarily_code;
    public Integer partly_through;

    public String getPlu() {
        return plu;
    }

    public int getAssortment_level() {
        return assortment_level;
    }

    public String getMacro_code() {
        return macro_code;
    }

    public String getAssortment_cluster() {
        return assortment_cluster;
    }

    public int getCluster_id() {
        return cluster_id;
    }

    public int getVersion() {
        return version;
    }

    public int getAssortment_id() {
        return assortment_id;
    }

    public boolean isThrough() {
        return through;
    }

    public boolean isCan_be_through_plu() {
        return can_be_through_plu;
    }

    public double getThrough_plu_part() {
        return through_plu_part;
    }

    public double getCan_be_through_plu_part() {
        return can_be_through_plu_part;
    }

    public int getNecessarily_code() {
        return necessarily_code;
    }

    public Integer getPartly_through() {
        return partly_through;
    }


    public PluCurrent_Fill clone() {

        PluCurrent_Fill pluClone = new PluCurrent_Fill();
        pluClone.assortment_level = this.assortment_level;
        pluClone.plu = this.plu;
        pluClone.macro_code = this.macro_code;
        pluClone.assortment_cluster = this.assortment_cluster;
        pluClone.version = this.version;
        pluClone.necessarily_code = this.necessarily_code;
        pluClone.partly_through = this.partly_through;
        pluClone.cluster_id = this.cluster_id;
        pluClone.can_be_through_plu = this.can_be_through_plu;
        pluClone.through_plu_part = this.through_plu_part;
        pluClone.through = this.through;
        pluClone.can_be_through_plu_part = this.can_be_through_plu_part;
        pluClone.assortment_id = this.assortment_id;
        return pluClone;
    }
}
