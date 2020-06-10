import java.util.*;
import java.io.*;

//this is our primary class to run the game. We'll have to go over the exact structure together but this is the base that I'm working with.
public class DungeonCrawler {
   public static Scanner IS = new Scanner(System.in); //input scanner
   public static Player PC = new Player();            //player object
   public static Dungeon Map = new Dungeon();
   
public static void main(String[] args) {
   
   while(IS.nextLine() != "q" || IS.nextLine() != "Q"){ //Q quits the game
      PC = intro();
      playerAction();      
   }
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
      System.out.println("In this game use wasd to move, i to open and close the inventory.");
      System.out.println("use the uhjk keys to face the direction you want to attack");
      System.out.println("Godspeed!");
      Map.place(PC.rep, "10-10"); //player will spawn here initially on our first map
      Map.printMap();
   return PC;
}

public static void playerAction(){
   try {
      char input = IS.nextLine().charAt(0);
      
		if(input >= 65 && input <= 90) {
			input += 22; //removes capitalization from equation
		}

      if(input == 119 || input == 115 || input == 97 || input == 100) {
         PC.action(Map, input);
      }//else if(input == 'u', 'h', 'j', 'k',) {
         
   //   }else if(input == 'i',) {
         
      
   } catch(Exception invalidChar) {
      System.out.println("Unrecognized command (WASD to move, UHJK for direction, I for inventory, Q to quit)");
   }
}













}