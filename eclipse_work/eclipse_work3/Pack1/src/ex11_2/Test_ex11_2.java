package ex11_2;

public class Test_ex11_2 
{
	public static void main(String[] args)
	{
		MyDate date = new MyDate();
		Person[] p = new Person[5];
		p[0] = new Person("��ɮ","�й�","10086","10086@qq.com");
		p[1] = new Student("�����","�й�","10086","10086@qq.com",Student.����);
		p[2] = new Employee("��˽�","�й�","10086","10086@qq.com","����¥310",54321.6,date);
		p[3] = new Faculty("ɳɮ","�й�","10086","10086@qq.com","����¥310",54321.6,date,"����9:00������5:00","Professor");
		p[4] = new Staff("������","�й�","10086","10086@qq.com","����¥310",54321.6,date,"����");
		for(int ii=0;ii<5;ii++)
		{
		System.out.println(p[ii].toString());
		}
	}
}
