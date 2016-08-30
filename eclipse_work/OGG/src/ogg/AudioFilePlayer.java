package ogg;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.TimerTask;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.TagException;

import ogg.util.GetMP3Length;

public class AudioFilePlayer
{
	URL mp3url = AudioFilePlayer.class.getResource("xueren.mp3");
	int loopinterval = 60 * 1000;
	/**
	 * @return the loopinterval
	 */
	public int getLoopinterval()
	{
		return loopinterval;
	}
	/**
	 * @param loopinterval
	 *            the loopinterval to set
	 */
	public void setLoopinterval(int loopinterval)
	{
		this.loopinterval = loopinterval * 1000;
	}
	/**
	 * @return the mp3url
	 */
	public URL getMp3url()
	{
		return mp3url;
	}
	/**
	 * @param mp3url
	 *            the mp3url to set
	 */
	public void setMp3url(URL mp3url)
	{
		this.mp3url = mp3url;
	}
	java.util.Timer timer;
	java.util.Timer timerforswitch = new java.util.Timer(true);
	boolean isplaying = false;
	boolean loopstarted = false;
	Thread t;

	public void loop()
	{
		if (loopstarted)
			return;
		loopstarted = true;
		timer = new java.util.Timer(true);
		timer.schedule(new LoopTask(), 0, loopinterval);
	}
	public void stoploop()
	{
		if (!loopstarted)
			return;
		loopstarted = false;
		timer.cancel();
		if (isplaying)
			try
			{
				stop();
			} catch (InterruptedException exception)
			{
			}
	}
	public void musicswitch() throws InterruptedException
	{
		if (isplaying)
			stop();
		else
			start();

	}
	public void loopmusicswitch() throws InterruptedException
	{
		timerforswitch.schedule(new LoopSwitchTask(), 100);

	}
	public void play(URL url)
	{
		try
		{
			final AudioInputStream in = AudioSystem.getAudioInputStream(url);
			final AudioFormat outFormat = getOutFormat(in.getFormat());
			final DataLine.Info info = new DataLine.Info(SourceDataLine.class,
					outFormat);

			final SourceDataLine line = (SourceDataLine) AudioSystem
					.getLine(info);

			if (line != null)
			{
				line.open(outFormat);
				line.start();
				stream(AudioSystem.getAudioInputStream(outFormat, in), line);
				line.drain();
				line.stop();
			}

		} catch (Exception e)
		{
			throw new IllegalStateException(e);
		}
	}
	public void play(String filePath) throws MalformedURLException
	{
		play(new File(filePath).toURI().toURL());
	}

	/*
	 * public void play(String filePath) { final File file = new File(filePath);
	 * 
	 * try {
	 * 
	 * final AudioInputStream in = AudioSystem.getAudioInputStream(file);
	 * 
	 * final AudioFormat outFormat = getOutFormat(in.getFormat()); final
	 * DataLine.Info info = new DataLine.Info(SourceDataLine.class, outFormat);
	 * 
	 * final SourceDataLine line = (SourceDataLine) AudioSystem .getLine(info);
	 * 
	 * if (line != null) { line.open(outFormat); line.start();
	 * stream(AudioSystem.getAudioInputStream(outFormat, in), line);
	 * line.drain(); line.stop(); }
	 * 
	 * } catch (Exception e) { throw new IllegalStateException(e); } }
	 */

	private AudioFormat getOutFormat(AudioFormat inFormat)
	{
		final int ch = inFormat.getChannels();
		final float rate = inFormat.getSampleRate();
		return new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, rate, 16, ch,
				ch * 2, rate, false);
	}

	private void stream(AudioInputStream in, SourceDataLine line)
			throws IOException
	{
		final byte[] buffer = new byte[65536 * 16];
		for (int n = 0; n != -1; n = in.read(buffer, 0, buffer.length))
		{
			line.write(buffer, 0, n);
		}
	}
	private void start()
	{
		if (isplaying)
			return;
		isplaying = !isplaying;
		t = new Thread(new Runnable() {
			public void run()
			{
				play(mp3url);
			}
		});

		t.start();
	}
	@SuppressWarnings({"deprecation"})
	private void stop() throws InterruptedException
	{
		if (!isplaying)
			return;
		isplaying = !isplaying;
		t.stop();
	}
	class LoopTask extends TimerTask
	{
		public void run()
		{
			try
			{
				stop();
				start();
			} catch (InterruptedException exception)
			{
			}

		}
	}
	class LoopSwitchTask extends TimerTask
	{
		public void run()
		{
			if (isplaying)
				stoploop();
			else
				loop();
		}
	}
	public void chooseFile() throws IOException
	{

		JFileChooser filechooser = new JFileChooser();
		// FileNameExtensionFilter filter = new
		// FileNameExtensionFilter("*.mp3/*.wav","mp3","wav");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.mp3",
				"mp3");
		filechooser.setFileFilter(filter);
		if (filechooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			File file = (filechooser.getSelectedFile());
			setMp3url(file.toURI().toURL());
			try
			{
				filelength_in_second = GetMP3Length.getSeconds(file);
				setLoopinterval(filelength_in_second);
				loopmusicswitch();
				loopmusicswitch();
				mp3panel.setTxtTime(getFilelength_in_second());
			} catch (InterruptedException exception)
			{
				// TODO Auto-generated catch block
				exception.printStackTrace();
			} catch (CannotReadException exception)
			{
				// TODO Auto-generated catch block
				exception.printStackTrace();
			} catch (TagException exception)
			{
				// TODO Auto-generated catch block
				exception.printStackTrace();
			} catch (ReadOnlyFileException exception)
			{
				// TODO Auto-generated catch block
				exception.printStackTrace();
			} catch (InvalidAudioFrameException exception)
			{
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
		}
	}
	public void showDialog()
	{
		mp3panel.setOpaque(false);
		JDialog jd = new JOptionPane(mp3panel).createDialog(null, "±≥æ∞“Ù¿÷∂‘ª∞øÚ");
		jd.setResizable(true);
		jd.setSize(792, 477);
		jd.setLocation(50, 40);
		jd.setResizable(false);
		jd.setVisible(true);
		
	}
	final MP3DialogPanel mp3panel = new MP3DialogPanel();
	int filelength_in_second = 30;
	/**
	 * @return the filelength_in_second
	 */
	public int getFilelength_in_second()
	{
		return filelength_in_second;
	}
}
