//HyperlinkTest.java
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

public class HyperlinkTest {
	//������
	public  static void main(String args[]){
		//��������
		JFrame eframe = new ExitableJFrame("Hyperlink Listener");
		//ʵ��������
		Container contentPane = eframe.getContentPane();
		//ʵ�����༭���
		final JEditorPane ep = new JEditorPane();
		//�趨Ŀ����ҳ
		try {
			ep.setPage("http://www.sohu.com");
		}catch(IOException e){
			System.err.println("Bad URL:"+e);
			System.exit(-1);
		}
		//�趨�������¼�����
		HyperlinkListener listener = new HyperlinkListener(){
		public void hyperlinkUpdate(HyperlinkEvent e){
			if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED){
				try{
				ep.setPage(e.getURL());
			}catch(IOException ioe){
				System.err.println("Error loading:"+ioe);
			}
			}
		  }
	        };
	//����¼�����        
 	ep.addHyperlinkListener(listener);
 	//�趨���ɱ༭
 	ep.setEditable(false);
 	//ʵ�����������
 	JScrollPane pane = new JScrollPane(ep);
 	contentPane.add(pane,BorderLayout.CENTER);
 	//�趨���ڳߴ�
 	eframe.setSize(640,480);
 	eframe.show();
}
}
			
