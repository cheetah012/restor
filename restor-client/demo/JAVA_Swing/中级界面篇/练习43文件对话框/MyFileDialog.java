//MyFileDialog.java
import java.awt.*;
import java.awt.event.*;

public class MyFileDialog implements ActionListener {

  private Frame f;
  private FileDialog fd;
  private Button b;

  public void go() {
    f = new Frame("FileDialog");
    fd = new FileDialog(f, "FileDialog");
    b = new Button("Launch FileDialog");

    //ע�ᶯ������
    b.addActionListener(this);

    f.add(b, BorderLayout.CENTER);
		f.pack();
    f.setVisible(true);
  }

  // ���а�ť�ľ��
  public void actionPerformed( ActionEvent ae) {
    String buttonPressed = ae.getActionCommand();
    if (buttonPressed.equals("Launch FileDialog")) {
      fd.setVisible(true);
    } else {
      fd.setVisible(false);
    }
  }

  public static void main (String args[]) {
    MyFileDialog myFileDialog = new MyFileDialog();
    myFileDialog.go();
  }
}
