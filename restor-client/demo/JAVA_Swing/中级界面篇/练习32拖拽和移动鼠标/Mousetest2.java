//Mousetest2.java
//��Ҫ�����ǵ��ƶ����ʱ����ʾ��������λ�ã�
//����ק���ʱ����һ��ֱ�ߡ�
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Event;
import java.applet.Applet;
import java.awt.Color;

public class Mousetest2 extends Applet  {
  final int MaxMarks=40;
  int CurMarks=0;
  Point MarkStarts[]=new Point[MaxMarks];
  Point MarkEnds[]=new Point[MaxMarks];
  Point StartPoint,CurPoint;
  String CurMessage="";

  //������갴��ʱ���õķ�����
  public boolean mouseDown(Event evt,int x,int y)  {
   if(CurMarks<MaxMarks) {
    StartPoint=new Point(x,y);
   }
   return true;
  }

  //�ɿ���갴��ʱ���õķ�����
  public boolean mouseUp(Event evt,int x,int y) {
   if(CurMarks<MaxMarks) {
    MarkStarts[CurMarks]=StartPoint;
    MarkEnds[CurMarks]=CurPoint;
    CurMarks++;
    StartPoint=null;
    CurPoint=null;
    repaint();
   }
   return true;
  }

  //����ק���ʱ���õķ�����
  public boolean mouseDrag(Event evt,int x,int y) {
   if(CurMarks<MaxMarks) {
    CurPoint=new Point(x,y);
    repaint();
    }
    return true;
  }

  //���ƶ����ʱ���õķ�����
  public boolean mouseMove(Event evt,int x,int y) {
   CurMessage="��������λ��Ϊ��"+x+","+y+"��";
   repaint();
   return true;
  }

 public void paint(Graphics g) {
  int x1,y1,x2,y2;
  g.drawString(CurMessage,10,10);
  for(int i=0;i<CurMarks;i++) {
   x1=MarkStarts[i].x;
   y1=MarkStarts[i].y;
   x2=MarkEnds[i].x;
   y2=MarkEnds[i].y;
   g.setColor(Color.blue);
   g.drawLine(x1,y1,x2,y2);
  }
  if(StartPoint!=null) {
   x1=StartPoint.x;
   y1=StartPoint.y;
   x2=CurPoint.x;
   y2=CurPoint.y;
   g.setColor(Color.blue);
   g.drawLine(x1,y1,x2,y2);
  }
 }
}
