import java.util.*;

public class inventoryHeap {
   private int size = 0;
   LinkedList<Item> heap = new LinkedList<Item>();
   
   //constructs out heap using Floyd's method
   public void inventoryHeap(LinkedList<Item> input) {
      Item val = new Item();
      val.setItem(0, "no item");
      heap.add(val);

      for(int i = 0; i < input.size(); i++) {
         heap.add(input.get(i));
      }
      this.size = heap.size() -1;
      
      for(int i = size/2; i > 0; i--) {
         val = heap.get(i);
         int hole = percolateDown(i, val);
         heap.set(hole, val);
      }
      
      
   }
   
   //this will be used to return sorted items to the menu
   public Item deleteMin() {
   Item ans = new Item();
      if(size == 0) {
         ans.setItem(0, "no item");
      } else {
         ans = heap.get(1);
         int hole = percolateDown(1, heap.get(size-1));
         heap.set(hole, heap.get(size));
         size--;
      } heap.removeLast();
      return ans;
   }
   
   public int percolateDown(int hole, Item val) {
      int target;
      
      while(2*hole <= size) {
         int left = 2*hole;
         int right = left+1;
         
         boolean toobig = false;
         if(right > size){
            toobig = true;
            right--;
         }
         
         if(toobig || heap.get(left).getVal() < heap.get(right).getVal()) {
            target = left;
         }else{
            target = right;
         }if(heap.get(target).getVal() < val.getVal()) {
            heap.set(hole, heap.get(target));
            hole = target;
         }else{
            break;
         }
         heap.set(hole, heap.get(hole));
      }return hole;
   }
   
   public int percolateUp(int hole, Item val) {
      while(hole > 1 && val.getVal() < heap.get(hole/2).getVal()) {
         heap.set(hole, heap.get(hole/2));
         hole = hole/2;
      } return hole;
   }
   
   
   public int heapSize() {
      return size;
   }
   
   
   
   
   public Item[] getHeap() {
      Item [] ret = new Item[size];
      for(int i = 0; i < size; i++) {
         ret[i] = heap.get(i);
      }return ret;
   }
   
}