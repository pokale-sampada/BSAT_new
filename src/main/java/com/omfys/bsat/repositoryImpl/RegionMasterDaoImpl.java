package com.omfys.bsat.repositoryImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.omfys.bsat.repository.RegionMasterDao;
import com.omfys.bsat.model.Bpil_Dealer_Master;
import com.omfys.bsat.model.Bpil_Depot_Master;
import com.omfys.bsat.model.Bpil_Headquarter_Master;
import com.omfys.bsat.model.Bpil_MenuGroup;
import com.omfys.bsat.model.Bpil_Region_Master;

@Repository("RegionMasterDao")
public class RegionMasterDaoImpl implements RegionMasterDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public int insertuser(Bpil_Region_Master bpil_Region_Master, int userId) {

		hibernateTemplate.saveOrUpdate(bpil_Region_Master);

		return 0;
	}

	@Override
	public List<Bpil_Region_Master> getRegionList() {

		List<Bpil_Region_Master> regionlist = null;
		Transaction tx = null;
		Session session = hibernateTemplate.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();

			String query = "from Bpil_Region_Master";
			Query sql = session.createQuery(query);
			regionlist = sql.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
			System.gc();
		}

		return regionlist;
	}

	@Override
	public int saveregion(Bpil_Region_Master bpil_Region_Master) {
		System.out.println("In Region DAO IMPL");

		hibernateTemplate.saveOrUpdate(bpil_Region_Master);
		return 1;

	}

	@Override
	public Bpil_Region_Master updateregion(int region_id) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Bpil_Region_Master bpil_Region_Master = (Bpil_Region_Master) session.load(Bpil_Region_Master.class, region_id);

		String region_code = bpil_Region_Master.getRegion_code();
		bpil_Region_Master.setRegion_code(region_code);

		String region_name = bpil_Region_Master.getRegion_name();
		bpil_Region_Master.setRegion_name(region_name);

		String is_active = bpil_Region_Master.getIs_active();
		bpil_Region_Master.setIs_active(is_active);

		transaction.commit();
		session.close();

		return bpil_Region_Master;
	}

	@Override
	public int saveheadquarter(Bpil_Headquarter_Master headquartermaster) {
		System.out.println("In Region DAO IMPL");

		hibernateTemplate.saveOrUpdate(headquartermaster);
		return 1;
	}

	@Override
	public int saveDepot(Bpil_Depot_Master depot) {
		System.out.println("In Region DAO IMPL");

		hibernateTemplate.saveOrUpdate(depot);
		return 1;
	}

	@Override
	public int saveDealer(Bpil_Dealer_Master dealer) {
		System.out.println("In Region DAO IMPL");

		hibernateTemplate.saveOrUpdate(dealer);
		return 1;
	}
	

}
