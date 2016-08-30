package youdid_teacher;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import youdid.LogMain;
import dbsql.DBsqlAttendCourse;
import dbsql.DBsqlTeachCourse;

@SuppressWarnings({ "serial" })
public class MyStudents2 extends JPanel 
{
	private static final long serialVersionUID = -1748438499827612800L;
	private JTable table;
	private JTable table_1;
	private JTextField txtGrade;
	private String currentcourse = null;
	private String currentcourseName = null;
	private String currentstu = null;
	private String currentstuName = null;
	private JButton btnPrint = new JButton("\u6253\u5370\u540D\u5355");

	/**
	 * Create the panel.
	 */
	public MyStudents2() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u6211\u6559\u7684\u8BFE\u7A0B", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		/**
		 * impotant
		 */
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookTypeTableMousePressed(e);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BFE\u7A0B\u53F7", "\u8BFE\u7A0B\u540D\u79F0", "\u5B66\u5206", "\u8BFE\u7A0B\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\u672C\u8BFE\u7A0B\u5B66\u751F\u540D\u5355", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_2.add(scrollPane_1, BorderLayout.CENTER);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookTypeTableMousePressed_1(e);
			}
		});
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u53F7", "\u59D3\u540D", "\u6210\u7EE9"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "\u6210\u7EE9\u63D0\u4EA4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_3);
		
		JLabel lblGrade = new JLabel("\u6210\u7EE9");
		lblGrade.setIcon(new ImageIcon(MyStudents2.class.getResource("/images/about.png")));
		
		txtGrade = new JTextField();
		lblGrade.setLabelFor(txtGrade);
		txtGrade.setColumns(10);
		
		JButton btnSubmit = new JButton("\u63D0\u4EA4");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				GradeModifyAction();
			}
		});
		btnSubmit.setIcon(new ImageIcon(MyStudents2.class.getResource("/images/modify.png")));
		
		
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(119)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(btnPrint)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(lblGrade)
							.addGap(5)
							.addComponent(txtGrade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(btnSubmit)))
					.addGap(120))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(5)
							.addComponent(btnSubmit))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_3.createSequentialGroup()
									.addGap(9)
									.addComponent(lblGrade))
								.addGroup(gl_panel_3.createSequentialGroup()
									.addGap(7)
									.addComponent(txtGrade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnPrint)))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		fillTable();

	}
	
	public JButton getPrintButton()
	{
		return this.btnPrint; 
	}
	public JTable getPrintArea()
	{
		return this.table_1;
	}
	/**
	 * **********  IMPOTANT   *******************
	 */
	void fillTable()
	{		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);	
		DBsqlTeachCourse sql1 = new DBsqlTeachCourse();	
	
		try {
			sql1.showMyCourse(dtm,LogMain.getCurrentUser().getUserID());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	void fillTable_1()
	{		
		DefaultTableModel dtm = (DefaultTableModel) table_1.getModel();
		dtm.setRowCount(0);	
		DBsqlAttendCourse sql1 = new DBsqlAttendCourse();	
		try {
			if(this.getCurrentcourse()==null)
				{
				JOptionPane.showMessageDialog(null, "请先选择");
				return;
				}
			sql1.showMyStudentsList(dtm, this.getCurrentcourse());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	protected void bookTypeTableMousePressed(MouseEvent evt) 
	{
		
		int row = table.getSelectedRow();		
		String id1 = (String) table.getValueAt(row, 0);
		/**
		 * important
		 */
		this.setCurrentcourse(id1);
		this.setCurrentcourseName((String) table.getValueAt(row, 1));
		fillTable_1();
	}
	protected void bookTypeTableMousePressed_1(MouseEvent evt) 
	{
		int row = table_1.getSelectedRow();
		if(row<0)
		{
			JOptionPane.showMessageDialog(null, "请先选择");
			return;
		}
		String id = (String) table_1.getValueAt(row, 0);
		txtGrade.setText((String) table_1.getValueAt(row, 2));
		this.setCurrentstu(id);
		this.setCurrentstuName((String) table_1.getValueAt(row, 1));
		//System.out.println(id);
	}
	protected void GradeInit()
	{
		;
	}
	protected void GradeModifyAction() 
	{
		int ans = JOptionPane.NO_OPTION;
		DBsqlAttendCourse sql1 = new DBsqlAttendCourse();
		if(this.getCurrentcourse()==null||this.getCurrentstu()==null)
		{
			JOptionPane.showMessageDialog(null, "请先选择");
			return;
		}
		else
		{
			ans = JOptionPane.showConfirmDialog(null,"确认提交？ ("+this.getCurrentcourseName()+", "+this.getCurrentstuName()+")");
		}
		if(ans == JOptionPane.YES_OPTION)
		{
			sql1.updateGrade(currentstu, currentcourse, Integer.parseInt(txtGrade.getText()));
			fillTable_1();
		}
		
	}
	/**
	 * @return the currentcourse
	 */
	public String getCurrentcourse() {
		return currentcourse;
	}
	/**
	 * @param currentcourse the currentcourse to set
	 */
	public void setCurrentcourse(String currentcourse) {
		this.currentcourse = currentcourse;
	}
	/**
	 * @return the currentstu
	 */
	public String getCurrentstu() {
		return currentstu;
	}
	/**
	 * @param currentstu the currentstu to set
	 */
	public void setCurrentstu(String currentstu) {
		this.currentstu = currentstu;
	}

	/**
	 * @return the currentcourseName
	 */
	public String getCurrentcourseName() {
		return currentcourseName;
	}

	/**
	 * @param currentcourseName the currentcourseName to set
	 */
	public void setCurrentcourseName(String currentcourseName) {
		this.currentcourseName = currentcourseName;
	}

	/**
	 * @return the currentstuName
	 */
	public String getCurrentstuName() {
		return currentstuName;
	}

	/**
	 * @param currentstuName the currentstuName to set
	 */
	public void setCurrentstuName(String currentstuName) {
		this.currentstuName = currentstuName;
	}
}
