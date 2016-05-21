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
    private int strengthOfShot, angleOfShot;
    private double speedY=600, speedX=8;
    public long startTime, endTime, timeInterval;
    private double time;
    private int x,y,xDirection,xBullet,yBullet,deltaX,xBulletDirection,yBulletDirection, widthOfPanel, heightOfPanel;
    private int currentTankStartPosition;
    private static final int g=50;
    private int[] yCoordinates;
    private Thread moveThread;
    private boolean bulletReleased=false,readyToShot=false, endOfMove=true;
    public Color colorOfTank;

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
        this.yCoordinates=new int[width*3];

        xBullet=x;
        yBullet=y;
        widthOfTank=40;
        heightOfTank=10;
        lenghtOfCannon= 15;
        widthOfCannon= 3;
        sizeOfBullet=3;
        deltaX=4;
        setDoubleBuffered(true);
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
        Rectangle bullet=new Rectangle(xBullet-widthOfCannon/2,yBullet-heightOfTank-lenghtOfCannon,sizeOfBullet,sizeOfBullet);
        g.fillRect(xBullet-widthOfCannon/2,yBullet-heightOfTank-lenghtOfCannon, sizeOfBullet,sizeOfBullet);

        Rectangle tank = new Rectangle(x-widthOfTank/2, y-heightOfTank, widthOfTank, heightOfTank);
        g.setColor(colorOfTank);
        g.fillRect(x-widthOfTank/2, y-heightOfTank, widthOfTank, heightOfTank);
        g.fillRect(x-widthOfCannon/2, y - heightOfTank-lenghtOfCannon, widthOfCannon, lenghtOfCannon);

        if(bullet.intersects(tank))
            System.out.println("bum");

    }


    /**
     * Metoda odpowiadająca za ruch czołgu.
     * @return Brak
     */
    public void move(int dir) throws InterruptedException {
        moveThread.sleep(10);
        if(readyToShot){
            xBullet=x;
            yBullet=y;
            readyToShot=false;
        }

        if (bulletReleased==false && endOfMove==false) {
            time=0;
            x += dir;
            xBullet=x;
            yBullet=y;
            if (x <= 1) {
                x = 1;
                y = yCoordinates[x];
            }
            if (x >= widthOfPanel - 20) {
                x = widthOfPanel - 20;
                y = yCoordinates[x];
            }
            y = yCoordinates[x];

            if(dir==1) {
                if (x - currentTankStartPosition >= 100)
                    endOfMove = true;

            }
            else {
                if (currentTankStartPosition - x >= 100)
                    endOfMove = true;
            }
        }
        if(bulletReleased==true){

            long startTime = System.currentTimeMillis();
            setBulletCoordinates();
            System.out.println("szczal   " + xBullet);
            if(xBullet>=widthOfPanel*3 || xBullet<=-10 || yBullet<3 || yBullet>=1000){
                bulletReleased = false;
                readyToShot = false;
                time = 0;
            }
        }
        //System.out.println(x+"   "+y);
    }

    public void setBulletCoordinates() throws InterruptedException {
        double speed;

        time+=Math.abs((double)deltaX/speedX);
        moveThread.sleep((int)Math.abs((double)deltaX/speedX));
        System.out.println(time);
        speed=-speedY+time*(double)g/2;
        xBullet+=deltaX*Math.signum(speedX);
        yBullet=(int)((double)yBullet+speed/100);
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
    public void setEndOfMove(boolean flag){endOfMove = flag;}
    public void setCurrentTankStartPosition(int pos){currentTankStartPosition=pos;}
    public void setReadyToShot(boolean ready) {readyToShot=ready;}

    public void setStrengthOfShot(int strength){
        strengthOfShot=strength;
        speedX=(Math.cos((double)angleOfShot*Math.PI/180))*strength/10;
        speedY=(Math.sin((double)angleOfShot*Math.PI/180))*10*strength;
    }
    public void setAngleOfShot(int angle){
        angleOfShot=angle;
    }


    /**
     * Metoda zdarzeniowa z interfejsu Runnable wykonująca wątek.
     */
    public void run(){}
}