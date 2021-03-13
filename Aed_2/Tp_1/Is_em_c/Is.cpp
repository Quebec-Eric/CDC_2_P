#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

bool sVogal(char eric)
{

  bool sVogal = false;
  if (eric == 'A' || eric == 'a' || eric == 'E' || eric == 'e' || eric == 'I' || eric == 'i' || eric == 'O' || eric == 'o' || eric == 'U' || eric == 'u')
  {
    sVogal = true;
  }
  return sVogal;
}

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
}

bool contemletra(char eric)
{
  bool saber = false;
  if (eric >= 'A' && eric <= 'Z' || eric >= 'a' && eric <= 'z')
    saber = true;
  return saber;
}

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
}
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
}
bool testeSupremo(char teste[], int tamanho){
  bool saber = false;
  int testeSupremo =0;
  for (int i =0 ;i<tamanho;i++  ) {

          if((teste[i] >= '0' && teste[i] <= '9')){
           saber =true;
      }

  }
  return saber;
}

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
}


    

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