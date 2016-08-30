package pac21;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


public class myblock extends JFrame {
    
	private static final long serialVersionUID = 1L;        
    public static void main(String[] args){
    	final JFrame frame = new JFrame("����˹���顣����");
    	final Tetrisblok a = new Tetrisblok();
        frame.addKeyListener(a);
        frame.add(a);
        final Timer timer = new Timer(400, a.new TimerListener());
        timer.start();
        JMenuBar menu = new JMenuBar();
        frame.setJMenuBar(menu);
        //������Ϸ�˵���
        JMenu gameMenu = new JMenu("��Ϸ��G��");
        JMenuItem newitem = new JMenuItem("����Ϸ��N��");
        gameMenu.add(newitem);
        final JMenuItem pauseitem = new JMenuItem("��ͣ��P��");
        gameMenu.add(pauseitem);
        JMenuItem contitem = new JMenuItem("������c��");
        gameMenu.add(contitem);
        JMenuItem exititem = new JMenuItem("�˳���E��");
        gameMenu.add(exititem);
        //��Ӽ�������ʵ����Ϸ�˵��ϵĸ����˵���Ĺ���,���������ڲ���
 	    //����Ϸ�˵���Ĺ���ʵ��
        newitem.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			a.newmap();
                a.drawwall();
                a.score = 0;
                a.x=4;
                a.y=-1;
                a.blockType=a.ran.nextInt(7);
                a.turnState=a.ran.nextInt(4);
                a.nextb=a.ran.nextInt(7);
                a.nextt=a.ran.nextInt(4);
    		}
        });
      //��ͣ�˵���Ĺ���ʵ��
        pauseitem.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			timer.stop();
    			pauseitem.setEnabled(false);
    		}
        });
      //�����˵���Ĺ���ʵ��
        contitem.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			timer.start();
    			pauseitem.setEnabled(true);
    		}
        });
      //�˳��˵���Ĺ���ʵ��
        exititem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				timer.stop();
				Object[] options = { "�ǵģ���Ҫ�˳�", "������˼�������" };
				int option = JOptionPane.showOptionDialog(null, "��ȷ��Ҫ�˳���",
						 "�˳���ʾ....",JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE,
						  null,options, options[0]);     
				 if(option == JOptionPane.OK_OPTION){
				 System.exit(0);
				 }
				 timer.start();
			}
			  
		   });
        //��������˵���
        JMenu helpMenu = new JMenu("������H��");
        JMenuItem aboutitem = new JMenuItem("������Ϸ��G��");
        helpMenu.add(aboutitem);
        JMenuItem writeitem = new JMenuItem("�������ߣ�W��");
        helpMenu.add(writeitem);
        helpMenu.addSeparator();
        JMenuItem adviitem = new JMenuItem("��Ϸ�Ҹ棨A��");
        helpMenu.add(adviitem);
      //��Ӽ�������ʵ�ְ����˵��ϵĸ����˵���Ĺ���,���������ڲ���
      //������Ϸ�˵���Ĺ���ʵ��
        aboutitem.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			timer.stop();
    			JOptionPane.showMessageDialog(frame,"����Ϸ�ɹ¶���Ұ��������\n����ҪԴ���룬��ʱ��ӭ��ϵ���ߣ�\n" +
						"�������䣺sunchuanhui212@126.com\nQQ�ţ�2442701497\n����Ϸ���ܻ���������ȫ�ģ�\n" +
						"�������ˡ���ͣ���������¿�ʼ���ȹ���  ...\nϣ����ϲ����\n" +
						"�����κ����ʼ������������ʱ��ӭָ����\n���ǽ�������Ŭ��������������\n" +
						"���лл����ʹ�ã�\n��Ȩ���У�������Ȩ��","������Ϸ...",JOptionPane.INFORMATION_MESSAGE);
    			timer.start();
    		}
        });
      //�������߲˵���Ĺ���ʵ��
        writeitem.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			timer.stop();
    			JOptionPane.showMessageDialog(frame,"���ߣ��¶���Ұ��\n�Ա���\n���᣺��������\n�����գ�1990��11��9��\n" +
						"����ԺУ���Ϻ�Ӧ�ü���ѧԺ\n�־ӵأ��Ϻ�\n���ҽ��ܣ���˧Ҳ����\nż�񣺰���˹̹\n" +
						"��ϲ���ĸ��֣�����\n�������ĵط�������\n�����������Դ������\n" +
						"                 �ڷ����ͻԻ�\n��ϲ���Ļ�����Ը���һ��ʯ�ţ��������紵����������\n" +
						"                          �������ɹ��ֻ����������߹�...\n" +
						"���룺����ж�����ж�����\n","��������...",JOptionPane.INFORMATION_MESSAGE);
    			timer.start();
    		}
        });
      //��Ϸ�Ҹ�˵���Ĺ���ʵ��
        adviitem.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			timer.stop();
    			JOptionPane.showMessageDialog(frame,"���Ʋ�����Ϸ , �ܾ�������Ϸ\n\nע�����ұ��� , ������ƭ�ϵ�\n\n" +
    					"�ʶ���Ϸ���� , ������Ϸ����\n\n������ʱ�� , ���ܽ�������\n","������Ϸ�Ҹ档����", JOptionPane.INFORMATION_MESSAGE);
    			timer.start();
    		}
        });
        menu.add(gameMenu);
        menu.add(helpMenu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(300,100,400,520);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}


// ����һ������˹������
class Tetrisblok extends JPanel implements KeyListener {
	private static final long serialVersionUID = 1L;
	Random ran = new Random(); //ʹ��Random������
    public int blockType; // blockType����������
    public int score = 0; //������
    public int turnState; // turnState������״̬
    public int x; //������ʼλ�õĺ�����
    public int y; //������ʼλ�õ�������
    public int nextb = ran.nextInt(7); //��һ���������ͣ�
    public int nextt = ran.nextInt(4); //��һ���������״��
    private int i = 0;
    private int j = 0;
    private boolean flag = false;
    int[][] map = new int[13][23];
    Tetrisblok(){ 
        newblock();
        newmap();
        drawwall();
    }
    //��һ����������״��������״������S��Z��L��J��I��O��T 7��
    //�ڶ����������ת���� 
    //��������Ϊ�������
    private final int shapes[][][] = new int[][][] {
            // ���ͷ���
            { { 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 },
                    { 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 } },
            // s�ͷ���
            { { 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
                    { 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 } },
            // z�ͷ���
            { { 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
                    { 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 } },
            // ��l�ͷ���
            { { 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                    { 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
                    { 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 } },
            // ���ͷ���
            { { 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } },
            // ��l�ͷ���
            { { 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                    { 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 } },
            // t�ͷ���
            { { 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
                    { 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 } } };

    // �����·���ķ���
    public void newblock(){ 
    	blockType = nextb;
    	turnState = nextt;
        nextb = ran.nextInt(7); 
        nextt = ran.nextInt(4);
        x = 4;
        y = 0;
        if (gameover(x, y)){
        	JOptionPane.showMessageDialog(null,"������˼����Ϸ���������ٽ�������");
        	newmap();
            drawwall();
            score = 0;
        }
    }
    
    
    // �ж���Ϸ�����ķ���
    public boolean gameover(int x, int y){
        if (blow(x, y, blockType, turnState)){
            return true;
        }else{
            return false;
        }
    }
    
    // �Ƿ�Ϸ��ķ���
    public boolean blow(int x, int y, int blockType, int turnState){
        for (int a = 0; a < 4; a++) {
            for (int b = 0; b < 4; b++){
                if (((shapes[blockType][turnState][a * 4 + b] == 1) && (map[x+ b + 1][y + a] == 1))
                        || ((shapes[blockType][turnState][a * 4 + b] == 1) && (map[x+ b + 1][y + a] == 2))){
                          return true;
                }
            }
        }
        return false;
    }
    
    // ��ʼ����ͼ
    public void newmap(){
        for (i = 0; i < 12; i++){
            for (j = 0; j < 22; j++){
                map[i][j] = 0;
            }
        }
    }
    
    // ��Χǽ
    public void drawwall(){
        for (i = 0; i < 12; i++){
            map[i][21] = 2;
        }
        for (j = 0; j < 22; j++){
            map[11][j] = 2;
            map[0][j] = 2;
        }
    }

    // ��ת�ķ���
    public void turn(){
        int tempturnState = turnState;
        turnState = (turnState + 1) % 4;
        if (!blow(x, y, blockType, turnState)){
        }
        if (blow(x, y, blockType, turnState)){
            turnState = tempturnState;
        }
        repaint();
    }

    // ���Ƶķ���
    public void left(){
        if (!blow(x - 1, y, blockType, turnState)) {
            x = x - 1;
        }
        repaint();
    }

    // ���Ƶķ���
    public void right(){
        if (!blow(x + 1, y, blockType, turnState)){
            x = x + 1;
        }
        repaint();
    }

    // ����ķ���
    public void down(){
        if (!blow(x, y + 1, blockType, turnState)){
            y = y + 1;
        }
        if (blow(x, y + 1, blockType, turnState)){
            add(x, y, blockType, turnState);
            newblock(); 
        }
        delline();
        repaint();
    }



    // ���еķ���
    public void delline(){
        int c = 0;
        int i = 0;  //i����ȷ���������˼���
        for (int b = 0; b < 22; b++){
            for (int a = 0; a < 12; a++){
                if (map[a][b] == 1){
                    c = c + 1;
                    if (c == 10) {
                    	i = i + 1;
                        for (int d = b; d > 0; d--) {
                            for (int e = 0; e < 11; e++) {
                                map[e][d] = map[e][d - 1];
                            }
                        }
                    }
                }
            }
            c = 0;
        }
        //ȷ�����з���
        switch (i) {
            case 1:
            	score = score +1;
            	break;
            case 2:
            	score = score +3;
            	break;
            case 3:
            	score = score +6;
            	break;
            case 4:
            	score = score +10;
            	break;
            default:
            	break;
        }
    }



    // �ѵ�ǰ���map
    public void add(int x, int y, int blockType, int turnState) {
        int j = 0;
        for (int a = 0; a < 4; a++){
            for (int b = 0; b < 4; b++){
                if (map[x + b + 1][y + a] == 0){
                    map[x + b + 1][y + a] = shapes[blockType][turnState][j];
                }
                j++;
            }
        }
    }

    // ������ĵķ���
    public void paintComponent(Graphics g){
    	//Object[] yanse = {"BLUE","GREEN","LIGHT_GRAY","YELLOW","PINK"};
        super.paintComponent(g);
        // ����ǰ����
        for (j=0;j<16;j++){
            if (shapes[blockType][turnState][j]==1){
            	//����������
            	g.setColor(Color.BLUE);
                g.fill3DRect((j%4+x+1)*20,(j/4+y)*20,20,20,true);
            	g.setColor(Color.BLACK);
                g.draw3DRect((j%4+x+1)*20,(j/4+y)*20,20,20, true);

            }
        }
        //����һ������
        for (j = 0; j < 16; j++){
            if (shapes[nextb][nextt][j] == 1){
            	g.setColor(Color.BLUE);
                g.fill3DRect((j%4+1)*20+250,(j/4)*20+40, 20, 20,true);
            	g.setColor(Color.BLACK);
                g.draw3DRect((j%4+1)*20+250,(j/4)*20+40, 20, 20, true);

            }
        }
        // ���Ѿ��̶��ķ���
        for (j = 0; j < 22; j++){
            for (i = 0; i < 12; i++){
            	if (map[i][j]==2){ //��Χǽ
                	g.setColor(Color.BLACK);
                    g.fill3DRect(i*20,j*20,20,20,true);
                    g.setColor(Color.WHITE);
                    g.draw3DRect(i*20,j*20,20,20,true);
                }
                if (map[i][j]==1){ //���̶��ķ���
                	g.setColor(Color.GREEN);
                    g.fill3DRect(i*20,j*20,20,20,true);
                	g.setColor(Color.BLACK);
                    g.draw3DRect(i*20,j*20,20,20,true);
                }
                
            }
        }
        g.setColor(Color.black);
        g.drawString("score = "+score,250,10);
        g.setColor(Color.RED);
        g.drawString("��һ�����飺",250,30);
    }

    // ���̼���
    public void keyPressed(KeyEvent e){
        switch (e.getKeyCode()){
        case KeyEvent.VK_DOWN:
            down();
            break;
        case KeyEvent.VK_SPACE:
            turn();
            break;
        case KeyEvent.VK_RIGHT:
            right();
            break;
        case KeyEvent.VK_LEFT:
            left();
            break;
        default:
            	break;
        }
    }

    //�������Ա�������
    public void keyReleased(KeyEvent e){
    	
    }

    //�������Ա�������
    public void keyTyped(KeyEvent e){
    	
    }

    // ��ʱ������
    class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            repaint();
            if (!blow(x,y+1,blockType,turnState)){
                y=y+1;
                delline();
            }

            if (blow(x, y+1, blockType,turnState)){
                if (flag == true) {
                    add(x,y,blockType,turnState);
                    delline();
                    newblock();
                    flag = false;
                }
                flag = true;
            }
        }
    }
}

