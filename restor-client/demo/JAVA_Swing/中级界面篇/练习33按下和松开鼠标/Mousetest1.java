//Mousetest1.java
//��Ҫ�����ǵ�������갴��ʱ�����һ���ַ�A��
//���ɿ���갴��ʱ������궯�����м�����
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Event;
import java.applet.Applet;

public class Mousetest1 extends Applet  {
  final int MaxMarks=40;
  int CurMarks=0;
  int hSum=0;
  int hPaintMark=0;
  Point Marks[]=new Point[MaxMarks];
  //������갴��ʱ���õķ�����
  public boolean mouseDown(Event evt,int x,int y)  {
   if(CurMarks<MaxMarks) {
    Marks[CurMarks++]=new Point(x,y);
    hPaintMark=1;
    repaint();
   }
   return true;
  }
 //�ɿ���갴��ʱ���õķ�����
  public boolean mouseUp(Event evt,int x,int y) {
   hSum +=1;
   hPaintMark=2;
   repaint();
   return true;
  }
 public void paint(Graphics g) {
  switch(hPaintMark) {
   case 1:
    for(int i=0;i<CurMarks;i++) {
     g.drawString("A",Marks[i].x,Marks[i].y);
    }
    break;
   case 2:
    for(int i=0;i<CurMarks;i++) {
     g.drawString("A",Marks[i].x,Marks[i].y);
    }
    g.drawString("����¼��Ĵ���="+hSum,10,10);
    break;
   }
  hPaintMark=0;
 }
}
