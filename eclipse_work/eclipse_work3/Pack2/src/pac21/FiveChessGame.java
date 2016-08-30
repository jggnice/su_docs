package pac21;

/**
  ��Һã�����������ѧϰjava����Ȼ����֮ǰ���Ѿ�ѧϰ��һ���ˣ�����������������ѧ���ŷ�����ǰѧ��̫��ǳ�ˣ�����ѧ������Ҳ�ܲ��ã����ԣ�������������վ�����µ��������ϣ���ʼ���ҵ�javaѧϰ֮�ã�ϲ��java�����Ѻ���ѧϰjava������������һ��ǰ���ɡ��һἰʱ�İ��Լ�ѧ��һЩ�����ܽ�����������͵��Ŀ��кʹ��һ�����ġ�
 ����Make The Change��ʱ���ˣ�Everyone��Come On��
���ҵ�QQ��jiaziming1990@qq.com��Ը�⽻����ͬѧ���Լ�����)
  Java�еļ������򷽷���ð������ѡ�����򣬲�������Ϳ��������������ҵ�����ʼѧjavaʱ��һЩԴ���룬���׶����ó����������ң�ϣ���ԸսӴ�java�����ܹ�����������
  �ڴˣ�Ҳ�ʹ�ҹ���һ�£������Լ�������ѧϰ���󵨴��£�
*/

/**
  ����һ���򵥵���������Ϸ������ķ�����ȷʵû��ʲô��ֵ�����ǣ���ȴ������һЩjava�����������֪ʶ�������Ժ��ѧϰ�кܴ�İ��������һ�������ǿ����������ϣ���������д��һ��Դ�룬ִ��Ч�ʲ����ߣ������������²ο�(*^__^*) ��������
*/
import java.util.Scanner;
public class FiveChessGame{
	public static void main(String[] args){
		char[][] arr=new char[17][17];
		
		arr[0][0]=' ';
		//�������̣�����������forѭ����
		for(int i=1;i<11;i++){
			arr[0][i]=(char)('0'+(i-1));
			arr[i][0]=(char)('0'+(i-1));
		}
		for(int i=11;i<17;i++){
			arr[0][i]=(char)('a'+(i-11));
			arr[i][0]=(char)('a'+(i-11));
		}
		for(int i=1;i<17;i++){
			for(int j=1;j<17;j++){
				arr[i][j]='*';
			}
		}
		print(arr);
		for(;;){
			boolean flag=false;
			bFall(arr);
			flag=compareB(arr);
			if(flag) break;
			wFall(arr);
			flag=compareW(arr);
			if(flag) break;
		}
		
	}
	//��������bFall()��
	public static void bFall(char[][] arr){
		//����ǰ�������ж�ѡ�е�λ���ǲ����Ѿ���������
		System.out.println("�������ӣ�");
		Scanner sc=new Scanner(System.in);
		String in=sc.next();
		char c1=in.charAt(0);
		char c2=in.charAt(1);
		int hIndex=0;
		int sIndex=0;
		for(int i=1;i<arr.length;i++){
			for(int j=1;j<arr[i].length;j++){
				if(c1==arr[i][0]&&c2==arr[0][j]){
					hIndex=i;
					sIndex=j;
				}
			}
		}
		if(arr[hIndex][sIndex]!='*'){
			System.out.println("��ǰ��λ�����Ѿ��������ˣ�����������");
		}else{
			arr[hIndex][sIndex]='@';
			print(arr);
		}
	}
	//��������wFall();
	public static void wFall(char[][] arr){
		//����ǰ�������ж�ѡ�е�λ���ǲ����Ѿ���������
		System.out.println("�������ӣ�");
		Scanner sc=new Scanner(System.in);
		String in=sc.next();
		char c1=in.charAt(0);
		char c2=in.charAt(1);
			
		int hIndex=0;
		int sIndex=0;
		for(int i=1;i<arr.length;i++){
			for(int j=1;j<arr[i].length;j++){
				if(c1==arr[i][0]&&c2==arr[0][j]){
					hIndex=i;
					sIndex=j;
				}
			}
		}
		if(arr[hIndex][sIndex]!='*'){
			System.out.println("��ǰ��λ�����Ѿ��������ˣ�����������");
		}else{
			arr[hIndex][sIndex]='&';
			print(arr);
		}
	}
	//�����������
	public static int crossRight(char[][] arr,int i,int j,char c){
		int count=1;
		while(j+1<arr[i].length&&arr[i][++j]==c)
			count++;
		return count;
	}
	//�����������
	public static int verticalRight(char[][] arr,int i,int j,char c){
		int count=1;
		while(i+1<arr.length&&arr[++i][j]==c){
			count++;
		}
		return count;
	}
	//б���������
	public static int obliqueRight(char[][] arr,int i,int j,char c){
		int count=1;
		while(i+1<arr.length&&j<arr[i].length&&arr[++i][++j]==c){
			count++;
		}
		return count;
	}
	//��б���������
	public static int inverseRight(char[][] arr,int i,int j,char c){
		int count=1;
		while(i+1<arr.length&&j<arr[i].length&&arr[--i][++j]==c){
			count++;
		}
		return count;
	}
	//�ȽϺ���
	public static boolean compareB(char arr[][]){
		boolean b=false;
		//�ȽϺ��� 
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				if(arr[i][j]=='@'){
					int count=crossRight(arr,i,j,'@');
					if(count==5){ 
						b=true;
						print(arr);
						System.out.println("����Ӯ��");
					}
				}
			}
		}
		//�Ƚ����� 
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				if(arr[i][j]=='@'){
					int count=obliqueRight(arr,i,j,'@');
					if(count==5){ 
						b=true;
						print(arr);
						System.out.println("����Ӯ��");
					}
				}
			}
		}
		//�Ƚ�б�� 
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				if(arr[i][j]=='@'){
					int count=obliqueRight(arr,i,j,'@');
					if(count==5){ 
						b=true;
						print(arr);
						System.out.println("����Ӯ��");
					}
				}
			}
		}
		//�ȽϷ�б��
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				if(arr[i][j]=='@'){
					int count=inverseRight(arr,i,j,'@');
					if(count==5){ 
						b=true;
						print(arr);
						System.out.println("����Ӯ��");
					}
				}
			}
		}
		return b;
	} 
	//�Ƚϰ���
	public static boolean compareW(char arr[][]){
		boolean b=false;
		//�ȽϺ��� 
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				if(arr[i][j]=='&'){
					int count=crossRight(arr,i,j,'&');
					if(count==5){
						b=true;
						print(arr);
						System.out.println("����Ӯ��");
					}
					
				}
			}
		}
		//�Ƚ����� 
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				if(arr[i][j]=='&'){
					int count=obliqueRight(arr,i,j,'&');
					if(count==5){
						b=true;
						print(arr);
						System.out.println("����Ӯ��");
					}
				}
			}
		}
		//�Ƚ�б�� 
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				if(arr[i][j]=='&'){
					int count=obliqueRight(arr,i,j,'&');
					if(count==5){
						b=true;
						print(arr);
						System.out.println("����Ӯ��");
					}
				}
			}
		}
		//�ȽϷ�б��
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				if(arr[i][j]=='&'){
					int count=inverseRight(arr,i,j,'&');
					if(count==5){
						b=true;
						print(arr);
						System.out.println("����Ӯ��");
					}
				}
			}
		}
		return b;
	} 
	//��ӡ����
	public static void print(char[][] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}