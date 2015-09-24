package game;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Hua_Rong_Dao extends Panel implements MouseListener,
		MouseMotionListener, ActionListener, KeyListener {
	double mx, my;
	Person person[] = new Person[10];
	Rectangle left, right, above, below;// 华容道的边界
	Button restart = new Button("重新开始");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f = new Frame();// 创建容器
		Hua_Rong_Dao hrr = new Hua_Rong_Dao();
		f.add(hrr);
		f.setSize(400, 500);
		f.setVisible(true);
		f.addWindowListener(new WindowListener() {
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void windowIconified(WindowEvent e) {
				
			}
			
			public void windowDeiconified(WindowEvent e) {
				}
			

			public void windowDeactivated(WindowEvent e) {
	
			}
			public void windowClosing(WindowEvent e) {
				System.out.println("dsubcihvh");
				System.exit(0);
				}
			
			public void windowClosed(WindowEvent e) {
				
			}
			
			public void windowActivated(WindowEvent e) {
				
			}
		});

		hrr.init();

	}

	private void init() {
		setLayout(null);
		add(restart);
		restart.setBounds(5, 5, 80, 25);
		restart.addActionListener(this);
		person[0] = new Person(0, "曹操", 104, 54, 100, 100, this);
		person[1] = new Person(1, "关羽", 104, 154, 100, 50, this);
		person[2] = new Person(2, "张飞", 54, 154, 50, 100, this);
		person[3] = new Person(3, "刘备", 204, 154, 50, 100, this);
		person[4] = new Person(4, "张辽", 54, 54, 50, 100, this);
		person[5] = new Person(5, "曹仁", 204, 54, 50, 100, this);
		person[6] = new Person(6, "1兵  ", 54, 254, 50, 50, this);
		person[7] = new Person(7, "2兵  ", 204, 254, 50, 50, this);
		person[8] = new Person(8, "3兵  ", 104, 204, 50, 50, this);
		person[9] = new Person(9, "4兵  ", 154, 204, 50, 50, this);
		person[9].requestFocus();
		left = new Rectangle(49, 49, 5, 260);
		person[0].setForeground(Color.white);
		right = new Rectangle(254, 49, 5, 260);
		above = new Rectangle(49, 49, 210, 5);
		below = new Rectangle(49, 304, 210, 5);

	}

	public void paint(Graphics g) { // 画出华容道的边界:
		g.setColor(Color.cyan);
		g.fillRect(49, 49, 5, 260);// left.
		g.fillRect(254, 49, 5, 260);// right.
		g.fillRect(49, 49, 210, 5); // above.
		g.fillRect(49, 304, 210, 5);// below.
		// 提示曹操逃出位置和按键规则:
		g.drawString("点击相应的人物,然后拖拽鼠标移动", 100, 20);
		g.setColor(Color.red);
		g.drawString("曹操到达该位置", 110, 300);
	}

	public void actionPerformed(ActionEvent e) {
		new Hua_Rong_Dao();
	}

	public void mouseDragged(MouseEvent e) {

	}
	public void mouseMoved(MouseEvent e) {

	}
	public void mouseClicked(MouseEvent e) {

	}
	public void mousePressed(MouseEvent e) {

	}
	public void mouseReleased(MouseEvent e) {

	}
	public void mouseEntered(MouseEvent e) {

	}
	public void mouseExited(MouseEvent e) {

	}
	public void keyTyped(KeyEvent e) {
		
	}

	public void keyReleased(KeyEvent e) {
	}
	public void keyPressed(KeyEvent e) {
		Person man = (Person) e.getSource();
		int direction = e.getKeyCode();
		if (direction == KeyEvent.VK_DOWN) {
			System.out.println("DOWN");
			go(man, direction);
		}
		if (direction == KeyEvent.VK_UP) {
			System.out.println("UP");
			go(man, direction);
		}
		if (direction == KeyEvent.VK_LEFT) {
			System.out.println("LEFT");
			go(man, direction);
		}
		if (direction == KeyEvent.VK_RIGHT) {
			System.out.println("RIGHT");
			go(man, direction);
		}
	}

	private void go(Person man, int direction) {
		boolean move = true;
		Rectangle manRect = man.getBounds();
		int rx = man.getBounds().x;
		int ry = man.getBounds().y;
		if (direction == (int) KeyEvent.VK_DOWN) {
			ry = ry + 50;
		} else if (direction == (int) KeyEvent.VK_UP) {
			ry = ry - 50;
		} else if (direction == (int) KeyEvent.VK_LEFT) {
			rx = rx - 50;
		} else if (direction == (int) KeyEvent.VK_RIGHT) {
			rx = rx + 50;
		}
		manRect.setLocation(rx, ry);
		for (int k = 0; k < 10; k++) {
			Rectangle PeopleRec = person[k].getBounds();
			// 如果覆盖就不移动
			if (manRect.intersects(PeopleRec) && (man.number != k)&&rx<54&&rx>254&&ry<54&&ry>304) {
				move = false;
			}
		}
		if (move == true) {
			man.setLocation(rx, ry);
		}
	}
}