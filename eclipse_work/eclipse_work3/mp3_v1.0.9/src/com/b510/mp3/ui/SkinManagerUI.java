package com.b510.mp3.ui;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle;

import com.b510.mp3.common.Common;

/**
 * @author Hongten
 * @created 2014-8-1
 */
public class SkinManagerUI extends MainUI {
	private static final long serialVersionUID = -37011351219515242L;

	private JLabel currentSkinDescJLabel;
	private JLabel currentSkinJLabel;
	private JLabel descJlabel;
	private JSeparator line;
	private JComboBox sinkJComboBox;
	
	public String[][] skins = { { "AutumnSkin", "1", "<html><a href='http://www.baidu.com'>baidu</a>current skin is good skin, and you <br> can change the color for this skin.</html>" },
			{ "BusinessBlackSteelSkin", "2", "This is BusinessBlackSteelSkin" }, { "ChallengerDeepSkin", "3", "This is ChallengerDeepSkin" },
			{ "CremeCoffeeSkin", "4", "This is CremeCoffeeSkin" }, { "CremeSkin", "5", "This is CremeSkin" }, { "EbonyHighContrastSkin", "6", "This is EbonyHighContrastSkin" },
			{ "EmeraldDuskSkin", "7", "This is EmeraldDuskSkin" }, { "FieldOfWheatSkin", "8", "This is FieldOfWheatSkin" }, { "FindingNemoSkin", "9", "This is FindingNemoSkin" },
			{ "GreenMagicSkin", "10", "This is GreenMagicSkin" }, { "MagmaSkin", "11", "This is MagmaSkin" }, { "MangoSkin", "12", "This is MangoSkin" },
			{ "MistSilverSkin", "13", "This is MistSilverSkin" }, { "ModerateSkin", "14", "This is ModerateSkin" }, { "NebulaBrickWallSkin", "15", "This is NebulaBrickWallSkin" },
			{ "NebulaSkin", "16", "This is NebulaSkin" }, { "OfficeBlue2007Skin", "17", "This is OfficeBlue2007Skin" },
			{ "RavenGraphiteGlassSkin", "18", "This is RavenGraphiteGlassSkin" }, { "RavenGraphiteSkin", "19", "This is RavenGraphiteSkin" },
			{ "RavenSkin", "20", "This is RavenSkin" }, { "SaharaSkin", "21", "This is SaharaSkin" } };

	private Object[] skinNames() {
		Object[] os = new Object[skins.length];
		for (int i = 0; i < skins.length; i++) {
			os[i] = skins[i][0];
		}
		return os;
	}

	private Object[] getSkinDetails(Object obj) {
		for (int i = 0; i < skins.length; i++) {
			if (skins[i][0].equals(obj)) {
				Object[] os = new Object[skins[i].length - 1];
				for (int j = 0; j < os.length; j++) {
					os[j] = skins[i][j + 1];
				}
				return os;
			}
		}
		return new Object[] {};
	}

	public SkinManagerUI(String title) {
		super(title);
		initComponents();

		initSelf();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				SkinManagerUI.this.setVisible(false);
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
		currentSkinJLabel.setText(Common.CURRENT_SINK);

		Object[] skinNames = skinNames();
		sinkJComboBox.setModel(new DefaultComboBoxModel(skinNames));
		sinkJComboBox.setSelectedIndex(skinNum);
		sinkJComboBox.addActionListener(this);

		descJlabel.setText(Common.DESCRIPTION_WITH_COLOR);

		currentSkinDescJLabel.setText(skins[skinNum][2]);
		currentSkinDescJLabel.addMouseListener(new MouseListener(){
			 
			@Override
			public void mouseClicked(MouseEvent e) {
			try {
			Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler  http://www.baidu.com");
			} catch (IOException e1) {
			e1.printStackTrace();
			}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}});
		pageGourpLayout();
	}

	private void initElement() {
		currentSkinJLabel = new JLabel();
		sinkJComboBox = new JComboBox();
		descJlabel = new JLabel();
		currentSkinDescJLabel = new JLabel();
		line = new JSeparator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sinkJComboBox) {
			updateSkin();
		}
	}

	public synchronized void updateSkin() {
		Object[] os = getSkinDetails(sinkJComboBox.getSelectedItem());
		String index = (String) os[0];
		String desc = (String) os[1];
		skinNum = Integer.valueOf(index);
		currentSkinDescJLabel.setText(desc);
		setJUI();
	}

	public static void main(String args[]) {
		new SkinManagerUI("Skin Mainger UI Test...");
	}

	/**
	 * If not necessary, please do not change
	 */
	private void pageGourpLayout() {
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		horizontalGroupLayout(layout);
		verticalGroupLayout(layout);
		pack();
	}

	private void verticalGroupLayout(GroupLayout layout) {
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addGap(40, 40, 40)
						.addGroup(
								layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(currentSkinJLabel)
										.addComponent(sinkJComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGap(26, 26, 26)
						.addComponent(line, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(descJlabel).addGap(18, 18, 18).addComponent(currentSkinDescJLabel).addContainerGap(47, Short.MAX_VALUE)));
	}

	private void horizontalGroupLayout(GroupLayout layout) {
		layout.setHorizontalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(21, 21, 21)
								.addGroup(
										layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(currentSkinDescJLabel)
												.addComponent(descJlabel)
												.addGroup(
														layout.createSequentialGroup().addComponent(currentSkinJLabel).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(sinkJComboBox, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(layout.createSequentialGroup().addComponent(line, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE).addGap(0, 0, Short.MAX_VALUE)));
	}
}
