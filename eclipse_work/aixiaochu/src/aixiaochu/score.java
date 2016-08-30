package aixiaochu;



public class score {
	static int the_first;
	static int the_second;
	static int the_third;
	private int now;
	java.io.File file = new java.io.File("score.txt");
	public score(){
		the_first = 0;
		the_second = 0;
		the_third = 0;
		}
	public score(int now){
		this.now = now;
		if(now > the_first){
			the_third = the_second;
			the_second = the_first;
			the_first = now;
		}else if(now > the_second){
			the_third = the_second;
			the_second = now;
		}else if(now > the_third){
			the_third = now; 
		}
	}
	public int getNow() {
		return now;
	}
	
	public int refresh(int now){
		this.now = now;
		if(now > the_first){
			the_third = the_second;
			the_second = the_first;
			the_first = now;
			return 1;
		}else if(now > the_second){
			the_third = the_second;
			the_second = now;
			return 2;
		}else if(now > the_third){
			the_third = now;
			return 3;
		}
		return 4;
	}
	

}
