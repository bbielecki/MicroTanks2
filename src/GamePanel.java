import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Created by Bartłomiej on 2016-04-09.
 */
public class GamePanel extends JPanel {
    private int width,height;

    public GamePanel(int x,int y) {
        width=x;
        height=y;
        setPreferredSize(new Dimension(width, height));
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        int x,x2,y,y2;

        g.drawLine(300,300,200,200);


        for(int i=1;i<100;i++)
        {
            x=width/100*i;
            x2=height/100*(i+1);
            y=(int)((Math.sin(x)/x)*100);
            y2=(int)((Math.sin(x2)/(x2))*100);
            g.setColor(Color.black);
           // line[i]=new Line2D.Double(x,y,x2,y2);
            g.drawLine(x,y,x2,y2);

        }


        //rectangle originated at 10,10 and end at 240,240
        g.drawRect(10, 10, 240, 240);
        //filled Rectangle with rounded corners.
        g.fillRoundRect(50, 50, 100, 100, 80, 80);
        g.setColor(Color.BLUE);
        g.drawLine(100,100,200,200);
    }
}
