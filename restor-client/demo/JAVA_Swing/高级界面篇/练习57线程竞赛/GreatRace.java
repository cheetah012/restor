//GreatRace.java
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Frame;

public class GreatRace extends java.applet.Applet implements Runnable{
  Threader theRacers[];
  static int racerCount = 3;
  Thread    theThreads[];
  Thread    thisThread;
  static boolean inApplet=true;
  int    numberofThreadsAtStart;

  public void init(){
    //���㹤���̵߳ĸ���
    numberofThreadsAtStart = Thread.activeCount();
    //ȷ���������ʾ���
    setLayout(new GridLayout(racerCount,1));
    //ȷ�������ߵ�����
    theRacers = new Threader [racerCount];
    theThreads = new Thread[racerCount];
    //Ϊÿһ�������ߴ���һ���߳�
    for (int x=0;x<racerCount;x++){
      theRacers[x]=new Threader ("Racer #"+x);
      theRacers[x].setSize(getSize().width,getSize().height/racerCount);
      add (theRacers[x]);
      theThreads[x]=new Thread(theRacers[x]);

    }
  }

  public void start(){
    //�������е��߳�
    for (int x=0;x<racerCount;x++)
      theThreads[x].start();
    //����һ�������߳�
    thisThread= new Thread (this);
    thisThread.start();
  }

  public void stop(){    
    for (int x= 0;x<theRacers.length;x++){
      theRacers[x].stop();
    }
  }
  
  public void run(){
    //ѭ��ֱ������
    while(Thread.activeCount()>numberofThreadsAtStart+2){
      try{
        thisThread.sleep(100);
      }  catch (InterruptedException e){
        System.out.println("thisThread was interrupted");
      }
    }

    //ֹͣ����
    if (inApplet){
      stop();
      destroy();
    }
    else
      System.exit(0);
  }


  public static void main (String argv[]){
    inApplet=false;

    //������߾����ߵ�����.
    if (argv.length>0)
      racerCount = Integer.parseInt(argv[0]);

    //����һ���µĽ���
    Frame theFrame = new Frame("The Great Thread Race");
    GreatRace theRace = new GreatRace();
    theFrame.setSize(400,200);
    theFrame.add ("Center",theRace);
    theFrame.show();
    theRace.init();
    theFrame.pack();
    theRace.start();
  }

}//end class GreatRace. 
