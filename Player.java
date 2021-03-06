import java.util.Random;

public class Player {
   private char facing = 'N';
	private String cord = "5-18";
	private int hp = 100;
	private int def = 0;
	private int attack = 2;
	private boolean bleed;
	private boolean confusion;
   private char rep;
	
	// returns the char representing the player
	public char symbol() { 
		return rep;
	}
	
	public void symbol(char x) {
		rep = x;
	}
	
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
   
   public int dmg() {
      return attack;
   }
		
	//changes value based on value of weapon
	public void equipWeap(int x) {
			attack = x;
	}
   
   //changes value based on value of armor
	public void equipArmor(int x) {
			def = x;
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
   
   public String getPos() {
      return cord;
   }
   
   public char facing() {
      return facing;
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
