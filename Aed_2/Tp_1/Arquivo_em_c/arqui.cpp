#include <stdio.h>

 // inicio arbri-arquivo
void abrirarquivo(int quantidade){
   double pegar=0;
   	// abrir arquivo como escrita
	FILE * arquivo =fopen("arquivo.txt", "wb");
	// teste
	if(arquivo == NULL){

		printf("Erro ao abrir arquivo\n");
	}
	else{

		for(int i =0 ;i<quantidade;i++){
             scanf("%lf",&pegar);
            // fprintf(arquivo, "%lf", pegar);
             fwrite(&pegar, sizeof(double), 1, arquivo); // escrever dentro do arquivo como ( RandomAccessFile)

		}
		 fclose(arquivo);
	}
} // fim abrir arquivo

// inicio ler arquivo
void lerarquivo(int quantidade){
	double numero=0;;
	int resposta=0;
	// abrir arquivo como leitura
 FILE * arquivo =fopen("arquivo.txt", "rb");
	if(arquivo == NULL){

		printf("Erro ao abrir arquivo\n");
	}
	else{
		 for(int i=0;i<quantidade;i++)
    {
         // ler a cada 8 bits que e o tamanho de uma variavel; doble
        fseek(arquivo,  (quantidade-1-i)*8, SEEK_SET);
        fread(&numero, sizeof(double), 1, arquivo);
         resposta=numero;
         // testar para ver se ela E INTERIRA
        if(numero-resposta!=0)
        {
            printf("%d\n", numero);
        }
        else
        {
            printf("%d\n", resposta);
        }
        
    }

	}
	fclose(arquivo);
        
} //Fim ler arquivo

// int main
int main (){
 int quantidade=0;
 scanf("%d\n", &quantidade);
 abrirarquivo(quantidade);
} // fim int main

