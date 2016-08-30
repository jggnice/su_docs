package pac21;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;



class Bomb extends JButton { 
	private static final long serialVersionUID = 1L;
public int num_x,num_y; //�ڼ��ŷ��� 
public int BombRoundCount; //��Χ���� 
public boolean isBomb; //�Ƿ�Ϊ�� 
public boolean isClicked; //�Ƿ񱻵�� 
public int BombFlag; //̽�ױ�� 
public boolean isRight; //�Ƿ����Ҽ� 

public Bomb(int x,int y) { 
BombFlag = 0; 
num_x = x; 
num_y = y; 
BombRoundCount = 0; 
isBomb = false; 
isClicked = false; 
isRight = false; 
} 
} 
/*���ڼ��㷨ʵ����*/ 

class MainBomb extends JFrame implements ActionListener,MouseListener { 
	private static final long serialVersionUID = 1L;
public JTextField text; 
public Label nowBomb,setBomb; 
public int BlockNum,BombNum; //��ǰ��������ǰ���� 
public Icon icon_bomb = new ImageIcon("Bomb.gif"); //���� 
public Icon icon_bomb_big = new ImageIcon("bomb_big.gif"); //���ױ�� 
public Icon icon_flag = new ImageIcon("flag.gif"); //�ױ�� 
public Icon icon_question = new ImageIcon("question.gif"); //�ɻ��Ƿ����� 
public JButton start = new JButton(" ��ʼ "); 
public Panel MenuPamel = new Panel(); 
public Panel mainPanel = new Panel(); 
public Bomb[][] bombButton; 

/*�������*/ 

public MainBomb() 
{ 
super("ɨ�� �¶���Ұ������ 2004.8 "); 
BlockNum = 64; 
BombNum = 10; 
Container c=getContentPane(); 
c.setBackground(Color.gray); 
c.setLayout(new BorderLayout()); 
text=new JTextField("10 ",3); 
nowBomb = new Label("��ǰ����"+" "+BombNum+""); 
setBomb= new Label("���õ�����"); 
start.addActionListener(new ActionListener(){ 
public void actionPerformed(ActionEvent e) 
{ 
BombNum = Integer.parseInt(text.getText().trim()); 
if(BombNum >= 10 && BombNum < 50 ) 
replay(); 
else { 
                new JOptionPane(); 
JOptionPane.showMessageDialog(null,"�����õĵ�����̫����,������!","����",2); 
} 

} 
} ); 
MenuPamel.add(setBomb); 
MenuPamel.add(text); 
MenuPamel.add(start); 
MenuPamel.add(nowBomb); 
c.add(MenuPamel,"North"); 

mainPanel.setLayout(new GridLayout( (int)Math.sqrt(BlockNum) , (int)Math.sqrt(BlockNum)) ); 
bombButton=new Bomb[ (int)Math.sqrt(BlockNum) ][]; 
for(int i = 0 ; i < (int)Math.sqrt(BlockNum) ; i++) { 
          bombButton[ i ]=new Bomb[ (int)Math.sqrt(BlockNum) ]; 
} 
for(int i = 0 ; i < (int)Math.sqrt(BlockNum) ; i++ ) 
for(int j = 0 ; j < (int)Math.sqrt(BlockNum) ; j++ ) 
{ 
bombButton[ i ][ j ]=new Bomb(i,j); 
bombButton[ i ][ j ].setForeground( Color.gray); 
bombButton[ i ][ j ].addActionListener(this); 
bombButton[ i ][ j ].addMouseListener(this); 
} 
for(int i = 0 ; i < (int)Math.sqrt(BlockNum) ; i++ ) 
for(int j = 0 ; j < (int)Math.sqrt(BlockNum) ; j++ ) 
mainPanel.add(bombButton[ i ][ j ]); 
c.add(mainPanel,"Center"); 
startBomb(); 
setSize(400,400); 
setLocation(350,200); 
setResizable(false); 
} 

/*����*/ 

public void startBomb() 
{ 

for(int i=0;i<BombNum;i++) 
{ 
int x =(int)(Math.random()*(int)(Math.sqrt(BlockNum)-1)); 
int y =(int)(Math.random()*(int)(Math.sqrt(BlockNum)-1)); 

if(bombButton[ x ][ y ].isBomb==true) 
i--; 
else 
bombButton[ x ][ y ].isBomb=true ; 
} 
} 

/*���¿�ʼ*/ 

public void replay() 
{ 
nowBomb.setText("��ǰ����"+" "+BombNum+""); 
for(int i = 0 ; i < (int)Math.sqrt(BlockNum) ; i++) 
for(int j = 0 ; j < (int)Math.sqrt(BlockNum) ; j++) 
{ 
bombButton[ i ][ j ].isBomb=false; 
bombButton[ i ][ j ].isClicked=false; 
bombButton[ i ][ j ].setEnabled(true); 
bombButton[ i ][ j ].setText(""); 
bombButton[ i ][ j ].setIcon(null); 
} 
startBomb(); 
} 

public void isWin() 
{ 
int findBomb=0; //�ҵ��ĵ����� 

for(int i = 0;i < (int)Math.sqrt(BlockNum) ; i++) 
for(int j = 0;j < (int)Math.sqrt(BlockNum ); j++) 
{ 
if(bombButton[ i ][ j ].isBomb == true && bombButton[ i ][ j ].isRight == true) 
findBomb++; 
} 
if( findBomb == Integer.parseInt(text.getText().trim()) ) 
{ 
          new JOptionPane(); 
JOptionPane.showMessageDialog(this,"�����������е��ף���ʤ����!","��ʤ����",2); 
} 
} 
public void CountRoundBomb() 
{ 
for (int i = 0; i < (int)Math.sqrt(BlockNum); i++) { 
for (int j = 0; j < (int)Math.sqrt(BlockNum); j++) { 
int count = 0; 
//����Ҫ���ĵ�Ԫ�����޵��׵������,ͳ����Χ�ĵ��׸��� 
if (bombButton[ i ][ j ].isBomb != true) { 
if ( (i - 1 >= 0) && (j - 1 >= 0)) { 
if (bombButton[i - 1][j - 1].isBomb == true) { 
count += 1; //������Ϸ��ո��Ƿ��ǵ��� 
} 
} 
if ( (i - 1 >= 0)) { 
if (bombButton[i - 1][ j ].isBomb == true) { 
count += 1; //����Ϸ��ո��Ƿ�Ϊ���� 
} 
} 
if ( (i - 1 >= 0) && (j + 1 <= (int)Math.sqrt(BlockNum)-1)) { 
if (bombButton[i - 1][j + 1] .isBomb == true) { 
count += 1; //������Ϸ��Ƿ�Ϊ���� 
} 
} 
if ( (j - 1 >= 0)) { 
if (bombButton[ i ][j - 1] .isBomb == true) { 
count += 1; //�������Ƿ�Ϊ���� 
} 
} 
if ( (i >= 0) && (j + 1 <= (int)Math.sqrt(BlockNum)-1)) { 
if (bombButton[ i ][j + 1].isBomb == true) { 
count += 1; //�ұ� 
} 
} 
if ( (j - 1 >= 0) && (i + 1 <= (int)Math.sqrt(BlockNum)-1)) { 
if (bombButton[i + 1][j - 1].isBomb == true) { 
count += 1; //���� 
} 
} 
if ( (i + 1 <= (int)Math.sqrt(BlockNum)-1)) { 
if (bombButton[i + 1][ j ].isBomb == true) { 
count += 1; //�� 
} 
} 
if ( (j + 1 <= (int)Math.sqrt(BlockNum)-1) && (i + 1 <= Math.sqrt(BlockNum)-1)) { 
if (bombButton[i + 1][j + 1].isBomb == true) { 
count += 1; //���� 
} 
} 
bombButton[ i ][ j ].BombRoundCount = count; 
} 
} 
} 
} 

/**��ѡ�е�λ��Ϊ��,�򷭿���Χ�ĵ�ͼ**/ 

public void isNull(Bomb[][] bombButton,Bomb ClickecButton) 
{ 
int i,j; 
i=ClickecButton.num_x; 
j=ClickecButton.num_y; 

if (ClickecButton.isBomb==true) { 

} 
else { 

if ( (i - 1 >= 0) && (j - 1 >= 0)) { //������Ϸ��ո��Ƿ��ǿ� 
if (bombButton[i - 1][j - 1].isBomb == false && bombButton[i - 1][j - 1].isClicked == false && bombButton[i - 1][j - 1].isRight == false) { 
bombButton[i - 1][j - 1].setText((bombButton[i - 1][j - 1].BombRoundCount)+""); 
bombButton[i - 1][j - 1].setEnabled(false); 
bombButton[i - 1][j - 1].isClicked=true; 
} 
} 

if ( (i - 1 >= 0)) { //����Ϸ��ո��Ƿ�Ϊ�� 
if (bombButton[i - 1][ j ] .isBomb == false && bombButton[i - 1][ j ].isClicked == false && bombButton[i - 1][ j ].isRight == false) { 
bombButton[i - 1][ j ].setText((bombButton[i - 1][ j ].BombRoundCount)+""); 
bombButton[i - 1][ j ].setEnabled(false); 
bombButton[i - 1][ j ].isClicked=true; 
} 
} 
if ( (i - 1 >= 0) && (j + 1 <= ((int)Math.sqrt(BlockNum)-1)) ) { //������Ϸ��Ƿ�Ϊ�� 
if (bombButton[i - 1][j + 1] .isBomb == false && bombButton[i - 1][j + 1].isClicked == false && bombButton[i - 1][j + 1].isRight == false) { 
bombButton[i - 1][j + 1].setText((bombButton[i - 1][j + 1].BombRoundCount)+""); 
bombButton[i - 1][j + 1].setEnabled(false); 
bombButton[i - 1][j + 1].isClicked=true; 
} 

} 
if ( (j - 1 >= 0)) { //�������Ƿ�Ϊ�� 
if (bombButton[ i ][j - 1].isBomb == false && bombButton[ i ][j - 1].isClicked == false && bombButton[ i ][j - 1].isRight == false) { 
bombButton[ i ][j - 1].setText((bombButton[ i ][j - 1].BombRoundCount)+""); 
bombButton[ i ][j - 1].setEnabled(false); 
bombButton[ i ][j - 1].isClicked=true; 
} 

} 
if ( (i >= 0) && (j + 1 <= ((int)Math.sqrt(BlockNum)-1)) ) { //����ұ߿ո��Ƿ��ǿ� 
if (bombButton[ i ][j + 1].isBomb == false && bombButton[ i ][j + 1].isClicked == false && bombButton[ i ][j + 1].isRight == false) { 
bombButton[ i ][j + 1].setText((bombButton[ i ][j + 1].BombRoundCount)+""); 
bombButton[ i ][j + 1].setEnabled(false); 
bombButton[ i ][j + 1].isClicked=true; 
} 
} 
if ( (j - 1 >= 0) && (i + 1 <= ((int)Math.sqrt(BlockNum)-1)) ) { //������¿ո��Ƿ��ǿ� 
if (bombButton[i + 1][j - 1].isBomb == false && bombButton[i + 1][j - 1].isClicked == false && bombButton[i + 1][j - 1].isRight == false) { 
bombButton[i + 1][j - 1].setText((bombButton[i + 1][j - 1].BombRoundCount)+""); 
bombButton[i + 1][j - 1].setEnabled(false); 
bombButton[i + 1][j - 1].isClicked=true; 
} 
} 
if ( (i + 1 <= ((int)Math.sqrt(BlockNum)-1)) ) { //����±߿ո��Ƿ��ǿ� 
if (bombButton[i + 1][ j ].isBomb == false && bombButton[i + 1][ j ].isClicked == false && bombButton[i + 1][ j ].isRight == false) { 
bombButton[i + 1][ j ].setText((bombButton[i + 1][ j ].BombRoundCount)+""); 
bombButton[i + 1][ j ].setEnabled(false); 
bombButton[i + 1][ j ].isClicked=true; 
} 
} 
if ( (j + 1 <= ((int)Math.sqrt(BlockNum)-1) ) && (i + 1 <= ((int)Math.sqrt(BlockNum)-1)) ) { //������±߿ո��Ƿ��ǿ� 
if (bombButton[i + 1][j + 1].isBomb == false && bombButton[i + 1][j + 1].isClicked == false && bombButton[i + 1][j + 1].isRight == false) { 
bombButton[i + 1][j + 1].setText((bombButton[i + 1][j + 1].BombRoundCount)+""); 
bombButton[i + 1][j + 1].setEnabled(false); 
bombButton[i + 1][j + 1].isClicked=true; 
} 
} 
if ( (i - 1 >= 0) && (j - 1 >= 0))//������� 
isNull(bombButton,bombButton[i - 1][j - 1]); 
if ( (i - 1 >= 0)) 
isNull( bombButton,bombButton[i - 1][ j ]);//����Ϸ� 
if ( (i - 1 >= 0) && (j + 1 <= (int)Math.sqrt(BlockNum)-1)) 
isNull( bombButton,bombButton[i - 1][j + 1]);//������� 
if ( (j - 1 >= 0)) 
isNull(bombButton,bombButton[i][j - 1]);//������ 
if ( (i >= 0) && (j + 1 <= ((int)Math.sqrt(BlockNum)-1)) ) 
     isNull(bombButton,bombButton[i][j + 1]);//����ұ� 
if ( (j - 1 >= 0) && (i + 1 <= ((int)Math.sqrt(BlockNum)-1)) ) 
isNull(bombButton,bombButton[i + 1][j - 1]); //������� 
if ( (i + 1 <= ((int)Math.sqrt(BlockNum)-1)) ) //����� 
isNull(bombButton,bombButton[i + 1][ j ]); 
if ( (j + 1 <= ((int)Math.sqrt(BlockNum)-1)) && (i + 1 <= ((int)Math.sqrt(BlockNum)-1)) ) //������� 
isNull(bombButton,bombButton[i + 1][j + 1]); 

} 
} 

public void actionPerformed(ActionEvent e) 
{ 

CountRoundBomb(); 

if(((Bomb)e.getSource()).isBomb==false && ((Bomb)e.getSource()).isClicked == false) 
{ 
((Bomb)e.getSource()).setText(( ((Bomb)e.getSource()).BombRoundCount )+""); 
((Bomb)e.getSource()).isClicked=true; 
((Bomb)e.getSource()).setIcon(null); 
((Bomb)e.getSource()).setEnabled(false); 
if((((Bomb)e.getSource()).BombRoundCount) == 0) 
isNull(bombButton,(Bomb)e.getSource()); 
isWin(); 
} 
else if(((Bomb)e.getSource()).isBomb == true) 
{ 

for(int i=0;i<(int)Math.sqrt(BlockNum);i++) 
for(int j=0;j<(int)Math.sqrt(BlockNum);j++) 
{ 
if(bombButton[ i ][ j ].isBomb == true) 
bombButton[ i ][ j ].setIcon(icon_bomb); 
} 

((Bomb)e.getSource()).setIcon(icon_bomb_big); 

          new JOptionPane(); 
JOptionPane.showMessageDialog(this,"��ȵ������ˣ���ȷ������","��ȵ�������",2); 
replay(); 
} 
} 

public void mouseClicked(MouseEvent e) 
{ 
Bomb bombSource = (Bomb)e.getSource(); 
boolean right = SwingUtilities.isRightMouseButton(e); 

if((right == true) && (bombSource.isClicked == false)) 
{ 
bombSource.BombFlag = (bombSource.BombFlag + 1)%3; 
if(bombSource.BombFlag == 1) 
{ 

if(BombNum > 0 && bombSource.isRight == false ){ 
bombSource.setIcon(icon_flag); 
bombSource.isRight = true; 
BombNum--; 
} 
isWin(); 
nowBomb.setText("��ǰ����"+" "+BombNum+""); 
} 
else if(bombSource.BombFlag == 2) 
{ 

if( (BombNum !=0 ) ||(BombNum ==0 &&(bombSource.getIcon()==icon_flag)) ) 
BombNum++; 
bombSource.setIcon(icon_question); 
nowBomb.setText("��ǰ����"+" "+BombNum+""); 
} 
else if(bombSource.BombFlag == 0) 
{ 
bombSource.setIcon(null); 
bombSource.isRight = false; 
} 
} 
} 

public void mouseEntered(MouseEvent e) 
{} 
public void mouseReleased(MouseEvent e) 
{} 
public void mouseExited(MouseEvent e) 
{} 
public void mousePressed(MouseEvent e) 
{} 
} 

/*����*/ 

public class MineSquare { 
public static void main(String args[]) 
{ 
(new MainBomb()).setVisible(true); 

} 
} 