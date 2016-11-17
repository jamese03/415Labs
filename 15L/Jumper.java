/**
 * Jumper - 
 * 
 * @author rdb 
 * derived from the Cockroach class by mlb
 * 
 * History 
 * 10/19/09 rdb Jumper - also generates random color
 *       
 */
import wheelsunh.users.*;
import java.awt.Color;
import java.util.*;

public class Jumper extends Ellipse
{   
   //-------------- instance variables -----------------
   private Random  rng        = null;
   private static int count = 1;
   public int rem;
   
   //------------------- Constructor -------------------
   public Jumper()
   {       
       count++;
      System.out.println( " count " + count );
      
      rng = new Random();
      int height = rng.nextInt( 15 ) + 10;
      int width  = height * 3;
      
      setSize( width, height );     
      
      setRotation( rng.nextInt( 360 ));    
      jump();     
      int rem =  height %  3;
      
      if( rem == 0 )
      {
          setColor( Color.BLACK );
      }
      else if( rem == 1 )
      {
          setColor( Color.BLUE );
      }
      else if( rem == 2 )
      {
          setColor( Color.GREEN );
      }
      
   }
   
   //----------------------- jump() ---------------------------
   public void jump()
   {
      int x = rng.nextInt( 680 ); 
      int y = rng.nextInt( 480 )  ; 
      setLocation( x,  y );
   }
   
   //-------------------mousePressed( MouseEvent  --------------
   public void mousePressed( java.awt.event.MouseEvent e )
   {
     
      
      Jumper child = null;
      child = new Jumper();     
      jump(); 

      System.out.println( "------------  roaches! ----- " );
      
      if( getColor() == Color.BLACK )
      {
          setColor( Color.BLUE );
          child = new Jumper(); 
          jump();
      }
      if( getColor() == Color.BLUE )
      {
          setColor( Color.GREEN );
          jump();
      }
      if( getColor() == Color.GREEN && count < 10 )
      {
          setColor( Color.BLACK );
          child = new Jumper(); 
         
      }
      if( getColor() == Color.GREEN)
      {
          setColor( Color.BLACK );
      }
      
      
   } 
   
   
   //----------------------- main ---------------------------
   public static void main ( String[] argv )     
   {
      Frame m = new Frame();
      Jumper cartoon = new Jumper();
   }   
}
