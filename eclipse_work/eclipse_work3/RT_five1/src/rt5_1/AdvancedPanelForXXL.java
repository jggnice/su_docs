package rt5_1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class AdvancedPanelForXXL extends JPanel
{
	public AdvancedPanelForXXL()
	{
		
		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel.add(tabbedPane, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("\u9636\u6570", null, panel_1, null);
		panel_1.setLayout(null);

		txtTimer = new JTextField();
		txtTimer.setBounds(99, 59, 66, 21);
		panel_1.add(txtTimer);
		txtTimer.setColumns(10);

		JLabel lblTimer = new JLabel("\u9636\u6570(5-20)");
		lblTimer.setBounds(10, 60, 99, 18);
		panel_1.add(lblTimer);

		final JLabel lblConsole = new JLabel("\u63D0\u793A :");
		lblConsole.setBounds(11, 89, 158, 28);
		panel_1.add(lblConsole);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				int time = 10;
				try
				{
					time = Integer.parseInt(txtTimer.getText());
					if (time < 5||time>20)
					{
						lblConsole.setText("设置失败 ! ");
						return;
					} else
						lblConsole.setText("设置成功 ! ");
				} catch (NumberFormatException exception)
				{
					lblConsole.setText("设置失败 ! ");
				}
				FrameForFiveChess.frame.getCenterPanel().setBoardsize(time);
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
