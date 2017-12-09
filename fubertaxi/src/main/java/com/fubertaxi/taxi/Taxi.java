package com.fubertaxi.taxi;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Taxi {

	private long id;
	private Location location;
	private boolean isPink;
	private boolean isAvailable;
	
	public Taxi() {
		
	}
	public boolean isPink() {
		return isPink;
	}

	public void setPink(boolean isPink) {
		this.isPink = isPink;
	}

	public Taxi(long id, Location location, boolean isPink, boolean isAvailable) {
		this.id = id;
		this.location = location;
		this.isPink = isPink;
		this.isAvailable = isAvailable;
	}
	
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
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailablel) {
		this.isAvailable = isAvailablel;
	}

	@Override
	public String toString() {
		return "Cab Number= " + id + ", location : " + location;
	}
}
