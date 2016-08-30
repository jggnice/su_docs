package pac1;


public class hi
{
    public static void main(String[] arg1)
    {
		System.out.println("***********************");
        System.out.println("** Welcome to java ! "+16);
		System.out.println("***********************");
		//char[] ch={'a','b','c','d'};
		//byte b = (byte) '\uFF44';
		int[] ch = new int[3];
		int[] ch4 = new int[4];
		ch[0] = 70;
		ch[1] = 4;
		ch[2] = 8;
		ch4[0] = (ch[0] >> 2);
		ch4[1] = (((ch[0] & 3) << 4) | (ch[1] >> 4));
		ch4[2] = (((ch[1] & 0xF) << 2) | (ch[2] >> 6));
		ch4[3] = (ch[2] & 63);
		System.out.println(ch4[0]);
		System.out.println(ch4[1]);
		System.out.println(ch4[2]);
		System.out.println(ch4[3]);
		System.out.println(0xf&0xff);
		 
    }
}
