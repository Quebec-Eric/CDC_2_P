/***** *************************
*   Eric Azevedo de Oliveira  *
*   Aluno da Puc              *
*   2 periodo                 *
*******************************/

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <math.h>
#include <time.h>
#define MAXTAM 400
typedef struct
{
    int day;
    int month;
    int year;
} Date;

typedef struct
{
    char iid[30];
    char nome[200];
    char key[20];
    char artistis[98];
    int num_artists;
    Date release_date[12];
    char acousticness[20];
    char danceability[20];
    char energy[20];
    int duration_ms;
    char instrumentalness[10];
    double valence;
    int popularity;
    float tempo;
    char liveness[20];
    char loudness[20];
    double speechiness;
    int year;
} Musica;

Musica Clone_music(Musica music)
{

    return music;
}
/*Fim Struct Musica */

//------------------------------------------------------------------
/* inicio funcao CelulaDupla*/
typedef struct CelulaDupla
{
    Musica elemento;
    struct CelulaDupla *prox;
    struct CelulaDupla *ant;
} CelulaDupla;

/*  inicio funcoes utilizadas  */
int caracterPosition(char caracter, char *readFile, int lenghtReadFile);
Musica getArtistis(char *readFile, Musica music, int lenghtReadFile);
Musica get3Information(char *readFile, Musica music, int lenghtReadFile);
void toString(Musica music);
Musica fazerTudo(char *readFile, int lengthReadFile);
void insertDate(Date *d, char *stringData);
void displayFormattedDate(Date *d);
double handle_percentage(double value);
char *processData(char *dado);
char *newString(char *oldString, int oldTamanho);
Musica colocarTudoClass(char *readFile, Musica eric);
CelulaDupla *novaCelulaDupla(Musica elemento);
CelulaDupla *novaCelulaDuplaVazia();
void inserirFim(Musica x);
CelulaDupla *getelementoPos(int posicao);
void swap(CelulaDupla *i, CelulaDupla *j);
void quickSort(int esq, int dir);
int tamanho();
void ordenar();
void start();
void mostrar();
void escritaNoarquivo(double eric);
/* fim funcoes utilizdas */

//criacao de uma nova celula usando reparticao de memoria com malloc
CelulaDupla *novaCelulaDupla(Musica elemento)
{
    CelulaDupla *nova = (CelulaDupla *)malloc(sizeof(CelulaDupla));
    nova->elemento = elemento;
    nova->ant = nova->prox = NULL;
    return nova;
}
//ponteiros primeiro , e ultimo
CelulaDupla *primeiro;
CelulaDupla *ultimo;

//criacao de uma nova Celula com malloc mas sem passagem de parametro
CelulaDupla *novaCelulaDuplaVazia()
{
    CelulaDupla *nova = (CelulaDupla *)malloc(sizeof(CelulaDupla));
    nova->elemento;
    nova->ant = nova->prox = NULL;
    return nova;
}

/* inserir fim  na Lista*/
void inserirFim(Musica x)
{
    ultimo->prox = novaCelulaDupla(x);
    ultimo->prox->ant = ultimo;
    ultimo = ultimo->prox;
}

/* saber a posicao dos elementos */
CelulaDupla *getelementoPos(int posicao)
{
    CelulaDupla *i = primeiro->prox;

    for (int j = 0; j < posicao; j++)
    {
        i = i->prox;
    }
    return i;
}

/* Funcao de troca de valores , pensei em fazer a troca dos ponteiros mas iria dar um trabalho foda*/
void swap(CelulaDupla *i, CelulaDupla *j)
{
    Musica tmp = i->elemento;
    i->elemento = j->elemento;
    j->elemento = tmp;
}

/*funcao na qual ira ser realizado a ordenaxao */
void quickSort(int esq, int dir)
{

    int i = esq, j = dir;
    int comparacoes = 0;
    //CelularDupla pivo = primeiro;
    //movimentar o pivo pra mediana
    //  for(int k = 0; k < (numero1+numeor2+numero3)/3 && pivo.proximo != null; pivo = pivo.proximo);
    //	System.out.println(pivo);
    int pivo = getelementoPos((dir + esq) / 2)->elemento.duration_ms;
    while (i <= j)
    {
        while (getelementoPos(i)->elemento.duration_ms < pivo)
            i++;
        while (getelementoPos(j)->elemento.duration_ms > pivo)
            j--;

        if (i <= j)
        {
            swap(getelementoPos(i), getelementoPos(j));
            i++;
            j--;
        }
    }
    if (esq < j)
    {
        quickSort(esq, j);
    }
    if (i < dir)
    {
        quickSort(i, dir);
    }
}

/*  Saber o tamanho da lista*/
int tamanho()
{
    int tamanho = 0;
    CelulaDupla *i;
    for (i = primeiro; i != ultimo; i = i->prox)
    {
        tamanho++;
    }
    return tamanho;
}
/*funcao na qual ira char o algoritimo de ordenacao */
void ordenar()
{
    quickSort(0, tamanho()-1);
}

/* Funcao onde tudo comeca*/
void start()
{
    ultimo=primeiro=novaCelulaDuplaVazia();
}

/* funcao de mostrar a lista completa*/
void mostrar()
{
    for(CelulaDupla* i=primeiro->prox;i!=NULL;i=i->prox)
    {
        toString(i->elemento);
    }
}

/* inicio do programa*/
int main()
{
    clock_t begin = clock();
    start();
    char *entradas[MAXTAM];
    for (int i = 0; i < MAXTAM; i++)
        entradas[i] = (char *)calloc(100, sizeof(char));

    int variacaoENtradas = 0;
    do
    {
        scanf("%s", entradas[variacaoENtradas]);
    } while (strncmp(entradas[variacaoENtradas++], "FIM", 3) != 0 && variacaoENtradas < MAXTAM); // ler a primeira parte do pub.in
    ///tmp/data.csv
    FILE *arquivo = fopen("/tmp/data.csv", "r"); // abri o arquivo

    if (arquivo != NULL)
    {
        char readFile[1000];
        int ghj = 0;

        Musica *eric = (Musica *)malloc(170625 * sizeof(Musica));
        Musica *pegar = (Musica *)malloc(variacaoENtradas * sizeof(Musica));
        fgets(readFile, sizeof(readFile), arquivo);
        while (fgets(readFile, sizeof(readFile), arquivo) != NULL)
        {

            int lengthReadFile = sizeof(readFile) - 1;

            eric[ghj] = fazerTudo(readFile, lengthReadFile); // ler e executar todas as linhas do arquivo

            ghj++;
        }
        int m = 0;
        for (int e = 0; e < variacaoENtradas; e++)
        {
            for (int j = 0; j < ghj; j++)
            {
                // printf("%s\n",eric[ghj].iid);
                if (strcmp(eric[j].iid, entradas[e]) == 0)
                {
                    pegar[m] = eric[j]; // pegar apenas as linhas nas quais os ids sao iguais aos do inicio
                     inserirFim(pegar[m]);
                    m++;
                }
            }
        }
        ordenar(); // funcao de ordenar
       mostrar();
        free(pegar); //desalocar a  memoria
        free(eric);
    }
    for (int i = 0; i < MAXTAM; i++)
    {
        free(entradas[i]);
    }
    clock_t end = clock();
   double time_spent = (double)(end - begin);
   escritaNoarquivo(time_spent);
}
Musica getArtistis(char *readFile, Musica music, int lenghtReadFile)
{
    int testar = 0;
    int fritPosition = caracterPosition('[', readFile, lenghtReadFile);
    int lastPosition = caracterPosition(']', readFile, lenghtReadFile);
    // printf("<<<<%d\n", lenghtReadFile);
    // printf("-----%d\n",fritPosition);
    //printf("=====%d\n",lastPosition);
    //printf("?>>>>>%s\n",readFile);
    char artistis1[lastPosition - fritPosition - 2];
    int p = 0;
    for (int i = fritPosition; i <= lastPosition; i += 1)
    {
        if (readFile[i] != '\'')
        {
            artistis1[p] = readFile[i];
            p += 1;
        }
    }
    artistis1[p] = '\0';
    artistis1[strlen(artistis1)] = '\0';
    //  printf("%s\n",artistis1);
    strcpy(music.artistis, artistis1);
    //printf("%s\n",artistis1);
    //scanf("%d",&testar);
    //printf("============%s\n",music.artistis);
    return music;
}
Musica get3Information(char *readFile, Musica music, int lenghtReadFile)
{
    int fritPosition = caracterPosition('[', readFile, lenghtReadFile);
    char inFormacoes[fritPosition - 2];
    int p = 0;
    for (int i = 0; i < fritPosition - 1; i++)
    {
        if (readFile[i] != '[')
        {
            inFormacoes[p] = readFile[i];
            p += 1;
        }
    }
    inFormacoes[p] = '\0';
    inFormacoes[strlen(inFormacoes)] = '\0';
    //printf("%s\n", inFormacoes);
    float values[3];
    char *piece;
    piece = strtok(inFormacoes, ";");
    int m = 0;
    while (piece != NULL)
    {

        if (m == 2)
        {
            strcpy(music.acousticness, piece);
        }
        values[m] = atof(piece);
        m++;
        piece = strtok(NULL, ";");
    }
    music.valence = values[0];
    music.year = values[1];

    return music;
}
char *processData(char *dado)
{
    char *dado_tratado = (char *)calloc(1000, sizeof(char));
    int j = 0;

    for (int i = 0; i < strlen(dado); i++)
    {
        if (dado[i] == '\"')
        {
            i++;

            if (dado[i] == '[')
            {
                while (dado[i] != '\"')
                {
                    if (dado[i] != '\'')
                    {
                        dado_tratado[j] = dado[i];
                        j++;
                    }

                    i++;
                }
            }
            else
            {
                while (dado[i] != '\"')
                {
                    dado_tratado[j] = dado[i];
                    j++;
                    i++;
                }
            }
        }
        else if (dado[i] == '[')
        {
            while (dado[i] != ']')
            {
                if (dado[i] != '\'')
                {
                    dado_tratado[j] = dado[i];
                    j++;
                }

                i++;
            }

            dado_tratado[j] = dado[i];
            j++;
        }
        else if (dado[i] == ',')
        {
            dado_tratado[j] = ';';
            j++;
        }
        else
        {
            dado_tratado[j] = dado[i];
            j++;
        }
    }

    return dado_tratado;
}

Musica fazerTudo(char *readFile, int lengthReadFile)
{
    Musica eric;
    char *pegar;

    readFile = processData(readFile);
    eric = getArtistis(readFile, eric, lengthReadFile);
    eric = get3Information(readFile, eric, lengthReadFile);
    readFile = newString(readFile, lengthReadFile);
    // printf("%s\n",readFile);
    eric = colocarTudoClass(readFile, eric);

    return eric;
}

Musica colocarTudoClass(char *readFile, Musica eric)
{
    char *piece;
    int m = 0;
    // printf("%s\n", readFile);
    piece = strtok(readFile, ";");
    while (piece != NULL)
    {
        if (m == 0)
        {
            //danceability
            strcpy(eric.danceability, piece);
        }
        else if (m == 1)
        {
            //duration_ms
            eric.duration_ms = atoi(piece);
        }
        else if (m == 2)
        {
            //energy
            strcpy(eric.energy, piece);
        }
        else if (m == 3)
        {
            //explicit
        }
        else if (m == 4)
        {
            //id
            // printf("%s\n", piece);
            strcpy(eric.iid, piece);
        }
        else if (m == 5)
        {
            //instrumentalness
            strcpy(eric.instrumentalness, piece);
        }
        else if (m == 6)
        {
            //key
            strcpy(eric.key, piece);
        }
        else if (m == 7)
        {
            //liveness
            strcpy(eric.liveness, piece);
        }
        else if (m == 8)
        {
            //loudness
            strcpy(eric.loudness, piece);
        }
        else if (m == 9)
        {
            //mode
            //strcpy(eric.mode, piece);
        }
        else if (m == 10)
        {
            //name
            strcpy(eric.nome, piece);
        }
        else if (m == 11)
        {
            //popularity
            eric.popularity = atoi(piece);
            // strcpy(eric.popularity, piece);
        }
        else if (m == 12)
        {
            //release_date
            insertDate(eric.release_date, piece);
        }
        else if (m == 13)
        {
            //speechiness
            eric.speechiness = atoi(piece);
        }
        else
        {
            //tempo
            eric.tempo = atof(piece);
        }

        m++;
        piece = strtok(NULL, ";");
    }

    return eric;
}

char *newString(char *oldString, int oldTamanho)
{
    int ondeCortar = caracterPosition(']', oldString, oldTamanho);
    char newString[oldTamanho - ondeCortar];
    char *resposta = (char *)calloc(oldTamanho - ondeCortar, sizeof(char));

    //printf("%d\n", oldTamanho);
    int p = 0;
    for (int i = ondeCortar + 2; i < oldTamanho; i++)
    {
        newString[p] = oldString[i];
        //printf("%c\n", newString);
        p++;
    }
    //printf("%s\n", newString);
    strcpy(resposta, newString);
    // printf("%s\n", oldString);
    return resposta;
}

int caracterPosition(char caracter, char *readFile, int lenghtReadFile)
{
    int positionC = 0;

    for (positionC = 0; positionC < lenghtReadFile; positionC++)
    {
        if (readFile[positionC] == caracter)
        {

            return positionC;
        }
    }

    return positionC;
}

/*double handle_percentage(double value)
{
    return ceil(value) == value ? value / 100 : value;
} */

void toString(Musica music)
{

    printf("%s ## ", music.iid);
    printf("%s ## ", music.artistis);
    printf("%s ## ", music.nome);
    displayFormattedDate(music.release_date);
    printf(" ## %s ## %s ## %s ## %s ", music.acousticness, music.danceability, music.instrumentalness, music.liveness);
    printf("## %s ## %G ## %s ## %d\n", music.loudness, music.speechiness, music.energy, music.duration_ms);
    // printf("----------------------------------------------------------------------------------------- ## \n");
}

void displayFormattedDate(Date *d)
{
    printf("%0*d/%0*d/%0*d", 2, d->day, 2, d->month, 4, d->year);
}
//s
void insertDate(Date *d, char *stringData)
{
    char day[3];
    char month[3];
    char year[5];

    strncpy(year, stringData, 4);
    d->year = atoi(year);

    if (stringData[4] != '-')
    {
        strcpy(month, "01");
    }

    else
    {
        month[0] = stringData[5];
        month[1] = stringData[6];
    }

    if (stringData[7] != '-')
    {
        strcpy(day, "01");
    }
    else
    {
        day[0] = stringData[8];
        day[1] = stringData[9];
    }
    d->month = atof(month);
    d->year = atof(year);
    d->day = atof(day);
}

void escritaNoarquivo(double eric)
{

    char *matricula = {"Matricula: 694493"};
    FILE *pont_arq = fopen("694493_quicksort2.txt", "w");
    if (pont_arq == NULL)
    {
        printf("Erro na abertura do arquivo!");
    }
    else
    {
        fprintf(pont_arq, "%s ", matricula);
        fprintf(pont_arq, " Tempo== %lf", eric);
    }
}
