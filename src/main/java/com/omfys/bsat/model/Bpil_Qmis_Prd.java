package com.omfys.bsat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "BPIL_QMIS_PRD")
public class Bpil_Qmis_Prd {
	
	@Id
	@Column(name = "ML")
	private String ml;

	@Column(name = "GRP")
	private String grp;

	@Column(name = "PRODUCT")
	private String product;

	@Column(name = "BL")
	private String bl;

	@Column(name = "ML_SMRY_GRP")
	private String ml_smry_grp;

	@Column(name = "PRDKT_CATEGORY")
	private String prdkt_category;

	@Column(name = "ADV_CATEGORY")
	private String adv_category;

	@Column(name = "AGM_GRP_DESC")
	private String agm_grp_desc;

	@Column(name = "SUB_GRP")
	private String sub_grp;

	@Override
	public String toString() {
		return "Bpil_Qmis_Prd [ml=" + ml + ", grp=" + grp + ", product=" + product + ", bl=" + bl + ", ml_smry_grp="
				+ ml_smry_grp + ", prdkt_category=" + prdkt_category + ", adv_category=" + adv_category
				+ ", agm_grp_desc=" + agm_grp_desc + ", sub_grp=" + sub_grp + "]";
	}

	public Bpil_Qmis_Prd(String ml, String grp, String product, String bl, String ml_smry_grp, String prdkt_category,
			String adv_category, String agm_grp_desc, String sub_grp) {
		super();
		this.ml = ml;
		this.grp = grp;
		this.product = product;
		this.bl = bl;
		this.ml_smry_grp = ml_smry_grp;
		this.prdkt_category = prdkt_category;
		this.adv_category = adv_category;
		this.agm_grp_desc = agm_grp_desc;
		this.sub_grp = sub_grp;
	}

	public Bpil_Qmis_Prd() {
		super();
		// TODO Auto-generated constructor stub
	}

}
