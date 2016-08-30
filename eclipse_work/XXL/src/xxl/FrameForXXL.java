package xxl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import ogg.MP3DialogPanel;
import resources.PIC;
import xxl.util.BackgroundPanel;
import xxl.util.MusicForXXL;

public class FrameForXXL extends JFrame
{
	Thread t1 = null;
	JPanel logo = new JPanel();
	static FrameForXXL frame;
	static java.util.Timer timerfortime = new java.util.Timer(true);
	static java.util.Timer timerforframe = new java.util.Timer(true);
	boolean GameIsOver = false;
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
					MP3DialogPanel.getPlayer().loopmusicswitch();
					MP3DialogPanel.getPlayer().setLoopinterval(30);
					frame = new FrameForXXL();
					frame.setVisible(true);

				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	public void restartGame()
	{
		GameIsOver = false;
		setTime(60);
		setScore(0);
		xiaoxiao.setNewGame();
		MusicForXXL.playreadygo();
		timerfortime.cancel();
		timerfortime = new java.util.Timer(true);
		for (int i = PanelForXXL.getLimitoftime_in_second(); i >= 0; i--)
			timerfortime.schedule(new TimeTask(i),
					(PanelForXXL.getLimitoftime_in_second() - i) * 1000);
		timerfortime.schedule(new TimeIsUpTask(),
				(PanelForXXL.getLimitoftime_in_second()) * 1000 + 100);
		for (int i = PanelForXXL.getLimitoftime_in_second() - 5; i < PanelForXXL.getLimitoftime_in_second(); i++)
			timerfortime.schedule(new AlarmTask(), i * 1000);
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
	class AlarmTask extends TimerTask
	{
		public void run()
		{
			MusicForXXL.playalarm();
		}
	}
	class TimeIsUpTask extends TimerTask
	{
		int time;
		public void run()
		{
			MusicForXXL.playtimeisup();
			GameIsOver = true;
			xiaoxiao.setVisible(false);
			xiaoxiao.showGameOverDialog();
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
		setBounds(600, 0, 516, 720);
		contentPane = new BackgroundPanel(PIC.background);
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		xiaoxiao = new PanelForXXL();
		xiaoxiao.setOpaque(false);
		/*
		 * logo = new JPanel(); contentPane.add(logo); logo.setOpaque(false);
		 * logo.setLayout(null);
		 *//**
		 * *** 主程序
		 */
		/*
		 * // setBounds(600, 0, 516, 720); contentPane.remove(logo);
		 */
		contentPane.add(xiaoxiao);

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JMenuBar menuBar = new JMenuBar();
		panel_1.add(menuBar);
		menuBar.setOpaque(false);

		JMenu mnNewgame = new JMenu("\u65B0\u6E38\u620F");
		menuBar.add(mnNewgame);

		JMenuItem mntmNewgame = new JMenuItem("FreshGame");
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
				xiaoxiao.setVisible(true);
			}
		});
		mnNewgame.add(mntmRestart);

		JMenu mnRank = new JMenu("\u96BE\u5EA6\u8BBE\u7F6E");
		menuBar.add(mnRank);

		JMenuItem mntmEasy = new JMenuItem("easy");
		mntmEasy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				xiaoxiao.bottomButton.setVisible(false);
				PanelForXXL.numberofanimals = 4;
				restartGame();
				xiaoxiao.setVisible(true);
			}
		});
		mnRank.add(mntmEasy);

		JMenuItem mntmMedium = new JMenuItem("medium");
		mntmMedium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				xiaoxiao.bottomButton.setVisible(false);
				PanelForXXL.numberofanimals = 6;
				restartGame();
				xiaoxiao.setVisible(true);
			}
		});
		mnRank.add(mntmMedium);

		JMenuItem mntmHard = new JMenuItem("hard");
		mntmHard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				xiaoxiao.bottomButton.setVisible(true);
				PanelForXXL.numberofanimals = 8;
				restartGame();
				xiaoxiao.setVisible(true);
			}
		});
		mnRank.add(mntmHard);

		JMenu mnAboutmusic = new JMenu("\u58F0\u97F3\u8BBE\u7F6E");
		menuBar.add(mnAboutmusic);

		JRadioButtonMenuItem rdbtnmntmChoose = new JRadioButtonMenuItem(
				"\u81EA\u5B9A\u4E49mp3");
		rdbtnmntmChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				MP3DialogPanel.getPlayer().showDialog();
			}
		});
		buttonGroup.add(rdbtnmntmChoose);
		mnAboutmusic.add(rdbtnmntmChoose);

		JCheckBoxMenuItem chckbxmntmMusicOff = new JCheckBoxMenuItem(
				"Music Off");
		chckbxmntmMusicOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					MusicForXXL.musicswitch();
				} catch (InterruptedException exception)
				{
					// TODO Auto-generated catch block
					exception.printStackTrace();
				}
			}
		});
		mnAboutmusic.add(chckbxmntmMusicOff);
		
		JMenu mnAdvance = new JMenu("\u9AD8\u7EA7\u8BBE\u7F6E");
		menuBar.add(mnAdvance);
		
		JMenuItem mntmTimer = new JMenuItem("Timer");
		mntmTimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				xiaoxiao.showTimerDialog();
			}
		});
		mnAdvance.add(mntmTimer);

		JLabel label = new JLabel("         ");
		menuBar.add(label);
		label.setOpaque(false);

		JLabel lblScoret = new JLabel("Score : ");
		lblScoret.setForeground(Color.RED);
		lblScoret.setFont(new Font("华文新魏", Font.PLAIN, 25));
		menuBar.add(lblScoret);
		lblScoret.setOpaque(false);

		lblScore = new JLabel("0");
		lblScore.setFont(new Font("华文新魏", Font.PLAIN, 25));
		menuBar.add(lblScore);
		lblScore.setOpaque(false);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(0, 3, 0, 0));
		panel_2.setOpaque(false);

		JLabel lblLeftgif = new JLabel("");
		lblLeftgif.setHorizontalAlignment(SwingConstants.LEFT);
		lblLeftgif.setIcon(new ImageIcon(FrameForXXL.class
				.getResource("/resources/mianzai.gif")));
		panel_2.add(lblLeftgif);
		lblLeftgif.setOpaque(false);

		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		panel_3.setOpaque(false);

		lblTime = new JLabel("60\u79D2");
		lblTime.setFont(new Font("华文新魏", Font.BOLD, 40));
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblTime);
		lblTime.setOpaque(false);

		JLabel lblRightgif = new JLabel("");
		lblRightgif.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRightgif.setIcon(new ImageIcon(FrameForXXL.class
				.getResource("/resources/mianzai.gif")));
		panel_2.add(lblRightgif);
		lblRightgif.setOpaque(false);
		restartGame();
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				InitialGame();
			}
		});
		btnStart.setIcon(new ImageIcon(FrameForXXL.class
				.getResource("/resources/labelstart.png")));
		btnStart.setBounds(156, 330, 150, 49);
		logo.add(btnStart);
		btnStart.setOpaque(false);
		btnStart.setContentAreaFilled(false);

		/*
		 * Toolkit tk = Toolkit.getDefaultToolkit(); Image image = new
		 * ImageIcon(PIC.mousepoint).getImage(); Cursor cursor =
		 * tk.createCustomCursor(image, new Point(10, 10), "norm");
		 * this.setCursor(cursor); // panel 也可以是其他组件
		 */}
	private static final long serialVersionUID = 9059115948870291404L;
	private BackgroundPanel contentPane;
	PanelForXXL xiaoxiao;
	private JLabel lblScore;
	private JLabel lblTime;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public void InitialGame()
	{
		/**
		 * *** 主程序// setBounds(600, 0, 516, 720);
		 */
	}
}
