package sortlist;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class FileSortPanel extends JPanel
{

	JLabel lblCountallwords = new JLabel("countAllWords");
	JLabel lblDifferentwords = new JLabel("differentWords");
	JLabel lblPleaseChooseFile;
	JCheckBox chckbxOnlyletter = new JCheckBox("OnlyLetter");
	TestSort s1;
	JTable table;
	JComboBox<String> comboBox;
	static int timecount = 0;
	static JProgressBar progressBar;
	java.io.File file = null;
	/**
	 * Create the panel.
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	public FileSortPanel()
	{
		setLayout(new BorderLayout(0, 0));

		JPanel panel_5 = new JPanel();
		add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel_5.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblTophot = new JLabel("\u70ED\u8BCD\u4E2A\u6570");
		panel_3.add(lblTophot);

		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel(new String[]{"10", "20",
				"40", "80", "160", "1600", "16000"}));
		panel_3.add(comboBox);

		JButton btnChooseFile = new JButton("choose file");
		btnChooseFile.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 12));
		panel_3.add(btnChooseFile);

		JButton btnConfirm = new JButton("\u786E\u8BA4\u63D0\u4EA4");
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e)
			{
				if(TestSort.getFile()==null)
					return;
				timecount = 0;
				new Thread(new Runnable() {
					public void run()
					{

						new Timer(20, new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0)
							{
								if (timecount < 100)
								{
									timecount++;
									FileSortPanel.progressBar
											.setValue(timecount);
								}
							}
						}).start();
					}
				}).start();
			}
		});

		panel_3.add(btnConfirm);
		lblCountallwords.setToolTipText("\u5355\u8BCD\u603B\u7684\u4E2A\u6570");

		panel_3.add(lblCountallwords);
		lblDifferentwords
				.setToolTipText("\u76F8\u5F02\u5355\u8BCD\u4E2A\u6570");

		panel_3.add(lblDifferentwords);
		chckbxOnlyletter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				TestSort.setOnlyletter(chckbxOnlyletter.isSelected());
				try
				{
					TestSort.switchFile();
					lblPleaseChooseFile.setText(TestSort.file.getName());
				} catch (Exception exception)
				{
				}
			}
		});

		chckbxOnlyletter
				.setToolTipText("\u53BB\u9664\u6240\u6709\u975E\u5B57\u6BCD");
		panel_3.add(chckbxOnlyletter);

		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6, BorderLayout.NORTH);

		lblPleaseChooseFile = new JLabel("\u8BF7\u9009\u62E9\u6587\u4EF6");
		panel_6.add(lblPleaseChooseFile);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					btnConfirmAction(arg0);
				} catch (FileNotFoundException exception)
				{
					exception.printStackTrace();
				}
			}
		});
		btnChooseFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					btnChooseFileAction(arg0);
				} catch (FileNotFoundException exception)
				{
					exception.printStackTrace();
				} catch (IOException exception)
				{
					exception.printStackTrace();
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][]{}, new String[]{
				"\u8BA1\u6570", "\u5355\u8BCD", "\u8BCD\u9891"}) {
			boolean[] columnEditables = new boolean[]{false, false, false};
			public boolean isCellEditable(int row, int column)
			{
				return columnEditables[column];
			}
		});

		scrollPane.setViewportView(table);

		JPanel panel_pro = new JPanel();
		add(panel_pro, BorderLayout.SOUTH);
		JLabel lblTimeleft = new JLabel("progress");
		panel_pro.add(lblTimeleft);

		progressBar = new JProgressBar();
		progressBar.setOrientation(JProgressBar.HORIZONTAL);
		progressBar.setMaximum(100);
		progressBar.setMinimum(0);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		progressBar.setPreferredSize(new Dimension(320, 25));
		panel_pro.add(progressBar);
	}
	protected void btnConfirmAction(ActionEvent arg0)
			throws FileNotFoundException
	{
		Object str = comboBox.getSelectedItem();
		TestSort.setLimit(Integer.parseInt(str.toString()));
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);

		TestSort.countallwords = 0;
		TestSort.alldifferent = 0;
		TestSort.startSortWords(dtm, TestSort.getFile());
		lblCountallwords.setText("All: " + TestSort.countallwords);
		lblDifferentwords.setText("Different: " + TestSort.alldifferent);

	}

	protected void btnChooseFileAction(ActionEvent arg0) throws IOException
	{
		// TODO Auto-generated method stub
		TestSort.chooseFile();

		try
		{
			lblPleaseChooseFile.setText(TestSort.file.getName());

		} catch (Exception ecp)
		{

		}
	}

}
