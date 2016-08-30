package com.b510.mp3.ui;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.b510.mp3.common.Common;
import com.b510.mp3.util.CommonUtil;

/**
 * @author Hongten
 * @created 2014-8-2
 */
public class AboutUI extends MainUI {
	private static final long serialVersionUID = 1L;

	private JLabel descriptionLabel;
	private JButton hongtenButton;
	private JTable aboutUITable;
	private JPanel mainPanel;
	private JScrollPane rightScrollPane;

	public AboutUI(String title) {
		super(title);
		initComponents();
		initSelf();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				AboutUI.this.setVisible(false);
			}
		});
	}

	public void initSelf() {
		this.setVisible(true);
		setResizable(false);
		this.setLocation(MainUI.pointX + 60, MainUI.pointY + 190);
	}

	private void initComponents() {
		initElement();

		hongtenButton.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource(Common.ABOUT_PIC)));
		hongtenButton.setToolTipText(Common.AUTHOR_NAME);

		Object[][] values = new Object[][] { { Common.AUTHOR, Common.AUTHOR_NAME }, { Common.APPLICATION_NAME, Common.MP3_PLAYER }, { Common.APPLICATION_DESCRIPTION, Common.APPLICATION_DESCRIPTION_DETAIL }, { Common.VERSION, Common.VERSION_VALUE }, { Common.BLOG, Common.HOME_PAGE } };

		String[] titles = new String[] { Common.ITEM, Common.DESCRIPTION };

		aboutUITable.setModel(new DefaultTableModel(values, titles) {
			private static final long serialVersionUID = 1L;
			boolean[] canEdit = new boolean[] { false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		
		aboutUITable.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		aboutUITable.setOpaque(false);
		aboutUITable.setRowHeight(Common.TABLE_ROW_HEIGHT);
		aboutUITable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		aboutUITable.setSurrendersFocusOnKeystroke(true);
		aboutUITable.getTableHeader().setReorderingAllowed(false);
		aboutUITable.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() == 2) {
					matchUrlOperation();
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		rightScrollPane.setViewportView(aboutUITable);

		descriptionLabel.setFont(new java.awt.Font(Common.FONT_SONG_TI, 1, 18));
		descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		descriptionLabel.setText(Common.AUTHOR_DESC);
		mainPanelLayout();
	}
	
	private void matchUrlOperation() {
		int id = aboutUITable.getSelectedRow();
		String url = (String) aboutUITable.getValueAt(id, 1);
		if (url.equals(Common.HOME_PAGE)) {
			askAccessBlogOperation();
		}
	}

	protected void askAccessBlogOperation() {
		int option = JOptionPane.showConfirmDialog(AboutUI.this, Common.ACCESS_URL + Common.HOME_PAGE + Common.BLANK + Common.QUESTION_MARK, Common.ACCESS_URL_REQUEST, JOptionPane.YES_NO_OPTION);
		if (option == JOptionPane.YES_OPTION) {
			CommonUtil.accessURL(Common.HOME_PAGE);
		}
	}

	public static void main(String[] args) {
		new AboutUI("");
	}

	private void initElement() {
		mainPanel = new JPanel();
		hongtenButton = new JButton();
		rightScrollPane = new JScrollPane();
		aboutUITable = new JTable();
		descriptionLabel = new JLabel();
	}

	/**
	 * If not necessary, please do not change
	 */
	private void mainPanelLayout() {
		GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
		mainPanel.setLayout(mainPanelLayout);
		mainPanelLayout.setHorizontalGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(mainPanelLayout.createSequentialGroup().addContainerGap().addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(hongtenButton).addComponent(descriptionLabel, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)).addGap(18, 18, 18).addComponent(rightScrollPane, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		mainPanelLayout.setVerticalGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(mainPanelLayout.createSequentialGroup().addContainerGap().addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(rightScrollPane, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE).addGroup(mainPanelLayout.createSequentialGroup().addComponent(hongtenButton, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(descriptionLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))).addGap(0, 0, Short.MAX_VALUE)));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addContainerGap()));

		pack();
	}
}
