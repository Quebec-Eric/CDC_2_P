import java.io.*;
import java.net.*;

class Html {
    public static int[] getHtml(String endereco) {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String resp = "", line;
        int a = 0;
        int e = 0;
        int i = 0;
        int o = 0;
        int u = 0;
        int a1 = 0;
        int e1 = 0;
        int i1 = 0;
        int o1 = 0;
        int u1 = 0;
        int a2 = 0;
        int e2 = 0;
        int i2 = 0;
        int o2 = 0;
        int u2 = 0;
        int a3 = 0;
        int o3 = 0;
        int a4 = 0;
        int e3 = 0;
        int i3 = 0;
        int o4 = 0;
        int u3 = 0;
        int br1 = 0;
        int table = 0;
        int consoantes = 0;
        int[] vetor = new int[25];
        try {
            String resposta = "";
            url = new URL(endereco);
            is = url.openStream();  // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                resposta = line;
                if (paramentroT(resposta)) {
                    table++;
                } else if (paramentroT(resposta)) {

                    br1++;
                } else {

                    for (int z = 0; z < resposta.length(); z++) {

                        if (resposta.charAt(z) == 'a') {
                            a++;
                        } else if (resposta.charAt(z) == 'e') {
                            e++;
                        } else if (resposta.charAt(z) == 'i') {
                            i++;
                        } else if (resposta.charAt(z) == 'o') {
                            o++;
                        } else if (resposta.charAt(z) == 'u') {
                            u++;
                        } else if (resposta.charAt(z) == 225) {
                            a1++;
                        } else if (resposta.charAt(z) == 233) {
                            e1++;
                        } else if (resposta.charAt(z) == 237) {
                            i1++;
                        } else if (resposta.charAt(z) == 243) {
                            o1++;
                        } else if (resposta.charAt(z) == 250) {
                            u1++;
                        } else if (resposta.charAt(z) == 224) {
                            a2++;
                        } else if (resposta.charAt(z) == 232) {
                            e2++;
                        } else if (resposta.charAt(z) == 236) {
                            i2++;
                        } else if (resposta.charAt(z) == 242) {
                            o2++;
                        } else if (resposta.charAt(z) == 249) {
                            u2++;
                        } else if (resposta.charAt(z) == 227) {
                            a3++;
                        } else if (resposta.charAt(z) == 245) {
                            o3++;
                        } else if (resposta.charAt(z) == 226) {
                            a4++;
                        } else if (resposta.charAt(z) == 234) {
                            e3++;
                        } else if (resposta.charAt(z) == 238) {
                            i3++;
                        } else if (resposta.charAt(z) == 244) {
                            o4++;
                        } else if (resposta.charAt(z) == 251) {
                            u3++;
                        } else {
                            consoantes++;
                        }
                    }
                }


            }
            vetor[0] = a;
            vetor[1] = e;
            vetor[2] = i;
            vetor[3] = o;
            vetor[4] = u;
            vetor[5] = a1;
            vetor[6] = e1;
            vetor[7] = i1;
            vetor[8] = o1;
            vetor[9] = u1;
            vetor[10] = a2;
            vetor[11] = e2;
            vetor[12] = i2;
            vetor[13] = o2;
            vetor[14] = u2;
            vetor[15] = a3;
            vetor[16] = o3;
            vetor[17] = a4;
            vetor[18] = e3;
            vetor[19] = i3;
            vetor[20] = o4;
            vetor[21] = u3;
            vetor[22] = consoantes;
            vetor[23] = br1;
            vetor[24] = table;


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

        return vetor;
    }


//

    /**
     * Funcao da funcao Testar: Verificar se a entrada no teclado e diferente da palavra FIM , com isso retornara um valor booleano
     *
     * @param String pato que sera analisado se e ou nao a palavra FIM
     * @return Boolean ; retornara um valor boolean se a palavra e ou nao igual a FIM
     */
    public static boolean Testar(String pato) {
        return (pato.length() == 3 && pato.charAt(0) == 'F' && pato.charAt(1) == 'I' && pato.charAt(2) == 'M');
    }// fim da funcao Testar

    //||pato.length()==4&&pato.charAt(0)=='<'&&pato.charAt(1)=='b'&&pato.charAt(2)=='r'&&pato.charAt(3)=='>'
    public static boolean paramentroT(String pato) {
        return (pato.length() == 7 && pato.charAt(0) == '<' && pato.charAt(1) == 't' && pato.charAt(2) == 'a' && pato.charAt(3) == 'b' && pato.charAt(4) == 'l' && pato.charAt(5) == 'e' && pato.charAt(6) == '>');

    }// fim da funcao Testar

    public static boolean paramentroB(String pato) {
        return (pato.length() == 4 && pato.charAt(0) == '<' && pato.charAt(1) == 'b' && pato.charAt(2) == 'r' && pato.charAt(3) == '>');

    }


    public static void main(String[] args) throws Exception {
        String paginaH = MyIO.readLine();


        while (Testar(paginaH) != true) {
            String endereco = MyIO.readLine();
            int[] vetor = getHtml(endereco);
      //     MyIO.setCharset("UTF-8");
          MyIO.println("a(" + vetor[0] + ") e(" + vetor[1] + ") i(" + vetor[2] + ") o(" + vetor[3] + ") u(" + vetor[4] + ") á(" + vetor[5] + ") é(" + vetor[6] + ") í(" + vetor[7] + ") ó(" + vetor[8] + ") ú(" + vetor[9] + ") à(" + vetor[10] + ") è(" + vetor[11] + ") ì(" + vetor[12] + ") ò(" + vetor[13] + ") ù(" + vetor[14] + ") ã(" + vetor[15] + ") õ(" + vetor[16] + ") â(" + vetor[17] + ") ê(" + vetor[18] + ") î(" + vetor[19] + ") ô(" + vetor[20] + ") û(" + vetor[21] + ") consoante(" + vetor[22] + ") <br>(" + vetor[23] + ") <table>(" + vetor[24] + ") " + paginaH);
    //    String resposta=    new String(ax.getBytes("UTF-8"), "ISO-8859-1");
      //  System.out.println(resposta)
            paginaH = MyIO.readLine();


        }

    }

}
