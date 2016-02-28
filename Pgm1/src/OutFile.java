import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OutFile {

	private Integer lineCount;
	private String fileName;
	private ArrayList<Person> personArray;

	public OutFile(String fileName, ArrayList<Person> personArray, Integer lineCount) {
		this.fileName = fileName;
		this.personArray = personArray;
		this.lineCount = lineCount;
	}

	public void buildOutFile() {

		try (FileWriter fileWriter = new FileWriter(createFile().getAbsoluteFile())) {
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(lineCount.toString() + "\n");
			
			for(Person p : personArray){
				bufferedWriter.write(p.toString());
			}
			
			bufferedWriter.close();
		} catch (IOException e) {
			System.out.println(e.getMessage() + e);
		}
	}

	private File createFile() {
		File file = new File(fileName);
		try {

			if (!file.exists()) {
				file.createNewFile();
			} else {
				file.delete();
				file.createNewFile();
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage() + e);
		}
		return file;
	}
}
