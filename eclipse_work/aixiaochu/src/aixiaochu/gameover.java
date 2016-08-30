package aixiaochu;



import java.awt.Font;
import java.awt.Graphics;

import javax.swing.*;

import resources.PIC;

public class gameover extends JLabel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5203733820080052791L;

	
	ImageIcon gameover = new ImageIcon(PIC.gameover1);
	//ImageIcon gameover = new ImageIcon("Image/gameover1.png");
	private String s;
	public gameover(){
		setFont(new Font("serif", Font.BOLD, 30));
		setLocation(0, 0);
		setSize(100, 100);
		setLayout(null);
		setIcon(gameover);
	}
	public gameover(int score){
		this.s = "Your score:" + score;
		setFont(new Font("serif", Font.BOLD, 30));
		setLocation(0, 0);
		setSize(100, 100);
		setLayout(null);
		setIcon(gameover);
		
	}
	public String getS() {
		return s;
	}
	public void setS(int s) {
		this.s = "Your score:" + s;
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawString(s, 30, 50);
	}
}
