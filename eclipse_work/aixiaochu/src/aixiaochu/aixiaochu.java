package aixiaochu;



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import resources.PIC;


public class aixiaochu extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7726551876542890523L;
	private fangkuaipanel fangkuai = new fangkuaipanel();
	private time time = new time(60);
	private ImageIcon mianzai = new ImageIcon(aixiaochu.class.getResource("mianzai.gif"));
	private ImageIcon imgstart = new ImageIcon(PIC.starticon);
	private ImageIcon imgstop = new ImageIcon(PIC.stopicon);
	private JButton jbtstart = new JButton(imgstart);
	private JButton jbtstopgame = new JButton(imgstop);
	private JTextField scoreshow = new JTextField("0", 5);

	private JLabel jbl1 = new JLabel(mianzai);
	private JLabel jbl2 = new JLabel(mianzai);
	private JPanel south = new JPanel(new GridLayout(1, 3, 50, 50));
	private JPanel north = new JPanel(new FlowLayout(FlowLayout.LEFT, 40, 5));
	
	Timer timer = new Timer(1000,new TimerListener());
	Timer timer2 = new Timer(100, new Timer2Listener());
	JFrame frame1 = new JFrame();
	gameover gameoverlabel = new gameover();
	public aixiaochu(){
	//	time.setFont(new Font("Serif", Font.BOLD, 30));
		setLayout(new BorderLayout(10, 5));
		fangkuai.enable(false);
		add(fangkuai,BorderLayout.CENTER);
		
		south.setPreferredSize(new Dimension(450, 60));
		//time.setPreferredSize(new Dimension(200, 60));
		south.add(jbl1);
		south.add(time);
		south.add(jbl2);
		jbtstart.addActionListener(new startActionListener());
		north.add(jbtstart);
		jbtstopgame.addActionListener(new stopgameActionListener());
		north.add(jbtstopgame);
		north.add(new JLabel("Score:"));
		scoreshow.setEditable(false);
		scoreshow.setHorizontalAlignment(JTextField.RIGHT);
		north.add(scoreshow);
		add(south, BorderLayout.SOUTH);
		add(north, BorderLayout.NORTH);
		frame1.setSize(300, 200);
		frame1.add(gameoverlabel);
		frame1.setLocationRelativeTo(null);
		frame1.setVisible(false);
		frame1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	class startActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			timer.start();
			timer2.start();
			fangkuai.enable(true);
			if(time.getT() == 0){
				time.setT(60);
				time.repaint();
				fangkuai.setScore(0);
				scoreshow.setText("" + fangkuai.getScore());
			}
		}
	}
	class stopgameActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			timer.stop();
			timer2.stop();
			fangkuai.enable(false);
		}
		}

	class TimerListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
		
			if(time.getT() > 0){
				time.setT(time.getT() - 1);
				time.repaint();
			}else{
				timer.stop();
				timer.stop();
				fangkuai.enable(false);
				scoreshow.setText("" + 0);
				frame1.setVisible(true);
				gameoverlabel.setS(fangkuai.getScore());
			}
	}
	}
	class Timer2Listener implements ActionListener{
		public void actionPerformed(ActionEvent e1){
			if(("" + fangkuai.getScore()) != scoreshow.getText()){
				scoreshow.setText("" + fangkuai.getScore());
			}
		}
	}


	public static void main(String[] args){
		JFrame frame = new JFrame();
		
		ImageIcon bg = new ImageIcon(PIC.background);
		JLabel lb = new JLabel(bg);
		
		frame.getLayeredPane().add(lb,new Integer(Integer.MIN_VALUE));
		lb.setBounds(0,72,516,538);
		JPanel content = (JPanel) frame.getContentPane();
		content.add(lb);
		content.setOpaque(false);
		JPanel p = new aixiaochu();
		p.setOpaque(true);
		
		frame.add(p);
		frame.setTitle("***消消天天乐***");
		frame.setSize(535,717);
	
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}	

}
