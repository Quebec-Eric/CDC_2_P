/**
 * @author Eric Azevedo de Oliveira 
*/
#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
/**
* Funcao da funcao sVogais:ira testar se cade Char e ou nao uma  vogal
* @param char eric a ser analisado se e ou nao uma vogal
* @return Boolean ; retornara um valor boolean 
*/
//inicio sVogal
bool sVogal(char eric)
{
  bool sVogal = false;
  if (eric == 'A' || eric == 'a' || eric == 'E' || eric == 'e' || eric == 'I' || eric == 'i' || eric == 'O' || eric == 'o' || eric == 'U' || eric == 'u')
  {
    sVogal = true;
  }
  return sVogal;
}// Fim sVogal

/**
* Funcao da funcao Somvogais:ira testar se a palavra e ou nao so compostas por vogais
* @param  char Teste [];que sera analisado se e ou nao uma  composta por vogais
* @param  int Tamanho ; saber o tamanho do vetor de caracteres
* @return Boolean ; retornara um valor boolean 
*/
// inicio Somvogais 
bool Smetvogais(char teste[], int tamanho)
{
  bool saber = true;
  for (int i = 0; i < tamanho; i++)
  {
    if (!sVogal(teste[i]))
    {
      saber = false;
    }
  }
  return saber;
}// Fim SOmvogais
 
/**
* Funcao da funcao contemletra ira analisar se o char e uma letra ou nao 
* @param char eric , o qual ira sofrer o teste de saber se e letra ou nao
* @return Boolean ; retornara um valor boolean 
*/
// inico contemletra
bool contemletra(char eric)
{
  bool saber = false;
  if (eric >= 'A' && eric <= 'Z' || eric >= 'a' && eric <= 'z')
    saber = true;
  return saber;
}// fim contemletra

/**
* Funcao da funcao soComso:ira testar se cade a palavra so contem ou nao consoantes
* @param  char Teste [];que sera analisado se e ou nao uma  composta por vogais
* @param  int Tamanho ; saber o tamanho do vetor de caracteres
* @return Boolean ; retornara um valor boolean 
*/
// inicio SoComso
bool SoComso(char teste[], int tamanho)
{
  bool saber = true;
  for (int i = 0; i < tamanho; i++)
  {
    if (sVogal(teste[i]) || !contemletra(teste[i]))
    {
      saber = false;
    }
  }
  return saber;
}// fim SoComso

 /**
* Funcao da funcao contemNI:ira testar se a palavra contem ou nao numeros 
* @param  char Teste [];que sera analisado se e ou nao uma  composta por vogais
* @param  int Tamanho ; saber o tamanho do vetor de caracteres
* @return Boolean ; retornara um valor boolean 
*/
// inicio ContemNi
bool ContemNi(char teste[], int tamanho)
{
  bool saber = true;
  for (int i = 0; i < tamanho; i++)
  {
    if (teste[i] == '.' || teste[i] == ',' || contemletra(teste[i]))
    {
      saber = false;
    }
  }
  return saber;
}// fim COmtemNi

 /**
* Funcao da funcao tsteSupremo , e o teste que verificar por fim a string , sendo supremo
* @param  char Teste [];que sera analisado se e ou nao uma  composta por vogais
* @param  int Tamanho ; saber o tamanho do vetor de caracteres
* @return Boolean ; retornara um valor boolean 
*/
// inicio testeSupremo 
bool testeSupremo(char teste[], int tamanho){
  bool saber = false;
  int testeSupremo =0;
  for (int i =0 ;i<tamanho;i++  ) {
          if((teste[i] >= '0' && teste[i] <= '9')){
           saber =true;
      }
  }
  return saber;
}// fim teste supremo 

/**
* Funcao da funcao ContenNR ira verificar se a string contem numeros reais
*  @param  char Teste [];que sera analisado se e ou nao uma  composta por vogais
* @param  int Tamanho ; saber o tamanho do vetor de caracteres
* @return Boolean ; retornara um valor boolean 
*/  
  //inicio contenNR
bool ContenNR(char teste[], int tamanho)
{
  bool saber = false;

  for (int i = 0; i < tamanho; i++)
  {
    if (!contemletra(teste[i]))
    {
      saber = testeSupremo(teste,tamanho);
    }
  }
  return saber;
}// fim ContenNR


    
// inicio main
int main()
{

  char entrada[2000];
  
  fgets(entrada, 400, stdin);
  entrada[strlen(entrada) - 1] = '\0';
  int tamanho = strlen(entrada) - 1;
  while (strcmp(entrada, "FIM") != 0)
  {
    // printf("%s\n",entrada);

    if ( Smetvogais(entrada, tamanho) == true)
    {
      printf("SIM ");
    }
    else
    {
      printf("NAO ");
    }
    if (SoComso(entrada, tamanho) == true)
    {
      printf("SIM ");
    }

    else
    {
      printf("NAO ");
    }
    if (ContemNi(entrada, tamanho) == true)
    {
      printf("SIM ");
    }

    else
    {
      printf("NAO ");
    }

    if (ContenNR(entrada, tamanho) == true)
    {

      printf("SIM\n");
    }
    else
    {
      printf("NAO\n");
    }

    //  printf("%d\n", saber);
    fgets(entrada, 400, stdin);
    entrada[strlen(entrada) - 1] = '\0';
    tamanho = strlen(entrada) - 1;
  }
}
// fim main