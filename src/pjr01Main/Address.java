package pjr01Main;

public class Address {
	String Add;	//post add.
	String Zip;	//zipcode
	String city;
	
	/**
	 * 
	 * @param add
	 * @param zip
	 * @param city
	 */
	public Address(String add, String zip, String city) {
		super();
		Add = add;
		Zip = zip;
		this.city = city;
	}

	public String getAdd() {
		return Add;
	}

	public void setAdd(String add) {
		Add = add;
	}

	public String getZip() {
		return Zip;
	}

	public void setZip(String zip) {
		Zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	
}
