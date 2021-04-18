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

int caracterPosition(char caracter, char *readFile, int lenghtReadFile);
Musica getArtistis(char *readFile, Musica music, int lenghtReadFile);
Musica get3Information(char *readFile, Musica music, int lenghtReadFile);
char *getNewString(char *readFile, int lenghtReadFile);
Musica picTheLast(char *newString, int sizoFNew, Musica music);
bool haveOR(char *String, int lenghtString);
void toString(Musica music);
int getLengthString(char *String, int lenaghtOldString);
Musica gatNameOfMusic(char *newString, int sizoFNew, Musica music);
char *getFrist(char *newString, int sizeofString, Musica music);
char *getLast(char *newString, int sizeofString, Musica music);
Musica fazerTudo(char *readFile, int lengthReadFile);
void insertDate(Date *d, char *stringData);
void displayFormattedDate(Date *d);
double handle_percentage(double value);
Musica *insercaoPorCor(Musica *eric, int n, int cor, int h);
Musica *shellsort(Musica *eric, int n);

int main()
{
    char *entradas[MAXTAM];
    for (int i = 0; i < MAXTAM; i++)
        entradas[i] = (char *)calloc(100, sizeof(char));

    int variacaoENtradas = 0;
    do
    {
        scanf("%s", entradas[variacaoENtradas]);
    } while (strncmp(entradas[variacaoENtradas++], "FIM", 3) != 0 && variacaoENtradas < MAXTAM);

    FILE *arquivo = fopen("/tmp/data.csv", "r");

    if (arquivo != NULL)
    {
        char readFile[1000];
        int ghj = 0;

        Musica eric[variacaoENtradas];

        while (fgets(readFile, sizeof(readFile), arquivo) != NULL && ghj < variacaoENtradas)
        {
            for (int y = 0; y < variacaoENtradas; y++)
            {
                if (strstr(readFile, entradas[y]))
                {
                    int lengthReadFile = sizeof(readFile) - 1;
                    //printf("%s\n", entradas[y]);
                    eric[ghj] = fazerTudo(readFile, lengthReadFile);

                    ghj++;
                    y = variacaoENtradas + 1;
                }
            }
        }
        Musica *resposta = shellsort(eric, variacaoENtradas);
        for (int e = 0; e < ghj; e++)
        {
            toString(resposta[e]);
        }
    }
    for (int i = 0; i < MAXTAM; i++)
    {
        free(entradas[i]);
    }
}

Musica fazerTudo(char *readFile, int lengthReadFile)
{
    Musica eric;

    eric = getArtistis(readFile, eric, lengthReadFile); // ok aki
    eric = get3Information(readFile, eric, lengthReadFile);
    char *newString = getNewString(readFile, lengthReadFile);
    //printf("%s", newString);
    int newlenght = getLengthString(readFile, lengthReadFile);
    eric = picTheLast(newString, newlenght, eric);
    //toString(eric);
    return eric;
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
        //printf("-----%c\n", readFile[positionC]);
    }

    return positionC;
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

    int endOfInformation = caracterPosition('[', readFile, lenghtReadFile);
    char information[endOfInformation - 2];
    int p = 0;
    for (int i = 0; i < endOfInformation - 1; i++)
    {
        if (readFile[i] != '[')
        {
            information[p] = readFile[i];
            p += 1;
            //  i=endOfInformation;
        }
    }
    information[p] = '\0';
    information[strlen(information)] = '\0';
    // printf("%s\n", information);
    float values[3];
    float *pato = (float *)malloc(sizeof(float) * 3);
    char *piece;
    piece = strtok(information, ",");
    int m = 0;
    while (piece != NULL)
    {
        values[m] = atof(piece);
        // printf("%s\n", piece);
        if (m == 2)
        {
            strcpy(music.acousticness, piece);
        }
        m++;
        piece = strtok(NULL, ",");
    }

    music.valence = values[0];
    music.year = values[1];
    // music.acousticness = values[2];
    // printf("----------%f\n",music.acousticness);

    return music;
}

char *getNewString(char *readFile, int lenghtReadFile)
{

    int getCutPart = caracterPosition(']', readFile, lenghtReadFile);

    char newString[lenghtReadFile - getCutPart];
    char *eric = (char *)malloc(sizeof(char) * (lenghtReadFile - getCutPart));
    int x = 0;
    //  getCutPart + 4;
    for (int i = getCutPart + 2; i < sizeof(newString) - 1; i += 1)
    {
        newString[x] = readFile[i];
        x++;
    }
    strcpy(eric, newString);
    //  printf("%s", eric);
    return eric;
}
bool haveOR(char *String, int lenghtString)
{

    for (int i = 0; i < lenghtString - 1; i += 1)
    {
        if (String[i] == '"')
        {
            return true;
        }
    }
    return false;
}
double handle_percentage(double value)
{
    return ceil(value) == value ? value / 100 : value;
}
Musica picTheLast(char *newString, int sizoFNew, Musica music)
{

    if (haveOR(newString, sizoFNew))
    {
        // printf("ola");
        music = gatNameOfMusic(newString, sizoFNew, music);
        char *fristString = getFrist(newString, sizoFNew, music);
        float ggg[15];
        char *piece1 = strtok(fristString, ",");
        int m = 0;
        while (piece1 != NULL)
        {
            //printf("----------------------------------------------------------------------------------------- ## \n");
            if (m == 0)
            {
                //danceability

                //music.danceability = handle_percentage((atof(piece1)));
                strcpy(music.danceability, piece1);
                //printf("Danceabil LF%lf\n", music.danceability);
                //printf("Danceabil GG %G\n", music.danceability);
            }
            else if (m == 1)
            {
                //duration+ms
                // ggg[m] = atoi(piece1);

                music.duration_ms = handle_percentage(atoi(piece1));
                //printf("Duration LF %lf\n", music.duration_ms);
                //printf("Duration GG %G\n", music.duration_ms);
            }
            else if (m == 2)
            {
                //ggg[m] = atof(piece1);

                // music.energy = handle_percentage(atof(piece1));
                strcpy(music.energy, piece1);
                //printf("Energy LF %lf\n", music.energy);
                //printf("Energy GG %G\n", music.energy);
            }
            else if (m == 3)
            {
                // explicit
            }
            else if (m == 4)
            {
                //printf("id ====%s\n", piece1);
                strcpy(music.iid, piece1);
            }
            else if (m == 5)
            {
                //ggg[m] = atof(piece1);

                strcpy(music.instrumentalness, piece1);

                //printf("Instrumenta LF %lf\n", music.instrumentalness);
                //printf("Instrumenta GG %G\n", music.instrumentalness);
            }
            else if (m == 6)
            {
                //key
                strcpy(music.key, piece1);
            }
            else if (m == 7)
            {
                //liveness
                //ggg[m] = atof(piece1);
                strcpy(music.liveness, piece1);
                //music.liveness = handle_percentage(atof(piece1));
                //printf(" Liveness LF %lf\n", music.liveness);
                //printf("Liveness GG %G\n", music.liveness);
            }
            else if (m == 8)
            {
                //loudness
                // ggg[m] = atof(piece1);

                //  music.loudness = atof(piece1);
                strcpy(music.loudness, piece1);
                //printf(" Liveness LF %lf\n", music.loudness);
                //printf("loudness GG %G\n", music.loudness);
            }
            m++;

            piece1 = strtok(NULL, ",");
        }
        char *secondString = getLast(newString, sizoFNew, music);
        float www[5];
        char *piece2 = strtok(fristString, ",");
        int y = 0;
        while (piece2 != NULL)
        {
            if (y == 0)
            {
                // popularitu
                //www[y] = atoi(piece2);
                music.popularity = atoi(piece2);
            }
            else if (y == 1)
            {
                //realease_date

                insertDate(music.release_date, piece2);
            }
            else if (y == 2)
            {
                //speechines
                //www[y] = atof(piece2);

                music.speechiness = handle_percentage(atof(piece2));
                //printf("speechiness LF%lf\n", music.speechiness);
                //printf("speechiness GG %G\n", music.speechiness);
            }
            else if (y == 3)
            {
                //tempo
                //www[y] = atof(piece2);

                music.tempo = atof(piece2);
                //printf("Tempo LF%lf\n", music.tempo);
                //printf("Tempo GG %G\n", music.tempo);
            }

            y++;
            piece2 = strtok(NULL, ",");
        }
    }
    else
    {

        float ttt[15];
        char *piece = strtok(newString, ",");
        int m = 0;
        while (piece != NULL)
        {
            if (m == 0)
            {
                // ttt[m] = atof(piece);

                //music.danceability = handle_percentage(atof(piece));
                strcpy(music.danceability, piece);
                //printf("Danceabil LF%lf\n", music.danceability);
                //printf("Danceabil GG %G\n", music.danceability);
            }
            else if (m == 1)
            {
                //ttt[m] = atoi(piece);

                music.duration_ms = atof(piece);
                //printf("Duration LF %lf\n", music.duration_ms);
                //printf("Duration GG %G\n", music.duration_ms);
            }
            else if (m == 2)
            {
                //ttt[m] = atof(piece);

                strcpy(music.energy, piece);
                //printf("Energy LF %lf\n", music.energy);
                //printf("Energy GG %G\n", music.energy);
            }
            else if (m == 3)
            {
                //exp
            }
            else if (m == 4)
            {
                //id
                //printf("id ====%s\n", piece);
                strcpy(music.iid, piece);
            }
            else if (m == 5)
            {
                //intumwntalness
                //ttt[m] = atof(piece);

                strcpy(music.instrumentalness, piece);
                //printf("Instrumenta LF %lf\n", music.instrumentalness);
                //printf("Instrumenta GG %G\n", music.instrumentalness);
            }
            else if (m == 6)
            {
                //ky
                strcpy(music.key, piece);
            }
            else if (m == 7)
            {
                //liveness

                // ttt[m] = atof(piece);
                strcpy(music.liveness, piece);
                //music.liveness = handle_percentage(atof(piece));
                //printf(" Liveness LF %lf\n", music.liveness);
                //printf("Liveness GG %G\n", music.liveness);
            }
            else if (m == 8)
            {
                //loudness

                //ttt[m] = atof(piece);

                //  music.loudness = atof(piece);

                strcpy(music.loudness, piece);
                //printf(" Liveness LF %lf\n", music.loudness);
                //printf("loudness GG %G\n", music.loudness);
            }
            else if (m == 9)
            {
                //mode
            }
            else if (m == 10)
            {
                //nome
                strcpy(music.nome, piece);
            }
            else if (m == 11)
            {
                //popularity
                // ttt[m] = atoi(piece);
                music.popularity = atof(piece);
            }
            else if (m == 12)
            {
                //realease_date
                insertDate(music.release_date, piece);
            }
            else if (m == 13)
            {
                //speechiness
                //ttt[m] = atof(piece);

                music.speechiness = handle_percentage(atof(piece));
                //printf("speechiness LF%lf\n", music.speechiness);
                //printf("speechiness GG %G\n", music.speechiness);
            }
            else
            {
                //tempo
                //ttt[m] = atof(piece);

                music.tempo = atof(piece);
                //printf("Tempo LF%lf\n", music.tempo);
                //printf("Tempo GG %G\n", music.tempo);
            }
            m++;

            piece = strtok(NULL, ",");
        }
    }

    return music;
}

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

int getLengthString(char *String, int lenaghtOldString)
{
    int getCutPart = caracterPosition(']', String, lenaghtOldString);
    int tamanho = 0;

    char newString[lenaghtOldString - getCutPart];
    for (int i = getCutPart + 2; i < sizeof(newString) - 1; i += 1)
    {
        tamanho += 1;
    }

    return tamanho;
}

Musica gatNameOfMusic(char *newString, int sizoFNew, Musica music)
{

    int getCutPart = caracterPosition('"', newString, sizoFNew);
    char firstCutString[sizoFNew - getCutPart];

    int x = 0;
    for (int i = getCutPart; i < sizoFNew - 1; i++)
    {
        firstCutString[x] = newString[i];
        x += 1;
    }
    int local = 0;
    for (; x > 0; x--)
    {
        if (newString[x] == '"')
        {
            local = x;
            x = 0;
        }
    }

    char nameOfMusic[(sizoFNew - getCutPart) - local - 1];
    int v = 0;
    for (int i = getCutPart; i < local - 1; i++)
    {

        nameOfMusic[v] = newString[i];
        v += 1;
    }
    for (int i = 0; i < v; i++)
    {
        if (nameOfMusic[i] == '"')
        {
            nameOfMusic[i] = ' ';
        }
    }
    strcpy(music.nome, nameOfMusic);
    return music;
}
char *getFrist(char *newString, int sizeofString, Musica music)
{
    int getCutPart = caracterPosition('"', newString, sizeofString);
    char firstCutString[sizeofString - getCutPart];
    char *eric = (char *)malloc(sizeof(char) * (sizeofString - getCutPart));
    for (int x = 0; x < getCutPart - 1; x++)
    {
        firstCutString[x] = newString[x + 1];
    }
    //printf("---%s\n", firstCutString);
    strcpy(eric, firstCutString);
    return eric;
}
char *getLast(char *newString, int sizeofString, Musica music)
{
    int getCutPart = caracterPosition('"', newString, sizeofString);
    int inicio = 0;

    for (int i = sizeofString - 1; i > getCutPart; i--)
    {
        if (newString[i] == '"')
        {
            inicio = i;
            i = 0;
        }
    }
    //printf("--->>%d\n", inicio);

    char lastCurString[sizeofString - inicio];
    int x = 0;
    char *eric = (char *)malloc(sizeof(char) * (sizeofString - inicio));
    for (int i = inicio + 2; i < sizeofString; i++)
    {
        lastCurString[x] = newString[i];
        x++;
    }
    strcpy(eric, lastCurString);
    return eric;
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

/*Musica *shellsort(Musica *eric, int n)
{
    //Musica *pegar = eric;
    int h = 1;

    do
    {
        h = (h * 3) + 1;
    } while (h < n);

    do
    {
        h /= 3;
        for (int cor = 0; cor < h; cor++)
        {
            eric = insercaoPorCor(eric, n, cor, h);
        }
    } while (h != 1);
    return eric;
}

Musica *insercaoPorCor(Musica *eric, int n, int cor, int h)
{
    Musica pegar;
    for (int i = (h + cor); i < n; i += h)
    {
        pegar = eric[i];
        //strcpy(pegar[0], eric[i]);
        int j = i - h;
        while ((j >= 0) && (eric[j].iid > pegar.iid))
        {
            eric[j + h] = eric[j];
            j -= h;
        }
        eric[j + h] = pegar;
        // strcpy(eric[j + h], eric[tmp]);
    }
    return eric;
}*/

Musica *shellsort(Musica *eric, int n)
{
    // Start with a big gap, then reduce the gap
    for (int gap = n / 2; gap > 0; gap /= 2)
    {
        // Do a gapped insertion sort for this gap size.
        // The first gap elements a[0..gap-1] are already in gapped order
        // keep adding one more element until the entire array is
        // gap sorted
        for (int i = gap; i < n; i += 1)
        {
            // add a[i] to the elements that have been gap sorted
            // save a[i] in temp and make a hole at position i
            Musica pegar = eric[i];

            // shift earlier gap-sorted elements up until the correct
            // location for a[i] is found
            int j;
            for (j = i; j >= gap && eric[j].iid > pegar.iid; j -= gap)
                //arr[j] = arr[j - gap];
                eric[j] = eric[j - gap];

            //  put temp (the original a[i]) in its correct location
            //arr[j] = temp;
            eric[j] = pegar;
        }
    }
    return eric;
}