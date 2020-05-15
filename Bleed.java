import java.util.*;
public class Bleed {
	
	private String list; //contains current list of targets with bleed and duration of buff.
	private Scanner scan = new Scanner(list);
			
	//takes in a string with the targets identification and duration 
	public void addTarget(String tar, int dur) {
		list += tar + ":" + Integer.toString(dur) + "\n"; // adds new target to list
		
	}
	
	//runs through list of targets with debuffs
	public void action( ) {
		
		while(scan.hasNext()) {
			// split method
		}
		update();
		scan = new Scanner(list);
		}
	
	// decrements the duration of the debuff and removes once it reaches 0
	private void update() {
		String nList; //updating new list values
		while(scan.hasNext()) {
			// and split here Integer.parseInt();
			if(dur == 0) {
				
			} else {
				nlist += target + ":" + Integer.toString(dur) + "\n";
			}
			
	}
	}
}
