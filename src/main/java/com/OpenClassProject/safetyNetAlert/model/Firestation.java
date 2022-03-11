package com.OpenClassProject.safetyNetAlert.model;

import java.util.Objects;

public class Firestation {
	private String address;
	private int station;
	
	public Firestation (String address, int station) {
		this.address = address;
		this.station = station;
	}
	
	public Firestation() {
		
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getStation() {
		return station;
	}

	public void setStation(int station) {
		this.station = station;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, station);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Firestation other = (Firestation) obj;
		return Objects.equals(address, other.address) && station == other.station;
	}
	
	
}
