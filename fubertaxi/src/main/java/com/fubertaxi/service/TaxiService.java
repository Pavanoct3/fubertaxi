package com.fubertaxi.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fubertaxi.customer.Customer;
import com.fubertaxi.taxi.Location;
import com.fubertaxi.taxi.Taxi;

public class TaxiService {

	private static List<Taxi> taxisList = new ArrayList<>();
	private static List<Customer> customerList = new ArrayList<>();
	private TaxiService() {
		
	}
	public static Taxi getRide(Customer customer) {
		
		List<Taxi> taxiList = fetchCabs(customer.isPinkPreferred());
		if(taxiList.size()!=0) {
			Collections.sort(taxiList, new TaxiCustomerDistanceComparator(customer.getLocation()));				
		    taxiList.get(0).setAvailable(false);
		    customer.setRideStartTime(System.currentTimeMillis());
		    customerList.add(customer);		    
		    return taxiList.get(0);
		}
		return null;
		
		
	}
	
	public static Customer endRide(Long customerId){
		
		if(customerList.size()==0) {
			return null;
		}
		for(Customer customer : customerList) {
			if(customer.getId()==customerId) {
				customer.setAmountToPay(calculateRideCost(customer));
				customer.setRideStartTime(0);
				makeTaxiAvailable(customer.getTaxiId(), customer.getDestLocation());
				return customer;
			}
		}
		return null;
		
	}
	
	private static void makeTaxiAvailable(long taxiId, Location destLocation) {
		for(Taxi taxi : taxisList) {
			if(taxi.getId()==taxiId) {
				taxi.setAvailable(true);
				taxi.setLocation(destLocation);
			}
		}		
	}
	
	private static double calculateRideCost(Customer customer) {
		double totalCost = 0;
		double distance = getDistance(customer.getDestLocation(), customer.getLocation());
		long currentTimeInMillis = System.currentTimeMillis();
		long rideTimeInMillis = currentTimeInMillis - customer.getRideStartTime();
		totalCost = (distance*2) + ((rideTimeInMillis/(1000*60))*1);	
		return Math.round(totalCost);
		
	}
	private static List<Taxi> fetchCabs(boolean isPinkPreferred) {
		
		if(taxisList.size()==0) {
			initialiseTaxiList();
		}
		List<Taxi> list = new ArrayList<>();
		for(Taxi taxi : taxisList) {
			if(taxi.isAvailable()==true) {
				if(isPinkPreferred) {
					if(taxi.isPink()) {
						list.add(taxi);
					}
				}
				else {
					list.add(taxi);
				}
			}
		}
						
		return list;

		
	}
	
	private static void initialiseTaxiList() {
		taxisList.add(new Taxi(1, new Location(10, 100), true, true));
		taxisList.add(new Taxi(2, new Location(20, 200), false, true));
		taxisList.add(new Taxi(3, new Location(30, 300), false, true));
		taxisList.add(new Taxi(4, new Location(40, 400), true, false));
		taxisList.add(new Taxi(5, new Location(50, 500), false , true));
		taxisList.add(new Taxi(6, new Location(60, 600), false, false));
		taxisList.add(new Taxi(7, new Location(70, 700), false, true));
		taxisList.add(new Taxi(8, new Location(80, 800), false, true));
		taxisList.add(new Taxi(9, new Location(90, 900), false, true));
		taxisList.add(new Taxi(10, new Location(100, 1000), true , true));		
	}

	public static double getDistance(Location location1, Location location2) {
		
		double xDistance = Math.pow((location1.getLattitude()-location2.getLattitude()), 2);
		double yDistance = Math.pow((location1.getLongitude()-location2.getLongitude()), 2);
		double distance = Math.abs(Math.sqrt(xDistance+yDistance));
		return distance;
	}
}
