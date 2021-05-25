/***** *************************
*   Eric Azevedo de Oliveira  *
*   Aluno da Puc              *
*   2 periodo                 *
*******************************/

// inicio class Celula
class Celula {
	public int elemento; // valor da variavel que sera referenciada
	public Celula direita; // ira referenciar a variavel que se encontra a sua direita
	public Celula esquerda; // ira referenciar a variavel que se encontra a esquerda
	public Celula cima; // ira referenciar a variavel que esta em cima dela
	public Celula inferiror; // ira referenciar a variavel que esta na posicao inferior a ela

	public Celula() {
		this(0); // iniciar a celula com o valor 0
	}

	public Celula(int elemento) {
		this.elemento = elemento;// receber o valor fo elemento
		this.direita = this.esquerda = this.cima = this.inferiror = null; // apontar para null com todas as referencias
	}
}
 // inicio class MAtriz
class Matriz {

	private Celula inicio;// basicamente a referencia da matriz
	private int linha; // basicamente as linhas horizontais presentes na variavel
	private int coluna; // referencia as linhas verticas da matriz

	public Matriz() {
		this(4, 4); // passar como parametro iniciar uma matriz 4.4
	}

// criacao da matriz como contrutor
	public Matriz(int linha, int coluna) {

		this.coluna = coluna;
		this.linha = linha;
		Celula i; // referencias
    Celula j; // referencias
		int linhas =1;//iniciar matriz em 11
    int colunas =1; // iniciar a matriz em 11

		// Criar a primeira celula
		inicio = new Celula(777);

    // criar as coluna da matriz as setando com o valor 777;
		for (j = inicio; colunas <coluna; j = j.direita, colunas++) {
			j.direita = new Celula(777); // criar um novo referencias que ira apontar para nulo
			j.direita.esquerda = j; // fazer com que esse apontador aponde para a celula anteriro
		}

    // criando o resto da Matriz

    for(i=inicio;linhas<linha;i=i.inferiror,linhas++){  // criando a primeira coluna completa em si
      i.inferiror = new Celula(777); //criar uma celula inferior a celula inicio
      i.inferiror.cima=i; // referencias a celula criada


      for (j = i.inferiror, colunas = 1; colunas < coluna; j = j.direita, colunas++) {
          j.direita = new Celula(777); // criar um celula na posicao 2.2 e 3.2 conforme uma matriz 3X3
          j.direita.esquerda = j; // fazer com que essacelula refenrecie a celula anteriro
          j.direita.cima = j.cima.direita; // fazer com que a celula referencia a celula de cima
          j.cima.direita.inferiror = j.direita; // fazer isso com a proxima celula a direita
       }
    }


	}


/* colocar valores na matriz*/
  public void colocarValores(){
    for(Celula i = inicio ; i!=null ; i= i.inferiror){
      for(Celula z = i ; z !=null ; z = z.direita){
        z.elemento=MyIO.readInt();
      }
    }
  }

/* Mostrar os valores da matriz*/
  public void mostrar() {
   for (Celula i = inicio; i != null; i = i.inferiror) {
      for (Celula j = i; j != null; j = j.direita) {
         System.out.print(j.elemento + " ");
      }
      MyIO.println("");
   }
}
/* Mostrar os valores da diagonal , como os valores da diagonal sao sempre inicio .direita .
inferior essa foi uma forma dee fazer,podeia ter colocado duas variaves como contador e quando a linha e a
coluna fossem iguais mostrava ,pelo fato das diagonais principais se formam quando linha e coluca estao no mesmo ponto de numero como 0,0 , 1,1 etc..
*/
public void mostrarDiagonalPRincipal(){
    if(linha == coluna && linha>0){
        Celula i = inicio;
        while(i!=null){
            System.out.print(i.elemento + " ");
            i = i.direita;
              if (i != null) {
                  i = i.inferiror;
                }
          }
					  System.out.println("");
    }
}
// funcao para mostrar a diagonar segundaria , que se baseia e ir ate o final da coluna e entao ir para a esquerda e para baixo
//com o intuido de pegar todos os numeos da diagonal comecando da ultima coluna da MAtriz
public void mostrarDiagonalSecundaria(){
    if(linha == coluna && linha>0){
      Celula i = inicio;
      Celula temporaria=null;
      for (i = inicio; i != null; i = i.direita){
        temporaria=i;
      }
      i=temporaria;
      temporaria=null;
      while(i!=null){
        System.out.print(i.elemento + " ");
        i=i.inferiror;
        if(i!=null){
          i=i.esquerda;
        }
      }
			System.out.println("");
    }
}
// sber se a matriz e quadratica
public boolean quadraticaConfirmacar(Matriz teste){
  if(teste.linha==teste.coluna){
    return true;
  }
  return false;

}

/* Funcao que nao qual ira usar dois for para mandar a posicao que deseja receber pegar a soma dos elementops*/
public Matriz somar(Matriz primeira , Matriz segunda){
  Matriz nova= null;
  if(quadraticaConfirmacar(primeira)==quadraticaConfirmacar(segunda)){ // veriaficar se e uma matriz quadratica
     nova = new Matriz(primeira.linha, primeira.coluna); // fazer uma nova matriz`
     Celula nn= nova.inicio; // apontar esse nova matriz para o inicio

     for(int i=0;i<nova.linha&&nn!=null;i++,nn=nn.inferiror){ // primeiro for para passar de linha a linha
       Celula nb= nn; // apontar para o proximo elemento

       for (int z=0;z<nova.coluna&&nb!=null;z++,nb=nb.direita ) { // pecorrer cara coluna da matriz

          nb.elemento=somarMM(primeira, segunda,i,z); // chamar o funcao somarMM

       }

     }

  }
    return nova; // retornar a matriz nova

}

// somar cada numero na posicao passada
public int somarMM(Matriz primeira, Matriz segunda , int caminhoL, int caminhoC){
  // referencias o inicio
  Celula linhaA=primeira.inicio;//referencias para o inicio da matriz primeira
  Celula colunaA=segunda.inicio; // referencia para o inicio da matriz segunda
      // posicionar em qual coluna o obajeto a ser somado esta
        for(int i=0;i<caminhoC;i++)
       {
           linhaA=linhaA.direita; // mover ate a coluna indicada
           colunaA=colunaA.direita;
       }
       //descer ate a linha que o obejeto esta localizado
       for(int i=0;i<caminhoL;i++)
       {
           linhaA=linhaA.inferiror;
           colunaA=colunaA.inferiror;
       }
       //fazer a soma dos elementos no local correto
       int somatorio = linhaA.elemento+colunaA.elemento;
       return somatorio;

}


public Matriz mutiplicacaoPegarValores(Matriz primeira , Matriz segunda){
  Matriz nova= null;
  if(quadraticaConfirmacar(primeira)==quadraticaConfirmacar(segunda)){ // veriaficar se e uma matriz quadratica
     nova = new Matriz(primeira.linha, primeira.coluna); // cria a matriz
     Celula nv=nova.inicio;// referenciar o inicio da matriz

		 for( int i =0;nv!=null &&i<primeira.linha;nv=nv.inferiror,i++){//  mudar a referencia apos passagem pela repeticao
			 Celula bv=nv; // referenciar a nova linha

			 for(int j=0;bv!=null&&j<primeira.linha;bv=bv.direita,j++){// mudar a referencia da coluna a cada passagem do for
				 bv.elemento=mutiplicacaoMatriz(primeira, segunda, i, j); // receber a mutiplicacao
			 }
		 }


	 	}
		return nova;
}
/* funcao na qual ira mutiplicar os o local das Matrizes passados e retornar o valor*/
  public int mutiplicacaoMatriz(Matriz primeira , Matriz segunda, int saberLinha, int saberColuna){
         Celula primeiraC=primeira.inicio;
         Celula segundaC=segunda.inicio;
				 // ir ate a linha que sera mutiplicada
         for(int i=0;i<saberLinha;i++)
         {
             primeiraC=primeiraC.inferiror;
         }
				 //ir ate a coluna que sera mutiplicada
         for(int i=0;i<saberColuna;i++)
         {
             segundaC=segundaC.direita;
         }

				int mult=0;

				// mutiplicar os valores ate mutipliar a linha e a coluna inteira da matriz ( linha*coluna)
        for(;primeiraC!=null && segundaC!=null;primeiraC=primeiraC.direita,segundaC=segundaC.inferiror){
             mult+=primeiraC.elemento*segundaC.elemento;
					 }
         return mult;
    }

}





public class Ma {

	public static void main(String[] args) {
		  	int saberNumerodeLinhaseColunas=0;
				saberNumerodeLinhaseColunas=MyIO.readInt(); // saber a quantidade das matrizes
				for(int i =0; i<saberNumerodeLinhaseColunas;i++){ //  estrutura de repeticao para pegar o numero de testes que seram feitos
					int linha=MyIO.readInt(); // pegar linha e coluna da primeira matriz == tp3
					int coluna=MyIO.readInt();
					Matriz tp3=new Matriz(linha,coluna); // criar a matriz tp3
					tp3.colocarValores(); // colocar os valores na matriz
					tp3.mostrarDiagonalPRincipal();// mostrar a diagonal principal
					tp3.mostrarDiagonalSecundaria(); // mostrar a diagonal secundaria
					int linha2=MyIO.readInt();//pegar os valores da coluna e linha da matriz m2
					int coluna2=MyIO.readInt();
					Matriz m2=new Matriz(linha2,coluna2);// cria a matriz m2
					m2.colocarValores();
					Matriz soma= tp3.somar(tp3,m2);
							//System.out.println("aki");
							soma.mostrar();
							//System.out.println("---");
					Matriz muti=tp3.mutiplicacaoPegarValores(tp3,m2); // fazer a mutiplicacao da matriz tp3 e m2
					muti.mostrar(); // mostrar


				}
	}
}
