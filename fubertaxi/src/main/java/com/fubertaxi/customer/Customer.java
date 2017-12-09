package com.fubertaxi.customer;

import javax.xml.bind.annotation.XmlRootElement;

import com.fubertaxi.taxi.Location;

@XmlRootElement
public class Customer {
	
	private long id;
	private Location location;
	private Location destLocation;
	private double amountToPay;
	private boolean isPinkPreferred;
	private long rideStartTime;
	private long taxiId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public double getAmountToPay() {
		return amountToPay;
	}
	public void setAmountToPay(double amountToPay) {
		this.amountToPay = amountToPay;
	}
	public boolean isPinkPreferred() {
		return isPinkPreferred;
	}
	public void setPinkPreferred(boolean isPinkPreferred) {
		this.isPinkPreferred = isPinkPreferred;
	}
	public Location getDestLocation() {
		return destLocation;
	}
	public void setDestLocation(Location destLocation) {
		this.destLocation = destLocation;
	}
	public long getRideStartTime() {
		return rideStartTime;
	}
	public void setRideStartTime(long rideStartTime) {
		this.rideStartTime = rideStartTime;
	}
	public long getTaxiId() {
		return taxiId;
	}
	public void setTaxiId(long taxiId) {
		this.taxiId = taxiId;
	}

}
