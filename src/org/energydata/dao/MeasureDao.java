package org.energydata.dao;

import java.util.List;

import org.energydata.beans.Measure;
import org.energydata.beans.Sensor;

public interface MeasureDao {
	void create(Measure measure);
	
	void createList(Sensor sensor,List<Measure> measureList);
	
	void find();
	
	void delete();
	
	void update();

}
