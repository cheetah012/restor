//MyFrame.java
import java.awt.*;
public class MyFrame extends Frame {
	//������
	public static void main(String args[])  {
		MyFrame fr = new MyFrame("Hello,This is my frame !");
		//��������Component���setSize()����
		fr.setSize(400,200);
		//���ñ�����ɫ
		fr.setBackground(Color.blue);
		//���ô��ڿɼ�
		fr.setVisible(true);
	}
	//���캯��
	public MyFrame(String str){
		super(str);
	}
}