package com.fubertaxi.service;

import java.util.Comparator;

import com.fubertaxi.taxi.Location;
import com.fubertaxi.taxi.Taxi;

public class TaxiCustomerDistanceComparator implements Comparator<Taxi> {

	private Location userLocation;

	public TaxiCustomerDistanceComparator(Location userLocation) {
		super();
		this.userLocation = userLocation;
	}

	public int compare(Taxi taxi1, Taxi taxi2) {

		double dist1 = TaxiService.getDistance(taxi1.getLocation(), this.userLocation);
		double dist2 = TaxiService.getDistance(taxi2.getLocation(), this.userLocation);

		if (dist1 > dist2) {
			return 1;
		} else if (dist1 == dist2) {
			return 0;
		} else if (dist1 < dist2) {
			return -1;
		}
		return 0;
	}
}
