package main;

import java.math.*;

public class qiuni2
{
public static void printRN(Rational2[][] a)
{
		int row=a.length;
		int column=a[0].length;
		int i,j;
		System.out.print("\n");
		for(i=0;i<row;i++)
		{
			for(j=0;j<column;j++)
			{
				if(j==0)System.out.print("["+a[i][j]);
				else    System.out.print(a[i][j]);
			}
			System.out.print("]\n");
		}		
}
//*******************************block********************************************
public static void qiuni(int N)
{
	Rational2[][] a=new Rational2[N][N];
	Rational2[][] b=new Rational2[N][2*N];
	Rational2[][] c=new Rational2[N][N];
	Rational2 t1,t2;
	int i,j,m;
	//矩阵A的各元素存入二维数组a中。
	for(i=0;i<N;i++)
	for(j=0;j<N;j++)
	{a[i][j]=new Rational2(BigInteger.valueOf(1),BigInteger.valueOf(i+j+1));}

	//增广矩阵(A|E)存入二维数组b中
	for(i=0;i<N;i++)
	for(j=0; j<N;j++)
	b[i][j]=a[i][j];
for(i=0;i<N;i++)
for(j=N;j<2*N;j++)
{b[i][j]=new Rational2(BigInteger.valueOf(0),BigInteger.valueOf(1));}
for(i=0;i<N;i++)
{b[i][N+i]=new Rational2(BigInteger.valueOf(1),BigInteger.valueOf(1));}
//printRN(b);
//*******************************block********************************************
//对每行进行处理，目标为上三角矩阵
	for(m=0;m<N;m++)
{
//第m行不动
		for(i=m+1 ;i<N;i++)
		{
			for(j=2*N-1 ;j>=m;j--)
			{//b[i][j]=-b[i][m]*b[m][j]/b[m][m]+b[i][j];
			t1=(b[i][m]).RN_div(b[m][m]);
			t2=t1.RN_mul(b[m][j]);
			b[i][j]=(b[i][j]).RN_sub(t2);

			}
		}
//m=0 时,将第一行的-b[i][0]/b[0][0]倍加到以下各行。这样以下每行第一个元素b[i][0]就为0。
//*******************************block********************************************
//printRN(b);
		for(j=2*N-1 ;j>=m;j--)
		{//b[m][j]=b[m][j]/b[m][m];
			b[m][j]=b[m][j].RN_div(b[m][m]);
		}
//第m行归一,除以b[m][m],使b[m][m]为1。

}
//上三角矩阵完毕
//*******************************block********************************************


m=N-1;
//上三角矩阵变单位矩阵
while(m>0)
{
	for(i=0;i<m;i++)
	for(j=2*N-1;j>=m;j--)			//从后面计算。
	//b[i][j]=b[i][j]-b[i][m]*b[m][j];
	{b[i][j]=b[i][j].RN_sub(b[i][m].RN_mul(b[m][j]));}
	m--;

//printRN(b);
//最后一行消第一行、第二行…然后是倒数第二行消第一行、第二行…
}
//将逆矩阵存入二维数组c中。
	for(i=0;i<N;i++)
		for(j=0;j<N;j++)
			{c[i][j]=b[i][N+j];}
//打印
//	printfen(c,N);
printRN(c);
}

}