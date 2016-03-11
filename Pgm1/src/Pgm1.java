import java.util.ArrayList;
import java.util.List;

public class Pgm1 {
	public static void main(String[] args) {

		for (String inputFileName : loadTestFiles()) {
			ReadFile readFile = new ReadFile(inputFileName);

			PersonBuilder builder = new PersonBuilder();
			List<Person> persons = builder.buildPersonList(readFile.buildArrayFromFile());
			Integer lineCount = readFile.getLineCount();

			runQuickSort(persons, inputFileName, lineCount);
			runInsertionSort(persons, inputFileName, lineCount);
			runMergeSort(persons, inputFileName, lineCount);
		}
	}

	public static List<String> loadTestFiles() {
		List<String> testFiles = new ArrayList<>();
		testFiles.add("10People.txt");
		testFiles.add("100People.txt");
		testFiles.add("1000People.txt");
		return testFiles;
	}
	
	public static void runQuickSort(List<Person> persons, String inputFileName, Integer lineCount){
		QuickSort quickSort = new QuickSort(persons);
		quickSort.execute();
		OutFile quickSortResults = new OutFile("QuickSortResults-" + inputFileName, quickSort.getSortedPersons(),
				lineCount);
		quickSortResults.buildOutFile();
	}
	
	public static void runInsertionSort(List<Person> persons, String inputFileName, Integer lineCount){
		InsertionSort insertionSort = new InsertionSort(persons);
		insertionSort.execute();
		OutFile insertionSortResults = new OutFile("InsertionSortResults-" + inputFileName,
				insertionSort.getSortedPersons(), lineCount);
		insertionSortResults.buildOutFile();
	}
	
	public static void runMergeSort(List<Person> persons, String inputFileName, Integer lineCount){
		MergeSort mergeSort = new MergeSort(persons);
		mergeSort.execute();
		OutFile mergeSortResults = new OutFile("MergeSortResults-" + inputFileName, mergeSort.getSortedPersons(),
				lineCount);
		mergeSortResults.buildOutFile();
	}
	

}
