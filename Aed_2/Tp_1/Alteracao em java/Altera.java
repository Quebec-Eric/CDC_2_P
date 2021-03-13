/**
 * @author Eric Azevedo de Oliveira 
 * 
*/
import java.util.Random;
public class Altera {
/**
   * Funcao da funcao Testar: Verificar se a entrada no teclado e diferente da palavra FIM , com isso retornara um valor booleano
   * @param String pato que sera analisado se e ou nao a palavra FIM
   * @return Boolean ; retornara um valor boolean se a palavra e ou nao igual a FIM
    */
// inicio main
 public  static void main (String []args ){
   Random aleatorio=new Random();
   aleatorio.setSeed(4);
   String[] entrada = new String[1000];
     int i=0;
     entrada[i] = MyIO.readLine();
      while(Testar(entrada[i])!=true) {
          i++;
         entrada[i] = MyIO.readLine();
   }
      for (int z = 0; z < i; z++) {
        MyIO.println(alteracao_Ale(entrada[z], aleatorio));
     }
 } // fim main

/**
   * Funcao da funcao Testar: Verificar se a entrada no teclado e diferente da palavra FIM , com isso retornara um valor booleano
   * @param String pato que sera analisado se e ou nao a palavra FIM
   * @return Boolean ; retornara um valor boolean se a palavra e ou nao igual a FIM
    */
   // inicio Testar
   public static boolean Testar(String pato){

      return (pato.length()==3&&pato.charAt(0)=='F'&&pato.charAt(1)=='I'&&pato.charAt(2)=='M');

   }// fim da funcao Testar
    
/**
   * Funcao da funcao  alteracao_Ale: ira sortear dois numeros da tabela acii e quando ela aparecer dentro da string ira ser colocado na strng
   * @param String pato que sera analisado se e a palavra sorteada esta presente na string
   * @return String retorna uma nova string com os caracteres mudados
    */
   // inico  alteracao_Ale
   public static String alteracao_Ale(String pato ,Random aleatorio){
     String mudar_string="";
     char charTirado=(char) ('a' + (Math.abs(aleatorio.nextInt())) % 26);
     char charAdicionado=(char) ('a' + (Math.abs(aleatorio.nextInt())) % 26);

      for(int i=0;i<pato.length();i++)
         {
            if(pato.charAt(i)==charTirado)
                mudar_string+=charAdicionado;
            else
                mudar_string+=pato.charAt(i);
        }
     return mudar_string;
   } // fim alteracao_Ale
} 
