//CursorChoiceTest.java
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class CursorChoiceTest extends Applet {
	//ʵ����CursorChoice
	private CursorChoice cursorChoice = new CursorChoice();	
	//�����ʼ��
    public void init() {
		add(cursorChoice);
		//�¼�����
		cursorChoice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				setCursor(cursorChoice.getSelectedCursor());
			}
		});
    }
}
