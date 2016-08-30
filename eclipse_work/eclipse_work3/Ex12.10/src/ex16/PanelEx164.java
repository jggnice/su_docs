package ex16;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class PanelEx164 extends JPanel {
	private JTextField txtNum;
	private JTextField txtNum_1;
	private JTextField txtRs;

	/**
	 * Create the panel.
	 */
	public PanelEx164() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel.add(panel_1);

		JLabel lblNum = new JLabel("num1");
		panel_1.add(lblNum);

		txtNum = new JTextField();
		txtNum.setText("0");
		panel_1.add(txtNum);
		txtNum.setColumns(10);

		JLabel lblNum_1 = new JLabel("num2");
		panel_1.add(lblNum_1);

		txtNum_1 = new JTextField();
		txtNum_1.setText("1");
		panel_1.add(txtNum_1);
		txtNum_1.setColumns(10);

		JLabel lblRs = new JLabel("rs");
		panel_1.add(lblRs);

		txtRs = new JTextField();
		panel_1.add(txtRs);
		txtRs.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel.add(panel_2);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAddAction(arg0);
			}
		});
		btnAdd.setMnemonic('A');
		panel_2.add(btnAdd);

		JButton btnSubtract = new JButton("Subtract");
		btnSubtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnSubtractAction(arg0);
			}
		});
		btnSubtract.setMnemonic('S');
		panel_2.add(btnSubtract);

		JButton btnMultiply = new JButton("Multiply");
		btnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnMultiplyAction(arg0);
			}
		});
		btnMultiply.setMnemonic('M');
		panel_2.add(btnMultiply);

		JButton btnDivide = new JButton("Divide");
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnDivideAction(arg0);
			}
		});
		btnDivide.setMnemonic('D');
		panel_2.add(btnDivide);

	}

	protected void btnAddAction(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String rs = null;
		try {
			double num1 = Double.parseDouble(txtNum.getText());
			double num2 = Double.parseDouble(txtNum_1.getText());
			double sum;
			sum = num1 + num2;
			rs = "" + sum;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "输入不合法!");
		} finally {
			txtRs.setText(rs);
		}

	}

	protected void btnSubtractAction(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String rs = null;
		try {
			double num1 = Double.parseDouble(txtNum.getText());
			double num2 = Double.parseDouble(txtNum_1.getText());
			double sum;
			sum = num1 - num2;
			rs = "" + sum;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "输入不合法!");
		} finally {
			txtRs.setText(rs);
		}

	}

	protected void btnMultiplyAction(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String rs = null;
		try {
			double num1 = Double.parseDouble(txtNum.getText());
			double num2 = Double.parseDouble(txtNum_1.getText());
			double sum;
			sum = num1 * num2;
			rs = "" + sum;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "输入不合法!");
		} finally {
			txtRs.setText(rs);
		}

	}

	protected void btnDivideAction(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String rs = null;
		try {
			double num1 = Double.parseDouble(txtNum.getText());
			double num2 = Double.parseDouble(txtNum_1.getText());
			double sum;
			sum = num1 / num2;
			rs = "" + sum;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "输入不合法!");
		} finally {
			txtRs.setText(rs);
		}

	}
}
