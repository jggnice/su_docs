package com.b510.mp3.util;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class SimplePaint02 {

	private static final int LINE_THICKNESS = 4;
	private static final int LINE_GAP = 10;
	private Color lineColor = Color.red;

	public static void main(String[] args) {
		new SimplePaint02();
	}

	public SimplePaint02() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception ex) {
				}

				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLayout(new BorderLayout());
				frame.add(new TestPane());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

	public class TestPane extends JPanel {

		int radius = 75;

		@Override
		public Dimension getPreferredSize() {
			return new Dimension((int) (1.1 * radius), (int) (1.1 * radius));
		}

		@Override
		public void paintComponent(Graphics g) {

			BufferedImage buffer = new BufferedImage(radius * 2, radius * 2, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2d = buffer.createGraphics();

			RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			rh.put(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
			rh.put(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
			g2d.setRenderingHints(rh);

			Ellipse2D circle = new Ellipse2D.Float(0, 0, radius, radius);
			Shape clip = g2d.getClip();
			g2d.setClip(circle);
			AffineTransform at = g2d.getTransform();

			g2d.setTransform(AffineTransform.getRotateInstance(Math.toRadians(45), radius / 2, radius / 2));

			int gap = LINE_GAP;

			g2d.setColor(Color.WHITE);
			g2d.fill(circle);

			g2d.setColor(lineColor);
			// g2d.setStroke(new BasicStroke(LINE_THICKNESS));
			for (int index = 0; index < 10; index++) {
				int x1 = index * gap - (LINE_THICKNESS / 2);
				int y1 = 0;
				int x2 = index * gap + (LINE_THICKNESS / 2);
				int y2 = radius;
				int width = x2 - x1;
				int height = y2 - y1;

				g2d.fillRect(x1, y1, width, height);
				// g2d.drawLine(index * gap, 0, index * gap, getRadius());
			}

			g2d.setTransform(at);
			g2d.setClip(clip);
			g2d.setClip(null);
			g2d.setStroke(new BasicStroke(1.5f));
			g2d.draw(circle);
			g2d.dispose();
			g.drawImage(buffer, 0, 0, this);
		}
	}
}