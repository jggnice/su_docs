package xxl.util;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import resources.PIC;

import javax.swing.JLabel;

public class GameOverForXXL extends JPanel
{
	private GameLabel lblScore = new GameLabel("0");
	/**
	 * Create the panel.
	 */
	public GameOverForXXL()
	{
		setLayout(new BorderLayout(0, 0));
		BackgroundPanel panel = new BackgroundPanel(PIC.gameover1);
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(getLblScore(), BorderLayout.CENTER);

	}
	/**
	 * @return the lblScore
	 */
	public GameLabel getLblScore()
	{
		return lblScore;
	}
	/**
	 * @param lblScore the lblScore to set
	 */
	public void setLblScore(GameLabel lblScore)
	{
		this.lblScore = lblScore;
	}
	public class GameLabel extends JLabel
	{
		String s;
		/**
		 * @param s
		 *            the s to set
		 */
		public void setS(String s)
		{
			this.s = s;
			repaint();
		}

		public GameLabel(String s)
		{
			super();
			setS(s);
			setFont(new Font("serif", Font.BOLD, 30));
		}

		@Override
		protected void paintComponent(Graphics arg0)
		{
			// TODO Auto-generated method stub
			super.paintComponent(arg0);
			arg0.drawString(s, 20, 50);
		}

		/**
		 * 
		 */
		private static final long serialVersionUID = 3584047550740550433L;

	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -1392227469798263647L;

}
