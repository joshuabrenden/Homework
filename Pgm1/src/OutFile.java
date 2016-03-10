import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OutFile {

	private Integer lineCount;
	private String fileName;
	private List<Person> persons;

	public OutFile(String fileName, List<Person> persons, Integer lineCount) {
		this.fileName = fileName;
		this.persons = persons;
		this.lineCount = lineCount;
	}

	public void buildOutFile() {

		try (FileWriter fileWriter = new FileWriter(createFile())) {
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(lineCount.toString() + "\n");
			
			for(Person p : persons){
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
