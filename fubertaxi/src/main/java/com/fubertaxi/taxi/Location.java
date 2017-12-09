package com.fubertaxi.taxi;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Location {
	
	private double longitude;
	private double lattitude;
	public Location() {
		
	}
	public Location(double lattitude, double longitude) {
		this.lattitude = lattitude;
		this.longitude = longitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLattitude() {
		return lattitude;
	}
	public void setLattitude(double lattitude) {
		this.lattitude = lattitude;
	}
	@Override
	public String toString() {
		return "Lattitude = " + this.lattitude + ", Longitude =" + this.longitude;
	}


}
