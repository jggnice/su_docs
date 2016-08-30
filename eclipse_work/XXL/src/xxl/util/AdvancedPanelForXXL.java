package xxl.util;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import xxl.PanelForXXL;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdvancedPanelForXXL extends JPanel
{
	PanelForXXL dominace;
	/**
	 * @return the dominace
	 */
	public PanelForXXL getDominace()
	{
		return dominace;
	}
	/**
	 * @param dominace
	 *            the dominace to set
	 */
	public void setDominace(PanelForXXL dominace)
	{
		this.dominace = dominace;
	}
	/**
	 * Create the panel.
	 */
	public AdvancedPanelForXXL(PanelForXXL dominace)
	{
		setDominace(dominace);
		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel.add(tabbedPane, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Timer", null, panel_1, null);
		panel_1.setLayout(null);

		txtTimer = new JTextField();
		txtTimer.setBounds(99, 59, 66, 21);
		panel_1.add(txtTimer);
		txtTimer.setColumns(10);

		JLabel lblTimer = new JLabel("\u65F6\u95F4\u9650\u5B9A( \u79D2 )");
		lblTimer.setBounds(10, 60, 99, 18);
		panel_1.add(lblTimer);

		final JLabel lblConsole = new JLabel("\u63D0\u793A :");
		lblConsole.setBounds(11, 89, 158, 28);
		panel_1.add(lblConsole);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				int time = 60;
				try
				{
					time = Integer.parseInt(txtTimer.getText());
					if (time < 10)
					{
						lblConsole.setText("设置失败 ! ");
						return;
					} else
						lblConsole.setText("设置成功 ! ");
				} catch (NumberFormatException exception)
				{
					lblConsole.setText("设置失败 ! ");
				}
				PanelForXXL.setLimitoftime_in_second(time);;
			}
		});
		btnSubmit.setBounds(175, 58, 93, 23);
		panel_1.add(btnSubmit);

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2008886507631411725L;
	private JTextField txtTimer;
}
