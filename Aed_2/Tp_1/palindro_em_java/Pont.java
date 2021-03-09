  public  class Pont{
 /**
  * Funcao da funcao Testar: Verificar se a entrada no teclado e diferente da palavra FIM , com isso retornara um valor booleano
  * @param String pato que sera analisado se e ou nao a palavra FIM
  * @return Boolean ; retornara um valor boolean se a palavra e ou nao igual a FIM
   */
  public static boolean Testar(String pato){
   return (pato.length()==3&&pato.charAt(0)=='F'&&pato.charAt(1)=='I'&&pato.charAt(2)=='M');
 } // fim da funcao Testar



  public static void main (String[] args){

  boolean saber=false;
  String entrada = MyIO.readLine();
/*
  o While ira ler do teclado e so ira parar a sua execucao quando a palavra for FIM, fazendo esse teste por meio da
   funcao Testar
*/

     while(Testar(entrada) !=true){


          saber= Confirmacao(entrada);
          if(saber==true){

              System.out.println("SIM");
          }
          else{
             System.out.println("NAO");
          }

          entrada = MyIO.readLine();
       }

    }
   // fim do main

  /**
    * Funcao da funcao Confirmacao: Verificar se a String e um palindromo ou nao
    * @param String pato que sera analisado se e ou nao um  palindromo
    * @return Boolean ; retornara um valor boolean se a palavra e ou nao um palindromo
  */


   public static boolean Confirmacao(String pato){

     String  otap = new StringBuilder(pato).reverse().toString(); // usado para inverter a String
      boolean saber = true;
    /*
       o for ira testar se cada local da string normal "pato" e a string invertida "otap"
       sao iguals mais se forem diferentes ele para imediatamente a execucao do for
    */
     for(int i=0;i<pato.length()-1;i++){

       if(pato.charAt(i)!=otap.charAt(i)) {
         saber = false;
         i = pato.length();
       }

   }
   return saber;
 } // fim funcao Confirmacao
} // fim classe Pont
