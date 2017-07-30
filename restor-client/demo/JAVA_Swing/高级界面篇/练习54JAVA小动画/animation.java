//animation.java
import java.awt.*;
import java.applet.Applet;

public class animation extends Applet implements Runnable
 {
  Image hImages[];
  int hFrame=0;
  Thread hThread;
  public void init(){
   //׼��ÿһ֡ͼ��
   hImages=new Image[6]; 
   for(	int i=1;
   		i<=6;
   		i++
      )
     hImages[i-1]=getImage(getCodeBase(),"frame"+i+".jpg");
  }
 public void start(){
  //�����߳�
  if(hThread==null)
     hThread=new Thread(this); 
  //�����߳�
   hThread.start();
 }
public void run(){
  //�߳�run����
  while(true) {
   repaint(); 
   try{
    //�߳�˯��ʱ��
    hThread.sleep(500);
   }
   catch(InterruptedException e)
    {
    }
   if(hFrame==5) 
   	   hFrame=0;
   else
   	   hFrame++;
  }
 }
 public void paint(Graphics g){
 		update(g); 
 }
 public void update(Graphics g){ 
  g.drawImage(hImages[hFrame],0,0,this); 
 }

  public void stop() 
  {
   hThread= null; 
  } 
}
