//GraphicsCanvasTest.java
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
public class GraphicsCanvasTest extends Applet implements ActionListener
   {
    //��������
    private Button bt1=new Button("������");
    private Button bt2=new Button("Բ��");
    private koCanvas pic=new koCanvas();
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
   //������Ӧ����
   public void actionPerformed(ActionEvent e)
	{
	if (e.getSource()==bt1)
	   pic.picture1();
	else if (e.getSource()==bt2)
	   pic.picture2();
	pic.repaint();
	}
   }
//�Զ��廭��
class koCanvas extends Canvas
   {
   boolean choose;
   public koCanvas()
      {
      setSize(200,120);
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
       Graphics2D g2=(Graphics2D)g;
       int x=90,y=50,n,m,i;
       double d;
       if (choose)
	  {
	  g2.setColor(Color.red);  
	  for (m=0;m<=360;m+=6)
	     {  
	     d=m*Math.PI/180;
	     g2.draw(new Rectangle2D.Double(x,y,30,30));
	     g2.translate(x,y);
	     g2.rotate(d);
	     g2.translate(-x,-y);
	     g2.draw(new Rectangle2D.Double(x,y,30,30));
	    }
          }
       else
	  {
	  g2.setColor(Color.red);  
	  for (m=0;m<=360;m+=6)
	     {  
	     d=m*Math.PI/180;
	     g2.draw(new Ellipse2D.Double(x,y,35,30));
	     g2.translate(x,y);
	     g2.rotate(d);
	     g2.translate(-x,-y);
	     g2.draw(new Ellipse2D.Double(x,y,35,30));
	    }
	  }
      }
   }    