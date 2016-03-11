import java.util.Arrays;
import java.util.List;

public class QuickSort implements ISort {

	List<Person> unsortedPersons;
	Person[] personArray;
	private List<Person> sortedPersons;

	public QuickSort(List<Person> unsortedPersons) {
		this.unsortedPersons = unsortedPersons;
	}

	@Override
	public void execute() {
		personArray = unsortedPersons.toArray(new Person[unsortedPersons.size()]);

		int high = personArray.length - 1;
		int low = 0;

		quickSort(low, high);
		sortedPersons = Arrays.asList(personArray);
	}

	@Override
	public List<Person> getSortedPersons() {
		return sortedPersons;

	}

	private void quickSort(int low, int high) {
		int lowIndex = low;
		int highIndex = high;
		int pivotIndex = low + (high - low) / 2;

		Person pivotPerson = personArray[pivotIndex];

		while (lowIndex <= highIndex) {

			while (personArray[lowIndex].compareTo(pivotPerson) < 0) {
				lowIndex++;
			}

			while (personArray[highIndex].compareTo(pivotPerson) > 0) {
				highIndex--;
			}

			if (lowIndex <= highIndex) {
				rotate(lowIndex, highIndex);
				lowIndex++;
				highIndex--;
			}
		}

		if (low < highIndex) {
			quickSort(low, highIndex);
		}

		if (lowIndex < high) {
			quickSort(lowIndex, high);
		}

	}

	private void rotate(int low, int high) {
		Person tempPerson = personArray[low];
		personArray[low] = personArray[high];
		personArray[high] = tempPerson;
	}
}
