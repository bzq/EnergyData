package org.energydata.services;

import org.energydata.beans.Appliance;
import org.energydata.beans.Measure;
import org.energydata.dao.ApplianceDao;
import org.energydata.dao.DAOFactory;
import org.energydata.dao.HouseHoldDao;
import org.energydata.dao.MeasureDao;
import org.energydata.dao.SensorDao;

public class DataStorageDBImpl implements DataStorage {

	public int save(DataLoader dataLoader) {
		Measure m1 = dataLoader.getMeasures().get(0);
		HouseHoldDao householdDao = DAOFactory.getInstance().getHouseHoldDao();
		householdDao.create(m1.getSensor().getHouseHold());
		
		ApplianceDao applianceDao = DAOFactory.getInstance().getApplianceDao();
		Appliance newAppliance = applianceDao.create(m1.getSensor().getAppliance());
		m1.getSensor().setAppliance(newAppliance);
		SensorDao sensorDao = DAOFactory.getInstance().getSensorDao();
		sensorDao.create(m1.getSensor());
		
		for(Measure measure : dataLoader.getMeasures()){
			
			MeasureDao measureDao = DAOFactory.getInstance().getMeasureDao();
			measureDao.create(measure);
		}
		return 0;
	}

}
