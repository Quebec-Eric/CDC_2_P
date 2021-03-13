public class main{
    char[] vogais = {65,69,73,79,85,97,101,105,111,117};
  /**
   * Funcao da funcao Testar: Verificar se a entrada no teclado e diferente da palavra FIM , com isso retornara um valor booleano
   * @param String pato que sera analisado se e ou nao a palavra FIM
   * @return Boolean ; retornara um valor boolean se a palavra e ou nao igual a FIM
    */
    public static boolean Testar(String pato){

       return (pato.length()==3&&pato.charAt(0)=='F'&&pato.charAt(1)=='I'&&pato.charAt(2)=='M');

    }// fim da funcao Testar

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
     }
  /*
      public static boolean Somvogais(String pato,int i){

       boolean saber = true;
        for (int i =0 ;i<pato.length();i++  ) {

                if(!sVogal(pato.charAt(i))){

                  saber = false;
                }
          }

          return saber;

        }
        */

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

        public static boolean sVogal(char eric) {
       boolean sVogal=false;
       if(eric=='A'||eric=='a'||eric=='E'||eric=='e'||eric=='I'||eric=='i'||eric=='O'||eric=='o'||eric=='U'||eric=='u')
       {
           sVogal=true;
       }
       return sVogal;
   }

    public static boolean SoComso(String pato){
      boolean saber = true;
       for (int i =0 ;i<pato.length()-1;i++  ) {

               if(sVogal(pato.charAt(i))||!contemletra(pato.charAt(i))){

                 saber = false;
               }
         }
     return saber;


    }

    public static boolean ContemNi (String pato){
      boolean saber = true;
       for (int i =0 ;i<pato.length();i++  ) {

               if(pato.charAt(i)=='.'||pato.charAt(i)==','||contemletra(pato.charAt(i))){

                 saber = false;

               }
         }
     return saber;

    }

    public static boolean contemletra(char eric)
 {
     boolean saber=false;
     if(eric>='A'&&eric<='Z'||eric>='a'&&eric<='z')
         saber=true;
     return saber;
 }

 public static boolean testeSupremo(String pato){
  boolean saber = false;
  int testeSupremo =0;
  for (int i =0 ;i<pato.length();i++  ) {

          if((pato.charAt(i) >= '0' && pato.charAt(i) <= '9')){
           saber =true;
      }

  }
    return saber;
 }

 public static boolean ContenNR(String pato){

   boolean saber = false;
  // System.out.println(pato);
    for (int i =0 ;i<pato.length();i++  ) {

            if(!contemletra(pato.charAt(i)) ){

              saber = testeSupremo(pato);
            }
      }
  return saber;

 }






}
