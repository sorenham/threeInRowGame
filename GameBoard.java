import static java.lang.Math.random;

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
            for(int col = 0; col < this.cols; col++ )
            {
                this.board[row][col] = ' ';
            }
        }
    }
    private boolean isBoardFull()
    {
        boolean HasFreePos = false;
        for( int row = 0; row < this.rows; row++)
        {
            for ( int col = 0; col < this.cols; col++ )
            {
                if ( this.board[row][col] == ' ' ) HasFreePos = true;
            }
        }
        return HasFreePos;
    }
    public boolean CheckWin( Player aPlayer )
    {
        boolean GotAWinner = false;
        if ( isBoardFull() )
        {
            GotAWinner = true;
        }

        return GotAWinner;
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
        int row;
        int col;
        boolean BadMove = true;
        do
        {
            row = GetRandomNumber( 0 , this.rows );
            col = GetRandomNumber( 0 , this.cols );
            BadMove = !IsFreePosition( row, col );

            System.out.printf("col = %d, row = %d, BadMove = %b%n" , row, col , BadMove);

        } while ( BadMove );
        MarkPosition( row, col, aPlayer.getToken() );
    }
    public void MakeMove( Player aPlayer )
    {
        if ( aPlayer.isPlayer() )
        {
            System.out.printf("Ok, it's %s's turn!%n" , aPlayer.getName());
            PlayerMove( aPlayer );
        }
        else
        {
            System.out.printf("The Computer is making a move!%n" );
            ComputerMove( aPlayer );
        }
    }
    private int GetRandomNumber(int min, int max) {
        return (int) ((random() * (max - min)) + min);
    }
    private void ComputerMove( Player aPlayer )
    {
        int row;
        int col;
        boolean BadMove = true;
        do
        {
            row = GetRandomNumber( 0 , this.rows );
            col = GetRandomNumber( 0 , this.cols );
            BadMove = !IsFreePosition( row, col );

        } while ( BadMove );
        MarkPosition( row, col, aPlayer.getToken() );
    }

    public void PrintBoard()
    {
        //char aChar = 'X';
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
                System.out.printf("   %C   |", this.board[row][col] );
            }
            System.out.printf("%n");
        }
    }
}
