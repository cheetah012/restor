//BorderedButtons.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class BorderedButtons extends JPanel {
  //��������
  static JFrame myFrame;
  protected JLabel label;
  JPopupMenu pm;
  
  //���캯��
  public BorderedButtons(){
    label = new JLabel ("Hello World!");
    label.setBorder(new EtchedBorder());
    
    JButton hello = new JButton("Hello");    
    hello.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae){
      label.setText("Hello World!");
      }
      });
          
    //��ͼƬ����Ϊ��ť�ı߽�
    Icon icon = new ImageIcon ("java.jpg");
    hello.setBorder(new MatteBorder(10, 10, 10, 10, icon));
     
    //������ť
    JButton bye = new JButton("Bye");
    bye.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae){
      label.setText("Good Bye World!");
      }
      });
    //���ñ�����ɫ
    bye.setBackground (SystemColor.control);
    //���ð�ť�ı߽�����ɫ��ֱ��
    bye.setBorder(new LineBorder(Color.green));
    
    add(bye);
    add(hello);
    add(label);
    
  }
  //������
  public static void main(String args[]){
    myFrame = new JFrame("���б߽�İ�ť");
    //ʵ�����߽簴ť��
    BorderedButtons jt = new BorderedButtons();
    myFrame.getContentPane().add("Center",jt);
    myFrame.setSize(500,200);    
    myFrame.setBackground(Color.orange);    
    //����������Ϣ
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
