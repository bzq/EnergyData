package org.energydata.beans;

import java.util.Date;


public class Factory {

	public static Appliance createAppliance(String applianceName){
		Appliance appliance = new Appliance();
		appliance.setApplianceName(applianceName);
		
		return appliance;
	}
	
	public static HouseHold createHouseHold(int houseId){
		HouseHold houseHold = new HouseHold();
		houseHold.setIdHouseHold(houseId);
		
		return houseHold;
	}
	
	public static Measure createMeasure(Date date, long energyValue, int state){
		Measure measure = new Measure();
		measure.setDate(date);
		measure.setEnergyValue(energyValue);
		measure.setState(state);
		/*
		// If a supprimer quand le sensor sera crée
		if(sensor!=null){
			measure.setSensor(sensor);
			sensor.addMeasure(measure);
		}
		*/
		return measure;
	}
	
	public static Sensor createSensor(int identifySensor,Appliance appliance, HouseHold houseHold, String descriptionSensor, String location){
		Sensor sensor = new Sensor();
		sensor.setIdentifySensor(identifySensor);
		sensor.setAppliance(appliance);
		sensor.setDescriptionSensor(descriptionSensor);
		sensor.setHouseHold(houseHold);
		sensor.setLocation(location);
		appliance.add(sensor);
		houseHold.add(sensor);
		return sensor;

	}

}
