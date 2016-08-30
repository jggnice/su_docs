package resources;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PIC {
	public static BufferedImage redqq;
	public static BufferedImage birdqq;
	public static BufferedImage blueqq;
	public static BufferedImage yellowqq;
	public static BufferedImage whiteqq;
	public static BufferedImage brownqq;
	public static BufferedImage bombqq;
	public static BufferedImage greyqq;
	public static BufferedImage purpleqq;
	public static BufferedImage greenqq;
	public static BufferedImage redpp;
	public static BufferedImage bluepp;
	public static BufferedImage yellowpp;
	public static BufferedImage whitepp;
	public static BufferedImage brownpp;
	public static BufferedImage mousepoint;
	public static BufferedImage greypp;
	public static BufferedImage purplepp;
	public static BufferedImage greenpp;
	
	public static BufferedImage blackqq;
	public static BufferedImage blackpp;
	public static BufferedImage stopicon;
	public static BufferedImage starticon;
	public static BufferedImage openicon;

	public static BufferedImage gif1;
	public static BufferedImage gameover1;
	public static BufferedImage background;
	/*
	
	public static BufferedImage flowerPNG;
	public static BufferedImage gameoverPNG;
	public static BufferedImage congratulationPNG;*/
	static {
		try {
			birdqq = ImageIO.read(PIC.class
					.getResourceAsStream("bird.png"));
			redqq = ImageIO.read(PIC.class
					.getResourceAsStream("redqq.png"));
			whiteqq = ImageIO.read(PIC.class
					.getResourceAsStream("whiteqq.png"));
			bombqq = ImageIO.read(PIC.class
					.getResourceAsStream("bombqq.png"));
			blueqq = ImageIO.read(PIC.class
					.getResourceAsStream("blueqq.png"));
			blackqq = ImageIO.read(PIC.class
					.getResourceAsStream("blackqq.png"));
			blackpp = ImageIO.read(PIC.class
					.getResourceAsStream("blackqq.png"));
			brownqq = ImageIO.read(PIC.class
					.getResourceAsStream("brownqq.png"));
			greyqq = ImageIO.read(PIC.class
					.getResourceAsStream("greyqq.png"));
			purpleqq = ImageIO.read(PIC.class
					.getResourceAsStream("purpleqq.png"));
			greenqq = ImageIO.read(PIC.class
					.getResourceAsStream("greenqq.png"));
			yellowqq = ImageIO.read(PIC.class
					.getResourceAsStream("yellowqq.png"));
			redpp = ImageIO.read(PIC.class
					.getResourceAsStream("redpp.png"));
			whitepp = ImageIO.read(PIC.class
					.getResourceAsStream("whitepp.png"));
			mousepoint = ImageIO.read(PIC.class
					.getResourceAsStream("mousepoint.png"));
			bluepp = ImageIO.read(PIC.class
					.getResourceAsStream("bluepp.png"));
			brownpp = ImageIO.read(PIC.class
					.getResourceAsStream("brownpp.png"));
			greypp = ImageIO.read(PIC.class
					.getResourceAsStream("greypp.png"));
			purplepp = ImageIO.read(PIC.class
					.getResourceAsStream("purplepp.png"));
			greenpp = ImageIO.read(PIC.class
					.getResourceAsStream("greenpp.png"));
			yellowpp = ImageIO.read(PIC.class
					.getResourceAsStream("yellowpp.png"));
			
			
			stopicon = ImageIO.read(PIC.class
					.getResourceAsStream("Stop_easyicon.net.png"));

			starticon = ImageIO.read(PIC.class
					.getResourceAsStream("Play_easyicon.net.png"));
			openicon = ImageIO.read(PIC.class
					.getResourceAsStream("open_easyicon.net.png"));

			gif1 = ImageIO.read(PIC.class
					.getResourceAsStream("mianzai.gif"));
			gameover1 = ImageIO.read(PIC.class
					.getResourceAsStream("gameover1.png"));
			background = ImageIO.read(PIC.class
					.getResourceAsStream("bgm.png"));
		} catch (IOException e) {
			System.out.println("√ΩÃÂº”‘ÿ ß∞‹!");
			e.printStackTrace();
		}
	}
	
}
