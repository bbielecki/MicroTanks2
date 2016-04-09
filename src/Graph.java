/**
 * Created by Bartłomiej on 2016-04-09.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Graph extends JFrame {
    JPanel jp;

    public Graph() {
        super("Simple Drawing");
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        jp = new GPanel();
        add(jp);
    }

    class GPanel extends JPanel {
        public GPanel() {
            setPreferredSize(new Dimension(300, 300));
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            //rectangle originated at 10,10 and end at 240,240
            g.drawRect(10, 10, 240, 240);
            //filled Rectangle with rounded corners.
            g.fillRoundRect(50, 50, 100, 100, 80, 80);
        }
    }
}
