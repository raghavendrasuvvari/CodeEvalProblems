/*
 * binary.c
 *
 *  Created on: May 26, 2014
 *      Author: Raghavendra
 */

/*
 * DECIMAL TO BINARY
CHALLENGE DESCRIPTION:

Given a decimal (base 10) number, print out its binary representation.

INPUT SAMPLE:

Your program should accept as its first argument a path to a filename containing whole decimal numbers greater or equal to 0, one per line.
Ignore all empty lines. E.g.

2
10
67
OUTPUT SAMPLE:

Print the binary representation, one per line. E.g.

10
1010
1000011*/

#include<stdio.h>
#include<stdlib.h>

void binary(unsigned n)
{
    if (n > 1)
    	binary(n/2);

    printf("%d", n % 2);
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
            binary(integer);
            printf("\n");
        }

        fclose(fp);
        return 0;
    }

