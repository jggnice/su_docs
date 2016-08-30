package pac0;

public class MyInteger 
{
	private int values;

	public MyInteger(){}
	public MyInteger(int values)
	{
		this.setValues(values);
	}
	public boolean isEven()
	{
		return isEven(this.getValues());
	}
	public static boolean isEven(int a)
	{
		if(a%2 == 0) return true;
		else return false;
	}
	public static boolean isEven(MyInteger a)
	{
		return isEven(a.getValues());
	}
	public boolean isOdd()
	{
		return isOdd(this.getValues());
	}
	public static boolean isOdd(MyInteger a)
	{
		return isOdd(a.getValues());
	}
	public static boolean isOdd(int a)
	{
		if(a%2 == 1) return true;
		else return false;
	}
	public static boolean isPrime(MyInteger a)
	{		
		return isPrime(a.getValues());
	}
	public boolean isPrime()
	{		
		return isPrime(this.getValues());
	}
	public static boolean isPrime(int n)
	{
		
	int i;
	
	for(i=2;i<n;i++)
	{	
		if(n%i==0)break;
	}
		if(i==n)return true;
		else return false;
	}
	public boolean equals(int a)
	{
		return(a == this.values);
	}
	public boolean equals(MyInteger a)
	{
		return this.equals(a.getValues());
	}
	public static int parseInt(char[] str)
	{
		int sum = 0;int i = 0;
		for(i=0;i<str.length;i++)
		{
		sum = sum * 10 + (str[i]-'0');
		}
		return sum;
	}
	public static int parseInt(String str)
	{
		int sum = 0;int i;
		for(i=0;i<str.length();i++)
		{
		sum = sum * 10 + (str.charAt(i)-'0');
		}
		return sum;
	
	}
	/**
	 * @return the values
	 */
	public int getValues() {
		return values;
	}

	/**
	 * @param values the values to set
	 */
	public void setValues(int values) {
		this.values = values;
	}	
}
