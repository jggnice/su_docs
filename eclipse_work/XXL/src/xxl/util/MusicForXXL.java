package xxl.util;

import java.applet.Applet;
import java.applet.AudioClip;

import ogg.MP3DialogPanel;
import resources.MP3;

public class MusicForXXL
{
	public static void musicswitch() throws InterruptedException
	{
		MP3DialogPanel.getPlayer().loopmusicswitch();
		music_off = !music_off;
	}
	public static void loginswitch()
	{
	}
	static boolean music_off = false;
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
	static AudioClip musicalarm = Applet.newAudioClip(MP3.class
			.getResource("alarm.wav"));
	/*
	 * static AudioClip musicbgm = Applet.newAudioClip(MP3.class
	 * .getResource("bgm.wav"));
	 */
	Thread t;
	static AudioClip musicbgm;
	public static void playalarm()
	{
		// if (!music_off)
		musicalarm.play();
	}
	public static void playselect()
	{
		// if (!music_off)
		musicselect.play();
	}
	public static void playreadygo()
	{
		// if (!music_off)
		musicreadygo.play();
	}
	public static void playtimeisup()
	{
		// if (!music_off)
		musictimeisup.play();
	}
	public static void playcancel()
	{
		// if (!music_off)
		musiccancel.play();
	}
	public static void playclear()
	{
		// if (!music_off)
		musicclear.play();

	}
	public static void playbgm()
	{
		if (!music_off)
			musicbgm.loop();
		else
			musicbgm.stop();
	}
}
