//Emboss.java
import java.awt.*;
import java.applet.*;
import java.awt.geom.*;
import java.awt.font.*;
import java.awt.image.*;
import java.net.URL;

public class Emboss extends Applet
{

    public void paint(Graphics g)
    {
        //ʵ����Graphics2D ��
        Graphics2D newG = (Graphics2D) g;
        //����һ��ͼƬ������ʾ 
        URL imgURL = null;
        try {
            imgURL = new URL(getDocumentBase(), "sunflower.jpg");
        } catch (Exception ignore) {
        }

        Image img = getImage(imgURL);

        MediaTracker tracker = new MediaTracker(this);
        try {
            tracker.addImage(img, 0);
            tracker.waitForAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //�õ�ͼƬ�ĳߴ�
        int width = img.getWidth(this);
        int height = img.getHeight(this);
        //����һ������������ͼƬ����
        BufferedImage buff = new BufferedImage(width,
            height, BufferedImage.TYPE_INT_ARGB);
        Graphics tempGr = buff.createGraphics();
        tempGr.drawImage(img, 0, 0, this);
        //����һ��ͼ�񻺳�������ž�����������ͼƬ 
        BufferedImage outBuff = new BufferedImage(width,
            height, BufferedImage.TYPE_INT_ARGB);
        embossImage(buff, outBuff);
        newG.drawImage(outBuff, 100, 100, this);
    }

    //��ͼƬ���и�����
    public void embossImage(BufferedImage srcImage, BufferedImage destImage)
    {

        int width = srcImage.getWidth();
        int height = srcImage.getHeight();

        // ��ÿһ�����ؽ���ѭ������
        for (int i=0; i < height; i++) {
            for (int j=0; j < width; j++) {

       //ȷ���������¶�Ϊ0
                int upperLeft = 0;
                int lowerRight = 0;
                //����
                if ((i > 0) && (j > 0)) {
                   upperLeft = srcImage.getRGB(j-1, i-1) 
                        & 0xffffff;
                }
                //����
                if ((i < height-1) && (j < width-1)) {
                    lowerRight = srcImage.getRGB(j+1, i+1) 
                        & 0xffffff;
                }

                // �õ���ɫ����ɫ����ɫ֮��Ĳ��
                int redDiff = ((lowerRight >> 16) & 255) -
                    ((upperLeft >> 16) & 255);
                int greenDiff = ((lowerRight >> 8) & 255) -
                    ((upperLeft >> 8) & 255);
                int blueDiff = (lowerRight & 255) -
                    (upperLeft & 255);

                // ������һ����ɫ�ı仯���
                int diff = redDiff;
                if (Math.abs(greenDiff) > Math.abs(diff)) 
                    diff=greenDiff;
                if (Math.abs(blueDiff) > Math.abs(diff)) 
                    diff=blueDiff;

		// ���仯������ɫ��Ϊ��ɫ
                int greyColor = 128 + diff;

                // �����ɫ������߹�ǳ���ı䵽0-255֮��ķ�Χ
                if (greyColor > 255) greyColor = 255;
                if (greyColor < 0) greyColor = 0;
		
		//����һ���µ���ɫ
                int newColor = 0xff000000 + (greyColor << 16) +
                    (greyColor << 8) + greyColor;

                destImage.setRGB(j, i, newColor);
            }
        }
    }
}
