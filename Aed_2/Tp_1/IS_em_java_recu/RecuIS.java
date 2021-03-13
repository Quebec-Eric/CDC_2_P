/**
 * @author Eric Azevedo de Oliveira 
*/

public class RecuIS{
    
  /**
   * Funcao da funcao Testar: Verificar se a entrada no teclado e diferente da palavra FIM , com isso retornara um valor booleano
   * @param String pato que sera analisado se e ou nao a palavra FIM
   * @return Boolean ; retornara um valor boolean se a palavra e ou nao igual a FIM
    */
    public static boolean Testar(String pato){

       return (pato.length()==3&&pato.charAt(0)=='F'&&pato.charAt(1)=='I'&&pato.charAt(2)=='M');

    }// fim da funcao Testar

     // inicio main
     public static void main (String []args){

       String entrada = MyIO.readLine();
       while(Testar(entrada)!=true) {

     if  (Somvogais(entrada,0,0)==true)
          MyIO.print("SIM ");
    else
          MyIO.print("NAO ");
     if (SoComso(entrada)==true)
          MyIO.print("SIM ");

    else
           MyIO.print("NAO ");
      if (ContemNi(entrada)==true)
          MyIO.print("SIM ");
    else
           MyIO.print("NAO ");

      if (ContenNR(entrada)==true)

           MyIO.print("SIM\n");
     else
          MyIO.print("NAO\n");

        entrada = MyIO.readLine();

       }
     } // fim main

      /**
   * Funcao da funcao Somvogais:ira testar se a palavra e ou nao so compostas por vogais
   * @param String pato que sera analisado se e ou nao uma  composta por vogais
     @param int     i  , iniciar minha recursividade , dando a ela um fim 
     @param  int  p  . parametro para ser utilizado para decretar se e bollean ou n 
   * @return Boolean ; retornara um valor boolean 
    */
        // inicio Somvogais 
        public static boolean Somvogais(String pato,int i, int p){
          if(i ==pato.length()){
             if(p==pato.length()){
              return true;
             }
             else{
             return false;
             }
          }
          else{
             if(!sVogal(pato.charAt(i))){
              return Somvogais( pato, i+1, p);
             }
             else{
               return Somvogais( pato, i+1, p+1);
             }
          }
        }
        // fim somvogais

              /**
   * Funcao da funcao sVogais:ira testar se cade Char e ou nao uma  vogal
   * @param char eric a ser analisado se e ou nao uma vogal
   * @return Boolean ; retornara um valor boolean 
    */
       //inicio sVogal
        public static boolean sVogal(char eric) {
       boolean sVogal=false;
       if(eric=='A'||eric=='a'||eric=='E'||eric=='e'||eric=='I'||eric=='i'||eric=='O'||eric=='o'||eric=='U'||eric=='u')
       {
           sVogal=true;
       }
       return sVogal;
   }// fim Svogal

            /**
   * Funcao da funcao soComso:ira testar se cade a palavra so contem ou nao consoantes
   * @param String eric a ser analisado se e ou nao uma vogal
   * @return Boolean ; retornara um valor boolean 
    */

    // inicio SoComso
    public static boolean SoComso(String pato){
      boolean saber = true;
       for (int i =0 ;i<pato.length()-1;i++  ) {
               if(sVogal(pato.charAt(i))||!contemletra(pato.charAt(i))){
                saber = false;
               }
         }
     return saber;
    } // fim soComso

                 /**
   * Funcao da funcao contemNI:ira testar se a palavra contem ou nao numeros 
   * @param String pato , a qual ira ser analisada se comtem numeros ou nao
   * @return Boolean ; retornara um valor boolean 
    */

    // inicio ContemNi
    public static boolean ContemNi (String pato){
      boolean saber = true;
       for (int i =0 ;i<pato.length();i++  ) {
               if(pato.charAt(i)=='.'||pato.charAt(i)==','||contemletra(pato.charAt(i))){
                saber = false;
               }
         }
     return saber;
    } // fim COmtemNi

            /**
   * Funcao da funcao contemletra ira analisar se o char e uma letra ou nao 
   * @param char eric , o qual ira sofrer o teste de saber se e letra ou nao
   * @return Boolean ; retornara um valor boolean 
    */
   // inico contemletra
    public static boolean contemletra(char eric)
 {
     boolean saber=false;
     if(eric>='A'&&eric<='Z'||eric>='a'&&eric<='z')
         saber=true;
     return saber;
 } // fim contemletra

  /**
   * Funcao da funcao tsteSupremo , e o teste que verificar por fim a string , sendo supremo
   * @param String pato , a string que ira ser testa 
   * @return Boolean ; retornara um valor boolean 
    */
 // inicio testeSupremo 
 public static boolean testeSupremo(String pato){
  boolean saber = false;
  int testeSupremo =0;
  for (int i =0 ;i<pato.length();i++  ) {

          if((pato.charAt(i) >= '0' && pato.charAt(i) <= '9')){
           saber =true;
      }

  }
    return saber;
 } // fim teste supremo 

 /**
   * Funcao da funcao ContenNR ira verificar se a string contem numeros reais
   * @param String pato , string que ira sofrer o teste
   * @return Boolean ; retornara um valor boolean 
    */  
  //inicio contenNR
  public static boolean ContenNR(String pato){
   boolean saber = false;
    for (int i =0 ;i<pato.length();i++  ) {
           if(!contemletra(pato.charAt(i)) ){
              saber = testeSupremo(pato);
            }
      }
  return saber;
 } // fim ContenNR






}
