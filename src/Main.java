import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		String[] vowel = { "a", "e", "i", "o", "u" };
		String ruta = "";
		File fichero;
		for (String v : vowel) {
			ruta = v + "_res.txt";
			fichero = new File(ruta);
			if (fichero.exists()) {
				System.out.println("El fichero " + ruta + " ya existe!");
			try {
					BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
					//introduzco 5 para que no se produzca el java.error por parsear un null, 
					//si no inicializaría el vocal_res vacio cada vez que se ejecute
					//bw.write("");
					bw.write("5");
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					fichero.createNewFile();
					System.out.println("El fichero " + ruta + " se ha creado satisfactoriamente");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			ProcessBuilder pb;
			pb = new ProcessBuilder("java", args[0], v, v + "_res.txt");
			try {
				pb.start();
				pb.redirectError(new File(".\\vocal_" + v.toUpperCase() + "_Err.txt"));

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ruta = "results.txt";
		File file = new File(ruta);
		if (file.exists()) {
			System.out.println("El fichero " + ruta + " ya existe!");
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(file));
				bw.write("");
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			try {
				file.createNewFile();
				System.out.println("El fichero " + ruta + " se ha creado satisfactoriamente");
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		
		FileWriter fw;
		FilesProperties fp = new FilesProperties();
		BufferedReader bf = null;
		PrintWriter pw = null;
		int total= 0;
		try {
			fw = new FileWriter(file, true);
			for (String v : vowel) {
				ruta = v + "_res.txt";
				bf = fp.getBufferedReader(ruta);
				int nvocal = Integer.parseInt(bf.readLine());
				pw = new PrintWriter(fw);
				pw.println(v.toUpperCase()+": "+nvocal);
				total = total+nvocal;
			}
			pw.println("TOTAL: "+total);
			fw.close();
			pw.close();
			bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ruta = "results.txt";
		BufferedReader br = fp.getBufferedReader(ruta);
		String linea;
		do {
			linea = br.readLine();
			System.out.println(linea);
		}while (linea != null);
		System.out.println("Fin del programa");
	}
}
