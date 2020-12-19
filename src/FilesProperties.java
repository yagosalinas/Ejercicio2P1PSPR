import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FilesProperties {

	public FilesProperties() {
	}

	public BufferedReader getBufferedReader(String fileName) {
		BufferedReader br = null;
		File file = new File(fileName);
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return br;
	}

	public PrintWriter getPrintWriter(String fileName) {
		PrintWriter pw = null;
		File file = new File(fileName);
		try {
			pw = new PrintWriter(new FileWriter(file, true));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pw;
	}

}
