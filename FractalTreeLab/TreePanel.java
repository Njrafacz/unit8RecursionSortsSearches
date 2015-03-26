import java.awt.*;
import javax.swing.JPanel;
import java.awt.geom.Line2D.Double;
public class TreePanel extends JPanel
{
   private final int PANEL_WIDTH = 800;
   private final int PANEL_HEIGHT = 800;

   private int current; //current order
   
   private final double ANGLE = .5;   
   
   //-----------------------------------------------------------------
   //  Sets the initial fractal order to the value specified.
   //-----------------------------------------------------------------
   public TreePanel (int currentOrder)
   {
      current = currentOrder;
      setBackground (Color.black);
      setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
      
   }

   //-----------------------------------------------------------------
   //  Draws the fractal recursively. Base case is an order of 1 for
   //  which a simple straight line is drawn. Otherwise three
   //  intermediate points are computed, and each line segment is
   //  drawn as a fractal.
   //-----------------------------------------------------------------
   public void drawFractal (Graphics g, int x1, int y1, double ANGLE, int order)
   {
      if( order == 0)
      {
          return;
        }
      int x2 = x1 + (int) (Math.cos(Math.toRadians(ANGLE)) * order * 10.0);
      int y2 = y1 - (int) (Math.sin(Math.toRadians(ANGLE)) * order * 10.0);
      g.drawLine(x1,y1,x2,y2);
      drawFractal(g,x2,y2, ANGLE-20, order-1);
      drawFractal(g,x2,y2, ANGLE +20, order -1);
      }
   

   //-----------------------------------------------------------------
   //  Performs the initial calls to the drawFractal method.
   //-----------------------------------------------------------------
   public void paintComponent (Graphics page)
   {
       super.paintComponent(page);
       page.setColor(Color.green);
       
       drawFractal(page, 400,800 , 90, 10);
   }

   //-----------------------------------------------------------------
   //  Sets the fractal order to the value specified.
   //-----------------------------------------------------------------
   public void setOrder (int order)
   {
      current = order;
   }

   //-----------------------------------------------------------------
   //  Returns the current order.
   //-----------------------------------------------------------------
   public int getOrder ()
   {
      return current;
   }
}
