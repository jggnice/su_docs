package util;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import youdid.LogMain;

@SuppressWarnings("serial")
public class PrintFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private PrintJob p;
	private Graphics g;

	/**
	 * Create the frame.
	 */
	public PrintFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (null != LogMain.ofun
				&& (arg0.getSource() == LogMain.ofun.getInfoPanel()
						.getPrintButton())) {

			p = getToolkit().getPrintJob(this, "个人信息打印", null);

			try {
				g = p.getGraphics();
			} catch (Exception e) {
				return;// CUT EXCEPTION
			}

			g.translate(10, 10);// dx,dy
			LogMain.ofun.getInfoPanel().getPrintArea().print(g);
			g.dispose();
			p.end();
		}
		if (null != LogMain.kebiao
				&& arg0.getSource() == LogMain.kebiao.getPrintButton()) {
			p = getToolkit().getPrintJob(this, "我的课表", null);

			try {
				g = p.getGraphics();
			} catch (Exception e) {
				return;// CUT EXCEPTION
			}
			g.translate(10, 10);// dx,dy
			LogMain.kebiao.getPrintArea().printAll(g);
			g.dispose();
			p.end();
		}
		if (null != LogMain.listcourse
				&& arg0.getSource() == LogMain.listcourse.getPrintButton()) {
			p = getToolkit().getPrintJob(this, "我的选课", null);

			try {
				g = p.getGraphics();
			} catch (Exception e) {
				return;// CUT EXCEPTION
			}
			g.translate(10, 10);// dx,dy
			LogMain.listcourse.getPrintArea().printAll(g);
			g.dispose();
			p.end();
		}
		if (null != LogMain.mygrade
				&& arg0.getSource() == LogMain.mygrade.getPrintButton()) {
			p = getToolkit().getPrintJob(this, "我的成绩", null);

			try {
				g = p.getGraphics();
			} catch (Exception e) {
				return;// CUT EXCEPTION
			}
			g.translate(10, 10);// dx,dy
			LogMain.mygrade.getPrintArea().printAll(g);
			g.dispose();
			p.end();
		}
		if (null != LogMain.mystu
				&& arg0.getSource() == LogMain.mystu.getPrintButton()) {
			p = getToolkit().getPrintJob(this, "我的学生", null);

			try {
				g = p.getGraphics();
			} catch (Exception e) {
				return;// CUT EXCEPTION
			}
			g.translate(10, 10);// dx,dy
			LogMain.mystu.getPrintArea().printAll(g);
			g.dispose();
			p.end();
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrintFrame frame = new PrintFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
