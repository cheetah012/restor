//NervousText.java
import java.awt.Graphics;
import java.awt.Font;

public class NervousText extends java.applet.Applet implements Runnable {
        
    //��������
	char separated[];
	String s = null;
	Thread killme = null;
	int i;
	int x_coord = 0, y_coord = 0;
	String num;
	int speed=35;
	int counter =0;
	boolean threadSuspended = false; 
//��ʼ��С����
public void init() {
	//������ʾ������
	s = getParameter("text");
	if (s == null) {
	    s = "I Like Java";
	}
        //���÷ָ�
	separated =  new char [s.length()];
	s.getChars(0,s.length(),separated,0);
	resize(150,50);
	//��������
	setFont(new Font("TimesRoman",Font.BOLD,36));
 }
//����С����
public void start() {
	if(killme == null) 
	{
        killme = new Thread(this);
        killme.start();
	}
 }
//ֹͣС����
public void stop() {
	killme = null;
 }
//����С����
public void run() {
	while (killme != null) {
	try {Thread.sleep(100);} catch (InterruptedException e){}
	repaint();
	}
	killme = null;
 }
//��������
public void paint(Graphics g) {
	for(i=0;i<s.length();i++)
	{
	x_coord = (int) (Math.random()*10+15*i);
	y_coord = (int) (Math.random()*10+36);
	g.drawChars(separated, i,1,x_coord,y_coord);
	}
 }
 
//��Ӧ�������
public boolean mouseDown(java.awt.Event evt, int x, int y) {
        if (threadSuspended) {
            killme.resume();
        }
        else {
            killme.suspend();
        }
        threadSuspended = !threadSuspended;
    return true;
    }
}