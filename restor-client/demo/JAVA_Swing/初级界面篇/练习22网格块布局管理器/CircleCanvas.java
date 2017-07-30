//CircleCanvas.java
import java.awt.*;
//����һ������
public class CircleCanvas extends Canvas
{
     Color circleColor;
     //������ɫ�ӿ�
     public CircleCanvas(Color drawColor)
     {
          circleColor = drawColor;
     }
     //��������
     public void paint(Graphics g)
     {
          int circleDiameter, circleX, circleY;
          Dimension currentSize = getSize();

          if (currentSize.width < currentSize.height)
          {
               circleDiameter = currentSize.width;
          }
          else
          {
               circleDiameter = currentSize.height;
          }
          g.setColor(circleColor);
          //���ú�������
          circleX = (currentSize.width - circleDiameter) / 2;
          circleY = (currentSize.height - circleDiameter) / 2;

          g.fillOval(circleX, circleY, circleDiameter, circleDiameter);
     }
}
