package com.b510.mp3.ui;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

import com.b510.mp3.common.Common;
import com.b510.mp3.util.OpenUtil;
import com.b510.mp3.util.ScaledImageUtil;

public class SingerImageHandlerUI extends MainUI {
	private static final long serialVersionUID = 1L;

	private JPanel backGroundPanel;
	private JPanel buttomPanel;
	private JSeparator buttomjSeparator;
	private JButton cancelButton;
	private JTextField imagePathTextField;
	private JPanel middlePanel;
	private JButton previewButton;
	private JLabel selectImageDescLabel;
	private JLabel selectLabel;
	private JButton setButton;
	private JPanel topPanel;
	private JSeparator topjSeparator;

	private String imagePathTextFieldValue = Common.DEFAULT_DIRECTORY_PATH;

	private MainUI mainUI;

	public SingerImageHandlerUI(String title) {
		super(title);
		initComponents();

		initSelf();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				SingerImageHandlerUI.this.setVisible(false);
			}
		});
	}

	public void initSelf() {
		this.setVisible(true);
		this.setResizable(false);
		this.setLocation(MainUI.pointX + 80, MainUI.pointY + 55);
	}

	private void initElement() {
		backGroundPanel = new JPanel();
		topPanel = new JPanel();
		selectImageDescLabel = new JLabel();
		topjSeparator = new JSeparator();
		middlePanel = new JPanel();
		selectLabel = new JLabel();
		imagePathTextField = new JTextField();
		setButton = new JButton();
		cancelButton = new JButton();
		buttomPanel = new JPanel();
		previewButton = new JButton();
		buttomjSeparator = new JSeparator();
	}

	private void initComponents() {
		initElement();
		initTopPanelLayout();
		initMiddlePanelLayout();
		initButtomPanelLayout();
		backGroundPanelLayout();
		pack();
	}

	private void initTopPanelLayout() {
		selectImageDescLabel.setHorizontalAlignment(SwingConstants.CENTER);
		selectImageDescLabel.setText("<html>Input the path of a directory, and click the 'Set' button to set singer image.<br>Or click the 'Cancel' button to cancel.</html>");

		topPanelLayout();
	}

	private void initMiddlePanelLayout() {
		selectLabel.setText("Select Image : ");

		String path = playLists.get(PlayListUI.selectId_button3).getImagePath();
		imagePathTextFieldValue = path.trim();
		imagePathTextField.setText(path);
		imagePathTextField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1 || e.getClickCount() == 2) {
					openOperation();
				}
			}
		});
		setButton.setText("Set");
		setButton.addActionListener(this);

		cancelButton.setText("cancel");
		cancelButton.addActionListener(this);

		middlePanelLayout();
	}

	private void initButtomPanelLayout() {
		if (imagePathTextFieldValue.startsWith("com")) {
			previewButton.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource(imagePathTextFieldValue)));
		} else {
			try {
				URL url = new URL("file:/" + imagePathTextFieldValue);
				previewButton.setIcon(new ImageIcon(url));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}

		buttomPanelLayout();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == setButton) {
			setOperation();
		} else if (e.getSource() == cancelButton) {
			cancelOperation();
		}
	}

	private void openOperation() {
		String imagePath = OpenUtil.open(Common.JPG);
		if (Common.EMPTY.equals(imagePath)) {
			imagePathTextField.setText(imagePathTextFieldValue);
			File file = new File(imagePathTextField.getText().trim());
			if (file.isDirectory()) {
				JOptionPane.showMessageDialog(SingerImageHandlerUI.this, Common.INVALID_FILE_FORMAT_JPG);
			}
		} else {
			imagePathTextField.setText(imagePath);
			File file = new File(imagePathTextField.getText().trim());
			if (file.exists()) {
				String scaledPath = "c:/mp3/head/";
				String scaledName = "";
				String postFix = ScaledImageUtil.getPostfix(imagePath);
				file = new File(scaledPath);
				if (!file.exists()) {
					file.mkdirs();
				}
				scaledName = "temp_head" + Common.FULL_SPOT + postFix;
				String singerImagePath = scaledPath + scaledName;
				ScaledImageUtil.scaledImage(imagePath, 2, singerImagePath);
				try {
					URL url = new URL("file:/" + singerImagePath);
					previewButton.setIcon(new ImageIcon(url));
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void setOperation() {
		String path = imagePathTextField.getText();
		if (!path.startsWith("com")) {
			String postFix = ScaledImageUtil.getPostfix(path);
			String scaledPath = "c:/mp3/head/";
			String tempPath = scaledPath + "temp_head" + Common.FULL_SPOT + postFix;
			File tempFile = new File(tempPath);
			if (tempFile.exists()) {
				File[] listFiles = new File(scaledPath).listFiles();

				String setImagePath = scaledPath + "head_" + listFiles.length + Common.FULL_SPOT + postFix;
				File f = new File(setImagePath);
				tempFile.renameTo(f);
				playLists.get(PlayListUI.selectId_button3).setImagePath(setImagePath.replace(Common.BLACKSLASH, Common.ELLIPSIS_SIGN));
				mainUI.refreshPlaylistUIWhenUIVisible();
				mainUI.generatePlayListXML();
			}
		}
		this.setVisible(false);
	}

	private void cancelOperation() {
		this.setVisible(false);
	}

	public void setMainUI(MainUI mUI) {
		this.mainUI = mUI;
	}

	public static void main(String args[]) {
		new SingerImageHandlerUI("").setVisible(true);
	}

	/**
	 * If not necessary, please do not change
	 */
	private void topPanelLayout() {
		GroupLayout topPanelLayout = new GroupLayout(topPanel);
		topPanel.setLayout(topPanelLayout);
		topPanelLayout.setHorizontalGroup(topPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				topPanelLayout.createSequentialGroup().addContainerGap()
						.addGroup(topPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(selectImageDescLabel).addComponent(topjSeparator))
						.addContainerGap()));
		topPanelLayout.setVerticalGroup(topPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				topPanelLayout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(selectImageDescLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18)
						.addComponent(topjSeparator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)));
	}

	/**
	 * If not necessary, please do not change
	 */
	private void middlePanelLayout() {
		GroupLayout middlePanelLayout = new GroupLayout(middlePanel);
		middlePanel.setLayout(middlePanelLayout);
		middlePanelLayout.setHorizontalGroup(middlePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				middlePanelLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(selectLabel)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(
								middlePanelLayout
										.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(
												middlePanelLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
														.addComponent(setButton, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)).addComponent(imagePathTextField))
						.addContainerGap()));
		middlePanelLayout.setVerticalGroup(middlePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				middlePanelLayout
						.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(
								middlePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(selectLabel)
										.addComponent(imagePathTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(
								middlePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(setButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
										.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))));
	}

	/**
	 * If not necessary, please do not change
	 */
	private void buttomPanelLayout() {
		GroupLayout buttomPanelLayout = new GroupLayout(buttomPanel);
		buttomPanel.setLayout(buttomPanelLayout);
		buttomPanelLayout.setHorizontalGroup(buttomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(buttomPanelLayout.createSequentialGroup().addComponent(buttomjSeparator).addContainerGap())
				.addGroup(GroupLayout.Alignment.TRAILING, buttomPanelLayout.createSequentialGroup().addGap(0, 88, Short.MAX_VALUE).addComponent(previewButton).addGap(88, 88, 88)));
		buttomPanelLayout.setVerticalGroup(buttomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				GroupLayout.Alignment.TRAILING,
				buttomPanelLayout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(buttomjSeparator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(previewButton)
						.addContainerGap()));
	}

	/**
	 * If not necessary, please do not change
	 */
	private void backGroundPanelLayout() {
		GroupLayout backGroundPanelLayout = new GroupLayout(backGroundPanel);
		backGroundPanel.setLayout(backGroundPanelLayout);
		backGroundPanelLayout.setHorizontalGroup(backGroundPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(topPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(middlePanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(buttomPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		backGroundPanelLayout.setVerticalGroup(backGroundPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				backGroundPanelLayout.createSequentialGroup().addContainerGap()
						.addComponent(topPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(0, 0, 0)
						.addComponent(middlePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(0, 0, Short.MAX_VALUE)
						.addComponent(buttomPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addContainerGap()));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addContainerGap().addComponent(backGroundPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addContainerGap().addComponent(backGroundPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
	}
}
