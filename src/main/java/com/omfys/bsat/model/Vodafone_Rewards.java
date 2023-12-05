package com.omfys.bsat.model;

import java.io.Serializable;

public class Vodafone_Rewards implements Serializable {

	private int rw_id;
	private String range;
	private String circle;
	private String emp_name;
	private int emp_code;
	private String role;
	private String emp_status;
	private String month;
	private int target_payout;

	// p1
	private int p1_monthly_tgt;
	private int p1_monthly_ach;
	private float p1_cum_tgt;
	private float p1_cum_ach;
	private float p1_monthly_ach_per;
	private float p1_cum_ach_per;
	private float p1_mtd;
	private float p1_ytd;
	private float p1_weightage;

	// p2 mobility
	private int p2_mb_monthly_tgt;
	private int p2_mb_monthly_ach;
	private float p2_mb_cum_tgt;
	private float p2_mb_cum_ach;
	private float p2_mb_monthly_ach_per;
	private float p2_mb_cum_ach_per;

	// p2 FLD
	private int p2_fld_monthly_tgt;
	private int p2_fld_monthly_ach;
	private float p2_fld_cum_tgt;
	private float p2_fld_cum_ach;
	private float p2_fld_monthly_ach_per;
	private float p2_fld_cum_ach_per;

	// p2 FLV
	private int p2_flv_monthly_tgt;
	private int p2_flv_monthly_ach;
	private float p2_flv_cum_tgt;
	private float p2_flv_cum_ach;
	private float p2_flv_monthly_ach_per;
	private float p2_flv_cum_ach_per;

	// p2 FLV
	private int p2_iot_monthly_tgt;
	private int p2_iot_monthly_ach;
	private float p2_iot_cum_tgt;
	private float p2_iot_cum_ach;
	private float p2_iot_monthly_ach_per;
	private float p2_iot_cum_ach_per;

	// p2 cloud
	private int p2_cloud_monthly_tgt;
	private int p2_cloud_monthly_ach;
	private float p2_cloud_cum_tgt;
	private float p2_cloud_cum_ach;
	private float p2_cloud_monthly_ach_per;
	private float p2_cloud_cum_ach_per;

	// p2 total
	private float p2_monthly_ach;
	private float p2_cum_ach;
	private float p2_mtd;
	private float p2_ytd;
	private float p2_weightage;

	// p3 segment1
	private int p3_seg1_monthly_tgt;
	private int p3_seg1_monthly_ach;
	private float p3_seg1_cum_tgt;
	private float p3_seg1_cum_ach;
	private float p3_seg1_monthly_ach_per;
	private float p3_seg1_cum_ach_per;

	// p3 segment2
	private int p3_seg2_monthly_tgt;
	private int p3_seg2_monthly_ach;
	private float p3_seg2_cum_tgt;
	private float p3_seg2_cum_ach;
	private float p3_seg2_monthly_ach_per;
	private float p3_seg2_cum_ach_per;

	// p3 total
	private float p3_monthly_ach;
	private float p3_cum_ach;
	private float p3_mtd;
	private float p3_ytd;
	private float p3_weightage;

	private float overall_ach;

	private int p1_qtd_payout;
	private int p1_ytd_payout;
	private int p2_qtd_payout;
	private int p2_ytd_payout;
	private int p3_qtd_payout;
	private int p3_ytd_payout;

	private int total_payout_sip;
	private int final_payout_amt;

	public int getRw_id() {
		return rw_id;
	}

	public void setRw_id(int rw_id) {
		this.rw_id = rw_id;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public String getCircle() {
		return circle;
	}

	public void setCircle(String circle) {
		this.circle = circle;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public int getEmp_code() {
		return emp_code;
	}

	public void setEmp_code(int emp_code) {
		this.emp_code = emp_code;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmp_status() {
		return emp_status;
	}

	public void setEmp_status(String emp_status) {
		this.emp_status = emp_status;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getTarget_payout() {
		return target_payout;
	}

	public void setTarget_payout(int target_payout) {
		this.target_payout = target_payout;
	}

	public int getP1_monthly_tgt() {
		return p1_monthly_tgt;
	}

	public void setP1_monthly_tgt(int p1_monthly_tgt) {
		this.p1_monthly_tgt = p1_monthly_tgt;
	}

	public int getP1_monthly_ach() {
		return p1_monthly_ach;
	}

	public void setP1_monthly_ach(int p1_monthly_ach) {
		this.p1_monthly_ach = p1_monthly_ach;
	}

	public float getP1_cum_tgt() {
		return p1_cum_tgt;
	}

	public void setP1_cum_tgt(float p1_cum_tgt) {
		this.p1_cum_tgt = p1_cum_tgt;
	}

	public float getP1_cum_ach() {
		return p1_cum_ach;
	}

	public void setP1_cum_ach(float p1_cum_ach) {
		this.p1_cum_ach = p1_cum_ach;
	}

	public float getP1_monthly_ach_per() {
		return p1_monthly_ach_per;
	}

	public void setP1_monthly_ach_per(float p1_monthly_ach_per) {
		this.p1_monthly_ach_per = p1_monthly_ach_per;
	}

	public float getP1_cum_ach_per() {
		return p1_cum_ach_per;
	}

	public void setP1_cum_ach_per(float p1_cum_ach_per) {
		this.p1_cum_ach_per = p1_cum_ach_per;
	}

	public float getP1_mtd() {
		return p1_mtd;
	}

	public void setP1_mtd(float p1_mtd) {
		this.p1_mtd = p1_mtd;
	}

	public float getP1_ytd() {
		return p1_ytd;
	}

	public void setP1_ytd(float p1_ytd) {
		this.p1_ytd = p1_ytd;
	}

	public float getP1_weightage() {
		return p1_weightage;
	}

	public void setP1_weightage(float p1_weightage) {
		this.p1_weightage = p1_weightage;
	}

	public int getP2_mb_monthly_tgt() {
		return p2_mb_monthly_tgt;
	}

	public void setP2_mb_monthly_tgt(int p2_mb_monthly_tgt) {
		this.p2_mb_monthly_tgt = p2_mb_monthly_tgt;
	}

	public int getP2_mb_monthly_ach() {
		return p2_mb_monthly_ach;
	}

	public void setP2_mb_monthly_ach(int p2_mb_monthly_ach) {
		this.p2_mb_monthly_ach = p2_mb_monthly_ach;
	}

	public float getP2_mb_cum_tgt() {
		return p2_mb_cum_tgt;
	}

	public void setP2_mb_cum_tgt(float p2_mb_cum_tgt) {
		this.p2_mb_cum_tgt = p2_mb_cum_tgt;
	}

	public float getP2_mb_cum_ach() {
		return p2_mb_cum_ach;
	}

	public void setP2_mb_cum_ach(float p2_mb_cum_ach) {
		this.p2_mb_cum_ach = p2_mb_cum_ach;
	}

	public float getP2_mb_monthly_ach_per() {
		return p2_mb_monthly_ach_per;
	}

	public void setP2_mb_monthly_ach_per(float p2_mb_monthly_ach_per) {
		this.p2_mb_monthly_ach_per = p2_mb_monthly_ach_per;
	}

	public float getP2_mb_cum_ach_per() {
		return p2_mb_cum_ach_per;
	}

	public void setP2_mb_cum_ach_per(float p2_mb_cum_ach_per) {
		this.p2_mb_cum_ach_per = p2_mb_cum_ach_per;
	}

	public int getP2_fld_monthly_tgt() {
		return p2_fld_monthly_tgt;
	}

	public void setP2_fld_monthly_tgt(int p2_fld_monthly_tgt) {
		this.p2_fld_monthly_tgt = p2_fld_monthly_tgt;
	}

	public int getP2_fld_monthly_ach() {
		return p2_fld_monthly_ach;
	}

	public void setP2_fld_monthly_ach(int p2_fld_monthly_ach) {
		this.p2_fld_monthly_ach = p2_fld_monthly_ach;
	}

	public float getP2_fld_cum_tgt() {
		return p2_fld_cum_tgt;
	}

	public void setP2_fld_cum_tgt(float p2_fld_cum_tgt) {
		this.p2_fld_cum_tgt = p2_fld_cum_tgt;
	}

	public float getP2_fld_cum_ach() {
		return p2_fld_cum_ach;
	}

	public void setP2_fld_cum_ach(float p2_fld_cum_ach) {
		this.p2_fld_cum_ach = p2_fld_cum_ach;
	}

	public float getP2_fld_monthly_ach_per() {
		return p2_fld_monthly_ach_per;
	}

	public void setP2_fld_monthly_ach_per(float p2_fld_monthly_ach_per) {
		this.p2_fld_monthly_ach_per = p2_fld_monthly_ach_per;
	}

	public float getP2_fld_cum_ach_per() {
		return p2_fld_cum_ach_per;
	}

	public void setP2_fld_cum_ach_per(float p2_fld_cum_ach_per) {
		this.p2_fld_cum_ach_per = p2_fld_cum_ach_per;
	}

	public int getP2_flv_monthly_tgt() {
		return p2_flv_monthly_tgt;
	}

	public void setP2_flv_monthly_tgt(int p2_flv_monthly_tgt) {
		this.p2_flv_monthly_tgt = p2_flv_monthly_tgt;
	}

	public int getP2_flv_monthly_ach() {
		return p2_flv_monthly_ach;
	}

	public void setP2_flv_monthly_ach(int p2_flv_monthly_ach) {
		this.p2_flv_monthly_ach = p2_flv_monthly_ach;
	}

	public float getP2_flv_cum_tgt() {
		return p2_flv_cum_tgt;
	}

	public void setP2_flv_cum_tgt(float p2_flv_cum_tgt) {
		this.p2_flv_cum_tgt = p2_flv_cum_tgt;
	}

	public float getP2_flv_cum_ach() {
		return p2_flv_cum_ach;
	}

	public void setP2_flv_cum_ach(float p2_flv_cum_ach) {
		this.p2_flv_cum_ach = p2_flv_cum_ach;
	}

	public float getP2_flv_monthly_ach_per() {
		return p2_flv_monthly_ach_per;
	}

	public void setP2_flv_monthly_ach_per(float p2_flv_monthly_ach_per) {
		this.p2_flv_monthly_ach_per = p2_flv_monthly_ach_per;
	}

	public float getP2_flv_cum_ach_per() {
		return p2_flv_cum_ach_per;
	}

	public void setP2_flv_cum_ach_per(float p2_flv_cum_ach_per) {
		this.p2_flv_cum_ach_per = p2_flv_cum_ach_per;
	}

	public int getP2_iot_monthly_tgt() {
		return p2_iot_monthly_tgt;
	}

	public void setP2_iot_monthly_tgt(int p2_iot_monthly_tgt) {
		this.p2_iot_monthly_tgt = p2_iot_monthly_tgt;
	}

	public int getP2_iot_monthly_ach() {
		return p2_iot_monthly_ach;
	}

	public void setP2_iot_monthly_ach(int p2_iot_monthly_ach) {
		this.p2_iot_monthly_ach = p2_iot_monthly_ach;
	}

	public float getP2_iot_cum_tgt() {
		return p2_iot_cum_tgt;
	}

	public void setP2_iot_cum_tgt(float p2_iot_cum_tgt) {
		this.p2_iot_cum_tgt = p2_iot_cum_tgt;
	}

	public float getP2_iot_cum_ach() {
		return p2_iot_cum_ach;
	}

	public void setP2_iot_cum_ach(float p2_iot_cum_ach) {
		this.p2_iot_cum_ach = p2_iot_cum_ach;
	}

	public float getP2_iot_monthly_ach_per() {
		return p2_iot_monthly_ach_per;
	}

	public void setP2_iot_monthly_ach_per(float p2_iot_monthly_ach_per) {
		this.p2_iot_monthly_ach_per = p2_iot_monthly_ach_per;
	}

	public float getP2_iot_cum_ach_per() {
		return p2_iot_cum_ach_per;
	}

	public void setP2_iot_cum_ach_per(float p2_iot_cum_ach_per) {
		this.p2_iot_cum_ach_per = p2_iot_cum_ach_per;
	}

	public int getP2_cloud_monthly_tgt() {
		return p2_cloud_monthly_tgt;
	}

	public void setP2_cloud_monthly_tgt(int p2_cloud_monthly_tgt) {
		this.p2_cloud_monthly_tgt = p2_cloud_monthly_tgt;
	}

	public int getP2_cloud_monthly_ach() {
		return p2_cloud_monthly_ach;
	}

	public void setP2_cloud_monthly_ach(int p2_cloud_monthly_ach) {
		this.p2_cloud_monthly_ach = p2_cloud_monthly_ach;
	}

	public float getP2_cloud_cum_tgt() {
		return p2_cloud_cum_tgt;
	}

	public void setP2_cloud_cum_tgt(float p2_cloud_cum_tgt) {
		this.p2_cloud_cum_tgt = p2_cloud_cum_tgt;
	}

	public float getP2_cloud_cum_ach() {
		return p2_cloud_cum_ach;
	}

	public void setP2_cloud_cum_ach(float p2_cloud_cum_ach) {
		this.p2_cloud_cum_ach = p2_cloud_cum_ach;
	}

	public float getP2_cloud_monthly_ach_per() {
		return p2_cloud_monthly_ach_per;
	}

	public void setP2_cloud_monthly_ach_per(float p2_cloud_monthly_ach_per) {
		this.p2_cloud_monthly_ach_per = p2_cloud_monthly_ach_per;
	}

	public float getP2_cloud_cum_ach_per() {
		return p2_cloud_cum_ach_per;
	}

	public void setP2_cloud_cum_ach_per(float p2_cloud_cum_ach_per) {
		this.p2_cloud_cum_ach_per = p2_cloud_cum_ach_per;
	}

	public float getP2_monthly_ach() {
		return p2_monthly_ach;
	}

	public void setP2_monthly_ach(float p2_monthly_ach) {
		this.p2_monthly_ach = p2_monthly_ach;
	}

	public float getP2_cum_ach() {
		return p2_cum_ach;
	}

	public void setP2_cum_ach(float p2_cum_ach) {
		this.p2_cum_ach = p2_cum_ach;
	}

	public float getP2_mtd() {
		return p2_mtd;
	}

	public void setP2_mtd(float p2_mtd) {
		this.p2_mtd = p2_mtd;
	}

	public float getP2_ytd() {
		return p2_ytd;
	}

	public void setP2_ytd(float p2_ytd) {
		this.p2_ytd = p2_ytd;
	}

	public float getP2_weightage() {
		return p2_weightage;
	}

	public void setP2_weightage(float p2_weightage) {
		this.p2_weightage = p2_weightage;
	}

	public int getP3_seg1_monthly_tgt() {
		return p3_seg1_monthly_tgt;
	}

	public void setP3_seg1_monthly_tgt(int p3_seg1_monthly_tgt) {
		this.p3_seg1_monthly_tgt = p3_seg1_monthly_tgt;
	}

	public int getP3_seg1_monthly_ach() {
		return p3_seg1_monthly_ach;
	}

	public void setP3_seg1_monthly_ach(int p3_seg1_monthly_ach) {
		this.p3_seg1_monthly_ach = p3_seg1_monthly_ach;
	}

	public float getP3_seg1_cum_tgt() {
		return p3_seg1_cum_tgt;
	}

	public void setP3_seg1_cum_tgt(float p3_seg1_cum_tgt) {
		this.p3_seg1_cum_tgt = p3_seg1_cum_tgt;
	}

	public float getP3_seg1_cum_ach() {
		return p3_seg1_cum_ach;
	}

	public void setP3_seg1_cum_ach(float p3_seg1_cum_ach) {
		this.p3_seg1_cum_ach = p3_seg1_cum_ach;
	}

	public float getP3_seg1_monthly_ach_per() {
		return p3_seg1_monthly_ach_per;
	}

	public void setP3_seg1_monthly_ach_per(float p3_seg1_monthly_ach_per) {
		this.p3_seg1_monthly_ach_per = p3_seg1_monthly_ach_per;
	}

	public float getP3_seg1_cum_ach_per() {
		return p3_seg1_cum_ach_per;
	}

	public void setP3_seg1_cum_ach_per(float p3_seg1_cum_ach_per) {
		this.p3_seg1_cum_ach_per = p3_seg1_cum_ach_per;
	}

	public int getP3_seg2_monthly_tgt() {
		return p3_seg2_monthly_tgt;
	}

	public void setP3_seg2_monthly_tgt(int p3_seg2_monthly_tgt) {
		this.p3_seg2_monthly_tgt = p3_seg2_monthly_tgt;
	}

	public int getP3_seg2_monthly_ach() {
		return p3_seg2_monthly_ach;
	}

	public void setP3_seg2_monthly_ach(int p3_seg2_monthly_ach) {
		this.p3_seg2_monthly_ach = p3_seg2_monthly_ach;
	}

	public float getP3_seg2_cum_tgt() {
		return p3_seg2_cum_tgt;
	}

	public void setP3_seg2_cum_tgt(float p3_seg2_cum_tgt) {
		this.p3_seg2_cum_tgt = p3_seg2_cum_tgt;
	}

	public float getP3_seg2_cum_ach() {
		return p3_seg2_cum_ach;
	}

	public void setP3_seg2_cum_ach(float p3_seg2_cum_ach) {
		this.p3_seg2_cum_ach = p3_seg2_cum_ach;
	}

	public float getP3_seg2_monthly_ach_per() {
		return p3_seg2_monthly_ach_per;
	}

	public void setP3_seg2_monthly_ach_per(float p3_seg2_monthly_ach_per) {
		this.p3_seg2_monthly_ach_per = p3_seg2_monthly_ach_per;
	}

	public float getP3_seg2_cum_ach_per() {
		return p3_seg2_cum_ach_per;
	}

	public void setP3_seg2_cum_ach_per(float p3_seg2_cum_ach_per) {
		this.p3_seg2_cum_ach_per = p3_seg2_cum_ach_per;
	}

	public float getP3_monthly_ach() {
		return p3_monthly_ach;
	}

	public void setP3_monthly_ach(float p3_monthly_ach) {
		this.p3_monthly_ach = p3_monthly_ach;
	}

	public float getP3_cum_ach() {
		return p3_cum_ach;
	}

	public void setP3_cum_ach(float p3_cum_ach) {
		this.p3_cum_ach = p3_cum_ach;
	}

	public float getP3_mtd() {
		return p3_mtd;
	}

	public void setP3_mtd(float p3_mtd) {
		this.p3_mtd = p3_mtd;
	}

	public float getP3_ytd() {
		return p3_ytd;
	}

	public void setP3_ytd(float p3_ytd) {
		this.p3_ytd = p3_ytd;
	}

	public float getP3_weightage() {
		return p3_weightage;
	}

	public void setP3_weightage(float p3_weightage) {
		this.p3_weightage = p3_weightage;
	}

	public float getOverall_ach() {
		return overall_ach;
	}

	public void setOverall_ach(float overall_ach) {
		this.overall_ach = overall_ach;
	}

	public int getP1_qtd_payout() {
		return p1_qtd_payout;
	}

	public void setP1_qtd_payout(int p1_qtd_payout) {
		this.p1_qtd_payout = p1_qtd_payout;
	}

	public int getP1_ytd_payout() {
		return p1_ytd_payout;
	}

	public void setP1_ytd_payout(int p1_ytd_payout) {
		this.p1_ytd_payout = p1_ytd_payout;
	}

	public int getP2_qtd_payout() {
		return p2_qtd_payout;
	}

	public void setP2_qtd_payout(int p2_qtd_payout) {
		this.p2_qtd_payout = p2_qtd_payout;
	}

	public int getP2_ytd_payout() {
		return p2_ytd_payout;
	}

	public void setP2_ytd_payout(int p2_ytd_payout) {
		this.p2_ytd_payout = p2_ytd_payout;
	}

	public int getP3_qtd_payout() {
		return p3_qtd_payout;
	}

	public void setP3_qtd_payout(int p3_qtd_payout) {
		this.p3_qtd_payout = p3_qtd_payout;
	}

	public int getP3_ytd_payout() {
		return p3_ytd_payout;
	}

	public void setP3_ytd_payout(int p3_ytd_payout) {
		this.p3_ytd_payout = p3_ytd_payout;
	}

	public int getTotal_payout_sip() {
		return total_payout_sip;
	}

	public void setTotal_payout_sip(int total_payout_sip) {
		this.total_payout_sip = total_payout_sip;
	}

	public int getFinal_payout_amt() {
		return final_payout_amt;
	}

	public void setFinal_payout_amt(int final_payout_amt) {
		this.final_payout_amt = final_payout_amt;
	}

}
