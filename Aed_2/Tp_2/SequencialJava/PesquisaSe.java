import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.File;

public class PesquisaSe {


	public static void main(String[] args) throws IOException {
		long tempoInicial = System.currentTimeMillis();
		String[] pubIn = new String[500];
		int x = 0;
		pubIn[x] = MyIO.readLine();
		while (pubIn[x].equals("FIM") != true) {
			x++;
			pubIn[x] = MyIO.readLine();

		}
		String[] pubinTest = new String[500];
		int y = 0;
		pubinTest[y] = MyIO.readLine();
		while (pubinTest[y].equals("FIM") != true) {
			y++;
			pubinTest[y] = MyIO.readLine();
		}
		int i = 0;
		for (i = 0; i < y; i += 1) {
			if (toCheck(pubIn, pubinTest[i], x)) {
				System.out.println("SIM");
			} else {
				System.out.println("NAO");
			}
		}
		int numeroComparacoes = i * y;
		wreiterFile(System.currentTimeMillis() - tempoInicial, numeroComparacoes);

	}

	public static boolean toCheck(String[] pubIn, String test, int y) {
		for (int z = 0; z < y; z += 1) {
			if (test.equals(pubIn[z])) {
				return true;
			}
		}
		return false;

	}

	public static void wreiterFile(long l, int numeroComparacoes) throws IOException {
		File arquivo = new File("matricula_sequenecial.txt");
		try {
			if (!arquivo.exists()) {
				arquivo.createNewFile();
			}
			FileWriter ttt = new FileWriter(arquivo);
			BufferedWriter escrita = new BufferedWriter(ttt);
			escrita.write("Matrucula: 694493 " + "Tempo: " + l + "" + "Comparacoes: " + numeroComparacoes);
			escrita.close();
			ttt.close();

		} catch (Exception e) {

		} 

	}

}