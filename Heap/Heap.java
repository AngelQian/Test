package Heap;

public class Heap {
	private Node[] heapArr;
	private int max_size;
	private int current_size;

	public Heap(int mx) {
		max_size = mx;
		current_size = 0;
		heapArr = new Node[max_size];
	}

	public boolean isEmpty() {
		return current_size == 0;
	}

	public boolean insert(int data) {
		if (current_size == max_size)
			return false;

		Node temp = new Node(data);
		heapArr[current_size] = temp;
		trickUp(current_size);
		current_size++;

		return true;
	}

	private void trickUp(int index) {
		int par_index = (index - 1) / 2;
		Node bottom = heapArr[index];

		while (index > 0 && heapArr[par_index].get_data() < bottom.get_data()) {
			heapArr[index] = heapArr[par_index];
			index = par_index;
			par_index = (index - 1) / 2;
		}

		heapArr[index] = bottom;

		/*
		 * int par_data = heapArr[par_index].get_data();
		 * 
		 * int temp_data = heapArr[index].get_data();
		 * 
		 * while(temp_data > par_data){ heapArr[index].set_data(par_data); index
		 * = par_index; par_index = (index-1)/2;
		 * heapArr[index].set_data(temp_data); }
		 */
	}

	public Node remove() {// remove root
		Node root = heapArr[0];
		heapArr[0] = heapArr[--current_size];
		trickDown(0);
		return root;
	}

	public void trickDown(int index) {
		int large_cindex;
		Node top = heapArr[index];

		while (current_size / 2 > index)// 如果有child
		{
			int left_cindex = index * 2 + 1;
			int right_cindex = index * 2 + 2;
			top = heapArr[index];

			if (right_cindex < current_size
					&& heapArr[right_cindex].get_data() > heapArr[left_cindex]
							.get_data())
				large_cindex = right_cindex;
			else
				large_cindex = left_cindex;

			if (heapArr[index].get_data() >= heapArr[large_cindex].get_data())
				break;

			heapArr[index] = heapArr[large_cindex];
			index = large_cindex;
			heapArr[index] = top;
		}
//		heapArr[index] = top;
	}

	public boolean change(int index, int new_data) {
		if (index < 0 || index > current_size)
			return false;
		int old_data = heapArr[index].get_data();
		heapArr[index].set_data(new_data);

		if (old_data > new_data)
			trickDown(index);
		else
			trickUp(index);

		return true;
	}

	public void displayHeap() {
		System.out.println("heap array: ");
		for (int i = 0; i < current_size; i++) {
			if (heapArr[i] != null)
				System.out.print(heapArr[i].get_data() + "  ");
			else
				System.out.print("--");
		}
		System.out.println("");
		//可以进一步格式化
	}
	public void displaySortedHeap() {
		System.out.println("heap array: ");
		for (int i = 0; i < max_size; i++) {
			if (heapArr[i] != null)
				System.out.print(heapArr[i].get_data() + "  ");
			else
				System.out.print("--");
		}
		System.out.println("");
		//可以进一步格式化
	}
	
	public void insert_at(int index, Node new_node){
		heapArr[index] = new_node;
		//current_size ++;
	}
	public void increase_size(){
		current_size ++;
	}
}
