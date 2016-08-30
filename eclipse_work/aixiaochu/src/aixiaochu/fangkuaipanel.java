package aixiaochu;



import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

class fangkuaipanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7915119575710100908L;
	private  mybutton[][] jbt = new mybutton[10][10];
	final static mybutton unpressedbutton = new mybutton(0);
	static mybutton thebuttonpressed = unpressedbutton;
	private int score = 0;
	public fangkuaipanel(){
		setLayout(new GridLayout(10, 10, 5, 5));
		ButtonListener listener = new ButtonListener();
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				int radom = (int)(Math.random() * 4);
				jbt[i][j] = new mybutton(radom);
				jbt[i][j].setLine(i);
				jbt[i][j].setColumn(j);
				jbt[i][j].setForeground(Color.BLACK);
				jbt[i][j].setBackground(Color.BLACK);
				jbt[i][j].setBorder(BorderFactory.createLineBorder(Color.CYAN, 3));
				jbt[i][j].setBorderPainted(false);
				add(jbt[i][j]);
				jbt[i][j].addActionListener(listener);
			}
		}
	
		while(checkall() > 0){
			change(checkall1(), checkall());
		}
		
	}
	public int getScore(){
	return score;
}


	public void setScore(int score) {
		this.score = score;
	}
	public boolean checkbutton(mybutton jbt1){
	int i = jbt1.getLine();
	int j = jbt1.getColumn();
	int ico = jbt1.getIcontype();
	if(i > 1 && jbt[i - 1][j].getIcontype() == ico && jbt[i - 2][j].getIcontype() == ico)
		return true;
	if(i > 0 && i < 9 && jbt[i - 1][j].getIcontype() == ico && jbt[i + 1][j].getIcontype() == ico)
		return true;
	if(i < 8 && jbt[i + 1][j].getIcontype() == ico && jbt[i + 2][j].getIcontype() == ico)
		return true;
	if(j > 1 && jbt[i][j - 2].getIcontype() == ico && jbt[i][j - 1].getIcontype() == ico)
		return true;
	if(j > 0 && j < 9 && jbt[i][j - 1].getIcontype() == ico && jbt[i][j + 1].getIcontype() == ico)
		return true;
	if(j < 8 && jbt[i][j + 1].getIcontype() == ico && jbt[i][j + 2].getIcontype() == ico)
		return true;
	return false;
}
	public int[] checkall1(){
	int[] location = new int[100];
	int number = 0;
	for(int i = 0; i < 10; i++){
		for(int j = 0; j < 10; j++){
			if(checkbutton(jbt[i][j])){
				location[number] = jbt[i][j].getLine() * 10 + jbt[i][j].getColumn();
				number++;
			}
		}
	}
	return location;
}
	public int checkall(){
	int[] location = new int[100];
	int number = 0;
	for(int i = 0; i < 100; i++)
		location[i] = -1;
	
	for(int i = 0; i < 10; i++){
		for(int j = 0; j < 10; j++){
			if(checkbutton(jbt[i][j])){
				location[number] = jbt[i][j].getLine() * 10 + jbt[i][j].getColumn();
				number++;
			}
		}
	}
	return number;
}
	public void change(int[] location, int number){
		for(int i = 0; i < number; i++){
			int c = location[i] % 10;
			int l = (location[i] - c) / 10;
			jbt[l][c].setIcontype((int)(Math.random() * 4));
			jbt[l][c].setIcon(mybutton.icon[jbt[l][c].getIcontype()]);		
		}
	
	}
	public void enable(boolean enable){
	for(int i = 0; i < 10; i++){
		for(int j = 0; j < 10; j++){
			jbt[i][j].setEnabled(enable);
		}
	}
}


	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			mybutton presswho;
			presswho = (mybutton) e.getSource();
			int l = Math.abs(presswho.getLine() - thebuttonpressed.getLine());
			int c = Math.abs(presswho.getColumn() - thebuttonpressed.getColumn());
			if(thebuttonpressed == unpressedbutton){
				thebuttonpressed = presswho;
				thebuttonpressed.setBorderPainted(true);
			}else if(l + c == 1){
				int temp = thebuttonpressed.getIcontype();
				thebuttonpressed.setBorderPainted(false);
				thebuttonpressed.setIcontype(presswho.getIcontype());
				thebuttonpressed.setIcon(thebuttonpressed.getIcontype());
				presswho.setIcontype(temp);
				presswho.setIcon(presswho.getIcontype());
				
				int mem = checkall();
				if(mem == 0){
					presswho.setIcontype(thebuttonpressed.getIcontype());
					presswho.setIcon(presswho.getIcontype());
					thebuttonpressed.setIcontype(temp);
					thebuttonpressed.setIcon(thebuttonpressed.getIcontype());
					thebuttonpressed = presswho;
					thebuttonpressed.setBorderPainted(true);
				}else{
					score += mem;
					thebuttonpressed = unpressedbutton;
					int[] location = checkall1();
					while(checkall() > 0){
						change(location, mem);
					}
				}
				
				}else{
					thebuttonpressed.setBorderPainted(false);
					thebuttonpressed = presswho;
					thebuttonpressed.setBorderPainted(true);
				}
		 
			 
		 }
	

}
}
