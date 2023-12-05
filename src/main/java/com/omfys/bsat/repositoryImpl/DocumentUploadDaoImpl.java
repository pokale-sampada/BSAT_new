package com.omfys.bsat.repositoryImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.text.ParseException;
import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.omfys.bsat.model.DocumentGrid_Autofill;
import com.omfys.bsat.repository.DocumentUploadDao;
import com.omfys.bsat.model.Bpil_Document_Master;
import com.omfys.bsat.model.Bpil_Users;

@Repository("DocumentUploadDao")
public class DocumentUploadDaoImpl  implements DocumentUploadDao {
	
	@Autowired
	private HibernateTemplate  hibernateTemplate;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<DocumentGrid_Autofill> Loaddoc()
	{
		System.out.println("in of dao");
				
		String sql="SELECT DOCUMENT_ID,FILE_DESCRIPTION,FILE_NAME,ACTIVE_START_DATE,ACTIVE_END_DATE FROM BPIL_DOCUMENT_MASTER";

		List<DocumentGrid_Autofill> doc_data = jdbcTemplate.query(sql, new RowMapper<DocumentGrid_Autofill>() {

			@Override
			public DocumentGrid_Autofill mapRow(ResultSet rs, int rowNum) throws SQLException 
			{
				
				DocumentGrid_Autofill doc_details = new DocumentGrid_Autofill();
				
				doc_details.setDocument_id(rs.getInt("DOCUMENT_ID"));
				doc_details.setFile_description(rs.getString("FILE_DESCRIPTION"));
				doc_details.setFile_name(rs.getString("FILE_NAME"));
			//	doc_details.setActive_start_date(rs.getDate("ACTIVE_START_DATE"));
				if(rs.getDate("ACTIVE_START_DATE")!=null)
				{
					DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
					String dateStr1 = ser1.format(rs.getDate("ACTIVE_START_DATE"));
					doc_details.setActive_start_date(dateStr1);	
					try {
						System.out.println(ser1.parse(rs.getString("ACTIVE_START_DATE")));
					} catch (ParseException e) {
							e.printStackTrace();
					}
				}
				
			//	doc_details.setActive_end_date(rs.getDate("ACTIVE_END_DATE"));				
				if(rs.getDate("ACTIVE_END_DATE")!=null)
				{
					DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
					String dateStr1 = ser1.format(rs.getDate("ACTIVE_END_DATE"));
					doc_details.setActive_end_date(dateStr1);	
					try {
						System.out.println(ser1.parse(rs.getString("ACTIVE_END_DATE")));
					} catch (ParseException e) {
							e.printStackTrace();
					}
				}
				
				System.out.println("out of dao");
				
				return doc_details;
			
			}
			
		});
		
		return doc_data;
		
	}
	
	
	public int UploadDocs(Bpil_Document_Master Koel_doc)
	{	
	    synchronized(this) {
			hibernateTemplate.saveOrUpdate(Koel_doc);
		
		System.out.println(Koel_doc.getDocument_id());
		return Koel_doc.getDocument_id();
	    }
	}
}
	/*
	public void UploadDocs( final Koel_Document_Master Koel_doc)
	{			
		final String query = "insert into koel_document_master (document_id,file_description,active_start_date,active_end_date,file_name,file_type,file_size,doc_file) values (koel_master_docs_s.nextval,?,?,?,?,?,?,?)";
		 
        try {
            synchronized(this) {
            	jdbcTemplate.update(new PreparedStatementCreator() {
 
                    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                        PreparedStatement statement = con.prepareStatement(query);
                        
                        statement.setString(1, Koel_doc.getFile_description());
                        statement.setDate(2,(Date) Koel_doc.getActive_start_date());
                        statement.setDate(3,(Date) Koel_doc.getActive_end_date());
                        statement.setString(4, Koel_doc.getFile_name());
                        statement.setString(5, Koel_doc.getFile_type());
						statement.setLong(6, Koel_doc.getFile_size());
						statement.setBytes(7, Koel_doc.getDoc_file());
                        return statement;
                    }
                });
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
*/


