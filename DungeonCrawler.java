import java.util.*;
import java.io.*;

//this is our primary class to run the game. We'll have to go over the exact structure together but this is the base that I'm working with.
public class DungeonCrawler {
   public static Scanner IS = new Scanner(System.in); //input scanner
   public static Player PC = new Player();            //player object
   public static Dungeon Map = new Dungeon();
   public static boolean turn;
   public static Inventory Inv = new Inventory();
   
public static void main(String[] args) {
   char input = ' ';
   
   
   PC = intro();
   PC.ui();
   while(input != 'q' || input != 'Q') {
   turn = true;
   //this block constitutes the player's turn, while turn is true it will loop
   //thus attacking or moving will end the player turn
      while(turn){
      try {
         input = IS.nextLine().charAt(0);
      } catch(Exception invalidInput) {
         System.out.println("please enter a command");
      }
      playerAction(input);
      }
      
      
      
      Map.printMap();
      PC.ui();
   }
   
}



//this class will give an introduction and assign a player-given symbol
public static Player intro() {
   Inv.setWeapons();
   Inv.setArmors();
   System.out.println("Welcome to The Dungeon! To begin, give your character a symbol for the map:");
   try {
      while(PC.symbol() == 0 || PC.symbol() == 32) {
         PC.symbol(IS.nextLine().charAt(0));
         if(PC.symbol() <= 32 || PC.symbol() == 45 || PC.symbol() == 124) { //catches possible problem symbols
            System.out.println("This character conflicts with one in the game, Sorry try again!");
            PC.symbol(' ');
         }
      }
   } catch(Exception invalidChar) {
      System.out.println("Sorry! That's an invalid character!");
   }
      System.out.println("In this game use wasd to move, i to open and close the inventory.");
      System.out.println("use the uhjk keys to face the direction you want to attack");
      System.out.println("Godspeed!");
      
      Map.place(PC.symbol(), "10-10"); //player will spawn here initially on our first map
      Map.printMap();
      PC.ui();
   return PC;
}



//This is the primary method for player actions, taking movement, direction or inventory actions
public static void playerAction(char input){
   if(input >= 65 && input <= 90) {
			input += 32; //removes capitalization from equation
		}
   try {
      if(input == 'w' || input == 'a' || input == 's' || input == 'd') { //movement
         Map = PC.move(Map, input);
         turn = false; //ends player turn
      }else if(input == 'u' || input == 'h' || input == 'j' || input == 'k') { //direction
         PC.face(input);
         Map.printMap();
         PC.ui();
      }else if(input == 'e') { //interaction
         interact();
         Map.printMap();
      }else if(input == 'i') { //interaction
         PC = Inv.openInventory(PC);
         Map.printMap();
         PC.ui();
      } else {
         System.out.println("Unrecognized command (WASD to move, UHJK for direction, I for inventory, Q to quit)");
      }
   } catch(Exception invalidInput) {
         System.out.println("Unrecognized command (WASD to move, UHJK for direction, I for inventory, Q to quit)");
      }
      
      
}


   //interact lets the player interact with ladders and chests
   public static void interact() {
      char result = Map.checkInteract(PC.getPos(), PC.facing());
      if(result == 'v') { //traverses down
         Map.level++;
         Map.nextDungeon();
         Map.place(PC.symbol(), PC.getPos());
         Map.printMap();
      }else if(result == '^') { //traverses up
         Map.level--;
         Map.nextDungeon();
         Map.place(PC.symbol(), PC.getPos());
         Map.printMap();
      }else if(result == '$') { //get that loot! gives random loot from a chest
         Inv.randomItem(Map);
         String intPos = new String(Map.getInteractPos(PC.getPos(), PC.facing()));
         Map.remove(intPos);
      } else {
         System.out.println("You can't interract with this object!");
      }
   }










}