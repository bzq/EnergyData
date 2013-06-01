package org.energydata.services;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import org.energydata.beans.Measure;
import org.energydata.beans.Sensor;


public class DataLoaderWSImpl implements DataLoader {

	@Override
	public List<Measure> getMeasures() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sensor getSensor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void convertMeasureToDailyAverage() {
		// TODO Auto-generated method stub

	}
	

}
