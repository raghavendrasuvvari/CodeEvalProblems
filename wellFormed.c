/*
 * wellFormed.c
 *
 *  Created on: May 28, 2014
 *      Author: Raghavendra
 */
/*
 * CHALLENGE DESCRIPTION:

Given a string comprising just of the characters (,),{,},[,] determine if it is well-formed or not.

INPUT SAMPLE:

Your program should accept as its first argument a path to a filename. Each line in this file contains a string comprising of the characters mentioned above. E.g.

()
([)]
OUTPUT SAMPLE:

Print out True or False if the string is well-formed. E.g.

True
False
*/
#include<stdlib.h>
#include<stdio.h>
#include<string.h>

#define MAXSIZE 100

struct stack
{
	int stk[MAXSIZE];
	int top;
};

typedef struct stack STACK;
STACK s;

int main(int argc, char *argv[])
{
	FILE *fp = NULL;
	char *line=NULL;
	char str[256];
	size_t read;
	size_t len = 0;
	int i=0;
	s.top = -1;

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
			s.top = -1;
			strcpy(str, line);
			if(str[0]=='\n')
				continue;
			else if((str[0]==')')||(str[0]=='}')||(str[0]==']'))
			{
				printf("False\n");
				continue;
			}
			for(i=0;i<strlen(str);i++)
			{
				if((str[i]=='(')||(str[i]=='{')||(str[i]=='['))
				{
					s.top = s.top + 1;
					s.stk[s.top] = str[i];
				}
				else if(str[i]==')')
				{
					if(s.stk[s.top]=='(')
						s.top = s.top - 1;
				}
				else if(str[i]=='}')
				{
					if(s.stk[s.top]=='{')
						s.top = s.top - 1;
				}
				else if(str[i]==']')
				{
					if(s.stk[s.top]=='[')
						s.top = s.top - 1;
				}
			}
			if (s.top == -1)
				printf("True\n");
			else
				printf("False\n");

		}
}
