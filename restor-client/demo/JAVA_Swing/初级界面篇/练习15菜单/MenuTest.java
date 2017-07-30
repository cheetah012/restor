//MenuTest.java
import java.awt.*;
import java.awt.event.*;
//MenuTest�Ķ���
public class MenuTest extends Frame
   {
    //��������
    int n=12;
    String ko="TimesRoman";
    Color fcolor=Color.red;
    TextField ta=new TextField("TimesRoman");
    //�˵�������
    MenuBar bar=new MenuBar();
    //�˵�
    Menu mu1=new Menu("����"),
	 mu2=new Menu("�ֺ�"),
         mu3=new Menu("������ɫ");
    //ѡ��˵���Ŀ
    CheckboxMenuItem ft1=new CheckboxMenuItem("TimesRoman"),
		     ft2=new CheckboxMenuItem("Courier"),
		     ft3=new CheckboxMenuItem("Helvetica"),
		     sz1=new CheckboxMenuItem("10"),
		     sz2=new CheckboxMenuItem("15"),
		     sz3=new CheckboxMenuItem("20"),
		     fc1=new CheckboxMenuItem("��ɫ"),
		     fc2=new CheckboxMenuItem("��ɫ"),
		     fc3=new CheckboxMenuItem("��ɫ");
    //����ʽ�˵�
    PopupMenu ppm=new PopupMenu();
    MenuItem pp1,pp2,pp3;
    //���캯��
    public MenuTest()
	{
	super("MenuTest");
	setLayout(new FlowLayout());
	setBackground(Color.orange);
	mu1.add(ft1);
	mu1.add(ft2);
	mu1.add(ft3);
	mu2.add(sz1);
	mu2.add(sz2);
	mu2.add(sz3);
	mu3.add(fc1);
	mu3.add(fc2);
	mu3.add(fc3);
	bar.add(mu1);
	bar.add(mu2);
	bar.add(mu3);
	setMenuBar(bar);
	ppm.add(pp1=new MenuItem("��ɫ"));
	pp1.addActionListener(new koActionListener());
	ppm.add(pp2=new MenuItem("��ɫ"));
	pp2.addActionListener(new koActionListener());
	ppm.add(pp3=new MenuItem("��ɫ"));
	pp3.addActionListener(new koActionListener());
	add(ta);
	add(ppm);
	enableEvents(AWTEvent.MOUSE_EVENT_MASK);
	sz1.setState(true);
	fc1.setState(true);
	setSize(200,180);
	setVisible(true);
	addWindowListener(new koWindowListener());
	ft1.addItemListener(new koItemListener());
	ft2.addItemListener(new koItemListener());
	ft3.addItemListener(new koItemListener());
	sz1.addItemListener(new koItemListener());
	sz2.addItemListener(new koItemListener());
	sz3.addItemListener(new koItemListener());
	fc1.addItemListener(new koItemListener());
	fc2.addItemListener(new koItemListener());
	fc3.addItemListener(new koItemListener());
	}
    //�رմ��ڼ���
    class koWindowListener extends WindowAdapter
	{
	public void windowClosing(WindowEvent e)
	    {
	     e.getWindow().dispose();
	     System.exit(0);
	    }
	}
   //�����˵�ѡ��
   class koItemListener implements ItemListener
	{
	public void itemStateChanged(ItemEvent e)
	    {
	    if (e.getItemSelectable()==ft1)
	       {
	       ko=ft1.getLabel();
	       ft2.setState(false);
	       ft3.setState(false);
	       }
	    else if (e.getItemSelectable()==ft2)
	       {
	       ko=ft2.getLabel();
	       ft1.setState(false);
	       ft3.setState(false);
	       }
	    else if (e.getItemSelectable()==ft3)
	       {
	       ko=ft3.getLabel();
	       ft1.setState(false);
	       ft2.setState(false);
	       }
	    else if (e.getItemSelectable()==sz1)
	       {
	       n=Integer.parseInt(sz1.getLabel());
	       sz2.setState(false);
	       sz3.setState(false);
	       }
	    else if (e.getItemSelectable()==sz2)
	       {
	       n=Integer.parseInt(sz2.getLabel());
	       sz1.setState(false);
	       sz3.setState(false);
	       }
	    else if (e.getItemSelectable()==sz3)
	       {
	       n=Integer.parseInt(sz3.getLabel());
	       sz1.setState(false);
	       sz2.setState(false);
	       }
	    else if (e.getItemSelectable()==fc1)
	       {
	       fcolor=Color.red;
	       fc2.setState(false);
	       fc3.setState(false);
	       }
	    else if (e.getItemSelectable()==fc2)
	       {
	       fcolor=Color.green;
	       fc1.setState(false);
	       fc3.setState(false);
	       }
	    else if (e.getItemSelectable()==fc3)
	       {
	       fcolor=Color.blue;
	       fc1.setState(false);
	       fc2.setState(false);
	       }
	    ta.setFont(new Font(ko,Font.PLAIN,n));
	    ta.setForeground(fcolor);
	    ta.setText(ko);
	    }
	}
   //��Ӧ����¼�
   public void processMouseEvent(MouseEvent e)
	{
	if (e.isPopupTrigger())
	    ppm.show(e.getComponent(),e.getX(),e.getY());
	//super.processMouseEvent(e);
	}
   class koActionListener implements ActionListener
        {
        public void actionPerformed(ActionEvent e)
	   {
           if (e.getSource()==pp1)
	        {
		ta.setBackground(Color.gray);
		}
	   else if (e.getSource()==pp2)
	        {
		ta.setBackground(Color.cyan);
		}
	   else if (e.getSource()==pp3)
	        {
		ta.setBackground(Color.yellow);
		}
	   }
	}
   //������
   public static void main(String args[])
	{
	new MenuTest();
	}
   }
      