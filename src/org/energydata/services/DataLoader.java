package org.energydata.services;

import java.util.List;

import org.energydata.beans.Measure;
import org.energydata.beans.Sensor;


public interface DataLoader {
    
    public List<Measure> getMeasures();

}
