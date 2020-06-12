public class inventoryHeap {
   private int size = 0;
   private Item[] heap = new Item[0];
   
   //constructs out heap using Floyd's method
   public void inventoryHeap(Item[] input) {
      int size = heap.length;
      heap = input;
      Item val = new Item();
      
      for(int i = size/2; i > 0; i--) {
         val = heap[i];
         int hole = percolateDown(i, val);
         heap[hole] = val;
      }
      
   }
   
   //this will be used to return sorted items to the menu
   public Item deleteMin() {
   Item ans = new Item();
      if(heap[1] == null) {
         ans.setItem(0, "no item");
      } else {
         ans = heap[1];
         int hole = percolateDown(1, heap[size]);
         heap[hole] = heap[size];
         size--;
      }return ans;
   }
   
   public int percolateDown(int hole, Item val) {
      int target;
      while(2*hole <= size) {
         int left = 2*hole;
         int right = left+1;
         if(heap[left].getVal() < heap[right].getVal() || right > size) {
            target = left;
         }else{
            target = right;
         }if(heap[target].getVal() < val.getVal()) {
            heap[hole] = heap[target];
            hole = target;
         }else{
            break;
         }
         
      }return hole;
   }
   
   public int percolateUp(int hole, Item val) {
      while(hole > 1 && val.getVal() < heap[hole/2].getVal()) {
         heap[hole] = heap[hole/2];
         hole = hole/2;
      } return hole;
   }
   
   
   public int heapSize() {
      return size;
   }
   
}