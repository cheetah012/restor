//ButtonCanvasTest.java
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
public class ButtonCanvasTest extends Applet implements ActionListener
   {
    Button bt1=new Button("����Բ");
    Button bt2=new Button("ʵ��Բ");
    koCanvas pic=new koCanvas();
    //��ʼ������
    public void init()
	{
	add(bt1);
	add(bt2);
    add(pic);
    bt1.setBackground(Color.orange);	   	   
	bt2.setBackground(Color.orange);
	bt1.addActionListener(this);
	bt2.addActionListener(this);
	}
    //��Ϣ��������
   public void actionPerformed(ActionEvent e)
	{
	if (e.getSource()==bt1)
	   pic.picture1();
	else if (e.getSource()==bt2)
	   pic.picture2();
	pic.repaint();
	}
   }
//����һ��������
class koCanvas extends Canvas
   {
   boolean choose;
   public koCanvas()
      {
      setSize(170,120);
      }
   public void picture1()
      {
      choose=true;
      }
   public void picture2()
      {
      choose=false;
      }
   //��������
   public void paint(Graphics g)
      {
       if (choose)
	  {
	  g.setColor(Color.red);
	  g.drawOval(40,10,40,50);
          g.drawString("����Բ",40,80);
          }
       else
	  {
	  g.setColor(Color.blue);
	  g.fillOval(40,10,40,50);
	  g.drawString("ʵ��Բ",40,80);
	  }
      }
   }    