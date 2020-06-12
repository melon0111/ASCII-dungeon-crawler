public class test {

public static void main(String[] args) {
   Dungeon map = new Dungeon();
   Inventory inv = new Inventory();
   inv.setArmors();
   inv.setWeapons();
   for(int i = 0; i < 10; i++) {
      inv.randomItem(map);
   }
   Player PC = new Player();
   inv.openInventory(PC);
}

}