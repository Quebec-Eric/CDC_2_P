class Ces {

  public static void main (String[] args){

    boolean pali= true;
  
    int i =0;

    while(pali==true){

      if(args[i].length()==3&&args[i].charAt(0)=='F'&&args[i].charAt(1)=='I'&&args[i].charAt(2)=='M'){
          pali=false;
          System.out.println(Crip(args[i]));
      }
      else{

           System.out.println(Crip(args[i]));
          }
         
      i++;
       }
    }

     public static String Crip(String pato){
   
      String cript="";

      for(int i =0;i<pato.length();i++){
      cript+=(char)(pato.charAt(i)+3);
 
      }
      return cript;

     }
     
    
  }
