//RadioButtonDemo.java
import javax.swing.*;
import java.awt.event.*; 
import java.awt.*;

public class RadioButtonDemo extends JPanel{
	
	//�����ַ������͵ĳ���
	static String aString = "a";
	static String bString = "b";
	static String cString = "c";
	static String dString = "d";
	static String eString = "e";
	JLabel picture;
		
	public RadioButtonDemo(){
		
		//���嵥ѡ��ťa���ҳ�ʼ����ť������
		JRadioButton aButton = new JRadioButton(aString);
		aButton.setMnemonic('a');
		aButton.setActionCommand(aString);
		aButton.setSelected(true);
		aButton.setBackground(Color.pink);
		
		//���嵥ѡ��ťb���ҳ�ʼ����ť������
		JRadioButton bButton = new JRadioButton(bString);
		bButton.setMnemonic('b');
		bButton.setActionCommand(bString);
		bButton.setBackground(Color.pink);
		
		//���嵥ѡ��ťc���ҳ�ʼ����ť������
		JRadioButton cButton = new JRadioButton(cString);
		cButton.setMnemonic('c');
		cButton.setActionCommand(cString);
		cButton.setBackground(Color.pink);
		
		//���嵥ѡ��ťd���ҳ�ʼ����ť������
		JRadioButton dButton = new JRadioButton(dString);
		dButton.setMnemonic('d');
		dButton.setActionCommand(dString);
		dButton.setBackground(Color.pink);
		
		//���嵥ѡ��ťe���ҳ�ʼ����ť������
		JRadioButton eButton = new JRadioButton(eString);
		eButton.setMnemonic('e');
		eButton.setActionCommand(eString);
		eButton.setBackground(Color.pink);
		
		//ʵ����ButtonGroup�࣬����������õ������ѡ��ť�ӵ������group֮��
		ButtonGroup group = new ButtonGroup();
		group.add(aButton);
		group.add(bButton);
		group.add(cButton);
		group.add(dButton);
		group.add(eButton);
		
		//ʵ����RadioListener��
		//����������õ������ѡ��ť�����¼�����
		RadioListener myListener = new RadioListener();
		aButton.addActionListener(myListener);
		bButton.addActionListener(myListener);
		cButton.addActionListener(myListener);
		dButton.addActionListener(myListener);
		eButton.addActionListener(myListener);
		
		picture = new JLabel(new ImageIcon("image/"+aString+".gif"));
		picture.setPreferredSize(new Dimension(200,200));
		
		//ʵ����JPanel�Ķ���
		//�������ѡ��ť���뵽�����radioPanel֮��
		JPanel radioPanel = new JPanel();
		//�������ѡ��ť����0��1�еĸ�ʽ����
		radioPanel.setLayout(new GridLayout(0,1));
		radioPanel.add(aButton);
		radioPanel.add(bButton);
		radioPanel.add(cButton);
		radioPanel.add(dButton);
		radioPanel.add(eButton);
	    
	    setBackground(Color.pink);	    
	    setLayout(new BorderLayout());
	    
	    //��ѡ��ťλ������岼�ֵ�����
	    add(radioPanel,BorderLayout.WEST);	    
	    //ͼƬλ������岼�ֵ�����
	    add(picture,BorderLayout.CENTER);
	    
	    setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
	}
	
	//�Ե�ѡ��ť���¼���Ӧ
	class RadioListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			picture.setIcon(new ImageIcon("images/"+e.getActionCommand()+".gif"));
		}
	}
	
	//��������Ҳ�ǳ�����ڴ�
	public static void main(String s[]){
		JFrame jf = new JFrame("RadioButtonDemo");
		RadioButtonDemo rbd = new RadioButtonDemo();
		jf.setSize(300,300);
	    jf.setBackground(Color.pink);
		jf.setContentPane(rbd);
		jf.setVisible(true);
		
		jf.addWindowListener(new WindowAdapter() {	
			public void windowClosing(WindowEvent e){
				 System.exit(0);}
												
		});		
	}	
}	