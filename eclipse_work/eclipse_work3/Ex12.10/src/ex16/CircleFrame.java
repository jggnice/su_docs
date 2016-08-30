package ex16;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class CircleFrame extends JFrame {
	private JButton jbtLeft = new JButton("Left");
	private JButton jbtRight = new JButton("Right");
	private JButton jbtUp = new JButton("Up");
	private JButton jbtDown = new JButton("Down");
	private CirclePanel canvas = new CirclePanel();

	public CircleFrame() {
		JPanel panel = new JPanel(); // Use the panel to group buttons
		panel.add(jbtLeft);
		panel.add(jbtRight);
		panel.add(jbtUp);
		panel.add(jbtDown);

		this.add(canvas, BorderLayout.CENTER); // Add canvas to center
		this.add(panel, BorderLayout.SOUTH); // Add buttons to the frame

		jbtLeft.addActionListener(new Listener());
		jbtRight.addActionListener(new Listener());
		jbtUp.addActionListener(new Listener());
		jbtDown.addActionListener(new Listener());
		setTitle("ControlCircle2");
		setLocationRelativeTo(null); // Center the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		setVisible(true);
	}

	class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//System.out.println(new java.util.Date(e.getWhen()));
			if (e.getSource() == jbtLeft)
				canvas.moveLeft();
			else if (e.getSource() == jbtRight)
				canvas.moveRight();
			else if (e.getSource() == jbtUp)
				canvas.moveUp();
			else if (e.getSource() == jbtDown)
				canvas.moveDown();
			
		}
	}

	class CirclePanel extends JPanel {
		private int radius = 5; // Default circle radius
		private int m = 20;
		private int n = 20;
		public CirclePanel()
		{
			System.out.println(m+", "+n);
			repaint();
		}
		/** Enlarge the circle */
		public void enlarge() {
			radius++;
			repaint();
		}

		public void moveLeft() {
			m -= 3;
			repaint();
		}

		public void moveRight() {
			m += 3;
			repaint();
		}

		public void moveUp() {
			n -= 3;
			repaint();
		}

		public void moveDown() {
			n += 3;
			repaint();
		}

		/** Enlarge the circle */
		public void shrink() {
			radius--;
			repaint();
		}

		/** Repaint the circle */
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawOval(m, n, 2 * radius, 2 * radius);
		}
	}
}
