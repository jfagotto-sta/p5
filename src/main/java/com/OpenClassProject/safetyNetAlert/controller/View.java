package com.OpenClassProject.safetyNetAlert.controller;

public class View {

	public interface infoLastName {
	}

	public interface infoFirstName {
	}

	public interface infoAge {
	}

	public interface infoMedications {
	}

	public interface infoAllergies {
	}

	public interface infoMail {
	}

	public interface infoAddress {
	}

	public interface infoStation {
	}

	public interface infoPhone {
	}

	public interface viewChildAlert extends infoLastName, infoFirstName, infoAge {

	}
	
	public interface viewPeopleAtFirestation extends infoLastName, infoFirstName, infoAddress, infoPhone {

	}

	public interface viewPersonInfo extends infoLastName, infoFirstName, infoMail, infoMedications, infoAllergies {

	}

	public interface viewPersonLivingInAddress extends infoLastName, infoPhone, infoAge, infoStation, infoAllergies, infoMedications {

	}

	public interface viewFloodStationInfo extends infoLastName, infoPhone, infoAge, infoAllergies, infoMedications {

	}

}
