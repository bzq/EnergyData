package org.energydata.services;

import java.util.Map;

import org.energydata.beans.Appliance;
import org.energydata.beans.HouseHold;

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

}
