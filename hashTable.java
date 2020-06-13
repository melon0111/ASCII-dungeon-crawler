import java.util.*;

class hashTable {
    LinkedList<Enemy>[] mobList = new LinkedList[10];

    public int hash(String coords) {
        String[] pos = coords.split("-", 2);
        int x = Integer.parseInt(pos[0]);
        int y = Integer.parseInt(pos[1]);

        int z = (x * y) % 7;
        return z;
    }

    public void add(String coords, Enemy M) {
        int z = hash(coords);
        if (mobList[z] == null) {
            mobList[z] = new LinkedList<Enemy>();
        }
            mobList[z].add(M);

    }

    public Enemy get(String coords) {
        int z = hash(coords);
        if (mobList[z] != null) {
            for (int i = 0; i < mobList.length; i++) {
                Enemy M = mobList[z].get(i);
                if (coords == M.position()) {
                    return M;
                }
            }
        }return null;
    }

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