import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FilesManagedment {
	
	public static boolean counter(String fileName, char vowel, char vowelCapital, String fileResultName) {
		boolean bool = true;
		try {
			FilesProperties fp = new FilesProperties();
			BufferedReader bf = fp.getBufferedReader(fileName);
			File result = new File(fileResultName);
			result.createNewFile();
			System.out.println(fileResultName+"se crea");
			PrintWriter pw = fp.getPrintWriter(fileResultName);
			int contador = 0;
			String linea;
			do{
				int i = 0;
				int lnum = 1;
				linea = bf.readLine();
				lnum = linea.length();
				while (i < lnum) {
					if (linea.charAt(i) == vowel | linea.charAt(i) == vowelCapital) {
						contador++;
					}
					i++;
				}
			}while (linea != null);
			pw.println(contador);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
			bool = false;
		}
		return bool;
	}

	public static void main(String[] args) {
		counter(args[0], args[1].charAt(0), args[1].toUpperCase().charAt(0), args[2]);
	}
}
