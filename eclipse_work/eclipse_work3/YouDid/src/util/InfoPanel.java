package util;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import lei.NewUser;
import dbsql.DBsql1;

@SuppressWarnings("serial")
public class InfoPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public InfoPanel() {
		setLayout(new BorderLayout(0, 0));		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));		
		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));		
		panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		
		btnRefresh = new JButton("点我刷新");		
		panel_2.add(btnRefresh);		
		Infobutton = new JButton("点我打印");
		panel_2.add(Infobutton);
		Infobutton.setFont(new Font("宋体", Font.PLAIN, 12));		
		textArea = new JTextArea(" ");
		panel_1.add(textArea, BorderLayout.CENTER);
		textArea.setEditable(false);
		btnRefresh.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				RefreshInfo(user);
			}
		});
	}
	public void RefreshInfo(NewUser TempUser)
	{
		
		DBsql1 tepDBsql1 = new DBsql1();
		try {
			textArea.setText(
					TempUser.toDescription()
					+"\nThe total number of user is = "
					+tepDBsql1.getTotal()
					+"\n");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void setNULL()
	{
		textArea.setText(null);
	}
	/**
	 * @return the user
	 */
	public NewUser getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(NewUser user) {
		this.user = user;
	}
	public JButton getPrintButton()
	{
		return this.Infobutton;
	}
	public JTextArea getPrintArea()
	{
		return this.textArea;
	}
	private JButton Infobutton;
	private JTextArea textArea;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton btnRefresh;
	private NewUser user;
}
