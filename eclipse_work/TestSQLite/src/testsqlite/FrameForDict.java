package testsqlite;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JProgressBar;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameForDict extends JFrame
{
	/**
	 * FrameForDict
	 */
	private static final long serialVersionUID = 479139431416824029L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtEnglish;
	private JTextField txtChinese;
	private JProgressBar progressBar;
	private int timecount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try
				{
					FrameForDict frame = new FrameForDict();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	protected void OKbuttonAction(ActionEvent arg0)
	{
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);

		try
		{
			TestSQLite1.wordToTable(dtm, txtEnglish.getText(),
					txtChinese.getText());
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}
	protected void mousePressedAction(MouseEvent arg0)
	{

		timecount = 0;
		new Thread(new Runnable() {
			public void run()
			{

				new Timer(1, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0)
					{
						if (timecount < 100)
						{
							timecount += 5;
							progressBar.setValue(timecount);
						}
					}
				}).start();
			}
		}).start();
	}
	/**
	 * Create the frame.
	 */
	@SuppressWarnings("serial")
	public FrameForDict()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][]{}, new String[]{
				"\u8BA1\u6570", "English", "\u4E2D\u6587"}) {
			boolean[] columnEditables = new boolean[]{false, false, false};
			public boolean isCellEditable(int row, int column)
			{
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);

		JLabel lblEnglish = new JLabel("English");
		panel_1.add(lblEnglish);

		txtEnglish = new JTextField();
		txtEnglish.setText("English");
		panel_1.add(txtEnglish);
		txtEnglish.setColumns(10);

		JLabel lblChinese = new JLabel("\u4E2D\u6587");
		panel_1.add(lblChinese);

		txtChinese = new JTextField();
		txtChinese.setText("\u4E2D\u6587");
		panel_1.add(txtChinese);
		txtChinese.setColumns(10);

		JButton btnOk = new JButton("OK");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0)
			{
				mousePressedAction(arg0);
			}
		});
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				OKbuttonAction(arg0);
			}
		});
		panel_1.add(btnOk);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);

		JLabel lblProgress = new JLabel("progress");
		panel_2.add(lblProgress);

		progressBar = new JProgressBar();
		panel_2.add(progressBar);
	}

}
