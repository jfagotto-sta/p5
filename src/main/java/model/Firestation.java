package model;

public class Firestation {
	private String adress;
	private int stationNumber;
	
	public Firestation (String adress, int stationNumber) {
		this.adress = adress;
		this.stationNumber = stationNumber;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getStationNumber() {
		return stationNumber;
	}

	public void setStationNumber(int stationNumber) {
		this.stationNumber = stationNumber;
	}
}
