
/************* *****************
*   Eric Azevedo de Oliveira  *
*   Aluno da Puc              *
*   2 periodo                 *
*******************************/

import java.io.FileWriter;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.*;
import java.io.BufferedWriter;
import java.io.File;

// class musica
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

// set e gets
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

// contrutor
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

class NoPrimeiro{

  public int durationMod;
  public NoPrimeiro esquerda;
  public NoPrimeiro direita;
  public NoSegundo outro;

  public NoPrimeiro(int elemento){
      this.durationMod=elemento;
      this.esquerda=this.direita=null;
      this.outro=null;
  }
  public NoPrimeiro(int elemento, NoPrimeiro esq, NoPrimeiro direita,NoSegundo outro) {
	   this.durationMod = elemento;
	   this.esquerda = esquerda;
	   this.direita = direita;
	   this.outro = outro;
	}

}

 class NoSegundo{
    public Musica musicas;
    public NoSegundo esquerda;
    public NoSegundo direita;

  public NoSegundo(Musica musicas) {
	   this(musicas,null,null);
	}

public NoSegundo(Musica musicas, NoSegundo esquerda, NoSegundo direita) {
	   this.musicas = musicas;
	   this.esquerda = esquerda;
	   this.direita = direita;
	}

 }

 class Arvore{
   private NoPrimeiro raiz;
   	private int numeroComparacoes;
   public Arvore() throws IOException{
     raiz=null;
        insetir(7);
        insetir(3);
        insetir(11);
        insetir(1);
        insetir(5);
        insetir(9);
        insetir(12);
        insetir(0);
        insetir(2);
        insetir(4);
        insetir(6);
        insetir(8);
        insetir(10);
        insetir(13);
        insetir(14);
   }

   private NoPrimeiro inserir(int duration, NoPrimeiro i) throws IOException{
     if(i==null)
      {
          i=new NoPrimeiro(duration);
      }
      else if(duration<i.durationMod)
      {
          i.esquerda=inserir(duration, i.esquerda);
      }
      else if(duration>i.durationMod)
      {
          i.direita=inserir(duration, i.direita);
      }
      return i;
   }
   private void insetir(int idade) throws IOException {
        raiz=inserir(idade, raiz);
    }


    public void inserir2(Musica musicas)  throws IOException{
      inserirTeste(musicas,raiz);
    }

    private void inserirTeste(Musica musicas, NoPrimeiro i)  throws IOException{
       if(musicas.getDuration_ms()%15==i.durationMod)
       {
        i.outro=inserirSec(musicas, i.outro);
        }
        else if(musicas.getDuration_ms()%15<i.durationMod && i.esquerda!=null)
        {
         inserirTeste(musicas, i.esquerda);
        }
        else if(musicas.getDuration_ms()%15>i.durationMod && i.direita!=null)
        {
        inserirTeste(musicas, i.direita);
        }
     }

    private NoSegundo inserirSec(Musica x, NoSegundo i)  throws IOException{
      if (i == null) {
  			i = new NoSegundo(x);
  		} else if (x.getId().compareTo(i.musicas.getId()) < 0) {
  			i.esquerda = inserirSec(x, i.esquerda);
  		} else if (x.getId().compareTo(i.musicas.getId()) > 0) {
  			i.direita = inserirSec(x, i.direita);
  		} else {
  			throw new IOException("Erro ao inserir!");
  		}
  		return i;
  	}

    public boolean pesquisar(String id){
      boolean saberV=false;
      System.out.println(id);
      System.out.print("raiz ");
      return pesquisarT( id, raiz);
    }
    private boolean pesquisarT(String id, NoPrimeiro i){
    boolean saberV=false;
    if(i!=null){
        saberV=pesquisar2(id, i.outro);
        if(saberV==false){
            System.out.print("esq ");
            saberV=pesquisarT(id, i.esquerda);
        }
        if(saberV==false){

            MyIO.print("dir ");
            saberV=pesquisarT(id, i.direita);
        }
    }
    return saberV;
  }

	private boolean pesquisar2(String x, NoSegundo i) {
	   boolean saverV= false;
	   if(i != null){
		  if (x.compareTo(i.musicas.getId())==0) {
			 saverV = true;
		  }
		  else{
		      System.out.print("ESQ ");
		 	    saverV = pesquisar2(x, i.esquerda);
		  	     if(saverV == false){
			            System.out.print("DIR ");
				              saverV = pesquisar2(x, i.direita);
			         }
		       }
	   }
	   return saverV;
	}

 }


//inicio
public class ArvoreDeArvore {
	public static void main(String[] args) throws IOException {
		long tempoInicial = System.currentTimeMillis(); /* saber o tempo de duracao */
		String linhaArquivo = "";
		String[] entradaDados = new String[600];
    Arvore eric= new Arvore();
		int variarAloca = 0;
		BufferedReader conteudoCsv = null;
		entradaDados[variarAloca] = MyIO.readLine();
		/* entrada de dados */
		while (entradaDados[variarAloca].equals("FIM") != true) {
			variarAloca += 1;
			entradaDados[variarAloca] = MyIO.readLine();

		}
		try {
			/* tentar abrir o arquivo */ /// tmp/data.csv
			conteudoCsv = new BufferedReader(new FileReader("/tmp/data.csv"));
			String[] saidas = new String[variarAloca];
			int y = 0;
			linhaArquivo = conteudoCsv.readLine();
			Musica[] resposta1 = new Musica[variarAloca];
			while ((linhaArquivo = conteudoCsv.readLine()) != null) {
				for (int z = 0; z < variarAloca; z++) {

					if (linhaArquivo.contains(entradaDados[z])) { /* pegar so as linhas que foram iguais as entradas */
						resposta1[z] = extrairMusica(linhaArquivo);
						y++;
					}
				}
			}

			for (int i = 0; i < variarAloca; i++) {
				for (int t = 0; t < y; t++) {
					if (entradaDados[i].equals(resposta1[t].getId())) {
						eric.inserir2(resposta1[t]);
						// System.out.println(resposta1[t].getId());
					}
				}
			}

		/*	File arquivo = new File("694493_arvoreBinaria.txt");
			try {
				if (!arquivo.exists()) {
					arquivo.createNewFile();
				}
				eric.setNumeroComp();
				FileWriter ttt = new FileWriter(arquivo);
				BufferedWriter escrita = new BufferedWriter(ttt);
				escrita.write("Matrucula: 694493 ");

				/* entrada de dados */
        String[] pesquisasA = new String[200];
        int pp = 0;
        pesquisasA[pp] = MyIO.readLine();
				while (pesquisasA[pp].equals("FIM") != true) {
					pp += 1;
					pesquisasA[pp] = MyIO.readLine();
				}
        for (int tt = 0; tt < pp; tt++) {
          if (eric.pesquisar(pesquisasA[tt])) {
            System.out.println(" SIM");
            //escrita.write(pesquisasA[tt]+" Comparac "+ eric.getNumeroCom()+" ");
            //eric.setNumeroComp();
          } else {
            System.out.println(" NAO");
            //escrita.write(pesquisasA[tt]+" Comparac "+ eric.getNumeroCom()+" ");
            //eric.setNumeroComp();
          }
        }


	  //long l=	System.currentTimeMillis() - tempoInicial;
		//		escrita.write( "  Tempora de Ex == "+ l);
    //	escrita.close();
				//ttt.close();

			} catch (Exception e) {

			}

  	/*} catch (IOException e) {
			System.out.println("Erro :" + e);
		}
    */


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

	/* Funcao na qual ira pegar todos os nomes dos artistas */
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

	/* funcao que ira pegar os 3 primeiros valores de cada linha */
	public static String[] pegarPrimeirosValores(String linha) {
		int fimaSerCortado = linha.indexOf("[");
		String retirada = linha.substring(0, fimaSerCortado);
		String[] tirarVirgula = retirada.split(",");
		return tirarVirgula;

	}

	/*
	 * Funcao que ira abandonar os valores ja alocados e colocar o restante em uma
	 * string nova
	 */
	public static String fazerStringNova(String linha) {
		int fimaSerCortado = linha.indexOf("]");
		String retirada = linha.substring(fimaSerCortado);
		fimaSerCortado = retirada.indexOf(",");
		String novaString = retirada.substring(fimaSerCortado + 1);

		return novaString;
	}

	/* dar split por virgula em todos os valores */
	public static String[] pegarTodosValores(String linha) {
		String[] tirarVirgula = linha.split(",");

		return tirarVirgula;
	}

	/* pegar os nomes das musicas */
	public static String tirarONome(String linha) {
		int inicioaSerCortado = linha.indexOf("\"");
		int fimaSerCortado = linha.indexOf("\"", inicioaSerCortado + 1);
		String retirada = linha.substring(inicioaSerCortado + 1, fimaSerCortado);

		return retirada;
	}

	/* funcao na qual ira pegar todos os valores menos os nomes da musicas */
	public static String[] pegarTudoSemNomes(String linha) {
		int inicioaSerCortado = linha.indexOf("\"");
		int fimaSerCortado = linha.indexOf("\"", inicioaSerCortado + 1);
		String retirada = linha.substring(0, inicioaSerCortado);
		String depois = linha.substring(fimaSerCortado + 1);
		String retidadoNomes = retirada.concat(depois);
		String[] tirarVirgula = retidadoNomes.split(",");

		return tirarVirgula;
	}

	public static String mudarS(String linha) {
		String[] tt = linha.split("/");
		String nova = "";
		nova += tt[2] + "/";
		nova += tt[1] + "/";
		nova += tt[0];
		return nova;

	}
}
