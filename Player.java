public class Player {
    private String name;

    private char token;

    private boolean player;

    private boolean computer;

    public Player( String name, char token )
    {
        this.name = name;
        this.token = token;
        this.player = true;
        this.computer = false;
    }
    public Player( char token )
    {
        this.name = "Computer";
        this.token = token;
        this.player = false;
        this.computer = true;
    }
    public String getName()
    {
        return this.name;
    }
    public char getToken()
    {
        return this.token;
    }
    public boolean isPlayer()
    {
        return this.player;
    }
    public boolean isComputer()
    {
        return this.computer;
    }
}
