package aixiaochu;



import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;


public class time extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6226649653929559019L;
	private int t = 0;
	String s = "***********" + t + "***********";
	public time(){
		
	}
	public time(int t){
		this.t = t;
		s = "**" + t + "**";
		setPreferredSize(new Dimension(200, 60));
		setFont(new Font("Serif", Font.BOLD, 30));
	}
	public int getT() {
		return t;
	}
	public void setT(int t) {
		this.t = t;
		s = "**" + t + "**";
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		FontMetrics fm = g.getFontMetrics();
		int stringwidth = fm.stringWidth(s);
		int stringAscent = fm.getAscent();
		int xCoordinate = getWidth() / 2 - stringwidth / 2;
		int yCoordinate = getHeight() / 2 - stringAscent / 2 + 20;
		g.drawString(s, xCoordinate, yCoordinate);
	}

}
