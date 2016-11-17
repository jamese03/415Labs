
import java.io.*;
import java.awt.Color;
import wheelsunh.users.*;


/**
 * QueenApp    Fall 2013
 *           Creates a chessboard with a draggable queen
 * 
 * @author mlb
 * 11/13
 */
public class QueenApp 
{  
    private Square [ ][ ] board;
    public static final int SQUARE_SIZE = 60;
    public static final int BASE_X = 20;
    public static final int BASE_Y = 20;
    private Color green = new Color( 23,143, 45 );
    private Color cream = new Color( 235, 234, 185 );
    private Queen queen;
    
    //------------------------- constructor ----------------------------
    /**
     * create new application with a rXc playing board.
     * @param row int
     * @param col int
     */
    public QueenApp(  int row, int col  ) 
    {  
        board = new Square[ row ] [ col ];
        
        
        
        for( int r = 0; r < row; r++ )
        {
          for( int c = 0; c < col; c++ )
          {
            board[r][c] = new Square( r, c );
            
            if( (r+c)%2 == 0 )
            {
              board[r][c].setColor( cream ); 
            }
            else
            {
              board[r][c].setColor( green ); 
            }
          }
        }
        
        queen = new Queen( 0, 0, board );
        

    }
    
    //------------------------- main -------------------------------
    /**
     * main.
     * @param a String a[]
     */
    public static void main(String a [] )
    {    
        new Frame( 700, 550 );
        new QueenApp( 8, 8 );
    }
}
