//CheckBoxPanel.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckBoxPanel extends JPanel implements SwingConstants{
  public CheckBoxPanel(ActionListener al){
    
    //��������
    Box vertBox = Box.createVerticalBox();        
    Box topBox = Box.createHorizontalBox();
    Box middleBox = Box.createHorizontalBox();
    Box bottomBox = Box.createHorizontalBox();
    
    ButtonGroup group = new ButtonGroup();

    //������ѡ��
    //��
    JCheckBox north = new JCheckBox("�����϶���");
    north.addActionListener(al);
    north.setActionCommand("�����϶���");
    north.setBackground(Color.orange); 
    group.add(north);    
    topBox.add(north);
    //��
    JCheckBox west = new JCheckBox("���������");
    west.addActionListener(al);
    west.setActionCommand("���������");
    west.setBackground(Color.orange); 
    group.add(west);	
    middleBox.add(west);
    //��
    JCheckBox center = new JCheckBox("�������Ķ���");
    center.addActionListener(al);
    center.setActionCommand("�������Ķ���");
    center.setBackground(Color.red);
    group.add(center);
    middleBox.add(center);
    //��
    JCheckBox east = new JCheckBox("�����Ҷ���");
    east.setBackground(Color.orange); 
    east.addActionListener(al);
    east.setActionCommand("�����Ҷ���");
    //��
    group.add(east);
    middleBox.add(east);
    JCheckBox south = new JCheckBox("�����¶���");
    south.addActionListener(al);
    south.setActionCommand("�����¶���");
    south.setBackground(Color.orange); 
    group.add(south);
    bottomBox.add(south);
    //���ظ�ѡ��
    vertBox.add (topBox);
    vertBox.add (middleBox);
    vertBox.add (bottomBox);
    
    add(vertBox);
  }
}
