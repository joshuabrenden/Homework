
public class Person implements Comparable<Person> {
	private String firstName;
	private String lastName;
	private String state;
	private String street;
	private String city;
	private String zip;

	public Person(String firstName, String lastName, String street, String city, String state, String zip) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.state = state;
		this.street = street;
		this.city = city;
		this.zip = zip;
	}

	public String toString() {

		StringBuilder builder = new StringBuilder();
		builder.append(firstName).append(" ").append(lastName).append(" | ").append(street).append(" | ").append(city)
				.append(" | ").append(state).append(" | ").append(zip).append("\n");

		return builder.toString();
	}

	public void printPerson() {
		System.out.println("Name: " + lastName + ", " + firstName);
		System.out.println("Street: " + street);
		System.out.println("City: " + city);
		System.out.println("State: " + state);
		System.out.println("Zip: " + zip);

	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getStreet() {
		return street;
	}

	public String getState() {
		return state;
	}

	public String getCity() {
		return city;
	}

	public String getZip() {
		return zip;
	}

	@Override
	public int compareTo(Person otherPerson) {
		int result = this.lastName.compareToIgnoreCase(otherPerson.lastName);

		if (result == 0) {
			result = this.firstName.compareToIgnoreCase(otherPerson.firstName);

			if (result == 0) {
				result = this.state.compareToIgnoreCase(otherPerson.state);

				if (result == 0) {
					result = this.city.compareToIgnoreCase(otherPerson.city);

					if (result == 0) {
						result = this.zip.compareToIgnoreCase(otherPerson.zip);

						if (result == 0) {
							result = this.street.compareToIgnoreCase(otherPerson.street);
						}
					}
				}
			}
		}

		return result;
	}

}
