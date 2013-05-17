package org.energydata.beans;

import java.util.ArrayList;
import java.util.LinkedList;



/**
 * @author Miage
 *
 */
public class Appliance {
	
	private int idAppliance;

	private String applianceName;
	
	private ArrayList<Sensor> listOfSensor;
	
	private String applianceUnit;
	



	protected Appliance(){
		listOfSensor = new ArrayList<Sensor>();
	}


	public void add(Sensor sensor) {
		this.listOfSensor.add(sensor);
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.AbstractList#equals(java.lang.Object)
	 */
	public boolean equals(Sensor sensor) {
		return listOfSensor.equals(sensor);
	}

	/**
	 * Get the value of applianceName
	 *
	 * @return the value of applianceName
	 */
	public String getApplianceName() {
		return applianceName;
	}

	public ArrayList<Sensor> getListOfSensor() {
		return listOfSensor;
	}
	//A completer
	//retour un sensor, soit le sensor courant si existant, sinon en creer un nouveau
	public Sensor getSensor() {
		return null;
	}
	
	public String getApplianceUnit() {
		return applianceUnit;
	}


	public void setApplianceUnit(String applianceUnit) {
		this.applianceUnit = applianceUnit;
	}
    
	
	public int getIdAppliance() {
		return idAppliance;
	}


	public void setIdAppliance(int idAppliance) {
		this.idAppliance = idAppliance;
	}


	/**
	 * @param o
	 * @return
	 * @see java.util.ArrayList#remove(java.lang.Object)
	 */
	public boolean remove(Sensor sensor) {
		return listOfSensor.remove(sensor);
	}


	/**
	 * Set the value of applianceName
	 *
	 * @param applianceName new value of applianceName
	 */
	public void setApplianceName(String applianceName) {
		this.applianceName = applianceName;
	}

	public void setListOfSensor(ArrayList<Sensor> listOfSensor) {
		this.listOfSensor = listOfSensor;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Appliance [applianceName=" + applianceName + ", listOfSensor=" + "]";
	}


}
