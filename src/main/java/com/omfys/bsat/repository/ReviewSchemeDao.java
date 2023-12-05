package com.omfys.bsat.repository;

import java.util.ArrayList;

import com.omfys.bsat.model.New_Scheme_mstr;

public interface ReviewSchemeDao 
{

	ArrayList<New_Scheme_mstr> showreviwe(int user_id, int profile_id, String PMG_ML_Group);

	ArrayList<New_Scheme_mstr> autofillreviwe(String scheme_id);

	ArrayList<New_Scheme_mstr> showlaunchscheme(int user_id, int profile_id, String PMG_ML_Group);

	ArrayList<New_Scheme_mstr> Fin_Pending_list(int user_id, int profile_id, String PMG_ML_Group);

	ArrayList<New_Scheme_mstr> Rewpro_Pending_list(int user_id, int profile_id);

	ArrayList<New_Scheme_mstr> Rew_Sch_Freeze_list(int user_id, int profile_id);

	ArrayList<New_Scheme_mstr> Rew_Sch_Close_list(int user_id, int profile_id);

}
