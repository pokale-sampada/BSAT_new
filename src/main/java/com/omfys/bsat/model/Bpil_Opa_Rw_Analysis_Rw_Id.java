package com.omfys.bsat.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import lombok.Data;

@Data
@Embeddable
public class Bpil_Opa_Rw_Analysis_Rw_Id implements Serializable {

	@Column(name = "OPA_RW_AN_REWARD_ID")
	private int opa_analysis_id;

	@Column(name = "REWARD_SCHEME_ID")
	private int scheme_id;
	
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof Bpil_Opa_Rw_Analysis_Rw_Id)) return false;
	        Bpil_Opa_Rw_Analysis_Rw_Id that = (Bpil_Opa_Rw_Analysis_Rw_Id) o;
	        return Objects.equals(getOpa_analysis_id(), that.getOpa_analysis_id()) &&
	                Objects.equals(getScheme_id(), that.getScheme_id());
	    }
	 
	    @Override
	    public int hashCode() {
	        return Objects.hash(getOpa_analysis_id(), getScheme_id());
	    }	
	
}
