<<<<<<< .mine
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






















=======
package org.energydata.services;

import org.energydata.beans.Appliance;
import org.energydata.beans.HouseHold;
import org.energydata.beans.Measure;
import org.energydata.beans.Sensor;
import org.energydata.dao.ApplianceDao;
import org.energydata.dao.DAOFactory;
import org.energydata.dao.HouseHoldDao;
import org.energydata.dao.MeasureDao;
import org.energydata.dao.SensorDao;

public class DataStorageDBImpl implements DataStorage {

	public int save(DataLoader dataLoader) {
		
		Sensor sensor = dataLoader.getSensor();
		
		
		HouseHoldDao householdDao = DAOFactory.getInstance().getHouseHoldDao();
		HouseHold household=householdDao.create(sensor.getHouseHold());
		ApplianceDao applianceDao = DAOFactory.getInstance().getApplianceDao();
		Appliance newAppliance = applianceDao.create(sensor.getAppliance());
		SensorDao sensorDao = DAOFactory.getInstance().getSensorDao();
		sensorDao.create(sensor);
		MeasureDao measureDao = DAOFactory.getInstance().getMeasureDao();
		measureDao.createList(sensor,sensor.getListOfMeasure());
		
		
		/*
		Measure m1 = dataLoader.getMeasures().get(0);
		HouseHoldDao householdDao = DAOFactory.getInstance().getHouseHoldDao();
		HouseHold household=householdDao.create(m1.getSensor().getHouseHold());
		
		ApplianceDao applianceDao = DAOFactory.getInstance().getApplianceDao();
		Appliance newAppliance = applianceDao.create(m1.getSensor().getAppliance());
		m1.getSensor().setAppliance(newAppliance);
		m1.getSensor().setHouseHold(household);
		SensorDao sensorDao = DAOFactory.getInstance().getSensorDao();
		sensorDao.create(m1.getSensor());
		MeasureDao measureDao = DAOFactory.getInstance().getMeasureDao();
		measureDao.createList(dataLoader.getMeasures());
		*/
		/*
		for(Measure measure : dataLoader.getMeasures()){
			
			MeasureDao measureDao = DAOFactory.getInstance().getMeasureDao();
			measureDao.create(measure);
		}
		*/
		return 0;
	}

}
>>>>>>> .theirs
