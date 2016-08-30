package angry;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
import java.awt.BorderLayout;

public class BackgroundPanel extends JPanel
{
	Image bg;
	/**
	 * 
	 */
	private static final long serialVersionUID = 5936106560174119880L;

	/**
	 * Create the panel.
	 */
	public BackgroundPanel(){
		setLayout(new BorderLayout(0, 0));}
	public BackgroundPanel(Image bg)
	{
		super();
		this.bg = bg;
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	//Image bg = (PIC.background);
	@Override
	protected void paintComponent(Graphics arg0)
	{
		// TODO Auto-generated method stub
		super.paintComponent(arg0);
		arg0.drawImage(bg, 0, 0, null);
	}

}
