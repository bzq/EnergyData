package org.energydata.beans;

import java.util.Date;
import java.util.Iterator;

import org.joda.time.DateTime;

public class Measure {


	/**
	 * @param obj
	 * @return
	 * @see java.util.Date#equals(java.lang.Object)
	 */
	public boolean equals(Measure measure) {
		//return date.equals(measure.getDate()) && sensor.equals(measure.getSensor());
		return date.equals(measure.getDate()) ;
	}

	private Date date;
	private long energyValue;
	private Sensor sensor;

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	private int state;
	
	/**
	 * Get the value of date
	 *
	 * @return the value of date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Get the value of energyValue
	 *
	 * @return the value of energyValue
	 */
	
	public float getEnergyValue() {
		return energyValue;
	}

	/**
	 * Get the value of state
	 *
	 * @return the value of state
	 */
	public int getState() {
		return state;
	}


	/**
	 * Set the value of date
	 *
	 * @param date new value of date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Set the value of energyValue
	 *
	 * @param energyValue new value of energyValue
	 */
	public void setEnergyValue(long energyValue) {
		this.energyValue = energyValue;
	}


	/**
	 * Set the value of state
	 *
	 * @param state new value of state
	 */
	public void setState(int state) {
		this.state = state;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Measure [date=" + date + ", state=" + state + ", energyValue="
				+ energyValue + "]";
	}
	

    public boolean dayEquals(Date date){
        DateTime dtRef = new DateTime(this.date);
        DateTime dtCible = new DateTime(date);
       
        return dtRef.getDayOfMonth() == dtCible.getDayOfMonth() && dtRef.getMonthOfYear() == dtCible.getMonthOfYear() && dtRef.getYear() == dtCible.getYear();
    }


}
