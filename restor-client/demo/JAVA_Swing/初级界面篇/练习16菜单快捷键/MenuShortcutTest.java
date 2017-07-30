//MenuShortcutTest.java
import java.awt.*;
import java.awt.event.*;
public class MenuShortcutTest extends Frame
   {
    //��������
    double a,d,n,sum;
    TextField tf1=new TextField(5),
	      tf2=new TextField(5),
	      tf3=new TextField(5),
	      tf4=new TextField(10);
    Label lb1=new Label("******����Ȳ�/�ȱȼ���******"),
	  lb2=new Label("�����ʼֵ��"),
	  lb3=new Label("���빫��/����ֵ:"),
	  lb4=new Label("����ڼ���:"),
	  lb5=new Label("����ܺ�:");
    //�˵���ݼ�
    MenuShortcut msc1=new MenuShortcut(KeyEvent.VK_A,true),
    			 msc2=new MenuShortcut(KeyEvent.VK_S,false);
    //�˵�������
    MenuBar bar=new MenuBar();
    Menu mu=new Menu("����");
    MenuItem sz1=new MenuItem("�Ȳ��",msc1),
			 sz2=new MenuItem("�ȱȼ���",msc2);
    public MenuShortcutTest()
	{
	super("�˵���ݼ�����");
	setLayout(new FlowLayout());
	setBackground(Color.orange);
	mu.add(sz1);
	mu.add(sz2);
	bar.add(mu);
	setMenuBar(bar);
	add(lb1);
	add(lb2);
	add(tf1);
	add(lb3);
	add(tf2);
	add(lb4);
	add(tf3); 
	add(lb5);
	add(tf4);
	setSize(200,180);
	setVisible(true);
	addWindowListener(new koWindowListener());
	sz1.addActionListener(new koActionListener());
	sz2.addActionListener(new koActionListener());
	}
    //��Ӧ�رմ���
    class koWindowListener extends WindowAdapter
	{
	public void windowClosing(WindowEvent e)
	    {
	     e.getWindow().dispose();
	     System.exit(0);
	    }
	}
    //��Ӧ�˵�����
   class koActionListener implements ActionListener
	{
	public void actionPerformed(ActionEvent e)
	    {
	   a=new Double(tf1.getText()).doubleValue();
	   d=new Double(tf2.getText()).doubleValue();
	   n=new Double(tf3.getText()).doubleValue();
	   if (e.getSource()==sz1)
	        {
		tf4.setBackground(Color.yellow);	
	        sum=(2*a+(n-1)*d)*n/2;//����Ȳ�����ܺ�
	        }
	   else if (e.getSource()==sz2)
		{
		tf4.setBackground(Color.green);	
	        sum=a*(1-Math.pow(d,n))/(1-d);//����ȱȼ������ܺ�
		}
	   tf4.setText(String.valueOf(sum));
	    }
	}
    //������
   public static void main(String args[])
	{
	new MenuShortcutTest();
	}
   }
      