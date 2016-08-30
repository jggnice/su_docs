package lsw11;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class LSW11
{

	static int RandomNumber;
	final static int toRate[] = { -1, -1, -1, -1, -1, -1, -1, -5, +10, +10 };
	static double Bet = 0.1;
	static double Sum = 1.0;
	static int count = 1;
	static int countNegtive = 0;

	public static void main(String[] args) throws FileNotFoundException
	{
		java.io.File file1 = new java.io.File("ans.txt");
		PrintWriter into = new PrintWriter(file1);
		double[] ans = new double[4];
		into.printf("Count\tMax_his\tMin_his\tThe_end\n");
		fun2(ans, into);
	}

	public static void fun1(double[] args, PrintWriter into)
	{
		int jj = 0;
		args[0] = 1.0;
		args[1] = 1.0;
		args[2] = 1.0;
		Sum = 1.0;
		for (jj = 0; jj < 1000; jj++)
		{
			RandomNumber = (int) (Math.random() * 10);
			Sum = Sum + Bet * toRate[RandomNumber];
			if (Sum > args[0])
				args[0] = Sum;
			if (Sum < args[1])
				args[1] = Sum;
			if (Sum <= 0)
				{countNegtive ++; break;}
			// System.out.printf("\n%d\t%d\t%.2f",jj,RandomNumber,Sum);
		}
		System.out.printf("%.2f\t%.2f\n", args[0], args[1]);
		into.printf("%d\t%.2f\t%.2f\t%.2f\n", count++, args[0], args[1],Sum);
		args[2] = Sum;
	}

	public static void fun2(double[] args, PrintWriter into)
	{
		int ii = 0;
		args[0] = 1.0;
		args[1] = 1.0;
		args[2] = 1.0;
		args[3] = 1.0;
		double[] ans = new double[3];
		for (ii = 0; ii < 100; ii++)
		{
			fun1(ans, into);
			if (ans[0] > args[0])
				args[0] = ans[0];
			if (ans[1] < args[1])
				args[1] = ans[1];
			if(ans[2]>args[2])args[2] = ans[2];
			if(ans[2]<args[3])args[3] = ans[2];
		}
		System.out.printf("%.2f\t%.2f\n", args[0], args[1]);
		System.out.printf("Negtive Rate = %d/100",countNegtive);
		into.printf("ALL_in_history\t%.2f\t%.2f\n", args[0], args[1]);
		into.printf("ALL_in_the_end\t%.2f\t%.2f\n", args[2], args[3]);
		into.close();
	}
}
