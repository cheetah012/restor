//FocusManage.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FocusManage extends JApplet {
	//������ť
	private JButton button_1 = new NotFocusTraversableButton(),
		button_2 = new ButtonThatManagesFocus(),
		button_3 = new JButton("�淶�İ�ť"),
		button_4 = new JButton("�淶�İ�ť"),
		button_5 = new JButton("�����ܽ���İ�ť"),
		button_6 = new JButton(
		"���ͽ���İ�ť");
	//��ʼ��С����		
	public void init() {
		//���ð�ť�ı�����ɫ
		button_1.setBackground(Color.orange);
		button_2.setBackground(Color.green);
		button_3.setBackground(Color.yellow);
		button_4.setBackground(Color.yellow);
		button_5.setBackground(Color.pink);
		button_6.setBackground(Color.red);
		
		//��������
		Container contentPane = getContentPane();
		FocusCycleRootPanel panel = new FocusCycleRootPanel();
                //�����ܽ���
		button_5.setRequestFocusEnabled(false);
		//���ݽ���
		button_6.setNextFocusableComponent(button_2);
                //���ذ�ť
		panel.add(button_3);
		panel.add(button_4);
		panel.add(button_5);
                //�����������
		contentPane.setLayout(new FlowLayout());
		contentPane.add(button_1);
		contentPane.add(button_2);
		contentPane.add(panel);
		contentPane.add(button_6);
	}
}
//�����ͽ���İ�ť
class ButtonThatManagesFocus extends JButton {
	public ButtonThatManagesFocus() {
		super("�����ͽ���İ�ť");	
	}
	public boolean isManagingFocus() {
		return true;
	}
	public void processComponentKeyEvent(KeyEvent e) {
		System.out.println(e);
	}
}
//�����ܽ���İ�ť
class NotFocusTraversableButton extends JButton {
	public NotFocusTraversableButton() {
		super("�����ܽ���İ�ť");	
	}
	public boolean isFocusTraversable() {
		return false;
	}
}
//����ѭ�����
class FocusCycleRootPanel extends JPanel {
	public FocusCycleRootPanel() {
		setBorder(BorderFactory.createTitledBorder(
					"����ѭ�����"));
	}
	public boolean isFocusCycleRoot() {
		return true;
	}
}
