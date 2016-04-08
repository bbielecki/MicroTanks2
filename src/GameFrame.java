import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class GameFrame extends Frame
{
    JPanel gamePanel;
    EarthGenerator earthGenerator;
    MicroTanks microTanks;
    public GameFrame()
    {
        this.width=width/2;
        this.height=height*3/4;
        earthGenerator = new EarthGenerator();
        microTanks = new MicroTanks();

    }

    public void createGameFrame(JFrame frame, JFrame mainMenuframe)
    {
        JPanel settingsPanel = new JPanel();
        gamePanel = new JPanel();

        frame.setLayout(new BorderLayout());
        frame.add(settingsPanel,BorderLayout.SOUTH);
        settingsPanel.setVisible(true);
        settingsPanel.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
        settingsPanel.setBackground(Color.GREEN);
        Dimension dim = new Dimension(getWidth(),getHeight()/4);
        settingsPanel.setPreferredSize(dim);
        setSettingPanel(settingsPanel);

        frame.add(gamePanel,BorderLayout.CENTER);
        gamePanel.setVisible(true);
        gamePanel.setBackground(Color.black);
        Dimension dim2= new Dimension(getWidth(),getHeight()*3/4);
        gamePanel.setPreferredSize(dim2);


    }

    private JPanel setSettingPanel(JPanel setPanel){
        JButton shoot = new JButton("fire!");
        JButton right, left, rightAngle, leftAngle, rightPower, leftPower;
        JTextField move, angle,angleMeasure, power, powerMeasure;
        JPanel weaponPanel,anglePanel,movePanel,powerPanel;
        Choice weapons;
        setPanel.setLayout(new GridLayout(2,2));


        Image imgLeft,imgRight;
        ImageIcon im,im2;
        try
        {
            URL url = new URL("http://www.pd4pic.com/images/computer-back-icon-left-right-arrow-cartoon.png");
            URL url2 = new URL("http://www.pd4pic.com/images/computer-icon-left-right-arrow-cartoon-orange.png");
            imgLeft = ImageIO.read(url);
            imgRight = ImageIO.read(url2);
            imgLeft = imgLeft.getScaledInstance(15,15,100);
            imgRight = imgRight.getScaledInstance(15,15,100);
            im = new ImageIcon(imgLeft);
            im2 = new ImageIcon(imgRight);
            right = new JButton(im2);
            left = new JButton(im);
            rightAngle = new JButton(im2);
            leftAngle = new JButton(im);
            rightPower = new JButton(im2);
            leftPower = new JButton(im);

            movePanel = new JPanel(new FlowLayout());
            anglePanel = new JPanel(new FlowLayout());
            weaponPanel = new JPanel(new FlowLayout());
            powerPanel = new JPanel(new FlowLayout());

            move = new JTextField("move");
            move.setEditable(false);
            move.setBorder(BorderFactory.createEmptyBorder());
            angle = new JTextField("angle");
            angle.setEditable(false);
            angle.setBorder(BorderFactory.createEmptyBorder());
            power = new JTextField("power");
            power.setBorder(BorderFactory.createEmptyBorder());
            power.setEditable(false);
            angleMeasure = new JTextField("number");
            powerMeasure = new JTextField("number");
            weapons = new Choice();
            weapons.add("weapon1");



            movePanel.add(move);
            movePanel.add(left);
            movePanel.add(right);
            anglePanel.add(angle);
            anglePanel.add(leftAngle);
            anglePanel.add(angleMeasure);
            anglePanel.add(rightAngle);
            weaponPanel.add(weapons);
            weaponPanel.add(shoot);
            powerPanel.add(power);
            powerPanel.add(leftPower);
            powerPanel.add(powerMeasure);
            powerPanel.add(rightPower);

            setPanel.add(movePanel);
            setPanel.add(anglePanel);
            setPanel.add(weaponPanel);
            setPanel.add(powerPanel);

            movePanel.setVisible(true);
            weaponPanel.setVisible(true);
            powerPanel.setVisible(true);
            anglePanel.setVisible(true);
            move.setVisible(true);
            left.setVisible(true);
            right.setVisible(true);
            angle.setVisible(true);
            angleMeasure.setVisible(true);
            leftAngle.setVisible(true);
            rightAngle.setVisible(true);
            weapons.setVisible(true);
            shoot.setVisible(true);
            power.setVisible(true);
            powerMeasure.setVisible(true);
            leftPower.setVisible(true);
            rightPower.setVisible(true);


        }
        catch (MalformedURLException e)
        {
            System.err.println("Wyjebało błąd");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return setPanel;
    }

    public void paint(Graphics g){

        paintComponent(g);

    }

    public void paintComponent(Graphics g){
        earthGenerator.earthBuilder(gamePanel);
        g.drawLine(100,100,200,200);
        repaint();
    }
}
