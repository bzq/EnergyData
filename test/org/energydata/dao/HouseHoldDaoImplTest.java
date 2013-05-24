package org.energydata.dao;

import static org.junit.Assert.*;

import org.energydata.beans.Factory;
import org.energydata.beans.HouseHold;
import org.junit.*;


public class HouseHoldDaoImplTest {

	HouseHoldDao householdDao = null;

	@Before
	public void setUp() throws Exception {

		householdDao = DAOFactory.getInstance().getHouseHoldDao();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHouseHoldDaoImpl() {

		
	}

	@Test
	public void testCreate() {
		HouseHold household = Factory.createHouseHold(30003925);


		HouseHold tmp = householdDao.create(household);
		assertNotNull(tmp);
		System.out.println("HouseHold  Id : " + tmp.getIdHouseHold());
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
