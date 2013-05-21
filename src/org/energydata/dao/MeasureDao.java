package org.energydata.dao;

import java.util.List;

import org.energydata.beans.Measure;

public interface MeasureDao {
	void create(Measure measure);
	
	void createList(List<Measure> measureList);
	
	void find();
	
	void delete();
	
	void update();

}
