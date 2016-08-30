package time;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

import javax.swing.JFrame;

import resources.MP3;

public class TestTime
{

	public TestTime()
	{
		super();
		fun();
	}
	static int timecoumt = 0;
	static java.util.Timer timer;
	public static void main(String[] args)
	{
		TestTime.timecoumt = 0;
		TestTime t1 = new TestTime();
		JFrame f = new JFrame();
		f.setVisible(true);// 关键代码,使得程序生命周期变长

	}
	public void fun()
	{

		timer = new java.util.Timer(true);
		timer.schedule(new MyTimerTask(), 0, 100);
		timer.schedule(new MyTimerTask2(), 0, 200);
		// if(TestTime.timecoumt>10)控制失败,无法按条件启动
		timer.schedule(new MyTimerTask3(), 5000);

	}
	public void fun2()
	{

		javax.swing.Timer timer = new javax.swing.Timer(100,
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0)
					{
						System.out.println("checking");

					}
				});
		timer.start();

	}

}
class MyTimerTask extends TimerTask
{
	
	public void run()
	{
		// TODO Auto-generated method stub
		TestTime.timecoumt++;
		if (TestTime.timecoumt < 15)
		{
			System.out.println("Synchro data to other servers.");
			Applet.newAudioClip(MP3.class.getResource("clear.wav")).play();
			
		}
	}

}
class MyTimerTask2 extends TimerTask
{

	public void run()
	{
		// TODO Auto-generated method stub
		System.out.println("droping");
	}

}
class MyTimerTask3 extends TimerTask
{

	public void run()
	{
		TestTime.timer.cancel();
	}

}
class CheckTask extends TimerTask
{

	public void run()
	{
		TestTime.timer.cancel();
	}

}
class BlowTask extends TimerTask
{

	public void run()
	{
		TestTime.timer.cancel();
	}

}
class ClearTask extends TimerTask
{

	public void run()
	{
		TestTime.timer.cancel();
	}

}
class DropTask extends TimerTask
{

	public void run()
	{
		TestTime.timer.cancel();
	}

}