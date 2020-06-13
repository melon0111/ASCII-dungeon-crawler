
public class Enemy {

	private int x;
	private int y;

	//returns a string representing current position
	public String position() {
		return "" + x + "-" + y;
	}
   
   public void action(Player PC) {
   
   }
   
   //assigns an initial position
   public void assignPos(int newx, int newy) {
      x = newx;
      y = newy;
   }
}
