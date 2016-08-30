package xxl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.TimerTask;

import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;

import resources.PIC;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameForXXL extends JFrame
{
	JLabel logo = new JLabel();
	static FrameForXXL frame;
	static int limitoftime_in_second = 60;
	static java.util.Timer timerfortime = new java.util.Timer(true);
	static java.util.Timer timerforframe = new java.util.Timer(true);
	/**
	 * <b>Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try
				{
					frame = new FrameForXXL();
					frame.setVisible(true);
					MusicForXXL.playbgm();
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	public void restartGame()
	{
		setTime(60);
		setScore(0);
		xiaoxiao.setNewGame();
		MusicForXXL.playreadygo();
		timerfortime.cancel();
		timerfortime = new java.util.Timer(true);
		for (int i = limitoftime_in_second; i >= 0; i--)
			timerfortime.schedule(new TimeTask(i), (limitoftime_in_second - i) * 1000);
		timerfortime.schedule(new TimeIsUpTask(), (limitoftime_in_second) * 1000 - 500);
	}
	public void setScore(int score)
	{
		this.lblScore.setText(score + "");
	}
	public int getScore()
	{
		return Integer.parseInt(this.lblScore.getText());
	}
	public void setTime(int time)
	{
		this.lblTime.setText(time + "秒");
		mytime = time;
	}
	public int getTime()
	{
		return mytime;
	}
	int mytime = 60;
	class LogonTask extends TimerTask
	{
		int width;
		int height;

		public LogonTask(int width, int height)
		{
			super();
			this.width = width;
			this.height = height;

		}
		public void run()
		{
			setSize(width, height);
		}
	}
	class TimeTask extends TimerTask
	{
		int time;

		public TimeTask(int time)
		{
			super();
			this.time = time;

		}
		public void run()
		{
			setTime(time);
		}
	}
	class TimeIsUpTask extends TimerTask
	{
		int time;
		public void run()
		{
			MusicForXXL.playtimeisup();
		}
	}
	/**
	 * <b>Create the frame.
	 */
	public FrameForXXL()
	{
		System.out.println("******console log for XXL********");
		System.out.println("******这是消消乐的控制台输出********");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 0, 490, 490);
		contentPane = new JPanel();
		contentPane.setOpaque(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		xiaoxiao = new PanelForXXL();
		xiaoxiao.setOpaque(false);
		logo = new JLabel();
		logo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0)
			{
				if (arg0.getY() < 280)
				{
					for (int i = 0; i < 400; i++)
						timerforframe.schedule(new LogonTask(
								(int) (490 + 26f * i / 400.0f),
								(int) (490 + 230.0f * i / 400.0f)), i);
					timerforframe.schedule(new LogonTask(516, 720), 400);
					InitialGame();
				} else
				{
					MusicForXXL.musicswitch();
				}
			}
		});
		logo.setSize(490, 490);
		logo.setIcon(new ImageIcon(PIC.class
				.getResource("backgroundstart .png")));
		contentPane.add(logo);

		/*
		 * Toolkit tk = Toolkit.getDefaultToolkit(); Image image = new
		 * ImageIcon(PIC.mousepoint).getImage(); Cursor cursor =
		 * tk.createCustomCursor(image, new Point(10, 10), "norm");
		 * this.setCursor(cursor); // panel 也可以是其他组件
		 */}
	private static final long serialVersionUID = 9059115948870291404L;
	private JPanel contentPane;
	PanelForXXL xiaoxiao;
	private JLabel lblScore;
	private JLabel lblTime;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public void InitialGame()
	{
		/**
		 * *** 主程序
		 */
		// setBounds(600, 0, 516, 720);
		contentPane.remove(logo);
		contentPane.add(xiaoxiao);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JMenuBar menuBar = new JMenuBar();
		panel_1.add(menuBar);

		JMenu mnFun = new JMenu("\u8C03\u8BD5\u9009\u9879");
		menuBar.add(mnFun);

		JMenuItem mntmCheck = new JMenuItem("check");
		mntmCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				xiaoxiao.checkAll();
			}
		});
		mnFun.add(mntmCheck);

		JMenuItem mntmClear = new JMenuItem("clear");
		mntmClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				xiaoxiao.clearAll();
			}
		});
		mnFun.add(mntmClear);

		JMenuItem mntmDrop = new JMenuItem("drop");
		mntmDrop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				xiaoxiao.dropAll();
			}
		});
		mnFun.add(mntmDrop);

		JMenu mnNewgame = new JMenu("\u65B0\u6E38\u620F");
		menuBar.add(mnNewgame);

		JMenuItem mntmNewgame = new JMenuItem("NewGame");
		mntmNewgame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				xiaoxiao.setNewGame();
			}
		});
		mnNewgame.add(mntmNewgame);

		JMenuItem mntmRestart = new JMenuItem("Restart");
		mntmRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				restartGame();
			}
		});
		mnNewgame.add(mntmRestart);

		JMenu mnRank = new JMenu("\u96BE\u5EA6\u8BBE\u7F6E");
		menuBar.add(mnRank);

		JMenuItem mntmEasy = new JMenuItem("easy");
		mntmEasy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{

			}
		});
		mnRank.add(mntmEasy);

		JMenuItem mntmMedium = new JMenuItem("medium");
		mntmMedium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
			}
		});
		mnRank.add(mntmMedium);

		JMenuItem mntmHard = new JMenuItem("hard");
		mntmHard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
			}
		});
		mnRank.add(mntmHard);

		JMenu mnAboutmusic = new JMenu("\u58F0\u97F3\u8BBE\u7F6E");
		menuBar.add(mnAboutmusic);

		JRadioButtonMenuItem rdbtnmntmMusicOff = new JRadioButtonMenuItem(
				"Music Off");
		rdbtnmntmMusicOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				MusicForXXL.musicswitch();
			}
		});
		buttonGroup.add(rdbtnmntmMusicOff);
		mnAboutmusic.add(rdbtnmntmMusicOff);

		JRadioButtonMenuItem rdbtnmntmMusicOn = new JRadioButtonMenuItem(
				"Music On");
		rdbtnmntmMusicOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				MusicForXXL.musicswitch();
			}
		});
		buttonGroup.add(rdbtnmntmMusicOn);
		mnAboutmusic.add(rdbtnmntmMusicOn);

		JLabel label = new JLabel("         ");
		menuBar.add(label);

		JLabel lblScoret = new JLabel("Score : ");
		lblScoret.setForeground(Color.RED);
		lblScoret.setFont(new Font("华文新魏", Font.PLAIN, 25));
		menuBar.add(lblScoret);

		lblScore = new JLabel("0");
		lblScore.setFont(new Font("华文新魏", Font.PLAIN, 25));
		menuBar.add(lblScore);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(0, 3, 0, 0));

		JLabel lblLeftgif = new JLabel("");
		lblLeftgif.setHorizontalAlignment(SwingConstants.LEFT);
		lblLeftgif.setIcon(new ImageIcon(FrameForXXL.class
				.getResource("/resources/mianzai.gif")));
		panel_2.add(lblLeftgif);

		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));

		lblTime = new JLabel("60\u79D2");
		lblTime.setFont(new Font("华文新魏", Font.BOLD, 40));
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblTime);

		JLabel lblRightgif = new JLabel("");
		lblRightgif.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRightgif.setIcon(new ImageIcon(FrameForXXL.class
				.getResource("/resources/mianzai.gif")));
		panel_2.add(lblRightgif);
		restartGame();
	}
}
