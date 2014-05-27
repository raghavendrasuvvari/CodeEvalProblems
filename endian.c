/*
 * endian.c
 *
 *  Created on: May 27, 2014
 *      Author: Raghavendra
 */
/*
 * CHALLENGE DESCRIPTION:

Write a program to print out the endianness of the system.

INPUT SAMPLE:

None

OUTPUT SAMPLE:

Print to stdout, the endianness, wheather it is LittleEndian or BigEndian.
e.g.

BigEndian*/

#include<stdio.h>

int main()
{

	int num = 1;
	/*(char*)&num will be pointing to first byte of that int*/
	if(*(char *)&num == 1)
		printf("LittleEndian\n");
	else
		printf("BigEndian\n");
	return 0;
}

