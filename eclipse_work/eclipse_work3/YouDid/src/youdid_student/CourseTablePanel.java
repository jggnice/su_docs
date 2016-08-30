package youdid_student;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import lei.Course;
import lei.Grade;
import util.ListTable;
import youdid.LogMain;
import dbsql.DBsqlAttendCourse;
import dbsql.DBsqlCourse;

@SuppressWarnings("serial")
public class CourseTablePanel extends JPanel{
	
	/**
	 * Create the panel.
	 */
	public CourseTablePanel() 
	{
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel table = new JPanel();
		panel.add(table, BorderLayout.CENTER);
		table.setLayout(new GridLayout(11, 7, 0, 0));
		
		freshPrint = new JPanel();
		panel.add(freshPrint, BorderLayout.NORTH);
		
		btnRefresh = new JButton("点我刷新");
		btnRefresh.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				setNULL();
				getMyCourse();
				
			}
		});
		freshPrint.add(btnRefresh);
		
		btnCourseprint = new JButton("点我打印");
		freshPrint.add(btnCourseprint);
		
		JScrollPane[][] webc = new JScrollPane[11][7];
		Font textfront = new Font("微软雅黑", Font.PLAIN, 8);
		web = new JTextArea[11][7];
		valid = new boolean[11][7];
		/* these are 77 addresses*/
		
		for(int ii=0;ii<11;ii++)
			for(int jj=0;jj<7;jj++)
				{web[ii][jj] = new JTextArea(""+(ii+1)+","+(jj+1));
				web[ii][jj].setFont(textfront);
				webc[ii][jj] = new JScrollPane();
				valid[ii][jj] = true;
				}
		
		for(int ii=0;ii<11;ii++)
			for(int jj=0;jj<7;jj++)
				{
				table.add(webc[ii][jj]);
				webc[ii][jj].setViewportView(web[ii][jj]);
				web[ii][jj].setEditable(false);
				}
		//INITIAL FINISH
		
	}
	public void makeRefresh()
	{
		setNULL();
		getMyCourse();
	}
	public void setNULL()
	{
		for(int ii=0;ii<11;ii++)
			for(int jj=0;jj<7;jj++)
				{web[ii][jj].setText(""+(ii+1)+","+(jj+1));				
				valid[ii][jj] = true;
				}
	}
	public boolean addCourse(Course course)
	{
		
		int[][] TimeTable = course.getWeekday();		
		for(int ii = 0;ii < TimeTable.length; ii++)
		{
			if(!valid[TimeTable[ii][1]-1][TimeTable[ii][0]-1])return false;
		}
		
		for(int ii = 0;ii < TimeTable.length; ii++)
		{
			web[TimeTable[ii][1]-1][TimeTable[ii][0]-1].setText(course.toString());
			valid[TimeTable[ii][1]-1][TimeTable[ii][0]-1] = false;
		}
		
		return true;
	}
	public void getMyCourse()
	{
		int totalAmount = ListTable.amount;
		//GET COURSE LIST
		DBsqlAttendCourse sql1 = new DBsqlAttendCourse();
		try {
			totalAmount = sql1.getTotal(LogMain.getCurrentUser().getUserID());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
		gradelist = sql1.showAttendList(totalAmount,1,LogMain.getCurrentUser().getUserID());
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//RETURN COURSE
		for(int ii=0; ii < gradelist.size();ii++)
		{
			Course course ;Grade grade ;
			DBsqlCourse sql2 = new DBsqlCourse();
			
			grade = gradelist.get(ii);
			try {
				course = sql2.selectCourse(grade.getCourseID());
				addCourse(course);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}		
		//ADD COURSE
		
	}
	public JButton getPrintButton()
	{
		return this.btnCourseprint;		
	}
	public JPanel getPrintArea()
	{
		return this.panel;
	}
	private JPanel panel;
	private JTextArea[][] web;
	private boolean[][] valid;
	private JPanel freshPrint;
	private JButton btnRefresh;
	private JButton btnCourseprint;
	private List<Grade> gradelist;
}
