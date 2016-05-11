import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Console;

/**
 * Klasa implementująca pojedynczy czołg.
 * @author      Bartłomiej Bielecki <address @ example.com>
 * @author      Jacek Polak <polakjacek@gmail.com>
 * @version     1.1
 * @since       2016-03-26
 */

public class Tank extends JPanel implements Runnable {

    private int widthOfTank, heightOfTank;
    private int lenghtOfCannon, widthOfCannon;
    private int sizeOfBullet;
    private double time;
    private int x,y,xDirection,xBullet,yBullet,xBulletDirection,yBulletDirection, widthOfPanel, heightOfPanel;
    private static final int g=10;
    private int[] yCoordinates;
    private Thread moveThread;
    private boolean bulletReleased=false;

    /**
     * Konstruktor klasy <code>Tank</code> tworzy czołg w zależności od współrzędnych,
     * na których chcemy go umieścić.
     * @param width Współrzędna 'x' ekranu
     * @param height Współrzędna 'y' ekranu
     */
    public Tank(int width,int height, Thread tThread){
        widthOfPanel=width;
        heightOfPanel=height;
        moveThread=tThread;
        int rand = (int)(Math.random()*widthOfPanel);
        this.x=rand;
        this.yCoordinates=new int[width];

        xBullet=x;
        yBullet=y;
        widthOfTank=40;
        heightOfTank=10;
        lenghtOfCannon= 15;
        widthOfCannon= 3;
        sizeOfBullet=3;
    }

    public void setyCoordinates(int yy,int i){
        yCoordinates[i]=yy;

    }

    public void setRandomY(){
        y=yCoordinates[this.x];
    }
    /**
     * Metoda rysująca pojedynczy czołg.
     * @param g Kontekst graficzny
     */
    public void draw(Graphics g) {

        g.setColor(Color.black);
        g.fillRect(xBullet-widthOfCannon/2,yBullet-heightOfTank-lenghtOfCannon, sizeOfBullet,sizeOfBullet);


        g.setColor(Color.BLUE);
        g.fillRect(x-widthOfTank/2, y-heightOfTank, widthOfTank, heightOfTank);
        g.fillRect(x-widthOfCannon/2, y - heightOfTank-lenghtOfCannon, widthOfCannon, lenghtOfCannon);
    }

    /**
     * Metoda odpowiadająca za ruch czołgu.
     * @return Brak
     */
    public void move() throws InterruptedException {
        moveThread.sleep(10);

        if (bulletReleased==false) {
            time=0;
            x += xDirection;
            xBullet=x;
            if (x <= 1) {
                x = 1;
                y = yCoordinates[x];
            }
            if (x >= widthOfPanel - 20) {
                x = widthOfPanel - 20;
                y = yCoordinates[x];
            }
            y = yCoordinates[x];
            yBullet=y;
        }
        if(bulletReleased==true){
            time+=0.1;
            xBullet+=10;
            yBullet=(int)(yBullet-1*time+time*time*(double)g/2);
            System.out.println("szczal");
            if(xBullet>=widthOfPanel || xBullet<=1 || yBullet<3) {
                bulletReleased = false;
                time = 0;
            }
        }
        //System.out.println(x+"   "+y);
    }

    public void releaseTheBullet(){
        bulletReleased=true;
    }


    /**
     * Metoda ustawiająca kierunek czołgu w poziomie.
     * @param xdir Kierunek
     */
    public void setXDirection(int xdir)
    {
        xDirection = xdir;
        System.out.println(xDirection + "    " + x);
    }

    public int getX(){return x;}


    /**
     * Metoda zdarzeniowa z interfejsu Runnable wykonująca wątek.
     */
    public void run(){}
}