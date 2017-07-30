//JComboBoxTest.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class JComboBoxTest extends JApplet implements ItemListener
   {
   //��������
   Container ctp=getContentPane();
   JTextField tf1=new JTextField(5),
	      tf2=new JTextField(5);
   JLabel lb1=new JLabel("����:"),
	  lb2=new JLabel("�����:");
   String obj[]={"����","����","���","����","������"},
          price[]={"12","118","29","24","47"},
          num[]={"232","45","405","12","49"};
   JComboBox cbx=new JComboBox();
   //��ʼ��С����
   public void init()
     {
     //����ҳ�沼�ַ��
     ctp.setLayout(new FlowLayout());
     for (int n=0;n<obj.length;n++)
         cbx.addItem(obj[n]);
     ctp.add(cbx);
     //�����Ϣ����
     cbx.addItemListener(this);
     ctp.add(lb1);
     ctp.add(tf1);
     ctp.add(lb2);
     ctp.add(tf2);
     }
  //��Ӧ�û�����
  public void itemStateChanged(ItemEvent e)
     {
     int x=0,y;
     String ko=(String)e.getItem();
     for (y=0;y<obj.length;y++)
        if (ko==obj[y])
	    x=cbx.getSelectedIndex();
     //���ü۸�
     tf1.setText(price[x]);
     //��������
     tf2.setText(num[x]);
     }
}

