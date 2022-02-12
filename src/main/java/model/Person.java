package model;

	public class Person {
		
		private String firstName;
		private String lastName;
		private String adress;
		private String city;
		private int zip;
		private String phone;
		private String email;
		
		public Person(String firstName, String lastName, String adress, String phone,
				String email) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.adress = adress;
			this.city = "Culver";
			this.zip = 97451;
			this.phone = phone;
			this.email = email;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getAdress() {
			return adress;
		}

		public void setAdress(String adress) {
			this.adress = adress;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getCity() {
			return city;
		}

		public int getZip() {
			return zip;
		}
		

}
