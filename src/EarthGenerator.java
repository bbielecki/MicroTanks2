import javax.swing.*;
import java.io.*;
import java.util.Properties;

/**
 * Created by Bartłomiej on 2016-04-08.
 */
public class EarthGenerator {

    public JPanel earthBuilder(JPanel gamePanel){




        return gamePanel;
    }

    public String loadMap() throws FileNotFoundException, IOException
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
