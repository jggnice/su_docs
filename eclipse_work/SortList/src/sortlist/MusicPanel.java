package sortlist;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import resources.MP3;
import resources.PIC;
/**
 * <p>描述:
 * <p>这个Panel用来播放音乐
 * <code>MusicPanel</code>
 * <p>
 * <tt>elements</tt>
 */
@SuppressWarnings("serial")
public class MusicPanel extends JPanel
{

	static AudioClip mp = Applet.newAudioClip(MP3.class
			.getResource("soundofsilence.wav"));
	ImageIcon openicon = new ImageIcon(
			PIC.class.getResource("open_easyicon.net.png"));
	ImageIcon stopicon = new ImageIcon(
			PIC.class.getResource("Stop_easyicon.net.png"));
	ImageIcon playicon = new ImageIcon(
			PIC.class.getResource("Play_easyicon.net.png"));
	/**
	 * <p>描述:
	 * <p>Create the panel.
	 * <p>构造函数
	 * @throws IOException
	 */
	public MusicPanel() throws IOException
	{
		setLayout(new GridLayout(0, 2, 0, 0));
		JButton btnChoose = new JButton("choose");
		btnChoose.setIcon(openicon);
		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					chooseMusicAction(arg0);
				} catch (MalformedURLException exception)
				{
					// TODO Auto-generated catch block
					exception.printStackTrace();
				}
			}
		});
		add(btnChoose);

		JButton btnStop = new JButton("stop");

		btnStop.setIcon(stopicon);
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				mp.stop();
			}
		});
		add(btnStop);

		JButton btnStart = new JButton("start");

		btnStart.setIcon(playicon);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				mp.loop();
			}
		});
		add(btnStart);

	}

	protected void chooseMusicAction(ActionEvent arg0)
			throws MalformedURLException
	{
		File fp = null;

		JFileChooser filechooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"*.au/*.mid/*.wav", "au","mid", "wav");
		filechooser.setFileFilter(filter);
		if (filechooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			fp = (filechooser.getSelectedFile());
			try
			{
				mp.stop();
				mp = Applet.newAudioClip(fp.toURI().toURL());
				mp.loop();
			} catch (Exception ecp)
			{
				System.out.println("mp3 not create");
			}
		}
		

	}

}
