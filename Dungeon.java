import java.util.*;
import java.io.*;

//the Dungeon class is the object that all of our dungeon levels/maps will be comprised of. Thus far it will contain a grid read from a text file and a player location.
public class Dungeon {

char[][] map = new char[20][20]; //our map grid of characters, my initial idea here is that any spaces will be null, but printed as spaces


//constructor for our Dungeon, the idea here is to take the file and map out the characters to our map array
public Dungeon(int level){ 
   int row = 0;
   
   try {
      File dng = new File("Dungeon1.txt"); //reads our first dungeon file, this will have to be made modular, to read different dungeon levels
      Scanner builder = new Scanner(dng);
      while(builder.hasNextLine()) { //here we'll create a string, then populate the corresponding row of our 2D array with it
         String rowString = builder.nextLine();
         for(int i = 0; i < rowString.length(); i++){ //loops for x coordinates
            if(rowString.charAt(i) == 32) { //if the position is a space, changes to a null ascii character, may or may not be necessary, keeps things simple though
               map[row][i] = 0;
            } else {
               map[row][i] = rowString.charAt(i);
            }
         }
         row++;
      }
   } catch (FileNotFoundException e) {
         System.out.println("That Dungeon file does not exist");
   }
}


//this method will simply run through the ASCII map and print to the prompt
public void printMap() { 
   for(int i = 0; i < map.length; i++) {
      for(int j = 0; j < map[i].length; j++) {
         System.out.print(map[i][j]);
         System.out.print(" ");
      }
      System.out.println();
   }
}



//this method checks to see if a position is a vacant floor space, should always be run before changePos. Basically changePos that doesn't change anything(may implement a related method that checks for other objects, as it relates to attacks)
//Y is open, N is occupied
public boolean checkNewPos(String origin, char input) {  
   String[] coords = origin.split("-", 2);
   int x = Integer.parseInt(coords[0]); int y = Integer.parseInt(coords[1]); //converts the x-y hash to x and y integers
   
   if(input == 119 || input == 87) { //if input is w, move up
      y--;
   }else if(input == 115 || input == 83) { //if input is s, move down
      y++;
   }else if(input == 97 || input == 65) { //if input is a, move left
      x--;
   }else if(input == 100 || input == 68) { //if input is d, move right
      x++;
   }

   if(map[y][x] == 0) { //checks if space is blank
      return true;
   }else{
      return false;
   }
}



//this method takes a given hash key (which is the coordinates x-y) and splits into x and y, then
public String changePos(String origin, char input, char symbol) {  
   String[] coords = origin.split("-", 2);
   int x = Integer.parseInt(coords[0]); int y = Integer.parseInt(coords[1]); //converts the x-y hash to x and y integers
   
   map[y][x] = 0; //removes symbol from the space it occupies
   
   if(input == 119 || input == 87) { //if input is w, move up
      y--;
   }else if(input == 115 || input == 83) { //if input is s, move down
      y++;
   }else if(input == 97 || input == 65) { //if input is a, move left
      x--;
   }else if(input == 100 || input == 68) { //if input is d, move right
      x++;
   }
   
   map[y][x] = symbol; //places symbol on it's new position
   
   
   return x + "-" + y; //concatenation of new hash key string
}


//this method will place/spawn a symbol on the map
public void place(char symbol, String position) {
   String[] coords = position.split("-", 2);
   int x = Integer.parseInt(coords[0]); int y = Integer.parseInt(coords[1]); //converts the x-y hash to x and y integers
   map[y][x] = symbol; //places symbol on it's new position
}


//this method will remove/despawn a symbol from the map
public void remove(char symbol, String position) {
   String[] coords = position.split("-", 2);
   int x = Integer.parseInt(coords[0]); int y = Integer.parseInt(coords[1]); //converts the x-y hash to x and y integers
   map[y][x] = 0; //removes symbol from the space it occupies
}


/* This method will involve retrieving applicable hash/keys. So it will return the object at the grid position, or the character if there is no associated object
public void getPos(int x, y) {
   return 
}
*/

}