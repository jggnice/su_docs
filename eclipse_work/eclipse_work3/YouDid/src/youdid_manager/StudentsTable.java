package youdid_manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import lei.NewUser;
import util.InfoModify;
import dbsql.DBsql1;

public class StudentsTable extends JPanel {
	private static final long serialVersionUID = 1157508885327958197L;
	private JTextField txtSno;
	private JTextField txtSname;
	private JTable table;
	private InfoModify1 panel_m = new InfoModify1();
	private JTextField txtSpec;
	/**
	 * Create the panel.
	 */
	@SuppressWarnings("serial")
	public StudentsTable() 
	{
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new CompoundBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "\u8BF7\u8F93\u5165\u67E5\u8BE2\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
		panel.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblSno = new JLabel("\u5B66\u53F7");
		panel_1.add(lblSno);
		
		txtSno = new JTextField();
		panel_1.add(txtSno);
		txtSno.setColumns(10);
		
		JLabel lblSname = new JLabel("\u59D3\u540D");
		panel_1.add(lblSname);
		
		txtSname = new JTextField();
		panel_1.add(txtSname);
		txtSname.setColumns(10);
		
		JButton btnQuery = new JButton("\u67E5\u8BE2");
		/**
		 * impotant
		 */
		btnQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				bookTypeSearchActionPerformed(arg0);
			}
		});
		
		JLabel lblSpec = new JLabel("\u4E13\u4E1A");
		panel_1.add(lblSpec);
		
		txtSpec = new JTextField();
		panel_1.add(txtSpec);
		txtSpec.setColumns(10);
		panel_1.add(btnQuery);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
		);
		
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
				"\u5B66\u53F7", "\u59D3\u540D", "\u4E13\u4E1A"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		/**
		 * ModifyInfo panel
		 */
		
		panel_m.setBorder(new TitledBorder(null, "\u4FEE\u6539\u5B66\u751F\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.add(panel_m, BorderLayout.CENTER);
		
	}
	/**
	 * **********  IMPOTANT   *******************
	 */
	void fillTable()
	{		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);	
		DBsql1 sql1 = new DBsql1();	
	
		try {
			sql1.tablelist(dtm,txtSno.getText(),txtSname.getText(),txtSpec.getText());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	protected void bookTypeTableMousePressed(MouseEvent e) 
	{
		int row = table.getSelectedRow();
		String id = (String) table.getValueAt(row, 0);
		DBsql1 sql1 = new DBsql1();
		NewUser tep = sql1.selectNewUser(id);		
		panel_m.setUser(tep);
		panel_m.InitInfo(panel_m.getUser());
	}
	private void bookTypeSearchActionPerformed(ActionEvent arge) 
	{		
		this.fillTable();
	}

}
@SuppressWarnings("serial")
class InfoModify1 extends InfoModify
{
	@Override
	public void additional(){}	
}