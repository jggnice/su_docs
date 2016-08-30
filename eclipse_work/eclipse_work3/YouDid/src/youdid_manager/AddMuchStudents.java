package youdid_manager;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import lei.NewUser;
import dbsql.DBsql1;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddMuchStudents extends JPanel {
	private static final long serialVersionUID = 4221551288990994676L;
	private JTextField txtAmount;
	private GregorianCalendar date;
	private JComboBox<String> cBoxYear;
	private String[] UserYear;
	private JComboBox<String> cBoxYuanXi;
	private JComboBox<String> cBoxHowLong;
	private JComboBox<String> cBoxSpec;
	private int int_amount;
	private String str_amount;
	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AddMuchStudents() 
	{
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblAddmuchstudents = new JLabel("�������ѧ��");
		lblAddmuchstudents.setFont(new Font("����", Font.PLAIN, 14));
		lblAddmuchstudents.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblAddmuchstudents, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblYear = new JLabel("ѡ���꼶");
		panel_1.add(lblYear);
		
		cBoxYear = new JComboBox<String>();
		
		panel_1.add(cBoxYear);
		
		JLabel lblYuanxi = new JLabel("ѡ��Ժϵ");
		panel_1.add(lblYuanxi);
		
		cBoxYuanXi = new JComboBox();
		cBoxYuanXi.setModel(new DefaultComboBoxModel(new String[] {"��ѧ��ѧѧԺ"}));
		panel_1.add(cBoxYuanXi);
		
		JLabel lblHowlong = new JLabel("ѡ��ѧ����");
		panel_1.add(lblHowlong);
		
		cBoxHowLong = new JComboBox();
		cBoxHowLong.setModel(new DefaultComboBoxModel(new String[] {"������", "������"}));
		panel_1.add(cBoxHowLong);
		
		JLabel lblSpec = new JLabel("ѡ��רҵ");
		panel_1.add(lblSpec);
		String Spec_4[] = {"Ӧ����ѧ(ʦ��)", "��ѧ����(��Ϣ�����)", "ͳ��ѧ", "������ѧ"};
		cBoxSpec = new JComboBox();
		cBoxSpec.setModel(new DefaultComboBoxModel(Spec_4));
		panel_1.add(cBoxSpec);
		
		JLabel lblAmount = new JLabel("��д��רҵ����");
		panel_1.add(lblAmount);
		
		txtAmount = new JTextField();
		txtAmount.setText("66");
		panel_1.add(txtAmount);
		txtAmount.setColumns(10);
		
		JButton btnSubmit = new JButton("�ύ");		
		panel_1.add(btnSubmit);
		
		JLabel lblNotice = new JLabel("Notice");
		panel_1.add(lblNotice);
		
		date = new GregorianCalendar();
		int tep = date.get(Calendar.YEAR);		
		
		UserYear = new String[3];
		String[] UserYear2 = new String[3];
		UserYear2[0] = ""+tep+"��";
		UserYear2[1] = ""+(tep+1)+"��";
		UserYear2[2] = ""+(tep+2) + "��";
		
		tep = tep % 100;
		UserYear[0] = ""+tep;
		UserYear[1] = ""+(tep+1);
		UserYear[2] = ""+(tep+2);
		
		cBoxYear.setModel(new DefaultComboBoxModel(UserYear2));
		btnSubmit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				str_amount = txtAmount.getText();
				int_amount = Integer.parseInt(str_amount);
				if(int_amount>999)
				{
					lblNotice.setText("������������");return;
				}
				int ans = JOptionPane.showConfirmDialog(null, "ȷ����ӣ�");
				if(ans == JOptionPane.YES_OPTION)
				{
					for(int ii=1;ii<=int_amount;ii++)
					{
						add(ii);
					}					
					lblNotice.setText("��ӳɹ�");		
				}				
				else
				{
					lblNotice.setText("���ʧ��");
				}			
			}
		});
	}
	public boolean add(int am)
	{
		String Spec_41[] = {"Ӧ����ѧ(ʦ��)", "��ѧ����(��Ϣ�����)", "ͳ��ѧ", "������ѧ"};
		String yy = UserYear[cBoxYear.getSelectedIndex()];
		String Yuanxi[] = {"07"}; 
		String yuanxi = Yuanxi[cBoxYuanXi.getSelectedIndex()];
		String HowLong[] = {"4","5"};
		String howlong = HowLong[cBoxHowLong.getSelectedIndex()];
		String Spec[] = {"01","02","03","04"};
		String spec = Spec[cBoxSpec.getSelectedIndex()];
		String number = ""+am;
		{
			String tep = ""+am;
			for(int ii=0;ii<3-tep.length();ii++)
			{
				number = "0"+number;
			}
		}
		String ID = yy + yuanxi + howlong + spec + number;
		NewUser reader = new NewUser();
		reader.setUserID(ID);
		reader.setName(ID);
		reader.setUserType(0);
		reader.setUserPassword(ID);
		reader.setSex("��");
		reader.setSpec(Spec_41[cBoxSpec.getSelectedIndex()]);		
		//System.out.println(ID);
		DBsql1 sql1 = new DBsql1();
		return	sql1.addNewUser(reader);
	}

	/**
	 * @return the date
	 */
	public GregorianCalendar getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(GregorianCalendar date) 
	{
		this.date = date;
	}
	/**
	 * @return the int_amount
	 */
	public int getInt_amount() {
		return int_amount;
	}
	/**
	 * @param int_amount the int_amount to set
	 */
	public void setInt_amount(int int_amount) {
		this.int_amount = int_amount;
	}
	/**
	 * @return the str_amount
	 */
	public String getStr_amount() {
		return str_amount;
	}
	/**
	 * @param str_amount the str_amount to set
	 */
	public void setStr_amount(String str_amount) {
		this.str_amount = str_amount;
	}

}
