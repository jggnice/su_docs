package ex11_2;

public class Test_ex11_2 
{
	public static void main(String[] args)
	{
		MyDate date = new MyDate();
		Person[] p = new Person[5];
		p[0] = new Person("唐僧","中国","10086","10086@qq.com");
		p[1] = new Student("孙悟空","中国","10086","10086@qq.com",Student.大三);
		p[2] = new Employee("猪八戒","中国","10086","10086@qq.com","金正楼310",54321.6,date);
		p[3] = new Faculty("沙僧","中国","10086","10086@qq.com","金正楼310",54321.6,date,"上午9:00到下午5:00","Professor");
		p[4] = new Staff("白龙马","中国","10086","10086@qq.com","金正楼310",54321.6,date,"主任");
		for(int ii=0;ii<5;ii++)
		{
		System.out.println(p[ii].toString());
		}
	}
}
