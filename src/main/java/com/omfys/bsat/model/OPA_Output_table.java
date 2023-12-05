package com.omfys.bsat.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "BPIL_OPA_SCH_ANALYSIS_TBL")
public class OPA_Output_table {


	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="course_seq")
	@SequenceGenerator(name="course_seq", sequenceName="BPIL_SCH_OPA_OUTPUT_S", allocationSize=1)
	
	@Column(name = "SCHEME_OUTPUT_ID")
	private int scheme_output_id;
	
	@Column(name = "SCHEME_ID")
	private int scheme_id;
	
	@Column(name = "SCHEME_CODE")
	private String scheme_code;
	
	@Column(name = "SCH_REWARD_TYPE")
	private String sch_reward_type;
	
	@Column(name = "SCH_REGN")
	private String sch_regn;
	
	@Column(name = "SCH_DEPOT")
	private String sch_depot;
	
	@Column(name = "SCH_TERR")
	private String sch_terr;
	
	@Column(name = "SCH_TERR_NAME")
	private String sch_terr_name;
	
	@Column(name = "SCH_DLR_CODE")
	private String sch_dlr_code;
		
	@Column(name = "SCH_DLR_NAME")
	private String sch_dlr_name;
	
	@Column(name = "SCH_DLR_CAT")
	private String sch_dlr_cat;
	
	@Column(name = "SCH_DLR_BILL_TO")
	private int sch_dlr_bill_to;
	
	@Column(name = "SCH_DLR_TYPE")
	private int sch_dlr_type;
			
	@Column(name = "LY_VOLUME")
	private int ly_volume;
	
	@Column(name = "LY_VALUE")
	private int ly_value;
	
	@Column(name = "LLY_VOLUME")
	private int lly_volume;
	
	@Column(name = "LLY_VALUE")
	private int lly_value;
	
	@Column(name = "TY_VOLUME")
	private int ty_volume;
	
	@Column(name = "TY_VALUE")
	private int ty_value;
	
	@Column(name = "SCH_TGT_GRW_PCT")
	private int sch_tgt_grw_pct;
	
	@Column(name = "SCH_ACT_GRW_PCT")
	private int sch_act_grw_pct;
	
	@Column(name = "PART1_VOLUME")
	private int part1_volume;
	
	@Column(name = "PART1_VALUE")
	private int part1_value;
	
	@Column(name = "PART1_EXT_VOL")
	private int part1_ext_vol;
	
	@Column(name = "PART1_EXT_VAL")
	private int part1_ext_val;
	
	@Column(name = "PART2_VOLUME")
	private int part2_volume;
	
	@Column(name = "PART2_VALUE")
	private int part2_value;

	@Column(name = "PART2_EXT_VOL")
	private int part2_ext_vol;
	
	@Column(name = "PART2_EXT_VAL")
	private int part2_ext_val;

	@Column(name = "LYTY")
	private int lyty;
	
	@Column(name = "PART1_CN_PTS")
	private int part1_cn_pts;
	
	@Column(name = "PART1_GIFT_CNT")
	private int part1_gift_cnt;
	
	@Column(name = "PART2_CN_PTS")
	private int part2_cn_pts;
	
	@Column(name = "PART2_GIFT_CNT")
	private int part2_gift_cnt;
	
	@Column(name = "SCH_TOT_CN_PTS")
	private int sch_tot_cn_pts;

	@Column(name = "SCH_ADJ_PTS")
	private int sch_adj_pts;
	
	@Column(name = "SCH_ADJ_REASON")
	private String sch_adj_reason;
	
	@Column(name = "SCH_STATUS")
	private String  sch_status;
	
	@Column(name = "ATTRIBUTE1")
	private String  attribute1;
	
	@Column(name = "COMMENTS")
	private String  comments;	
	
	@Column(name = "CREATED_BY")
	private int created_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "CREATION_DATE" , updatable = false)
	private Date creation_date= new java.sql.Date(new java.util.Date().getTime());

	@Column(name = "LAST_UPDATED_BY")
	private int last_updated_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "LAST_UPDATE_DATE" , updatable = true)
	private Date last_update_date= new java.sql.Date(new java.util.Date().getTime());
	
}
