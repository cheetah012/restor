//StringApplet2.java
import java.awt.*;
import java.applet.*;
public class StringApplet2 extends Applet
{	
	//��������
    TextField textField1;
    TextField textField2;
    Button button1;
    String displayStr;
    //��ʼ������
    public void init()
    {
        Label label = new Label("String 1:");
        add(label);
        textField1 = new TextField(20);
        add(textField1);
        label = new Label("String 2:");
        add(label);
        textField2 = new TextField(20);
        add(textField2);
        button1 = new Button("Compare");
        add(button1);
        displayStr = "";
        resize(230, 200);
    }
    //��ʾ�ȽϽ������
    public void paint(Graphics g)
    {
        g.drawString(displayStr, 30, 150);
    }
    //��Ӧ�û���������
    public boolean action(Event evt, Object arg)
    {
        if (arg == "Compare")
        {
            String str1 = textField1.getText();
            String str2 = textField2.getText();
            int result = str1.compareTo(str2);
            if (result < 0)
                displayStr = "String1 is less than String2";
            else if (result == 0)
                displayStr = "String1 is equal to String2";
            else
                displayStr = "String1 is greater than String2";
            repaint();
            return true;
        }
        else
            return false;
    }
}

