package rt5_1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MyFivePanel extends JPanel
{
	/**
	 * Create the panel.
	 */
	public MyFivePanel()
	{
		restart(this);
	}

	/**
	 * 
	 */
	static int chess = 0;
	static ImageIcon[] ballImage = {
			new ImageIcon(MyFivePanel.class.getResource("image/ball.png")),
			new ImageIcon(MyFivePanel.class.getResource("image/black.png")),
			new ImageIcon(MyFivePanel.class.getResource("image/white.png"))};

	ActionHandler listener = new ActionHandler();
	// Playerdo
	public void playerdo(ActionEvent evnt)
	{
		Person p = (Person) evnt.getSource();
		if (!GameIsOver)
		{
			n = p.getLine();
			m = p.getColumn();
			// System.out.println("("+m+","+ n + ")");
			if (IsPlayerTurn)
			{
				while (ball[m][n].getIcontype() == freeBall)
				{
					ball[m][n].setIcontype(playerBall);
					ball[m][n].setIcon(ballImage[playerBall]);
					ball[mComputerLastBall][nComputerLastBall]
							.setBorderPainted(false);
					playerChessCount++;
					chess++;
					ball[m][n].setText("" + chess);
					ball[m][n].setHorizontalTextPosition(SwingConstants.CENTER);
					MessageToShow = Message_Baby_you_wait;
					checkIfTie();
					checkTableforPlayer();
					if (!GameIsOver)
					{
						checkIfWhoWins();
					}
					if (GameIsOver)
					{
						showGameOverInfomation();
					}
					if (!GameIsOver)
					{
						IsPlayerTurn = false;
						IsComputerTurn = true;
						repaint();
						computerdo();
					}
				}
			} else
			{
				return;
			}
		}

	}

	public void computerdo()
	{
		if (!GameIsOver)
			if (IsComputerTurn)
			{
				countPlayerGrades();
				countComputerGrades();
				if (GameJustStarted)
				{
					if (ball[(Boardsize - 1) / 2][(Boardsize - 1) / 2]
							.getIcontype() == freeBall)
					{
						m = (Boardsize - 1) / 2;
						n = m;
					} else
					{
						m = (Boardsize + 1) / 2;
						n = m;
					}
					GameJustStarted = false;
				} else
				{
					checkBestPosition();
				}
				TheMaxComputerGrade = 0;
				TheMaxPlayerGrade = 0;
				ball[m][n].setIcontype(computerBall);
				ball[m][n].setIcon(ballImage[computerBall]);
				ball[m][n].setBorderPainted(true);
				chess++;
				ball[m][n].setText("" + chess);
				ball[m][n].setHorizontalTextPosition(SwingConstants.CENTER);
				mComputerLastBall = m;
				nComputerLastBall = n;
				computerChessCount++;
				MessageToShow = Message_Baby_you_go;
				checkIfTie();
				checkTableforComputer();
				if (!GameIsOver)
				{
					checkIfWhoWins();
				}
				IsPlayerTurn = true;
				IsComputerTurn = false;
				repaint();

				if (GameIsOver)
				{
					showGameOverInfomation();

				}
			}
	}

	public void countPlayerGrades()
	{
		for (i = 0; i <= (Boardsize - 1); i++)
			// COUNT playerGrades
			for (j = 0; j <= (Boardsize - 1); j++)
			{
				playerGrades[i][j] = 0;
				if (ball[i][j].getIcontype() == freeBall)
					for (k = 0; k < numberofwinpaths; k++)
						if (ptable[i][j][k])
						{
							switch (win[0][k])
							{
								case 1 :
									playerGrades[i][j] += GradeRank[0];
									break;
								case 2 :
									playerGrades[i][j] += GradeRank[1];
									break;
								case 3 :
									playerGrades[i][j] += GradeRank[2];
									break;
								case 4 :
									playerGrades[i][j] += GradeRank[3];
									break;
							}
						}
			}
	}
	public void countComputerGrades()
	{
		for (i = 0; i <= (Boardsize - 1); i++)
			// COUNT computerGrades
			for (j = 0; j <= (Boardsize - 1); j++)
			{
				computerGrades[i][j] = 0;
				if (ball[i][j].getIcontype() == freeBall)
					for (k = 0; k < numberofwinpaths; k++)
						if (ctable[i][j][k])
						{
							switch (win[1][k])
							{
								case 1 :
									computerGrades[i][j] += GradeRank[0];
									break;
								case 2 :
									computerGrades[i][j] += GradeRank[1];
									break;
								case 3 :
									computerGrades[i][j] += GradeRank[2];
									break;
								case 4 :
									computerGrades[i][j] += GradeRank[3];
									break;
							}
						}
			}
	}

	public void checkBestPosition()
	{
		for (i = 0; i < Boardsize; i++)
			for (j = 0; j < Boardsize; j++)
				if (ball[i][j].getIcontype() == freeBall)
				{
					if (computerGrades[i][j] >= TheMaxComputerGrade)
					{
						TheMaxComputerGrade = computerGrades[i][j];
						mAttack = i;
						nAttack = j;
						// �Ե���������λ��
					}
					if (playerGrades[i][j] >= TheMaxPlayerGrade)
					{
						TheMaxPlayerGrade = playerGrades[i][j];
						mDefend = i;
						nDefend = j;
						// �����������λ��
					}
				}
		if (TheMaxPlayerGrade + 50 < TheMaxComputerGrade
				|| TheMaxPlayerGrade <= littleGrade
				|| TheMaxComputerGrade >= bigGrade)
		{
			m = mAttack;// �Ե���������λ��
			n = nAttack;// �Ե���������λ��
		} else
		{
			m = mDefend;// �����������λ��
			n = nDefend;// �����������λ��
		}
		// if (TheMaxPlayerGrade >= TheMaxComputerGrade && TheMaxPlayerGrade >
		// 100
		// && TheMaxComputerGrade < 4000)
		// {
		// m = mDefend;//�����������λ��
		// n = nDefend;//�����������λ��
		// } else
		// {
		// m = mAttack;//�Ե���������λ��
		// n = nAttack;//�Ե���������λ��
		// }
	}

	public static void checkIfTie()
	{
		if ((computerChessCount == Boardsize * Boardsize / 2)
				&& (playerChessCount == Boardsize * Boardsize / 2))
		{
			GameIsATie = true;
			GameIsOver = true;
			MessageToShow = Message_Baby_you_not_win;
		}
	}

	private void checkTableforPlayer()
	{
		for (i = 0; i < numberofwinpaths; i++)
		{
			/**
			 * ��(10*10) �� , ˫�� ֻ�� �� �� 192 ����� �л�ʤ
			 */
			/***
			 * ��� i ��� ���� ���(1��) and i ��� ���� ( 5�Ӵ��� )
			 * <p>
			 * ��ô�� �� i ������� (5�Ӵ���ĵط�)���(1 ��)
			 */
			if (ptable[m][n][i] && win[0][i] != impossible)
				win[0][i]++;
			/***
			 * ����� �� i ������� (5�Ӵ���ĵط�)���(5��)
			 * <p>
			 * ��ô ��ʤ
			 */
			/***
			 * ���(����)�� �� i ������� ���� ���(1��)
			 * <p>
			 * ���Ǳ�(���)����
			 * <p>
			 * ��ô (����)�� �� i ������� ���ٿ��� ���(1��)
			 * <p>
			 * ��ô (����)�� �� i ������� ���ٿ��� ���(5��)
			 */
			if (ctable[m][n][i])
			{
				ctable[m][n][i] = false;
				win[1][i] = impossible;
				// �� �� 1 ����� �в��ܻ�ʤ
			}
		}
	}
	private void checkTableforComputer()
	{
		for (i = 0; i < numberofwinpaths; i++)
		{
			if (ctable[m][n][i] && win[1][i] != impossible)
				win[1][i]++;
			if (ptable[m][n][i])
			{
				ptable[m][n][i] = false;
				win[0][i] = impossible;
			}
		}
	}

	public static int getxx(int th)
	{
		return (th - 400) / 2;
	}

	public static int getyy(int th)
	{
		return th - 400 - 5;
	}

	public static boolean MouseInTheBoard(int xMouse, int yMouse, int x, int y)
	{
		return xMouse > x && xMouse < (x + 400) && yMouse > y
				&& yMouse < (y + 400);
	}

	public static int getIndex(int Mouse, int x)
	{
		return (int) ((Mouse - x) / 40);
	}

	public static void soPlayerWins()
	{
		PlayerWinsTheGame = true;
		ComputerWinsTheGame = false;
		GameIsOver = true;
		MessageToShow = Message_Baby_you_good;
	}

	public static void soComputerWins()
	{
		ComputerWinsTheGame = true;
		PlayerWinsTheGame = false;
		GameIsOver = true;
		MessageToShow = Message_Baby_you_fool;
	}

	public static void showGameOverInfomation()
	{
		if (GameIsATie)
			JOptionPane
					.showConfirmDialog(null, "ƽ�֣�", "ȷ����Ϣ",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.INFORMATION_MESSAGE);
		else if (PlayerWinsTheGame)
			JOptionPane
					.showConfirmDialog(null, "��ϲ�㣡�����ˡ�", "ȷ����Ϣ",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.INFORMATION_MESSAGE);
		else if (ComputerWinsTheGame)
			JOptionPane
					.showConfirmDialog(null, "�����ˣ�", "ȷ����Ϣ",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.INFORMATION_MESSAGE);
	}

	public static void checkIfWhoWins()
	{
		for (i = 0; i <= 1; i++)
			for (j = 0; j < numberofwinpaths; j++)
			{
				if (win[i][j] == 5)
					if (i == 0)
					{
						soPlayerWins();
						break;
					} else
					{
						soComputerWins();
						break;
					}
				if (GameIsOver)
					break;
			}
	}

	public void restart(MyFivePanel myFivePanel)
	{
		myFivePanel.removeAll();
		myFivePanel.setLayout(new GridLayout(Boardsize, Boardsize, 0, 0));
		for (int i = 0; i < Boardsize; i++)
			for (int j = 0; j < Boardsize; j++)
			{
				ball[i][j] = new Person(freeBall, 0, 0, i, j);
				myFivePanel.add(ball[i][j]);
				ball[i][j].setIcon(ballImage[freeBall]);
				ball[i][j].setIcontype(freeBall);
				ball[i][j].addActionListener(myFivePanel.listener);
			}
		for (i = 0; i < Boardsize; i++)
			for (j = 0; j < Boardsize; j++)
			{
				playerGrades[i][j] = 0;
				computerGrades[i][j] = 0;
				ball[i][j].setIcontype(freeBall);
				ball[i][j].setIcon(ballImage[freeBall]);
				ball[i][j].setBorderPainted(false);
				ball[i][j].setText("");
			}
		count = 0;
		/**
		 * <b> ������Ļ����ϵ (1st,2nd)��ʾ (����ƫ����,����ƫ����)
		 * <p>
		 * �趨ˮƽ����Ļ�ʤλ�� ,���� 60 �� 5 ������
		 */
		for (i = 0; i <= Boardsize - 5; i++)

			for (j = 0; j < Boardsize; j++)
			{
				for (k = 0; k < 5; k++)
				{
					ptable[i + k][j + 0][count] = true;
					ctable[i + k][j + 0][count] = true;
					// ������չ
				}
				count++;
				// ÿ�� 5 ������ ռ�� 1 ��� count
			}

		/**
		 * <b> ������Ļ����ϵ (1st,2nd)��ʾ (����ƫ����,����ƫ����)
		 * <p>
		 * �趨��ֱ����Ļ�ʤλ�� ,���� 60 �� 5 ������
		 */
		for (i = 0; i < Boardsize; i++)
			// �趨��ֱ����Ļ�ʤλ��
			for (j = 0; j <= Boardsize - 5; j++)
			{
				for (k = 0; k < 5; k++)
				{
					ptable[i + 0][j + k][count] = true;
					ctable[i + 0][j + k][count] = true;
					// ������չ
				}
				count++;
				// ÿ�� 5 ������ ռ�� 1 ��� count
			}
		/**
		 * <b> ������Ļ����ϵ (1st,2nd)��ʾ (����ƫ����,����ƫ����)
		 * <p>
		 * �趨�Խ��߷���Ļ�ʤλ�� ,���� 36 �� 5 ������
		 */
		for (i = 0; i <= Boardsize - 5; i++)
			// �趨���Խ��߷���Ļ�ʤλ��
			for (j = 0; j <= Boardsize - 5; j++)
			{
				for (k = 0; k < 5; k++)
				{
					ptable[i + k][j + k][count] = true;
					ctable[i + k][j + k][count] = true;
					// ��������չ
				}
				count++;
				// ÿ�� 5 ������ ռ�� 1 ��� count
			}

		/**
		 * <b> ������Ļ����ϵ (1st,2nd)��ʾ (����ƫ����,����ƫ����)
		 * <p>
		 * �趨���Խ��߷���Ļ�ʤλ�� ,���� 36 �� 5 ������
		 */
		for (i = Boardsize - 1; i >= 5 - 1; i--)
			// �趨���Խ��߷���Ļ�ʤλ��
			for (j = 0; j <= Boardsize - 5; j++)
			{
				for (k = 0; k < 5; k++)
				{
					ptable[i - k][j + k][count] = true;
					ctable[i - k][j + k][count] = true;
					// ��������չ
				}
				count++;
				// ÿ�� 5 ������ ռ�� 1 ��� count
			}

		for (i = 0; i <= 1; i++)
			for (j = 0; j < numberofwinpaths; j++)
				win[i][j] = 0;
		IsComputerTurn = false;
		IsPlayerTurn = true;
		MessageToShow = Message_Baby_you_first;
		count = 0;
		computerChessCount = 0;
		playerChessCount = 0;
		GameJustStarted = true;
		GameIsOver = false;
		PlayerWinsTheGame = false;
		ComputerWinsTheGame = false;
		GameIsATie = false;
		mComputerLastBall = 0;
		nComputerLastBall = 0;
		chess = 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g)
	{
		switch (MessageToShow)
		{
			case 0 :
				FrameForFiveChess.frame.setMessageText("������ !");
				break;
			case 1 :
				FrameForFiveChess.frame.setMessageText("�ȴ�!");
				break;
			case 2 :
				FrameForFiveChess.frame.setMessageText("����ѽ.");
				break;
			case 3 :
				FrameForFiveChess.frame.setMessageText("��������");
				break;
			case 4 :
				FrameForFiveChess.frame.setMessageText("����ЦЦ!");
				break;
			case 5 :
				FrameForFiveChess.frame.setMessageText("ƽ ��!");
				break;
		}
		super.paintComponent(g);
	}

	private class ActionHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			playerdo(arg0);

		}
	}
	final AdvancedPanelForXXL advance = new AdvancedPanelForXXL();
	public void showTimerDialog()
	{
		advance.setOpaque(false);
		JDialog jd = new JOptionPane(advance).createDialog(null, "�߼��Ի���");
		jd.setResizable(true);
		jd.setLocationRelativeTo(this);
		jd.setSize(500, 295);
		jd.setResizable(false);
		jd.setVisible(true);
	}
	private static final long serialVersionUID = 1401912263260863727L;
	/**
	 * The Variable Declarations
	 * 
	 */
	private static int Boardsize = 10;
	Person[][] ball = new Person[Boardsize][Boardsize];
	/**
	 * @return the boardsize
	 */
	public static int getBoardsize()
	{
		return Boardsize;
	}

	/**
	 * @param boardsize
	 *            the boardsize to set
	 */
	public void setBoardsize(int boardsize)
	{
		if (boardsize >= 5 && boardsize <= 20)
		{
			Boardsize = boardsize;
			ball = new Person[Boardsize][Boardsize];
			numberofwinpaths = 2 * Boardsize * (Boardsize - 5 + 1) + 2
					* (Boardsize - 5 + 1) * (Boardsize - 5 + 1);
			ptable = new boolean[Boardsize][Boardsize][numberofwinpaths];
			ctable = new boolean[Boardsize][Boardsize][numberofwinpaths];
			playerGrades = new int[Boardsize][Boardsize];
			computerGrades = new int[Boardsize][Boardsize];
			win = new int[2][numberofwinpaths];
			restart(this);
		}
	}

	private static int numberofwinpaths = 2 * Boardsize * (Boardsize - 5 + 1)
			+ 2 * (Boardsize - 5 + 1) * (Boardsize - 5 + 1);
	private static final int impossible = 7;
	private int[] GradeRank = {5, 50, 100, 400};
	private int littleGrade = GradeRank[2];
	private int bigGrade = GradeRank[3];
	// POSITIONS
	private static boolean ptable[][][] = new boolean[Boardsize][Boardsize][numberofwinpaths];
	private static boolean ctable[][][] = new boolean[Boardsize][Boardsize][numberofwinpaths];
	// REMEMBER
	private static int playerGrades[][] = new int[Boardsize][Boardsize];
	private static int computerGrades[][] = new int[Boardsize][Boardsize];
	private static int TheMaxComputerGrade = 0, TheMaxPlayerGrade = 0;
	// WEIGHT
	private static int win[][] = new int[2][numberofwinpaths];
	private static int playerChessCount, computerChessCount;
	// COUNT CHESS
	private static boolean IsPlayerTurn, IsComputerTurn;
	private static boolean GameJustStarted = true, GameIsOver = false;
	private static boolean PlayerWinsTheGame, ComputerWinsTheGame, GameIsATie;
	private static int i, j, k;
	private static int count, mComputerLastBall = 0, nComputerLastBall = 0;
	private static int n, m;
	// Drop At Point(m,n)
	private static int mAttack, nAttack, mDefend, nDefend;
	private static int MessageToShow = 0;
	// STATE
	final static int Message_Baby_you_first = 0;
	final static int Message_Baby_you_wait = 1;
	final static int Message_Baby_you_go = 2;
	final static int Message_Baby_you_good = 3;
	final static int Message_Baby_you_fool = 4;
	final static int Message_Baby_you_not_win = 5;
	public static final int WIDTH = 560;
	public static final int HEIGHT = 520;
	public static final int OUT_OF_FRAME = 50;
	public static final int freeBall = 0;
	public static final int playerBall = 1;
	public static final int computerBall = 2;
	class Person extends JButton
	{

		/*
		 * (non-Javadoc)
		 * 
		 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
		 */
		@Override
		protected void paintComponent(Graphics arg)
		{

			super.paintComponent(arg);
			Graphics2D arg0 = (Graphics2D)arg;
			arg0.setStroke(new BasicStroke(1.0f));
			arg0.setColor(Color.BLACK);
			
			arg0.drawLine(0, getHeight() / 2, getWidth() / 2 - 12,
					getHeight() / 2);
			arg0.drawLine(getWidth(), getHeight() / 2, getWidth() / 2 + 12,
					getHeight() / 2);
			arg0.drawLine(getWidth() / 2, 0, getWidth() / 2,
					getHeight() / 2 - 12);
			arg0.drawLine(getWidth() / 2, getHeight(), getWidth() / 2,
					getHeight() / 2 + 12);
			arg0.setColor(Color.ORANGE);
		}
		Person(int icontype, int width, int height, int x, int y)
		{
			super();
			setFont(new Font("������κ", Font.PLAIN, 12));
			setBackground(new Color(44, 154, 44));
			setForeground(Color.ORANGE);
			this.setLine(y);
			this.setColumn(x);
			// this.setSize(width, height);
			setIcontype(icontype);
			// setIcon(ICONS.iconpp[icontype]);
			// addFocusListener(this);
			setBorder(BorderFactory.createLineBorder(Color.CYAN, 3));
			setBorderPainted(false);

		}
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
		public Person()
		{
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
		/**
		 * *********************************************
		 */
		private static final long serialVersionUID = 8787631154804311924L;
		int icontype;
		int line;
		int column;
	}
}
