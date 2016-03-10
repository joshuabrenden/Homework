import java.util.List;

public class Pgm1 {
	public static void main(String[] args) {

		String inputFileName = "Input.txt";
		ReadFile readFile = new ReadFile(inputFileName);
		
		PersonBuilder builder = new PersonBuilder();
		List<Person> persons = builder.buildPersonList(readFile.buildArrayFromFile());
		Integer lineCount = readFile.getLineCount();
		
		//Change to a sort factory
		QuickSort quickSort = new QuickSort(persons);
		quickSort.execute();
		OutFile quickSortResults = new OutFile("QuickSortResults.txt", quickSort.getSortedPersons(), lineCount);
		quickSortResults.buildOutFile();
		
		InsertionSort insertionSort = new InsertionSort(persons);
		insertionSort.execute();
		OutFile insertionSortResults = new OutFile("InsertionSortResults.txt", insertionSort.getSortedPersons(), lineCount);
		insertionSortResults.buildOutFile();

		MergeSort mergeSort = new MergeSort(persons);
		mergeSort.execute();
		OutFile mergeSortResults = new OutFile("MergeSortResults.txt", mergeSort.getSortedPersons(), lineCount);
		mergeSortResults.buildOutFile();
	}

}
