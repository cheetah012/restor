//JTabbedPaneTest.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//JTabbedPaneTest�������
public class JTabbedPaneTest extends JApplet {
	//����ʵ����
	private JTabbedPane tp = new JTabbedPane(SwingConstants.BOTTOM);
	private JComboBox combo = new JComboBox();
	//���캯��
	public JTabbedPaneTest() {
		//����
		Container contentPane = getContentPane();
		//�������
		JPanel comboPanel = new JPanel();
		JPanel panelOne = new JPanel();
		JPanel panelTwo = new JPanel();
				
		panelOne.add(new JButton("��ǰѡ�е��ǵ�1��ѡ�"));
		panelOne.setBackground(Color.cyan);
		panelTwo.add(new JButton("��ǰѡ�е��ǵ�2��ѡ�"));
		panelTwo.setBackground(Color.orange);

		tp.add(panelOne, "Panel One");
		tp.add(panelTwo, "Panel Two");
		
		combo.addItem("TOP");
		combo.addItem("LEFT");
		combo.addItem("RIGHT");
		combo.addItem("BOTTOM");

		setComboValue();

		comboPanel.add(new JLabel("ѡ���λ��:"));
		comboPanel.add(combo);

		contentPane.setLayout(new BorderLayout());
		contentPane.add(comboPanel, BorderLayout.NORTH);
		contentPane.add(tp, BorderLayout.CENTER);
		//��Ӧ�û�����
		combo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				int state = e.getStateChange();

				if(state == ItemEvent.SELECTED) {
					String s = (String)cb.getSelectedItem();

					if(s.equals("TOP"))
						tp.setTabPlacement(JTabbedPane.TOP);
					else if(s.equals("LEFT"))
						tp.setTabPlacement(JTabbedPane.LEFT);
					else if(s.equals("RIGHT"))
						tp.setTabPlacement(JTabbedPane.RIGHT);
					else if(s.equals("BOTTOM"))
						tp.setTabPlacement(JTabbedPane.BOTTOM);

					tp.validate();
				}
			}
		});
	}
	//������Ͽ��ֵ
		private void setComboValue() {
		int placement = tp.getTabPlacement();
		String selectedItem = null;

		switch(placement) {
			case JTabbedPane.TOP:
					selectedItem = "TOP";
					break;
			case JTabbedPane.LEFT:
					selectedItem = "LEFT";
					break;
			case JTabbedPane.RIGHT:
					selectedItem = "RIGHT";
					break;
			case JTabbedPane.BOTTOM:
					selectedItem = "BOTTOM";
					break;
		}
		combo.setSelectedItem(selectedItem);
	}
}
