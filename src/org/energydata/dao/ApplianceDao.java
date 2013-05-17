package org.energydata.dao;

import org.energydata.beans.Appliance;

public interface ApplianceDao {
	Appliance create(Appliance appliance);
	
	Appliance find(Appliance appliance);
	
	void delete();
	
	void update();

}
