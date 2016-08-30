package main;

import java.math.*;

public class TestRational2
{
	public static void main(String[] args)
	{
		Rational2 r1=new Rational2(new BigInteger("1"),new BigInteger("2"));
		Rational2 r2=new Rational2(new BigInteger("1"),new BigInteger("1"));
		Rational2 r3=new Rational2(new BigInteger("1"),new BigInteger("2"));
		System.out.println(r1+"+"+r2+"+"+r3+"="+r1.RN_add(r2).RN_add(r3));
		System.out.println(r1+"-"+ r2+"-"+ r3+"="+r1.RN_sub(r2).RN_sub(r3));
		System.out.println(r1+"*"+r2+"*"+ r3+"="+r1.RN_mul(r2).RN_mul(r3));
		System.out.println(r1+"/"+ r2+"="+r1.RN_div(r2));
	}
}