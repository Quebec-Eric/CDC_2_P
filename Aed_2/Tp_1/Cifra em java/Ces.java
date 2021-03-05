 import java.util.Scanner;
public class Ces {
  /**
   * Funcao da funcao Testar: Verificar se a entrada no teclado e diferente da palavra FIM , com isso retornara um valor booleano
   * @param String pato que sera analisado se e ou nao a palavra FIM
   * @return Boolean ; retornara um valor boolean se a palavra e ou nao igual a FIM
    */
    public static boolean Testar(String pato){

       return (pato.length()==3&&pato.charAt(0)=='F'&&pato.charAt(1)=='I'&&pato.charAt(2)=='M');

    }// fim da funcao Testar

    public static void main (String[] args )throws Exception{
    String resposta="";
    Scanner ler = new Scanner(System.in);

      String entrada = MyIO.readLine();

         String print21 = new String(entrada.getBytes(), "UTF-8");
          System.out.println(print21);
      /*
        o While ira ler do teclado e so ira parar a sua execucao quando a palavra for FIM, fazendo esse teste por meio da
         funcao Testar
      */


       while(Testar(entrada)!=true){

       resposta=  Crip(entrada);
       String print = new String(resposta.getBytes("UTF-8"), "ISO-8859-1");
       System.out.println(print);
       entrada = MyIO.readLine();

    }

  } // fim do main
  /**
    * Funcao da funcao Crip: ira cripitografar usando a logica de Cesar a string
    * @param String pato sera a string que sera criptografada
    * @return String ; retornara  a string criptografada
     */

     public static String Crip(String pato){

      String cript="";
      int eric=0;
      int saber=0;
     /*
      for ira cripitografar cara letra da string
     */
      for(int i =0;i<pato.length();i++){
      eric=(int)(pato.charAt(i)+3);

       if (eric >122){
        eric-= 26;
          cript+=(char)eric;
      }
      else {
          cript+=(char)eric;
      }
    }
      return cript;

    } // fim funcao Crip


  } // fim class Ces

  /*
  String resposta = "";

  String entrada = MyIO.readLine();

  PrintStream outISO = new PrintStream(System.out, true, "ISO-8859-1");

  */
