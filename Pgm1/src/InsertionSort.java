import java.util.Arrays;
import java.util.List;

public class InsertionSort implements ISort {

	List<Person> unsortedPersons;
	List<Person> sortedPersons;
	Person[] personArray;

	public InsertionSort(List<Person> unsortedPersons) {
		this.unsortedPersons = unsortedPersons;
	}

	@Override
	public void execute() {
		personArray = unsortedPersons.toArray(new Person[unsortedPersons.size()]);
		insertionSort();

		sortedPersons = Arrays.asList(personArray);
	}

	@Override
	public List<Person> getSortedPersons() {
		return sortedPersons;

	}

	private void insertionSort() {
		Person tempPerson;
		for (int i = 1; i < personArray.length; i++) {
			for (int j = i; j > 0; j--) {

				if (personArray[j].compareTo(personArray[j - 1]) < 0) {

					tempPerson = personArray[j];
					personArray[j] = personArray[j - 1];
					personArray[j - 1] = tempPerson;
				}
			}
		}
	}
}
