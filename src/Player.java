/**
 * Klasa opisująca gracza.
 */
public class Player
{
    private String tankColour = "Czerwony";
    private String name = "player1";
    private int numberOfMoves;
    private int points;

    public Player(String colour, String name)
    {
        tankColour = colour;
        this.name = name;
        points = 0;
        numberOfMoves=5;
    }

    public String getTankColour() {return tankColour;}
    public String getName() {return name;}
    public void addPoints(int addedPoints){points=points+addedPoints;}
    public int getPoints() {return points;}
    public void oneMove(){numberOfMoves--;}
    public int checkNumberOfMoves(){return numberOfMoves;}
}