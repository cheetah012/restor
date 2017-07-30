//JNotepadTest.java
import java.awt.*; 
import java.awt.event.*; 
import java.awt.print.*; 
import java.awt.datatransfer.*; 
import java.io.*; 
import javax.swing.*; 
import javax.swing.event.*; 
import javax.swing.text.*; 

public class JNotepadTest extends JPanel 
{ 
//��������
JTextArea jta = new JTextArea("", 24, 40); 
JScrollPane jsp = new JScrollPane(jta); 
//�˵���
JMenuBar jmb = new JMenuBar(); 
JMenu file = new JMenu("�ļ�"); 
JMenu edit = new JMenu("�༭"); 
JMenu search = new JMenu("����"); 
//������
JToolBar toolBar = new JToolBar(); 
//�˵�����
JMenuItem jmi; 
//ʵ�������а�
Clipboard clipbd = getToolkit().getSystemClipboard(); 
//��ӡ����
PrinterJob prtMe = PrinterJob.getPrinterJob(); 
String text = ""; 
//���캯��
public JNotepadTest() 
{ 
class newL implements ActionListener 
{ 
public void actionPerformed(ActionEvent e) 
{ 
jta.setDocument(new PlainDocument()); 
} 
} 
//�򿪹���
class openL implements ActionListener 
{ 
public void actionPerformed(ActionEvent e) 
{ 
JFileChooser fc = new JFileChooser(); 
int returnVal = fc.showDialog(JNotepadTest.this, "��"); 
if(returnVal == JFileChooser.APPROVE_OPTION) 
{ 
String file = fc.getSelectedFile().getPath(); 
if(file == null) 
{ 
return; 
} 
//��ȡ�ļ�
try 
{ 
Reader in = new FileReader(file); 
char[] buff = new char[4096]; 
int nch; 
while((nch = in.read(buff, 0, buff.length)) != -1) 
{ 
jta.setDocument(new PlainDocument()); 
jta.append(new String(buff, 0, nch)); 
} 
} 
catch (IOException io) 
{ 
System.err.println("IOException: " + io.getMessage()); 
} 
} 
else 
{ 
return; 
} 
} 
} 
//�����ļ�
class saveL implements ActionListener 
{ 
public void actionPerformed(ActionEvent e) 
{ 
JFileChooser fc = new JFileChooser(); 
int returnVal = fc.showSaveDialog(JNotepadTest.this); 
if(returnVal == JFileChooser.APPROVE_OPTION) 
{ 
String savefile = fc.getSelectedFile().getPath(); 
if(savefile == null) 
{ 
return; 
} 
else 
{ 
String docToSave = jta.getText(); 
if(docToSave != null) 
{ 
FileOutputStream fstrm = null; 
BufferedOutputStream ostrm = null; 
try 
{ 
fstrm = new FileOutputStream(savefile); 
ostrm = new BufferedOutputStream(fstrm); 
byte[] bytes = null; 
try 
{ 
bytes = docToSave.getBytes(); 
} 
catch(Exception e1) 
{ 
e1.printStackTrace(); 
} 
ostrm.write(bytes); 
} 
catch(IOException io) 
{ 
System.err.println("IOException: " + 
io.getMessage()); 
} 
finally 
{ 
try 
{ 
ostrm.flush(); 
fstrm.close(); 
ostrm.close(); 
} 
catch(IOException ioe) 
{ 
System.err.println("IOException: " + 
ioe.getMessage()); 
} 
} 
} 
} 
} 
else 
{ 
return; 
} 
} 
} 
//ҳ������
class pageSetupL implements ActionListener 
{ 
public void actionPerformed(ActionEvent e) 
{ 
prtMe.printDialog(); 
} 
} 
//��ӡ
class printL implements ActionListener 
{ 
public void actionPerformed(ActionEvent e) 
{ 
try 
{ 
prtMe.print(); 
} 
catch(Exception ew) 
{ 
} 
} 
} 
//�˳�
class exitL implements ActionListener 
{ 
public void actionPerformed(ActionEvent e) 
{ 
System.exit(0); 
} 
} 
//����
class copyL implements ActionListener 
{ 
public void actionPerformed(ActionEvent e) 
{ 
String selection = jta.getSelectedText(); 
StringSelection clipString = new StringSelection(selection); 
clipbd.setContents(clipString, clipString); 
} 
} 
//����
class cutL implements ActionListener 
{ 
public void actionPerformed(ActionEvent e) 
{ 
String selection = jta.getSelectedText(); 
StringSelection clipString = new StringSelection(selection); 
clipbd.setContents(clipString, clipString); 
jta.replaceRange("", jta.getSelectionStart(), 
jta.getSelectionEnd()); 
} 
} 
//ճ��
class pasteL implements ActionListener 
{ 
public void actionPerformed(ActionEvent e) 
{ 
Transferable clipData = clipbd.getContents(JNotepadTest.this); 
try 
{ 
String clipString = 
(String)clipData.getTransferData( 
DataFlavor.stringFlavor); 
jta.replaceRange(clipString, 
jta.getSelectionStart(), jta.getSelectionEnd()); 
} 
catch(Exception ex) 
{ 
} 
} 
} 
//ɾ��
class deleteL implements ActionListener 
{ 
public void actionPerformed(ActionEvent e) 
{ 
String selection = jta.getSelectedText(); 
jta.replaceRange("", jta.getSelectionStart(), 
jta.getSelectionEnd()); 
} 
} 
//ȫ��ѡ��
class selectAllL implements ActionListener 
{ 
public void actionPerformed(ActionEvent e) 
{ 
jta.selectAll(); 
} 
} 
//����
class findL implements ActionListener 
{ 
public void actionPerformed(ActionEvent e) 
{ 
String find = ""; 
find = JOptionPane.showInputDialog( 
"���ҵ����ݣ�"); 
} 
} 
//������һ��
class findNextL implements ActionListener 
{ 
public void actionPerformed(ActionEvent e) 
{ 
} 
} 
//�¼�����
class jtaL implements ActionListener 
{ 
public void actionPerformed(ActionEvent e) 
{ 
} 
} 
//��ݼ�����
file.add(jmi = new JMenuItem("�½�", KeyEvent.VK_N)); 
jmi.addActionListener(new newL()); 
file.add(jmi = new JMenuItem("��", KeyEvent.VK_O)); 
jmi.addActionListener(new openL()); 
file.add(jmi = new JMenuItem("����", KeyEvent.VK_S)); 
jmi.addActionListener(new saveL()); 
file.addSeparator(); 
file.add(jmi = new JMenuItem("ҳ������", KeyEvent.VK_G)); 
jmi.addActionListener(new pageSetupL()); 
file.add(jmi = new JMenuItem("��ӡ", KeyEvent.VK_P)); 
jmi.addActionListener(new printL()); 
file.addSeparator(); 
file.add(jmi = new JMenuItem("�˳�", KeyEvent.VK_X)); 
jmi.addActionListener(new exitL()); 

edit.add(jmi = new JMenuItem("����", KeyEvent.VK_C)); 
jmi.addActionListener(new copyL()); 
edit.add(jmi = new JMenuItem("����", KeyEvent.VK_T)); 
jmi.addActionListener(new cutL()); 
edit.add(jmi = new JMenuItem("ճ��", KeyEvent.VK_P)); 
jmi.addActionListener(new pasteL()); 
edit.add(jmi = new JMenuItem("ɾ��", KeyEvent.VK_D)); 
jmi.addActionListener(new deleteL()); 
edit.addSeparator(); 
edit.add(jmi = new JMenuItem("ȫѡ", KeyEvent.VK_A)); 
jmi.addActionListener(new selectAllL()); 

search.add(jmi = new JMenuItem("����", KeyEvent.VK_F)); 
jmi.addActionListener(new findL()); 
search.add(jmi = new JMenuItem("������һ��", KeyEvent.VK_N)); 
jmi.addActionListener(new findNextL()); 
//����ҳ�沼�ַ��
setLayout(new BorderLayout()); 
file.setMnemonic(KeyEvent.VK_F); 
jmb.add(file); 
edit.setMnemonic(KeyEvent.VK_E); 
jmb.add(edit); 
search.setMnemonic(KeyEvent.VK_S); 
jmb.add(search); 
jmb.add(Box.createHorizontalGlue()); 

toolBar.setFloatable(true); 
addButtons(toolBar); 

add(jmb, BorderLayout.NORTH); 
add(toolBar, BorderLayout.CENTER); 
add(jsp, BorderLayout.SOUTH); 

jta.getCaret().setVisible(true); 
jta.setCaretPosition(0); 
} 

//��Ӱ�ť
protected void addButtons(JToolBar toolBar) 
{ 
JButton button = new JButton(new ImageIcon("images/new.gif")); 
button.setToolTipText("�½�һ���ĵ�"); 
button.addActionListener(new ActionListener() 
{ 
public void actionPerformed(ActionEvent e) 
{ 
jta.setDocument(new PlainDocument()); 
} 
}); 
toolBar.add(button); 
//�򿪰�ť
JButton button1 = new JButton(new ImageIcon("images/open.gif")); 
button1.setToolTipText("��һ���ĵ�"); 
//��Ӱ�ť���¼�����
button1.addActionListener(new ActionListener() 
{ 
public void actionPerformed(ActionEvent e) 
{ 
JFileChooser fc = new JFileChooser(); 
int returnVal = fc.showDialog(JNotepadTest.this, "���ļ�"); 
if(returnVal == JFileChooser.APPROVE_OPTION) 
{ 
String file = fc.getSelectedFile().getPath(); 
if(file == null) 
{ 
return; 
} 
try 
{ 
Reader in = new FileReader(file); 
char[] buff = new char[4096]; 
int nch; 
while((nch = in.read(buff, 0, buff.length)) != -1) 
{ 
jta.setDocument(new PlainDocument()); 
jta.append(new String(buff, 0, nch)); 
} 
} 
catch (IOException io) 
{ 
System.err.println("IOException: " + io.getMessage()); 
} 
} 
else 
{ 
return; 
} 
} 
}); 
toolBar.add(button1); 
//���水ť
JButton button2 = new JButton(new ImageIcon("images/save.gif")); 
button2.setToolTipText("�����ĵ�"); 
button2.addActionListener(new ActionListener() 
{ 
public void actionPerformed(ActionEvent e) 
{ 
JFileChooser fc = new JFileChooser(); 
int returnVal = fc.showSaveDialog(JNotepadTest.this); 
if(returnVal == JFileChooser.APPROVE_OPTION) 
{ 
String savefile = fc.getSelectedFile().getPath(); 
if(savefile == null) 
{ 
return; 
} 
else 
{ 
String docToSave = jta.getText(); 
if(docToSave != null) 
{ 
FileOutputStream fstrm = null; 
BufferedOutputStream ostrm = null; 
try 
{ 
fstrm = new FileOutputStream(savefile); 
ostrm = new BufferedOutputStream(fstrm); 
byte[] bytes = null; 
try 
{ 
bytes = docToSave.getBytes(); 
} 
catch(Exception e1) 
{ 
e1.printStackTrace(); 
} 
ostrm.write(bytes); 
} 
catch(IOException io) 
{ 
System.err.println("IOException: " + 
io.getMessage()); 
} 
finally 
{ 
try 
{ 
ostrm.flush(); 
fstrm.close(); 
ostrm.close(); 
} 
catch(IOException ioe) 
{ 
System.err.println("IOException: " + 
ioe.getMessage()); 
} 
} 
} 
} 
} 
else 
{ 
return; 
} 
} 
}); 
toolBar.add(button2); 
//���ư�ť
JButton button3 = new JButton(new ImageIcon("images/copy.gif")); 
button3.setToolTipText("����ѡ�������"); 
button3.addActionListener(new ActionListener() 
{ 
public void actionPerformed(ActionEvent e) 
{ 
String selection = jta.getSelectedText(); 
StringSelection clipString = new StringSelection(selection); 
clipbd.setContents(clipString, clipString); 
} 
}); 
toolBar.add(button3); 
//���а�ť
JButton button4 = new JButton(new ImageIcon("images/cut.gif")); 
button4.setToolTipText("����ѡ�������"); 
button4.addActionListener(new ActionListener() 
{ 
public void actionPerformed(ActionEvent e) 
{ 
String selection = jta.getSelectedText(); 
StringSelection clipString = new StringSelection(selection); 
clipbd.setContents(clipString, clipString); 
jta.replaceRange("", jta.getSelectionStart(), 
jta.getSelectionEnd()); 
} 
}); 
toolBar.add(button4); 
//ճ����ť
JButton button5 = new JButton(new ImageIcon("images/paste.gif")); 
button5.setToolTipText("ճ�����а������"); 
button5.addActionListener(new ActionListener() 
{ 
public void actionPerformed(ActionEvent e) 
{ 
Transferable clipData = clipbd.getContents(JNotepadTest.this); 
try 
{ 
String clipString = 
(String)clipData.getTransferData( 
DataFlavor.stringFlavor); 
jta.replaceRange(clipString, 
jta.getSelectionStart(), jta.getSelectionEnd()); 
} 
catch(Exception ex) 
{ 
} 
} 
}); 
toolBar.add(button5); 

} 


//�رմ���
protected static final class appCloseL extends WindowAdapter 
{ 
public void windowClosing(WindowEvent e) 
{ 
System.exit(0); 
} 
} 
//���������������
public static void main(String args[]) 
{ 
JFrame f = new JFrame(); 
JNotepadTest applet = new JNotepadTest(); 
f.setTitle("д�ְ�"); 
f.setBackground(Color.lightGray); 
f.getContentPane().add(applet, BorderLayout.CENTER); 
f.addWindowListener(new appCloseL()); 
f.setSize(800, 500); 
f.setVisible(true); 
f.pack(); 
} 
} 