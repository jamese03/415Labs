
import wheelsunh.users.*;
import java.util.*;
import java.awt.Point;
import java.awt.Color;


/**
 * IntersectApp.java.
 * @author MB
 * 
 */
public class Intersect 
{
    
    private Rectangle rectangle;
    private BouncingBall ball;
    
    //-------------------------------  Intersect -----------------------
    /**
     *  Draw a rectangle and a ball then animate.
     * 
     * 
     */ 
    public Intersect (   )
    {      
        rectangle = new Rectangle( 200, 200 );
        rectangle.setSize( 200, 200 );
        
        ball =  new BouncingBall( 30, 15, 10 ) ;
        animate( );
    }
    
    
    
    //-------------------------------  animate -------------------------
    /**
     * This will animate a ball forever
     * when the ball and rectangle intersect then make the rectangle
     * blue.
     * 
     */ 
    public void animate()
    {
        while( true )
        {
            ball.move();
            Utilities.sleep( 100 );
            if( rectangle.boundsIntersects( ball ) )
            {
                rectangle.setColor( Color.BLUE );
            }
            else
            {
                rectangle.setColor( Color.RED );
            }
        }
        
        
    }
    
    
    //-------------------------------  main ----------------------------
    /**
     *  Get the ball rolling.
     * @param a String[]
     * 
     */ 
    public static void main( String a[] )
    {
        new Frame( );
        new Intersect( );
    }
}
