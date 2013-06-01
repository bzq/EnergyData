package org.energydata.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.RPC)
public interface MeasureWS{

	@WebMethod String sendMeasure(@WebParam(name = "household")String household,
								  @WebParam(name = "appliance")String appliance,
								  @WebParam(name = "date")String date,
								  @WebParam(name = "state")int state,
								  @WebParam(name = "energyValue")int energyValue);

}