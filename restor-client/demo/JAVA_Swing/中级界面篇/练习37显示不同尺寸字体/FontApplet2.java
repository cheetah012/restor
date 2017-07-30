//FontApplet2.java
import java.awt.*;
import java.applet.*;
public class FontApplet2 extends Applet
{
	//��������
    TextField textField;
    
    //��ʼ������
    public void init()
    {
        textField = new TextField(10);
        add(textField);
        textField.setText("32");
    }
    
    //��������
    public void paint(Graphics g)
    {
    	//������ʾ���ֵĸ߶�
        String s = textField.getText();
        int height = Integer.parseInt(s);        
        //������ʾ���ֵ�����
        Font font = new Font("TimesRoman", Font.PLAIN, height);
        g.setFont(font);
        FontMetrics fontMetrics = g.getFontMetrics(font);
        height = fontMetrics.getHeight();
        //������ʾ���ֵ���ʼ��
        int row = 80;
        //������ʾ����
        g.drawString("This is the first line.", 70, row);
        row += height;
        g.drawString("This is the second line.", 70, row);
        row += height;
        g.drawString("This is the third line.", 70, row);
        row += height;
        g.drawString("This is the fourth line.", 70, row);
    }
    
    //��Ӧ�û���������
    public boolean action(Event event, Object arg)
    {
        repaint();
        return true;
    }
}
