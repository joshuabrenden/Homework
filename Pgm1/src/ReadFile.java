import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadFile {

	private Integer lineCount;
	private String fileName;

	public ReadFile(String fileName) {
		this.fileName = fileName;

	}

	public ArrayList<String> buildArrayFromFile() {
		ArrayList<String> personStrings = new ArrayList<>();
		try (InputStream iStream = new FileInputStream(fileName)) {

			InputStreamReader iStreamReader = new InputStreamReader(iStream);
			BufferedReader reader = new BufferedReader(iStreamReader);

			setLineCount(reader.readLine());

			String line;
			while ((line = reader.readLine()) != null) {
				personStrings.add(line);
			}

		} catch (IOException e) {
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
