import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Created by Bartłomiej on 2016-04-09.
 */
public class GamePanel extends JPanel {
    private int width,height;
    static Tank tank1;

    public GamePanel(int x,int y) {
        width=x;
        height=y;
        setPreferredSize(new Dimension(width, height));
        tank1 = new Tank(width,200);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        double x,x2,y,y2;


        for(int i=0;i<100;i++)
        {
            x=((double)width/100)*i;
            x2=((double)width/100)*(i+1);
            y=200+((Math.sin(i/10))*100);
            y2=200+((Math.sin((i+1)/10)*100));
            g.setColor(Color.black);
           // line[i]=new Line2D.Double(x,y,x2,y2);
            g.drawLine((int)x,(int)y,(int)x2,(int)y2);

        }
        tank1.draw(g);

        repaint();



    }
}
