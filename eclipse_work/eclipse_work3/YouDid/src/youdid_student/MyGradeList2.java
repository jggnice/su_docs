package youdid_student;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import youdid.LogMain;
import dbsql.DBsqlAttendCourse;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MyGradeList2 extends JPanel {
	private JTable table;
	private JButton btnPrint;

	/**
	 * Create the panel.
	 */
	public MyGradeList2() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		
		JButton btnRefresh = new JButton("\u70B9\u6211\u5237\u65B0");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				refreshAction();
			}
		});
		panel_1.add(btnRefresh);
		
		btnPrint = new JButton("\u70B9\u6211\u6253\u5370");
		panel_1.add(btnPrint);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BFE\u7A0B\u540D\u79F0", "\u6210\u7EE9"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		fillTable();
	}
	protected void refreshAction() 
	{
		 fillTable();
	}
	void fillTable()
	{		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);	
		DBsqlAttendCourse sql1 = new DBsqlAttendCourse();	
		try {
			sql1.showAttendList2(dtm,LogMain.getCurrentUser().getUserID());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public JButton getPrintButton()
	{
		return this.btnPrint;
	}
	public JTable getPrintArea()
	{
		return this.table;
	}

}
