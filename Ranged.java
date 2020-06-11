
public class Ranged {
	private int x;
	private int y;
	private char symbol;
	
	public void action(String play) {
		
		 String[] coords = play.split("-", 2);
		 int x = Integer.parseInt(coords[0]); int y = Integer.parseInt(coords[1]); //converts the x-y hash to x and y integers
		 this.x = x; this.y = y;
		 
	}
	
	public String position() {
		return "" + x + "-" + y;
	}
	
	public char symbol() {
		return symbol;
	}
	
	public void symbol(char x) {
		symbol = x;
	}
}
