import java.util.Random;

public class Ranged {
	private int x;
	private int y;
	private char symbol;
	private boolean agro;
	
	//decides ai's action 
	public void action(String player) {
		 String[] coords = player.split("-", 2);
		 int x = Integer.parseInt(coords[0]); int y = Integer.parseInt(coords[1]); //converts the x-y hash to x and y integers
		 if(!agro) {
			 agro(x, y); //checks if player is close enough to agro on
		 }
		 if(x - this.x > -3 && x - this.x < 0) {
			 if (!map.checkNewPos((""+ this.x  + "-" + this.y), symbol)) {
				 
			 }
		 }
		 
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
	
	//checks if the player is close enough and changes the ai's agro boolean to true
	// to modify it's pattern
	private void agro(int x, int y) {
		if( ((y - this.y) + ( x - this.x)) <= 6 && ((y - this.y) + ( x - this.x)) >= -6 ) {
			agro = true;
		}
	}
	
	//chooses the ai's movement, following player if agro true
	// or calls rMove for random direction
	private String move() {
		if(!agro) {
			char move = rMove(); 
			while(!map.checkNewPos((""+ this.x  + "-" + this.y), move)){
				move = rMove();
				
			}
			String cord = map.changePos((""+ this.x  + "-" + this.y), move, symbol);
			String[] coords = cord.split("-", 2);
			int x = Integer.parseInt(coords[0]); int y = Integer.parseInt(coords[1]); 
			this.x = x; 
			this.y = y;
		}else {
			
		}
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
