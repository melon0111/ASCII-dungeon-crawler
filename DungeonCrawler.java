import java.util.*;
import java.io.*;

//this is our primary class to run the game. We'll have to go over the exact structure together but this is the base that I'm working with.
public class DungeonCrawler {
   public static Scanner IS = new Scanner(System.in); //input scanner
   public static Player PC = new Player();            //player object
   
public static void main(String[] args) {

   
   PC = intro();


}


//this class will give an introduction and assign a player-given symbol
public static Player intro() {
   System.out.println("Welcome to The Dungeon! To begin, give your character a symbol for the map:");
   try {
      while(PC.rep == 0) {
         PC.rep = IS.nextLine().charAt(0);
         if(PC.rep <= 32 || PC.rep == 45 || PC.rep == 124) { //catches possible problem symbols
            System.out.println("This character conflicts with one in the game, Sorry try again!");
            PC.rep = 0;
         }
      }
   } catch(Exception invalidChar) {
      System.out.println("Sorry! That's an invalid character!");
   }
      System.out.println("In this game use wasd to move, i to open the inventory, and escape to close.");
      System.out.println("use the arrow keys to face another direction when attacking");
      System.out.println("Godspeed!");
   return PC;
}




}