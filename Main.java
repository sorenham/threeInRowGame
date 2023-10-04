import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    private enum GameType { player, computer }
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
    public static void main(String[] args) {
        GameType activeGame = SelectOpponent();
        if( activeGame == GameType.player )
        {
            String player1Name = GetPlayerName( 1 );
            String player2Name = GetPlayerName( 2 );
        }
        int GameRowSize = SelectRowSize();
        int GameColSize = SelectColSize();
        GameBoard aGameBoard = new GameBoard( GameRowSize, GameColSize );

        aGameBoard.PrintBoard();
    }
}