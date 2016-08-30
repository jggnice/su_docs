/**
 * 
 */
package com.b510.mp3.util;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

import com.b510.mp3.ui.Mp3UI;

/**
 * @author Hongten
 * @created Aug 1, 2014
 */
public class JProgressBarSample extends Mp3UI implements ActionListener {
	private static final long serialVersionUID = 1L;
	JButton updateButton;
	JButton finishButton;
	JProgressBar progressBarA;
	JProgressBar progressBarB;
	JProgressBar progressBarC;

	public JProgressBarSample(String title) {
		super(title);
		setTitle(title);
		setBounds(550, 400, 350, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		updateButton = new JButton("Update");
		finishButton = new JButton("Finish");
		updateButton.addActionListener(this);
		finishButton.addActionListener(this);
		finishButton.setEnabled(false);

		updateButton.setBounds(20, 20, 20, 20);

		progressBarA = new JProgressBar();
		progressBarA.setStringPainted(true);
		progressBarA.setIndeterminate(false);

		progressBarB = new JProgressBar();
		progressBarB.setStringPainted(true);
		progressBarB.setIndeterminate(false);

		progressBarC = new JProgressBar();
		progressBarC.setStringPainted(true);
		progressBarC.setIndeterminate(false);

		setLayout(new FlowLayout(2, 10, 10));
		getContentPane().add(updateButton);
		getContentPane().add(finishButton);

		getContentPane().add(progressBarA);
		getContentPane().add(progressBarB);
		getContentPane().add(progressBarC);
	}

	class Progress extends Thread {
		int[] progressValue = { 6, 18, 27, 39, 51, 66, 81, 100 };

		JProgressBar progressBarA;
		JProgressBar progressBarB;
		JProgressBar progressBarC;
		JButton jButton;

		public Progress(JProgressBar barA, JProgressBar barB, JProgressBar barC, JButton button) {
			this.progressBarA = barA;
			this.progressBarB = barB;
			this.progressBarC = barC;
			this.jButton = button;
		}

		public void run() {
			int valueA = 0;
			int valueB = 0;
			int valueC = 0;

			Random random = new Random();
			while (true) {
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
//				if (valueA <= 110) {
//					valueA += Math.abs(random.nextInt() % 10);
//					progressBarA.setValue(valueA);
//				}else{
//					valueA = 100;
//					progressBarA.setVisible(false);
//				}
//
//				if (valueB <= 110) {
//					valueB += Math.abs(random.nextInt() % 10);
//					progressBarB.setValue(valueB);
//				}else{
//					progressBarB.setVisible(false);
//					valueB =  100;
//				}
//				if (valueC <= 110) {
//					valueC += Math.abs(random.nextInt() % 10);
//					progressBarC.setValue(valueC);
//				}else{
//					valueC = 100;
//					progressBarC.setVisible(false);
//				}
//				if ((valueA + valueB + valueC) > 300) {
//					break;
//				}
				
				valueA = Math.abs(Math.abs(random.nextInt() % 10) * Math.abs(random.nextInt() % 10));
				progressBarA.setValue(valueA);
				progressBarA.setStringPainted(false);

				valueB = Math.abs(Math.abs(random.nextInt() % 10) * Math.abs(random.nextInt() % 10));
				progressBarB.setValue(valueB);

				valueC = Math.abs(Math.abs(random.nextInt() % 10) * Math.abs(random.nextInt() % 10));
				progressBarC.setValue(valueC);
				if ((valueA + valueB + valueC) == -2) {
					break;
				}
			}
			progressBarA.setIndeterminate(false);
			progressBarA.setString("Update complete.");
			
			progressBarB.setIndeterminate(false);
			progressBarB.setString("Update complete.");
			
			progressBarC.setIndeterminate(false);
			progressBarC.setString("Update complete.");
			jButton.setEnabled(true);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == updateButton) {
			new Progress(progressBarA, progressBarB, progressBarC, finishButton).start();
			updateButton.setEnabled(false);
			updateButton.setText("Updating...");
		} else if (e.getSource() == finishButton) {
			System.out.println("finish");
		}
	}

	public static void main(String[] args) {
		JProgressBarSample sample = new JProgressBarSample("Test JprogressBar");
		sample.setVisible(true);
		// Random random = new Random();
		// for (int i = 0; i < 10; i++) {
		// System.err.println(Math.abs(random.nextInt() % 10));
		// }
	}

}
