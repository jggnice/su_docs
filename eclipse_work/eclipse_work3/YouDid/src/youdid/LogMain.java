package youdid;

import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import jmfmusic.MusicPlay;
import lei.NewUser;
import util.PrintFrame;
import youdid_manager.AddMuchStudents;
import youdid_manager.AddNewUser;
import youdid_manager.StudentsTable;
import youdid_student.CourseListPanel;
import youdid_student.CourseTablePanel;
import youdid_student.MyGradeList2;
import youdid_teacher.MyStudents2;
import dbsql.DBsql1;

@SuppressWarnings("serial")
public class LogMain extends JPanel {
	
	private JTextField NametextField;
	private JPasswordField passwordField;
	static NewUser CurrentUser = null;
	private JLabel lblNotice = new JLabel("Notice:");
	PrintFrame frame1;
	public static UserInfo ofun;
	public static StudentsTable stu_table;
	public static CourseListPanel listcourse;
	public static CourseTablePanel kebiao;
	public static MyGradeList2 mygrade;
	public static MyStudents2 mystu;
	public static AddNewUser adduser;
	public static AddMuchStudents addmuchstudents;
	/**
	 * Create the panel.
	 */
	public LogMain() {
		setLayout(new BorderLayout(0, 0));		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.control);
		add(desktopPane, BorderLayout.CENTER);		
		JLabel lbUser = new JLabel("\u7528\u6237\u540D");
		lbUser.setIcon(new ImageIcon(LogMain.class.getResource("/images/userName.png")));
		lbUser.setBounds(14, 13, 72, 18);
		desktopPane.add(lbUser);		
		NametextField = new JTextField();
		lbUser.setLabelFor(NametextField);
		NametextField.setColumns(10);
		NametextField.setBounds(87, 10, 86, 24);
		desktopPane.add(NametextField);
		passwordField = new JPasswordField();
		passwordField.setBounds(87, 51, 86, 24);
		desktopPane.add(passwordField);		
		JLabel label_pass = new JLabel("\u5BC6\u7801");
		label_pass.setLabelFor(passwordField);
		label_pass.setIcon(new ImageIcon(LogMain.class.getResource("/images/password.png")));
		label_pass.setBounds(14, 54, 72, 18);
		desktopPane.add(label_pass);
		lblNotice.setIcon(new ImageIcon(LogMain.class.getResource("/images/me.png")));
		lblNotice.setBounds(58, 126, 343, 24);
		desktopPane.add(lblNotice);		
		JButton btnLogon = new JButton("logon");
		btnLogon.setIcon(new ImageIcon(LogMain.class.getResource("/images/login.png")));
		JButton btnLogOff = new JButton("log off");
		btnLogOff.setIcon(new ImageIcon(LogMain.class.getResource("/images/reset.png")));
		btnLogon.setBounds(58, 189, 115, 27);
		desktopPane.add(btnLogon);
		btnLogOff.setBounds(213, 190, 115, 25);
		desktopPane.add(btnLogOff);
		
	
		
		frame1 = new PrintFrame();
		frame1.setVisible(false);
		btnLogon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				login_Action();
			}
		});		
		btnLogOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				logout_Action();				
			}
		});
	

	}

	public void setNULL()
	{
		this.NametextField.setText(null);
		this.passwordField.setText(null);
	}
	/**
	 * @return the currentUser
	 */
	public static NewUser getCurrentUser() {
		return CurrentUser;
	}
	/**
	 * @param currentUser the currentUser to set
	 */
	public void setCurrentUser(NewUser currentUser) {
		CurrentUser = currentUser;
	}
	public void login_Action()
	{
		if(!OurFrame.Available)
		{
			lblNotice.setText("Notice : 请你先退出登陆  ");
			return;
		}
		String idnumber = NametextField.getText();
		NewUser TempUser;
		DBsql1 tepDBsql1 = new DBsql1();
		TempUser = tepDBsql1.selectNewUser(idnumber);				
		//first judge if the user exists	
		if(TempUser==null)
		{
			lblNotice.setText("Notice : 没有找到该用户 ");return;
		}
		//password
		@SuppressWarnings("deprecation")
		String password= passwordField.getText();			
		//if password is right
		
		if((OurFrame.Available)&&password.equals(TempUser.getUserPassword()))
		{
			setCurrentUser(TempUser);
			OurFrame.Available = false;
			lblNotice.setText("Notice : 成功登陆   "+TempUser.getName());
			
			/**
			 ***************** INFO Panel *****************
			 */
			ofun = new UserInfo();			
			ofun.getInfoPanel().setUser(getCurrentUser());
			ofun.getInfoPanel().RefreshInfo(getCurrentUser());
			ofun.getInfoPanel().getPrintButton().addActionListener(this.frame1);
			ofun.getInfoModify().setUser(getCurrentUser());
			ofun.getInfoModify().InitInfo(getCurrentUser());
			ofun.getInfoModify().setTxtEditAble(false);
			if(TempUser.getUserType()== 0)
			{
				/**
				 ***************** Course TablePanel *****************
				 */
				kebiao = new CourseTablePanel();
				kebiao.getPrintButton().addActionListener(this.frame1);
				
				/**
				 ***************** CourseList Panel *****************
				 */
				listcourse = new CourseListPanel();
				listcourse.getPrintButton().addActionListener(this.frame1);
				/**
				 ***************** myGradeList Panel *****************
				 */		
				mygrade = new MyGradeList2();
				mygrade.getPrintButton().addActionListener(this.frame1);
				OurFrame.tabbedPane.addTab("选课单", null, listcourse, null);
				OurFrame.tabbedPane.addTab("课表", null,kebiao, null);
				OurFrame.tabbedPane.addTab("成绩单", null,mygrade, null);
				listcourse.makeRefresh();
				kebiao.makeRefresh();
			}
			if(TempUser.getUserType()== 1)
			{
				/**
				 ***************** mystu Panel *****************
				 */
				mystu = new MyStudents2();
				mystu.getPrintButton().addActionListener(this.frame1);
				OurFrame.tabbedPane.addTab("我的学生", null, mystu, null);	
			}
			if(TempUser.getUserType()== 2)
			{
				/**
				 ***************** ADD USER Panel *****************
				 */	
				adduser = new AddNewUser();
				/**
				 ***************** ADD _STUDENTS Panel *****************
				 */	
				addmuchstudents = new AddMuchStudents();
				/**
				 ***************** UpdateINFO Panel *****************
				 */
				stu_table = new StudentsTable();
				OurFrame.tabbedPane.addTab("更新用户信息", null, stu_table, null);				
				OurFrame.tabbedPane.addTab("添加多个用户", null, addmuchstudents, null);
				OurFrame.tabbedPane.addTab("添加单个用户", null, adduser, null);				
			}			
			OurFrame.tabbedPane.addTab("修改本人信息", null, ofun, null);	
		}
		/**
		 * if password was wrong
		 */
		else
		{
			if(!OurFrame.Available)lblNotice.setText("Notice : 请你先退出登陆  ");
			else lblNotice.setText("Notice : 密码好像不对哦!");
		}
	}
	public void logout_Action()
	{
		setNULL();
		OurFrame.tabbedPane.remove(ofun);
		OurFrame.tabbedPane.remove(kebiao);
		OurFrame.tabbedPane.remove(listcourse);
		OurFrame.tabbedPane.remove(mygrade);
		OurFrame.tabbedPane.remove(adduser);
		OurFrame.tabbedPane.remove(addmuchstudents);
		OurFrame.tabbedPane.remove(stu_table);
		OurFrame.tabbedPane.remove(mystu);
		lblNotice.setText("Notice : 退出成功 !");
		OurFrame.Available = true;
	}
}
