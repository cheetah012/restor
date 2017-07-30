//TableDemo.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class TableDemo
{
	//�������ڷ���
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Table");
		frame.addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				//�����˳�Java�����
				System.exit(0);
			}
		} );
		
		// �������б����ı�����
		ImageTable table = new ImageTable( 15, 3 );
		//����������ÿ����Ԫ��������ֵ
		for( int i=0; i<table.getRowCount(); i++ ){
			for( int j=0; j< table.getColumnCount(); j++ ){
				table.setValueAt("(" + i+ "," +j+ ")",i,j);
			}
		}
		//�ѱ�����������������
		JScrollPane sp = new JScrollPane( table );
		//�������������ܴ�����
		frame.getContentPane().add( sp );
		//��ʾ��ܴ���
		frame.pack();
		frame.show();
	}
}
/*
 * һ�����Ƶı��������䱳��ΪͼƬ
*/
class ImageTable extends JTable
{
	// Ҫ���õı��ı���ͼƬ�������滻���Լ�ϲ����ͼƬ.
	ImageIcon image = new ImageIcon( "clouds.jpg" );
	
	//�������Ĺ��췽��
	public ImageTable(int rows, int cols)
	{
		super(rows,cols);		
	}
	public ImageTable(Object[][] rowData, Object[] columnNames)
	{
		super(rowData,columnNames);		
	}
	public ImageTable(java.util.Vector rowData, java.util.Vector columnNames)
	{
		super(rowData,columnNames);		
	}
	public ImageTable(TableModel row, TableColumnModel column)
	{
		super(row,column);		
	}
	public ImageTable(TableModel model)
	{
		super(model);		
	}
	//׼��������
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) 
	{
		
		Component c = super.prepareRenderer( renderer, row, column);
		//ʹ����ͼƬ�ɼ�
		if( c instanceof JComponent )
			((JComponent)c).setOpaque(false);
		return c;
	}
	//���Ʊ�����	
	public void paint( Graphics g )
	{
		// ���ñ������ı�����͸����
		setOpaque(false);
		//��ȡ�������Ĵ�С
		Dimension d = getSize();
		// ��ƽ�̷�ʽ������ͼƬ
		for( int x = 0; x < d.width; x += image.getIconWidth() )
			for( int y = 0; y < d.height; y += image.getIconHeight() )
				g.drawImage( image.getImage(), x, y, null, null );
		//���ø���ķ���
		super.paint(g);
	}
				
}
