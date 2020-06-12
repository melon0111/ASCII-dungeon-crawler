import java.util.Random;
import java.util.Scanner;

//this inventory class will be the players main storage, as well as contain lists of possible items, and manage random item spawns
public class Inventory {
   private Item [] playerArmors = new Item[50];
   private Item [] playerWeapons = new Item[50];
   private Item [] armorSet = new Item[13];
   private Item [] weaponSet = new Item[13];
   
   //this method sets out list of armors that can be gotten
   public void setArmors() {
      for(int i = 0; i < weaponSet.length; i++) {
         armorSet[i] = new Item();
      }
      armorSet[0].setItem(3, "rags");
      armorSet[1].setItem(5, "bucket helmet");
      armorSet[2].setItem(8, "thick shirt");
      armorSet[3].setItem(10, "gambeson");
      armorSet[4].setItem(12, "chain mail");
      armorSet[5].setItem(15, "hauberk");
      armorSet[6].setItem(17, "lamelar");
      armorSet[7].setItem(20, "cuirass");
      armorSet[8].setItem(23, "plate armor");
      armorSet[9].setItem(25, "gothic armor");
      armorSet[10].setItem(28, "adamantium armor");
      armorSet[11].setItem(30, "mithril armor");
      armorSet[12].setItem(35, "armor of the gods");
   }
   
   //this method sets out list of weapons that can be gotten
   public void setWeapons() {
      for(int i = 0; i < weaponSet.length; i++) {
         weaponSet[i] = new Item();
      }
      weaponSet[0].setItem(3, "rock");
      weaponSet[1].setItem(5, "medium stick");
      weaponSet[2].setItem(8, "slingshot");
      weaponSet[3].setItem(10, "dagger");
      weaponSet[4].setItem(12, "big stick");
      weaponSet[5].setItem(15, "shortsword");
      weaponSet[6].setItem(17, "spear");
      weaponSet[7].setItem(20, "short bow");
      weaponSet[8].setItem(23, "longsword");
      weaponSet[9].setItem(25, "longbow");
      weaponSet[10].setItem(28, "halberd");
      weaponSet[11].setItem(30, "flaming poleaxe");
      weaponSet[12].setItem(35, "machine gun");
   }

   //this method randomizes what type of item will be gotten
   public void randomItem(Dungeon map) {
      Random rando = new Random();
      int rand = rando.nextInt(2);
      if(rand == 0) {
         addWeapon(map);
      } else if(rand == 1) {
         addArmor(map);
      }// else if(rand == 2) {
     //    addSpell();
     // }
   }
   
   //this method will add the item type and determine the modifier of the item gotten
   public void addWeapon(Dungeon map) {
      int level = map.getLevel();
      Item newItem = new Item();
      
      Random rando = new Random(); //assigns an item based on dungeon level and random chance
      int rand = rando.nextInt(3);
      newItem = weaponSet[level + rand];
      
      rand = rando.nextInt(5); //assigns a weapon grade randomly
      if(rand == 0) {
         if(newItem.isMetalWeap()) {
            newItem.setModifier(-2, "rusty");
         } else {
            newItem.setModifier(-2, "shoddy");
         }
      } else if(rand == 1) {
         if(newItem.isMetalWeap()) {
            newItem.setModifier(-1, "dull");
         } else {
            newItem.setModifier(-1, "wonky");
         }
      } else if(rand == 2) {
         //no modifier
      } else if(rand == 3) {
         if(newItem.isMetalWeap()) {
            newItem.setModifier(1, "sharp");
         } else {
            newItem.setModifier(1, "nice");
         }
      } else if(rand == 4) {
         if(newItem.isMetalWeap()) {
            newItem.setModifier(2, "Masterpiece");
         } else {
            newItem.setModifier(2, "excellent");
         }
      }
      int i = 0; //this block places the item in the closest open inventory slot
      boolean fin = false;
      while(i < 50 && fin == false) {
         if(playerWeapons[i] != null) {
            playerWeapons[i] = newItem;
            fin = true;
         } else { i++; }
      }if(i == 50) {
         System.out.println("Sorry, inventory for that item is full!");
      }

}

   //this method will add the item type and determine the modifier of the item gotten
   public void addArmor(Dungeon map) {
      int level = map.getLevel();
      Item newItem = new Item();
      
      Random rando = new Random(); //assigns an item based on dungeon level and random chance
      int rand = rando.nextInt(3);
      newItem = armorSet[level + rand];
      
      rand = rando.nextInt(5); //assigns a weapon grade randomly
      if(rand == 0) {
         if(newItem.isMetalArmor()) {
            newItem.setModifier(-2, "cracked");
         } else {
            newItem.setModifier(-2, "tattered");
         }
      } else if(rand == 1) {
         if(newItem.isMetalArmor()) {
            newItem.setModifier(-1, "rusty");
         } else {
            newItem.setModifier(-1, "shoddy");
         }
      } else if(rand == 2) {
         newItem.setModifier(0, " ");
      } else if(rand == 3) {
         if(newItem.isMetalArmor()) {
            newItem.setModifier(1, "shiny");
         } else {
            newItem.setModifier(1, "quality");
         }
      } else if(rand == 4) {
         if(newItem.isMetalArmor()) {
            newItem.setModifier(2, "Masterpiece");
         } else {
            newItem.setModifier(2, "exquisite");
         }
      }
      int i = 0; //this block places the item in the closest open inventory slot
      boolean fin = false;
      while(i < 50 && fin == false) {
         if(playerWeapons[i] != null) {
            playerWeapons[i] = newItem;
            fin = true;
         } else { i++; }
      } if(i == 50) {
         System.out.println("Sorry, inventory for that item is full!");
      }

}


   //this will be the main UI for the inventory
   public Player openInventory(Player PC) {
      int value = 0;
      System.out.println("hit a for armor, w for weapons, or anything else to leave this menu");
      Scanner IS = new Scanner(System.in);
      if(IS.nextLine().charAt(0) == 'a' || IS.nextLine().charAt(0) == 'A'){
         value = armorSelect();
         PC.equip('x', value);
      }else if(IS.nextLine().charAt(0) == 'w' || IS.nextLine().charAt(0) == 'W'){
         value = weaponSelect();
         PC.equip('w', value);
      }
      return PC;
   }
   
   //this will print the armors the player can equip and ask which he wants to
   public int armorSelect() {
      int armorLevel = 0;
      inventoryHeap heap = new inventoryHeap();
      heap.inventoryHeap(playerArmors);
      Item [] list = new Item[heap.heapSize()+1]; //our displayed list of items
      
      for(int i = 0; i < list.length ; i++) {
         list[i] = heap.deleteMin();
      }
         System.out.println("|-------------------------------------------");
         System.out.println("|  To select armor, enter its index number  ");
         System.out.println("|-------------------------------------------");
         System.out.println("|index   Strength   Name                    ");
      for(int i = 0; i < list.length; i++) {
         System.out.println("|" + i + "      " + list[i].getVal() + "     " + list[i].getName());
      }  System.out.println("-------------------------------------------");
      Scanner IS = new Scanner(System.in);
      try {
         int choice = IS.nextInt(); //this will assign the player choice to our return value
         while(choice > 0 && choice < list.length) {
            armorLevel = list[choice].getVal();
         }
      }catch(Exception invalidInput) {
         System.out.println("please type the number of the item you would like to equip");
      } return armorLevel;
   }



   //this will print the weapons the player can equip and ask which he wants to
   public int weaponSelect() {
      int weaponLevel = 0;
      inventoryHeap heap = new inventoryHeap();
      heap.inventoryHeap(playerWeapons);
      Item [] list = new Item[heap.heapSize()+1]; //our displayed list of items
      
      for(int i = 0; i < list.length ; i++) {
         list[i] = heap.deleteMin();
      }
         System.out.println("|-------------------------------------------");
         System.out.println("| To select a weapon, enter its index number");
         System.out.println("|-------------------------------------------");
         System.out.println("|index   Strength   Name                    ");
      for(int i = 0; i < list.length; i++) {
         System.out.println("|" + i + "      " + list[i].getVal() + "     " + list[i].getName());
      }  System.out.println("-------------------------------------------");
      Scanner IS = new Scanner(System.in);
      try {
         int choice = IS.nextInt(); //this will assign the player choice to our return value
         while(choice > 0 && choice < list.length) {
            weaponLevel = list[choice].getVal();
         }
      }catch(Exception invalidInput) {
         System.out.println("please type the number of the item you would like to equip");
      } return weaponLevel;
   }

}