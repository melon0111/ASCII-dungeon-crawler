public class Item {
   private int value;
   private String name;
   private String modifier;
   
   
   
   public void setItem(int val, String nam) {
      value = val;
      name = nam;
   }
   
   public void setModifier(int val, String mod) {
      mod = modifier;
      value += val;
   }
   
   //if the weapon type is metal, it will have different modifier names
   public boolean isMetalWeap() {
      if(name == "rock" || name == "medium stick" || name == "slingshot" || name == "big stick" || name == "machine gun" || name == "short bow" || name == "longbow") {
         return false;
      } else {
         return true;
      }
   }

   //if the armor type is metal, it will have different modifier names
   public boolean isMetalArmor() {
      if(name == "rags" || name == "thick shirt" || name == "gambeson") {
         return false;
      } else {
         return true;
      }
   }
   
   public int getVal() {
      return value;
   }
   
   public String getName() {
      
      return name;
   }




}