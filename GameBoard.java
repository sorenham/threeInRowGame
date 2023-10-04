public class GameBoard
{
    private char[][] board;
    private int rows = 0;
    private int cols = 0;
    public GameBoard(int rows, int cols)
    {
        if ( rows < 3 )
        {
            this.rows = 3;
        }
        else if ( rows > 12 )
        {
            this.rows = 12;
        }
        else
        {
            this.rows = rows;
        }

        if ( cols < 3 )
        {
            this.cols = 3;
        }
        else if ( cols > 12 )
        {
            this.cols = 12;
        }
        else
        {
            this.cols = cols;
        }

        this.board = new char[this.rows][this.cols];
        ClearBoard();
    }
    public GameBoard()
    {
        this.rows = 3;
        this.cols = 3;

        this.board = new char[3][3];
        ClearBoard();
    }
    public void ClearBoard()
    {
        for(int row = 0; row < this.rows; row++ )
        {
            for(int col = 0; this.cols < 3; col++ )
            {
                this.board[row][col] = ' ';
            }
        }
    }
    public boolean CheckWin( Player aPlayer )
    {
        return true;
    }
    public boolean IsFreePosition( int row, int col )
    {
        return ( this.board[row][col] == ' ' );
    }
    public void MarkPosition( int row, int col, char mark )
    {
        this.board[row][col] = mark;
    }
    public void PlayerMove( Player aPlayer )
    {
        if ( aPlayer.isPlayer() )
        {
            System.out.printf("Ok, it's %s's turn!%n" , aPlayer.getName());
        }
        else
        {
            System.out.printf("The Computer is making a move!%n" );
        }
    }
    public void PrintBoard()
    {
        char aChar = 'X';
        System.out.printf("         ");
        for( int col = 1; col <= this.cols; col++ )
        {
            System.out.printf("Col%2d   ", col);
        }
        System.out.printf("%n");

        for( int row = 0; row < this.rows; row++ )
        {
            System.out.printf("Row%2d  |",row+1);
            for( int col = 0; col < this.cols; col++ )
            {
                System.out.printf("   %C   |", aChar );
            }
            System.out.printf("%n");
        }
    }
}
