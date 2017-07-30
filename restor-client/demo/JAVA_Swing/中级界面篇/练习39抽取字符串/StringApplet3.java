//StringApplet3.java
import java.awt.*;
import java.applet.*;
public class StringApplet3 extends Applet
{
	//��������
    TextField textField1;
    TextField textField2;
    TextField textField3;
    Button button1;
    String displayStr;
    //��ʼ������
    public void init()
    {
        Label label = new Label("String:");
        add(label);
        textField1 = new TextField(20);
        add(textField1);
        label = new Label("Start:");
        add(label);
        textField2 = new TextField(5);
        add(textField2);
        label = new Label("End:");
        add(label);
        textField3 = new TextField(5);
        add(textField3);
        button1 = new Button("Extract");
        add(button1);
        displayStr = "";
        resize(230, 200);
    }
    //ˢ������
    public void paint(Graphics g)
    {
        g.drawString("Selected substring:", 70, 130);
        g.drawString(displayStr, 70, 150);
    }
    //��Ӧ�û�����
    public boolean action(Event evt, Object arg)
    {
        if (arg == "Extract")
        {
            String str1 = textField1.getText();
            String str2 = textField2.getText();
            String str3 = textField3.getText();
            int start = Integer.parseInt(str2)-1;
            int end = Integer.parseInt(str3);
            displayStr = str1.substring(start, end);
            repaint();
            return true;
        }
        else
            return false;
    }
}
