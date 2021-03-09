import java.util.Random;
public class Altera {

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

 }

   public static boolean Testar(String pato){

      return (pato.length()==3&&pato.charAt(0)=='F'&&pato.charAt(1)=='I'&&pato.charAt(2)=='M');

   }// fim da funcao Testar
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
   }
}
