package org.energydata.services;

import java.util.Map;

import org.energydata.beans.Appliance;
import org.energydata.beans.HouseHold;
import org.energydata.beans.Sensor;

public interface Launcher {

	Map<Integer, Double> getTotalConsumeEachHouseHold();
	
	public Map<Integer, Double> getTotalConsumeEachHouseHold(String startDate, String finDate);

	Map<Integer, Double> getHouseHoldMostConsume();
	
	public Map<Integer, Double> getHouseHoldMostConsume(String startDate,String finDate);

	Map<Integer, Double> getHouseHoldLeastConsume();
	
	public Map<Integer, Double> getHouseHoldLeastConsume(String startDate,String finDate);

	Map<Appliance, Double> getTotalConsumeEachAppliance();
	
	public Map<Appliance, Double> getTotalConsumeEachAppliance(String startDate,String finDate);

	Map<Appliance, Double> getApplianceMostConsume();
	
	public Map<Appliance, Double> getApplianceMostConsume(String startDate,String finDate);

	Map<Appliance, Double> getApplianceLeastConsume();
	
	public Map<Appliance, Double> getApplianceLeastConsume(String startDate,String finDate);

	Map<String, Double> getMostConsumeDate();
	
	
	void LoadFileByFile(String fileName);

	void LoadFileByDiectory(String directoryName);
	
//	A partir de la,N'existe pas pour le moment
	Map<String, Double> getLeastConsumeDate();
	
	// Le double en sortie si c'est possible que ce soit le total de la consommation de ce capteur pour cette maison
	Map<Sensor,Double> getSensorsList(int houseHoldId);
	
	//Retourne le nombre de capteur pour une appliance donnée en parametre
	int getNumberOfSensor(Appliance appliance);




}
