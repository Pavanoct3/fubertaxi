package fubertaxi;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fubertaxi.customer.Customer;
import com.fubertaxi.service.TaxiService;
import com.fubertaxi.taxi.Location;

import junit.framework.Assert;

public class TaxiServiceTest {

	@Test
	public void test() {
		Customer customer = new Customer();
		customer.setId(1);
		customer.setLocation(new Location(10,100));
		customer.setDestLocation(new Location(20, 200));
		customer.setPinkPreferred(true);
		Assert.assertNotNull("Found a Taxi", TaxiService.getRide(customer));
	}

}
