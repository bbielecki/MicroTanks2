import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import java.io.Console;

/**
 * Klasa implementująca pojedynczy czołg.
 * @author      Bartłomiej Bielecki <address @ example.com>
 * @author      Jacek Polak <polakjacek@gmail.com>
 * @version     1.1
 * @since       2016-03-26
 */

public class Tank extends JPanel implements Runnable,KeyListener {

    private int x,y,xDirection,yDirection, widthOfPanel, heightOfPanel;
    private int localX,localY;
    private int[] yCoordinates;

    /**
     * Konstruktor klasy <code>Tank</code> tworzy czołg w zależności od współrzędnych,
     * na których chcemy go umieścić.
     * @param width Współrzędna 'x' ekranu
     * @param height Współrzędna 'y' ekranu
     */
    public Tank(int width,int height){
        widthOfPanel=width;
        heightOfPanel=height;
        int rand = (int)(Math.random()*widthOfPanel);
        this.x=rand;
        this.yCoordinates=new int[width];
        //addKeyListener(this);
    }

    public void setyCoordinates(int y,int i){
        yCoordinates[i]=y;
    }
    /**
     * Metoda rysująca pojedynczy czołg.
     * @param g Kontekst graficzny
     */
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x-20, y-10, 40, 10);
        g.fillRect(x-20 + 18, y - 25, 3, 15);
    }

    /**
     * Metoda odpowiadająca za ruch czołgu.
     * @return Brak
     */
    public void move() {
        x += xDirection;

        if (x <= 1) {
            x = 1;
            y = yCoordinates[x];
        }
        if (x >= widthOfPanel - 20) {
            x = widthOfPanel - 20;
            y = yCoordinates[x];
        }
        y = yCoordinates[x];
        //System.out.println(x+"   "+y);
    }

    /**
     * Metoda ustawiająca kierunek czołgu w poziomie.
     * @param xdir Kierunek
     */
    public void setXDirection(int xdir)
    {
        xDirection = xdir;
    }


    /**
     * Metoda ustawiająca kierunek czołgu.
     * @param e KeyEvent
     */
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == e.VK_LEFT) {
                setXDirection(-1);
            }
            if (keyCode == e.VK_RIGHT) {
                setXDirection(1);
            }
        }

        /**
         * Metoda zatrzymująca czołg w momencie puszczenia klawisza kierunkowego(srzałki).
         *
         * @param e KeyEvent
         */

        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == e.VK_LEFT) {
                setXDirection(0);
            }
            if (keyCode == e.VK_RIGHT) {
                setXDirection(0);
            }
        }

    public void keyTyped(KeyEvent e){}


    /**
     * Metoda zdarzeniowa z interfejsu Runnable wykonująca wątek.
     */
    public void run() {
        try {
            while (true) {

                move();

                Thread.sleep(5);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}