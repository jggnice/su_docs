#include "route.h"
#include "lib/lib_record.h"
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
//common variables
int tepresult[600] =
{ 0 };
int dresult[60] =
{ 0 };
int num_of_demand = 0;
int num_of_points = 0;
int num_of_d = 0;
int topo_d[52 * MM][610];
int djaccent[52][MM] =
{ 0 };
int adjacent[600][8] =
{ 0 };
int dj_res[52][MM] =
{ 0 };
int adj_res[600][8] =
{ 0 };
int djindex[52] =
{ 0 };
int adjindex[600] =
{ 0 };
int demands[52];
int num_of_edge = 0;
//common variables ends
//int isValid(int column, int *res, int vim)
//{
//	int i;
//	if (res[vim - 1] == res[column])
//		return 0;
//	for (i = 0; i < column; i++)
//		if (res[i] == res[column])
//			return 0;
//	return 1;
//}
int isdjacent(int a, int b)
{
	int i = 0;
	for (i = 0; i < MM; i++)
	{
		if (djaccent[a][i] == b)
			return dj_res[a][i] + 1;
	} // return plus 1 due to index of 0
	return 0;
}
int containsAll(int *result1, int vim)
{
//	int i, j;
//	int count = 0;
//	for (i = 2; i < num_of_demand; i++)
//		for (j = 1; j < vim - 1; j++)
//		{
//			if (result1[j] == demands[i])
//				count++;
//		}
//	return count > (num_of_demand - 3);
	return 1;
}
void search_route3(int (*topo_int)[4], int sour)
{
	//// local variables ////
	int Visited[600] =
	{ 0 };
	int minweight = 1000000;
	int edgeall[600];
	int edgemin[600];
	int result1[Pn];
	int i;
	int loc = 1;
	int tar;
	int adjindex1[600] =
	{ 0 };
	//// local variables end ////
	for (i = 0; i < Pn; i++)
	{
		result1[i] = NOVALE;
	}
	result1[0] = demands[sour];
	Visited[demands[sour]] = 1;

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
		int notvalid = 0;
		if (result1[loc] == NOVALE)
		{
			//if loc has no candidates
			if (0 == adjindex[result1[loc - 1]])
			{
				//loc-1 not valid
				loc--;
				if (0 == loc)
					return;
				notvalid = 1;
				//loc-1 not valid
			}
			else
			{
				result1[loc] = adjacent[result1[loc - 1]][0];
				edgeall[loc - 1] = adj_res[result1[loc - 1]][0];
				adjindex1[result1[loc - 1]]++;
			}

		}
		if (!notvalid && !Visited[result1[loc]])
		{
			int re = result1[loc];
			int win = 0;
			Visited[re] = 1;
			for (i = 1; i < num_of_demand; i++)
			{
				///////// any how ////////////
				if (re == demands[i])
				{
					win = 1;
					break;
				}
			}
			tar = i;
			if (win)
			{
				Visited[re] = 0;
				if (djindex[sour] < MM)
				{
					int weight = 0;
					for (i = 0; i < loc; i++)
					{
						weight += topo_int[edgeall[i]][3];
						printf("__%d", result1[i]);
						////////////////////
						topo_d[num_of_d][i + 1] = edgeall[i];
					}
					printf("||--->%d cost = %d\n", demands[tar], weight);
					topo_d[num_of_d][0] = weight;
					topo_d[num_of_d][loc + 1] = -1;
					djaccent[sour][djindex[sour]] = tar;
					dj_res[sour][djindex[sour]] = num_of_d;
					djindex[sour]++;
					num_of_d++;
				}
				/////////////////////////////////////
//				if (weight < minweight)
//				{
//					minweight = weight;
//					for (i = 0; i < loc; i++)
//					{
//						edgemin[i] = edgeall[i];
//					}
//					edgemin[loc] = -1;
//				}

				//////////////////////////////////////
				notvalid = 1;

			}
			else
			{
				//valid and go on
				loc++;
				continue;
			}

		}
		else
			notvalid = 1;
		if (1 == notvalid)
		{
			if (adjindex1[result1[loc - 1]] < adjindex[result1[loc - 1]])
			{
				result1[loc] = adjacent[result1[loc - 1]][adjindex1[result1[loc
						- 1]]];
				edgeall[loc - 1] =
						adj_res[result1[loc - 1]][adjindex1[result1[loc - 1]]];
				adjindex1[result1[loc - 1]]++;
				//end
			}
			else
			{
				while (adjindex1[result1[loc - 1]] == adjindex[result1[loc - 1]])
				{
					if (loc == 1)
					{
//						printf("\n-------analyse finished--------\n");
						if (minweight >= tepresult[0])
							return;
						for (i = 0; i < 600; i++)
						{
							if (edgemin[i] < 0)
								break;
							tepresult[i + 1] = edgemin[i];
							printf("__%d", edgemin[i]);
						}
						tepresult[0] = minweight;
						tepresult[i + 1] = -1;
						printf("|| cost = %d", minweight);
						printf("\n");

						return;
					}
					//back
					result1[loc] = NOVALE;
					adjindex1[result1[loc - 1]] = 0;
					loc--;
//					Visited[result1[loc]] = 0;				//something
				}
				result1[loc] = adjacent[result1[loc - 1]][adjindex1[result1[loc
						- 1]]];

				edgeall[loc - 1] =
						adj_res[result1[loc - 1]][adjindex1[result1[loc - 1]]];
				adjindex1[result1[loc - 1]]++;
				//end
			}
		} //not valid
	} //while
}
void search_route1(int vim)
{
	//// local variables ////
	int isnotValid[60] =
	{ 1, 1 };
	int minweight = 1000000;
	int edgeall[vim - 1];
	int edgemin[vim - 1];
	int result1[60];
	int i;
	int loc;
	int adjindex1[600] =
	{ 0 };
	//// local variables end ////
	for (i = 0; i < 60; i++)
	{
		result1[i] = NOVALE;
	}
	result1[0] = 0;
	result1[vim - 1] = 1;
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
		int notvalid = 0;
		if (result1[loc] == NOVALE)
		{
			//if loc has no candidates
			if (0 == djindex[result1[loc - 1]])
			{
				//loc-1 not valid
				loc--;
				if (0 == loc)
					return;
				notvalid = 1;
				//loc-1 not valid
			}
			else
			{
				result1[loc] = djaccent[result1[loc - 1]][0];
				edgeall[loc - 1] = dj_res[result1[loc - 1]][0];
				adjindex1[result1[loc - 1]]++;
			}

		}
		if (!notvalid && !isnotValid[result1[loc]])
		{
			isnotValid[result1[loc]] = 1;
			if (loc == vim - TWO)
			{
				//here needs to prove the last point
				int adj = isdjacent(result1[loc], result1[loc + 1]);
				if (adj)
				{
					edgeall[loc] = adj - 1;
					printf("\n");
					int weight = 0;
					for (i = 0; i < vim - 1; i++)
					{
						weight += topo_d[edgeall[i]][0];
						printf("__%d", result1[i]);
					}
					printf("||__%d --> %d", result1[vim - 1], weight);
					printf("\n");
					/////////////////////////////////////
					if (weight < minweight)
					{
						minweight = weight;
						for (i = 0; i < vim - 1; i++)
						{
							edgemin[i] = edgeall[i];
						}
					}
					//////////////////////////////////////
					notvalid = 1;
				}
				else
				{
					notvalid = 1;
				}
			}
			else
			{
				loc++;
				continue;
			}

		}
		else
			notvalid = 1;
		if (1 == notvalid)
		{
			if (adjindex1[result1[loc - 1]] < djindex[result1[loc - 1]])
			{
				result1[loc] = djaccent[result1[loc - 1]][adjindex1[result1[loc
						- 1]]];
				edgeall[loc - 1] =
						dj_res[result1[loc - 1]][adjindex1[result1[loc - 1]]];
				adjindex1[result1[loc - 1]]++;
				//end
			}
			else
			{
				while (adjindex1[result1[loc - 1]] == djindex[result1[loc - 1]])
				{
					if (loc == 1)
					{
						printf("\n-------Result-Listed-Below--------\n");
						if (minweight >= dresult[0])
							return;
						for (i = 0; i < vim - 1; i++)
						{
							dresult[i + 1] = edgemin[i];
							printf("__%d", edgemin[i]);
						}
						dresult[0] = minweight;
						dresult[vim] = -1;
						printf("||--> %d", minweight);
						printf("\n");

						return;
					}
					result1[loc] = NOVALE;
					adjindex1[result1[loc - 1]] = 0;
					loc--;
					isnotValid[result1[loc]] = 0; //some
				}
				result1[loc] = djaccent[result1[loc - 1]][adjindex1[result1[loc
						- 1]]];
				edgeall[loc - 1] =
						dj_res[result1[loc - 1]][adjindex1[result1[loc - 1]]];
				adjindex1[result1[loc - 1]]++;
				//end
			}
		} //not valid
	} //while
}
void search_route(char *topo[En], int edge_num, char *demand)
{
	int i, j;
//////////////// common settings begin //////////////////
	char delim[3] = ",|";
	char *p;
	j = 0;
	demands[j++] = atoi(strtok(demand, delim));
	while ((p = strtok(NULL, delim)))
		demands[j++] = atoi(p);
	num_of_demand = j;
	num_of_edge = edge_num;
	for (i = 0; i < 600; i++)
		for (j = 0; j < 8; j++)
		{
			adjacent[i][j] = Pn;
			adj_res[i][j] = En;
		}
	for (i = 0; i < 52; i++)
		for (j = 0; j < MM; j++)
		{
			djaccent[i][j] = Pn;
			dj_res[i][j] = En;
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
		adj_res[x][adjindex[x]] = i;
		adjindex[topo_int[i][1]]++;
	}
	num_of_points++;
	printf("\n--num_of_points--->%d\n", num_of_points);
	tepresult[0] = 1000000;
	for (i = 1; i < 600; i++)
	{
		tepresult[i] = -1;
	}
	dresult[0] = 1000000;
	for (i = 1; i < 60; i++)
	{
		dresult[i] = -1;
	}
//////////////// common settings end //////////////////
	search_route3(topo_int, 0);
	for (i = 2; i < num_of_demand; i++)
	{
		search_route3(topo_int, i);
		printf("\n-------analyse ---%d/%d---- finished--------\n", i + 1,
				num_of_demand);
	}

	search_route1(num_of_demand);
//////////////////   The Ending   ////////////////////
	int tep = dresult[0];
	if (tep >= 1000000)
	{
		printf("\n-----no valid solution-----\n");
		return;
	}
	printf("\n---- minimum weight is %d ----\n", tep);
	for (i = 0; i < num_of_demand - 1; i++)
	{
		for (j = 1; j < 610; j++)
		{
			tep = topo_d[dresult[i + 1]][j];
			if (tep < 0)
				break;
			record_result(tep);
		}
	}
//	tep = tepresult[0];
//	if (tep >= 1000000)
//	{
//		printf("\n-----no valid solution-----\n");
//		return;
//	}
//	printf("\n---- minimum weight is %d ----\n", tep);
//	for (i = 1; i < num_of_points; i++)
//	{
//		tep = tepresult[i];
//		if (tep < 0)
//			return;
//		record_result(tep);
////		printf("-%d-", tep);
//	}
//////////////////   The Ending   ////////////////////
}
