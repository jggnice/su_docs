package util;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import tofile.ToFile;
import youdid.App2;
import youdid.OurFrame;
import base64.EnCode;
import dbsql.DBConn;

@SuppressWarnings("serial")
public class DBFrame extends JFrame {
	private JPanel contentPane;
	private static JTextField txtUserid;
	private static JPasswordField pwdUsepassword;

	public static String getid() {
		return txtUserid.getText();
	}

	@SuppressWarnings("deprecation")
	public static String getPwdUsepassword() {
		return pwdUsepassword.getText();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DBFrame frame = new DBFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DBFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblHuanyin = new JLabel("\u6B22\u8FCE\u4F7F\u7528");
		lblHuanyin.setHorizontalAlignment(SwingConstants.CENTER);
		lblHuanyin.setFont(new Font("华文中宋", Font.BOLD, 18));

		JLabel lblDbuserid = new JLabel("\u6570\u636E\u5E93\u767B\u5F55\u540D");
		lblDbuserid.setIcon(new ImageIcon(DBFrame.class
				.getResource("/images/userName.png")));

		txtUserid = new JTextField();
		lblDbuserid.setLabelFor(txtUserid);
		txtUserid.setText("sa");
		txtUserid.setColumns(10);

		JLabel lblDbpassword = new JLabel(
				"\u6570\u636E\u5E93\u7684\u5BC6\u7801");
		lblDbpassword.setIcon(new ImageIcon(DBFrame.class
				.getResource("/images/password.png")));

		pwdUsepassword = new JPasswordField();
		lblDbpassword.setLabelFor(pwdUsepassword);

		JButton btnLogon = new JButton("\u767B\u9646");
		btnLogon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DBlogonActionPerformed();
			}
		});
		btnLogon.setIcon(new ImageIcon(DBFrame.class
				.getResource("/images/login.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGap(72)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																lblHuanyin,
																GroupLayout.PREFERRED_SIZE,
																255,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblDbpassword,
																								GroupLayout.PREFERRED_SIZE,
																								103,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								lblDbuserid))
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING,
																								false)
																						.addComponent(
																								txtUserid,
																								GroupLayout.DEFAULT_SIZE,
																								114,
																								Short.MAX_VALUE)
																						.addComponent(
																								pwdUsepassword)
																						.addComponent(
																								btnLogon,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE))))
										.addContainerGap(97, Short.MAX_VALUE)));
		gl_contentPane
				.setVerticalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGap(21)
										.addComponent(lblHuanyin,
												GroupLayout.PREFERRED_SIZE, 28,
												GroupLayout.PREFERRED_SIZE)
										.addGap(51)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																txtUserid,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblDbuserid))
										.addGap(24)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																pwdUsepassword,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblDbpassword))
										.addGap(31).addComponent(btnLogon)
										.addGap(30)));
		contentPane.setLayout(gl_contentPane);
	}

	/**
	 * ****************************************************************
	 */
	protected void DBlogonActionPerformed() {
		/**
		 * SEND TO CLASS DBConn
		 */
		DBConn.setDbUserName(DBFrame.txtUserid.getText());
		DBConn.setDBPassword(String.valueOf(DBFrame.pwdUsepassword
				.getPassword()));
		/**
		 * CHECK
		 */
		if (DBConn.tryConnection()) {

			try {
				/**
				 * SEND TO FILE
				 */
				String[] Encode = new String[2];
				Encode[0] = App2.filename;
				Encode[1] = App2.filename1;
				String[] arg_txt = new String[2];
				arg_txt[0] = DBFrame.txtUserid.getText();
				arg_txt[1] = String.valueOf(DBFrame.pwdUsepassword
						.getPassword());
				
				String[] rsaen_arg = new String[2];
				rsaen_arg[0] = arg_txt[0];
				not_file.TestRSAnoPadding.S2S(rsaen_arg);
				arg_txt[0] = rsaen_arg[1];				
				rsaen_arg[0] = arg_txt[1];
				not_file.TestRSAnoPadding.S2S(rsaen_arg);
				arg_txt[1] = rsaen_arg[1];
				
				ToFile.setFile(App2.filename, arg_txt);
				EnCode.encode(Encode);
				ToFile.file_delete(App2.filename);
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "FileNotFoundException");
			} catch (IOException e) {
				e.printStackTrace();
			}
			this.dispose();
			System.out.println("HOW ARE YOU?");
			/**
			 * NEW OURFRAME
			 */
			OurFrame f0 = new OurFrame();
			f0.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "连接数据库失败");
		}
	}
}
