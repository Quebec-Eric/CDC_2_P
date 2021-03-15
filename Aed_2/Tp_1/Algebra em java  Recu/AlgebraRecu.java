public class AlgebraRecu{

                            //   1          0         0          1           1           1           0
  static String [] expessoesE={ "not(0)", "not(1)", "or(0,0)", "or(0,1)", "or(1,0)", "or(1,1)", "and(0,0)",
        //     0           0           1            0           1              1          1           1
          "and(0,1)", "and(1,0)", "and(1,1)", "or(0,0,0)", "or(0,0,1)", "or(0,1,0)", "or(0,1,1)", "or(1,0,0)",
 //             1          1            1             0               0         0              0             0
          "or(1,0,1)", "or(1,1,0)", "or(1,1,1)", "and(0,0,0)", "and(0,0,1)", "and(0,1,0)", "and(0,1,1)", "and(1,0,0)",
 //            0             0             0                0             1               1          1
          "and(1,0,1)", "and(1,1,0)", "and(1,1,1)", "or(0,0,0,0)", "or(0,0,0,1)", "or(0,0,1,0)", "or(0,0,1,1)",
//            1                1               1              1           1              1                1
          "or(0,1,0,0)", "or(0,1,0,1)", "or(0,1,1,0)", "or(0,1,1,1)", "or(1,0,0,0)", "or(1,0,0,1)", "or(1,0,1,0)",
//             1              1                1           1                1             0                0
          "or(1,0,1,1)", "or(1,1,0,0)", "or(1,1,0,1)", "or(1,1,1,0)", "or(1,1,1,1)", "and(0,0,0,0)", "and(0,0,0,1)",
//             0                 0               0                0              0             0
          "and(0,0,1,0)", "and(0,0,1,1)", "and(0,1,0,0)", "and(0,1,0,1)", "and(0,1,1,0)", "and(0,1,1,1)",
//               0              0                0               0                 0                0
          "and(1,0,0,0)", "and(1,0,0,1)", "and(1,0,1,0)", "and(1,0,1,1)", "and(1,1,0,0)", "and(1,1,0,1)","and(1,1,1,1)",
//               0                1
          "and(1,1,1,0)" };
     static String [] resultadosE={ "1", "0", "0", "1", "1", "1", "0", "0", "0", "1", "0", "1", "1", "1", "1", "1", "1", "1",
             "0", "0", "0", "0", "0", "0", "0", "1", "0", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1",
             "1", "1", "1", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "1" };
  
    /**
   * Funcao da funcao Semespaco: Tirar o espaco da string
   * @param String pato ; string que o espaco ainda nao foi retirado
   * @param String tirar2; string que sera retornada sem o espaco
   * @param  int  i2 ; usar como finalizador da funcao
   * @return String tirar2 ; string nova sem os espacos
   */ 
     // inicio Semespaco  
     public static String Semespaco(String pato, int i2 , String tirar2) {
       if(i2==pato.length())
         return tirar2;
       
       else
         if (pato.charAt(i2) != ' ') {
             return Semespaco(pato, i2+1,tirar2+=pato.charAt(i2));
           }
           else{
            return Semespaco(pato, i2+1,tirar2);
           }
       
   } // Fim Semespaco

   /**
   * Funcao da funcao PegarV: ira adentrar na String e pegar os valores binarios 
   * @param String pato ; string onde estao os valores binarios
   * @return Int [] valores ; array onde os valores foram armazenados
   */ 
    // inicio PegarV
    public static int [] PegarV (String  pato){
    int tamanho = Character.getNumericValue(pato.charAt(0));
         int[] valores = new int[tamanho];
         int z =1;
         for(int i =0;i<tamanho;i++){

           valores[i]=  Character.getNumericValue(pato.charAt(z));
          //   System.out.println(pato.charAt(z));
             z++;
         }

       return valores;
    } // Fim pegarV

   /**
   * Funcao da funcao PegarV: pegar somente as expressoes boleanas da string 
   * @param String pato ; string onde estao as expressoes boleanas
   * @return String ExpressaoT ; onde somente as expressoes boleanas vao estar
   */ 
    // inicio expressaoV
    public static String expressaoV(String pato, int i , String ExpressaoT ) {
        if(i==pato.length()){

          return ExpressaoT;
        }
        else{
          if (!(pato.charAt(i) >= '0' && pato.charAt(i) <= '9')) {
            return  expressaoV(pato, i+1,ExpressaoT += pato.charAt(i));
              
           }
           else{

           return  expressaoV(pato, i+1,ExpressaoT);
           }

        }      
       
      
   } //Fim expresssao
    
   /**
   * Funcao da funcao alocarEx ; a qual os valores binarios serao colocados na expressao
   * @param String pato ;a qual esta a expressao boleana
   * @param int[] tamanho ;onde estao os valores   
   * @return String Algebracom ; onde a algebra e os valores vao estar justos
   */
   // inicio alocarEx
   public static String alocarEx(String  pato, int[] tamanho){
     String Algebracompleta = "";
            for (int i = 0; i < pato.length(); i++) {
                int j = 0;
                int valorBoll = -1;
                while (j < tamanho.length) {
                    if (pato.charAt(i) == ('A' + j)) {
                        valorBoll = tamanho[j];
                    }
                    j++;
                }
                if (valorBoll != -1) {
                    Algebracompleta += valorBoll;
                } else {
                    Algebracompleta += pato.charAt(i);
                }
            }
            return Algebracompleta;
   } // FIm alocar Ex



   /**
   * Funcao da funcao oFim ; funcao na qual ira chamar outra funcao
   * @param String global
   * @return String global; ira retornar a expressao resolvida
   */
    // inico o oFim
    public static String oFim (String global){
      global = algebraExc(global);
       return global;

    } // Fim oFIm
    // testa se duas palavras sao iguais
    public static boolean Testar(String pato, String finalizar){
    boolean saber = true;

    if (pato.length() != finalizar.length()) {
        saber= false;
    } else {
        int i = 0;
        while ( saber&&i < pato.length()) {
            if (pato.charAt(i) != finalizar.charAt(i)) {
                saber = false;
            }
            i++;
        }
    }
    return saber;
  } /// Fim testar

   /**
   * Funcao da funcao algebraExc ; ira pegar procurar na String global expressaotv qual expressao e igual a ela e com isso retornar a verdade
   * @param String pato , onde a expressao boleana da entrada esta
   * @return String pato; onde o resultado ira voltar 
   */
   // inicio algebraExc 
  public static String algebraExc(String pato) {
        int pFrase=0;
        int  iPadrao = 0;
        while (!Testar(pato, "0") && !Testar(pato, "1")) {
          pFrase = indiceFrase(pato, expessoesE[iPadrao]);
            if (pFrase != -1) {
                pato = trocaBooleano(pato, pFrase, iPadrao);

            }
            if (iPadrao< expessoesE.length - 1) {
                iPadrao++;
            } else {
                iPadrao= 0;
  }
 }
        return pato;
    }
    // fim algebraExc
  // -----------------------------------------------------
 /**
   * Funcao da funcao algebraExc ; ira pegar procurar na String global expressaotv qual expressao e igual a ela e com isso retornar a verdade
   * @param String pato , onde esta a espresao booleana
   * @param  String expressaoTV onde se encontra a parte iguak 
   * @return int indece saber se aquele e o indece da expressao
   */
       // inicio indiceFrase
      public static int indiceFrase(String frase, String expressaoTV) {
          int indice = -1;
          if (expressaoTV.length() <= frase.length()) {
              int i = 0;
              while (indice == -1 && i < frase.length()) {
                  if (frase.charAt(i) == expressaoTV.charAt(0)) {
                      if (SaberV(frase, expressaoTV, i)) {
                          indice = i;
                      }
                  }
                  i++;
              }
          }
          return indice;
      }// fim indice
       /**
   * Funcao da funcao algebraExc ; ira pegar procurar na String global expressaotv qual expressao e igual a ela e com isso retornar a verdade
   * @param String pato , onde esta a espresao booleana
   * @param String expressaoTV onde se encontra a parte iguak 
   * @param int  localizar onde estar a correspondende da expressao
   * @return boolean verificar se o indice e igula seu teste com isso retorna true ou false
   */
       // inicio SaberV  
      public static boolean SaberV(String pato, String expressaoTV , int i) {
          boolean saber = true;
          int j = 0;
          while (saber && i < pato.length() && j < expressaoTV.length()) {
              if (pato.charAt(i) != expressaoTV.charAt(j)) {
                  saber = false;
              }
              i++;
              j++;

          }
          return saber;
      }// fim SaberV

       /**
   * Funcao da funcao algebraExc ; ira pegar procurar na String global expressaotv qual expressao e igual a ela e com isso retornar a verdade
   * @param String pato , onde a expressao boleana da entrada esta
    *@param int vExpressao local onde pode se encontrar a frase
    *@param int indicePadrao local onde se encontra a correlacao da VExpressao
   * @return String novaExpressao expressao correlacionada
   */
     //inicio trocarBooleano
      public static String trocaBooleano(String pato, int vExpressao, int indicePadrao) {
          String novaExpressao = "";
          for (int i = 0; i < pato.length(); i++) {
              if (i == vExpressao) {
                  novaExpressao += resultadosE[indicePadrao];
                  i = (vExpressao + expessoesE[indicePadrao].length() - 1);
              }
              else
              novaExpressao += pato.charAt(i);

          }
          return novaExpressao;
      }
//-------------------------------------------------
/**
* Funcao da funcao Retornar_a_verdade ; funcao que guia praticamente todo o programa
* @param String entrada ; onde a entrada do teclado se encontra
* @return String tirarEspaco , o fim do programa 
*/
 //  inicio Retornar_a_verdade
   public  static String Retornar_a_verdade(String  entrada){
     boolean saber =true;

    String tirarEspaco=""; 
    tirarEspaco   = Semespaco(entrada,0,tirarEspaco);
   // System.out.println(tirarEspaco);
    int [] pegar_valores=PegarV(tirarEspaco);
  //   System.out.println(pegar[0]);
  //    System.out.println(pegar[1]);
    String fraseExpressao = "";
    fraseExpressao =expressaoV(tirarEspaco,0,fraseExpressao);
  //   System.out.println(fraseExpressao);
     String global=   alocarEx(fraseExpressao,pegar_valores);
  //  System.out.println("-----------------------------");
  //   System.out.println(global);
   tirarEspaco =oFim(global);
    return tirarEspaco;
  } //fim Retornar_a_verdade

    // inicio main
    public static void main (String[]args){

        String entrada =MyIO.readLine();
          while(Testar(entrada, "0") == false){

            MyIO.println(Retornar_a_verdade(entrada));
            entrada =MyIO.readLine();
       }

  } // fim main
} // Fim programa
