package dataProviders;

import com.github.javafaker.Faker;

public class FakeDataGenerator {

	
public String GetFakeData(String Category)
{
	String value = null;
	Faker faker = new Faker();
	switch (Category)
	{ 
	case "CompanyName" :
		value = faker.name().toString();
		break;
	case  "FirstName" :
		value = faker.firstName().toString();
		break;
	case  "Lastname" :
		value = faker.lastName().toString();
		break;
	}
	return value;
	
}
}
