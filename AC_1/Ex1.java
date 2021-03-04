import java.util.Scanner;

class Ex1 {
  // entrada do teclado
  public static void main(String[] args) {
    Scanner ler = new Scanner(System.in);
    System.out.println("Qual seu complemento");
    int complemnto = ler.nextInt();
    System.out.println("Quantos bits");
    int bits = ler.nextInt();
    String bina = ler.next();
    String separar = "";
    int saber = bina.length() - 1;
    saber = bits - saber;
    int z = 0;
    System.out.println(saber);
    for (int i = 0; i < saber - 1; i++) {

      separar += "0";

    }

    String pato = separar.concat(bina);
    if (complemnto == 1) {

   
      System.out.println(Complementode1(pato));

    } else {

      StringBuffer str = new StringBuffer(pato);
      System.out.println( findTwoscomplement(str));

    }
  }
   //trasnformar binario so para o 1 complemento

  public static String Complementode1( String bina) {

    String numero1 = "1";
    String[] pato = bina.split("");
    System.out.println(bina);
    int soma = 0;
    String nova = "";
    for (int i = 0; i <= bina.length() - 1; i++) {

      if (bina.charAt(i) == '1') {
        nova += "0";
      } else {
        nova += "1";
      }

    }
    return nova;

  }

  
// trocar para o 2 complemtt
  public static String findTwoscomplement(StringBuffer str) {
    int n = str.length();

    // Traverse the string to get first '1' from
    // the last of string
    int i;
    for (i = n - 1; i >= 0; i--)
      if (str.charAt(i) == '1')
        break;

    // If there exists no '1' concat 1 at the
    // starting of string
    if (i == -1)
      return "1" + str;

    // Continue traversal after the position of
    // first '1'
    for (int k = i - 1; k >= 0; k--) {
      // Just flip the values
      if (str.charAt(k) == '1')
        str.replace(k, k + 1, "0");
      else
        str.replace(k, k + 1, "1");
    }

    // return the modified string
    return str.toString();
  }



}





