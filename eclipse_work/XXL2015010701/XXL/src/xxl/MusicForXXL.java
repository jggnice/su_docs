package xxl;

import java.applet.Applet;
import java.applet.AudioClip;

import resources.MP3;

public class MusicForXXL
{
	public static void playselect()
	{
		if (!music_off)
			musicselect.play();
	}
	public static void playreadygo()
	{
		if (!music_off)
			musicreadygo.play();
	}
	public static void playtimeisup()
	{
		if (!music_off)
			musictimeisup.play();
	}
	public static void playcancel()
	{
		if (!music_off)
			musiccancel.play();
	}
	public static void playclear()
	{
		if (!music_off)
		new Thread(new Runnable() {
			public void run()
			{
				Applet.newAudioClip(MP3.class.getResource("clear.wav")).play();
			}
		}).start();
	}
	public static void playbgm()
	{
		if (!music_off)
			musicbgm.loop();
		else musicbgm.stop();
	}
	public static void musicswitch()
	{
		music_off = !music_off;
		playbgm();
	}
	public static void loginswitch()
	{
	}
	static boolean music_off = true;
	static AudioClip musicselect = Applet.newAudioClip(MP3.class
			.getResource("select.wav"));
	static AudioClip musicreadygo = Applet.newAudioClip(MP3.class
			.getResource("readygo.wav"));
	static AudioClip musictimeisup = Applet.newAudioClip(MP3.class
			.getResource("timeisup.wav"));
	static AudioClip musiccancel = Applet.newAudioClip(MP3.class
			.getResource("cancel.wav"));
	static AudioClip musicclear = Applet.newAudioClip(MP3.class
			.getResource("clear.wav"));
	static AudioClip musicbgm = Applet.newAudioClip(MP3.class
			.getResource("bgm.wav"));
}
