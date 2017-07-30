//Neon.java
import java.applet.Applet;
import java.awt.*;

public class Neon extends Applet
    implements Runnable
{  
    //��������
    Image mAge[] = null;
    int iMagNdx = 0;
    Thread endit = null;
    //��ʼ��С����
    public void init()
    {
    	resize(300, 250);
	setBackground(Color.orange);
    }
    //��������
    public void Paint(Graphics g)
    {
        update(g);
    }
    //ˢ������
    public void update(Graphics g)
    {
        if(mAge[iMagNdx] == null)
            g.drawString("Error loading pic", 0, 170);
        g.drawImage(mAge[iMagNdx], 0, 0, this);
    }
    //����С����
    public void start()
    {
        if(endit == null)
        {
            endit = new Thread(this);
            endit.start();
        }
    }
    //ֹͣС����
    public void stop()
    {
        endit = null;
    }
    //����С����
    public void run()
    {
    	mAge = new Image[2];
        String s = getParameter("picture1");
        String s1 = getParameter("picture2");
        mAge[0] = getImage(getDocumentBase(), s);
        mAge[1] = getImage(getDocumentBase(), s1);
        do
        {
            //ˢ����Ļ	 
            repaint();
            iMagNdx = iMagNdx != 0 ? 0 : 1;
            try
            {
            	//�߳�˯��
                Thread.sleep((int)(Math.random() * 500D));
            }
            catch(InterruptedException _ex) 
            {
            }
        }
        while(true);        
    }
}