public class test {

public static void main(String[] args) {
   String pos = "15-2";
   char input = 'w';
   char symbol = '$';
   Dungeon Dungeon1 = new Dungeon(1);
   Dungeon1.printMap();
   boolean available = Dungeon1.checkNewPos(pos, input);
   if(available) {
      pos = Dungeon1.changePos(pos, input, symbol);
   }
   Dungeon1.printMap();

}

}