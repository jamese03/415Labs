
import wheelsunh.users.*;
import java.awt.Color;
import java.util.*;
import java.awt.Point;

/**
 * BouncingBall.java.
 * @author MB
 * 
 */
public class BouncingBall extends Ellipse
{
    private int deltaX, deltaY;
    private int size;
    private Point currentPoint;
    private int diffX;
    private int diffY;
    
    
    
    //-------------------------------  BouncingBall -------------------
    /**
     * Create a bouncingBall of size s with given deltaX and deltaY.
     * 
     * @param s int
     * @param dX int
     * @param dY int
     */ 
    public BouncingBall ( int s, int x, int y )
    {    
        
        super();
        s = size;
        deltaX = 20;
        deltaY = 20;
    }
    
    //-------------------------------  move ----------------------------
    /**
     * This will move the ball by deltaX and deltaY
     * and bounce the ball off the edges of the Frame.
     * 
     */ 
    public void move() 
    {
        if( getYLocation() + deltaY < 0 ) 
        {
            setLocation( getXLocation() + deltaX, 0 );
            deltaY *= -1;
        }
        else if( getXLocation() + getWidth() + deltaX> 700 )
        {
            setLocation( 700 - getWidth() , getYLocation() + deltaY );
            deltaX *= -1;
        }
        else if( getXLocation() + deltaX < 0 )
        {
            setLocation( 0 , getYLocation() + deltaY );
            deltaX *= -1;
        }
        else if( getYLocation() + getHeight() + deltaY > 500 )
        {
            setLocation( getXLocation() + deltaX , 500 - getHeight() );
            deltaY *= -1;
        }
        else
        {
            setLocation( getXLocation() + deltaX , getYLocation() + deltaY );
        }
    }
    
    
    //-------------------------------  main ----------------------------
    /**
     * Get the ball rolling.
     * @param arg String[]
     * 
     * 
     */ 
    public static void main( String arg[] )
    {
        new Frame( );
        BouncingBall bb1 = new BouncingBall( 40 , 5 , 5 );
      
        
        while( true )
        {
            bb1.move();
            Utilities.sleep( 30 );
        }
        
        
        
    }
}
