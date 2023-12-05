package com.omfys.bsat.repositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.omfys.bsat.model.HierarchySetUp;
import com.omfys.bsat.repository.ProblemCodeDao;
import com.omfys.bsat.model.Bpil_Users;
//import com.omfys.bsat.model.ProblemCodes;
//import com.omfys.bsat.model.ResolutionCodes;

@Repository("ProblemCodeDao")
public class ProblemCodesDaoImpl implements ProblemCodeDao {

	/*@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private HibernateTemplate  hibernateTemplate;
	
	@Override
	public List<ResolutionCodes> ResolutionCodes_List() {
		String sql = "SELECT KRC.RESOLUTION_CODE_ID,KRC.RESOLUTION_CODE,KRC.RESOLUTION_DESC,KRC.PROBLEM_CODE,KPC.PROBLEM_DESC FROM KOEL_RESOLUTION_CODES KRC ,KOEL_PROBLEM_CODES KPC WHERE KRC.PROBLEM_CODE=KPC.PROBLEM_CODE";
		
		List<ResolutionCodes> ResolutionCodes_list = jdbcTemplate.query(sql, new RowMapper<ResolutionCodes>() {
			@Override
			public ResolutionCodes mapRow(ResultSet rs, int rowNum) throws SQLException {
				ResolutionCodes aContact = new ResolutionCodes();
				
				aContact.setResolution_code_id(rs.getInt("RESOLUTION_CODE_ID"));
				aContact.setResolution_code(rs.getString("RESOLUTION_CODE"));
				aContact.setResolution_desc(rs.getString("RESOLUTION_DESC"));
				aContact.setProblem_code(rs.getString("PROBLEM_CODE"));
				aContact.setAttribute1(rs.getString("PROBLEM_DESC"));
				
				System.out.println(rs.getString("RESOLUTION_CODE"));
				System.out.println(rs.getString("RESOLUTION_DESC"));

				
				
				return aContact;
			}
			
		});
		
		return ResolutionCodes_list;
	}

	public List<ProblemCodes> problemCodes_List()
	{
		String sql = "SELECT PROBLEM_CODE,PROBLEM_DESC FROM KOEL_PROBLEM_CODES";
		
		List<ProblemCodes> proCodes_list = jdbcTemplate.query(sql, new RowMapper<ProblemCodes>() {
			@Override
			public ProblemCodes mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProblemCodes pdata = new ProblemCodes(sql, sql);
				
				pdata.setProblem_code(rs.getString("PROBLEM_CODE"));
				pdata.setProblem_desc(rs.getString("PROBLEM_DESC"));
				
				System.out.println(rs.getString("PROBLEM_CODE"));
				System.out.println(rs.getString("PROBLEM_DESC"));				
				
				return pdata;
			}
			
		});
		
		return proCodes_list;
	}
	
	public ArrayList<ProblemCodes> Searchpro_code(String pro_code)
	{
		System.out.println("in dao");
		 String name=null;
		 
		 ArrayList<ProblemCodes> dml = (ArrayList<ProblemCodes>)hibernateTemplate.find("FROM ProblemCodes where problem_code =?",pro_code);
		
		 int len =dml.size();
		 System.out.println("in dao="+len);
		 for(int i=0; i<dml.size(); i++)
			{
				name = dml.get(0).getProblem_code();								
				System.out.println("user name  "+name);
			}
		return dml;
	 }

	/////////////////////////////////////////////////////////////////////////////////////
	
	
*/
}
