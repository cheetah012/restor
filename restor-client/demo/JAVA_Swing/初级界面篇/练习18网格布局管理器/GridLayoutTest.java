//GridLayoutTest.java
import java.awt.*;
import java.awt.event.*;
public class GridLayoutTest extends Frame
    {
    //��������
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,ba,bm,bd,be,bp;
    Panel p1;
    //���캯��
    public GridLayoutTest()
	{
	super("���񲼾ֹ�����");
	p1=new Panel();
	p1.setBackground(Color.orange);
	//4�У�4�У�ˮƽ���3�����أ���ֱ���3������
	p1.setLayout(new GridLayout(4,4,3,3));

        //���水ť�����úͼ���
	b7=new Button("A");
	p1.add(b7);
	b8=new Button("B");
	p1.add(b8);
	b9=new Button("C");
	p1.add(b9);
	bd=new Button("D");
	p1.add(bd);
	b4=new Button("E");
	p1.add(b4);
	b5=new Button("F");
	p1.add(b5);
	b6=new Button("G");
	p1.add(b6);
	bp=new Button("H");
	p1.add(bp);
	b1=new Button("I");
	p1.add(b1);
	b2=new Button("J");
	p1.add(b2);
	b3=new Button("K");
	p1.add(b3);
	bm=new Button("L");
	p1.add(bm);
	b0=new Button("M");
	p1.add(b0);
	ba=new Button("N");
	p1.add(ba);
	be=new Button("O");
	p1.add(be);
	this.add("Center",p1);
	this.setSize(200,200);
	this.setVisible(true);
	addWindowListener(new koWindowListener());
	}
     //�رմ���
     class koWindowListener extends WindowAdapter
	{
	public void windowClosing(WindowEvent e)
	    {
	     dispose();
	     System.exit(0);
	    }
	}
     //������
     public static void main(String args[])
    	{
    	GridLayoutTest ko=new GridLayoutTest();
    	}
   }

