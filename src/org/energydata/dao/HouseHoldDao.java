package org.energydata.dao;

import org.energydata.beans.HouseHold;

public interface HouseHoldDao {
	HouseHold create(HouseHold household);
	
	HouseHold find(HouseHold household);
	
	void delete();
	
	void update();



}
