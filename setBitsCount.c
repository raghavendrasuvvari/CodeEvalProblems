/*
 * setBitsCount.c
 *
 *  Created on: May 26, 2014
 *      Author: Raghavendra
 */

/*
 * CHALLENGE DESCRIPTION:

Write a program to determine the number of 1 bits in the internal representation of a given integer.

INPUT SAMPLE:

The first argument will be a path to a filename containing an integer, one per line. E.g.

10
22
56
OUTPUT SAMPLE:

Print to stdout, the number of ones in the binary form of each number. E.g.

2
3
3
Submit your solution in a file (some file name).(py2| c| cpp| java| rb| pl| php| tcl| clj| js| scala| cs| m| py3| hs| go| bash| lua) or use the online editor.*/

#include<stdio.h>
#include<stdlib.h>

/*Function implementing Brian Kerninghan's algorithm*/
int countSetBits_BKalgm(long n)
{
    unsigned int count = 0;
    while (n)
    {
      n &= (n-1) ;
      count++;
    }
    return count;
}

int main(int argc, char *argv[])

{
    FILE *fp = NULL;
    char read[80];
    long integer;

    if(argc > 2 || argc < 2)
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
    while(fgets(read, 80, fp)!=NULL)
    {
    	if (read[0] == '\n')
    		continue;
        sscanf (read, "%ld", &integer);
        printf("%d\n", countSetBits_BKalgm(integer));
    }

    fclose(fp);
    return 0;
}
