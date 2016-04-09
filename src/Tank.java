import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Bartłomiej on 2016-04-09.
 */
public class Tank implements Runnable {

    private int x,y,xDirection;

    public Tank(int width,int height){
        x=width/20;
        y=height;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y-10, 40, 10);
        g.fillRect(x + 18, y - 15, 4, 7);
    }

    public void move() {
        x += xDirection;
        if (x <= 0)
            x = 0;
        if (x >= 360)
            x = 360;
    }

    public void setXDirection(int xdir)
    {
        xDirection = xdir;
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == e.VK_LEFT) {
            setXDirection(-1);
        }
        if (keyCode == e.VK_RIGHT) {
            setXDirection(1);
        }
    }

    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == e.VK_LEFT) {
            setXDirection(0);
        }
        if (keyCode == e.VK_RIGHT) {
            setXDirection(0);
        }
    }

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

