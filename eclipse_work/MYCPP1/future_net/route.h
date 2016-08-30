#include<stdio.h>
#define __DEBUG__
#ifdef __DEBUG__
#define DEBUG(format,...) printf(format, ##__VA_ARGS__)
#else
#define DEBUG(format,...)
#endif


#ifndef __ROUTE_H__
#define __ROUTE_H__

#define FOUR 4
#define TWO 2
#define NOVALE -1
#define Pn 666
#define En 30000
#define MM 6
// MM can not more than 8
#define NN 10
#define SCALE 7000
void search_route(char *graph[5000], int edge_num, char *condition);
int evaluate();
void initGroup();
int select();
#endif
