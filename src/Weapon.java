import java.awt.*;

/**
 * Created by Bartłomiej on 2016-06-13.
 */
public class Weapon {
    public Weapon(){

    }

    public void drawWeapon(Graphics g, Rectangle bulletFig, int choosenWeapon){
        switch (choosenWeapon) {
            case 1:
            {
                g.setColor(Color.black);
                g.fillRect((int)bulletFig.getX(),(int)bulletFig.getY(), (int)bulletFig.getWidth(),(int)bulletFig.getHeight());
            }
            case 2:
            {
                g.setColor(Color.black);
                g.fillRect((int)bulletFig.getX(),(int)bulletFig.getY(),(int)bulletFig.getWidth()*3,(int)bulletFig.getHeight()*3);

            }


        }

    }


}
