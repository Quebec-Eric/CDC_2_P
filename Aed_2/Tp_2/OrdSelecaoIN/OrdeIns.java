

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.*;

class Musica {
	private String id;
	private String name;
	private String key;
	private List<String> artistas = new ArrayList<>();
	private String realease_date;
	private double acousticness;
	private double danceability;
	private double energy;
	private int duration_ms;
	private double instrumentalness;
	private double valence;
	private int popularity;
	private float tempo;
	private double liveness;
	private double loudness;
	private double speechiness;
	private int year;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return name;
	}

	public void setNome(String nome) {
		this.name = nome;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<String> getArtistas() {
		return artistas;
	}

	public void setArtistas(List<String> artistas) {
		this.artistas = artistas;
	}

	public String getRealease_date() {
		return realease_date;
	}

	public void setRealease_date(String realease_date) {
		this.realease_date = realease_date;
	}

	public double getAcousticness() {
		return acousticness;
	}

	public void setAcousticness(double acousticness) {
		this.acousticness = acousticness;
	}

	public double getDanceability() {
		return danceability;
	}

	public void setDanceability(double danceability) {
		this.danceability = danceability;
	}

	public double getEnergy() {
		return energy;
	}

	public void setEnergy(double energy) {
		this.energy = energy;
	}

	public int getDuration_ms() {
		return duration_ms;
	}

	public void setDuration_ms(int duration_ms) {
		this.duration_ms = duration_ms;
	}

	public double getInstrumentalness() {
		return instrumentalness;
	}

	public void setInstrumentalness(double instrumentalness) {
		this.instrumentalness = instrumentalness;
	}

	public double getValence() {
		return valence;
	}

	public void setValence(double valence) {
		this.valence = valence;
	}

	public int getPopularity() {
		return popularity;
	}

	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}

	public float getTempo() {
		return tempo;
	}

	public void setTempo(float tempo) {
		this.tempo = tempo;
	}

	public double getLiveness() {
		return liveness;
	}

	public void setLiveness(double liveness) {
		this.liveness = liveness;
	}

	public double getLoudness() {
		return loudness;
	}

	public void setLoudness(double loudness) {
		this.loudness = loudness;
	}

	public double getSpeechiness() {
		return speechiness;
	}

	public void setSpeechiness(double speechiness) {
		this.speechiness = speechiness;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Musica() {
		super();
		this.id = "";
		this.name = "";
		this.key = "";
		this.realease_date = "1";
		this.acousticness = 1;
		this.danceability = 1;
		this.energy = 1;
		this.duration_ms = 1;
		this.instrumentalness = 1;
		this.valence = 1;
		this.popularity = 1;
		this.tempo = 1;
		this.liveness = 1;
		this.loudness = 1;
		this.speechiness = 1;
		this.year = 1;
	}

	/* Metodo toString */
	public String toString() {
		return this.id + " ## " + this.artistas + " ## " + this.name + " ## " + this.realease_date + " ## "
				+ this.acousticness + " ## " + this.danceability + " ## " + this.instrumentalness + " ## "
				+ this.liveness + " ## " + this.loudness + " ## " + this.speechiness + " ## " + this.energy + " ## "
				+ this.duration_ms;

	}

}

public class OrdeIns {
	public static void main(String[] args) throws IOException {
		String linhaArquivo = "";
		String[] entradaDados = new String[600];

		int variarAloca = 0;
		BufferedReader conteudoCsv = null;
		entradaDados[variarAloca] = MyIO.readLine();
		while (entradaDados[variarAloca].equals("FIM") != true) {
			variarAloca += 1;
			entradaDados[variarAloca] = MyIO.readLine();

		}
		try {
			conteudoCsv = new BufferedReader(new FileReader("/tmp/data.csv"));
			String[] saidas = new String[variarAloca];
			int y = 0;
			linhaArquivo = conteudoCsv.readLine();
			while ((linhaArquivo = conteudoCsv.readLine()) != null) {
				for (int z = 0; z < variarAloca; z++) {

					if (linhaArquivo.contains(entradaDados[z])) {
						Musica resposta = extrairMusica(linhaArquivo);
						saidas[y] = resposta.toString();
						y++;
						// System.out.println(resposta.toString());
					}
				}

			}
		ordenacaoIns(saidas,y);
		} catch (IOException e) {
			System.out.println("Erro :" + e);
		} finally {
			conteudoCsv.close();
		}

	}


	    public static void ordenacaoIns(String []saidas,int y){
          String []nomes= new String[y];
          for(int x=0;x<saidas.length;x+=1){
            // System.out.println("------"+saidas[x]);
              nomes[x]=pegarId(saidas[x]);
          }
       		String []resultado= insertionSort(nomes);
       			          
			for (int p = 0; p < resultado.length; p += 1) {
				for (int j = 0; j < saidas.length; j += 1) {
					if (saidas[j].contains(resultado[p])) {
						System.out.println(saidas[j]);
					}
				}
			}
			
		
        }
		 public static String [] insertionSort(String [] ids) {
    		int j;
    		String key;
    		int i;
	   		 for (j = 1; j < ids.length; j++) {
    	  		key = ids[j];
      				for (i = j - 1; (i >= 0) && (ids[i].compareTo(key)>0); i--) {
       		 			ids[i + 1] = ids[i];
      				}
      			ids[i + 1] = key;
    		}
		return ids;
  		}




		
   
	

	/* Funcao onde ira alocar todas na class */
	public static Musica extrairMusica(String linha) {
		Musica musica = new Musica();
		musica.setArtistas(pegarNomesArtistar(linha));
		String[] renovada = pegarPrimeirosValores(linha);
		musica.setValence(Double.parseDouble(renovada[0]));
		musica.setYear(Integer.parseInt(renovada[1]));
		musica.setAcousticness(Double.parseDouble(renovada[2]));
		linha = fazerStringNova(linha);
		if (linha.contains("\"")) {
			musica.setNome(tirarONome(linha));
			String[] respostafinal = pegarTudoSemNomes(linha);
			musica.setDanceability(Double.parseDouble(respostafinal[0]));
			musica.setDuration_ms(Integer.parseInt(respostafinal[1]));
			musica.setEnergy(Double.parseDouble(respostafinal[2]));
			// a resposta 3 e explicit que tb nao foi pedida
			musica.setId(respostafinal[4]);
			musica.setInstrumentalness(Double.parseDouble(respostafinal[5]));
			musica.setKey(respostafinal[6]);
			musica.setLiveness(Double.parseDouble(respostafinal[7]));
			musica.setLoudness(Double.parseDouble(respostafinal[8]));
			// a resposta 9 e o mode que nao foi pedido para usar
			musica.setPopularity(Integer.parseInt(respostafinal[11]));
			if (respostafinal[12].length() > 4) {

				musica.setRealease_date(mudarS(respostafinal[12].replace("-", "/")));
			} else {
				String colocarData = "01/01/" + respostafinal[12];
				musica.setRealease_date(colocarData);
			}

			musica.setSpeechiness(Double.parseDouble(respostafinal[13]));
			musica.setTempo(Float.parseFloat(respostafinal[14]));

		} else {
			String[] resposta = pegarTodosValores(linha);
			musica.setDanceability(Double.parseDouble(resposta[0]));
			musica.setDuration_ms(Integer.parseInt(resposta[1]));
			musica.setEnergy(Double.parseDouble(resposta[2]));
			// a resposta 3 e explicit que tb nao foi pedida
			musica.setId(resposta[4]);
			musica.setInstrumentalness(Double.parseDouble(resposta[5]));
			musica.setKey(resposta[6]);
			musica.setLiveness(Double.parseDouble(resposta[7]));
			musica.setLoudness(Double.parseDouble(resposta[8]));
			// a resposta 9 e o mode que nao foi pedido para usar
			musica.setNome(resposta[10]);
			musica.setPopularity(Integer.parseInt(resposta[11]));
			if (resposta[12].length() > 4) {
				musica.setRealease_date(mudarS(resposta[12].replace("-", "/")));
			} else {
				String colocarData = "01/01/" + resposta[12];
				musica.setRealease_date(colocarData);
			}
			musica.setSpeechiness(Double.parseDouble(resposta[13]));
			musica.setTempo(Float.parseFloat(resposta[14]));

		}

		return musica;
	}
  public static List<String> pegarNomesArtistar(String linha) {
    List<String> nomes = new ArrayList<>();
    char tt = '"';
    int inicioaSerCortado = linha.indexOf("[");
    int fimaSerCortado = linha.indexOf("]");
    String todosNomes = linha.substring(inicioaSerCortado + 1, fimaSerCortado);
    String[] tirarVirgula = todosNomes.split(",");
    if (tirarVirgula.length > 1) {
     
      for (int i = 0; i < tirarVirgula.length; i++) {
      if (tirarVirgula[i].charAt(1) == tt && tirarVirgula[i].charAt(2) == tt) {

      } 
      }
       String[] eric = todosNomes.split("'");
          for (int k = 0; k < eric.length; k += 1) {
            if (k % 2 != 0) {

              nomes.add(eric[k]);
            }
          }


    } else {

      if (tirarVirgula[0].charAt(0) == tt && tirarVirgula[0].charAt(1) == tt) {

        nomes.add(tirarVirgula[0].substring(2, tirarVirgula[0].length() - 2));

      } else {

        inicioaSerCortado = tirarVirgula[0].indexOf("'");
        fimaSerCortado = tirarVirgula[0].indexOf("'", inicioaSerCortado + 1);
        String nome = tirarVirgula[0].substring(inicioaSerCortado + 1, fimaSerCortado);
        nomes.add(nome);
      }
    }
    return nomes;
  }
	

	public static String[] pegarPrimeirosValores(String linha) {
		int fimaSerCortado = linha.indexOf("[");
		String retirada = linha.substring(0, fimaSerCortado);
		String[] tirarVirgula = retirada.split(",");
		return tirarVirgula;

	}

	public static String fazerStringNova(String linha) {
		int fimaSerCortado = linha.indexOf("]");
		String retirada = linha.substring(fimaSerCortado);
		fimaSerCortado = retirada.indexOf(",");
		String novaString = retirada.substring(fimaSerCortado + 1);

		return novaString;
	}

	public static String[] pegarTodosValores(String linha) {
		String[] tirarVirgula = linha.split(",");

		return tirarVirgula;
	}

	public static String tirarONome(String linha) {
		int inicioaSerCortado = linha.indexOf("\"");
		int fimaSerCortado = linha.indexOf("\"", inicioaSerCortado + 1);
		String retirada = linha.substring(inicioaSerCortado + 1, fimaSerCortado);

		return retirada;
	}

	public static String[] pegarTudoSemNomes(String linha) {
		int inicioaSerCortado = linha.indexOf("\"");
		int fimaSerCortado = linha.indexOf("\"", inicioaSerCortado + 1);
		String retirada = linha.substring(0, inicioaSerCortado);
		String depois = linha.substring(fimaSerCortado + 1);
		String retidadoNomes = retirada.concat(depois);
		String[] tirarVirgula = retidadoNomes.split(",");

		return tirarVirgula;
	}

	public static String mudarS(String linha){
  	String []tt= linha.split("/");
    String nova="";
    nova+=tt[2]+"/";
    nova+=tt[1]+"/";
    nova+=tt[0];
	return nova;

	}
	 public static String pegarId(String linha) {

    	int fimaSerCortado = linha.indexOf("#");
    	String idCom = linha.substring(0, fimaSerCortado - 1);
   	 return idCom;
  	}

}