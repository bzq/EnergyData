package org.energydata.beans;

import java.util.ArrayList;



public class HouseHold {
	
	private int idHouseHold;

	private String houseName;

	private ArrayList<Appliance> listOfAppliance;

	private ArrayList<Sensor> listOfSensor;
	
	
	
	

	/**
	 * Get the value of houseName
	 *
	 * @return the value of houseName
	 */
	protected HouseHold(){
		listOfAppliance = new ArrayList<Appliance>();
		listOfSensor = new ArrayList<Sensor>();
	}

	/**
	 * @param e
	 * @return
	 * @see java.util.ArrayList#add(java.lang.Object)
	 */
	public boolean add(Appliance e) {
		return listOfAppliance.add(e);
	}

	/**
	 * @param e
	 * @return
	 * @see java.util.ArrayList#add(java.lang.Object)
	 */
	public boolean add(Sensor e) {
		return listOfSensor.add(e);
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.AbstractList#equals(java.lang.Object)
	 */
	public boolean equals(Appliance o) {
		return listOfAppliance.equals(o);
	}
	
	/**
	 * @param o
	 * @return
	 * @see java.util.AbstractList#equals(java.lang.Object)
	 */
	public boolean equals(Sensor o) {
		return listOfSensor.equals(o);
	}

	public String getHouseName() {
		return houseName;
	}

	/**
	 * @return the listOfAppliance
	 */
	public ArrayList<Appliance> getListOfAppliance() {
		return listOfAppliance;
	}

	/**
	 * @return the listOfSensor
	 */
	public ArrayList<Sensor> getListOfSensor() {
		return listOfSensor;
	}
	
	public int getIdHouseHold() {
		return idHouseHold;
	}

	public void setIdHouseHold(int idHouseHold) {
		this.idHouseHold = idHouseHold;
	}
	

	/**
	 * @param o
	 * @return
	 * @see java.util.ArrayList#remove(java.lang.Object)
	 */
	public boolean remove(Appliance s) {
		return listOfAppliance.remove(s);
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.ArrayList#remove(java.lang.Object)
	 */
	public boolean remove(Sensor s) {
		return listOfSensor.remove(s);
	}

	/**
	 * Set the value of houseName
	 *
	 * @param houseName new value of houseName
	 */
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	/**
	 * @param listOfAppliance the listOfAppliance to set
	 */
	public void setListOfAppliance(ArrayList<Appliance> listOfAppliance) {
		this.listOfAppliance = listOfAppliance;
	}
	
	/**
	 * @param listOfSensor the listOfSensor to set
	 */
	public void setListOfSensor(ArrayList<Sensor> listOfSensor) {
		this.listOfSensor = listOfSensor;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HouseHold [houseName=" + houseName + ", listOfAppliance="
				+ listOfAppliance + ", listOfSensor="+ "]";
	}





}
