/*
 * nonrepeat.c
 *
 *  Created on: May 28, 2014
 *      Author: Raghavendra
 */
/*
 * FIRST NON-REPEATED CHARACTER
CHALLENGE DESCRIPTION:

Write a program to find the first non repeated character in a string.

INPUT SAMPLE:

The first argument will be a path to a filename containing strings. E.g.

yellow
tooth
OUTPUT SAMPLE:

Print to stdout, the first non repeating character, one per line. E.g.

y
h
*/
#include<stdlib.h>
#include<stdio.h>
#include<string.h>
#define NO_OF_CHARS 256

/*some logic borrowed*/
int *getCharCountArray(char *str)
{
   int *count = (int *)calloc(sizeof(int), NO_OF_CHARS);
   int i;
   for (i = 0; *(str+i);  i++)
      count[*(str+i)]++;
   return count;
}

int firstNonRepeating(char *str)
{
  int *count = getCharCountArray(str);
  int index = -1, i;

  for (i = 0; *(str+i);  i++)
  {
    if (count[*(str+i)] == 1)
    {
      index = i;
      break;
    }
  }

  free(count);
  return index;
}

int main(int argc, char *argv[])
{
	FILE *fp = NULL;
	char *line=NULL;
	char str[256];
	size_t read;
	size_t len = 0;

	if(argc!=2)
	{
		exit(EXIT_FAILURE);
		printf("Invalid arguments\n");
	}

	fp = fopen(argv[1],"r");

	if(fp == NULL)
	{
		printf("ERROR: Couldn't open the file, please check\n");
		exit(EXIT_FAILURE);
	}
	while ((read = getline(&line, &len, fp)) != -1)
		{

			strcpy(str, line);
			int index =  firstNonRepeating(line);
			if (index == -1)
				printf("Invalid String");
			else
				printf("%c\n", str[index]);
		}
  return 0;
}

