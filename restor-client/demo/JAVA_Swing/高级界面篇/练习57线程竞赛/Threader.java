//Threader.java
import java.awt.Graphics;
import java.awt.Color;

public class Threader extends java.awt.Canvas implements Runnable {
  int myPosition =0;
  String myName;
  int numberofSteps=600;
  boolean keepRunning = true;
  //���캯��
  public Threader (String inName){
    myName=new String (inName);
  }

  public synchronized void paint(Graphics g){
    //Ϊ�߳̾�����һ��ֱ��
    g.setColor (Color.black);
    g.drawLine (0,getSize().height/2,getSize().width,getSize().height/2);

    //��������.
    g.setColor (Color.yellow);
    g.fillOval((myPosition*getSize().width/numberofSteps),0,15,getSize().height);
  }

  public void stop(){
    keepRunning = false;
  }

  public void run(){
    //ѭ��ֱ������ֹͣ
    while ((myPosition <numberofSteps)&& keepRunning){
      myPosition++;
      repaint();

      //����ǰ�߳�˯�ߣ�������������.
      try{
        Thread.currentThread().sleep(10);
      }catch (Exception e){System.out.println("Exception on sleep");}
    }
    System.out.println("Threader:"+myName+" has finished the race");
  }


}//end class Threader. 
