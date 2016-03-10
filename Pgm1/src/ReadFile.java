import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

	private Integer lineCount;
	private String fileName;

	public ReadFile(String fileName) {
		this.fileName = fileName;

	}

	public List<String> buildArrayFromFile() {
		List<String> personStrings = new ArrayList<>();
		URL path = getClass().getResource(fileName);

		try {
			File inputFile = new File(path.toURI());
			FileReader fileReader = new FileReader(inputFile);

			BufferedReader reader = new BufferedReader(fileReader);
			setLineCount(reader.readLine());

			String line;
			while ((line = reader.readLine()) != null) {
				personStrings.add(line);
			}

			reader.close();

		} catch (IOException | URISyntaxException e) {
			System.out.println(e.getMessage() + e);
		}

		return personStrings;
	}

	private boolean tryParseInt(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private void setLineCount(String firstLine) {
		if (tryParseInt(firstLine)) {
			lineCount = Integer.parseInt(firstLine);
		}
	}

	public Integer getLineCount() {
		return lineCount;
	}
}
