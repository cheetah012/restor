//DialogDemo.java
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
//������
class dlg extends Dialog 
    {
    Button bt=new Button("�ر�");
    //���캯��
    dlg(Frame fe,String str)
	{
	super(fe,str,true);
	setLayout(new FlowLayout());
	setSize(200,180);
	add(bt);
	bt.addActionListener(new ko1ActionListener());
	}
    //�رնԻ���
    class ko1ActionListener implements ActionListener
	{
	public void actionPerformed(ActionEvent e)
	   {
	   setVisible(false);
	   }
	}
    }
//����DialogDemo
public class DialogDemo extends Frame
   {
    //��������
    Frame fe;
    Menu mu=new Menu("������ɫ���ӶԻ���");
    MenuBar bar=new MenuBar();
    MenuItem i1,i2,i3,i4;
    //���캯��
    public DialogDemo()
	{
	super("���Ի���");
	setLayout(new FlowLayout());
	mu.add(i1=new MenuItem("��ɫ..."));
	mu.add(i2=new MenuItem("��ɫ..."));
        mu.add(i3=new MenuItem("��ɫ..."));
	mu.add(new MenuItem("-"));
	mu.add(i4=new MenuItem("�˳�"));
	bar.add(mu);
	setMenuBar(bar);
	setSize(500,400);
	setVisible(true);
	i1.addActionListener(new ko2ActionListener());
	i2.addActionListener(new ko2ActionListener());
	i3.addActionListener(new ko2ActionListener());
	i4.addActionListener(new ko2ActionListener());
	addWindowListener(new koWindowListener());
	}
    //�¼���������
    class ko2ActionListener implements ActionListener
	{
	Frame fe=new Frame();
	public void actionPerformed(ActionEvent e)
	   {
	    String ko=e.getActionCommand();
	    if (ko.equals("��ɫ..."))
		{
		dlg d=new dlg(fe,"��ɫ���ӶԻ���");
	        d.setBackground(Color.red);
		d.setVisible(true);
		}
	    else if (ko.equals("��ɫ..."))
		{
		dlg d=new dlg(fe,"��ɫ���ӶԻ���");
	        d.setBackground(Color.green);
		d.setVisible(true);
		}
	    else if (ko.equals("��ɫ..."))
		{
		dlg d=new dlg(fe,"��ɫ���ӶԻ���");
	        d.setBackground(Color.blue);
		d.setVisible(true);
		}
	    else if (ko.equals("�˳�"))
		{
		dispose();
	        System.exit(0);
		}
	   }
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
	Frame fe=new Frame();
	dlg k=new dlg(fe,"����ĶԻ���");
	k.setVisible(true);
	DialogDemo ko=new DialogDemo();
	}
   }
