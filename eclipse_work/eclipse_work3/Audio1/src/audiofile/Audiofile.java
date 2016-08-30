package audiofile;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.applet.*;
import java.net.MalformedURLException;
import java.net.URL;

@SuppressWarnings({ "unused", "serial" })
public class Audiofile extends JApplet {
	private final static int NUMBER_OF_NATIONS = 1;
	private int current = 0;
	private ImageIcon[] icons = new ImageIcon[NUMBER_OF_NATIONS];
	private AudioClip[] audioClips = new AudioClip[NUMBER_OF_NATIONS];
	private AudioClip currentAudioClip;

	private int[] delays = { 48000 };
	private Timer timer = new Timer(delays[0], new TimerListener());

	private JLabel jlblImageLabel = new JLabel();
	private JButton jbtResume = new JButton("Resume");
	private JButton jbtSuspend = new JButton("Suspend");
	private JComboBox<?> jcboNations = new JComboBox<Object>(
			new Object[] { "Denmark" });

	public Audiofile() throws MalformedURLException {
		// Load image icons and audio clips
		// must avoid null pointer

		for (int i = 0; i < NUMBER_OF_NATIONS; i++) {
			icons[i] = new ImageIcon(this.getClass().getResource(
					"audio_res/image/flag" + i + ".gif"));
			audioClips[i] = Applet.newAudioClip(this.getClass().getResource(
					"audio_res/audio/anthem" + i + ".mid"));
		}

		JPanel panel = new JPanel();
		panel.add(jbtResume);
		panel.add(jbtSuspend);
		panel.add(new JLabel("Select"));
		panel.add(jcboNations);
		add(jlblImageLabel, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);

		jbtResume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});
		jbtSuspend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stop();
			}
		});
		jcboNations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stop();
				current = jcboNations.getSelectedIndex();
				presentNation(current);
				timer.start();
			}
		});

		timer.start();
		jlblImageLabel.setIcon(icons[0]);
		jlblImageLabel.setHorizontalAlignment(JLabel.CENTER);
		currentAudioClip = audioClips[0];
		currentAudioClip.play();
	}

	private class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			current = (current + 1) % NUMBER_OF_NATIONS;
			presentNation(current);
		}
	}

	private void presentNation(int index) {
		jlblImageLabel.setIcon(icons[index]);
		jcboNations.setSelectedIndex(index);
		currentAudioClip = audioClips[index];
		currentAudioClip.play();
		timer.setDelay(delays[index]);
	}

	public void start() {
		timer.start();
		currentAudioClip.play();
	}

	public void stop() {
		timer.stop();
		currentAudioClip.stop();
	}

	/**
	 * Main method
	 * 
	 * @throws MalformedURLException
	 */
	public static void main(String[] args) throws MalformedURLException {
		// Create a frame
		JFrame frame = new JFrame("ImageAudioAnimation1");

		// Create an instance of the applet
		Audiofile applet = new Audiofile();
		applet.init();

		// Add the applet instance to the frame
		frame.getContentPane().add(applet, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Display the frame
		frame.setSize(400, 300);
		frame.setVisible(true);
	}
}
