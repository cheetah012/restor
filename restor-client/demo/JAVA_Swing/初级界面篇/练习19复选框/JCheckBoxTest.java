//JCheckBoxTest.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class JCheckBoxTest extends JApplet implements ItemListener
   {
   //��������
   int sum=0,
   	   a=0,
   	   b=0,
   	   c=0,
   	   d=0;
   Container ctp=getContentPane();
   JTextField tf=new JTextField(10);
   JLabel lb=new JLabel("�ܼ�:");
   JCheckBox cb1,cb2,cb3,cb4;
   JButton btn=new JButton("���");
   //��ʼ��С����
   public void init()
     {
     ctp.setLayout(new FlowLayout());
     cb1=new JCheckBox("��ʾ��1350",false);
     cb1.addItemListener(this);
     ctp.add(cb1);
     cb2=new JCheckBox("�ڴ�780",false);
     cb2.addItemListener(this);
     ctp.add(cb2);
     cb3=new JCheckBox("Ӳ��1100",false);
     cb3.addItemListener(this);
     ctp.add(cb3);
     cb4=new JCheckBox("CPU410",false);
     cb4.addItemListener(this);
     ctp.add(cb4);
     ctp.add(lb);
     ctp.add(tf);
     ctp.add(btn);
     btn.addActionListener(new koListener());
     }
  //ѡ���ѡ��
  public void itemStateChanged(ItemEvent e)
     {
     JCheckBox cbx=(JCheckBox)e.getItem();
     if (cbx==cb1)
	a=1350;
     if (cbx==cb2)
	b=780;
     if (cbx==cb3)
	c=1100;
     if (cbx==cb4)
	d=410;
     sum=a+b+c+d;
     tf.setText(String.valueOf(sum)+"Ԫ");
     }
   //����
  class koListener implements ActionListener
     {
     public void actionPerformed(ActionEvent e)
	{
        cb1.setSelected(false);
	cb2.setSelected(false);
	cb3.setSelected(false);
	cb4.setSelected(false);
        a=0;b=0;c=0;d=0;
	sum=a+b+c+d;
	tf.setText(String.valueOf(sum)+"Ԫ");
	}
     }
}

