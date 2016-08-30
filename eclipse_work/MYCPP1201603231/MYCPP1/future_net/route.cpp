#include "route.h"
#include "lib/lib_record.h"
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int isValid(int column, int *res, int vim)
{
	int i;
	if (res[vim - 1] == res[column])
		return 0;
	for (i = 0; i < column; i++)
		if (res[i] == res[column])
			return 0;
	return 1;
}
void search_route1(char *topo[5000], int edge_num, char *demand, int vim)
{

	int result1[666]; //
	int num_of_demand = 0;
	int num_of_points = 0;
	int i, j;
	int loc;
	int adjacent[600][8] =
	{ 0 };
	int adj_res[600][8] =
	{ 0 };
	int adjindex[600] =
	{ 0 };
	int adjindex1[600] =
	{ 0 };
	j = 0;
	int demands[52];
	int points[600];
	//char s[] = "ab-cd : ef;gh :i-jkl;mnop;qrs-tu: vwx-y;z";
	char delim[3] = ",|";
	char *p;
	demands[j++] = atoi(strtok(demand, delim));
	while ((p = strtok(NULL, delim)))
		demands[j++] = atoi(p);
	num_of_demand = j;
	for (i = 0; i < 600; i++)
		for (j = 0; j < 8; j++)
		{
			adjacent[i][j] = 666;
			adj_res[i][j] = 5000;
		}
	for (i = 0; i < 666; i++)
	{
		result1[i] = -1;
	}
	result1[0] = demands[0];
	result1[vim - 1] = demands[1];
	int topo_int[edge_num][4];
	for (i = 0; i < edge_num; i++)
	{
		int x, y;
		sscanf(topo[i], "%d,%d,%d,%d", &topo_int[i][0], &topo_int[i][1],
				&topo_int[i][2], &topo_int[i][3]);
		x = topo_int[i][1];
		if (num_of_points < x)
			num_of_points = x;
		y = topo_int[i][2];
		if (num_of_points < y)
			num_of_points = y;
		adjacent[x][adjindex[x]] = y;
		adj_res[x][adjindex[x]] = edge_num;
		adjindex[topo_int[i][1]]++;
	}
	num_of_points++;
	printf("\n--num_of_points--->%d\n", num_of_points);
//	for (i = 0; i < 600; i++)
//	{
//			for (j = 0; j < 8; j++)
//			{
//				printf("  %d",adjacent[i][j]);
//			}printf("\n");
//	}
//////////////////////////////////////////////////////////
	loc = 1;
	while (1)
	{
		if (result1[loc] == -1)
		{
			result1[loc] = adjacent[result1[loc - 1]][0];
			adjindex1[loc - 1]++;
			//if loc - 1 not adjacent to loc
		}
		if (isValid(loc, result1, vim))
		{
			if (loc == vim - TWO)
			{
				//here need prove the last point
				for (i = 0; i < vim; i++)
				{
					printf("\n%d->", result1[i]);
				}
				return;
			}
			else
				loc++;
			//end
		}
		else if (adjindex1[loc - 1] < adjindex[loc - 1] - 1)
		{
			result1[loc] = adjacent[result1[loc - 1]][adjindex1[loc - 1]];
			adjindex1[loc - 1]++;
			//end
		}
		else
		{
			while (adjindex1[loc - 1] == adjindex[loc - 1] - 1)
			{
				if (loc == 1)
				{
					for (i = 0; i < vim; i++)
					{
						printf("\n%d->", result1[i]);
					}
					return;
				}
				result1[loc] = 666;
				adjindex1[loc - 1] = 0;
				loc--;
			}
			result1[loc] = adjacent[result1[loc - 1]][adjindex1[loc - 1]];
			adjindex1[loc - 1]++;
			//end
		}
	}
	puts("__my__");
//output NA
//if(edge_num > 0)return;
//output  is not NA

//    for (int i = 0; i < 3; i++)
//    record_result(result[i]);
}
void search_route(char *topo[5000], int edge_num, char *demand)
{
	//no less than 2;no more than points
	//search_route1(topo, edge_num, demand, 4);

	int num_of_demand = 0;
	int num_of_points = 0;
	int i, j;
	int loc;
	int adjacent[600][8] =
	{ 0 };
	int adj_res[600][8] =
	{ 0 };
	int adjindex[600] =
	{ 0 };
	int adjindex1[600] =
	{ 0 };
	j = 0;
	int demands[52];
	int points[600];
	//char s[] = "ab-cd : ef;gh :i-jkl;mnop;qrs-tu: vwx-y;z";
	char delim[3] = ",|";
	char *p;
	demands[j++] = atoi(strtok(demand, delim));
	while ((p = strtok(NULL, delim)))
		demands[j++] = atoi(p);
	num_of_demand = j;
	for (i = 0; i < 600; i++)
		for (j = 0; j < 8; j++)
		{
			adjacent[i][j] = 666;
			adj_res[i][j] = 5000;
		}
	int topo_int[edge_num][4];
	for (i = 0; i < edge_num; i++)
	{
		int x, y;
		sscanf(topo[i], "%d,%d,%d,%d", &topo_int[i][0], &topo_int[i][1],
				&topo_int[i][2], &topo_int[i][3]);
		x = topo_int[i][1];
		if (num_of_points < x)
			num_of_points = x;
		y = topo_int[i][2];
		if (num_of_points < y)
			num_of_points = y;
		adjacent[x][adjindex[x]] = y;
		adj_res[x][adjindex[x]] = edge_num;
		adjindex[topo_int[i][1]]++;
	}
	num_of_points++;
	printf("\n--num_of_points--->%d\n", num_of_points);
	search_route1(topo, edge_num, demand, 3);
//output NA
//if(edge_num > 0)return;
//output  is not NA

//    for (int i = 0; i < 3; i++)
//    record_result(result[i]);
}
