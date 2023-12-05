package com.omfys.bsat.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "BPIL_PRODUCT_MASTER_DEMO")
public class ProductMasterDemo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bpil_product_master_demo_seq")
	@SequenceGenerator(name = "bpil_product_master_demo_seq", sequenceName = "BPIL_PRODUCT_MASTER_DEMO_S", allocationSize = 1)

	@Column(name = "PRODUCT_ID")
	private int product_id;

	@Column(name = "PRODUCT")
	private String product;

	@Column(name = "PRODUCT_DESC")
	private String product_desc;

	@Column(name = "PRODUCT_CODE")
	private String product_code;

	@Column(name = "PRODUCT_GROUP")
	private String product_group;

	@Column(name = "PRODUCT_CAT")
	private String product_cat;

	@Column(name = "PRODUCT_CAT_DESC")
	private String product_cat_desc;

	@Column(name = "PACK_SIZE")
	private int pack_size;

	@Column(name = "CREATION_DATE")
	private Date creation_date;

	@Column(name = "LAST_UPDATED_DATE")
	private Date last_updated_date;

	@Override
	public String toString() {
		return "ProductMasterDemo [product_id=" + product_id + ", product=" + product + ", product_desc=" + product_desc
				+ ", product_code=" + product_code + ", product_group=" + product_group + ", product_cat=" + product_cat
				+ ", product_cat_desc=" + product_cat_desc + ", pack_size=" + pack_size + ", creation_date="
				+ creation_date + ", last_updated_date=" + last_updated_date + "]";
	}

	public ProductMasterDemo(int product_id, String product, String product_desc, String product_code,
			String product_group, String product_cat, String product_cat_desc, int pack_size, Date creation_date,
			Date last_updated_date) {
		super();
		this.product_id = product_id;
		this.product = product;
		this.product_desc = product_desc;
		this.product_code = product_code;
		this.product_group = product_group;
		this.product_cat = product_cat;
		this.product_cat_desc = product_cat_desc;
		this.pack_size = pack_size;
		this.creation_date = creation_date;
		this.last_updated_date = last_updated_date;
	}

	public ProductMasterDemo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
