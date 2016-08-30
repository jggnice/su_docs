package aixiaochu;


import javax.swing.*;

import resources.PIC;
public class mybutton extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8345221551288768343L;
	private int line = -1;
	private int column = -1;
	private int icontype = -1;
	final static ImageIcon[] icon = {
		new ImageIcon(PIC.redqq),
			new ImageIcon(PIC.greenqq),
			new ImageIcon(PIC.yellowqq),
			new ImageIcon(PIC.blueqq)
	};
	
	public mybutton(){
		
		
	}
	
	public mybutton(int i){
		setIcon(icon[i]);
	}
	public int getLine() {
		return line;
	}
	public void setLine(int line) {
		this.line = line;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public int getIcontype() {
		return icontype;
	}
	public void setIcontype(int icon) {
		this.icontype = icon;
	}
	public void setIcon(int icontype2) {
		setIcon(icon[icontype2]);
		
	}
	

}
