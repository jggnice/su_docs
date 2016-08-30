
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
public static void qiuni(int N)
{
	Rational2[][] a=new Rational2[N][N];
	Rational2[][] b=new Rational2[N][2*N];
	Rational2[][] c=new Rational2[N][N];
	Rational2 t1,t2;
	int i,j,m;
	//����A�ĸ�Ԫ�ش����ά����a�С�
	for(i=0;i<N;i++)
	for(j=0;j<N;j++)
	{a[i][j]=new Rational2(BigInteger.valueOf(1),BigInteger.valueOf(i+j+1));}

	//�������(A|E)�����ά����b��
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
//��ÿ�н��д���Ŀ��Ϊ�����Ǿ���
	for(m=0;m<N;m++)
{
//��m�в���
		for(i=m+1 ;i<N;i++)
		{
			for(j=2*N-1 ;j>=m;j--)
			{//b[i][j]=-b[i][m]*b[m][j]/b[m][m]+b[i][j];
			t1=(b[i][m]).RN_div(b[m][m]);
			t2=t1.RN_mul(b[m][j]);
			b[i][j]=(b[i][j]).RN_sub(t2);

			}
		}
//m=0 ʱ,����һ�е�-b[i][0]/b[0][0]���ӵ����¸��С���������ÿ�е�һ��Ԫ��b[i][0]��Ϊ0��
//*******************************block********************************************
//printRN(b);
		for(j=2*N-1 ;j>=m;j--)
		{//b[m][j]=b[m][j]/b[m][m];
			b[m][j]=b[m][j].RN_div(b[m][m]);
		}
//��m�й�һ,����b[m][m],ʹb[m][m]Ϊ1��

}
//�����Ǿ������
//*******************************block********************************************


m=N-1;
//�����Ǿ���䵥λ����
while(m>0)
{
	for(i=0;i<m;i++)
	for(j=2*N-1;j>=m;j--)			//�Ӻ�����㡣
	//b[i][j]=b[i][j]-b[i][m]*b[m][j];
	{b[i][j]=b[i][j].RN_sub(b[i][m].RN_mul(b[m][j]));}
	m--;

//printRN(b);
//���һ������һ�С��ڶ��С�Ȼ���ǵ����ڶ�������һ�С��ڶ��С�
}
//�����������ά����c�С�
	for(i=0;i<N;i++)
		for(j=0;j<N;j++)
			{c[i][j]=b[i][N+j];}
//��ӡ
//	printfen(c,N);
printRN(c);
}

}