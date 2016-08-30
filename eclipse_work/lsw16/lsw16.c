#include <stdio.h>
#include<stdlib.h>
#include <string.h>
int count;
int find_index(char (*name)[20], char tempname[], int order[]);
void find_max(int order[], char (*name)[20]);
int word_analyse(FILE *fp)
{
	char tempname[20];
	int temporder;
	char name[1000][20];
	int order[1000] =
	{ 0 };
	int cursor = 0;
	int tempcursor = 0;
	while (!(feof(fp)))
	{
		fscanf(fp, "%s%d", tempname, &temporder);
		tempcursor = find_index(name, tempname, order);
		if (-1 == tempcursor)
		{
			strcpy(name[cursor], tempname);
			order[cursor] = temporder;
			cursor++;

		}
		else
		{
			order[tempcursor] += temporder;
		}
	}
	tempcursor = 0;
	while (order[tempcursor])
	{
		tempcursor++;
	}
	count = tempcursor;
	find_max(order, name);
	tempcursor = 0;
	while (order[tempcursor])
	{
		puts(name[tempcursor]);
		printf("%d\n", order[tempcursor]);
		tempcursor++;
	}

	return 0;
}
int find_index(char (*name)[20], char tempname[], int order[])
{
	int tempcursor = 0;
	while (order[tempcursor])
	{
		if (strcmp(name[tempcursor], tempname) == 0)
			return tempcursor;
		tempcursor++;
	}
	return -1;
}
void find_max(int order[], char (*name)[20])
{
	int i, j;
	char tempname[20];
	int temporder;
	for (i = 0; i < 10; i++)
	{
		for (j = i + 1; j < count; j++)
		{
			if (order[j] > order[i])
			{
				//swap
				strcpy(tempname, name[i]);
				temporder = order[i];
				strcpy(name[i], name[j]);
				order[i] = order[j];
				strcpy(name[j], tempname);
				order[j] = temporder;

			}
		}
	}
}
int main(int argc, char** argv)
{
	FILE *fp;
	if (argc != 2)
	{
		printf("useage: a.exe input.txt \n");
		system("pause");
		return 0;
	}
//check file
	fp = fopen(argv[1], "rt");
	if (fp == NULL)
	{
		printf("cannot open infile\n");
		return 0;
	}
	word_analyse(fp);
	return 0;
}
