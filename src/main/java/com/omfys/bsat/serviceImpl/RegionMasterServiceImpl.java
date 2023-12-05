package com.omfys.bsat.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.omfys.bsat.service.RegionMasterService;
import com.omfys.bsat.repository.RegionMasterDao;
import com.omfys.bsat.model.Bpil_Dealer_Master;
import com.omfys.bsat.model.Bpil_Depot_Master;
import com.omfys.bsat.model.Bpil_Headquarter_Master;
import com.omfys.bsat.model.Bpil_Region_Master;

@Service("RegionService")
@Transactional
public class RegionMasterServiceImpl implements RegionMasterService {

	@Autowired
	RegionMasterDao RegionMasterDao;

	@Override
	public int InsertRegion(Bpil_Region_Master bpil_Region_Master, int userId) {

		return RegionMasterDao.insertuser(bpil_Region_Master, userId);
	}

	@Override
	public List<Bpil_Region_Master> getRegionList() {
		// TODO Auto-generated method stub

		return RegionMasterDao.getRegionList();
	}

	@Override
	public int saveregion(Bpil_Region_Master bpil_Region_Master) {
		// TODO Auto-generated method stub
		return RegionMasterDao.saveregion(bpil_Region_Master);
	}

	@Override
	public Bpil_Region_Master updateregion(int region_id) {
		return RegionMasterDao.updateregion(region_id);

	}

	@Override
	public int saveheadquarter(Bpil_Headquarter_Master headquartermaster) {
		return RegionMasterDao.saveheadquarter(headquartermaster);
		
	}

	@Override
	public int saveDepot(Bpil_Depot_Master depot) {
		// TODO Auto-generated method stub
		return RegionMasterDao.saveDepot(depot);
	}

	@Override
	public int saveDealer(Bpil_Dealer_Master dealer) {
		// TODO Auto-generated method stub
		return RegionMasterDao.saveDealer(dealer);
	}

}
