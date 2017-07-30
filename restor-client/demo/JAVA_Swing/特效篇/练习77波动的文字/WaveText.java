//WaveText.java
import java.awt.*;

public class WaveText extends java.applet.Applet
    implements Runnable {
  //��������
  String str = null;
  int direction = 1;
  int horizontalRadius = 10;
  int verticalRadius = 10;
  Thread runner = null;
  char theChars[];
  int phase = 0;
  Image offScreenImage;
  Graphics offScreenG;

//��ʼ��С����
public void init() {
  String paramStr = null;
  str = getParameter("text");
  paramStr = getParameter("direction");
  setBackground(Color.black);
  if (paramStr != null)
    direction = Integer.parseInt(paramStr);
  paramStr = getParameter("horizontalRadius");
  if (paramStr != null)
    horizontalRadius = Integer.parseInt(paramStr);
  paramStr = getParameter("verticalRadius");
  if (paramStr != null)
    verticalRadius = Integer.parseInt(paramStr);
  setFont(new Font("TimesRoman",Font.BOLD,36));
  if (str == null) {
	str = "Museum of Java Applets";
  }
  resize(30+25*str.length()+2*horizontalRadius,80+2*verticalRadius);

  theChars =  new char [str.length()];
  str.getChars(0,str.length(),theChars,0);
  offScreenImage = createImage(this.size().width,this.size().height);
  offScreenG = offScreenImage.getGraphics();
  offScreenG.setFont(new Font("TimesRoman",Font.BOLD,36));
 }
 
//����С����
public void start() {
  if(runner == null) {
    runner = new Thread(this);
    runner.start();
  }
}

//ֹͣС����
public void stop() {
  if (runner != null) {
    runner.stop();
    runner = null;
  }
}

//����С����
public void run() {
  while (runner != null) {
	try {
	  Thread.sleep(120);
	}
	catch (InterruptedException e) { }
	repaint();
  }
}

  //���½���
  public void update(Graphics g) {
    int x, y;
    double angle;
    offScreenG.setColor(Color.black);
    offScreenG.fillRect(0,0,this.size().width,this.size().height);
    phase+=direction;
    phase%=8;
    for(int i=0;i<str.length();i++) {
  	  angle = ((phase-i*direction)%8)/4.0*Math.PI;
  	  //ˮƽ������˶�
	  x = 20+25*i+(int) (Math.cos(angle)*horizontalRadius); 
	  //��ֱ������˶�
	  y = 60+  (int) (Math.sin(angle)*verticalRadius); 
      // ��һ���ֵ���ɫ����ɫ
      if (i==0 || theChars[i-1]==' ')  
        offScreenG.setColor(Color.blue);
      else
        //������Ϊ��ɫ
        offScreenG.setColor(Color.orange);  
	  offScreenG.drawChars(theChars,i,1,x,y);
	}
    paint(g);
  }

  //��������
  public void paint(Graphics g) {
    g.drawImage(offScreenImage,0,0,this);
  }
}