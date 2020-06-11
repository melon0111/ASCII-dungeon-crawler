import java.util.Random;

public class Player {
   public char rep;
   private char facing = 'N';
	private String cord = "10-10";
	private int hp = 100;
	private int def = 0;
	private int attack = 2;
	private boolean bleed;
	private boolean confusion;
	
	//method to damage hp of the character
	public void dmg (int x) {
		x = x + def; //currently static reduction, might want to change math
		if(x < 0) {
			hp += x;
		}
		if( hp <= 0) {
			System.out.println("You Are Dead!");
			//set flag in main to game over
		}
	}
		
	//changes value based on value of weapon
	public void equip(char type, int x) {
		if(type == 'w') {
			attack = x;
		} else {
			def = x;
		}
	}
	
	//takes in a symbol from action and checks if the movement is possible
	// before updating map/cord
	public Dungeon move(Dungeon map, char symbol) {
		if(!map.checkNewPos((cord), symbol)) {
			System.out.println("You hug the wall, it feels appreciated");
		}else {
			cord = map.changePos((cord), symbol, rep);
		}
      return map;
	}
   
   public void place(String position) {
      cord = position;
   }
   
   
   //takes a symbol from action and makes the character face that direction
   public void face(char symbol) {
      if(symbol == 'u') { //faces north
         facing = 'N';
      }else if(symbol == 'h') { //faces west
         facing = 'W';
      }else if(symbol == 'j') { //faces south
         facing = 'S';
      }else if(symbol == 'k') { //faces east
         facing = 'E';
      }
   }
   
   
   
   //prints out a UI, giving player info
   public void ui() {
      System.out.println("hp: " + hp + "  def: " + def + "  attack: " + attack + "    facing: " + facing);
   }
   
   
   
   //interact lets the player interact with ladders and chests
   public Dungeon interact(Dungeon map) {
      char result = map.checkInteract(cord, facing);
      if(result == 'v') {
         map.level++;
         map.nextDungeon();
         map.place(rep, cord);
         map.printMap();
      }else if(result == '^') {
         map.level--;
         map.nextDungeon();
         map.place(rep, cord);
         map.printMap();
      } else {
         System.out.println("You can't interract with this object!");
      }
      return map;
   }
   
   
	/*
	//checks any adverse status effects and preforms any relevant action.
	private char status(char symbol) {
		//checks if player has bleed debuff and damages their hp
		if(bleed) {
			int x = Debuff.bleed();
			if(x < 0) {
				hp -= x;
				System.out.println("You take " + x + " in bleed damage.");
			} else {
				bleed = !bleed;
			}
		}
		
		//if player has confusion randomizes direction 
		if(confusion) {
			Random ran = new Random();
			int temp = ran.nextInt(3);
			if(temp == 0) {
				symbol = 'n';
			}else if(temp == 1) {
				symbol = 's';
			} else if(temp == 2) {
				symbol = 'w';
			} else {
				symbol = 'e';
			}
		}
		return symbol;
	} */
}
