//Animate.java
import java.awt.*;
import java.util.*;

public class Animate extends ExitableJFrame {
	//��������
	private static int DELAY = 100;
	
	Insets inset;
	//��ɫ����
	Color colors[] = {
		Color.red,
		Color.orange,
		Color.yellow,
		Color.green,
		Color.blue,
		Color.magenta
	};
	//��������
	public void paint(Graphics g) {
		super.paint(g);
		if (inset == null) {
			inset = getInsets();
		}
		//�ı䴰�ڴ�С
		int x = inset.left;
		int y = inset.top;
		int width = getWidth() - inset.left - inset.right;
		int height = getHeight() - inset.top - inset.bottom;
		int start = 0;
		int steps = colors.length;
		int stepSize = 360 / steps;
		synchronized (colors){
			for (int i=0; i<steps;i++){
				g.setColor(colors[i]);
				g.fillArc(x,y,width,height,start,stepSize);
				start += stepSize;
			}
		}
	}
	//ִ��
	public void go(){
		TimerTask task = new TimerTask(){
			public void run() {
				Color c = colors[0];
				synchronized (colors){
					System.arraycopy(colors, 1,colors, 0,colors.length-1);
					 colors[colors.length-1] = c;
					}
					repaint();
				}
			};
			Timer timer = new Timer();
			timer.schedule(task,0,DELAY);
		}
		//������
	public static void main(String arg[]){
		Animate f = new Animate();
		f.setSize(200,200);
		f.show();
		f.go();
	}
		}