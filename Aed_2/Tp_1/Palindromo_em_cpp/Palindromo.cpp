#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>
#include <string.h>
#include<stdbool.h>

bool testarPalindromo(char teste[], int tamanho){

 bool eh_ou_n = true;
 int z = tamanho;

 for(int i =0;i<tamanho;i+=1){

    if(teste[i]!=teste[z]){
      eh_ou_n = false;
      i=tamanho;
    }
    else
    z--;

 }
 return eh_ou_n;


}



int main (){

char entrada[2000];

   fgets(entrada, 400, stdin);
 entrada[strlen(entrada) - 1] = '\0';

 int tamanho = strlen(entrada) - 1;
while(strcmp(entrada, "FIM") != 0){

  bool saber=testarPalindromo(entrada,tamanho);
  if(saber ==1)
  printf("SIM\n");
  else
  printf("NAO\n");
 fgets(entrada, 400, stdin);
 entrada[strlen(entrada) - 1] = '\0';
 tamanho = strlen(entrada) - 1;


}

}
