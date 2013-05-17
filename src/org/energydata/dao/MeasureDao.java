package org.energydata.dao;

import org.energydata.beans.Measure;

public interface MeasureDao {
	void create(Measure measure);
	
	void find();
	
	void delete();
	
	void update();

}
