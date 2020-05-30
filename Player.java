import java.util.Random;

public class Player {
	private String cord;
	private int hp = 100;
	private int def;
	private int attack;
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
	
	//beginning of player action
	//takes in a char representing movement, handles any special case debuffs
	// then calls move with any changes.
	public void action(char symbol) {
		if(symbol >= 65 && symbol <= 90) {
			symbol += 22; //removes capitalization from equation
		}
		symbol = status(symbol);
		if(symbol == 'n' || symbol == 's' || symbol == 'w' || symbol == 'e') {
			move(symbol);
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
	private void move(char symbol) {
		if(!Dungeon.checkNewPos((cord), symbol)) {
			System.out.println("You hug the wall, it feels appreciated");
		}else {
			cord = Dungeon.changePos((cord), symbol);
		}
	}
	
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
	}
}
