package org.energydata.services;

import java.util.Date;
import java.util.Map;

import org.energydata.beans.Appliance;
import org.energydata.beans.HouseHold;
import org.energydata.beans.Sensor;

public interface Launcher {

	Map<Integer, Double> getTotalConsumeEachHouseHold();

	Map<Integer, Double> getHouseHoldMostConsume();

	Map<Integer, Double> getHouseHoldLeastConsume();

	Map<Appliance, Double> getTotalConsumeEachAppliance();

	Map<Appliance, Double> getApplianceMostConsume();

	Map<Appliance, Double> getApplianceLeastConsume();

	Map<String, Double> getMostConsumeDate();
	
	
	void LoadFileByFile(String fileName);

	void LoadFileByDiectory(String directoryName);
	
//	A partir de la,N'existe pas pour le moment
	Map<String, Double> getLeastConsumeDate();
	
	// Le double en sortie si c'est possible que ce soit le total de la consommation de ce capteur pour cette maison
	Map<Sensor,Double> getSensorsList(int houseHoldId);
	
	//Retourne le nombre de capteur pour une appliance donnée en parametre
	int getNumberOfSensor(Appliance appliance);

	//Retourne le total de la consommation pour la date "date" pour chaque appliance ayant fonctionné durant cette journée
	Map<Appliance,Double> getAppliancesList(Date date);



}
