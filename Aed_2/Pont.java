class Pont{

  public static void main (String[] args){
    
    boolean pali= true;
    boolean saber=false; 
    int i =0;
     
    while(pali==true){
     
      if(args[i].length()==3&&args[i].charAt(0)=='F'&&args[i].charAt(1)=='I'&&args[i].charAt(2)=='M'){
          pali=false;
          System.out.println("NAO");
      }
      else{
           
          saber= Testar(args[i]);
          if(saber==true){
       
              System.out.println("SIM");
          }
          else{
             System.out.println("NAO");
          }
          
       }
      i++;
    }
  }

   public static boolean Testar(String pato){
  
     String  otap = new StringBuilder(pato).reverse().toString();  
      boolean saber = true;
      int z =otap.length()-1;
      
     for(int i=0;i<pato.length()-1;i++){
     
       if(pato.charAt(i)!=otap.charAt(i)) {
         saber = false;
         i = pato.length(); 
       }
      z--;     
   } 
   return saber;
   }
}
