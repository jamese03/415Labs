import wheelsunh.users.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.Point;
/**
 * makes a draggable piano implementing Draggable
 * 
 * @author Sam Young
 */

public class Piano extends ShapeGroup implements Draggable
{
    //--------------instance variable------------------------------
    private Rectangle body; 
    private Rectangle keys;
    int bodyX = 25, bodyY = 25;
    int keysX = 40, keysY = 90;
    int x = 100, y = 100;
    
    Color c1;
    Point lastMousePosition;
    Point currentMousePosition;
    int diffX;
    int diffY;
    int r1;
    int r2;
        
    //--------------piano constructor------------------------------
    
    public Piano()
    {
        body = new Rectangle(Color.BLACK);
        body.setSize( 200, 200 );
        keys = new Rectangle(Color.WHITE);
        keys.setSize( 60 , 10 );
        add(body);
        add(keys);    
    }
    public Piano( int x, int y, Color _color )
    {
        c1 = _color;
        body = new Rectangle( _color );
        body.setSize( 200, 100 );
                
        keys = new Rectangle(Color.WHITE);
        keys.setSize( 175 , 20 );
            
        body.setLocation( x + bodyX, y + bodyY );
        keys.setLocation( x + keysX, y + keysY );
        add(body);
        add(keys);
     } 
    public void setColor( Color _color)
    {
        body.setColor( _color );
    }
    
    public Color getColor( )
    {
        return body.getColor( );
    }
    
    public void mousePressed( java.awt.event.MouseEvent e )
    {
        body.setFillColor( Color.GRAY ); 
        lastMousePosition = e.getPoint();
            }
    
    public void mouseReleased( java.awt.event.MouseEvent e )
    {
        body.setFillColor( c1 );
        Piano p3 = new Piano( r1, r2, c1.darker() );
    }
    public void mouseDragged( java.awt.event.MouseEvent e )
    {
        currentMousePosition = e.getPoint();
        diffX = currentMousePosition.x - lastMousePosition.x;
        diffY = currentMousePosition.y - lastMousePosition.y;
        setLocation( diffX + body.getXLocation(), 
                    diffY + body.getYLocation());
        lastMousePosition = currentMousePosition;
    }
    public static void main( String[] args )
    {
        Frame f1 = new Frame();
        Piano p1 = new Piano( 150, 150, Color.CYAN );
        Piano p2 = new Piano( 0, 0, Color.BLUE );
        Piano p3 = new Piano( 300, 300, Color.RED );
      }
}