package org.energydata.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

//Service Implementation Bean

@WebService(endpointInterface = "org.energydata.ws.MeasureWS")
public class MeasureWSImpl implements MeasureWS{

	@Override
	@WebMethod
	public String sendMeasure(@WebParam(name = "household") String household,
			@WebParam(name = "appliance") String appliance,
			@WebParam(name = "date") String date,
			@WebParam(name = "state") int state,
			@WebParam(name = "energyValue") int energyValue) {
		System.out.println(household+" ,"+appliance+" ,"+date+" ,"+state+" ,"+energyValue);
		return "Val retour Serveur sendMeasure OK: "+household+", "+date+" ,"+energyValue;
	}
	
}