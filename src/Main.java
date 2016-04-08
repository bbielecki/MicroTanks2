import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Bartłomiej on 2016-03-26.
 */
public class Main {
    public static void main(String[] args) throws IOException {


        MainMenu mainMenu = new MainMenu();
        JFrame mainMenuFrame= mainMenu.createAFrame(mainMenu.getWidth(),mainMenu.getHeight(),"Main Menu");
        mainMenuFrame.setForeground(new Color(21,185,125));
        mainMenu.createFrameButtons(mainMenuFrame);
        mainMenuFrame.setVisible(true);


    }
}
