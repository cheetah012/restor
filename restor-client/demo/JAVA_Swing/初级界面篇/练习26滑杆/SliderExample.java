//SliderExample.java
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class SliderExample extends JPanel{   
  //��������
  JLabel slider5Value;
  static JFrame myFrame;
  //���캯��
  public SliderExample() {
    Box horizBox = Box.createHorizontalBox();
    
    //������һ������
    JSlider slider1 = new JSlider (JSlider.VERTICAL, 0, 50, 25);
    slider1.setPaintTicks(true);    
    slider1.setMajorTickSpacing(10);
    slider1.setMinorTickSpacing(2);          
    slider1.setSnapToTicks(true);
    slider1.setBackground(Color.orange);
    horizBox.add(slider1);
    horizBox.add(horizBox.createHorizontalStrut(15));
    
    //�����ڶ�������
    JSlider slider2 = new JSlider (JSlider.VERTICAL, 0, 50,25);
    slider2.setPaintTicks(true);    
    slider2.setMinorTickSpacing(5); 
    slider2.setBackground(Color.green);     
    horizBox.add(slider2);
    horizBox.add(horizBox.createHorizontalStrut(15));
    
    //��������������
    JSlider slider3 = new JSlider (JSlider.VERTICAL, 0, 50,25);
    slider3.setPaintTicks(true);    
    slider3.setMajorTickSpacing(10); 
    slider3.setBackground(Color.yellow);   
    horizBox.add(slider3);
    horizBox.add(horizBox.createHorizontalStrut(15));
    
    //�������ĸ�����    
    JSlider slider4 =  new JSlider (JSlider.VERTICAL, 0, 50,25);
    slider4.setBorder(LineBorder.createBlackLineBorder());
    slider4.setBackground(Color.blue);
    horizBox.add(slider4);
    horizBox.add(horizBox.createHorizontalStrut(15));
    
    //�������������
    JSlider slider5 =  new JSlider (JSlider.VERTICAL, 0, 50,25);
    slider5.setBorder(LineBorder.createBlackLineBorder());
    slider5.setMajorTickSpacing(10);      
    slider5.setPaintLabels(true);
    slider5.setBackground(Color.pink);
    horizBox.add(slider5);
    horizBox.add(horizBox.createHorizontalStrut(15));

    //���õ�������˵�ֵ    
    slider5Value = new JLabel("��������˵�ֵ = 25");
    horizBox.add(slider5Value);
    //��Ӧ�û�ѡ��
    slider5.addChangeListener(new ChangeListener(){
      public void stateChanged(ChangeEvent event){
        slider5Value.setText("��������˵�ֵ = "+((JSlider)event.getSource()).getValue());
      }
    });
                              
    
    setLayout(new BorderLayout());
    add(horizBox,"Center");
  }

  //������
  public static void main(String args[]){
    myFrame = new JFrame("����");
    SliderExample sliderExample = new SliderExample();
    myFrame.getContentPane().add("Center",sliderExample);
    myFrame.setSize(350,300);
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
