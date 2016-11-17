/**
 * Square    Fall 2013
 *           A markable square for a chess board
 * 
 * @author mlb
 * 11/13
 */
import java.awt.Color;
import java.awt.event.*;
import wheelsunh.users.*;

public class Square extends Rectangle
{
    private int size = QueenApp.SQUARE_SIZE;
    private int x = QueenApp.BASE_X;
    private int y = QueenApp.BASE_Y;
    private Ellipse mark;
    
    //------------------------- Constructor ----------------------------
    /**
     * Position square at row r andcolumn, c
     */
    public Square( int r, int c )
    {
        setLocation( c *  size + x ,  r *  size + y );
        setSize( size, size );
        mark = new Ellipse( );
        mark.setSize( size / 5, size / 5 );
        mark.setColor( Color.black );
        setMark( false );   
    }
    
    //------------------------- setMark( boolean) ---------------------
    /**
     * set or unset mark
     */
    public void setMark( boolean isMarked )
    {
        if( isMarked )
            mark.setLocation( getXLocation() + 2 * size / 5,
                             getYLocation() + 2 * size / 5 );
        else
            mark.setLocation( -50, -50 );
    }
    
    
    //------------------------- main -------------------------------
    /**
     * main.
     * @param a String a[]
     */
    public static void main( String a [] )
    {    
        new Frame( 700, 550 );
        new QueenApp( 8, 8 );
    }
} 
