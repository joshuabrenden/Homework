import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonBuilder {
	public PersonBuilder() {

	}

	public ArrayList<Person> buildPersonList(ArrayList<String> personStrings) {
		ArrayList<Person> personArray = new ArrayList<>();

		for (String s : personStrings) {
			personArray.add(buildPerson(s));
		}

		return personArray;
	}

	private Person buildPerson(String personString) {

		String[] personAttributes = personString.split(" \\| ");

		String firstName = splitFirstName(personAttributes[0]);
		String lastName = splitLastName(personAttributes[0]);

		String street = personAttributes[1];
		String city = personAttributes[2];
		String state = personAttributes[3];
		String zip = personAttributes[4];

		Person person = new Person(firstName, lastName, street, city, state, zip);
		return person;
	}

	public static String splitFirstName(String fullName) {
		return fullName.split(" ")[0];
	}

	public static String splitLastName(String fullName) {
		return fullName.split(" ")[1];
	}
}
