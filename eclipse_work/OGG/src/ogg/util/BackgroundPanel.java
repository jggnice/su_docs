package ogg.util;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import ogg.MP3DialogPanel;

public class BackgroundPanel extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5936106560174119880L;
	public static BufferedImage background;
	static
		{
		try
		{
			background = ImageIO.read(MP3DialogPanel.class
					.getResourceAsStream("up.png"));
		} catch (Exception exp)
		{
		}
	}
	/**
	 * Create the panel.
	 */
	public BackgroundPanel()
	{

	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	Image bg = background;
	@Override
	protected void paintComponent(Graphics arg0)
	{
		// TODO Auto-generated method stub
		super.paintComponent(arg0);
		arg0.drawImage(bg, 0, 0, null);
	}

}
