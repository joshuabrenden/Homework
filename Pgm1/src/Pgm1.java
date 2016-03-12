import java.util.ArrayList;
import java.util.List;

public class Pgm1 {
	public static void main(String[] args) {

		for (String inputFileName : loadTestFiles()) {
			ReadFile readFile = new ReadFile(inputFileName);

			PersonBuilder builder = new PersonBuilder();
			List<Person> persons = builder.buildPersonList(readFile.buildArrayFromFile());
			Integer lineCount = readFile.getLineCount();

			runMergeSort(persons, inputFileName, lineCount);
			runQuickSort(persons, inputFileName, lineCount);
			runInsertionSort(persons, inputFileName, lineCount);
		}
	}

	public static List<String> loadTestFiles() {
		List<String> testFiles = new ArrayList<>();
		testFiles.add("10People.txt");
		testFiles.add("100People.txt");
		testFiles.add("1000People.txt");
		testFiles.add("10000People.txt");
		return testFiles;
	}
	
	public static void runQuickSort(List<Person> persons, String inputFileName, Integer lineCount){
		QuickSort quickSort = new QuickSort(persons);
		long startTime = System.nanoTime();
		
		quickSort.execute();
		long endTime = System.nanoTime();
		String duration = String.format( "%.2f", (endTime - startTime) / 1000000.0);
		String durationAverage = String.format( "%.4f", ((endTime - startTime) / 1000000.0) / lineCount);
		System.out.println(lineCount + " rows using quicksort: " + duration + "ms. Avg " + durationAverage + "ms per row.");
		
		OutFile quickSortResults = new OutFile("QuickSortResults-" + inputFileName, quickSort.getSortedPersons(),
				lineCount);
		quickSortResults.buildOutFile();
	}
	
	public static void runInsertionSort(List<Person> persons, String inputFileName, Integer lineCount){
		InsertionSort insertionSort = new InsertionSort(persons);
		long startTime = System.nanoTime();
		
		insertionSort.execute();
		long endTime = System.nanoTime();
		String duration = String.format( "%.2f", (endTime - startTime) / 1000000.0);
		String durationAverage = String.format( "%.4f", ((endTime - startTime) / 1000000.0) / lineCount);
		System.out.println(lineCount + " rows using insertionSort: " + duration + "ms. Avg " + durationAverage + "ms per row.");
		
		OutFile insertionSortResults = new OutFile("InsertionSortResults-" + inputFileName,
				insertionSort.getSortedPersons(), lineCount);
		insertionSortResults.buildOutFile();
	}
	
	public static void runMergeSort(List<Person> persons, String inputFileName, Integer lineCount){
		MergeSort mergeSort = new MergeSort(persons);
		long startTime = System.nanoTime();
		
		mergeSort.execute();
		long endTime = System.nanoTime();
		String duration = String.format( "%.2f", (endTime - startTime) / 1000000.0);
		String durationAverage = String.format( "%.4f", ((endTime - startTime) / 1000000.0) / lineCount);
		System.out.println(lineCount + " rows using mergesort: " + duration + "ms. Avg " + durationAverage + "ms per row.");
		
		OutFile mergeSortResults = new OutFile("MergeSortResults-" + inputFileName, mergeSort.getSortedPersons(),
				lineCount);
		mergeSortResults.buildOutFile();
	}
	

}
