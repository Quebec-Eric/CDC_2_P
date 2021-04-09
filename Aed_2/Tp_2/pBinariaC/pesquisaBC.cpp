#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <time.h>
#include <math.h>
void colocarArquivo(clock_t t, int comparacoes);
int main()
{
    clock_t t;
    t = clock();
    char **pubIn = (char **)malloc(sizeof(char *) * 500);
    for (int i = 0; i < 500; i += 1)
    {

        pubIn[i] = (char *)malloc(sizeof(char) * 50);
    }
    char entrada[50];
    fgets(entrada, sizeof(entrada), stdin);
    entrada[strlen(entrada) - 1] = '\0';
    int tamanhoPrimeira = 0;
    while (strcmp(entrada, "FIM") != 0)
    {

        strcpy(pubIn[tamanhoPrimeira], entrada);

        fgets(entrada, sizeof(entrada), stdin);

        entrada[strlen(entrada) - 1] = '\0';
        tamanhoPrimeira++;
    }
    // printf("====%d\n",z);
    char aux[50];
    for (int i = 0; i < tamanhoPrimeira; i++)
    {
        for (int j = i + 1; j < tamanhoPrimeira; j++)
        {
            if (strcmp(pubIn[j], pubIn[i]) < 0)
            {
                strcpy(aux, pubIn[i]);
                strcpy(pubIn[i], pubIn[j]);
                strcpy(pubIn[j], aux);
            }
        }
    }

    char **test = (char **)malloc(sizeof(char *) * 500);
    for (int i = 0; i < 500; i += 1)
    {

        test[i] = (char *)malloc(sizeof(char) * 50);
    }
    char entradaTest[50];
    fgets(entradaTest, sizeof(entradaTest), stdin);
    entradaTest[strlen(entradaTest) - 1] = '\0';
    int d = 0;
    while (strcmp(entradaTest, "FIM") != 0)
    {

        strcpy(test[d], entradaTest);

        scanf("%s", entradaTest);

        d += 1;
    }
    //   printf(">>>>>>>>>%d\n",d);

    for (int t = 0; t < d; t++)
    {
        int first = 0;
        int last = tamanhoPrimeira;
        int mid = (first + last) / 2;
        int saber = 0;
        while (first <= last)
        {
            //  printf("==Mi=%s\n", pubIn[mid]);
            // printf("==pro=%s\n", test[t]);
            if (strcmp(pubIn[mid], test[t]) == 0)
            {
                printf("SIM\n");

                saber = 4;
                first = last + 1;
            }
            else if (strcmp(pubIn[mid], test[t]) > 0)
            {
                //printf("menor\n");
                last = mid - 1;
            }
            else
            {
                //printf("maior\n");
                first = mid + 1;
            }
            mid = (first + last) / 2;
        }
        if (saber != 4)
        {
            printf("NAO\n");
        }
    }
    free(pubIn);
    free(test);
    int p = pow(d, tamanhoPrimeira);
    t = clock() - t;
    colocarArquivo(t, p);
}

void colocarArquivo(clock_t t, int comparacoes)
{
    FILE *arquivo = fopen("matricula_sequenecial.txt", "w");
    if (arquivo == NULL)
    {
        printf("ERRO\n");
    }
    else
    {
        fprintf(arquivo, "%s", "Matrucula: 694493 ");
        fprintf(arquivo, "%s", "Tempo: ");
        fprintf(arquivo, "%lf", ((double)t) / ((CLOCKS_PER_SEC / 1000)));
        fprintf(arquivo, "%s", " Comparacoes: ");
        fprintf(arquivo, "%d", comparacoes);
    }
}
