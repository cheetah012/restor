//BallAnim.java
import java.awt.*;
import java.applet.*;
import java.lang.*;

public class BallAnim extends Applet implements Runnable
{
   Thread animThread;
   //С��ĺ�����
   int ballX = 0;     
   //С����˶�����0Ϊ������
   int ballDirection = 0; 
   //����С����
   public void start()
   {
     if (animThread == null)
     {
        animThread = new Thread(this);
        animThread.start();
     }
   }
//ֹͣС����
   public void stop()
   {
     animThread.stop();
     animThread = null;
   }
//����С����
   public void run()
   {
     Thread.currentThread().setPriority(Thread.NORM_PRIORITY);

     while (true)
     {
        moveBall();
        try {
          // ˯�� 0.1 ��
          Thread.sleep(100);   
        } catch (Exception sleepProblem) {
        }
     }
   }

   private void moveBall()
   {
// С��������˶�
     if (ballDirection == 0)
     {
        ballX++;

// С����ҵ����˶�

        if (ballX > 100)
        {
          ballDirection = 1;
          ballX = 100;
        }
     }
     else
     {
        ballX--;
        if (ballX <= 0)
        {
          ballDirection = 0;
          ballX = 0;
        }
     }

     repaint();
   }
   //��������
   public void paint(Graphics g)
   {
     g.setXORMode(getBackground());
     g.fillRect(40, 10, 40, 40);
     g.fillOval(ballX, 0, 30, 30);
   }
}
