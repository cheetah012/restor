//ClipboardTest2.java
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;

//�����������õ��˽ӿ�ClipboardOwner
public class ClipboardTest2 extends    Applet 
                           implements ClipboardOwner {
	//��������                           	
	private Clipboard   clipboard;
	private ImageCanvas copyFrom = new ImageCanvas();
	private ImageCanvas copyTo   = new ImageCanvas();
	private Button copy  = new Button("����");
	private Button paste = new Button("ճ��");

	//��ʼ������
	public void init() {
		clipboard = new Clipboard("image clipboard");
		//�õ�Ҫ���Ƶ�ͼƬ
		copyFrom.setImage(getImage(getCodeBase(),"skelly.gif"));
		add(copyFrom);
		add(copyTo);
		add(copy);
		add(paste);
		//����¼�����
		copy.addActionListener (new CopyListener());
		paste.addActionListener(new PasteListener());
	}
	//������
	class CopyListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			////ʵ����ImageSelection��
			ImageSelection contents = 
						new ImageSelection(copyFrom.getImage());
	
			clipboard.setContents(contents, ClipboardTest2.this);
		}
	}
	//ճ����
	class PasteListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Transferable contents = clipboard.getContents(this);

			if(contents != null && 
				contents.isDataFlavorSupported(
					ImageSelection.ImageFlavor)) {
				try {
					Image image;
					image = (Image) contents.getTransferData(
							 ImageSelection.ImageFlavor);
					copyTo.setImage(image);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void lostOwnership(Clipboard    clip, 
	                          Transferable transferable) {
		System.out.println("Lost ownership");
	}
}
//������
class ImageCanvas extends Panel {
    private Image image;
	//���������Ĺ��캯��
	public ImageCanvas() {
		this(null);
	}
	//�������Ĺ��캯��
    public ImageCanvas(Image image) {
		if(image != null)
			setImage(image);
    }
    //��������
    public void paint(Graphics g) {
		g.setColor(Color.lightGray);

		g.draw3DRect(0,0,getSize().width-1,
		                 getSize().height-1,true);

		if(image != null) {
        	g.drawImage(image, 1, 1, this);
		}
    }
    //���º���
    public void update(Graphics g) {
        paint(g);
    }
    //����ͼƬ����
	public void setImage(Image image) {
		this.image = image;
		try {
			MediaTracker tracker = new MediaTracker(this);
			tracker.addImage(image, 0);
        	tracker.waitForID(0);
		}
		catch(Exception e) { e.printStackTrace(); }

		if(isShowing()) {
			repaint();
		}
	}
	//�õ�ͼƬ����
	public Image getImage() {
		return image;
	}
	public Dimension getPreferredSize() {
		return new Dimension(100,100);
	}
}
