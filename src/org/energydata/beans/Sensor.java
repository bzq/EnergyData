package org.energydata.beans;

import java.util.ArrayList;
import java.util.List;

public class Sensor {

	/**
	 * @param sensor
	 * @return
	 * @see org.energydata.beans.Appliance#equals(org.energydata.beans.Sensor)
	 */
	public boolean equals(Sensor sensor) {
		return appliance.equals(sensor.getAppliance()) && houseHold.equals(sensor.getHouseHold()) && identifySensor == sensor.getIdentifySensor();
	}

	private Appliance appliance;
	private String descriptionSensor;
	private HouseHold houseHold;
	private int identifySensor;
	private List<Measure> listOfMeasure;

	private String location;

	
	
	
	protected Sensor(){
		listOfMeasure = new ArrayList<Measure>();
	}
	public void addMeasure(Measure measure) {

		this.listOfMeasure.add(measure);

	}
	/**
	 * Get the value of appliance
	 *
	 * @return the value of appliance
	 */
	public Appliance getAppliance() {
		return appliance;
	}

	/**
	 * Get the value of descriptionSensor
	 *
	 * @return the value of descriptionSensor
	 */
	public String getDescriptionSensor() {
		return descriptionSensor;
	}

	/**
	 * Get the value of houseHold
	 *
	 * @return the value of houseHold
	 */
	public HouseHold getHouseHold() {
		return houseHold;
	}

	/**
	 * Get the value of identifySensor
	 *
	 * @return the value of identifySensor
	 */
	public int getIdentifySensor() {
		return identifySensor;
	}

	public List<Measure> getListOfMeasure() {
		return listOfMeasure;
	}

	/**
	 * Get the value of location
	 *
	 * @return the value of location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Set the value of appliance
	 *
	 * @param appliance new value of appliance
	 */
	public void setAppliance(Appliance appliance) {
		this.appliance = appliance;
	}

	/**
	 * Set the value of descriptionSensor
	 *
	 * @param descriptionSensor new value of descriptionSensor
	 */
	public void setDescriptionSensor(String descriptionSensor) {
		this.descriptionSensor = descriptionSensor;
	}

	/**
	 * Set the value of houseHold
	 *
	 * @param houseHold new value of houseHold
	 */
	public void setHouseHold(HouseHold houseHold) {
		this.houseHold = houseHold;
	}


	/**
	 * Set the value of identifySensor
	 *
	 * @param identifySensor new value of identifySensor
	 */
	public void setIdentifySensor(int identifySensor) {
		this.identifySensor = identifySensor;
	}

	public void setListOfMeasure(List<Measure> listOfMeasure) {
		this.listOfMeasure = listOfMeasure;
	}

	/**
	 * Set the value of location
	 *
	 * @param location new value of location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Sensor [identifySensor=" + identifySensor
				+ ", descriptionSensor=" + descriptionSensor + ", location="
				+ location + ", appliance=" + appliance + ", houseHold="
				+ houseHold + ", listOfMeasure=" + "]";
	}
}
