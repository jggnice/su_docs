package youdid_student;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import lei.Course;
import util.ListTable;
import youdid.LogMain;
import dbsql.DBsqlAttendCourse;
import dbsql.DBsqlCourse;

@SuppressWarnings("serial")
public class CourseListPanel extends ListTable {
	
	private JPanel RowsTable;	
	private List<Course> courselist;
	private JLabel[][] rowslabel;
	private JButton[] rowsbutton;
	private boolean[] state;
	
	public JPanel getPrintArea() {
		return RowsTable;
	}

	public CourseListPanel()	
	{
		RowsTable = new JPanel();
		RowsTable.setLayout(new GridLayout(amount, 0, 3, 0));
		
		int ii, jj;
		rowslabel = new JLabel[amount][2];
		rowsbutton = new JButton[amount];
		state = new boolean[amount];
		
		for(ii = 0;ii < amount; ii++)
		{
			rowsbutton[ii] = new JButton("选择/退选");
			
			for(jj = 0; jj< 2; jj++)
				rowslabel[ii][jj] = new JLabel("");
			
			RowsTable.add(rowslabel[ii][0]);
			RowsTable.add(rowsbutton[ii]);
			
			
			rowsbutton[ii].addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					for(int ii = 0;ii <amount ;ii ++)
					{
						if(arg0.getSource() == rowsbutton[ii])
							{							
							//CHANGE STATE
							if(state[ii])	delAttendCourse(ii);
							else 			addAttendCourse(ii);
							state[ii]=!state[ii];
							rowslabel[ii][1].setText(state[ii]?"__已经选了":"_还没有选");
							
							}
					}
					
				}
			});
			RowsTable.add(rowslabel[ii][1]);
		}
		addRowsTable(RowsTable);
		selectFisrtPage();
		
	}
	
	public void setNULL()
	{
		for(int ii = 0;ii <amount ;ii ++)
		{
			rowslabel[ii][0].setText(null);
			rowsbutton[ii].setText(null);
			rowslabel[ii][1].setText(null);			
		}
	}
	
	
	@Override
	public	void addtionalAction() {
		getStates();
		
	}
	@Override
	protected	void selectlist(int a, int b) {
		//ADD LIST TO PANEL
		DBsqlCourse sql1 = new DBsqlCourse();
		try {
		courselist = sql1.showCourseList(amount,startline);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//ADD LIST TO PANEL
		for(int ii=0; ii < courselist.size();ii++)
		{
			Course course ;//Grade grade ;
			//DBsqlCourse sql2 = new DBsqlCourse();			
			course = courselist.get(ii);
			//course = sql2.selectCourse(grade.getCourseID());
			rowslabel[ii][0].setText(course.getCourseName());
			rowsbutton[ii].setText("选择/退选");
		}
		for(int ii=courselist.size(); ii <amount ;ii++)
		{
			rowslabel[ii][0].setText("");
			rowsbutton[ii].setText("不要点我");
			rowslabel[ii][1].setText("");
		}		
	}
	public boolean addAttendCourse(int index)
	{
		Course course;
		try {
			course = courselist.get(index);
		} catch (Exception e) {
			return false;
		}
		DBsqlAttendCourse sql1 = new DBsqlAttendCourse();
		sql1.addAttendCourse(LogMain.getCurrentUser().getUserID(), course.getCourseID());
		return true;		
	}
	public boolean delAttendCourse(int index)
	{
		Course course;
		try {
			course = courselist.get(index);
		} catch (Exception e1) {
			return false;
		}
		DBsqlAttendCourse sql1 = new DBsqlAttendCourse();
		try {
			sql1.deleteAttendCourse(LogMain.getCurrentUser().getUserID(), course.getCourseID());
		} catch (Exception e) {			
			e.printStackTrace() ;return false ;
		}
		return true;		
	}
	public void getStates()
	{
		for (int ii = 0 ; ii < ListTable.amount ;ii ++)
		{
			Course course;
			try {
				course = courselist.get(ii);
			} catch (Exception e) {
				return ;
			}
			DBsqlAttendCourse sql1 = new DBsqlAttendCourse();
			if(sql1.isAttendCourse(LogMain.getCurrentUser().getUserID(), course.getCourseID()))
				state[ii] = true ;
			else
				state[ii] = false ;
			rowslabel[ii][1].setText(state[ii]?"__已经选了":"_还没有选");
			//SUPER CLASS VARIABLE
		}
	}
	@Override
	protected int getTotal() {
		int a=0;
		DBsqlCourse sql1 = new DBsqlCourse();
		try {
			a=sql1.getTotal();
			//System.out.println("__"+OurFrame.getCurrentUser());
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return a;
	}	
}
