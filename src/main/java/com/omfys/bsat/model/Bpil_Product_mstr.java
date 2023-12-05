package com.omfys.bsat.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BPIL_PRODUCT_MASTER")
public class Bpil_Product_mstr {
	
	@Id
	@Column(name = "PRODUCT_ID")
	private int product_id;
	
	@Column(name = "PRODUCT")
	private String product;
	
	@Column(name = "PRD_DESC")
	private String prd_desc;	
	
	@Column(name = "PRD_CODE")
	private String prd_code;
	
	@Column(name = "SHD_CODE")
	private String shd_code;
	
	@Column(name = "PRD_UOM")
	private String prd_uom;
	
	@Column(name = "PRD_GRP")
	private String prd_grp;
	
	@Column(name = "PRD_CAT")
	private String prd_cat;
	
	@Column(name = "PRD_CAT_DESC")
	private String prd_cat_desc;
	
	@Column(name = "PRD_CBNCB")
	private String prd_cbncb ;
	
	@Column(name = "PRD_LB")
	private String prd_lb;
		
	@Column(name = "SPD_PRD_CAT")
	private String spd_prd_cat;
	
	@Column(name = "PACK_SIZE")
	private int pack_size;
	
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

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getPrd_desc() {
		return prd_desc;
	}

	public void setPrd_desc(String prd_desc) {
		this.prd_desc = prd_desc;
	}

	public String getPrd_code() {
		return prd_code;
	}

	public void setPrd_code(String prd_code) {
		this.prd_code = prd_code;
	}

	public String getShd_code() {
		return shd_code;
	}

	public void setShd_code(String shd_code) {
		this.shd_code = shd_code;
	}

	public String getPrd_uom() {
		return prd_uom;
	}

	public void setPrd_uom(String prd_uom) {
		this.prd_uom = prd_uom;
	}

	public String getPrd_grp() {
		return prd_grp;
	}

	public void setPrd_grp(String prd_grp) {
		this.prd_grp = prd_grp;
	}

	public String getPrd_cat() {
		return prd_cat;
	}

	public void setPrd_cat(String prd_cat) {
		this.prd_cat = prd_cat;
	}

	public String getPrd_cat_desc() {
		return prd_cat_desc;
	}

	public void setPrd_cat_desc(String prd_cat_desc) {
		this.prd_cat_desc = prd_cat_desc;
	}

	public String getPrd_cbncb() {
		return prd_cbncb;
	}

	public void setPrd_cbncb(String prd_cbncb) {
		this.prd_cbncb = prd_cbncb;
	}

	public String getPrd_lb() {
		return prd_lb;
	}

	public void setPrd_lb(String prd_lb) {
		this.prd_lb = prd_lb;
	}

	public String getSpd_prd_cat() {
		return spd_prd_cat;
	}

	public void setSpd_prd_cat(String spd_prd_cat) {
		this.spd_prd_cat = spd_prd_cat;
	}

	public int getPack_size() {
		return pack_size;
	}

	public void setPack_size(int pack_size) {
		this.pack_size = pack_size;
	}

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public int getLast_updated_by() {
		return last_updated_by;
	}

	public void setLast_updated_by(int last_updated_by) {
		this.last_updated_by = last_updated_by;
	}

	public Date getLast_update_date() {
		return last_update_date;
	}

	public void setLast_update_date(Date last_update_date) {
		this.last_update_date = last_update_date;
	}

	
			
}
