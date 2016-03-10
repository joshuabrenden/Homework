import java.util.Arrays;
import java.util.List;

public class MergeSort implements ISort {
	
	List<Person> unsortedPersons;
	List<Person> sortedPersons;
	
	public MergeSort(List<Person> unsortedPersons){
		this.unsortedPersons = unsortedPersons;
	}

	@Override
	public void execute() {
		Person[] personArray = unsortedPersons.toArray(new Person[unsortedPersons.size()]);
		mergeSort(personArray);
		sortedPersons = Arrays.asList(personArray);
	}

	@Override
	public List<Person> getSortedPersons() {
		return sortedPersons;
	}
	
	private void mergeSort(Person[] personArray){
		if(personArray.length < 2){
			return;
		}
		
		Integer middle = personArray.length / 2;
		Integer end = personArray.length;
		
		Person[] left = new Person[middle];
		Person[] right = new Person[end - middle];
		
		for(int i =0;i < middle; i++){
			left[i] = personArray[i];
		}
		
		for(int i = middle; i < end; i++){
			right[i - middle] = personArray[i];
		}
		
		mergeSort(left);
		mergeSort(right);
		
		merge(personArray, left, right);
		
	}
	
	private void merge(Person[] personArray, Person[] left, Person[] right){
		Integer fullIndex = 0;
		Integer leftIndex = 0;
		Integer rightIndex = 0;
		
		Integer leftSize = left.length;
		Integer rightSize = right.length;
		
		while(leftIndex < leftSize && rightIndex < rightSize){
			if(left[leftIndex].compareTo(right[rightIndex]) < 0){
				personArray[fullIndex] = left[leftIndex];
				leftIndex++;
			} else {
				personArray[fullIndex] = right[rightIndex];
				rightIndex++;
			}
			
			fullIndex++;
		}
		
		while(leftIndex < leftSize){
			personArray[fullIndex] = left[leftIndex];
			fullIndex++;
			leftIndex++;
		}
		
		while(rightIndex < rightSize){
			personArray[fullIndex] = right[rightIndex];
			fullIndex++;
			rightIndex++;
		}
		
	}
}
