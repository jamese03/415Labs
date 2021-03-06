import wheelsunh.users.*;
import java.awt.event.*;
import java.util.*;
import java.awt.Point;
import java.awt.Color;

/**  GrinderApp
  * Create a collection of coins and rotating grinders.
  * 
  *@author Sam Young MB
  * 
  */
public class GrinderApp  
{  
    private Rectangle r;
    private Ellipse e;
    private int delay = 40;   // time delay in milliseconds
    private int count = 0;    // number of iterations of animation loop.
    private Vector <Rectangle> grinders;
    private Vector <Ellipse> coins;
    private int x = -15;
    private int counter = 0;

      
    
    //++++++++++++++++++++ default constructor ++++++++++++++++++++
    /**
     * Create a Grinder.
     * 
     */
    public GrinderApp( ) 
    {  

        grinders = new Vector <Rectangle>( );
        
        for( int i = 0; i < 13; i++ )
        {
            r = new Rectangle( i * 55 , 250 );
            r.setSize( 40, 40 );
            grinders.add( r );
            counter++;
        }
        
        coins = new Vector <Ellipse>( );
        
        counter = 0;
        int eLoc = 40;
        for( int i = 0; i < 12; i++ )
        {
            e = new Ellipse( eLoc , 260 );
            e.setSize( 15 , 15 );
            e.setFrameColor( Color.BLACK );
            e.setFillColor( Color.YELLOW );
            coins.add( e );
            eLoc = eLoc + 55;
            counter++;
        }
        delay = Utilities.readInt( "enterDelay" , 50 );
        while( delay > 0 )
        {
            count = 0;
            animate();
            delay = Utilities.readInt( "enterDelay" , 50 );
        }
        
        
    }
    //++++++++++++++++++++++++ animate ++++++++++++++++++++++++++++
    /**
     *  Animate the grinder.
     * 
     */
    public void animate()
    {
        while( count < 100 )
        {
            for( int i = 0; i < 13; i++ )
            {     
                grinders.get( i ).setRotation( grinders.get( i ).getRotation() + 2);
                  
            }
            Utilities.sleep( delay );
            count++;
        }
    }
    
    
    //--------------------------- main ---------------------------------
    /**
     * get the grind going.
     *
     * @param args String[]
     */
    public static void main( String args[ ] )
    {
        Frame f = new Frame( );
        GrinderApp  m = new GrinderApp(  ); 
    }
}
