#include<stdio.h>

int main()
{
	int count = 0;
	int a[5];
	for(a[0] = 0;a[0]<10;a[0]++)
		for(a[1] = a[0];a[1]<10;a[1]++)
			for(a[2] = a[1];a[2]<10;a[2]++)
				for(a[3] = a[2];a[3]<10;a[3]++)
					for(a[4] = a[3];a[4]<10;a[4]++)
					{
						if(10==(a[0]+a[1]+a[2]+a[3]+a[4]))
						{
							printf("%d %d %d %d %d\n",a[0],a[1],a[2],a[3],a[4]);
							count++;
						}
					}
	printf("count = %d",count);
	return 0;
}