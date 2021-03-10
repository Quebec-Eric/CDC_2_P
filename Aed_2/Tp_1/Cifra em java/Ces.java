public class Ces{

  //Altera a frase com a cifra de cesar
    public static char crip(char c){
        return (char)(c+3);
   }

    public static String mudarF(String pato){
      String resultado = "";
            for(int i = 0; i < pato.length(); i++){
                resultado += crip(pato.charAt(i));
            }
            return resultado;
      }


  public static void main (String []args){


    String[] entrada = new String[1000];
     int i=0;
     entrada[i] = MyIO.readLine();
   while(Testar(entrada[i])!=true) {

      i++;

      entrada[i] = MyIO.readLine();
   }
   for (int z = 0; z < i; z++) {
     MyIO.println(mudarF(entrada[z]));
     }
  }



       public static boolean Testar(String pato){
    return (pato.length() == 3 && pato.charAt(0) == 'F' && pato.charAt(1) == 'I' && pato.charAt(2) == 'M');
} // testar
}
