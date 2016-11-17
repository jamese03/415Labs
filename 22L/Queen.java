

import java.awt.Color;
import java.awt.event.*;
import wheelsunh.users.*;
import java.awt.Point;


/**
 * Queen.   Fall 2013
 *A draggable queen that snaps to grid and marks attacked squares.
 * 
 * @author mlb
 * 
 */
public class Queen extends ShapeGroup
{ 
    private Image image;
    private int size = QueenApp.SQUARE_SIZE;
    private int baseX = QueenApp.BASE_X;
    private int baseY  = QueenApp.BASE_Y;
    private int r, c;
    private Square [ ][ ] board;
    private Point last;            // used only for dragging
    
    //------------------------- Constructors --------------------------
    /**
     * Position tile at r, c on the board
     */
    public Queen( int r, int c,  Square b[][] )
    {
        try
        {
            // Assign a new Image to image
        image = new Image( "q2.png" );
        
        if( image != null )
              add(image );
        }
        catch( Exception e )
        {
            System.out.println( "Could not create image");
        }
        

        placeOnSquare( r , c );
        this.r = r;
        this.c = c;
        board = b;
        markAll( );
    }
    
    
    //--------------------------- placeOnSquare( r, c ) --------------
    /*
     *  place the queen on square r,c
     */    
    public void placeOnSquare( int r, int c )
    {
        setLocation( c *  size + baseX, r *  size + baseY );  
    }
    
    
    //--------------------------- mousePressed ------------------------
    /*
     *  the usual drag procedure.
     */     
    public void mousePressed( MouseEvent me )
    {
        last = me.getPoint( );
    }
    
    
    //--------------------------- mouseReleased -----------------------
    /*
     *   On mouse released get the closest row and column to the current
     *   location.
     */   
    public void mouseReleased( MouseEvent me )
    {
        Point p = me.getPoint( );
        
        r = getClosestRow( this.getCenterY( ) );
        c = getClosestCol( this.getCenterX( )  );
        if( r > 7)
          r = 7;
        if( r < 0)
          r = 0;
        if( c > 7)
          c=7;
        if( c < 0 ) 
          c=0;
        placeOnSquare(  r, c  );
        markAll();
    }
    
    //--------------------------- mouseDragged ------------------------
    /*
     *   The usual drag procedure.
     */   
    public void mouseDragged( MouseEvent me )
    {
        Point newLoc = me.getPoint();
        int dx = newLoc.x - last.x;
        int dy = newLoc.y - last.y;
        
        this.setLocation( getXLocation() + dx, getYLocation() + dy );
        last = newLoc;
    }
    
    
    //--------------------------- getClosestColumn -------------------
    /*
     *  
     */   
    private int getClosestCol( int x )
    {

        int s = x - baseX;
        int t = s/size;
        
        
        return t;  
    }
    
    
    //--------------------------- getClosestRow -----------------------
    /*
     * 
     */   
    private int  getClosestRow( int y  )
    {

        int s = y - baseY;
        int t = s/size;
        
        
        
        return t;  
    }
    
    
    //--------------------------- markAll -----------------------------
    /*    
     *  call setMark for all squares on the board.
     *  call setMark( true ) if the square is under attack and
     *  setmark( false ) otherwise. Use isAttacked( i, j ) to 
     *  see if a square is under attack.
     */
    private void  markAll( )
    {
      for( int r = 0; r < 8; r++ )
        {
          for( int c = 0; c < 8; c++ )
          {
              if( isAttacked( r, c ) == true )
              {
                 board[r][c].setMark(true); 
              }
              else
              {
                 board[r][c].setMark(false);  
              }
          }
      }
        
        
        
        
    }
    
    //--------------------------- isAttacked --------------------------
    /*
     *  return true if the square at i,j is under attack from the queen
     *  at r,c
     *  return false otherwise.
     * 
     */   
    private boolean isAttacked( int i, int j )
    {
       
        if( r == i  || c == j  || 
           (r + c ==  i + j )||
           ( r - c ==  i - j  ) )
        {
            boolean answer = true; 
             return answer;
        }
        else  
        {
            boolean answer = false;
             return answer;
        }
       
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
