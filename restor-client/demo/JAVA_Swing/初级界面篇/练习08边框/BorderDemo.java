//BorderDemo.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.*;

public class BorderDemo extends JFrame 
{
    public BorderDemo() 
    {
        //���ÿ�ܴ��ڵı���
        super("ʹ�ñ߿������");
        //����5�������͵ı߿�
        Border blackline, etched, raisedbevel, loweredbevel, empty;
        //������ɫ����״�߿�
        blackline = BorderFactory.createLineBorder(Color.black);
        //����ʴ�̱߿�
        etched = BorderFactory.createEtchedBorder();
        //����͹���߿�
        raisedbevel = BorderFactory.createRaisedBevelBorder();
        //�������ݱ߿�
        loweredbevel = BorderFactory.createLoweredBevelBorder();
        //�����յı߿�
        empty = BorderFactory.createEmptyBorder();

        //��һ����壺�򵥱߿�
        JPanel simpleBorders = new JPanel();
        simpleBorders.setLayout(new BoxLayout(simpleBorders, BoxLayout.Y_AXIS));

        addCompForBorder(blackline, "��״�߿�",simpleBorders);
        addCompForBorder(etched, "ʴ�̱߿�",simpleBorders);
        addCompForBorder(raisedbevel, "͹���߿�",simpleBorders);
        addCompForBorder(loweredbevel, "���ݱ߿�",simpleBorders);
        addCompForBorder(empty, "�յı߿�",simpleBorders);

     
        //�ڶ�����壺���б�������
        JPanel titledBorders = new JPanel();
        titledBorders.setLayout(new BoxLayout(titledBorders,BoxLayout.Y_AXIS));
        TitledBorder titled;

        titled = BorderFactory.createTitledBorder("����");
        addCompForBorder(titled,
                         "���������״�߿�"
                         + " (����Ĭ�ϵ�λ�������)",
                         titledBorders);

        titled = BorderFactory.createTitledBorder(blackline, "����");
        addCompForTitledBorder(titled,
                               "������ĺ�ɫ����״�߿�"
                                   + " (����Ĭ�ϵ�λ��������)",
                               TitledBorder.CENTER,
                               TitledBorder.DEFAULT_POSITION,
                               titledBorders);

        titled = BorderFactory.createTitledBorder(etched, "����");
        addCompForTitledBorder(titled,
                               "�������ʴ�̱߿�"
                                   + " (����Ĭ�ϵ�λ�����Ҷ�)",
                               TitledBorder.RIGHT,
                               TitledBorder.DEFAULT_POSITION,
                               titledBorders);

        titled = BorderFactory.createTitledBorder(loweredbevel, "����");
        addCompForTitledBorder(titled,
                               "������İ��ݱ߿�"
                                   + " (����Ĭ�ϵ�λ�����϶�)",
                               TitledBorder.DEFAULT_JUSTIFICATION,
                               TitledBorder.ABOVE_TOP,
                               titledBorders);

        titled = BorderFactory.createTitledBorder(empty, "����");
        addCompForTitledBorder(titled, "������Ŀյı߿�"
                               + " (����Ĭ�ϵ�λ�����¶�)",
                               TitledBorder.DEFAULT_JUSTIFICATION,
                               TitledBorder.BOTTOM,
                               titledBorders);

  
        //����TabbledPane���
        JTabbedPane tabbedPane = new JTabbedPane();
        
        tabbedPane.addTab("�򵥵ı߿�", null, simpleBorders, null);
       
        tabbedPane.addTab("���б���ı߿�", null, titledBorders, null);
 
        tabbedPane.setSelectedIndex(0);

        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

	//��Ӵ��б���ı߿�
    void addCompForTitledBorder(TitledBorder border,
                                String description,
                                int justification,
                                int position,
                                Container container) 
    {
        border.setTitleJustification(justification);
        border.setTitlePosition(position);
        addCompForBorder(border, description,
                         container);
    }

	//��Ӽ򵥵ı߿�
    void addCompForBorder(Border border,
                          String description,
                          Container container) 
    {
        JPanel comp = new JPanel(false);
        JLabel label = new JLabel(description, JLabel.CENTER);
        comp.setLayout(new GridLayout(1, 1));
        comp.add(label);
        comp.setBorder(border);

        container.add(Box.createRigidArea(new Dimension(0, 10)));
        container.add(comp);
    }

	//�������ڷ���
    public static void main(String[] args) 
    {
        JFrame frame = new BorderDemo();
        //��ӿ�ܴ��ڵ��¼������������رտ�ܴ����¼���
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                //�����Ƴ�Java�����
                System.exit(0);
            }
        });

		//��ʾ��ܴ���
        frame.pack();
        frame.setVisible(true);
    }
}