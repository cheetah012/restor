//JRadioButtonTest.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class JRadioButtonTest extends JApplet implements ItemListener
   {
   int x=0,
       y=0,
       sum=0,
       a=0,
       b=0,
       c=0;
   Container ctp=getContentPane();
   JTextField tf=new JTextField(10);
   JLabel lb=new JLabel("����:");
   JCheckBox cb;
   JRadioButton rb1,
                rb2,
                rb3;
   ButtonGroup bg=new ButtonGroup();
   //��ʼ��С����
   public void init()
     {
     //���ý��沼�ַ��
     ctp.setLayout(new FlowLayout());
     cb=new JCheckBox("ñ��10",false);
     cb.addItemListener(this);
     ctp.add(cb);
     cb=new JCheckBox("У��80",false);
     cb.addItemListener(this);
     ctp.add(cb);
     cb=new JCheckBox("����20",false);
     cb.addItemListener(this);
     ctp.add(cb);
     rb1=new JRadioButton("ȫ��40��");
     rb1.addActionListener(new koListener());
     ctp.add(rb1);
     rb2=new JRadioButton("ȫ��30��");
     rb2.addActionListener(new koListener());
     ctp.add(rb2);
     rb3=new JRadioButton("ȫ��20��");
     rb3.addActionListener(new koListener());
     ctp.add(rb3);
     bg.add(rb1);
     bg.add(rb2);
     bg.add(rb3);
     ctp.add(lb);
     ctp.add(tf);
     }
  //��Ӧ�û�ѡ��Ķ���
  public void itemStateChanged(ItemEvent e)
     {
     JCheckBox cbx=(JCheckBox)e.getItem();
     if (cbx.getText()=="ñ��10")
	a=10;
     if (cbx.getText()=="У��80")
	b=80;
     if (cbx.getText()=="����20")
	c=20;
     x=a+b+c;
     sum=x*y;
     tf.setText(String.valueOf(sum)+"Ԫ");
     }
  //��Ϣ����
  class koListener implements ActionListener
     {
     public void actionPerformed(ActionEvent e)
	{
         String rbt=e.getActionCommand();
         if (rbt=="ȫ��40��")
            y=40;
         else if (rbt=="ȫ��30��")
            y=30; 
         else
            y=20;
         sum=x*y;
	 tf.setText(String.valueOf(sum)+"Ԫ");
	}
     }
}

