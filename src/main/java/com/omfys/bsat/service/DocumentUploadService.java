package com.omfys.bsat.service;

import java.util.List;

import com.omfys.bsat.model.DocumentGrid_Autofill;
import com.omfys.bsat.model.Bpil_Document_Master;
import com.omfys.bsat.model.Bpil_Users;

public interface DocumentUploadService {
	
public List<DocumentGrid_Autofill> Loaddoc();
	
	public int UploadDocs(Bpil_Document_Master Koel_doc);
}
