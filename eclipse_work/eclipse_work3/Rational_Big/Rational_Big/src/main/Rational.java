package main;


public class Rational extends Number implements Comparable<Object>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8889732776416678233L;
	//Data field
	private long fenzi=0;
	private long fenmu=1;
	//construct a rational
	public Rational(long fenzi,long fenmu)
	{
		long gcd=gcd(fenzi,fenmu);
		this.fenzi=(fenmu>0?1:-1)*fenzi/gcd;
		this.fenmu=Math.abs(fenmu)/gcd;
	}
	public Rational()
	{
		this(0,1);
	}
	//method of gcd
	private static long gcd(long n,long d)
	{
		long m1=Math.abs(n);
		long n1=Math.abs(d);
		if(m1*n1==0)n1=m1+n1;
		else 
		{
			long r=m1%n1;
			while(r!=0){m1=n1;n1=r;r=m1%n1;}
		}
		if(n1<0)n1=-n1;
		//n1是最大公约数；
		return n1;
	}
	//get
	public long getFenzi(){return fenzi;}
	public long getFenmu(){return fenmu;}
	//RN_add
	public Rational RN_add(Rational r1)
	{
		long n=fenzi*r1.getFenmu()+fenmu*r1.getFenzi();
		long d=fenmu*r1.getFenmu();
		return new Rational(n,d);
	}
	//RN_mul
	public Rational RN_mul(Rational r1)
	{
		long n=fenzi*r1.getFenzi();
		long d=fenmu*r1.getFenmu();
		return new Rational(n,d);
	}
	//RN_sub
	public Rational RN_sub(Rational r1)
	{
		long n=-r1.getFenzi();
		long d=r1.getFenmu();
		Rational r0=new Rational(n,d);
		return this.RN_add(r0);	
	}
	//RN_div
	public Rational RN_div(Rational r1)
	{
		long n=fenmu;
		long d=fenzi;
		Rational r0=new Rational(n,d);
		return r0.RN_mul(r1);	
	}
	//toString
	public String toString()
	{
		return fenzi+"/"+fenmu;
	}
	//equals method
	public boolean equals(Object o)
	{
		if(this.RN_sub((Rational)(o)).getFenzi()==0)
			return true;
		else return false;
	}
	//(datatype)Value
	public int intValue(){return (int)doubleValue();}
	public long longValue(){return (long)doubleValue();}
	public float floatValue(){return (float)doubleValue();}
	public double doubleValue(){return fenzi*1.0/fenmu;}
	//compareTo
	public int compareTo(Object o)
	{
		if(this.RN_sub((Rational)(o)).getFenzi()>0)
			return 1;
		else if(this.RN_sub((Rational)(o)).getFenzi()<0)
			return -1;
		else
			return 0;
	}
}