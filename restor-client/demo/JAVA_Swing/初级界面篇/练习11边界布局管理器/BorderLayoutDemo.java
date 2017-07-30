//BorderLayoutDemo.java
import java.awt.*;
import java.awt.event.*;

public class BorderLayoutDemo extends Frame
{
	public BorderLayoutDemo()
	{
		//���ÿ�ܴ��ڵĲ��ֹ�����ΪBorderLayoutDemo
		this.setLayout( new BorderLayout()); 
		
		//���ܴ������5��Button
		this.add( new Button("��"), BorderLayout.SOUTH);
		this.add( new Button("��") ,BorderLayout.NORTH);
		this.add( new Button("�м�") ,BorderLayout.CENTER);
		this.add( new Button("��") ,BorderLayout.WEST);
		this.add( new Button("��") ,BorderLayout.EAST);
		
	}
	public static void main( String[] args )
	{
		BorderLayoutDemo frmBorderLayout=new BorderLayoutDemo();
		
		//���ÿ�ܴ�����¼�����(�رմ����¼�)
		frmBorderLayout.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});

		//��ʾ��ܴ���
		frmBorderLayout.pack();
		frmBorderLayout.show();
	}
	//���ÿ�ܴ���Ĵ�СΪ300��300
	public Dimension getPreferredSize()
	{
		return new Dimension(300,300);
	}	
}