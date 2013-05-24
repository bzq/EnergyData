package org.energydata.dao;

import org.energydata.beans.Sensor;

public interface SensorDao {
	void create(Sensor sensor);
	
	void find();
	
	void delete();
	
	void update();

}
