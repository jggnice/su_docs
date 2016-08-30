package pac0;

public class TestMyInteger 
{
	public static void main(String[] args)
	{
		MyInteger a1 = new MyInteger(12321);
		MyInteger a2 = new MyInteger(22);
		
		System.out.println("a1=12321 is even? "+a1.isEven());
		System.out.println("a1=12321 is odd? "+a1.isOdd());
		System.out.println("a1=12321 is Prime? "+a1.isPrime());
		System.out.println("13 is even? "+MyInteger.isEven(13));
		System.out.println("13 is odd? "+MyInteger.isOdd(13));
		System.out.println("13 is Prime? "+MyInteger.isPrime(13));
		System.out.println("a2=22 is even? "+MyInteger.isEven(a2));
		System.out.println("a2=22 is odd? "+MyInteger.isOdd(a2));
		System.out.println("a2=22 is Prime? "+MyInteger.isPrime(a2));
		System.out.println("a2 equals 13? "+a2.equals(13));
		System.out.println("a2 equals a1? "+a2.equals(a1));
		System.out.println("a2 = "+a2.getValues());
		
		System.out.println(MyInteger.parseInt(new String("13324")));
		System.out.println(MyInteger.parseInt(new char[]{'1','2','3','4'}));	
	}
}
