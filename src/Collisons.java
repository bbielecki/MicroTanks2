import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Bartłomiej on 2016-05-23.
 */
public class Collisons {

    private Image image;

    public Collisons(int width, int height, Graphics g, int x, int y){
        try {
            URL url = new URL("https://i.kinja-img.com/gawker-media/image/upload/s--wau7KSN4--/c_fit,fl_progressive,q_80,w_636/18bl3j27axli8jpg.jpg");
            image = ImageIO.read(url);
            image = image.getScaledInstance(width/4,height/5,150);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        g.drawImage(image, x,y, new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
    }
}
