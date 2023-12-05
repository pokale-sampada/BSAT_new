package com.omfys.bsat.repositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.omfys.bsat.repository.HierarchySetUpDao;
import com.omfys.bsat.model.HierarchySetUp;
import com.omfys.bsat.model.HierarchySetUp1;

@Repository("HierarchySetUpDao")
public class HierarchySetUpDaoImpl implements HierarchySetUpDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	@Override
	public List<HierarchySetUp1> HierarchySetUp_List1() {
		String sql = "SELECT KAH.WF_HIERARCHY_ID,KAH.USER_ID,KU.LAST_NAME||', '||KU.FIRST_NAME USER_NAME, KAH.APPROVER_LEVEL,KAH.APR_ORDER,KAH.TO_VALUE FROM BPIL_APRL_HIERARCHY KAH, BPIL_USERS KU WHERE KAH.USER_ID = KU.USER_ID(+) ORDER BY KAH.APR_ORDER";
List<HierarchySetUp1> HierarchySetUp_list = jdbcTemplate.query(sql, new RowMapper<HierarchySetUp1>() {

			@Override
			public HierarchySetUp1 mapRow(ResultSet rs, int rowNum) throws SQLException {
				HierarchySetUp1 aContact = new HierarchySetUp1();
				
				aContact.setWf_hierarchy_id(rs.getInt("WF_HIERARCHY_ID"));
				aContact.setUser_id(rs.getInt("USER_ID"));
				aContact.setApprover_level(rs.getString("APPROVER_LEVEL"));
				aContact.setApr_order(rs.getInt("APR_ORDER"));
				aContact.setTo_value(rs.getInt("TO_VALUE"));
				aContact.setUser_name(rs.getString("USER_NAME"));
				System.out.println("HierarchySetUp run");
				
				
				return aContact;
			}
			
		});
		
		return HierarchySetUp_list;
	}

	

}
