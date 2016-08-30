package youdid;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class OurFrame extends JFrame {

	private static final long serialVersionUID = 513928383256621039L;

	/**
	 ***************** Launch the application***********
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OurFrame frame = new OurFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 ****************** Create the frame****************
	 */
	public OurFrame() {
		super("JWDBMS");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 1, 600, 670);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.LIGHT_GRAY);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		Available = true;
		/**
		 ***************** LOG Main Panel *****************
		 */
		logmain = new LogMain();
		tabbedPane.addTab("\u684C\u9762", null, logmain, null);
	}
	public LogMain logmain;	
	public static JTabbedPane tabbedPane;
	public static boolean Available;
}
