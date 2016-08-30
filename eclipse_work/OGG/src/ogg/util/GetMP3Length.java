package ogg.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.TagException;

public class GetMP3Length
{
	//static URL mp3url = AudioFilePlayer.class.getResource("xx.mp3");
	//static File f = new File("D:/F_administer/Public/Music/bgm.mp3");
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception
	{

		//System.out.println(getSeconds(f));
	}
	public static int getSeconds(File fileurl) throws CannotReadException,
			IOException, TagException, ReadOnlyFileException,
			InvalidAudioFrameException
	{
		MP3File f = (MP3File) AudioFileIO.read(fileurl);
		MP3AudioHeader audioHeader = (MP3AudioHeader) f.getAudioHeader();
		return audioHeader.getTrackLength();

	}
//	public static int getSeconds(URL fileurl)
//	{
//		return Play(fileurl);
//	}
//
//	// ²¥·ÅÒôÆµÎÄ¼þ
//	public static int Play(URL fileurl)
//	{
//		int seconds = 29;
//		try
//		{
//			Format inMp3 = new AudioFormat(AudioFormat.MPEGLAYER3);
//			Format outLinear = new AudioFormat(AudioFormat.LINEAR);
//
//			PlugInManager.addPlugIn(
//					"com.sun.media.codec.audio.mp3.JavaDecoder",
//					new Format[]{inMp3}, new Format[]{outLinear},
//					PlugInManager.CODEC);
//			Player player = Manager.createPlayer(fileurl);
//			player.start();
//			Thread.sleep(500); // need
//
//			seconds = (int) player.getDuration().getSeconds();
//			// System.out.println("MediaTime:" + seconds);
//			// System.out.println("MediaTime:" + getTime(seconds));
//		} catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//		return seconds;
//	}
//	public static void Play(String fileurl)
//	{
//		try
//		{
//			Format inMp3 = new AudioFormat(AudioFormat.MPEGLAYER3);
//			Format outLinear = new AudioFormat(AudioFormat.LINEAR);
//
//			PlugInManager.addPlugIn(
//					"com.sun.media.codec.audio.mp3.JavaDecoder",
//					new Format[]{inMp3}, new Format[]{outLinear},
//					PlugInManager.CODEC);
//
//			File file = new File(fileurl);
//			Player player = Manager.createPlayer(file.toURI().toURL());
//			player.start();
//			Thread.sleep(500);
//
//			double seconds = player.getDuration().getSeconds();
//			System.out.println("MediaTime:" + seconds);
//			System.out.println("MediaTime:" + getTime(seconds));
//		} catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//	}

	public static String getTime(double time)
	{
		int millis = Integer.parseInt(String.valueOf(Math.round(time)));
		Calendar cal = Calendar.getInstance();
		cal.set(0, 0, 0, 0, 0, millis);

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(cal.getTime());
	}

}