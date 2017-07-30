//ProgressMonitorExample.java
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class ProgressMonitorExample extends JPanel {  
  //��������
  ProgressThread progressThread;    
  static JFrame myFrame;
  //���캯��
  public ProgressMonitorExample() {    
    setLayout(new BorderLayout());	  
    JPanel buttonPanel = new JPanel();
    JButton startButton = new JButton("Start");
    buttonPanel.add(startButton);
    startButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {    
      startRunning();    
      }
      });  

    JButton stopButton = new JButton("Stop");
    buttonPanel.add(stopButton);
    stopButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {      
      stopRunning();    
      }
      });          
    add(buttonPanel, BorderLayout.SOUTH);  
  } 
  //���¿�ʼ��ť�Ķ���
  public void startRunning() {
    if(progressThread == null|| !progressThread.isAlive()) {    
      progressThread = new ProgressThread(this);
      progressThread.start();    
    }  
  }
  //����ֹͣ��ť�Ķ���
  public void stopRunning() {       
    progressThread.setStop(true);          
  }  
 //��������������ڴ�
  public static void main(String args[]){
    myFrame = new JFrame("������");
    ProgressMonitorExample progressMonitorExample = new ProgressMonitorExample();
    myFrame.getContentPane().add("Center",progressMonitorExample);
    myFrame.setSize(200,100);    
    myFrame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
      System.exit(0);
      }
      });
    myFrame.setVisible(true);
  }
}

//������
class ProgressThread extends Thread {
  ProgressMonitor monitor;
  boolean stopStatus = false;
  int min = 0;    
  int max = 50;
  //���캯��
  public ProgressThread(Component parent){
    monitor = new ProgressMonitor(parent,"Progress of Thread","Not Started",min,max);
  }
  //ֹͣ
  public void setStop(boolean value){
    stopStatus = value;
  }
  //����
  public void run () {
    monitor.setNote("Started");
    for (int x=min;x<=max;x++) {
      if(stopStatus){
        monitor.close();
        break;
      }else{
        monitor.setProgress(x);
        monitor.setNote(""+(x*2)+"%");
        try {        
          sleep(100);
        } catch (InterruptedException e) { 
          // Ignore Exceptions        
        }   
      }     
    }    
  }
} 
