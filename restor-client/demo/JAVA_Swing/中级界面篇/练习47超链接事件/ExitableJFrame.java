//ExitableJFrame.java
import javax.swing.*;

public class ExitableJFrame extends JFrame{
        //���캯��
	public ExitableJFrame(){
	}
	//�����ڱ���Ĺ��캯��
	public ExitableJFrame(String title){
		super(title);
	}
	//���ڵĳ�ʼ��
	protected void frameInit(){
		super.frameInit();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	}