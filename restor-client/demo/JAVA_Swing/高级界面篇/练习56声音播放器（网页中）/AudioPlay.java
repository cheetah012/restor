//AudioPlay.java 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
public class AudioPlay extends JApplet
implements ItemListener, ActionListener
  {
  private AudioClip audio1, audio2, audio;  
  private JButton play, loop, stop;
  private String item[] = {"music", "bird"};
  private JComboBox comboBox = new JComboBox(item);
  
  //������ƺͳ���ĳ�ʼ��
  public void init()
    {
    //ʵ����������
    Container c = getContentPane();
    c.setLayout(new FlowLayout(FlowLayout.CENTER));
    comboBox.addItemListener(this);
    c.add(comboBox);
    c.setBackground(Color.black);
    play = new JButton("����");
    play.addActionListener(this);
    c.add(play);
    loop = new JButton("ѭ��");
    loop.addActionListener(this);
    c.add(loop);
    stop = new JButton("ֹͣ");
    stop.addActionListener(this);
    c.add(stop);
    audio1 = getAudioClip(getDocumentBase(), "music.au");
    audio2 = getAudioClip(getDocumentBase(), "bird.au");
    audio = audio1;
    }
  //ֹͣ����
  public void stop()
    {
    audio.stop();
    }
  //ѡ��������ʱ�������¼�
  public void itemStateChanged(ItemEvent e)
    {
    audio.stop();
    audio = comboBox.getSelectedIndex()==0 ? audio1:audio2;
	}
  //��Ӧ��ť�¼�
  public void actionPerformed(ActionEvent e)
    {
    if (e.getSource()==play)
      audio.play();
    else if (e.getSource()==loop)
      audio.loop();
    else if (e.getSource()==stop)
      audio.stop();
    }
  }