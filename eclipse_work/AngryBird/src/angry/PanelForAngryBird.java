package angry;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import resources.PIC;

@SuppressWarnings("serial")
public class PanelForAngryBird extends JPanel
{
	final int numberofpoints = 1600;
	/**
	 * Create the panel.
	 */
	public PanelForAngryBird()
	{

		setLayout(null);
		add(bird);
		bird.setLocation(200, 200);
		bird.setSize(51, 49);
		bird.setFocusable(false);
		bird.setOpaque(false);
		bird.setIcon(new ImageIcon(PIC.birdqq));
		bird.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0)
			{
				releaseAction(arg0);
			}
		});
		bird.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0)
			{
				draggingAction(arg0);
			}
		});

	}
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawLine(p1.x, p1.y, getXx() + 25, getYy() + 25);
		g.drawLine(p2.x, p2.y, getXx() + 25, getYy() + 25);
		g.setColor(Color.RED);
		g.drawPolyline(xPoints, yPoints, numberofpoints/1);
		g.setColor(Color.BLACK);
	}
	protected void releaseAction(MouseEvent arg0)
	{
		for (int i = 0; i < numberofpoints; i++)
		{
			timer.schedule(new Move(i), (long) (i / 1000.0 * 3000.0));
		}
	}
	protected void draggingAction(MouseEvent arg0)
	{
		JLabel temp = (JLabel) arg0.getSource();
		int x1 = temp.getX();
		int y1 = temp.getY();
		int dx = arg0.getX();
		int dy = arg0.getY();
		// System.out.println(x1 + dx + " , " + (y1 + dy));
		bird.setLocation(x1 + dx, y1 + dy);
		setXx(bird.getX() - 25);
		setYy(bird.getY() - 25);
		bird.setLocation(bird.getX() - 25, bird.getY() - 25);
		repaint();
		length_in_x = -(bird.getX() - p3.getX()) - 25;// 向右偏移
		length_in_y = -(bird.getY() - p3.getY()) - 25;// 向下偏移
		// System.out.println("(向右,向下偏移): " + length_in_x + " , " +
		// length_in_y);
		// length_in_dig = Math.sqrt((length_in_x) * (length_in_x) +
		// (length_in_y)
		// * (length_in_y));
		// speed_in_dig = length_in_dig * speed_in_unit;
		speed_in_x = speed_in_unit * length_in_x;
		speed_in_y = speed_in_unit * length_in_y;
		/********************************************************/
		for (int i = 0; i < numberofpoints; i++)
		{
			double t = (i / 1000.0 * 3.0);
			int xi = (int) (speed_in_x * t);
			int yi = (int) ((speed_in_y * t + gravity * t * t / 2));
			xPoints[i] = getXx() + xi + 25;
			yPoints[i] = getYy() + yi + 25;
			curve[i] = new Point(getXx() + xi, getYy() + yi);
			// System.out.println(xi + " , " + yi);
		}
	}
	/**
	 * @return the xx
	 */
	public int getXx()
	{
		return xx;
	}
	/**
	 * @param xx
	 *            the xx to set
	 */
	public void setXx(int xx)
	{
		this.xx = xx;
	}
	/**
	 * @return the yy
	 */
	public int getYy()
	{
		return yy;
	}
	/**
	 * @param yy
	 *            the yy to set
	 */
	public void setYy(int yy)
	{
		this.yy = yy;
	}
	JLabel bird = new JLabel();
	private int xx = 200;
	private int yy = 200;
	Point p1 = new Point(304, 301);
	Point p2 = new Point(455, 296);
	Point p3 = new Point(380, 299);
	double gravity = 1000.0 / (3.0);//制动快慢
	double speed_in_unit = 1000.0 / (3.0 * 100.0);//(1000像素每3秒)每100像素
	double speed_in_x = 0;
	double speed_in_y = 0;
	double speed_in_dig = 0;
	double length_in_x = 0;
	double length_in_y = 0;
	double length_in_dig = 0;
	int[] xPoints = new int[numberofpoints];
	int[] yPoints = new int[numberofpoints];
	Point[] curve = new Point[numberofpoints];
	java.util.Timer timer = new java.util.Timer(true);
	class Move extends TimerTask
	{
		int cursor;

		public Move(int cursor)
		{
			super();
			this.cursor = cursor;
		}

		public void run()
		{
			bird.setLocation(curve[cursor]);
		}
	}
}
