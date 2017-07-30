//Test.java
import javax.swing.*;
import javax.swing.colorchooser.*;
import java.awt.*;
import java.awt.event.*;

public class Test extends JApplet {
	//��������
	private JColorChooser chooser = new JColorChooser();
	private JButton button = new JButton("Show Color Chooser");
	private JDialog dialog;
 
        //��ʼ������
	public void init() {
		//������������
		Container contentPane = getContentPane();

		contentPane.setLayout(new FlowLayout());
		contentPane.add(button, BorderLayout.CENTER);
                //ѡ���
		chooser.setPreviewPanel(new PreviewPanel());

                //�¼�����
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(dialog == null) 
					dialog	= JColorChooser.createDialog(
							    Test.this,  // parent comp
								"Pick A Color",   // dialog title
								false, 			  // modality
								chooser,		  
								null, null);

				dialog.setVisible(true);
			}
		});
	}
	//����Ԥ�����
	class PreviewPanel extends JPanel {
		public PreviewPanel() {
			setPreferredSize(new Dimension(0,100));
			setBorder(BorderFactory.createRaisedBevelBorder());
		}
		public void paintComponent(Graphics g) {
			Dimension size = getSize();

			g.setColor(getForeground());
			g.fillRect(0,0,size.width,size.height);
		}
	}
}
