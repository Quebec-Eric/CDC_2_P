#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

typedef struct
{
    char iid[30];
    char nome[200];
    char key[20];
    char artistis[98];
    int num_artists;
    char release_date[12];
    double acousticness;
    double danceability;
    double energy;
    int duration_ms;
    double instrumentalness;
    double valence;
    int popularity;
    float tempo;
    double liveness;
    double loudness;
    double speechiness;
    int year;
} Musica;

Musica Clone_music(Musica music)
{

    return music;
}

int caracterPosition(char caracter, char *readFile, int lenghtReadFile);
Musica getArtistis(char *readFile, Musica music, int lenghtReadFile);
void get3Information(char *readFile, Musica music, int lenghtReadFile);
char *getNewString(char *readFile, int lenghtReadFile);
Musica picTheLast(char *newString, int sizoFNew, Musica music);
bool haveOR(char *String, int lenghtString);
void toString(Musica music);
int getLengthString(char *String, int lenaghtOldString);
Musica gatNameOfMusic(char *newString, int sizoFNew, Musica music);
char *getFrist(char *newString, int sizeofString, Musica music);
char *getLast(char *newString, int sizeofString, Musica music);
int main()
{
    char pubIn[50];
    fgets(pubIn, sizeof(pubIn), stdin);
    pubIn[strlen(pubIn) - 1] = '\0';
    int lengthPubIN = sizeof(pubIn);

    while (strcmp(pubIn, "FIM") != 0)
    {
        FILE *csvFile = fopen("data.csv", "r");
        if (csvFile == NULL)
        {
            printf("Erro");
        }
        else
        {
            Musica music;
            char readFile[400];
            fgets(readFile, sizeof(readFile), csvFile);
            while (fgets(readFile, sizeof(readFile), csvFile))
            {
                int lengthReadFile = sizeof(readFile);

                if (strstr(readFile, pubIn) != NULL)
                {
                    music = getArtistis(readFile, music, lengthReadFile);
                    get3Information(readFile, music, lengthReadFile);
                    char *newString = getNewString(readFile, lengthReadFile);
                    //printf("%s", newString);
                    int newlenght = getLengthString(readFile, lengthReadFile);
                    music = picTheLast(newString, newlenght, music);
                    // printf("%s",music.artistis);
                    toString(music);
                }
            }
        }
        fgets(pubIn, sizeof(pubIn), stdin);
        pubIn[strlen(pubIn) - 1] = '\0';
        lengthPubIN = sizeof(pubIn);
    }
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
    //printf("-----%d\n",fritPosition);
    //printf("=====%d\n",lastPosition);
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
    strcpy(music.artistis, artistis1);
    //printf("%s\n",artistis1);
    //scanf("%d",&testar);
    //printf("%s",music.artistis);
    return music;
}

void get3Information(char *readFile, Musica music, int lenghtReadFile)
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
    char *piece;
    piece = strtok(information, ",");
    int m = 0;
    while (piece != NULL)
    {
        values[m] = atof(piece);
        // printf("%s\n", piece);
        m++;
        piece = strtok(NULL, ",");
    }

    music.valence = values[0];
    music.year = values[1];
    music.acousticness = values[2];
}

char *getNewString(char *readFile, int lenghtReadFile)
{

    int getCutPart = caracterPosition(']', readFile, lenghtReadFile);

    char newString[lenghtReadFile - getCutPart];
    char *eric = (char *)malloc(sizeof(char) * (lenghtReadFile - getCutPart));
    int x = 0;
    getCutPart + 4;
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
            if (m == 0)
            {
                //danceability
                ggg[m] = atof(piece1);
                music.danceability = ggg[m];
            }
            else if (m == 1)
            {
                //duration+ms
                ggg[m] = atoi(piece1);
                music.duration_ms = ggg[m];
            }
            else if (m == 2)
            {
                ggg[m] = atof(piece1);
                music.energy = ggg[m];
            }
            else if (m == 3)
            {
                // explicit
            }
            else if (m == 4)
            {
                strcpy(music.iid, piece1);
            }
            else if (m == 5)
            {
                ggg[m] = atof(piece1);
                music.instrumentalness = ggg[m];
            }
            else if (m == 6)
            {
                //key
                strcpy(music.key, piece1);
            }
            else if (m == 7)
            {
                //liveness
                ggg[m] = atof(piece1);
                music.liveness = ggg[m];
            }
            else if (m == 8)
            {
                //loudness
                ggg[m] = atof(piece1);
                music.loudness = ggg[m];
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
                www[y] = atoi(piece2);
                music.popularity = www[y];
            }
            else if (y == 1)
            {
                //realease_date
                strcpy(music.release_date, piece2);
            }
            else if (y == 2)
            {
                //speechines
                www[y] = atof(piece2);
                music.speechiness = www[y];
            }
            else if (y == 3)
            {
                //tempo
                www[y] = atof(piece2);
                music.tempo = www[y];
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
                ttt[m] = atof(piece);
                music.danceability = ttt[m];
            }
            else if (m == 1)
            {
                ttt[m] = atoi(piece);
                music.duration_ms = ttt[m];
            }
            else if (m == 2)
            {
                ttt[m] = atof(piece);
                music.energy = ttt[m];
            }
            else if (m == 3)
            {
                //exp
            }
            else if (m == 4)
            {
                //id
                strcpy(music.iid, piece);
            }
            else if (m == 5)
            {
                //intumwntalness
                ttt[m] = atof(piece);
                music.instrumentalness = ttt[m];
            }
            else if (m == 6)
            {
                //ky
                strcpy(music.key, piece);
            }
            else if (m == 7)
            {
                //liveness

                ttt[m] = atof(piece);
                music.liveness = ttt[m];
            }
            else if (m == 8)
            {
                //loudness

                ttt[m] = atof(piece);
                music.loudness = ttt[m];
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
                ttt[m] = atoi(piece);
                music.popularity = ttt[m];
            }
            else if (m == 12)
            {
                //realease_date
                strcpy(music.release_date, piece);
            }
            else if (m == 13)
            {
                //speechiness
                ttt[m] = atof(piece);
                music.speechiness = ttt[m];
            }
            else
            {
                //tempo
                ttt[m] = atof(piece);
                music.tempo = ttt[m];
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
    printf("%s ## %s ## %G ## %G ## %G ## %G ## %G ## %G ## %G ## %d\n",
           music.nome, music.release_date, music.acousticness, music.danceability, music.instrumentalness,
           music.liveness, music.loudness, music.loudness, music.energy, music.duration_ms);
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
    for (x; x > 0; x--)
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
