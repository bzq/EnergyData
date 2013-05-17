package org.energydata.services;

import java.util.List;

import org.energydata.beans.Measure;


public interface DataLoader {
    
    public List<Measure> getMeasures();

}
