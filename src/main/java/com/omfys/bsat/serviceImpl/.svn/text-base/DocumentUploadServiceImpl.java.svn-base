package com.omfys.bsat.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omfys.bsat.repository.DocumentUploadDao;
import com.omfys.bsat.service.DocumentUploadService;
import com.omfys.bsat.model.DocumentGrid_Autofill;
import com.omfys.bsat.model.Bpil_Document_Master;
import com.omfys.bsat.model.Bpil_Users;

@Service
public class DocumentUploadServiceImpl implements DocumentUploadService {
	
	@Autowired
	private DocumentUploadDao Docdao;
	

	public List<DocumentGrid_Autofill> Loaddoc()
	{
		return Docdao.Loaddoc();
	}
	
	public int UploadDocs(Bpil_Document_Master Koel_doc)
	{
		return Docdao.UploadDocs(Koel_doc);
	}
	
	
}
