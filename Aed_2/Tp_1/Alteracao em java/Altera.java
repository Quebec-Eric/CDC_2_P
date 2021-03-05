import java.util.Random;
public class Altera {

 public  static void main (String []args ){
   Random aleatorio=new Random();
   aleatorio.setSeed(4);
   String entrada = MyIO.readLine();
   while(Testar(entrada)!=true) {

     System.out.println(alteracao_Ale(entrada,aleatorio));
     entrada=  MyIO.readLine();
   }
 }
 /**
  * Funcao da funcao Testar: Verificar se a entrada no teclado e diferente da palavra FIM , com isso retornara um valor booleano
  * @param String pato que sera analisado se e ou nao a palavra FIM
  * @return Boolean ; retornara um valor boolean se a palavra e ou nao igual a FIM
   */
   public static boolean Testar(String pato){

      return (pato.length()==3&&pato.charAt(0)=='F'&&pato.charAt(1)=='I'&&pato.charAt(2)=='M');

   }// fim da funcao Testar
   public static String alteracao_Ale(String pato, Random aleatorio){

   char charTirado=(char) ('a' + (Math.abs(aleatorio.nextInt())) % 26);
   char charAdicionado=(char) ('a' + (Math.abs(aleatorio.nextInt())) % 26);
   String mudar_string="";
   for(int i=0;i<pato.length();i++)
        {
            if(pato.charAt(i)==charTirado)
                mudar_string+=charAdicionado;
            else
                mudar_string+=pato.charAt(i);
        }
        return mudar_string;
   }
}
