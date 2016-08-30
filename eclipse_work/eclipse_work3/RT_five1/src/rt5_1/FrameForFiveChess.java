package rt5_1;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class FrameForFiveChess extends JFrame
{
	/**
	 * Launch the application.
	 */
	static FrameForFiveChess frame;
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try
				{
					frame = new FrameForFiveChess();
					frame.setSize(521, 620);
					//frame.setResizable(false);
					frame.setVisible(true);
					
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameForFiveChess()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 447);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewgame = new JMenu("\u65B0\u6E38\u620F");
		menuBar.add(mnNewgame);
		
		JMenuItem mntmNewgame = new JMenuItem("NewGame");
		mntmNewgame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				CenterPanel.restart(CenterPanel);
			}
		});
		mnNewgame.add(mntmNewgame);
		
		JMenu mnBsize = new JMenu("\u68CB\u5C40\u5927\u5C0F");
		menuBar.add(mnBsize);
		
		JMenuItem mntmSizedialog = new JMenuItem("sizeDialog");
		mntmSizedialog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				CenterPanel.showTimerDialog();
			}
		});
		mnBsize.add(mntmSizedialog);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		CenterPanel = new MyFivePanel();
		contentPane.add(CenterPanel, BorderLayout.CENTER);
		
		JPanel NorthPanel = new JPanel();
		contentPane.add(NorthPanel, BorderLayout.NORTH);
		NorthPanel.setLayout(new BoxLayout(NorthPanel, BoxLayout.X_AXIS));
		
		JLabel lblComputer = new JLabel("Computer");
		lblComputer.setFont(new Font("华文新魏", Font.PLAIN, 18));
		lblComputer.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblComputer.setHorizontalAlignment(SwingConstants.LEFT);
		NorthPanel.add(lblComputer);
		
		JLabel lblComputer_1 = new JLabel("");
		lblComputer.setLabelFor(lblComputer_1);
		lblComputer_1.setIcon(new ImageIcon(FrameForFiveChess.class.getResource("/rt5_1/image/white.png")));
		lblComputer_1.setHorizontalAlignment(SwingConstants.LEFT);
		NorthPanel.add(lblComputer_1);
		
		JLabel lblPlayer = new JLabel("Player");
		lblPlayer.setFont(new Font("华文新魏", Font.PLAIN, 18));
		lblPlayer.setHorizontalAlignment(SwingConstants.LEFT);
		NorthPanel.add(lblPlayer);
		
		JLabel lblPlayer_1 = new JLabel("");
		lblPlayer_1.setIcon(new ImageIcon(FrameForFiveChess.class.getResource("/rt5_1/image/black.png")));
		lblPlayer_1.setHorizontalAlignment(SwingConstants.LEFT);
		NorthPanel.add(lblPlayer_1);
		
		JLabel lblMessage_1 = new JLabel("               ");
		NorthPanel.add(lblMessage_1);
		
		lblMessage = new JLabel("Message");
		lblMessage.setFont(new Font("华文新魏", Font.PLAIN, 18));
		NorthPanel.add(lblMessage);
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = -305232437872324696L;
	private JPanel contentPane;
	private MyFivePanel CenterPanel;
	/**
	 * @return the centerPanel
	 */
	public MyFivePanel getCenterPanel()
	{
		return CenterPanel;
	}


	private static JLabel lblMessage;
	public void setMessageText(String s)
	{
		lblMessage.setText(s);
	}
	

}
