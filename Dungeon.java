import java.util.*;
import java.io.*;

//the Dungeon class is the object that all of our dungeon levels/maps will be comprised of. Thus far it will contain a grid read from a text file and a player location.
public class Dungeon {

public int level = 0;
char[][] map = new char[20][20]; //our map grid of characters, my initial idea here is that any spaces will be null, but printed as spaces


//constructor for our Dungeon, the idea here is to take the file and map out the characters to our map array
public Dungeon(){ 
   int row = 0;
   
   try {
      File dng = new File("Dungeon" + level + ".txt"); //reads our level of dungeon
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



//creates the next dungeon in the game (or the previous, if you go up)
public void nextDungeon(){ 
   int row = 0;
   
   
   while(row < 20) { //overwrites existing map with blank space if given map is less than 20x20 {
      for(int i = 0; i < 20; i++) {
         map[row][i] = 0;
      } row++;
   }   
      
   row = 0;
   try {
      File dng = new File("Dungeon" + level + ".txt"); //reads our level of dungeon
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



//this will check what is at the position the player is interacting with
public char checkInteract(String origin, char facing) {  
   String[] coords = origin.split("-", 2);
   int x = Integer.parseInt(coords[0]); int y = Integer.parseInt(coords[1]); //converts the x-y hash to x and y integers
   
   if(facing == 'N') {
      y--;
   }else if(facing == 'S') { 
      y++;
   }else if(facing == 'W') { 
      x--;
   }else if(facing == 'E') { 
      x++;
   }

   return map[y][x]; //returns the character at that position
    
}


//this will return the coordinates of the position you want to interact with
public String getInteractPos(String origin, char facing) {  
   String[] coords = origin.split("-", 2);
   int x = Integer.parseInt(coords[0]); int y = Integer.parseInt(coords[1]); //converts the x-y hash to x and y integers
   
   if(facing == 'N') {
      y--;
   }else if(facing == 'S') { 
      y++;
   }else if(facing == 'W') { 
      x--;
   }else if(facing == 'E') { 
      x++;
   }
   String ans = new String();
   ans = x + "-" + y;

   return ans; //returns the character at that position
    
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
public void remove(String position) {
   String[] coords = position.split("-", 2);
   int x = Integer.parseInt(coords[0]); int y = Integer.parseInt(coords[1]); //converts the x-y hash to x and y integers
   map[y][x] = 0; //removes symbol from the space it occupies
}

//returns current dungeon level, for item levelling! cool!
public int getLevel() {
   return level;
}


/* This method will involve retrieving applicable hash/keys. So it will return the object at the grid position, or the character if there is no associated object
public void getPos(int x, y) {
   return 
}
*/

}