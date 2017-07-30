//WavyText.java
import java.applet.Applet;
import java.applet.AppletContext;
import java.awt.*;
import java.io.PrintStream;
import java.net.URL;

public class WavyText extends Applet
    implements Runnable
{
    //��������
    Image gif = null;
    Image gifsec[] = null;
    Image curpic = null;
    Graphics curpicgr = null;
    float ang = 0;
    float theta = 0;
    String pageurl = null;
    int delay = 0;
    int strip = 0;
    int xoffset = 0;
    int peak = 0;
    Thread killme = null;
    boolean paused = false;
    //��ʼ��С����
    public void init()
    {
        setBackground(Color.black);
        if(getParameter("delay") == null)
            delay = 100;
        else
            delay = (new Integer(getParameter("delay"))).intValue();
        if(getParameter("strip") == null)
            strip = 1;
        else
            strip = (new Integer(getParameter("strip"))).intValue();
        if(getParameter("theta") == null)
            theta = 0.1F;
        else
            theta = Float.valueOf(getParameter("theta")).floatValue();
        if(getParameter("offset") == null)
            xoffset = 0;
        else
            xoffset = (new Integer(getParameter("offset"))).intValue();
        if(getParameter("peak") == null)
            peak = 0;
        else
            peak = (new Integer(getParameter("peak"))).intValue();
        pageurl = getParameter("url");
        ang = 0.0F;
    }
    //�õ�������ɫ
    Color getTextColor()
    {
        String s = getParameter("color");
        if(s == null)
            return Color.white;
        int k;
        int l;
        int i1;
        try
        {
            int i = s.indexOf(44);
            int j = s.indexOf(44, i + 1);
            k = Integer.parseInt(s.substring(0, i));
            l = Integer.parseInt(s.substring(i + 1, j));
            i1 = Integer.parseInt(s.substring(j + 1));
        }
        catch(Exception _ex)
        {
            System.out.println("Invalid 'rgb' specification.");
            return Color.white;
        }
        return new Color(k, l, i1);
    }
    //�������ֲ�����������
    void load_gifs()
    {
        gif = createImage(size().width, size().height);
        Graphics g = gif.getGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, size().width, size().height);
        int i;
        if(getParameter("size") == null)
            i = 24;
        else
            i = (new Integer(getParameter("size"))).intValue();
        String s = getParameter("text");
        if(s == null)
            s = "No Text Specified";
        g.setColor(getTextColor());
        g.setFont(new Font("TimesRoman", 1, i));
        g.drawString(s, 5, size().height - 8);
        make_imgs();
    }
    //����ͼƬЧ��
    void make_imgs()
    {
        gifsec = new Image[gif.getHeight(this) / strip + 1];
        for(int i = 0; i < gif.getHeight(this) / strip; i++)
        {
            gifsec[i] = createImage(gif.getWidth(this), strip);
            Graphics g = gifsec[i].getGraphics();
            g.drawImage(gif, 0, -i * strip, this);
        }

        ang += 0.10000000000000001D;
    }
    //����ͼƬЧ��
    void draw_imgs(Graphics g)
    {
        if(gif == null)
            return;
        g.setColor(Color.black);
        g.fillRect(0, 0, size().width, size().height);
        for(int i = 0; i < gif.getHeight(this) / strip; i++)
        {
            float f = ang + (float)i * theta;
            int j = (int)(Math.sin(f) * (double)peak);
            if(gifsec[i] != null)
                g.drawImage(gifsec[i], xoffset + j, i * strip, this);
        }

        ang += 0.10000000000000001D;
    }
    //ˢ����Ļ
    public void update(Graphics g)
    {
        if(curpic == null)
        {
            curpic = createImage(size().width, size().height);
            curpicgr = curpic.getGraphics();
            curpicgr.setColor(Color.black);
            curpicgr.fillRect(0, 0, size().width, size().height);
            return;
        }
        if(!paused)
            draw_imgs(curpicgr);
        g.draw3DRect(0, 0, size().width - 1, size().height - 1, true);
        g.drawImage(curpic, 0, 0, this);
    }
    //��������
    public void paint(Graphics g)
    {
        update(g);
    }
    //����С����
    public void run()
    {
        while(killme != null) 
        {
            repaint();
            try
            {
                Thread.sleep(delay);
            }
            catch(Exception _ex) { }
        }

    }
    //����С����
    public void start()
    {
        load_gifs();
        if(killme == null)
        {
            killme = new Thread(this);
            killme.start();
        }
    }
    //ֹͣС����
    public void stop()
    {
        killme = null;
    }
    //��Ӧ��������¼�
    public boolean mouseUp(Event event, int i, int j)
    {
        if(pageurl != null)
            try
            {
                getAppletContext().showDocument(new URL(getDocumentBase(), pageurl));
            }
            catch(Exception _ex)
            {
                System.out.println("WavyText Error: Could not show page");
            }
        return true;
    }
    //��Ӧ�������¼�
    public boolean mouseEnter(Event event, int i, int j)
    {
        requestFocus();
        if(pageurl != null)
            getAppletContext().showStatus(pageurl);
        else
            getAppletContext().showStatus("");
        return true;
    }
    //��Ӧ����뿪�¼�
    public boolean mouseExit(Event event, int i, int j)
    {
        getAppletContext().showStatus("");
        return true;
    }
    //��Ӧ���̰����¼�
    public boolean keyDown(Event event, int i)
    {
        paused = !paused;
        return true;
    }
    //���캯��
    public WavyText()
    {
        paused = false;
    }
}
