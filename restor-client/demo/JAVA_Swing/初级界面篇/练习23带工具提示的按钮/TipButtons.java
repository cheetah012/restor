//TipButtons .java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TipButtons extends JPanel {
  //��������
  static JFrame myFrame;
  protected JLabel label;
  
  //���캯��
  public TipButtons(){
    label = new JLabel ("Hello World!");
    label.setOpaque(true);
    JButton hello = new JButton("Hello");
    hello.setMnemonic('h');
    hello.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae){
      label.setText("Hello World!");
      }
      });
    //Set the ToolTip for the hello button
    hello.setToolTipText("Select to change label to Hello World");
    
    JButton bye = new JButton("Bye");
    bye.setMnemonic('b');
    bye.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae){
      label.setText("Good Bye World!");
      }
      });
    //Ϊ��ť���ù�����ʾ
    bye.setToolTipText("Select to change label to Good Bye World");
    
    add(bye);
    add(hello);
    add(label);
  }
  
  //������
  public static void main(String args[]){
    //���ɽ���
    myFrame = new JFrame("�й�����ʾ�İ�ť");
    TipButtons tb = new TipButtons();
    myFrame.getContentPane().add("Center",tb);
    myFrame.setSize(500,200);    
    myFrame.setBackground(Color.orange);
    //���������¼�
    myFrame.addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent e)
       	{
       		System.exit(0);
       	}
      }
      );
    myFrame.setVisible(true);
  }
}
