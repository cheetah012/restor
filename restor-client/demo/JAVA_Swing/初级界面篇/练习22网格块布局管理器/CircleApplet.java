//CircleApplet.java
import java.applet.*;
import java.awt.*;
//�����������Լ�д����CircleCanvas
public class CircleApplet extends Applet
{
     public void init()
     {
     	  //��������
          GridBagLayout gridbag = new GridBagLayout();
          GridBagConstraints constraints = new GridBagConstraints();
          CircleCanvas newCircle;
	      //���ý��沼�ַ�ʽ
          setLayout(gridbag);
          //���û�Բ����
          constraints.weightx = 1.0;
          constraints.weighty = 1.0;
          constraints.fill = GridBagConstraints.BOTH;
	      //����һ��Բ���Ҽ���
          newCircle = new CircleCanvas(Color.red);
          gridbag.setConstraints(newCircle, constraints);
          add(newCircle);
		  //���ô�Բ����
          constraints.weightx = 2.0;
          constraints.weighty = 2.0;
          //����һ����ɫԲȦ���Ҽ���
          newCircle = new CircleCanvas(Color.blue);
          gridbag.setConstraints(newCircle, constraints);
          add(newCircle);
          //����������Բ������һ��һ����
          constraints.weightx = 1.0;
          constraints.weighty = 1.0;
          //����һ����ɫԲȦ���Ҽ���       
          newCircle = new CircleCanvas(Color.green);
          gridbag.setConstraints(newCircle, constraints);
          add(newCircle);          
     }
}
