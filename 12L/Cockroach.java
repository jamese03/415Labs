
// ---------------       imports          ------------------------------
import wheelsunh.users.*;
import java.awt.Color;
import java.util.Random;

// ----------------------   class Cockroach    ---------------------------
/** 
 * This class creates a Cockroach that cannot be killed
 * 
 *
 * @author Sam Young CS415
 */

public class Cockroach extends Ellipse
{
    //--------------instance variables-------------------------------
    
    private Ellipse body;
    int bodyX = 50, bodyY = 50;
    int height = 20;
    Random rand = new Random();
    private Cockroach c2;
    int width;
    
    public Cockroach( )
    {
//        body = new Ellipse( bodyX, bodyY );
//        body.setColor( java.awt.Color.GRAY );
//        body.setSize( 3 * height, height );
//        body.setRotation( 45 );
        
        height = 10 + rand.nextInt( 25 - 10 );
        width = 3 * height;
            
        int randomrot = rand.nextInt( 360 - 0 );
        int loca = rand.nextInt( 700 - 0 );
        int loca2 = rand.nextInt( 500 - 0 );
        
        
        this.setColor( Color.GRAY );
        this.setSize( width, height );
        this.setLocation( loca, loca2 );
        this.setRotation( randomrot );
    }
    
    public void mousePressed( java.awt.event.MouseEvent e )
    {
        int newx = rand.nextInt( 700 - 0 );
        int newy = rand.nextInt( 500 - 0 );
        c2 = new Cockroach(  );

        this.setLocation( newx, newy );
        int x = e.getPoint().x;
        int y = e.getPoint().y;
        int xroach = c2.getXLocation();
        int yroach = c2.getYLocation();
        
        System.out.println( " The Coordinates of the mouse " + e.getX() + " , " + e.getY() );
        System.out.println( " The size of the Cockroach is " + height
                               + " , " + width );
        System.out.println( " The Location of the Cockroach is " + newx
                               + " , " + newy );
    }
    
        
     // -----------------------------------------------------------------
    /** main program creates a Frame and invokes the class constructor.
      * 
      * @param  args  the command line.
      */
    public static void main( String[] args )
    {
        Frame f = new Frame( 700, 500 );
        Cockroach c1 = new Cockroach( );
    }
    }