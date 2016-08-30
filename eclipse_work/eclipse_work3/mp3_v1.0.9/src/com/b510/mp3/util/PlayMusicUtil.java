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
	boolean isStop = true;// 控制播放线程
	boolean hasStop = true;// 播放线程状态

	boolean playing = true;
	byte tempBuffer[] = new byte[320];

	String filepath;// 播放文件目录
	String filename;// 播放文件名称
	AudioInputStream audioInputStream;// 文件流
	AudioFormat audioFormat;// 文件格式
	SourceDataLine sourceDataLine;// 输出设备

	List list;// 文件列表
	Label labelfilepath;// 播放目录显示标签
	Label labelfilename;// 播放文件显示标签

	public PlayMusicUtil() {
		// 设置窗体属性
		setLayout(new BorderLayout());
		setTitle("MP3音乐播放器");
		setSize(350, 370);

		// 建立菜单栏
		MenuBar menubar = new MenuBar();
		Menu menufile = new Menu("文件");
		MenuItem menuopen = new MenuItem("打开", new MenuShortcut(KeyEvent.VK_O));
		menufile.add(menuopen);
		menufile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				open();
			}
		});
		menubar.add(menufile);
		setMenuBar(menubar);

		// 文件列表
		list = new List(10);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 双击时处理
				if (e.getClickCount() == 2) {
					// 播放选中的文件
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

		// 信息显示
		Panel panel = new Panel(new GridLayout(2, 1));
		labelfilepath = new Label("播放目录：");
		labelfilename = new Label("播放文件：");
		panel.add(labelfilepath);
		panel.add(labelfilename);
		add(panel, "North");

		// 注册窗体关闭事件
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setVisible(true);
	}

	// 打开
	private void open() {
		FileDialog dialog = new FileDialog(this, "Open", 0);
		dialog.setVisible(true);
		filepath = dialog.getDirectory();
		if (filepath != null) {
			labelfilepath.setText("播放目录：" + filepath);

			// 显示文件列表
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

	// 播放
	private void play() {
		try {
			isStop = true;// 停止播放线程
			// 等待播放线程停止
			System.out.print("开始播放：" + filename);
			while (!hasStop) {
				System.out.print(".");
				try {
					Thread.sleep(10);
				} catch (Exception e) {
				}
			}
			System.out.println("");
			File file = new File(filepath + filename);
			labelfilename.setText("播放文件：" + filename);

			// 取得文件输入流
			audioInputStream = AudioSystem.getAudioInputStream(file);
			System.out.println(audioInputStream.getFrameLength());// -1
			audioFormat = audioInputStream.getFormat();
			// 转换mp3文件编码
			if (audioFormat.getEncoding() != AudioFormat.Encoding.PCM_SIGNED) {
				audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, audioFormat.getSampleRate(), 16, audioFormat.getChannels(), audioFormat.getChannels() * 2,
						audioFormat.getSampleRate(), false);
				audioInputStream = AudioSystem.getAudioInputStream(audioFormat, audioInputStream);
			}

			// 打开输出设备
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat, AudioSystem.NOT_SPECIFIED);
			sourceDataLine = (SourceDataLine) AudioSystem.getLine(info);
			sourceDataLine.open(audioFormat);
			sourceDataLine.start();

			// 创建独立线程进行播放
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
				// 读取数据到缓存数据
				while ((cnt = audioInputStream.read(tempBuffer, 0, tempBuffer.length)) != -1) {
					if (isStop)
						break;
					if (cnt > 0) {
						// 写入缓存数据
						sourceDataLine.write(tempBuffer, 0, cnt);
					}
				}
				// Block等待临时数据被输出为空
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