package util;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lei.NewUser;
import dbsql.DBsql1;

public abstract class InfoModify extends JPanel {	
	private static final long serialVersionUID = -6474392766292822177L;
	private JTextField txtUsername;
	private JTextField txtUserpassword;
	private JTextField txtUserspec;
	private JComboBox<String> cBoxSex;
	private JLabel lblNotice;
	private NewUser user;
	private JButton btnSubmit;
	
	/**
	 * ********* Methods****************
	 * 
	 */
	public NewUser getUser() {
		return user;
	}

	public void setUser(NewUser user) {
		this.user = user;
	}

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public InfoModify() 
	{
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblModifyinfo = new JLabel("\u4FE1\u606F\u7EF4\u62A4");
		panel_1.add(lblModifyinfo);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblUsername = new JLabel("\u59D3\u540D");
		panel_2.add(lblUsername);
		
		txtUsername = new JTextField();		
		panel_2.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblUsersex = new JLabel("\u6027\u522B");
		panel_2.add(lblUsersex);
		
		cBoxSex = new JComboBox<String>();
		cBoxSex.setModel(new DefaultComboBoxModel(new String[] {"男", "女"}));
		panel_2.add(cBoxSex);
		
		JLabel lblUserpassword = new JLabel("\u5BC6\u7801");
		panel_2.add(lblUserpassword);
		
		txtUserpassword = new JTextField();
		txtUserpassword.setText(null);
		panel_2.add(txtUserpassword);
		txtUserpassword.setColumns(10);
		
		JLabel lblUserspec = new JLabel("\u4E13\u4E1A");
		panel_2.add(lblUserspec);
		
		txtUserspec = new JTextField();
		panel_2.add(txtUserspec);
		txtUserspec.setColumns(10);
		
		btnSubmit = new JButton("\u63D0\u4EA4");		
		panel_2.add(btnSubmit);		
		lblNotice = new JLabel("notice");
		panel_2.add(lblNotice);
		btnSubmit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				ModifyAction(arg0);	
			}
		});
	
	}
	
	public JButton getSubmitButton()
	{
		return this.btnSubmit;
	}
	public void setTxtEditAble(boolean s)
	{
		this.txtUsername.setEditable(s);
		this.txtUserspec.setEditable(s);
		
	}
	public void DestroyAction()
	{
		this.txtUsername.setText(null);
		this.txtUserpassword.setText(null);
		this.txtUserspec.setText(null);
	}
	
	public void ModifyAction(ActionEvent arg0)
	{
		boolean result = false;
		{
			
			int ans = JOptionPane.showConfirmDialog(null,"确认修改？");
			if(ans == JOptionPane.YES_OPTION)
				if(user == null)
				{
					JOptionPane.showMessageDialog(null, "请先选择");
					return;
				}
			result = upadteInfo(user);
				if(!result)
				{
					lblNotice.setText("修改失败");
				}
				else
				{
					lblNotice.setText("修改成功");
					additional();
				}
		}
	}
	public abstract void additional();

	public void InitInfo(NewUser tep)
	{
		this.txtUsername.setText(tep.getName());
		this.cBoxSex.setSelectedItem(tep.getSex());
		this.txtUserspec.setText(tep.getSpec());
		this.txtUserpassword.setText(tep.getUserPassword());
		
	}

	/**
	 * @param tep
	 * @return
	 */
	public boolean upadteInfo(NewUser tep)
	{
		tep.setName(this.txtUsername.getText());
		tep.setSex((String) this.cBoxSex.getSelectedItem());
		tep.setSpec(this.txtUserspec.getText());
		tep.setUserPassword(this.txtUserpassword.getText());
		DBsql1 sql1 = new DBsql1();
		return sql1.updateSaveNewUser(tep);
	}

}
