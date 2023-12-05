package com.omfys.bsat.repository;

import org.springframework.transaction.annotation.Transactional;

import com.omfys.bsat.model.BPIL_MENU;

@Transactional(readOnly = false)
public interface Save_Menu_Dao {
	public int savemenu(BPIL_MENU save_menu);
}
