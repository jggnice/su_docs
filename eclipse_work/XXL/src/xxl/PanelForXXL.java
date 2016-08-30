package xxl;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import resources.PIC;
import xxl.util.AdvancedPanelForXXL;
import xxl.util.GameOverForXXL;
import xxl.util.MusicForXXL;
/**
 * 
 * @author <b>PanelForXXL
 *
 */

public class PanelForXXL extends JPanel
{
	Person tempPerson;
	Person lastperson = null;
	Person currentperson = null;
	boolean canCheck = true;
	boolean canBlow = false;
	boolean canClear = false;
	boolean canDrop = true;
	boolean canCancel = false;
	boolean started = false;
	boolean isEven = true;
	static boolean timerstarted = false;
	static int limitoftime_in_second = 60;
	/**
	 * @return the limitoftime_in_second
	 */
	public static int getLimitoftime_in_second()
	{
		return limitoftime_in_second;
	}
	/**
	 * @param limitoftime_in_second the limitoftime_in_second to set
	 */
	public static void setLimitoftime_in_second(int limitoftime_in_second)
	{
		PanelForXXL.limitoftime_in_second = limitoftime_in_second;
	}
	static int numberofanimals = 4;
	static java.util.Timer timer = new java.util.Timer(true);
	static java.util.Timer timerfordrop = new java.util.Timer(true);
	static java.util.Timer timerforcleartask = new java.util.Timer(true);
	MouseHandler listener1 = new MouseHandler();
	ButtonActionListener listener2 = new ButtonActionListener();

	class IconSwitchTask extends TimerTask
	{
		public void run()
		{
			switchIcon(currentperson, tempPerson);
			canCancel = true;
			lastperson = null;
			currentperson.setBorderPainted(false);
			tempPerson.setBorderPainted(false);
			if (currentperson.isAdjacentTo(tempPerson))
				MusicForXXL.playcancel();
		}
	}
	class CancelTask extends TimerTask
	{

		public void run()
		{
			if (canCancel)
			{

				timer.cancel();
				timerstarted = false;
				System.out.println("Timer Caneled");
				canCancel = false;

			}
		}

	}
	class CheckAndBlowAndClearTask extends TimerTask
	{

		public void run()
		{
			int size = checkAll();
			if (size > 0)
			{
				blowAll();
				MusicForXXL.playclear();
				// timer.schedule(new ClearTask(), 150);
				timer.schedule(new DropTask(), 100);
				FrameForXXL.frame.setScore(FrameForXXL.frame.getScore() + size);
				gover.getLblScore().setS("Your Score : "+FrameForXXL.frame.getScore());
			} else
			{
				timerstarted = false;
				currentperson.setBorderPainted(false);
				lastperson.setBorderPainted(false);
				tempPerson.setBorderPainted(false);
				System.out.println("Timer Caneled");
				lastperson = null;

			}

		}

	}
	class ClearSoundTask extends TimerTask
	{
		public void run()
		{
			MusicForXXL.playclear();
			// Applet.newAudioClip(MP3.class.getResource("clear.wav")).play();;
		}
	}
	class ClearTask extends TimerTask
	{

		public void run()
		{
			// if(canClear)
			{
				clearAll();
				System.out.println("cleared");
			}
		}

	}
	class DropTask extends TimerTask
	{
		int count = 0;
		public void run()
		{
			if (dropAll())
			{
				timer.schedule(new DropTask(), 300);

			} else
			{
				timer.schedule(new CheckAndBlowAndClearTask(), 0);
			}
		}
	}
	class ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
			if (timerstarted)
			{
				return;
			}
			currentperson = (Person) e.getSource();
			currentperson.setBorderPainted(true);
			if (lastperson == null)
			{
				lastperson = currentperson;
				return;
			}
			if (lastperson.equals(currentperson))
				return;
			if (!lastperson.isAdjacentTo(currentperson))
			{
				lastperson.setBorderPainted(false);
				lastperson = currentperson;				
				return;
			}
			timerstarted = true;
			switchIcon(currentperson, lastperson);			
			tempPerson = lastperson;
			lastperson = currentperson;

			System.out.println("Timer Started");

			if ((checkAll() == 0))
			{
				timerstarted = false;				
				System.out.println("Timer Caneled");
				lastperson = null;
				timer.schedule(new IconSwitchTask(), 200);
				return;
			} else
			{
				/**
				 * 第一次check > 0
				 */
				timer.schedule(new CheckAndBlowAndClearTask(), 0);
			}

		}
	}
	class MouseHandler extends MouseAdapter
	{
		@Override
		public void mouseEntered(MouseEvent arg0)
		{
			Person p = (Person) arg0.getSource();
			if (p.getIcontype() > 8)
				return;
			p.setIcon(ICONS.iconpp[p.getIcontype()]);
			// System.out.println("111");
			p.repaint();
		}
		@Override
		public void mouseExited(MouseEvent arg0)
		{
			Person p = (Person) arg0.getSource();
			p.setIcon(ICONS.iconss[p.getIcontype()]);
			// System.out.println("222");
			p.repaint();
		}
	}
	public void setNewGame()
	{
		int icontype;
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
			{
				icontype = (int) (Math.random() * numberofanimals);
				boxs[i][j].setIcontype(icontype);
				boxs[i][j].setIcon(ICONS.iconpp[icontype]);
			}
		while (checkAll() > 0)
		{
			clearAll(0);
			while (dropAll(0))
			{
				;
			}
		}
	}
	/**
	 * <b>Create the panel.
	 */
	public PanelForXXL()
	{
		setOpaque(false);
		setLayout(null);
		bottomButton.setSize(400, 400);
		bottomButton.setLocation(500-385, 490-315);
		add(bottomButton);
		bottomButton.setVisible(false);		
		bottomButton.setIcon(new ImageIcon(PIC.class.getResource("bggif.gif")));
		bottomButton.setOpaque(false);
		// bottomButton.setContentAreaFilled(false);
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
			{
				boxs[i][j] = new Person(
						(int) (Math.random() * numberofanimals), 49, 49, i, j);
				boxs[i][j].addMouseListener(listener1);
				boxs[i][j].addActionListener(listener2);
				add(boxs[i][j]);
				boxs[i][j].setOpaque(false);
				boxs[i][j].setContentAreaFilled(false);
				boxs[i][j].setLocation(i * 49, j * 49);
			}

		// Set<String> set = new HashSet<String>();
		// set.add("qq");
		// set.add("pp");
		// set.add("qq");
		// for (Iterator<String> it = set.iterator(); it.hasNext();)
		{
			// System.out.println(it.next());
		}
		// subRowString(0);
		// for (int i = 0; i < 10; i++)
		{
			// System.out.println(colString[i]);
		}

		while (checkAll() > 0)
		{
			clearAll(0);
			while (dropAll(0))
			{
				;
			}
		}

	}

	@Override
	protected void paintComponent(Graphics arg0)
	{
		super.paintComponent(arg0);

	}
	private static final long serialVersionUID = 9106785028497495727L;
	private Person[][] boxs = new Person[10][10];
	private String[] rowString = new String[10];
	private String[] colString = new String[10];
	public void setRowString()
	{
		for (int i = 0; i < 10; i++)
		{
			rowString[i] = boxs[0][i].toString();
		}
		for (int j = 1; j < 10; j++)
		{
			for (int i = 0; i < 10; i++)
			{
				rowString[i] = rowString[i].concat(boxs[j][i].toString());
			}
		}

	}
	final static String[] match3 = {"000", "111", "222", "333", "444", "555",
			"666", "777"};

	public void subRowString(int icontype)
	{
		for (int i = 0; i < 10; i++)
		{
			for (int j = 1; j < 10 - 1; j++)
			{
				if (rowString[i].regionMatches(j - 1, match3[icontype], 0, 3))
					;

			}

		}
	}
	public void setColString()
	{
		for (int i = 0; i < 10; i++)
		{
			colString[i] = boxs[i][0].toString();
		}
		for (int j = 1; j < 10; j++)
		{
			for (int i = 0; i < 10; i++)
			{
				colString[i] = colString[i].concat(boxs[i][j].toString());
			}
		}
	}
	public boolean checkBlow(Person button)
	{
		int j = button.getLine();
		int i = button.getColumn();
		boolean flag1 = false;
		boolean flag11 = false;
		boolean flag12 = false;
		boolean flag13 = false;
		boolean flag2 = false;
		boolean flag21 = false;
		boolean flag22 = false;
		boolean flag23 = false;
		int icontype = button.getIcontype();
		if (i > 1)
		{
			flag11 = (boxs[i - 1][j].getIcontype() == icontype && boxs[i - 2][j]
					.getIcontype() == icontype);
			if (flag11)
				return true;
		}
		if (i < 8)
		{
			flag13 = (boxs[i + 1][j].getIcontype() == icontype && boxs[i + 2][j]
					.getIcontype() == icontype);
			if (flag13)
				return true;
		}
		if (i > 0 && i < 9)
		{
			flag12 = (boxs[i - 1][j].getIcontype() == icontype && boxs[i + 1][j]
					.getIcontype() == icontype);
			if (flag12)
				return true;
		}
		flag1 = flag11 || flag13 || flag12;
		if (j > 1)
		{
			flag21 = (boxs[i][j - 1].getIcontype() == icontype && boxs[i][j - 2]
					.getIcontype() == icontype);
			if (flag21)
				return true;

		}
		if (j < 8)
		{
			flag23 = (boxs[i][j + 2].getIcontype() == icontype && boxs[i][j + 1]
					.getIcontype() == icontype);
			if (flag23)
				return true;

		}
		if (j > 0 && j < 9)
		{
			flag22 = (boxs[i][j - 1].getIcontype() == icontype && boxs[i][j + 1]
					.getIcontype() == icontype);
			if (flag22)
				return true;

		}
		flag2 = flag21 || flag23 || flag22;
		return flag2 || flag1;
	}

	Set<Person> set;
	/**
	 * <b>计算出可消除的个数
	 * 
	 * @return Size of Set
	 */
	public int checkAll()
	{
		set = new HashSet<Person>();
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
			{

				if (checkBlow(boxs[i][j]))
				{

					//boxs[i][j].setBorderPainted(true);
					set.add(boxs[i][j]);
					// 此处check过程不能有icon改动
					// 必须先存好,再来改动icon

				}
			}
		System.out.println("checkALL: " + set.size());
		return set.size();
	}
	public void blowAll()
	{

		/*
		 * try {
		 * 
		 * Thread.currentThread(); Thread.sleep(50); } catch (Exception e) { }
		 */
		// PanelForXXL.timerforcleartask.schedule(new ClearSoundTask(), 0);

		for (Iterator<Person> it = set.iterator(); it.hasNext();)
		{
			// 此过程icon改动
			Person p = it.next();
			// p.setBorderPainted(false);
			p.setIcontype(9);
			p.setIcon(new ImageIcon(PIC.class.getResource("bombqq.gif")));
		}
		// try
		{
			// Thread.currentThread();
			// Thread.sleep(1);
		}// catch (Exception e)
		{
		}
	}
	public void clearAll()
	{
		MusicForXXL.playclear();
		// Applet.newAudioClip(MP3.class.getResource("clear.wav")).play();
		for (Iterator<Person> it = set.iterator(); it.hasNext();)
		{
			// 此过程icon改动
			Person p = it.next();
			p.setBorderPainted(false);
			p.setIcontype(8);
			p.setIcon(ICONS.iconss[8]);
		}

	}
	public void clearAll(int notimer)
	{

		for (Iterator<Person> it = set.iterator(); it.hasNext();)
		{
			// 此过程icon改动
			Person p = it.next();
			p.setBorderPainted(false);
			p.setIcontype(8);
			p.setIcon(ICONS.iconss[8]);
		}
	}

	public boolean dropAll(int notimer)
	{
		boolean flag = false;
		for (int i = 0; i < 10; i++)
		{
			if (droponecolumn(i))
				flag = true;
		}
		System.out.println("can Drop ? : " + flag);
		return flag;
	}

	public boolean dropAll()
	{

		boolean flag = false;
		for (int i = 0; i < 10; i++)
		{
			if (droponecolumn4(i))
				flag = true;
		}
		System.out.println("can Drop ? : " + flag);
		return flag;
	}
	/**
	 * <b>这个掉落方法比较好
	 * 
	 * @param col
	 */
	public boolean candropAll()
	{

		boolean flag = false;
		for (int i = 0; i < 10; i++)

			System.out.println("can Drop ? : " + flag);
		return flag;
	}
	protected boolean droponecolumn(int col)
	{
		boolean flag = false;
		for (int j = 8; j >= 0; j--)
		{
			/**
			 * <b>下面顶层有空情况另外讨论
			 */
			if (boxs[col][j + 1].getIcontype() == ICONS.blackicon)
			{
				int icontype = boxs[col][j].getIcontype();
				Icon icon = boxs[col][j].getIcon();
				boxs[col][j + 1].setIcon(icon);
				boxs[col][j + 1].setIcontype(icontype);
				boxs[col][j].setIcon((ICONS.iconss[8]));
				boxs[col][j].setIcontype(8);
				flag = true;
			}

		}
		/**
		 * <b>下面是顶层有空的情况
		 */
		if (boxs[col][0].getIcontype() == ICONS.blackicon)
		{
			int icontype = (int) (Math.random() * numberofanimals);
			boxs[col][0].setIcontype(icontype);
			boxs[col][0].setIcon(ICONS.iconpp[icontype]);
			flag = true;
		}
		return flag;
	}
	/**
	 * <b>这个掉落方法是整体下落,可读性比较差
	 * 
	 * @param col
	 */
	public void droponecolumn1(int col)
	{

		for (int j = 8; j >= 0; j--)
		{
			if (boxs[col][j + 1].getIcontype() == ICONS.blackicon)
			{
				for (int k = j + 1; k > 0; k--)
				{
					int icontype = boxs[col][k - 1].getIcontype();
					boxs[col][k].setIcon(ICONS.iconpp[icontype]);
					boxs[col][k].setIcontype(icontype);
					if (k == 1)
					{
						icontype = (int) (Math.random() * numberofanimals);
						boxs[col][0].setIcontype(icontype);
						boxs[col][0].setIcon(ICONS.iconpp[icontype]);
					}

				}

				return;
			}
		}
		if (boxs[col][0].getIcontype() == ICONS.blackicon)
		{
			int icontype = (int) (Math.random() * numberofanimals);
			boxs[col][0].setIcontype(icontype);
			boxs[col][0].setIcon(ICONS.iconpp[icontype]);
		}
	}
	Person backupbox;
	protected boolean droponecolumn2(int col)
	{
		boolean flag = false;
		for (int j = 9; j >= 0; j--)
		{
			if (boxs[col][j].getIcontype() == ICONS.blackicon)
			{
				flag = true;
				backupbox = new Person((int) (Math.random() * numberofanimals),
						49, 49, col, 0);
				remove((boxs[col][j]));// 实际上还在
				repaint();

				for (int k = j; k >= 1; k--)
				{
					boxs[col][k] = boxs[col][k - 1];
					boxs[col][k].setLine(k);
				}
				boxs[col][0] = backupbox;
				add((boxs[col][0]));
				for (int k = j; k >= 0; k--)
				{
					boxs[col][k].setLocation(col * 49, k * 49);
				}
				repaint();
				return flag;

			}

		}
		return flag;
	}
	protected boolean droponecolumn3(int col)
	{
		boolean flag = false;
		for (int j = 9; j >= 0; j--)
		{
			if (boxs[col][j].getIcontype() == ICONS.bombicon)
			{
				flag = true;
				backupbox = new Person((int) (Math.random() * numberofanimals),
						49, 49, col, 0);
				remove((boxs[col][j]));// 实际上还在,只是不可见
				repaint();
				for (int k = j; k >= 1; k--)
				{
					boxs[col][k] = boxs[col][k - 1];// 指针改变
					boxs[col][k].setLine(k);
				}
				boxs[col][0] = backupbox;
				boxs[col][0].addMouseListener(listener1);
				boxs[col][0].addActionListener(listener2);
				add((boxs[col][0]));
				for (int k = j; k >= 0; k--)
				{
					boxs[col][k].setLocation(col * 49, k * 49 - 49);// 初始化下落位置
				}
				for (int ii = 0; ii < 49; ii++)
				{
					timerfordrop.schedule(new ButtonDropTask(col, j), 6 * ii);
				}
				// droponecolumn31(col, j);// 开始下落
				// droponecolumn31(col, j);// 开始下落
				repaint();
				return flag;

			}

		}
		return flag;
	}
	protected boolean droponecolumn4(int col)
	{
		boolean flag = false;
		for (int j = 9; j >= 0; j--)
		{
			if (boxs[col][j].getIcontype() == ICONS.bombicon)
			{
				flag = true;
				backupbox = boxs[col][j];// 回收
				for (int k = j; k >= 1; k--)
				{
					boxs[col][k] = boxs[col][k - 1];// 指针改变
					boxs[col][k].setLine(k);
				}
				int icontype = (int) (Math.random() * numberofanimals);
				boxs[col][0] = backupbox;
				boxs[col][0].setLine(0);
				boxs[col][0].setIcontype(icontype);
				boxs[col][0].setIcon(ICONS.iconpp[icontype]);
				boxs[col][0].setBorderPainted(false);
				for (int k = j; k >= 0; k--)
				{
					boxs[col][k].setLocation(col * 49, k * 49 - 49);// 初始化下落位置
				}
				for (int ii = 0; ii < 49; ii++)
				{
					timerfordrop.schedule(new ButtonDropTask(col, j), 6 * ii);
				}
				repaint();
				return flag;

			}

		}
		return flag;
	}
	class ButtonDropTask extends TimerTask
	{
		int row;
		int col;
		public ButtonDropTask()
		{
			super();
		}
		public ButtonDropTask(int col, int row)
		{
			super();
			this.col = col;
			this.row = row;

		}
		public void run()
		{
			droponecolumn31(col, row);
		}
	}
	protected boolean droponecolumn31(int col, int row)
	{
		boolean flag = false;

		for (int k = row; k >= 0; k--)
		{
			boxs[col][k].setLocation(boxs[col][k].getX(),
					boxs[col][k].getY() + 1);// 位置改变
		}

		repaint();
		return flag;
	}
	JLabel bottomButton = new JLabel();
	public void switchIcon(Person p1, Person p2)
	{
		if (p1.isAdjacentTo(p2))
		{
			int tempicontype = p1.getIcontype();
			Icon tempicon = p1.getIcon();
			p1.setIcontype(p2.getIcontype());
			p1.setIcon(p2.getIcon());
			p2.setIcontype(tempicontype);
			p2.setIcon(tempicon);
		}
	}
	public void switchIcon(Person p1, Person p2, int withpause)
	{
		if (p1.isAdjacentTo(p2))
		{
			/*
			 * try { Thread.currentThread(); Thread.sleep(50); } catch
			 * (Exception e) { }
			 */
			int tempicontype = p1.getIcontype();
			Icon tempicon = p1.getIcon();
			p1.setIcontype(p2.getIcontype());
			p1.setIcon(p2.getIcon());
			p2.setIcontype(tempicontype);
			p2.setIcon(tempicon);
		}
	}
	public void showGameOverDialog()
	{
		
		gover.setOpaque(false);
		JDialog jd = new JOptionPane(gover).createDialog(null,"游戏结束对话框");
		jd.setResizable(true);
		jd.setLocationRelativeTo(this.bottomButton);
		jd.setSize(302,295);
		jd.setResizable(false);
		jd.setVisible(true);
	}	
	final GameOverForXXL gover = new GameOverForXXL();
	final AdvancedPanelForXXL advance = new AdvancedPanelForXXL(this);
	public void showTimerDialog()
	{		
		advance.setOpaque(false);
		JDialog jd = new JOptionPane(advance).createDialog(null,"高级对话框");
		jd.setResizable(true);
		jd.setLocationRelativeTo(this);
		jd.setSize(500,295);
		jd.setResizable(false);
		jd.setVisible(true);
	}

}

class Person extends JButton implements FocusListener
{
	public boolean isAdjacentTo(Person p)
	{
		if (this.equals(p))
			return false;
		if (1 >= (this.getLine() - p.getLine())
				* (this.getLine() - p.getLine())
				+ (this.getColumn() - p.getColumn())
				* (this.getColumn() - p.getColumn()))
			return true;
		return false;
	}
	Person(int icontype, int width, int height, int x, int y)
	{
		super();
		this.setLine(y);
		this.setColumn(x);
		this.setSize(width, height);
		setIcontype(icontype);
		setIcon(ICONS.iconpp[icontype]);
		// addFocusListener(this);
		setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
		setBorderPainted(false);

	}

	public Person()
	{
	}
	public boolean equals(Person p)
	{
		return (p.getLine() == this.getLine() && p.getColumn() == this
				.getColumn());

	}
	public int getIcontype()
	{
		return icontype;
	}
	public void setIcontype(int icontype)
	{
		this.icontype = icontype;
	}
	public String toString()
	{
		return "" + getIcontype();
	}
	public void focusGained(FocusEvent e)
	{
		if(!PanelForXXL.timerstarted)
		setBorderPainted(true);
	}
	public void focusLost(FocusEvent e)
	{
		setBorderPainted(false);
	}
	/**
	 * *********************************************
	 */
	private static final long serialVersionUID = 8787631154804311924L;
	int icontype;
	int line;
	int column;
	// Color c = new Color(255, 245, 170);
	public int getLine()
	{
		return line;
	}
	public void setLine(int line)
	{
		this.line = line;
	}
	public int getColumn()
	{
		return column;
	}
	public void setColumn(int column)
	{
		this.column = column;
	}
}

class ICONS
{
	final static int redicon = 0;
	final static int blueicon = 1;
	final static int brownicon = 2;

	final static int greenicon = 3;
	final static int greyicon = 4;
	final static int purpleicon = 5;
	final static int yellowicon = 6;
	final static int whiteicon = 7;

	final static int blackicon = 8;
	final static int bombicon = 9;
	final static BufferedImage[] icons = {PIC.redqq, PIC.blueqq, PIC.brownqq,
			PIC.greenqq, PIC.greyqq, PIC.purpleqq, PIC.yellowqq, PIC.whiteqq,
			PIC.blackqq, PIC.bombqq};

	final static ImageIcon[] iconss = {new ImageIcon(icons[0]),
			new ImageIcon(icons[1]), new ImageIcon(icons[2]),
			new ImageIcon(icons[3]), new ImageIcon(icons[4]),
			new ImageIcon(icons[5]), new ImageIcon(icons[6]),
			new ImageIcon(icons[7]), new ImageIcon(icons[8]),
			new ImageIcon(icons[9])};
	final static ImageIcon[] iconpp = {new ImageIcon(PIC.redpp),
			new ImageIcon(PIC.bluepp), new ImageIcon(PIC.brownpp),
			new ImageIcon(PIC.greenpp), new ImageIcon(PIC.greypp),
			new ImageIcon(PIC.purplepp), new ImageIcon(PIC.yellowpp),
			new ImageIcon(PIC.whitepp), new ImageIcon(PIC.blackpp)};
}