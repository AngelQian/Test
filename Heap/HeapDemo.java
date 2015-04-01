package Heap;

public class HeapDemo {

	public static void main(String[] args) {
		int size = 20;
		Heap h = new Heap(size);
		/*h.insert(90);
		h.insert(60);
		h.insert(40);
		h.insert(80);
		//h.displayHeap();
		
		h.insert(93);
		h.insert(64);
		h.insert(45);
		h.insert(86);*/
		
		for(int i=0; i<size; i++){
		h.insert_at(i, new Node((int)(Math.random()*100)));
		h.increase_size();
		}
		h.displayHeap();
		
		for(int j=size/2-1; j>=0; j--){
			h.trickDown(j);
		}

		for(int k=size-1; k>=0; k--){
			Node big_node = h.remove();
			h.insert_at(k, big_node);
		}
		h.displaySortedHeap();
	}

}
