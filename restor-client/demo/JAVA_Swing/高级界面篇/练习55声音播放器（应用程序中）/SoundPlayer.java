//SoundPlayer.java
import sun.audio.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;

public class SoundPlayer extends Frame
							implements FilenameFilter,ActionListener
{
	Button openButton = new Button("Open");
	Button playButton = new Button("Play");
	Button loopButton = new Button("Loop");
	Button stopButton = new Button("Stop");
	
	Label filename = new Label("                  ");
	File theFile = null;
	AudioData theData = null;
	InputStream nowPlaying = null;
	
	public SoundPlayer(){
		//���ñ���������
		super("SoundPlayer");
		//�رմ���ʱ�˳�����
		addWindowListener(new WindowAdapter() {	public void windowClosing(WindowEvent e) 
												{ System.exit(0);
												}
										      }
						  );
		//���ô��ڴ�С						  
		setSize(300,200);
		//���ô��ڱ���ɫ
		setBackground(Color.orange);
		//���ô����Ϸ����ؼ�����
		Panel north = new Panel();
		north.setLayout(new FlowLayout(FlowLayout.LEFT));
		north.add(new Label("File:    "));
		north.add("NORTH",filename);
		add("North",north);
		//���ô����·����ؼ�����
		Panel south = new Panel();
		south.add(openButton);
		south.add(playButton);
		south.add(loopButton);
		south.add(stopButton);
		add("South",south);
		
		//Ϊ��ť����¼�����
		openButton.addActionListener(this);
		playButton.addActionListener(this);
		loopButton.addActionListener(this);
		stopButton.addActionListener(this);		
	}
	//��������Ӧ�ó�����ڴ�
	public static void main(String[] args){
		SoundPlayer sp = new SoundPlayer();
		sp.show();
	}		
	//���ļ�
	public void open(){
		FileDialog fd = new FileDialog(this,"please select a file");
		fd.setFilenameFilter(this);
		fd.show();
		try{
			theFile = new File(fd.getDirectory()+"/"+fd.getFile());
			if(theFile != null){
				filename.setText(theFile.getName());
				FileInputStream fis = new FileInputStream(theFile);
				AudioStream as = new AudioStream(fis);
				theData = as.getData();
			}
		}
		catch(IOException e){
			System.err.println(e);
		}	
		catch(SecurityException e){
			System.out.println("security exception");
		}		
	}
	//��ʼ����
	public void play(){
		stop();
		if(theData == null) open();
		if(theData != null){
			AudioDataStream ads = new AudioDataStream(theData);
			AudioPlayer.player.start(ads);
			nowPlaying = ads;
		}
	}
	//ֹͣ����
	public void stop(){
		if(nowPlaying != null){
			AudioPlayer.player.stop(nowPlaying);
			nowPlaying = null;
		}
	}		
	//ѭ������
	public void loop(){
		stop();
		if(theData == null) open();
		if(theData != null){
			ContinuousAudioDataStream cads 
									  = new ContinuousAudioDataStream(theData);
			AudioPlayer.player.start(cads);
			nowPlaying = cads;
		}	
	}
	//�¼���Ӧ
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == playButton){
			play();
		}
		if(e.getSource() == openButton){
			open();
		}
		if(e.getSource() == loopButton){
			loop();
		}		
		if(e.getSource() == stopButton){
			stop();
		}		
	}
	public boolean accept(File dir,String name){
		return true;
	}
}							
