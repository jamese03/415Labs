import wheelsunh.users.*;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.*;


/** 
 *  TrappedBall.java:
 *  
 */


public class TrappedBall extends Ellipse
{ 
    //----------------- instance variables --------------------------------------
    private int myX, myY;   // location of TrappedBall
    private Point lastMouse; 
    private static final int MAX_X  = 700;
    private static final int MAX_Y  = 500;
    
    //------------------ constructors ---------------------------------------------
    public TrappedBall( int x, int y ) 
    {      
        super( x, y );
        setColor(Color.orange);
        myX = x;
        myY = y;
    }
    
    
    
    //----------------------------------------------------------
    public void mousePressed( MouseEvent me )
    {
        lastMouse = me.getPoint();   
    }
    
    //----------------------------------------------------------
    public void mouseDragged( MouseEvent me )
    {
        Point curMouse = me.getPoint();
  
        int newX = myX + curMouse.x - lastMouse.x;
        int newY =  myY + curMouse.y - lastMouse.y;
        
        ///////////////////////////////////////////////////////////
        // Check to see if the new x or y will be out of the bounds,
        // if it is then set its value  to the bound
        //////////////////////////////////////////////////////////
        if( newX < 0 )
        {
            newX = 0;
        }
        if( newY < 0 )
        {
             newY = 0;
        }
        if( newX > 700 - getWidth() )
        {
            newX = 700 - getWidth();
        }
        if( newY > 500 - getWidth() )
        {
            newY = 500 - getWidth();
        }
        
        
        
        //Now we can do the  Normal drag code
        myX = newX;
        myY = newY;        
        setLocation( myX, myY);   
        lastMouse = curMouse;  
    }
    
    
    //---------------------------- main -----------------------------------------
    public static void main( String[ ] args )      
    {
        new Frame( );
        new TrappedBall(  325, 225 );
    }
}