package org.energydata.dao;
import static org.junit.Assert.*;

import org.energydata.dao.ApplianceDao;
import org.energydata.dao.DAOFactory;
import org.energydata.beans.Appliance;
import org.energydata.beans.Factory;
import org.energydata.beans.HouseHold;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ApplianceDaoImplTest {
	
	ApplianceDao applianceDao =null;

	@Before
	public void setUp() throws Exception {
	
		applianceDao = DAOFactory.getInstance().getApplianceDao();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testApplianceDaoImpl() {
		assertNotNull(applianceDao);
	}

	@Test
	public void testCreate() {
		
		Appliance appliance = Factory.createAppliance("test");

     	Appliance tmp = applianceDao.create(appliance);
		assertNotNull(tmp);
		System.out.println("Appliance  Id : " + tmp.getIdAppliance());
		System.out.println(tmp.toString());
	}

	@Test
	public void testFind() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

}
