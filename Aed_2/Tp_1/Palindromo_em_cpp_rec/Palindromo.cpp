#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>
#include <string.h>
#include<stdbool.h>
 
bool testarPalindromo(char teste[], int tamanho,int t2,int i,int p){

     if(i==tamanho){
      
        if(p==tamanho){
            
            return true;
        }
        else{
            return false; 
        }
     }
     else{

       if(teste[i]==teste[t2])
        return testarPalindromo( teste,  tamanho, t2-1,i+1,p+1);
               
       else
        return  testarPalindromo( teste,  tamanho, t2-1,i+1,p);    
     }
    }







int main (){

char entrada[2000];

   fgets(entrada, 400, stdin);
 entrada[strlen(entrada) - 1] = '\0';
 
 int tamanho = strlen(entrada) - 1;
 int t2=tamanho;

while(strcmp(entrada, "FIM") != 0){
 
  bool saber=testarPalindromo(entrada,tamanho,t2,0,0);
  if(saber ==1)
  printf("SIM\n");
  else
  printf("NAO\n");
 fgets(entrada, 400, stdin);
 entrada[strlen(entrada) - 1] = '\0';
 tamanho = strlen(entrada) - 1;
 t2=tamanho;


}

}
