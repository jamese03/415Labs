/** 
 * Utilities.java.
 *  
 *@author MB
 */

public class Utilities
{  
    //---------------------------------------------------------
    /**
     * This will pause execution.
     * @param milliseconds int
     * 
     */ 
    public static void sleep( int milliseconds ) 
    {
        try
        {
            Thread.sleep( milliseconds );
        }
        catch ( java.lang.InterruptedException e ) 
        {  }
    }
}