//CheckBoxExample.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class CheckBoxExample extends JPanel implements ActionListener,SwingConstants{
  //��������
  static JFrame myFrame;
  protected JLabel label;
  JButton theButton;
  
  //���캯��
  public CheckBoxExample(){
    Icon icon = new ImageIcon ("java.jpg");
    theButton = new JButton("My java",icon);  
    theButton.setBackground(Color.green);  
    add (theButton);
    add (new CheckBoxPanel(this));
  }    
  
  //��Ӧ�û�����
  public void actionPerformed(ActionEvent ae){
    String action = ae.getActionCommand();
    if (action.equals("�����϶���")){
      theButton.setVerticalTextPosition(TOP);
      theButton.setHorizontalTextPosition(CENTER);
    }
    else if (action.equals("�����¶���")){
      theButton.setVerticalTextPosition(BOTTOM);
      theButton.setHorizontalTextPosition(CENTER);
    }
    else if (action.equals("�����Ҷ���")){
      theButton.setHorizontalTextPosition(RIGHT);
      theButton.setVerticalTextPosition(CENTER);
    }            
    else if (action.equals("���������")){
      theButton.setHorizontalTextPosition(LEFT);
      theButton.setVerticalTextPosition(CENTER);
    }
    else if (action.equals("�������Ķ���")){
      theButton.setHorizontalTextPosition(CENTER);
      theButton.setVerticalTextPosition(CENTER);
    }
  }

  //������
  public static void main(String args[]){
    myFrame = new JFrame("�ø�ѡ��������ֶ���");
    CheckBoxExample jt = new CheckBoxExample();
    myFrame.getContentPane().add("Center",jt);
    myFrame.setSize(400,250);      
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
