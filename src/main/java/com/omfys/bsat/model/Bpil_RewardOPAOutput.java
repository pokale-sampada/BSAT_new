package com.omfys.bsat.model;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class Bpil_RewardOPAOutput {
	
	private Integer ID;
	private Integer RW_SCH_ID;
	private String RW_CODE;
	private String RW_DLR_REGN;
	private String RW_DLR_DEPOT;
	private String RW_DLR_STATE;
	private String RW_DLR_TERR_CODE;
	private String RW_DLR_TERR_NAME;
	private String RW_DLR_CODE;
	private String RW_DLR_CAT;
	private Integer RW_DLR_BILL_TO;
	private String RW_DLR_TYPE;
	private String RW_DLR_NAME;
	private String RW_SEC;
	private String RW_TYPE;
	private String RW_PRD;
	private String RW_UNIT;
	private Date RW_DATE;
	private BigDecimal RW_LY;
	private BigDecimal RW_TGT;
	private BigDecimal RW_TY;
	private BigDecimal RW_ADDITIONAL;
	private BigDecimal RW_BASE_TOTAL;
	private String RW_Q_STAT;
	private String RW_DESC;
	private BigDecimal RW_TOTAL;
	private BigDecimal RW_NXT_TGT;
	private String RW_GFT_TO_CN;
	private String RW_GFT_ID;
	private BigDecimal RW_CONV_CN;
	private String RW_I_STAT;
	private Date RW_LAST_UPDATE;
	
}
