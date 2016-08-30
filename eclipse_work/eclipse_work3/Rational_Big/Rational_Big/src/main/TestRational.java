package main;
public class TestRational
{
	public static void main(String[] args)
	{
		Rational r1=new Rational(1,3);
		Rational r2=new Rational(1,4);
		System.out.println(r1+"+"+r2+"="+r1.RN_add(r2));
		System.out.println(r1+"-"+r2+"="+r1.RN_sub(r2));
		System.out.println(r1+"*"+r2+"="+r1.RN_mul(r2));
		System.out.println(r1+"/"+r2+"="+r1.RN_div(r2));
	}
}