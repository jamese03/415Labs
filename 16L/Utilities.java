

import wheelsunh.users.*;
import java.awt.Color;
import java.util.*;
import javax.swing.JOptionPane;


/** 
 * Utilities.java.
 *  
 * @author MB
 */
public class Utilities
{  
    //++++++++++++++++++++ readInt ++++++++++++++++++++
    /**
     * Prompts user with Da Dialog and returns parsed integer.
     * If there is an exception then it reurns d.
     * @param prompt String
     * @param defaultValue int
     * @return int
     * 
     */
    public static int readInt( String prompt, int defaultValue )
    {
        String s = JOptionPane.showInputDialog( null,  prompt );   
        
        return  Utilities.parseInt( s, defaultValue );
    }
    
    
   //++++++++++++++++++++ parseInt ++++++++++++++++++++
   /**
    * parses s for an integer, if it can't be parsed
    * then return d.
    * 
    * @param s String
    * @param d int
    * @return int
    */
    private static int parseInt( String s, int d )
    {
        if( s == null )
            return d;
        
        Scanner scanner = new Scanner( s );
 
        if ( scanner.hasNextInt( ) )
        {
            d =  scanner.nextInt( );
            
        }
        else
            System.out.println( "Integer parse error: "  + s );
        
        return d;    
    }
    
    
    //++++++++++++++++++++ sleep ++++++++++++++++++++
    /**
     * sleep for m milliseconds, ignore exceptions.
     * @param m int
     * 
     */
    public static void sleep( int m ) 
    {
        try
        {
            Thread.sleep( m );
        }
        catch ( java.lang.InterruptedException e ) 
        {  }
    }
    
    
    
    
} //End of Class 