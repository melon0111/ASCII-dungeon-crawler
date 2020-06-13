import java.util.Random;

public class Angel extends Enemy{
	private int x;
	private int y;
	private char symbol;
	private int attack;
	private int hp = 20;
	private boolean damaged;
	
	//decides ai's action 
	public Dungeon action(Dungeon map, String player) {
		attack = (-100 - map.level);
		 String[] coords = player.split("-", 2);
		 int playerX = Integer.parseInt(coords[0]); int playerY = Integer.parseInt(coords[1]); //converts the x-y hash to x and y integers
		 
		 //attacks player if close enough and there is nothing in the way
		 //if there is it will move
		 if(this.x - playerX > -3 && this.x - playerX < 0) { // checks if player is in positive x direction and within 2
			 if (!map.checkNewPos((""+ this.x  + "-" + this.y), "w") && this.x - 1 != playerX && this.y == playerY) {
				 map = move(map, playerX, playerY);//there is an obstruction so ai moves, or player is too close.
				 
			 }else {
				// Player.dmg(attack);
			 }
		 }else if(this.x - playerX < 3 && this.x - playerX > 0 ) { //checks if player is in negative x direction and within 2 
			 if (!map.checkNewPos((""+ this.x  + "-" + this.y), "e") && this.x + 1 != playerX && this.y == playerY ) {
				 map = move(map, playerX, playerY);//there is an obstruction so ai moves, or player is too close.
			 }else {
				// Player.dmg(attack);
			 }
		 }else if (this.y - playerY > -3 && this.y - playerY < 0) { //checks if player is in negative y direction but compensates for inverted map
			 if (!map.checkNewPos((""+ this.x  + "-" + this.y), "n") && this.x != playerX && this.y -1 != playerY) {
				 map = move(map, playerX, playerY);//there is an obstruction so ai moves, or player is too close.
			 }else {
				// Player.dmg(attack);
			 }
		 }else if(this.y - playerY < 3 && this.y - playerY > 0) {//checks if player is in positive y direction but compensates for inverted map 
			 if (!map.checkNewPos((""+ this.x  + "-" + this.y), "s") && this.x == playerX && this.y + 1 != playerY) {
				 map = move(map, playerX, playerY); //there is an obstruction so ai moves, or player is too close.
			 }else {
				// Player.dmg(attack);
			 }
		 }else {
			map = move(map, playerX, playerY); // calls move because player is not close enough to attack
		 }
		return map; 
	}
	//sets the damaged boolean to true if is not already
	//then subtracts the int passed to it and returns value of hp
	public int dmg (int x) {
		hp--;
		return hp; 
	}
	
	//returns a string representing current position
	public String position() {
		return "" + x + "-" + y;
	}
	
	//returns the ai's symbol
	public char symbol() {
		return symbol;
	}
	
	//assigns a new symbol to ai
	public void symbol(char x) {
		symbol = x;
	}

	
	//chooses the ai's movement, following player if agro true
	// or calls rMove for random direction
	private Dungeon move(Dungeon map, int playerX, int playerY) {
		char move;
		int distanceX = this.x - playerX;
		int distanceY = this.y - playerY;
		while(move == 0) {
		if(Math.abs(distanceX) > Math.abs(distanceY)) {
			if(distanceX > 0 && map.checkNewPos((""+ this.x  + "-" + this.y), 'e')) {
				move = 'e';
			}else if(distanceX < 0 && map.checkNewPos((""+ this.x  + "-" + this.y), 'w')) {
				move = 'w';
			}else{
				distanceX = 0;
			}
		}else {
			if(distanceY > 0 && map.checkNewPos((""+ this.x  + "-" + this.y), 's')) {
				move = 's';
			}else if(distanceY < 0 && map.checkNewPos((""+ this.x  + "-" + this.y), 's')) {
					move = 's';
			}else{
				distanceY = 0;
			}
			}
		if(distanceX == 0 && distanceY == 0) {
				move = rMove();
		}

		}
		
		String cord = map.changePos((""+ this.x  + "-" + this.y), move, symbol);
		String[] coords = cord.split("-", 2);
		int x = Integer.parseInt(coords[0]); int y = Integer.parseInt(coords[1]); 
		this.x = x; 
		this.y = y;
		return map;
	}
	
	// randomly chooses a direction
	private char rMove() {
		char move;
		Random ran = new Random();
		int temp = ran.nextInt(3);
		if(temp == 0) {
			move = 'n';
		}else if(temp == 1) {
			move = 's';
		} else if(temp == 2) {
			move = 'w';
		} else {
			move = 'e';
		}
		return move;
	}
}
