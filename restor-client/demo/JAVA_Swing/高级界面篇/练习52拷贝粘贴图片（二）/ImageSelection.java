//ImageSelection.java
import java.awt.*;
import java.awt.datatransfer.*;
import java.io.*;

public class ImageSelection implements Transferable,
                                       ClipboardOwner {
    //��������                                       	
	static public DataFlavor ImageFlavor;

	private DataFlavor[] flavors = {ImageFlavor}; 
	private Image image;
	//��̬����
	static {
		try {
			ImageFlavor = new DataFlavor(
				Class.forName("java.awt.Image"), "AWT Image");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//ѡ��ͼƬ�Ĺ��캯��
	public ImageSelection(Image image) {
		this.image = image;
	}
	//��������
	public synchronized DataFlavor[] getTransferDataFlavors() {
		return flavors;
	}
	//�Ƿ�֧�ֵ�ǰ���ݸ�ʽ
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		return flavor.equals(ImageFlavor);
	}
	//�õ���ǰ����
	public synchronized Object getTransferData(DataFlavor flavor) 
		throws UnsupportedFlavorException, IOException {
		//���֧�ֵ�ǰ���ݸ�ʽ	
		if(flavor.equals(ImageFlavor)) {
			return image;
		}
		//�����֧�ֵ�ǰ���ݸ�ʽ
		else {
			throw new UnsupportedFlavorException(flavor);
		}
	}
	public void lostOwnership(Clipboard c, Transferable t) {
	}
}
