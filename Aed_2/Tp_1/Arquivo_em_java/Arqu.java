import java.io.File;
import java.io.RandomAccessFile;
public class Arqu{

   public static void main (String[] args){
    int quantidade = MyIO.readInt();
     criar_Arquivo(quantidade);
     ler_Arquivo(quantidade);

   }

   public static void criar_Arquivo(int quantidade){
    double pegar=0;
    File arquivo = new File("arquivo.txt");
    try{
         if(!arquivo.exists()){
           arquivo.createNewFile();
         }
         if(!arquivo.canWrite()){
           throw new Exception();
         }
          RandomAccessFile file = new RandomAccessFile(arquivo, "rw");
          for(int i =0;i<quantidade;i++){

                 pegar=MyIO.readDouble();
                 file.writeDouble(pegar);
          }
        file.close();
    }

    catch(Exception e)
      {

      }

   }

    public static void ler_Arquivo(int quantidade){
             File arquivo = new File("arquivo.txt");

             try{
               if(!arquivo.exists()){
                 throw new Exception();
               }
                 RandomAccessFile file = new RandomAccessFile(arquivo, "r");


                 for(int i =0;i<quantidade;i++){
                  file.seek((quantidade-1-i)*8);
                 double numero=file.readDouble();
                 if(numero%1!=0)
                   MyIO.println(numero);
               else
                   MyIO.println((int)numero);
                 }
               file.close();
           }

           catch(Exception e)
       {

       }
   }

}
