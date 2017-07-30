//MyCanvas.java
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class MyCanvas
  implements KeyListener,MouseListener{
  //��������
  Canvas c;
  String s ="";
  TextField t;
  //������
  public static void main(String args[]){
  	Frame f = new Frame("Canvas");
  	MyCanvas mc = new MyCanvas();
  	mc.c = new Canvas();
  	mc.t = new TextField();
  	f.add("South",mc.t);
  	f.add("Center",mc.c);
  	f.setSize(300,150);
  	mc.c.addMouseListener(mc);
  	mc.c.addKeyListener(mc);
  	f.setVisible(true);
}
//��Ӧ�����¼�
public void keyTyped(KeyEvent ev){
	t.setText("keyTyped");
	s+=ev.getKeyChar();
	c.getGraphics().drawString(s,0,20);
}
//��Ӧ���̰���
public void keyPressed(KeyEvent ev){ }
//��Ӧ����̧��
public void keyReleased(KeyEvent ev){
	t.setText("keyReleased");
}
//��Ӧ������
public void mouseClicked(MouseEvent ev){
	t.setText("mouseClicked");
	c.requestFocus();
}
//��Ӧѹ�����
public void mousePressed(MouseEvent ev){
	t.setText("mousePressed");
}
//��Ӧ�ɿ����
public void mouseReleased(MouseEvent ev){
	t.setText("mouseReleased");
}
//��Ӧ������
public void mouseEntered(MouseEvent ev){
	t.setText("mouseEntered");
}
//��Ӧ����˳�
public void mouseExited(MouseEvent ev){
    t.setText("mouseExited");
}
}