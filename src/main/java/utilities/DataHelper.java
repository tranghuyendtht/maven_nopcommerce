package utilities;

import java.util.Locale;

import com.github.javafaker.Faker;

public class DataHelper {
	private Locale locale = new Locale("en");
	private Faker faker = new Faker(locale);
	
	public static DataHelper getData() {
		return new DataHelper();
	}
	
	public String getFirstName() {
		return faker.address().firstName();
	}
	
	public String getLastName() {
		return faker.address().lastName();
	}
	
	public String getEmailAddress() {
		return faker.internet().emailAddress();
	}
	
	public String getCity() {
		return faker.address().cityName();
	}
	
	public String getAddress1() {
		return faker.address().fullAddress();
	}
	
	public String getZipPotalCode() {
		return faker.address().zipCode();
	}
	
	public String getPhoneNumber() {
		return faker.phoneNumber().phoneNumber();
	}
	

}
