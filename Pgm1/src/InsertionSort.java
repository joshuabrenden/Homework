import java.util.List;

public class InsertionSort implements ISort {
	
	List<Person> unsortedPersons;
	List<Person> sortedPersons;
	
	public InsertionSort(List<Person> unsortedPersons){
		this.unsortedPersons = unsortedPersons;
	}

	@Override
	public void execute() {
		sortedPersons = unsortedPersons;
	}

	@Override
	public List<Person> getSortedPersons() {
		return sortedPersons;
		
	}
}
