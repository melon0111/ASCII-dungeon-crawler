
public class Player {
	private int x;
	private int y;
	private int hp = 100;
	private int def;
	private int attack;
	
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
	
	public void move(char symbol) {
		if(!Dungeon.checkNewPos((x + "-" + y), symbol)) {
			System.out.println("You hug the wall, it feels appreciated");
		}else {
			Dungeon.changePos((x + "-" + y), symbol);
		}
	}
	
	public void equip(char type, int x) {
		if(type == 'w') {
			attack = x;
		} else {
			def = x;
		}
	}
}
