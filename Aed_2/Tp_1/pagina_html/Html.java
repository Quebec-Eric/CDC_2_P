import java.io.*;
import java.net.*;

class  Html {
   public static String getHtml(String endereco){
      URL url;
      InputStream is = null;
      BufferedReader br;
      String resp = "", line;

      try {
         url = new URL(endereco);
         is = url.openStream();  // throws an IOException
         br = new BufferedReader(new InputStreamReader(is));

         while ((line = br.readLine()) != null) {
            resp += line + "\n";
         }
      } catch (MalformedURLException mue) {
         mue.printStackTrace();
      } catch (IOException ioe) {
         ioe.printStackTrace();
      }

      try {
         is.close();
      } catch (IOException ioe) {
         // nothing to see here

      }

      return resp;


      /**
     * Funcao da funcao Testar: Verificar se a entrada no teclado e diferente da palavra FIM , com isso retornara um valor booleano
     * @param String pato que sera analisado se e ou nao a palavra FIM
     * @return Boolean ; retornara um valor boolean se a palavra e ou nao igual a FIM
      */
      public static boolean Testar(String pato){
         return (pato.length()==3&&pato.charAt(0)=='F'&&pato.charAt(1)=='I'&&pato.charAt(2)=='M');
      }// fim da funcao Testar

   public static void main (String[] args){

      String paginaH = MyIO.readLine();
      String endereco = MyIO.readLine();

    while(Testar(paginaH)!=true){

       getHtml(String endereco)

       paginaH = MyIO.readLine();
       endereco = MyIO.readLine();

    }

  }

}
