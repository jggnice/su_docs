/**
 * 
 */
package com.b510.mp3.util;

import com.b510.mp3.common.Common;
import com.b510.mp3.ui.MainUI;

/**
 * @author Hongten
 * @created Jul 31, 2014
 */
public class MusicPlayThreadUtil extends Thread {

	byte[] tempBuffer = new byte[320];

	private MusicUtil musicUtil;
	private MainUI mainUI;

	public MusicPlayThreadUtil(MusicUtil musicUtil, MainUI mUI) {
		this.musicUtil = musicUtil;
		this.mainUI = mUI;
	}
	
	public static byte[] getByte320(){
		return new byte[320];
	}
	
	public static byte[] getByte0(){
		return new byte[0];
	}

	@Override
	public void run() {
		try {
			int cnt;
			musicUtil.hasStop = false;
			while ((cnt = musicUtil.audioInputStream.read(tempBuffer, 0, tempBuffer.length)) != -1) {
				if (musicUtil.isStop) {
					break;
				}
				if (cnt > 0) {
					musicUtil.sourceDataLine.write(tempBuffer, 0, cnt);
				}
				if(!MainUI.playing){
					tempBuffer = getByte0();
				}else{
					tempBuffer = getByte320();
				}
				System.out.println(tempBuffer.length);
			}
			if (cnt == -1) {
				mainUI.stopOperation();
				if (MainUI.play_mode_value == Common.REPEAT_ONCE_MODE_VALUE) {
					mainUI.playOperation();
				} else {
					mainUI.nextOperation();
				}
			}
			musicUtil.sourceDataLine.drain();
			musicUtil.sourceDataLine.close();
			musicUtil.hasStop = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
}
