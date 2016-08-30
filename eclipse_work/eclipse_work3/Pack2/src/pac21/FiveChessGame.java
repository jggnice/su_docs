package pac21;

/**
  大家好，我现在正在学习java，虽然在这之前我已经学习过一遍了，但是现在再重新来学，才发现以前学的太肤浅了，而且学的质量也很不好，所以，现在我又重新站在了新的起跑线上，开始了我的java学习之旅，喜欢java的朋友和想学习java的朋友来和我一起前进吧。我会及时的把自己学的一些东西总结出来，并传送到文库中和大家一起分享的。
 所以Make The Change的时候到了，Everyone，Come On！
（我的QQ号jiaziming1990@qq.com，愿意交流的同学可以加我呦)
  Java中的几种排序方法：冒泡排序，选择排序，插入排序和快速排序。下面是我当初开始学java时的一些源代码，简单易懂，拿出来分享给大家，希望对刚接触java的人能够有所帮助。
  在此，也和大家共勉一下：相信自己，用心学习，大胆创新！
*/

/**
  这是一个简单的五子棋游戏，在玩的方面它确实没有什么价值。但是，它却包含了一些java方面最基础的知识。对你以后的学习有很大的帮助，而且还可以增强你的自信心呦！以下是我写的一个源码，执行效率并不高，但可以做以下参考(*^__^*) 嘻嘻……
*/
import java.util.Scanner;
public class FiveChessGame{
	public static void main(String[] args){
		char[][] arr=new char[17][17];
		
		arr[0][0]=' ';
		//布置棋盘，运用了三个for循环；
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
	//黑棋落子bFall()；
	public static void bFall(char[][] arr){
		//落子前，首先判断选中的位置是不是已经有棋子了
		System.out.println("黑棋落子：");
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
			System.out.println("当前的位置上已经有棋子了，请重新输入");
		}else{
			arr[hIndex][sIndex]='@';
			print(arr);
		}
	}
	//白棋落子wFall();
	public static void wFall(char[][] arr){
		//落子前，首先判断选中的位置是不是已经有棋子了
		System.out.println("白棋落子：");
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
			System.out.println("当前的位置上已经有棋子了，请重新输入");
		}else{
			arr[hIndex][sIndex]='&';
			print(arr);
		}
	}
	//横向够五个棋子
	public static int crossRight(char[][] arr,int i,int j,char c){
		int count=1;
		while(j+1<arr[i].length&&arr[i][++j]==c)
			count++;
		return count;
	}
	//竖向够五个棋子
	public static int verticalRight(char[][] arr,int i,int j,char c){
		int count=1;
		while(i+1<arr.length&&arr[++i][j]==c){
			count++;
		}
		return count;
	}
	//斜向够五个棋子
	public static int obliqueRight(char[][] arr,int i,int j,char c){
		int count=1;
		while(i+1<arr.length&&j<arr[i].length&&arr[++i][++j]==c){
			count++;
		}
		return count;
	}
	//反斜向够五个棋子
	public static int inverseRight(char[][] arr,int i,int j,char c){
		int count=1;
		while(i+1<arr.length&&j<arr[i].length&&arr[--i][++j]==c){
			count++;
		}
		return count;
	}
	//比较黑棋
	public static boolean compareB(char arr[][]){
		boolean b=false;
		//比较横向 
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				if(arr[i][j]=='@'){
					int count=crossRight(arr,i,j,'@');
					if(count==5){ 
						b=true;
						print(arr);
						System.out.println("黑棋赢了");
					}
				}
			}
		}
		//比较竖向 
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				if(arr[i][j]=='@'){
					int count=obliqueRight(arr,i,j,'@');
					if(count==5){ 
						b=true;
						print(arr);
						System.out.println("黑棋赢了");
					}
				}
			}
		}
		//比较斜向 
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				if(arr[i][j]=='@'){
					int count=obliqueRight(arr,i,j,'@');
					if(count==5){ 
						b=true;
						print(arr);
						System.out.println("黑棋赢了");
					}
				}
			}
		}
		//比较反斜向
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				if(arr[i][j]=='@'){
					int count=inverseRight(arr,i,j,'@');
					if(count==5){ 
						b=true;
						print(arr);
						System.out.println("黑棋赢了");
					}
				}
			}
		}
		return b;
	} 
	//比较白棋
	public static boolean compareW(char arr[][]){
		boolean b=false;
		//比较横向 
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				if(arr[i][j]=='&'){
					int count=crossRight(arr,i,j,'&');
					if(count==5){
						b=true;
						print(arr);
						System.out.println("白棋赢了");
					}
					
				}
			}
		}
		//比较竖向 
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				if(arr[i][j]=='&'){
					int count=obliqueRight(arr,i,j,'&');
					if(count==5){
						b=true;
						print(arr);
						System.out.println("白棋赢了");
					}
				}
			}
		}
		//比较斜向 
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				if(arr[i][j]=='&'){
					int count=obliqueRight(arr,i,j,'&');
					if(count==5){
						b=true;
						print(arr);
						System.out.println("白棋赢了");
					}
				}
			}
		}
		//比较反斜向
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				if(arr[i][j]=='&'){
					int count=inverseRight(arr,i,j,'&');
					if(count==5){
						b=true;
						print(arr);
						System.out.println("白棋赢了");
					}
				}
			}
		}
		return b;
	} 
	//打印棋盘
	public static void print(char[][] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}