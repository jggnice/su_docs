package ex173;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelEx173 extends JPanel
{
	static Color light = Color.BLACK;
	public void setredlight()
	{
		light = Color.RED;
		repaint();
	}
	public void setyellowlight()
	{
		light = Color.YELLOW;
		repaint();
	}
	public void setgreenlight()
	{
		light = Color.GREEN;
		repaint();
	}
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawRect(getWidth() / 2 - 40, 30, 80, getHeight() - 100);
		

		if (light == Color.RED)
		{
			g.setColor(light);
			g.fillOval(getWidth() / 2 - 40 + 5, 50, 50, 50);
			g.setColor(Color.BLACK);
		} else
		{g.drawOval(getWidth() / 2 - 40 + 5, 50, 50, 50);
		}

		if (light == Color.YELLOW)
		{
			g.setColor(light);
			g.fillOval(getWidth() / 2 - 40 + 5, 200, 50, 50);
			g.setColor(Color.BLACK);
		} else
		{	g.drawOval(getWidth() / 2 - 40 + 5, 200, 50, 50);
		}
		if (light == Color.GREEN)
		{
			g.setColor(light);
			g.fillOval(getWidth() / 2 - 40 + 5, 350, 50, 50);
			g.setColor(Color.BLACK);
		} else
		{
			g.drawOval(getWidth() / 2 - 40 + 5, 350, 50, 50);
		}
		
	}
}
