/** ****************************
*   Eric Azevedo de Oliveira  * 
*   Aluno da Puc              *  
*   2 periodo                 *  
*******************************/

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
int main()
{
    char *arquivo[400];
    for (int i = 0; i < 400; i++)
        arquivo[i] = (char *)calloc(50, sizeof(char));
    int x = 0;
    do
    {
        scanf("%s", arquivo[x]);
    } while (strncmp(arquivo[x++], "FIM", 3) != 0 && x < 400);

    char *teste[400];
    for (int i = 0; i < 400; i++)
        teste[i] = (char *)calloc(50, sizeof(char));

    int p = 0;
    do
    {
        scanf("%s", teste[p]);
    } while (strncmp(teste[p++], "FIM", 3) != 0);
    char *aux;

    int saber = 0;
    for (int t = 0; t < p; t++)
    {
        int first = 0;
        int last = x - 1;
        int mid = (first + last) / 2;
        saber = 0;
        while (first <= last)
        {
            //  printf("==Mi=%s\n", pubIn[mid]);
            // printf("==pro=%s\n", test[t]);
            if (strcmp(arquivo[mid], teste[t]) == 0)
            {
                printf("SIM\n");

                saber = 4;
                first = last + 1;
            }
            else if (strcmp(arquivo[mid], teste[t]) > 0)
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
}