package youdid_manager;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.JButton;

import dbsql.DBsql1;
import lei.NewUser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AddNewUser extends JPanel {
	private static final long serialVersionUID = 975903256456819395L;
	private JTextField txtUserid;
	private JTextField txtUsername;
	private JComboBox<String> cbUserType;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AddNewUser() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblAddnewuser = new JLabel("\u6DFB\u52A0\u5355\u4E2A\u7528\u6237");
		lblAddnewuser.setFont(new Font("宋体", Font.PLAIN, 14));
		lblAddnewuser.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblAddnewuser, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblUserid = new JLabel("填写学号或工号");
		panel_1.add(lblUserid);
		
		txtUserid = new JTextField();
		panel_1.add(txtUserid);
		txtUserid.setColumns(10);
		
		JLabel lblUsername = new JLabel("填写用户名字");
		panel_1.add(lblUsername);
		
		txtUsername = new JTextField();
		panel_1.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblUsertype = new JLabel("选择用户类别");
		panel_1.add(lblUsertype);		
		
		cbUserType = new JComboBox<String>();
		cbUserType.setModel(new DefaultComboBoxModel(new String[] {"学生", "教师", "教务员"}));
		panel_1.add(cbUserType);
		
		JButton btnSubmit = new JButton("Submit");		
		panel_1.add(btnSubmit);
		
		JLabel lblNotice = new JLabel("Notice");
		panel_1.add(lblNotice);
		//****************************************
		btnSubmit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				boolean result = false;
				
				{
					int ans = JOptionPane.showConfirmDialog(null, "确认添加？");
					if(ans == JOptionPane.YES_OPTION)
					 	result = add();
						if(!result)
						{
							lblNotice.setText("添加失败");
						}
						else
						{
							lblNotice.setText("添加成功");							
						}
				}						
			}
		});
		
	}
	public boolean add()
	{
		boolean s= false ;
		if("".equals(txtUserid.getText().trim())||"".equals(txtUsername.getText().trim()))
			{return false;}
		else			
		{
		int[] UserType = {0,1,2}; 
		NewUser reader = new NewUser();
		reader.setUserID(txtUserid.getText());
		reader.setName(txtUsername.getText());
		//reader.setUserType(Integer.parseInt((String) cbUserType.getSelectedItem()));
		reader.setUserType(UserType[cbUserType.getSelectedIndex()]);
		reader.setUserPassword(txtUserid.getText());
		reader.setSex("男");
		reader.setSpec("信息");
		DBsql1 sql1 = new DBsql1();
		s=sql1.addNewUser(reader);
		}
	return s;
	
	}

}
