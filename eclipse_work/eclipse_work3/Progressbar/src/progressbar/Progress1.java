package progressbar;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Progress1 {
	static JProgressBar jpb = null;
	static JButton jb = null;

	public static void main(String args[]) {
		JFrame frm = new JFrame();
		Container contentPane = frm.getContentPane();
		jpb = new JProgressBar();
		jpb.setOrientation(JProgressBar.HORIZONTAL);
		jpb.setMaximum(100);
		jpb.setMinimum(0);
		jpb.setValue(0);
		jpb.setStringPainted(true);
		jpb.setPreferredSize(new Dimension(400, 50));
		contentPane.add(jpb, BorderLayout.CENTER);
		jb = new JButton("Start");
		jb.addActionListener(new Change());
		contentPane.add(jb, BorderLayout.SOUTH);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.pack();
		frm.setVisible(true);
	}

	static class Change implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new Thread(new Runnable() {
				public void run() {
					for (int i = 1; i < 51; i++) {
						try {
							Thread.sleep(100);
							jpb.setValue(2*i);
						} catch (InterruptedException ie) {
						}
					}
				}
			}).start();
		}
	}
}