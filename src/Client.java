/**
 * Created by Bartłomiej on 2016-06-15.
 */
import java.io.*; import java.net.*;
import java.util.Properties;

public class Client {
    Socket socket;
    OutputStream outputStream;
    PrintWriter printWriter;


    public int[] getLevelMap(int numberOfLevel) {
        String aS = "", bS = ""; /// dzieki temu bedzie mozlwiosc zwrotu bezposrednio z funkcji wartosci a i b do kreacji planszy i jednoczesnie zapisanie tych wartosci do pliku
        String nameOfFile, nameOfRequest;
        int[] coefficient = new int[2];

        switch (numberOfLevel){
            case 1: {
                nameOfFile="maplvl1.properties";
                nameOfRequest="get maplvl1";
                break;
            }
            case 2: {
                nameOfFile="maplvl2.properties";
                nameOfRequest="get maplvl2";
                break;
            }
            case 3: {
                nameOfFile="maplvl3.properties";
                nameOfRequest="get maplvl3";
                break;
            }
            case 4: {
                nameOfFile="maplvl4.properties";
                nameOfRequest="get maplvl4";
                break;
            }
            case 5: {
                nameOfFile="maplv5.properties";
                nameOfRequest="get maplvl5";
                break;
            }
            default:{
                nameOfFile="maplvl1.properties";
                nameOfRequest="get maplvl1";
                break;
            }
        }
        try {
            socket = new Socket("192.168.1.5", 54321);
            outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(outputStream, true);

            printWriter.println(nameOfRequest);

            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            aS = bufferedReader.readLine();
            bS = bufferedReader.readLine();

            coefficient[0] = 0;//Integer.parseInt(bufferedReader.readLine());
            coefficient[1] = 0;//Integer.parseInt(bufferedReader.readLine());

            File maplvl1 = new File(nameOfFile);
            FileOutputStream fis = new FileOutputStream(maplvl1);
            Properties propConfig = new Properties();
            propConfig.setProperty("a", aS);
            propConfig.setProperty("b", bS);
            propConfig.store(fis, "maplvl");
            fis.close();

            socket.close();

            System.out.println(aS + "   " + bS);
            System.out.println("a = " + coefficient[0] + " i b = " + coefficient[1]);
        } catch (Exception e) {
            System.err.println("Client exception: " + e);
        }

        return coefficient;
    }









}
/*

    File cfgfile = new File("config.properties");
    FileOutputStream fis = new FileOutputStream(cfgfile);
    Properties propConfig = new Properties();
    propConfig.setProperty("imie", "Jacek");
    propConfig.setProperty("nazwisko", "Polak");
    propConfig.setProperty("chuj", "lolol");
    propConfig.store(fis,"Informacje");
    fis.close();

*/

