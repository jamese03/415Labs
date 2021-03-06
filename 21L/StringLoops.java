/**
 * StringLoops.java
 *      This class is just a collection of static methods that use different
 *      varieties of loops, arrays and ArrayLists/Vectors.
 *      Part of Lab 14.
 * 
 * @author rdb
 * 10/29/07
 */

import java.util.*;
public class StringLoops
{
   //--------------------- class variables --------------------------------
   static Random generator;
   static String alphabet[] = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                                "k", "l", "m", "n", "o", "p", "q", "r", "r", "t",
                                "u", "v", "w", "x", "y", "z" };
   //--------------------main ------------------------------------------- 
   public static void main( String args[] ) 
   { 
      ArrayList<String> names = new ArrayList<String>();
      ArrayList<String> sorted = new ArrayList<String>();
      
      generator = new Random( 2 );
      
      generateData( names, false );      
      printInOrder( names );
      printInReverse( names );
      
      System.out.println( "--------------------------------" );
      
      generateData( sorted, true );
      printInOrder( sorted );
      printInReverse( sorted );
   }
   //------------------------- generateData ----------------------------
   private static void generateData( ArrayList<String> n, boolean sort )
   {  
      // generate random number to decide how many strings to put into ArrayList
      int howMany = generator.nextInt( 5 ) + 5; // from 4 to 9 strings
      
      for ( int i = 0; i < howMany; i++ )
      {
         int    which = generator.nextInt( alphabet.length ) ;
         String name = alphabet[ which ];
         if ( sort )
            addSorted( n, name );
         else           
            n.add( name );
      }
   }
   
   //------------------------ addSorted--------------------------------  
   private static void addSorted( ArrayList<String> n, String name )
   {
      // Note: string1.compareTo( string2 ) returns 
      //        -1 if string1 is lexicographically less than string2
      //         0 if string1 and string2 are the same
      //         1 if string1 is lexicographically greater than string2
      
      int i = 0;
      while ( i < n.size() && name.compareTo( n.get( i )) >= 0 )
         i++;
      n.add( i, name );  // this can be an insertion, which pushes other
                         // elements down in the array to make space for new one
   }

   //------------------------ printInOrder ------------------------------
   private static void printInOrder( ArrayList<String> n )
   {
      for ( int i = 0; i < n.size(); i++ )
         System.out.print( " " + n.get( i ) );
      System.out.println();
   }
   
   //------------------------ printInReverse -----------------------------     
   private static void printInReverse( ArrayList<String> n )
   {
      for ( int i = n.size() - 1; i >= 0; i-- )
         System.out.print( " " + n.get( i ) );
      System.out.println();
   }  
}