import java.util.List;

public class QuickSort implements ISort {

	List<Person> unsortedPersons;
	Person[] personArray;

	public QuickSort(List<Person> unsortedPersons) {
		this.unsortedPersons = unsortedPersons;
	}

	@Override
	public void execute() {
		personArray = unsortedPersons.toArray(new Person[unsortedPersons.size()]);

		Integer high = personArray.length - 1;
		Integer low = 0;

		quickSort(low, high);
	}

	@Override
	public List<Person> getSortedPersons() {
		return unsortedPersons;

	}

	private void quickSort(Integer low, Integer high){
		Integer lowIndex = low;
		Integer highIndex = high;
		
		Person pivotPerson = personArray[lowIndex + (highIndex - lowIndex) / 2];
		if(highIndex - lowIndex >= 1){
			while(lowIndex <= highIndex){
				
				while(personArray[lowIndex].compareTo(pivotPerson) < 0){
					lowIndex++;
				}
				
				while(personArray[highIndex].compareTo(pivotPerson) > 0){
					highIndex--;
				}
				
				if(lowIndex <= highIndex){
					rotate(lowIndex, highIndex);
					lowIndex++;
					highIndex++;
				}
			}
			
			
		}
	}
	
	private void rotate(Integer low, Integer high){
	
	}
}
