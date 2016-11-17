import wheelsunh.users.*;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.*;


/** 
 *  MorphingShape.java:
 *  
 */
public class MorphingShape extends ShapeGroup
{ 
   //----------------- instance variables --------------------------------------

   private Rectangle r;
   private RoundedRectangle rr;
   private Ellipse e;
   int state = 0;
   
   
   //------------------ constructors ---------------------------------------------
   public MorphingShape(int x, int y ) 
   {        
        r = new Rectangle( x, y );
        add( r );
        r.setColor( Color.GREEN );
        
        rr = new RoundedRectangle( x, y );
        add( rr );
        rr.setColor( Color.RED );
        
        e = new Ellipse( x, y );
        add( e );
        e.setColor( Color.BLUE );
        
         //////////////////////////////////////////
        //   hide all but one shape and remember
        //   which one is showing
        ///////////////////////////////////////////
        
        r.show();
        rr.hide();
        e.hide();
        
      
   }
    

   //-----------------------------------------------------------------------------
   public void mouseClicked( MouseEvent me )
   {
         ///////////////////////////////////////////
         // change rectangle  to rounded rectangle  
         // or rounded rectangle  to ellipse 
         // or ellipse to rectangle 
         ///////////////////////////////////////////     
       if( state == 0 )
       {
           
           rr.show();
           e.hide();
           r.hide();
           state = 1;
       }
       else if( state == 1 )
       {
           e.show();
           r.hide();
           rr.hide(); 
           state = 2;
       }
       else if( state == 2 )
       {
           r.show();
           e.hide();
           rr.hide();  
           state = 0;
       }
        
      
     
   }
     
   
   //---------------------------- main -----------------------------------------
   public static void main( String[ ] args )      
   {
      new Frame( );

      new MorphingShape( 325, 225 );
   }
}