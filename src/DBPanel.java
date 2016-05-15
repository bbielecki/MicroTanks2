import javax.swing.*;
import java.awt.*;

/**
 * Created by Bartłomiej on 2016-05-15.
 */
public class DBPanel extends JPanel {
    public void update(Graphics g, int sizeX, int sizeY) {
        Graphics offgc;
        Image offscreen = null;

        // create the offscreen buffer and associated Graphics
        offscreen = createImage(sizeX, sizeY);
        offgc = offscreen.getGraphics();
        // clear the exposed area
        offgc.setColor(getBackground());
        offgc.fillRect(0, 0, sizeX, sizeY);
        offgc.setColor(getForeground());
        // do normal redraw
        paint(offgc);
        // transfer offscreen to window
        g.drawImage(offscreen, 0, 0, this);
    }
}