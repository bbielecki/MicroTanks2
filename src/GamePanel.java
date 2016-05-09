
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Klasa ta odpowiada za panel rozgrywki, umieszczony on jest w klasie <code>GameFrame</code>.
 *
 */
public class GamePanel extends JPanel {
    private int width,height;
    private int numberOfTanks=3;
    private int turnNumber=1;
    static Tank[] tank;
    static Tank currentTank;

    /**
     * Konstruktor klasy <code>GamePanel</code> przyjmuje wartości szerokości i wysokości panelu rozgrywki.
     * @param x Szerokość panelu gry
     * @param y Wysokość panelu gry
     */

    public GamePanel(int x,int y) {
        width=x;
        height=y;
        setPreferredSize(new Dimension(width, height));
        tank = new Tank[numberOfTanks];
        createTanks(tank);
    }

    public Tank[] createTanks(Tank[] tank){
        for (int i=0;i<numberOfTanks;i++) {
            tank[i] = new Tank(width, 200);
            selectATank(tank[i]);
        }

        selectATank(tank[1]);
        return tank;
    }

    public void selectATank(Tank tank){
        setFocusable(true);
        addKeyListener(tank);
        new Thread(tank).start();
        currentTank=tank;
    }

    public void nextTurn(){
        int previousTurnNumber=turnNumber;
        if(turnNumber<numberOfTanks) {
            previousTurnNumber = turnNumber;
            turnNumber++;
        }
        else
            turnNumber=1;

        selectATank(tank[turnNumber-1]);
    }

    /**
     * Metoda rysująca planszę w zależności od podanej jej funkcji matematycznej,
     * a także czołgi.
     *
     * @param g Kontekst graficzny
     * @return Brak
     */
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        double x,x2,y,y2;
        int[] formax = new int[2];
        loadMap(formax);

        for(int i=0;i<getWidth();i++)
        {
            x=i;
            x2=(i+1);
            y =  200 + formax[0] * Math.sin((double)i/50) + formax[1];
            y2 =  200 + formax[0] * Math.sin((double)(i+1)/50) + formax[1];
            //for(int j=0;j<numberOfTanks;j++)
                currentTank.setyCoordinates((int)y,i);
            //y=200+((Math.sin(i/10))*100);
            //y = 200 + Integer.parseInt(a) * Math.pow(i,2) + Integer.parseInt(b) + i;
            //y2 = 200 + Integer.parseInt(a) * Math.pow(i+1,2) + Integer.parseInt(b) + (i+1);
            //y2 = 200 + (Math.sin((i + 1) / 10) * 100));
            g.setColor(Color.black);
            // line[i]=new Line2D.Double(x,y,x2,y2);
            g.drawLine((int)x,(int)y,(int)x2,(int)y2);
        }

        for(int j=0;j<numberOfTanks;j++)
            tank[j].draw(g);

        repaint();

    }

    public void setTanksCoordinates(int x)
    {

    }
    /**
     * Metoda parsująca informacje o planszy do utworzenia z plików
     * konfiguracyjnych.
     * @return Współczynniki funkcji
     * @throws IOException
     */

    private int[] loadMap(int[] form)
    {
        String a = "1",b = "2";
        try {
            File mapFile = new File("maplvl2.properties");
            Properties pro = new Properties();
            FileInputStream fis = new FileInputStream(mapFile);
            pro.load(fis);
            a = pro.getProperty("a");
            b = pro.getProperty("b");
        } catch (IOException e) {
            e.printStackTrace();
        }
        form[0] = Integer.parseInt(a);
        form[1] = Integer.parseInt(b);

        return form;
    }

}