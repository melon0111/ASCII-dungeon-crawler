import java.util.*;
import java.io.*;

//the Dungeon class is the object that all of our dungeon levels/maps will be comprised of. Thus far it will contain a grid read from a text file and a player location.
public class Dungeon {

char[][] map = new char[20][20]; //our map grid of characters, my initial idea here is that any spaces will be null, but printed as spaces

public Dungeon(int level){ //constructor for our Dungeon, the idea here is to take the file and map out the characters to our map array
   int row = 0;
   
   try {
      File dng = new File("Dungeon1.txt"); //reads our first dungeon file, this will have to be made modular, to read different dungeon levels
      Scanner builder = new Scanner(dng);
      while(builder.hasNextLine()) { //here we'll create a string, then populate the corresponding row of our 2D array with it
         String rowString = builder.nextLine();
         for(int i = 0; i < rowString.length(); i++){
            map[row][i] = rowString.charAt(i);
         }
         row++;
      }
   } catch (FileNotFoundException e) {
         System.out.println("That Dungeon file does not exist");
   }
}




}