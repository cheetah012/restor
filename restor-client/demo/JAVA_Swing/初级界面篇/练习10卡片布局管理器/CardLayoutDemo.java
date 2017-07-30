//CardLayoutDemo.java
import java.awt.*;
import java.awt.event.*;

public class CardLayoutDemo extends Frame
{
	//�����ĸ����ܰ�ť��Panel�Ķ���ʹ���
	Panel pnlCommandArea=new Panel();
	//��ʾ����Panel�Ķ���ʹ���
	Panel pnlDisplayArea=new Panel();
	//CardLayout���ֹ������Ĵ���
	CardLayout cardlayout1=new CardLayout();
	//�ĸ����ܰ�ť�Ķ���ʹ���
	Button btnFirst=new Button("��һ��");
	Button btnPrevious=new Button("ǰһ��");	
	Button btnNext=new Button("��һ��");
	Button btnLast=new Button("���һ��");
	
	//��ܴ���Ĺ��췽��
	public CardLayoutDemo()
	{
		super("��Ƭ���ֹ�����");
		
		//�ĸ����ܰ�ť����ɫ����	
		btnFirst.setBackground(Color.white);
		btnPrevious.setBackground(Color.white);		
		btnNext.setBackground(Color.white);		
		btnLast.setBackground(Color.white);
		
		//����Frame�Ĳ��ֹ�����ΪBorderLayout
		this.setLayout(new BorderLayout());
		//������Panel���뵽���ֹ�������
		this.add( pnlCommandArea, BorderLayout.NORTH);
		this.add( pnlDisplayArea, BorderLayout.CENTER);

		//����ʾ��������Panel�Ĳ��ֹ���������ΪCardLayout
		pnlDisplayArea.setLayout(cardlayout1);
		//������һ����ʾPanel
		Panel pnlFirst=new Panel();		
		pnlFirst.setBackground(Color.yellow);
		pnlFirst.setForeground(Color.blue);
		pnlDisplayArea.add("first",pnlFirst);
		pnlFirst.add(new Label("���ǵ�һ�ſ�Ƭ") );
		//�����ڶ�����ʾPanel
		Panel pnlSecond=new Panel();		
		pnlSecond.setBackground(Color.pink);
		pnlSecond.setForeground(Color.blue);
		pnlDisplayArea.add("second",pnlSecond);
		pnlSecond.add(new Label("���ǵڶ��ſ�Ƭ") );
		//������������ʾPanel
		Panel pnlThird=new Panel();		
		pnlThird.setBackground(Color.orange);
		pnlThird.setForeground(Color.blue);
		pnlDisplayArea.add("third",pnlThird);
		pnlThird.add(new Label("���ǵ����ſ�Ƭ") );
		//�������ĸ���ʾPanel
		Panel pnlFourth=new Panel();		
		pnlFourth.setBackground(Color.green);
		pnlFourth.setForeground(Color.blue);
		pnlDisplayArea.add("fourth",pnlFourth);
		pnlFourth.add(new Label("���ǵ����ſ�Ƭ") );

		//Ϊ�ĸ����ܰ�ť�����¼�������
		btnFirst.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) 
            {
                processAction(e);
            }
		});				
		btnPrevious.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) 
            {
                processAction(e);
            }
		});	
		btnNext.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) 
            {
                processAction(e);
            }
		});
		btnLast.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) 
            {
                processAction(e);
            }
		});
		//���ĸ����ܰ�ť���뵽Panel
		pnlCommandArea.add( btnFirst );
		pnlCommandArea.add( btnPrevious );
		pnlCommandArea.add( btnNext );
		pnlCommandArea.add( btnLast );
	}
	
	//�������ڷ���
	public static void main( String[] args )
	{
		//������ܴ����ʵ��
		CardLayoutDemo frmCardLayout = new CardLayoutDemo();
		
		//���ÿ�ܴ�����¼�����(�رմ����¼�)
		frmCardLayout.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e)
			{
				//�����˳�Java�����
				System.exit(0);
			}
		});

		//��ʾ��ܴ���
		frmCardLayout.pack();
		frmCardLayout.show();
	}
	//���ÿ�ܴ���Ĵ�СΪ300��300
	public Dimension getPreferredSize()
	{
		return new Dimension(300,300);
	}
	//����ť���¼�
	private void processAction(ActionEvent e)
	{
		//��ȡ�¼�Դ���û�ѡ�����ĸ���ť��
		Button btnEvent=(Button)e.getSource();
		
		if( btnEvent.equals(btnFirst))
			cardlayout1.first( pnlDisplayArea );
		else if( btnEvent.equals(btnLast))
			cardlayout1.last( pnlDisplayArea );
		else if( btnEvent.equals(btnPrevious))
			cardlayout1.previous( pnlDisplayArea );
		else if( btnEvent.equals(btnNext))
			cardlayout1.next( pnlDisplayArea );		
	}
}