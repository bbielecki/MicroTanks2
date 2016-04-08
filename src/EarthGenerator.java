import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.io.*;
import java.util.Properties;

/**
 * Created by Bartłomiej on 2016-04-08.
 */
public class EarthGenerator extends Frame{

    public JPanel earthBuilder(JPanel gamePanel, Graphics g){

        int x,x2,y,y2;

        Line2D.Double[] line = new Line2D.Double[100];
        g=gamePanel.getGraphics();
        Graphics2D g2 = (Graphics2D)g;

        for(int i=1;i<100;i++)
        {
            x=gamePanel.getWidth()/100*i;
            x2=gamePanel.getWidth()/100*(i+1);
            y=(int)Math.sin(x)/x;
            y2=(int)Math.sin(x2)/(x2);
            line[i]=new Line2D.Double(x,y,x2,y2);
            g2.drawLine(x,y,x2,y2);
            g2.setColor(Color.black);
        }

        return gamePanel;
    }

    public String loadMap() throws IOException
    {
        File mapFile = new File("maplvl1.properties");
        Properties pro = new Properties();
        FileInputStream fis = new FileInputStream(mapFile);
        pro.load(fis);
        String jaco = pro.getProperty("Janusz");
        fis.close();
        return jaco;
    }
}
