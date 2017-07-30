//TTimer.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.*;

public class TTimer extends JApplet {
    Container container = null;
    Timer timer = null;
    JLabel label = null;
    JSlider slider1 = null;
    JSlider slider2 = null;
    Color[] color = {Color.blue, Color.green, Color.red,
                     Color.yellow, Color.lightGray};

    public void init() {
        //�õ�С��������������
        container = this.getContentPane();

        //������̬��ǩ
        label = new JLabel("��һʱ�䣡", JLabel.CENTER);
        label.setBackground(Color.black);
        label.setFont(new Font("Dialog", Font.BOLD, 40));
        label.setOpaque(true);
        container.add(label);

        //����ˮƽ����      
        Box box = Box.createHorizontalBox();
        container.add(box, BorderLayout.SOUTH);
        
        //������ֱ���� 
        Box vbox1 = Box.createVerticalBox();
        box.add(vbox1);

        //������ǩ�ͻ���
        JLabel initDelay = new JLabel("��������ʱ�䣺��----����", JLabel.CENTER);
        initDelay.setPreferredSize(new Dimension(200, 25));
        vbox1.add(initDelay);
        slider1 = new JSlider(JSlider.HORIZONTAL, 0, 60000, 0);
        slider1.addChangeListener(new SliderListener());
        vbox1.add(slider1);
        JLabel delay = new JLabel("��ɫ�仯ʱ�䣺��----����", JLabel.CENTER);
        delay.setPreferredSize(new Dimension(200, 25));
        vbox1.add(delay);
        slider2 = new JSlider(JSlider.HORIZONTAL, 0, 2000, 1000);
        slider2.addChangeListener(new SliderListener());
        vbox1.add(slider2);

        Box vbox2 = Box.createVerticalBox();
        box.add(vbox2);

        //������һ�����
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,2,5,5));
        vbox2.add(panel);
        //������ť
        String[] buttonLabels = {"��ʼ", "ֹͣ", "��������"};
        for (int i=0; i<buttonLabels.length; i++) {
            JButton button = new JButton(buttonLabels[i]);
            button.addActionListener(new ButtonListener());
            panel.add(button);
        }

        //����ʱ��ؼ�
        timer = new Timer(slider2.getValue(), new TimerListener());
        timer.setInitialDelay(slider1.getValue()); 
    }

        //������Ϣ
    class TimerListener implements ActionListener {
        int i;

        public void actionPerformed(ActionEvent e) {
            if (i == color.length) {
                i = 0;
                label.setForeground(color[i]);
            }
            else {
                label.setForeground(color[i]);
            }
            label.repaint();
            i++;
        }
    }

    //������ť��Ϣ
    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();

            if (button.getText() == "��ʼ") {
                timer.start();
            }
            else if (button.getText() == "ֹͣ") {
                timer.stop();
            }
            else if (button.getText() == "��������") {
                timer.restart();
            }
        }
    }

    //����������Ϣ
    class SliderListener implements ChangeListener {
        public void stateChanged(ChangeEvent e) {
            JSlider slider = (JSlider) e.getSource();

            if (slider == slider1) {
                timer.setInitialDelay(slider1.getValue());
            }
            else if (slider == slider2) {
                timer.setDelay(slider2.getValue());
            }
        }
    }
}