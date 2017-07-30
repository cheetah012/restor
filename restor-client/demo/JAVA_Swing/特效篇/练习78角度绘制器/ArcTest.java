//ArcTest.java
import java.awt.*;
import java.applet.*;

public class ArcTest extends Applet {
    ArcControls controls;
    //��ʼ��С����
    public void init() {
	setLayout(new BorderLayout());
	ArcCanvas c = new ArcCanvas();
	add("Center", c);
	add("South", controls = new ArcControls(c));
    }
    //����С����
    public void start() {
	controls.enable();
    }
    //ֹͣС����
    public void stop() {
	controls.disable();
    }
   //��Ӧ������Ϣ�¼�
    public boolean handleEvent(Event e) {
	if (e.id == Event.WINDOW_DESTROY) {
	    System.exit(0);
	}
	return false;
    }
   //������
    public static void main(String args[]) {
	Frame f = new Frame("�ǶȻ�����");
	ArcTest	arcTest = new ArcTest();

	arcTest.init();
	arcTest.start();

	f.add("Center", arcTest);
	f.resize(300, 300);
	f.show();
    }
}
    
//���Ƕ���
class ArcCanvas extends Canvas {
    int		startAngle = 0;
    int		endAngle = 45;
    boolean	filled = false;
    Font	font;

    public void paint(Graphics g) {
	Rectangle r = bounds();
	int hlines = r.height / 10;
	int vlines = r.width / 10;

	g.setColor(Color.pink);
	for (int i = 1; i <= hlines; i++) {
	    g.drawLine(0, i * 10, r.width, i * 10);
	}
	for (int i = 1; i <= vlines; i++) {
	    g.drawLine(i * 10, 0, i * 10, r.height);
	}

	g.setColor(Color.blue);
	if (filled) {
	    g.fillArc(0, 0, r.width - 1, r.height - 1, startAngle, endAngle);
	} else {
	    g.drawArc(0, 0, r.width - 1, r.height - 1, startAngle, endAngle);
	}

	g.setColor(Color.black);
	g.setFont(font);
	g.drawLine(0, r.height / 2, r.width, r.height / 2);
	g.drawLine(r.width / 2, 0, r.width / 2, r.height);
	g.drawLine(0, 0, r.width, r.height);
	g.drawLine(r.width, 0, 0, r.height);
	int sx = 10;
	int sy = r.height - 28;
	g.drawString("S = " + startAngle, sx, sy); 
	g.drawString("E = " + endAngle, sx, sy + 14); 
    }

    public void redraw(boolean filled, int start, int end) {
	this.filled = filled;
	this.startAngle = start;
	this.endAngle = end;
	repaint();
    }
}
//�Ƕȿ�����
class ArcControls extends Panel {
    TextField s;
    TextField e;
    ArcCanvas canvas;

    public ArcControls(ArcCanvas canvas) {
	this.canvas = canvas;
	add(s = new TextField("0", 4));
	add(e = new TextField("45", 4));
	add(new Button("�����ɫ"));
	add(new Button("���ƽǶ�"));
    }

    public boolean action(Event ev, Object arg) {
	if (ev.target instanceof Button) {
	    String label = (String)arg;

	    canvas.redraw(label.equals("�����ɫ"),
			  Integer.parseInt(s.getText().trim()),
			  Integer.parseInt(e.getText().trim()));

	    return true;
	}

	return false;
    }
}