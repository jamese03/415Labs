/**
 * PowerRectangle.java 
 *   This class extends Rectangle to add 
 *    - a peer object (a TextBox)
 *    - code to display the area, circumference, and diagonal length of
 *      the rectangle in the TextBox. 
 *      Use the ShapeFunctions class methods to compute these values.
 *    - Use mouse clicked to print size info to Interactions pane
 *   
 * @author rdb
 */
import wheelsunh.users.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Point;

public class PowerRectangle extends Rectangle
{
   //--------------- instance variables --------------------
   private TextBox peer;
   int height;
   int width;
   Point lastMousePosition;
   Point currentMousePosition;
   int diffX;
   int diffY;
   
   /**-------------------------------------------------------------------------
    * Constructor requires the x,y location of the rectangle
    *     must pass this on to super constructor
    * It must create a TextBox with a text string.
    *     The string should show the Area, Circumference and Diagonal length
    *     This should be done in the "updateInfo" private method that
    *     should be called from here.
    */
   public PowerRectangle( int x, int y )
   {
       super( x, y );
       peer = new TextBox( x - 40, y - 40 );
       peer.setText( " Power Rectangle ");
      
   }

   //-------------------------------------------------------------------------
   /**
    * setSize( int, int ) -- defines the width and height of the rectangle. 
    *     We need to override the parent setSize, because we must also use
    *     the new information to update the text field of the associated 
    *     TextBox object, by calling "updateInfo()".
    * 
    *     But, you still must invoke the super class setSize to get the 
    *     size changed!
    **********************************************************************
    ********************** Warning: **************************************
    **********************************************************************
    * setSize is called by the Rectangle constructor BEFORE the
    * PowerRectangle constructor is called!  This means that the first 
    * call to setSize happens BEFORE you have created your TextBox and 
    * initialized the instance variable that references it. 
    * 
    * setSize, however, needs to call "updateInfo()" to change the text
    * in the TextBox, but there is no TextBox yet (only the first time).
    * 
    * Hence, in the setSize code below you must only call "updateInfo" 
    * if your instance variable that references the TextBox is NOT null.
    * 
    * See the class notes from slide set 9.
    **********************************************************************
    */
   public void setSize( int width, int height )
   {  
       if( peer != null){
       super.setSize( width , height );
       this.updateInfo();}
              
   }

   //------------ utility methods --------------------------
   /**
    * updateInfo -- computes the current area and circumference of the 
    * rectangle (using methods in the ShapeFunctions class) and updates
    * the text string in the TextBox.
    * 
    * Note that the ShapeFunctions methods compute the area and circumference
    * as doubles; this class only needs to show the integer version of that,
    * so you need to coerce (or cast) the value returned from ShapeFunctions to
    * an int before assigning it to the local int variables.
    * 
    * Note: The String object you need to pass to the TextBox
    *       must be constructed from strings of text and numbers. We have
    *       yet covered this in class. If you have variables "area" and
    *       "circumference" with the appropriate values, you can create a
    *       String to give to TextBox with the following line:
    * 
    *    String message = "A: " + area + ", C: " + circumference;
    */
   private void updateInfo()
   {
       int area = (int) ShapeFunctions.area( this );
       int circumference = (int) ShapeFunctions.circumference( this ) ;
       int diagonal = (int) ShapeFunctions.diagonal( this );
      
       peer.setText( "A: " + area + ", C: " + circumference + ", D: " + diagonal );

   }
   
   //-------------------------------------------------------------------------
   /**
    * changeSizeBy( int, int ) -- update size of Rectangle by an encremental
    *                       amount in x and y. 
    */
   private void changeSizeBy( int dX, int dY )
   {
     this.getHeight();
     this.getWidth();
     super.setSize( this.getWidth() + dX, this.getHeight() + dY );

   }
   //-------------------------------------------------------------------------
   /**
    * mouseClicked - print the width/height to System.out
    */
   public void mouseClicked( MouseEvent me )
   {  
       lastMousePosition = me.getPoint();
       this.getHeight();
       this.getWidth();
    
       System.out.println( " width " + this.getWidth() + " , " + " height "
                              + this.getHeight() );  
   }
   public void mousePressed( MouseEvent me )
   {
    lastMousePosition = me.getPoint(); 
   }
   public void mouseDragged( MouseEvent me )   
   {
         
        Point currentMousePosition = me.getPoint();
         
         int diffX = currentMousePosition.x - lastMousePosition.x;
         int diffY = currentMousePosition.y - lastMousePosition.y;
         changeSizeBy( diffX, diffY );
         lastMousePosition = currentMousePosition;
         
         System.out.println( " width " + this.getWidth() + " , " + " height "
                              + this.getHeight() );  
         updateInfo();
   }
     
   //------------------ main ----------------------------------
   // unit test code
   //
   public static void main( String args[] )
   {
      Frame f = new Frame();
      PowerRectangle pr1 = new PowerRectangle( 250, 250 );
      PowerRectangle pr2 = new PowerRectangle( 100, 200 );
      PowerRectangle pr3 = new PowerRectangle( 400, 400 );
      pr1.setColor( Color.BLUE );
      pr2.setColor( Color.BLACK );
      pr3.setColor( Color.GREEN );
      pr1.setSize( 20, 25 );
      pr2.setSize( 45, 35 );
      pr3.setSize( 65, 25 );
   }
}
