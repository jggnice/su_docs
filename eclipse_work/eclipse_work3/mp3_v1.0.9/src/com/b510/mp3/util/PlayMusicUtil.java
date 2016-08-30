/**
 * 
 */
package com.b510.mp3.util;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

/**
 * @author Hongten
 * @created 2014-7-27
 */
public class PlayMusicUtil extends Frame {
	private static final long serialVersionUID = -6982844983910946916L;
	boolean isStop = true;// ���Ʋ����߳�
	boolean hasStop = true;// �����߳�״̬

	boolean playing = true;
	byte tempBuffer[] = new byte[320];

	String filepath;// �����ļ�Ŀ¼
	String filename;// �����ļ�����
	AudioInputStream audioInputStream;// �ļ���
	AudioFormat audioFormat;// �ļ���ʽ
	SourceDataLine sourceDataLine;// ����豸

	List list;// �ļ��б�
	Label labelfilepath;// ����Ŀ¼��ʾ��ǩ
	Label labelfilename;// �����ļ���ʾ��ǩ

	public PlayMusicUtil() {
		// ���ô�������
		setLayout(new BorderLayout());
		setTitle("MP3���ֲ�����");
		setSize(350, 370);

		// �����˵���
		MenuBar menubar = new MenuBar();
		Menu menufile = new Menu("�ļ�");
		MenuItem menuopen = new MenuItem("��", new MenuShortcut(KeyEvent.VK_O));
		menufile.add(menuopen);
		menufile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				open();
			}
		});
		menubar.add(menufile);
		setMenuBar(menubar);

		// �ļ��б�
		list = new List(10);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// ˫��ʱ����
				if (e.getClickCount() == 2) {
					// ����ѡ�е��ļ�
					filename = list.getSelectedItem();
					play();
				} else if (e.getClickCount() == 1) {
					if (playing) {
						if (sourceDataLine.isActive()) {
							sourceDataLine.stop();
							playing = false;
							tempBuffer = new byte[0];
						}
					} else {
						sourceDataLine.start();
						playing = true;
						tempBuffer = new byte[320];
					}
				}
			}
		});
		add(list, "Center");

		// ��Ϣ��ʾ
		Panel panel = new Panel(new GridLayout(2, 1));
		labelfilepath = new Label("����Ŀ¼��");
		labelfilename = new Label("�����ļ���");
		panel.add(labelfilepath);
		panel.add(labelfilename);
		add(panel, "North");

		// ע�ᴰ��ر��¼�
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setVisible(true);
	}

	// ��
	private void open() {
		FileDialog dialog = new FileDialog(this, "Open", 0);
		dialog.setVisible(true);
		filepath = dialog.getDirectory();
		if (filepath != null) {
			labelfilepath.setText("����Ŀ¼��" + filepath);

			// ��ʾ�ļ��б�
			list.removeAll();
			File filedir = new File(filepath);
			File[] filelist = filedir.listFiles();
			for (File file : filelist) {
				String filename = file.getName().toLowerCase();
				if (filename.endsWith(".mp3") || filename.endsWith(".wav")) {
					list.add(filename);
				}
			}
		}
	}

	// ����
	private void play() {
		try {
			isStop = true;// ֹͣ�����߳�
			// �ȴ������߳�ֹͣ
			System.out.print("��ʼ���ţ�" + filename);
			while (!hasStop) {
				System.out.print(".");
				try {
					Thread.sleep(10);
				} catch (Exception e) {
				}
			}
			System.out.println("");
			File file = new File(filepath + filename);
			labelfilename.setText("�����ļ���" + filename);

			// ȡ���ļ�������
			audioInputStream = AudioSystem.getAudioInputStream(file);
			System.out.println(audioInputStream.getFrameLength());// -1
			audioFormat = audioInputStream.getFormat();
			// ת��mp3�ļ�����
			if (audioFormat.getEncoding() != AudioFormat.Encoding.PCM_SIGNED) {
				audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, audioFormat.getSampleRate(), 16, audioFormat.getChannels(), audioFormat.getChannels() * 2,
						audioFormat.getSampleRate(), false);
				audioInputStream = AudioSystem.getAudioInputStream(audioFormat, audioInputStream);
			}

			// ������豸
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat, AudioSystem.NOT_SPECIFIED);
			sourceDataLine = (SourceDataLine) AudioSystem.getLine(info);
			sourceDataLine.open(audioFormat);
			sourceDataLine.start();

			// ���������߳̽��в���
			isStop = false;
			Thread playThread = new Thread(new PlayThread());
			playThread.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	class PlayThread extends Thread {

		@Override
		public void run() {
			try {
				int cnt;
				hasStop = false;
				// ��ȡ���ݵ���������
				while ((cnt = audioInputStream.read(tempBuffer, 0, tempBuffer.length)) != -1) {
					if (isStop)
						break;
					if (cnt > 0) {
						// д�뻺������
						sourceDataLine.write(tempBuffer, 0, cnt);
					}
				}
				// Block�ȴ���ʱ���ݱ����Ϊ��
				sourceDataLine.drain();
				sourceDataLine.close();
				hasStop = true;
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(0);
			}
		}
	}

	public static void main(String args[]) {
		new PlayMusicUtil();
	}
}