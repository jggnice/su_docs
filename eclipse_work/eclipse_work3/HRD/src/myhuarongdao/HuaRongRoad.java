package myhuarongdao;

import java.awt.Button;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class HuaRongRoad extends JPanel
		implements
			MouseListener,
			KeyListener,
			ActionListener
{
	static int ���� = 100;
	static int �̱� = ���� / 2;
	static int dx = 5;
	static int relative_left_bound = �̱� + dx - 1;

	Person person[] = new Person[10];
	Button left, right, above, below;
	
	public HuaRongRoad(int framewidth)
	{���� = framewidth;
	�̱� = ���� / 2;
	relative_left_bound = �̱� + dx - 1;
		init();
		
		validate();

	}
	
	
	public void init()
	{
		setLayout(null);
		Button exit = new Button("����");
		exit.setBackground(Color.red);
		add(exit);
		exit.setBounds(relative_left_bound + �̱�, relative_left_bound + 5 * �̱�,
				����, �̱� / 2);
		String name[] = {"�ܲ�", "����", "�ŷ�", "����", "����", "����", "��", "��", "��", "��"};
		for (int k = 0; k < name.length; k++)
		{
			person[k] = new Person(k, name[k]);
			person[k].addMouseListener(this);
			person[k].addKeyListener(this);
			add(person[k]);
		}
		person[0].setBounds(relative_left_bound + �̱�, relative_left_bound, ����,
				����);
		person[1].setBounds(relative_left_bound + �̱�, relative_left_bound + ����,
				����, �̱�);
		person[2].setBounds(relative_left_bound, relative_left_bound + ����, �̱�,
				����);
		person[3].setBounds(relative_left_bound + 3 * �̱�, relative_left_bound
				+ ����, �̱�, ����);
		person[4].setBounds(relative_left_bound, relative_left_bound, �̱�, ����);
		person[5].setBounds(relative_left_bound + 3 * �̱�, relative_left_bound,
				�̱�, ����);
		person[6].setBounds(relative_left_bound, relative_left_bound + 4 * �̱�,
				�̱�, �̱�);
		person[7].setBounds(relative_left_bound + 3 * �̱�, relative_left_bound
				+ 4 * �̱�, �̱�, �̱�);
		person[8].setBounds(relative_left_bound + �̱�, relative_left_bound + 3
				* �̱�, �̱�, �̱�);
		person[9].setBounds(relative_left_bound + ����, relative_left_bound + 3
				* �̱�, �̱�, �̱�);
		person[9].requestFocus();
		left = new Button();
		right = new Button();
		above = new Button();
		below = new Button();
		add(left);
		add(right);
		add(above);
		add(below);
		left.setBounds(relative_left_bound - dx, relative_left_bound - dx, dx,
				5 * �̱� + 2 * dx);
		right.setBounds(relative_left_bound + 4 * �̱�, relative_left_bound - dx,
				dx, 5 * �̱� + 2 * dx);
		above.setBounds(relative_left_bound - dx, relative_left_bound - dx, 4
				* �̱� + 2 * dx, dx);
		below.setBounds(relative_left_bound - dx, relative_left_bound + 5 * �̱�,
				4 * �̱� + 2 * dx, dx);
		validate();
	}
	public void keyTyped(KeyEvent e)
	{
	}
	public void keyReleased(KeyEvent e)
	{
	}
	public void keyPressed(KeyEvent e)
	{
		Person man = (Person) e.getSource();
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			go(man, below);
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			go(man, above);
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			go(man, left);
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			go(man, right);
		}
	}
	public void mousePressed(MouseEvent e)
	{
		Person man = (Person) e.getSource();
		int x = -1, y = -1;
		x = e.getX();// the horizontal x posit\ion of the event relative to the
						// source component
		y = e.getY();
		int w = man.getBounds().width;
		int h = man.getBounds().height;
		if (y > h / 2)
		{
			go(man, below);
		}
		if (y < h / 2)
		{
			go(man, above);
		}
		if (x < w / 2)
		{
			go(man, left);
		}
		if (x > w / 2)
		{
			go(man, right);
		}
	}
	public void mouseReleased(MouseEvent e)
	{
	}
	public void mouseEntered(MouseEvent e)
	{
	}
	public void mouseExited(MouseEvent e)
	{
	}
	public void mouseClicked(MouseEvent e)
	{
	}
	public void go(Person man, Button direction)
	{
		boolean move = true;
		Rectangle manRect = man.getBounds();
		int x = man.getBounds().x;
		int y = man.getBounds().y;
		if (direction == below)
		{
			y = y + �̱�;
		} else if (direction == above)
		{
			y = y - �̱�;
		} else if (direction == left)
		{
			x = x - �̱�;
		} else if (direction == right)
		{
			x = x + �̱�;
		}
		manRect.setLocation(x, y);
		Rectangle directionRect = direction.getBounds();
		for (int k = 0; k < 10; k++)
		{
			Rectangle personRect = person[k].getBounds();
			if ((manRect.intersects(personRect)) && (man.number != k))
			{
				move = false;// ������������
			}
		}
		if (manRect.intersects(directionRect))
		{
			move = false;// �����߽��
		}
		if (move == true)
		{
			man.setLocation(x, y);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub

	}
}