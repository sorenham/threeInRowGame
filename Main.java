import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    private enum GameType { player, computer }
    public enum GameResult { Winner, draw, noWinner }
    private static GameType SelectOpponent()
    {
        Scanner sc = new Scanner(System.in);
        boolean selecting = true;
        int user_input = 0;

        System.out.printf("Lets play Tic Tac Toe!%n");
        while ( selecting )
        {
            System.out.printf("possible opponents!%n");
            System.out.printf("1 = other player,  2 = computer%n");
            System.out.printf("Select opponent : ");

            try
            {
                user_input = sc.nextInt();
            }
            catch(Exception e)
            {
                sc.nextLine();
            }

            switch ( user_input )
            {
                case 1:
                {
                    return GameType.player;
                }
                case 2:
                {
                    return GameType.computer;
                }
                default:
                {
                    System.out.printf("Bad choice try again!%n");
                }
            }
        }
        return GameType.player;
    }
    private static int SelectRowSize()
    {
        int user_input = 0;
        boolean selecting = true;
        Scanner sc = new Scanner(System.in);
        while ( selecting )
        {
            System.out.printf("How many rows do you want (3-12) ? ");
            try
            {
                user_input = sc.nextInt();
            }
            catch (Exception e)
            {
                sc.nextLine();
            }
            if ( user_input > 2 && user_input < 13 )
            {
                selecting = false;
            }
            else
            {
                System.out.printf("Bad choice try again!%n");
            }
        }
        return user_input;
    }
    private static int SelectColSize()
    {
        int user_input = 0;
        boolean selecting = true;
        Scanner sc = new Scanner(System.in);
        while ( selecting )
        {
            System.out.printf("How many columns do you want (3-12) ? ");
            try
            {
                user_input = sc.nextInt();
            }
            catch (Exception e)
            {
                sc.nextLine();
            }
            if (user_input > 2 && user_input < 13)
            {
                selecting = false;
            }
            else
            {
                System.out.printf("Bad choice try again!%n");
            }
        }
        return user_input;
    }
    private static String GetPlayerName( int player )
    {
        String user_input = "";
        boolean selecting = true;
        Scanner sc = new Scanner(System.in);
        while ( selecting )
        {
            System.out.printf("Enter name of Player %d : ", player);
            try
            {
                user_input = sc.nextLine();
            }
            catch (Exception e)
            {
                sc.nextLine();
            }
            if ( user_input.isEmpty() )
            {
                System.out.printf("Bad choice try again!%n");
            }
            else
            {
                selecting = false;
            }
        }
        return user_input;
    }
    private static boolean askPlayAgain()
    {
        boolean selecting = true;
        boolean Selection = false;
        String user_input = "";
        Scanner sc = new Scanner(System.in);
        while ( selecting )
        {
            System.out.printf("Do yoy want to play another game ( Y / N ) ? ");
            try
            {
                user_input = sc.nextLine();
            }
            catch (Exception e)
            {
                user_input = "";
            }

            if ( user_input.equals("Y") || user_input.equals( "y" ))
            {
                selecting = false;
                Selection = true;
            }
            else if ( user_input.equals("N") || user_input.equals( "n" ))
            {
                selecting = false;
                Selection = false;
            }
            else
            {
                System.out.printf("Bad choice try again!%n");
            }
        }
        return Selection;
    }
    private static void SaluteTheWinner( Player aPlayer )
    {
        System.out.printf("We salute you, %s, you're a winner!%n",aPlayer.getName());
    }
    private static void InformDraw( )
    {
        System.out.printf("We Got a Draw!%n");
    }
    public static void main(String[] args)
    {
        Player player1;
        Player player2;
        GameType activeGame = SelectOpponent();
        GameResult aGameResult = GameResult.noWinner;
        if( activeGame == GameType.player )
        {
            String player1Name = GetPlayerName( 1 );
            String player2Name = GetPlayerName( 2 );
            player1 = new Player( player1Name, 'X' );
            player2 = new Player( player2Name, 'O' );
        }
        else
        {
            String player1Name = GetPlayerName( 1 );
            player1 = new Player( player1Name, 'X' );
            player2 = new Player( 'O');
        }

        int GameRowSize = SelectRowSize();
        int GameColSize = SelectColSize();
        GameBoard aGameBoard = new GameBoard( GameRowSize, GameColSize );

        do
        {
            aGameBoard.ClearBoard();
            boolean player1Turn = true;
            do
            {
                if ( player1Turn )
                {
                    aGameBoard.MakeMove( player1 );
                    aGameResult = aGameBoard.CheckWin( player1 );
                    aGameBoard.PrintBoard();
                    if ( aGameResult == GameResult.Winner ) SaluteTheWinner( player1 );
                    else if ( aGameResult == GameResult.draw ) InformDraw(  );
                }
                else
                {
                    aGameBoard.MakeMove( player2 );
                    aGameResult = aGameBoard.CheckWin( player2 );
                    aGameBoard.PrintBoard();
                    if ( aGameResult == GameResult.Winner  ) SaluteTheWinner( player2 );
                    else if ( aGameResult == GameResult.draw ) InformDraw(  );
                }
                player1Turn = !player1Turn;
            } while( aGameResult == GameResult.noWinner );
        } while ( askPlayAgain() );
    }
}