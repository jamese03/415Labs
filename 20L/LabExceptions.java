

import java.util.*;
import java.io.*;

/**
 * LabExceptions.java. 
 * @author mlb
 */
public class LabExceptions 
{ 
    /**
     * Constructor.
     * 
     *@throws IOException if file won't open
     */
    public LabExceptions( )  throws IOException                         
    { 
        // create a System.in scanner
        System.out.println( "Enter input file name> " );
        Scanner  scanIn   = new Scanner( System.in ); 
        String   fileName = scanIn.nextLine().trim();
        
        //////////////////////////////////////////////////////////////
        // 1. Create a File object from a String 
        // (containing the file name).
        ///////////////////////////////////////////////////////////////
        
        File inputFile = new File(  fileName );
   
        ////////////////////////////////////////////////////////////////
        
        System.out.println( "\n*******************************\n" );
        System.out.println( "Part 1: print a file to standard output" +
                               " with line numbers\n\n" );
        
        lineInput( inputFile );
        
        System.out.println( "\n*******************************\n" );
        System.out.println( "Part 2:print the same file one token per" +
                               " line\n\n" ); 
        
        tokenInput( inputFile );
        
        
    }
    
    /**
     * Read lines from inputFile and print out with line numbers.
     * 
     * @throws IOException  if file won't open
     * @param inFile File
     */
    private void lineInput( File inFile ) 
    {       
        Scanner scanFile;
        // 2a. Create a Scanner object from the File parameter, inFile 
        // 5. Add try-catch
        
        try
        {     
            scanFile = new Scanner( inFile );
        }
        catch( IOException ex )
        {
            System.err.println( ex.getMessage() );
            return;
        }
    
        
        // 2b. Read lines from the Scanner, print each input line on 1 
        // output line
        // prefixed by its line number, starting at 1; make it readable.
        int num = 0;
        
        while( scanFile.hasNextLine() )
        {
            num++;
            System.out.println( num + " " + scanFile.nextLine() );
        }
        
        
    }
    
    
    /**
     * Read tokens from inputFile and print out as one token per line.
     * 
     * 
     * @throws IOException  if file won't open
     * @param inFile File
     */
    
    private void tokenInput( File inFile ) throws IOException
    {
        Scanner scanFile;
        // 3a. Create a Scanner object from the File parameter, inFile 
        // 6. Add try-catch
        try
        {
        scanFile = new Scanner( inFile );
        
        while( scanFile.hasNext() )
        {
            System.out.println( scanFile.next(  ) );
        }
        }
        catch( IOException ex )
        {
            System.err.println( ex.getMessage() );
            return;
        }
  
        // 3b. Read tokens from the Scanner, print each input token 
        //     on its own output line
      
    }
    
    
    
    /**
     * Main.
     * @param args String[]
     * @throws IOException  if file won't open
     */
    public static void main( String[ ] args ) throws IOException
    {
        LabExceptions app = new LabExceptions( );
    }
}
