package org.energydata.services;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.energydata.beans.Appliance;
import org.energydata.beans.Factory;
import org.energydata.beans.HouseHold;
import org.energydata.beans.Measure;
import org.energydata.beans.Sensor;
import org.junit.*;


public class DataLoaderFileTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

//	@Test
//	public void testExtractSensorFromApplianceName() {
//		HouseHold houseHold = Factory.createHouseHold("2000913");
//		String applianceName = "Halogen lamp 5 ()";
//		Appliance appliance = FileDataLoader.extractApplianceFromApplianceName(applianceName, houseHold);
//		Sensor sensor = FileDataLoader.extractSensorFromApplianceName(applianceName, appliance, houseHold);
//		System.out.println(sensor.getIdentifySensor());
//		assertTrue(sensor.getIdentifySensor()==5);
//	}
//	
//	@Test
//	public void testExtractSensorFromApplianceName2() {
//		HouseHold houseHold = Factory.createHouseHold("2000913");
//		String applianceName = "Site consumption ()";
//		Appliance appliance = FileDataLoader.extractApplianceFromApplianceName(applianceName, houseHold);
//		Sensor sensor = FileDataLoader.extractSensorFromApplianceName(applianceName, appliance, houseHold);
//		System.out.println(sensor.getIdentifySensor());
//		assertTrue(sensor.getIdentifySensor()==1);
//	}
//	
//	@Test
//	public void testExtractSensorFromApplianceNameDescription() {
//		HouseHold houseHold = Factory.createHouseHold("2000913");
//		String applianceName = " Chest freezer (273l)";
//		Appliance appliance = FileDataLoader.extractApplianceFromApplianceName(applianceName, houseHold);
//		Sensor sensor = FileDataLoader.extractSensorFromApplianceName(applianceName, appliance, houseHold);
//		System.out.println(sensor.getIdentifySensor());
//		assertTrue(sensor.getIdentifySensor()==1 && sensor.getDescriptionSensor().equals("273l"));
//	}
//
//	
//	@Test
//	public void testLoadData() {
//        System.out.println("loadData");
//        String dataSource = "C:\\Users\\Miage\\Projet2013\\EnergyData\\Data\\RawData\\1000080-2000900-3009906.txt";
//        FileDataLoader instance = new FileDataLoader();
//        boolean expResult = false;
//        boolean result = instance.loadData(dataSource);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//	}
//
//	@Test
//	public void testIsMeasure() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testExtractApplianceFromApplianceName() {
//		HouseHold houseHold = Factory.createHouseHold("2000913");
//		String applianceName = "Halogen lamp 1 ()";
//		Appliance appliance = FileDataLoader.extractApplianceFromApplianceName(applianceName, houseHold);
//		assertTrue(appliance.getApplianceName().equals("Halogen lamp"));
//	}
//	
//	@Test
//	public void testExtractApplianceFromApplianceName2() {
//		HouseHold houseHold = Factory.createHouseHold("20009130");
//		String applianceName = "Site consumption ()";
//		Appliance appliance = FileDataLoader.extractApplianceFromApplianceName(applianceName, houseHold);
//		assertTrue(appliance.getApplianceName().equals("Site consumption"));
//	}
	
	@Test
	public void TestgetMeasures(){
		FileWriter out;
		try {
			out = new FileWriter("junitTestFileTemp.txt");
			out.write("PROJECT : Irise (France)\n");
			out.write("HOUSEHOLD : 2000900\n");
			out.write("APPLIANCE : Site consumption ()\n\n");
			out.write("DATE(dd/mm/yy)	TIME(hh:mm)	STATE	ENERGY(Wh)\n");
			out.write("22/01/98	13:40	0	000294\n");
			out.write("22/01/98	13:50	0	000085\n");
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		File file= new File("junitTestFileTemp.txt");
		DataLoader fileData= new DataLoaderFileImpl(file);
		Date d1=null,d2=null;
		try {
			d1 = new SimpleDateFormat("dd/MM/yy HH:mm").parse("22/01/98 13:40");
			d2 = new SimpleDateFormat("dd/MM/yy HH:mm").parse("22/01/98 13:50");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Measure m1 = fileData.getMeasures().get(0);
		Measure m2 = fileData.getMeasures().get(1);
		
		assertTrue(fileData.getMeasures().size() == 2 && (m1.getEnergyValue() == 294 && d1.equals(m1.getDate())) && ( m2.getEnergyValue() == 85 && d2.equals(m2.getDate())) );
		file.delete();
	}

	
}
