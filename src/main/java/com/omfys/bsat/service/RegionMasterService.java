package com.omfys.bsat.service;

import java.util.List;

import com.omfys.bsat.model.Bpil_Dealer_Master;
import com.omfys.bsat.model.Bpil_Depot_Master;
import com.omfys.bsat.model.Bpil_Headquarter_Master;
import com.omfys.bsat.model.Bpil_Region_Master;

public interface RegionMasterService {

	public int InsertRegion(Bpil_Region_Master bpil_Region_Master, int userId);

	public List<Bpil_Region_Master> getRegionList();

	public int saveregion(Bpil_Region_Master bpil_Region_Master);

	public Bpil_Region_Master updateregion(int region_id);

	public int saveheadquarter(Bpil_Headquarter_Master headquartermaster);

	public int saveDepot(Bpil_Depot_Master depot);

	public int saveDealer(Bpil_Dealer_Master dealer);

}
