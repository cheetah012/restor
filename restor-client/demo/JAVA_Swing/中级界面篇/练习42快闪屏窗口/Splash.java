//Splash.java 
//��Window�������������������
import java.awt.*;

public class Splash extends Frame
{
	//frame�Ĺ��췽��
    public Splash()
    {
    	//��ȡ�����������ͼ��
    	Image imgSplash=Toolkit.getDefaultToolkit().getImage("splash.gif");
    	//����װ��Imageͼ���Panel
    	ImagePane pnlImage=new ImagePane( imgSplash );
    	//�������������ڲ���ͼ��Panel��������
    	Window splashWindow=new Window(this);
    	splashWindow.add(pnlImage,BorderLayout.CENTER);
    	//��ȡ������Ļ�ĳߴ��С
    	Dimension scmSize=Toolkit.getDefaultToolkit().getScreenSize();
    	//ͼ��Ŀ�͸�
    	int nImageWidth=imgSplash.getWidth(this);
    	int nImageHeight=imgSplash.getHeight(this);
    	//���ÿ��������ڵĴ�С�;���λ��
    	splashWindow.setSize(nImageWidth,nImageHeight);
    	splashWindow.setLocation(scmSize.width/2-nImageWidth/2,scmSize.height/2-nImageHeight/2);
    	//��ʾ���������ڲ���֮��ǰ��
    	splashWindow.show();
    	splashWindow.toFront();
    	
    	try
    	{
    		//ʹ��ǰ�߳�˯��10����ģ��Ӧ�ó����װ��
    		Thread.currentThread().sleep(10000);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();	
    	}    	    	
    	//�رտ��������岢�ͷŸô������Դ
		splashWindow.dispose();
	}
	//�������ڷ���
	public static void main( String[] args )
	{
		//������ܴ���
		Splash frmSplash=new Splash();
		//�����˳�Java�����
		System.exit(0);		
	}
}
//��װװ��ͼ���Panel
class ImagePane extends Panel
{
	private Image imgSplash;
	public ImagePane(Image image)
	{
		MediaTracker mt=new MediaTracker(this);
		mt.addImage(image,0);
		try
		{
			mt.waitForID(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		this.imgSplash=image;
		
	}
	//����ͼ��
	public void paint(Graphics g)
	{
		g.drawImage(imgSplash,0,0,this);
	}
	//����ͼ��Panel�Ĵ�С
	public Dimension getPreferredSize()
	{
		return new Dimension( imgSplash.getWidth(this),imgSplash.getHeight(this));
	}
	
}