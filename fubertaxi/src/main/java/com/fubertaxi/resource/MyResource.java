package com.fubertaxi.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fubertaxi.customer.Customer;
import com.fubertaxi.service.TaxiService;
import com.fubertaxi.taxi.Taxi;


/**
 * Root resource (exposed at "myresource" path)
 */
@Path("fubertaxi")
public class MyResource {
	
	
    /**
     * Method handling HTTP POST requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @POST
    @Path("booktaxi")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public Response bookTaxi(Customer customer) {
    	Taxi taxi = TaxiService.getRide(customer);
    	if(taxi==null) {
    		String noCabs = "Sorry!!! No Taxis Available.";
    		return Response.ok(noCabs).build();
    	}
        return Response.ok().entity("SUCCESS!!! "+taxi.toString()).build();
    }
    @GET
    @Path("endRide/{customerId}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response bookTaxi(@PathParam("customerId")Long customerId) {
    	    	
    	Customer customer = TaxiService.endRide(customerId);
    	if(customer==null) {
    		return Response.ok().entity("No such Rides!!").build();
    	}
    	return Response.ok().entity("Thanks for Riding Fuber! Your Fare details::"+customer.getAmountToPay()+" dogecoins").build();
    	
    }
    
    
    
}
