 /**
 * Loops demo -- Debugger Lab
 */

import wheelsunh.users.*;
import java.awt.Color;
import java.awt.Point;
import java.util.*;

public class Loops
{  
   //---------------- class variables --------------------
   public  static int cmdErrors = 0;
   
   //------------------------- nested -------------------------
   public static void nested( )
   {
      // the code below is equivalent to the following nested for
      int n = 0;
      
      int i = 1;        // for ( int i = 1; i < 4; i = i + 1 )
      while ( i < 4 )
      {
         int j = 1;           // for int j = 1; j <= i; j++ )
         while ( j <= i )   
         {
            n += 1;          //           n += 1;
            j++;  
         }
         i = i + 1;
      }
      // the code above is equivalent to the following nested for
      /**/
      {
         n = 0;
         for ( i = 1; i < 4; i++ )
            for ( int j = 1; j <= i; j++ )
            {
               n++;
            }
      }
      /***/
   }
   
   //---------------  drawLines   -----------------------------
   public static void drawLines()
   {
      int count = 0;
      while ( count < 20 ) 
      {
         new Line( 30, count * 5, 100, count * 5 );
         count++;
      } 
   }
   
   //-------------------- drawBoxes   -------------------------
   public static void drawBoxes( int n )
   {
      for ( int i = 0; i < n; i++ ) 
      {
         for ( int j = 0; j < i; j++ ) 
         {
            Rectangle temp = new Rectangle( 100 + 20 * j , 100 + 20 * i );
            temp.setSize( 20, 20 );
            temp.setFrameColor( Color.BLACK );
         }
      }
   }
   
   //----------------------- sum ----------------------------
   public static void sum( int n , int m )
   {
      int sum = 0;
      ConversationBubble b = new ConversationBubble( "" + sum );
      b.setLocation( new Point( 0, 300 ) );   
      
      for ( int i = 0; i < n; i++ ) 
      {
         for ( int j = 0; j < m; j++ ) 
         {
            sum = sum + j;
            b.setText( "" + sum ) ;
         }
      }
   }
   //------------------------- getInt ------------------------------------   
   private  static int getInt( String arg, int defaultVal )
   { int cmdErrors = Loops.cmdErrors;
      try
      {
         return Integer.parseInt( arg );
      } 
      catch ( NumberFormatException nfe )
      {  
         cmdErrors++;
         System.err.println( "***Error in command line parameter: " + arg );
         System.err.println( "   It's not an int. Using: " + defaultVal );
      }
      
      return defaultVal;
   }
   //----------------------- printArray( String, int[] )----------------------
   public static void printArray( String header, int[] values )
   {
      int  numbersPerLine = 8;
      System.out.println( "--------------- " + header + "-------------------" );
      for ( int i = 0; i < values.length; i++ )
      {
         if ( i % numbersPerLine  == 0 )    // print limit on a line
            System.out.println();
         System.out.print( values[ i ] + " " );
      }
      System.out.println();
   }
   //------------------------ convertArgsToInts-------------------------------   
   private static int[] convertArgsToInts( String[] args, int defaultValue )
   {
      // create an int array from the args String array
      //   assume all args are (or should be) integers
      //   use the utility getInt function that converts
      //   a String to an int if it can, but returns a 
      //   user specified default value if it fails
      
      int vals[] = new int[ args.length ];
      
      for ( int i = 0; i < args.length; i++ )
         vals[ i ] = getInt( args[ i ], defaultValue );
      
      return vals;
   }
   
   //-------------------------------------------------------
   public static void main ( String[] args ) 
   {
      int defaultVal = -1;
      int[] intParams;
      Frame f = new Frame();
      cmdErrors = 0;
      
      intParams = convertArgsToInts( args, defaultVal );
      
      printArray( "Integers from command line: ", intParams );
            
      drawLines(); 
      nested();
      drawBoxes( 6 );      
      sum( 5, 3 ); 
   }  
}