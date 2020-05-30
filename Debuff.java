import java.util.Random;
public class Debuff {
	private Random ran = new Random();
	public int bleed() {
		int temp = ran.nextInt(5);
		if(temp > 0) {	
		return -1;
		} 
		return 0;
	}
	
	public char confuse(char symbol) {
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
		return symbol;
	}
}
