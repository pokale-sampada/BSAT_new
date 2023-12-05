package com.omfys.bsat.repositoryImpl;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.omfys.bsat.repository.SchemeRequestDao;
import com.omfys.bsat.TilesConfiguration;
import com.omfys.bsat.model.Bpil_Gift_Master;
import com.omfys.bsat.model.Bpil_Opa_Rw_Analysis_Rw;
import com.omfys.bsat.model.Bpil_Product_mstr;
import com.omfys.bsat.model.Bpil_ReportGroup;
import com.omfys.bsat.model.Bpil_Scheme_Benefit;
import com.omfys.bsat.model.Bpil_Scheme_Cust_Types;
import com.omfys.bsat.model.Bpil_Scheme_Doc;
import com.omfys.bsat.model.Bpil_Scheme_IT_Product;
import com.omfys.bsat.model.Bpil_Scheme_Product;
import com.omfys.bsat.model.Bpil_Scheme_Product_Outflow;
import com.omfys.bsat.model.Crm_Bpil_Scheme_Doc;
import com.omfys.bsat.model.New_Scheme_mstr;
import com.omfys.bsat.model.New_Scheme_mstr_for_Crm;

import oracle.jdbc.OracleTypes;

@Repository("SchemeRequestDao")
public class SchemeRequestDaoImpl implements SchemeRequestDao{


	@Autowired
	HibernateTemplate hibernatetemplate;

	@Autowired
	private TilesConfiguration hibernateConfiguration;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public int saveheader(New_Scheme_mstr new_scheme)
	{
		hibernatetemplate.saveOrUpdate(new_scheme);
		
		return new_scheme.getScheme_id();
	}
	
	@Transactional
	public int crmsaveheader(New_Scheme_mstr_for_Crm new_scheme)
	{
		hibernatetemplate.saveOrUpdate(new_scheme);
		
		return new_scheme.getScheme_id();
	}
	
	@Transactional
	public int savedocs(Bpil_Scheme_Doc docs)
	{
			hibernatetemplate.saveOrUpdate(docs);
		
			return docs.getScheme_doc_id();
	}
	
	@Transactional
	public int crmsavedocs(Crm_Bpil_Scheme_Doc docs)
	{
			hibernatetemplate.saveOrUpdate(docs);
		
			return docs.getScheme_doc_id();
	}
	
	@Transactional
	public int saverwdocs(Bpil_Opa_Rw_Analysis_Rw rw1)
	{
			hibernatetemplate.saveOrUpdate(rw1);
		
			return rw1.getOpa_analysis_id();
	}
	
	//product
	public int saveproduct(int len1,int new_scheme_id,String[] sch_prd_unique_id,String[] sch_prd_line_type,String[] sch_product_id,
			String[] sch_prd_exceptions,String[] vol_grwth_pct,String[] val_grwth_pct,String[] spread_pct,String[] spend_per_ltr)
	{				
		int infonum=0;		
		
		for(int i=0;i<len1;i++)
		{
				
			Bpil_Scheme_Product dml =new Bpil_Scheme_Product();
			
			if(sch_prd_unique_id[i].length()>0 && sch_prd_unique_id[i]!=null)
			{
				infonum = Integer.parseInt(sch_prd_unique_id[i]);
			}
			else
			{
				infonum = dml.getSch_prd_unique_id();
			}
						
			dml.setScheme_id(new_scheme_id);
			dml.setSch_prd_unique_id(infonum);
			
//			if(sch_product_id[i].length()>0 && sch_product_id[i]!=null){
//				dml.setSch_product_code(sch_product_id[i]);
//			}
			if(sch_prd_line_type[i].length()>0 && sch_prd_line_type[i]!=null){
				dml.setSch_prd_line_type(sch_prd_line_type[i]);
			}
			if(sch_product_id[i].length()>0 && sch_product_id[i]!=null){
				dml.setSch_prd_value(sch_product_id[i]);
			}
			if(sch_prd_exceptions[i].length()>0 && sch_prd_exceptions[i]!=null){
				dml.setSch_prd_exceptions(sch_prd_exceptions[i]);
			}
			if(vol_grwth_pct[i].length()>0 && vol_grwth_pct[i]!=null){
				dml.setVol_grwth_pct(Float.parseFloat(vol_grwth_pct[i]));
			}
			if(val_grwth_pct[i].length()>0 && val_grwth_pct[i]!=null){
				dml.setVal_grwth_pct(Float.parseFloat(val_grwth_pct[i]));
			}
			if(spread_pct[i].length()>0 && spread_pct[i]!=null){
				dml.setSpread_pct(Float.parseFloat(spread_pct[i]));
			}
			if(spend_per_ltr[i].length()>0 && spend_per_ltr[i]!=null){
				dml.setSpend_per_ltr(Float.parseFloat(spend_per_ltr[i]));
			}
			
			dml.setLast_update_date(new Date());
			 hibernatetemplate.saveOrUpdate(dml);						 
				 
		}		
		
		return 1;
	}
	
//rewards
	@Transactional
	public int savegift(int user_id,int new_scheme_id,int len,String[] sche_code, String[] gift_id,String[] gift_group,
			String[] gift_name,String[] effective_price)
	{
		int infonum=0;		
		
		for(int i=0;i<len;i++)
		{
			if(gift_name[i] != null && gift_name[i] != "") {
			Bpil_Scheme_Benefit bgm = new Bpil_Scheme_Benefit();
			
			if(gift_id[i].length()>0 && gift_id[i]!=null)
			{
				infonum = Integer.parseInt(gift_id[i]);
			}
			else
			{
				infonum = bgm.getSch_details_id();
			}
			
			bgm.setScheme_id(new_scheme_id);
			bgm.setSch_details_id(infonum);
			
			if(sche_code[i].length()>0 && sche_code[i]!=null){
					bgm.setSch_gift_code(sche_code[i]);
			}
			if(gift_name[i].length()>0 && gift_name[i]!=null){
					bgm.setGift_id(Integer.parseInt(gift_name[i]));
			}
			if(gift_group[i].length()>0 && gift_group[i]!=null){
					bgm.setGift_group(gift_group[i]);
			}
			if(effective_price[i].length()>0 && effective_price[i]!=null){
					bgm.setGift_effective_price(Float.parseFloat(effective_price[i]));
			}
			 
			bgm.setLast_update_date(new Date());
			 hibernatetemplate.saveOrUpdate(bgm);						 
				 
			}
		}		
		
		return 1;
	}
	
	@Transactional
	public int copysavegift(int user_id,int new_scheme_id,int len,String[] sche_code, String[] gift_id,String[] gift_group,
			String[] gift_name,String[] effective_price)
	{
		int infonum=0;		
		
		for(int i=0;i<len;i++)
		{
			if(gift_name[i] != null && gift_name[i] != "") {
			Bpil_Scheme_Benefit bgm = new Bpil_Scheme_Benefit();
			
			if(gift_id[i].length()>0 && gift_id[i]!=null)
			{
				infonum = Integer.parseInt(gift_id[i]);
			}
			else
			{
				infonum = bgm.getSch_details_id();
			}
			
			bgm.setScheme_id(new_scheme_id);
//			bgm.setSch_details_id(infonum);
			
			if(sche_code[i].length()>0 && sche_code[i]!=null){
					bgm.setSch_gift_code(sche_code[i]);
			}
			if(gift_name[i].length()>0 && gift_name[i]!=null){
					bgm.setGift_id(Integer.parseInt(gift_name[i]));
			}
			if(gift_group[i].length()>0 && gift_group[i]!=null){
					bgm.setGift_group(gift_group[i]);
			}
			if(effective_price[i].length()>0 && effective_price[i]!=null){
					bgm.setGift_effective_price(Float.parseFloat(effective_price[i]));
			}
			 
			bgm.setLast_update_date(new Date());
			 hibernatetemplate.saveOrUpdate(bgm);						 
				 
			}
		}		
		
		return 1;
	}

	@Override
	public int saveitproduct(int len1, int new_scheme_id, String[] sch_it_prd_dtls_id, String[] sch_prd_code,
			String[] sch_prd_grp, String[] sch_prd_cat, String[] sch_prd_cat_desc) {
		// TODO Auto-generated method stub
		
		 int infonum=0;		
		
		for(int i=0;i<len1;i++)
		{
				
			Bpil_Scheme_IT_Product dml =new Bpil_Scheme_IT_Product();
			
			if(sch_it_prd_dtls_id[i].length()>0 && sch_it_prd_dtls_id[i]!=null)
			{
				infonum = Integer.parseInt(sch_it_prd_dtls_id[i]);
			}
			else
			{
				infonum = dml.getSch_it_prd_dtls_id();
			}
						
			dml.setScheme_id(new_scheme_id);
			dml.setSch_it_prd_dtls_id(infonum);
			
//			if(sch_product_id[i].length()>0 && sch_product_id[i]!=null){
//				dml.setSch_product_code(sch_product_id[i]);
//			}
			
			if(i==0) {
				if(sch_prd_code[i].equals("All")) {
					
				} else {
					if(sch_prd_code[i].length()>0 && sch_prd_code[i]!=null){
						dml.setSch_prd_code(sch_prd_code[i]);
					}
					if(sch_prd_grp[i].length()>0 && sch_prd_grp[i]!=null){
						dml.setSch_prd_grp(sch_prd_grp[i]);
					}
					if(sch_prd_cat[i].length()>0 && sch_prd_cat[i]!=null){
						dml.setSch_prd_cat(sch_prd_cat[i]);
					}
					if(sch_prd_cat_desc[i].length()>0 && sch_prd_cat_desc[i]!=null){
						dml.setSch_prd_cat_desc(sch_prd_cat_desc[i]);
					}
				}
			}
			else {
				if(sch_prd_code[i].length()>0 && sch_prd_code[i]!=null){
					dml.setSch_prd_code(sch_prd_code[i]);
				}
				if(sch_prd_grp[i].length()>0 && sch_prd_grp[i]!=null){
					dml.setSch_prd_grp(sch_prd_grp[i]);
				}
				if(sch_prd_cat[i].length()>0 && sch_prd_cat[i]!=null){
					dml.setSch_prd_cat(sch_prd_cat[i]);
				}
				if(sch_prd_cat_desc[i].length()>0 && sch_prd_cat_desc[i]!=null){
					dml.setSch_prd_cat_desc(sch_prd_cat_desc[i]);
				}
			}
			
			dml.setLast_update_date(new Date());
			 hibernatetemplate.saveOrUpdate(dml);						 
				 
		}		
		
		return 1;
	}

	

	@Override
	public int savecust_type(int custlen, String[] cust_type, int new_scheme_id) {
		// TODO Auto-generated method stub
		
		String delete = "Delete from BPIL_SCHEME_CUST_TYPES where SCHEME_ID = "+new_scheme_id;
		 
		 jdbcTemplate.update(delete);
		 
		 System.out.println("kkkkkkkkkkkkkkkkkkkkkkjjjjjjjjjjjjjjjjjj");

		int infonum=0;		
		
		for(int i=0;i<custlen;i++)
		{
			 System.out.println("kkkkkkkkkkkkkk              jjjjjjjjj");
			Bpil_Scheme_Cust_Types dml =new Bpil_Scheme_Cust_Types();
			
//			if(sch_it_prd_dtls_id[i].length()>0 && sch_it_prd_dtls_id[i]!=null)
//			{
//				infonum = Integer.parseInt(sch_it_prd_dtls_id[i]);
//			}
//			else
//			{
				infonum = dml.getScheme_cust_type_id();
//			}
						
			dml.setScheme_id(new_scheme_id);
			dml.setScheme_cust_type_id(infonum);
			
			if(cust_type[i].length()>0 && cust_type[i]!=null){
				dml.setCust_type(cust_type[i]);
				
				 System.out.println("k                           j");
				
				if(cust_type[i].equals("15")) {
					dml.setDescription("Prolinks-Industrial");
				} 
				else
				if(cust_type[i].equals("3")) {
					dml.setDescription("Ultratech Dealer");
				}
				else
				if(cust_type[i].equals("4")) {
					dml.setDescription("Prolinks Dealer");
				}
				else
				if(cust_type[i].equals("5")) {
					dml.setDescription("Dealer");
				}
				else
				if(cust_type[i].equals("54")) {
					dml.setDescription("Retail Special Dealer");
				}
				else
				if(cust_type[i].equals("55")) {
					dml.setDescription("Retail Site Operations");
				}
				else
				if(cust_type[i].equals("56")) {
					dml.setDescription("Non Paint Dealer - CC");
				}
				else
				if(cust_type[i].equals("57")) {
					dml.setDescription("PXT Dealer");
				}
				else
				if(cust_type[i].equals("58")) {
					dml.setDescription("Distributor - Retail");
				}
				else
				if(cust_type[i].equals("6")) {
					dml.setDescription("Contractor");
				}
				else
				if(cust_type[i].equals("65")) {
					dml.setDescription("Retail Projects Strong");
				}
				else
				if(cust_type[i].equals("66")) {
					dml.setDescription("Prolinks Special Dealer");
				}
				else
				if(cust_type[i].equals("7")) {
					dml.setDescription("Alternate Distribution");
				}
				else
				if(cust_type[i].equals("53")) {
					dml.setDescription("Wholesaler");
				}
			}
			 System.out.println("              -----------))))))))"+dml.toString());
			 hibernatetemplate.saveOrUpdate(dml);	
			 System.out.println("                -=====================");
		}
		
		return 1;
	}

	@Override
	public int saveproductoutflow(int len1, int new_scheme_id, String[] sch_prd_outflow_unique_id,
			String[] sch_prd_outflow_line_type, String[] sch_product_outflow_id, 
			String[] sch_prd_lly_vol, String[] sch_prd_lly_val, String[] sch_prd_ly_vol, String[] sch_prd_ly_val, 
			String[] sch_prd_spread_tgt_vol, String[] sch_prd_spread_tgt_val, 
			String[] sch_prd_spread_mtd_ly_vol, String[] sch_prd_spread_mtd_ly_val,
			String[] proj_grwth_vol_pct, String[] proj_grwth_val_pct, String[] proj_grwth_spd_pct,
			String[] sch_prd_ty_vol, String[] sch_prd_ty_val, 
			String[] sch_prd_spread_mtd_ty_tgt_vol, String[] sch_prd_spread_mtd_ty_tgt_val,
			String[] sch_prd_wt_avg, String[] sch_prd_total_prd_bdgt) {
		// TODO Auto-generated method stub
		
		int infonum=0;		
		
		for(int i=0;i<len1;i++)
		{
				
			Bpil_Scheme_Product_Outflow dml =new Bpil_Scheme_Product_Outflow();
			
			if(sch_prd_outflow_unique_id[i].length()>0 && sch_prd_outflow_unique_id[i]!=null)
			{
				infonum = Integer.parseInt(sch_prd_outflow_unique_id[i]);
			}
			else
			{
				infonum = dml.getSch_prd_outflow_unique_id();
			}
						
			dml.setScheme_id(new_scheme_id);
			dml.setSch_prd_outflow_unique_id(infonum);
			
//			if(sch_product_id[i].length()>0 && sch_product_id[i]!=null){
//				dml.setSch_product_code(sch_product_id[i]);
//			}
			if(sch_prd_outflow_line_type[i].length()>0 && sch_prd_outflow_line_type[i]!=null){
				dml.setSch_prd_line_type(sch_prd_outflow_line_type[i]);
			}
			if(sch_product_outflow_id[i].length()>0 && sch_product_outflow_id[i]!=null){
				dml.setSch_prd_value(sch_product_outflow_id[i]);
			}
			if(sch_prd_lly_vol[i].length()>0 && sch_prd_lly_vol[i]!=null){
				dml.setLly_vol(Float.parseFloat(sch_prd_lly_vol[i]));
			}
			if(sch_prd_lly_val[i].length()>0 && sch_prd_lly_val[i]!=null){
				dml.setLly_val(Float.parseFloat(sch_prd_lly_val[i]));
			}
			if(sch_prd_ly_vol[i].length()>0 && sch_prd_ly_vol[i]!=null){
				dml.setLy_vol(Float.parseFloat(sch_prd_ly_vol[i]));
			}
			if(sch_prd_ly_val[i].length()>0 && sch_prd_ly_val[i]!=null){
				dml.setLy_val(Float.parseFloat(sch_prd_ly_val[i]));
			}
			if(sch_prd_spread_tgt_vol[i].length()>0 && sch_prd_spread_tgt_vol[i]!=null){
				dml.setSpread_tgt_vol(Float.parseFloat(sch_prd_spread_tgt_vol[i]));
			}
			if(sch_prd_spread_tgt_val[i].length()>0 && sch_prd_spread_tgt_val[i]!=null){
				dml.setSpread_tgt_val(Float.parseFloat(sch_prd_spread_tgt_val[i]));
			}
			if(sch_prd_spread_mtd_ly_vol[i].length()>0 && sch_prd_spread_mtd_ly_vol[i]!=null){
				dml.setSpread_mtd_ly_vol(Integer.parseInt(sch_prd_spread_mtd_ly_vol[i]));
			}
			if(sch_prd_spread_mtd_ly_val[i].length()>0 && sch_prd_spread_mtd_ly_val[i]!=null){
				dml.setSpread_mtd_ly_val(Integer.parseInt(sch_prd_spread_mtd_ly_val[i]));
			}
			if(proj_grwth_vol_pct[i].length()>0 && proj_grwth_vol_pct[i]!=null){
				dml.setProj_grwth_vol_pct(Float.parseFloat(proj_grwth_vol_pct[i]));
			}
			if(proj_grwth_val_pct[i].length()>0 && proj_grwth_val_pct[i]!=null){
				dml.setProj_grwth_val_pct(Float.parseFloat(proj_grwth_val_pct[i]));
			}
			if(proj_grwth_spd_pct[i].length()>0 && proj_grwth_spd_pct[i]!=null){
				dml.setProj_grwth_spd_pct(Float.parseFloat(proj_grwth_spd_pct[i]));
			}
			if(sch_prd_ty_vol[i].length()>0 && sch_prd_ty_vol[i]!=null){
				dml.setProj_ty_vol(Float.parseFloat(sch_prd_ty_vol[i]));
			}
			if(sch_prd_ty_val[i].length()>0 && sch_prd_ty_val[i]!=null){
				dml.setProj_ty_val(Float.parseFloat(sch_prd_ty_val[i]));
			}
			if(sch_prd_spread_mtd_ty_tgt_vol[i].length()>0 && sch_prd_spread_mtd_ty_tgt_vol[i]!=null){
				dml.setSpread_mtd_ty_tgt_vol(Integer.parseInt(sch_prd_spread_mtd_ty_tgt_vol[i]));
			}
			if(sch_prd_spread_mtd_ty_tgt_val[i].length()>0 && sch_prd_spread_mtd_ty_tgt_val[i]!=null){
				dml.setSpread_mtd_ty_tgt_val(Integer.parseInt(sch_prd_spread_mtd_ty_tgt_val[i]));
			}
			if(sch_prd_wt_avg[i].length()>0 && sch_prd_wt_avg[i]!=null){
				dml.setWt_avg(Float.parseFloat(sch_prd_wt_avg[i]));
			}
			if(sch_prd_total_prd_bdgt[i].length()>0 && sch_prd_total_prd_bdgt[i]!=null){
				dml.setTotal_prd_bdgt(Float.parseFloat(sch_prd_total_prd_bdgt[i]));
			}
			
			dml.setLast_update_date(new Date());
			 hibernatetemplate.saveOrUpdate(dml);						 
				 
		}		
		
		return 1;
		
	}
	
	@Override
	public int copysaveproductoutflow(int len1, int new_scheme_id, String[] sch_prd_outflow_unique_id,
			String[] sch_prd_outflow_line_type, String[] sch_product_outflow_id, 
			String[] sch_prd_lly_vol, String[] sch_prd_lly_val, String[] sch_prd_ly_vol, String[] sch_prd_ly_val, 
			String[] sch_prd_spread_tgt_vol, String[] sch_prd_spread_tgt_val, 
			String[] sch_prd_spread_mtd_ly_vol, String[] sch_prd_spread_mtd_ly_val,
			String[] proj_grwth_vol_pct, String[] proj_grwth_val_pct, String[] proj_grwth_spd_pct,
			String[] sch_prd_ty_vol, String[] sch_prd_ty_val, 
			String[] sch_prd_spread_mtd_ty_tgt_vol, String[] sch_prd_spread_mtd_ty_tgt_val,
			String[] sch_prd_wt_avg, String[] sch_prd_total_prd_bdgt) {
		// TODO Auto-generated method stub
		
		int infonum=0;		
		
		for(int i=0;i<len1;i++)
		{
				
			Bpil_Scheme_Product_Outflow dml =new Bpil_Scheme_Product_Outflow();
			
			if(sch_prd_outflow_unique_id[i].length()>0 && sch_prd_outflow_unique_id[i]!=null)
			{
				infonum = Integer.parseInt(sch_prd_outflow_unique_id[i]);
			}
			else
			{
				infonum = dml.getSch_prd_outflow_unique_id();
			}
						
			dml.setScheme_id(new_scheme_id);
//			dml.setSch_prd_outflow_unique_id(infonum);
			
//			if(sch_product_id[i].length()>0 && sch_product_id[i]!=null){
//				dml.setSch_product_code(sch_product_id[i]);
//			}
			if(sch_prd_outflow_line_type[i].length()>0 && sch_prd_outflow_line_type[i]!=null){
				dml.setSch_prd_line_type(sch_prd_outflow_line_type[i]);
			}
			if(sch_product_outflow_id[i].length()>0 && sch_product_outflow_id[i]!=null){
				dml.setSch_prd_value(sch_product_outflow_id[i]);
			}
			if(sch_prd_lly_vol[i].length()>0 && sch_prd_lly_vol[i]!=null){
				dml.setLly_vol(Float.parseFloat(sch_prd_lly_vol[i]));
			}
			if(sch_prd_lly_val[i].length()>0 && sch_prd_lly_val[i]!=null){
				dml.setLly_val(Float.parseFloat(sch_prd_lly_val[i]));
			}
			if(sch_prd_ly_vol[i].length()>0 && sch_prd_ly_vol[i]!=null){
				dml.setLy_vol(Float.parseFloat(sch_prd_ly_vol[i]));
			}
			if(sch_prd_ly_val[i].length()>0 && sch_prd_ly_val[i]!=null){
				dml.setLy_val(Float.parseFloat(sch_prd_ly_val[i]));
			}
			if(sch_prd_spread_tgt_vol[i].length()>0 && sch_prd_spread_tgt_vol[i]!=null){
				dml.setSpread_tgt_vol(Float.parseFloat(sch_prd_spread_tgt_vol[i]));
			}
			if(sch_prd_spread_tgt_val[i].length()>0 && sch_prd_spread_tgt_val[i]!=null){
				dml.setSpread_tgt_val(Float.parseFloat(sch_prd_spread_tgt_val[i]));
			}
			if(sch_prd_spread_mtd_ly_vol[i].length()>0 && sch_prd_spread_mtd_ly_vol[i]!=null){
				dml.setSpread_mtd_ly_vol(Integer.parseInt(sch_prd_spread_mtd_ly_vol[i]));
			}
			if(sch_prd_spread_mtd_ly_val[i].length()>0 && sch_prd_spread_mtd_ly_val[i]!=null){
				dml.setSpread_mtd_ly_val(Integer.parseInt(sch_prd_spread_mtd_ly_val[i]));
			}
			if(proj_grwth_vol_pct[i].length()>0 && proj_grwth_vol_pct[i]!=null){
				dml.setProj_grwth_vol_pct(Float.parseFloat(proj_grwth_vol_pct[i]));
			}
			if(proj_grwth_val_pct[i].length()>0 && proj_grwth_val_pct[i]!=null){
				dml.setProj_grwth_val_pct(Float.parseFloat(proj_grwth_val_pct[i]));
			}
			if(proj_grwth_spd_pct[i].length()>0 && proj_grwth_spd_pct[i]!=null){
				dml.setProj_grwth_spd_pct(Float.parseFloat(proj_grwth_spd_pct[i]));
			}
			if(sch_prd_ty_vol[i].length()>0 && sch_prd_ty_vol[i]!=null){
				dml.setProj_ty_vol(Float.parseFloat(sch_prd_ty_vol[i]));
			}
			if(sch_prd_ty_val[i].length()>0 && sch_prd_ty_val[i]!=null){
				dml.setProj_ty_val(Float.parseFloat(sch_prd_ty_val[i]));
			}
			if(sch_prd_spread_mtd_ty_tgt_vol[i].length()>0 && sch_prd_spread_mtd_ty_tgt_vol[i]!=null){
				dml.setSpread_mtd_ty_tgt_vol(Integer.parseInt(sch_prd_spread_mtd_ty_tgt_vol[i]));
			}
			if(sch_prd_spread_mtd_ty_tgt_val[i].length()>0 && sch_prd_spread_mtd_ty_tgt_val[i]!=null){
				dml.setSpread_mtd_ty_tgt_val(Integer.parseInt(sch_prd_spread_mtd_ty_tgt_val[i]));
			}
			if(sch_prd_wt_avg[i].length()>0 && sch_prd_wt_avg[i]!=null){
				dml.setWt_avg(Float.parseFloat(sch_prd_wt_avg[i]));
			}
			if(sch_prd_total_prd_bdgt[i].length()>0 && sch_prd_total_prd_bdgt[i]!=null){
				dml.setTotal_prd_bdgt(Float.parseFloat(sch_prd_total_prd_bdgt[i]));
			}
			
			dml.setLast_update_date(new Date());
			 hibernatetemplate.saveOrUpdate(dml);						 
				 
		}		
		
		return 1;
		
	}
}
