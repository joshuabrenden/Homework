import java.util.ArrayList;

public class Pgm1 {
	public static void main(String[] args) {

		String inputFileName = "/home/josh/Documents/Projects/Workspaces/Main/Pgm1/src/Input.txt";
		String outputFilePath = "/home/josh/Documents/Projects/Workspaces/Main/Pgm1/src/";
		ReadFile readFile = new ReadFile(inputFileName);
		Integer lineCount = readFile.getLineCount();
		
		PersonBuilder builder = new PersonBuilder();
		ArrayList<Person> persons = builder.buildPersonList(readFile.buildArrayFromFile());
		
		QuickSort quickSort = new QuickSort(persons);
		quickSort.execute();
		OutFile quickSortResults = new OutFile(outputFilePath + "QuickSortResults.txt", quickSort.getSortedPersons(), lineCount);
		quickSortResults.buildOutFile();
		
		MergeSort mergeSort = new MergeSort(persons);
		mergeSort.execute();
		OutFile mergeSortResults = new OutFile(outputFilePath + "MergeSortResults.txt", mergeSort.getSortedPersons(), lineCount);
		mergeSortResults.buildOutFile();
		
		InsertionSort insertionSort = new InsertionSort(persons);
		insertionSort.execute();
		OutFile insertionSortResults = new OutFile(outputFilePath + "InsertionSortResults.txt", insertionSort.getSortedPersons(), lineCount);
		insertionSortResults.buildOutFile();
		
	}

}
