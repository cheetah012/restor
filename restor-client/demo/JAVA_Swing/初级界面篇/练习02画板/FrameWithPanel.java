//FrameWithPanel.java
import java.awt.*;
public class FrameWithPanel extends Frame{
	
	
	//���캯��
	public FrameWithPanel (String str) {
	super(str);
	}
	
	
	public static void main(String args[]){
		FrameWithPanel fr = new FrameWithPanel("Frame with Panel");
		//���������Ϊ"Frame With Panel"
		Panel pan = new Panel( );
		
		
		fr.setSize(400,300);
		//����ܴ�С����Ϊ��400��300��
		fr.setBackground(Color.black);
		//����ܱ�����ɫ��Ϊ��ɫ
		fr.setLayout(null);
		pan.setSize(200,150);
		//�������С����Ϊ��200��150��
		pan.setBackground(Color.white);
		//��������ɫ��Ϊ��ɫ
		
		
		fr.add(pan);
		fr.setVisible(true);
	}
}