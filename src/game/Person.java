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
	//人物构造方法用来创建人物
	public Person(int number,String s,int x,int y,int w,int h,Hua_Rong_Dao road) {
	
		super(s);
		name = s;//姓名
		this.number = number;//序号
		 left_x = x;//左上角x坐标
		 left_y = y;//左上角y坐标
		 width = w;//长
		 height = h;//宽
		 setBackground(Color.gray);
		 road.add(this);
		 addMouseListener(road);
		 addKeyListener(road);
		
		 /*鼠标事件的类型是MouseEvent,即组件触发鼠标时，MouseEvent
		 类自动创建一个事件对象。Java分别使用MouseListener接口来处理鼠标事件。MouseListener接口可以处理5种鼠标事件：单击、按下、释放、进入和退出*/
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

          

