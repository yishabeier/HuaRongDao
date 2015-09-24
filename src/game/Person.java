package game;

import java.awt.Button;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import game.Hua_Rong_Dao;
public class Person extends Button implements FocusListener{
	Rectangle rect = null;
	int left_x,left_y;
	int width,height;
	String name;
	int number;
	//���ﹹ�췽��������������
	public Person(int number,String s,int x,int y,int w,int h,Hua_Rong_Dao road) {
	
		super(s);
		name = s;//����
		this.number = number;//���
		 left_x = x;//���Ͻ�x����
		 left_y = y;//���Ͻ�y����
		 width = w;//��
		 height = h;//��
		 setBackground(Color.gray);
		 road.add(this);
		 addMouseListener(road);
		 addKeyListener(road);
		
		 /*����¼���������MouseEvent,������������ʱ��MouseEvent
		 ���Զ�����һ���¼�����Java�ֱ�ʹ��MouseListener�ӿ�����������¼���MouseListener�ӿڿ��Դ���5������¼������������¡��ͷš�������˳�*/
		 setBounds(x, y, w, h);
		 addFocusListener(this);
		 rect=new Rectangle(x,y,w,h);
		 
	}

	public void focusGained(FocusEvent e) {
		setBackground(Color.yellow);
	}
	public void focusLost(FocusEvent e) {
		setBackground(Color.blue);
	}
	
	
}

          

