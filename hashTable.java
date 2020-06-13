import java.util.*;

//this class creates a hash table with a pretty simple hash function that stores enemies based on their position on the map
class hashTable {
    LinkedList<Enemy>[] mobList = new LinkedList[10]; //we use an array of linked lists for this
    
//the mathematical hash function
    public int hash(String coords) {
        String[] pos = coords.split("-", 2);
        int x = Integer.parseInt(pos[0]);
        int y = Integer.parseInt(pos[1]);

        int z = (x * y) % 7;
        return z;
    }

//adds the enemy object to it's sublist
    public void add(String coords, Enemy M) {
        int z = hash(coords);
        if (mobList[z] == null) {
            mobList[z] = new LinkedList<Enemy>();
        }
            mobList[z].add(M);

    }

//returns the enemy object at the given coordinates
    public Enemy get(String coords) {
        int z = hash(coords);
        if (mobList[z] != null) {
            for (int i = 0; i < mobList.length; i++) {
               if(i < mobList.length){
                Enemy M = mobList[z].get(i);
                if (coords == M.position()) {
                    return M;
                }
               }
            }
        }return null;
    }


//removes the enemy at the given coordinates
    public void remove(String coords) {
        int z = hash(coords);
        if (mobList[z] != null) {

            for (int i = 0; i < mobList.length; i++) {
                Enemy M = mobList[z].get(i);

                if (coords == M.position()) {
                    mobList[z].remove(i);
                }
            }
        }
    }
    
    
    
}