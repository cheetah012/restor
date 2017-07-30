//ListComboExample.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class ListComboExample extends JPanel{
  static JFrame myFrame;
  
  public ListComboExample(){
  	//�������񲼾ֹ�����
    setLayout(new GridLayout(2,2));
    //ʵ����JList
    JList list = new JList(new ListModelExample());
    list.setVisibleRowCount(4);
    //�������
    JScrollPane pane = new JScrollPane();
    pane.setViewportView(list);
    add(pane);
    //��Ͽ�
    JComboBox combobox = new JComboBox(new ComboModelExample());
    add(combobox);
  }
  
  //��������Ӧ�ó������
  public static void main(String args[]){
    myFrame = new JFrame("�б�����Ͽ�ʵ��");
    ListComboExample jt = new ListComboExample();
    myFrame.getContentPane().add("Center",jt);
    myFrame.setSize(200,200);
    //�����Ϣӳ��
    myFrame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {System.exit(0);}
    });
    //��Ϊ�ɼ�
    myFrame.setVisible(true);
  }
  //�б��
  class ListModelExample extends AbstractListModel{
    String values[] = {"����","����","����","����","����","���"};
    public Object getElementAt(int index){
      return values[index];
    }
    
    public int getSize(){
      return values.length;
    }
  }
  //��Ͽ�
  class ComboModelExample extends ListModelExample
	 implements ComboBoxModel{
    Object item;
    public void setSelectedItem(Object anItem){
      item = anItem;
    }
    public Object getSelectedItem(){
      return item;
    }

  }
}
