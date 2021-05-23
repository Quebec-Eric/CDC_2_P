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

typedef struct Celula
{
    Musica elemento;
    struct Celula *prox;
} Celula;
Celula *topo;
Celula *novaCelula(Musica musica)
{
    Celula *nova = (Celula *)malloc(sizeof(Celula));
    nova->elemento = musica;
    nova->prox = NULL;
    return nova;
}

void start()
{
    topo = NULL;
}
void inserir(Musica musica)
{
    Celula *tmp = novaCelula(musica);
    tmp->prox = topo;
    topo = tmp;
    tmp = NULL;
    free(tmp);
}
Musica remover()
{
    if (topo == NULL)
    {
        printf("Erro ao remover!");
    }

    Musica eric = topo->elemento;
    Celula *tmp = topo;
    topo = topo->prox;
    tmp->prox = NULL;
    free(tmp);
    return eric;
}
int tamanhoDetudo()
{

    int variacao = 0;
    Celula *i = topo;
    for (; i != NULL; variacao++, i = i->prox)
    {
    }

    free(i);
    return variacao;
}

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
int testar(char *pri, char *segu);

void mostrar()
{
    int n = tamanhoDetudo();

    for (int i = 0; i < n; i++)
    {
        Celula *j = topo;
        int v = 0;
        for (; j != NULL, v < n - i - 1; v++, j = j->prox)
        {
        }

        printf("[%d] ", i);
        toString(j->elemento);
        
    }
}
int main()
{
    start();
    char *entradas[MAXTAM];
    for (int i = 0; i < MAXTAM; i++)
        entradas[i] = (char *)calloc(100, sizeof(char));

    int variacaoENtradas = 0;
    do
    {
        scanf("%s", entradas[variacaoENtradas]);
    } while (strncmp(entradas[variacaoENtradas++], "FIM", 3) != 0 && variacaoENtradas < MAXTAM);
    int quantidade = 0;
    scanf("%d", &quantidade);
    char *operacoes[MAXTAM];

    for (int i = 0; i < MAXTAM; i++)
        operacoes[i] = (char *)calloc(100, sizeof(char));

    for (int i = 0; i <= quantidade; i++)
    {
        fgets(operacoes[i], 50, stdin);
    }

    ///tmp/data.csv
    FILE *arquivo = fopen("/tmp/data.csv", "r");

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

            eric[ghj] = fazerTudo(readFile, lengthReadFile);

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
                    pegar[m] = eric[j];
                    inserir(pegar[m]);

                    m++;
                }
            }
        }
        for (int i = 0; i <= quantidade; i++)
        {
            if (operacoes[i][0] == 'I')
            {
                char *ptr = strtok(operacoes[i], " ");
                char *pegar;
                int p = 0;
                while (ptr != NULL)
                {
                    if (p == 1)
                    {
                        pegar = ptr;
                    }

                    ptr = strtok(NULL, "");
                    p++;
                }
                char *ret;
                pegar[22] = '\0';
                for (int j = 0; j < ghj; j++)
                {
                    if (testar(pegar, eric[j].iid) == 1)
                    {
                        // printf("%s\n", eric[j].iid);
                        inserir(eric[j]);

                        j = ghj + 1;
                    }
                }
            }

            else if (operacoes[i][0] == 'R')
            {
                Musica eric = remover();
                //printf("%s\n",eric.iid);
                printf("(R) %s\n", (eric.nome));
            }
        }
        mostrar();
        free(pegar);
        free(eric);
    }
    for (int i = 0; i < MAXTAM; i++)
    {
        free(entradas[i]);
        free(operacoes[i]);
    }
}

int testar(char *pri, char *segu)
{
    int e = 1;
    for (int i = 0; i < 22; i++)
    {
        if (pri[i] != segu[i])
        {
            e = 0;
            return e;
        }
    }
    return e;
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
