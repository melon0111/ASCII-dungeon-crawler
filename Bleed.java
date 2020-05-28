import java.util.*;
public class Bleed {
	
	private String list; //contains current list of targets with bleed and duration of buff.
	private String nList; //updating new list values
	private Scanner scan = new Scanner(list);
	
			
	//takes in a string with the targets identification and duration 
	public void addTarget(String tar, int dur) {
		list += tar + ":" + Integer.toString(dur) + "\n"; // adds new target to list

	}
	
	//runs through list of targets with debuffs
	public void action( ) {
		while(scan.hasNext()) {
			String temp = scan.next();
			String[] aStr = temp.split(":", 2);
			
			//target.dmg.(1); need some way to dmg other objecs here here.
		
		this.update(aStr[0], Integer.parseInt(aStr[1])-1); // adds the target and decrements debuff dur to nlist
		}
		list = nList; // once list has been parsed updates it with nlist taking care of anyremovals and updates.
		scan = new Scanner(list);
		}
	
	// adds to nlist or removes tar once it reaches dur 0 
	private void update(String tar, int dur) {
			if(dur == 0) {
				
			} else {
				nList += tar + ":" + Integer.toString(dur) + "\n";
			}
			
	}
}
