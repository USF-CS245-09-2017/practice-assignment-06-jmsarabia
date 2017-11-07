public class BinaryHeap 
{
	private int[] heap;
	private int maxsize;
	private int size;

	/*Following reader's recommendation: position 0 set as most min value
	*		-position 0 set at most min value so not to deal with index out of bound/to have index 1 be start
	*		-position 1 acts as head/root/starting value
	*/
	public BinaryHeap()
	{
		maxsize = 10; //arbitrary initialization
		heap = new int[maxsize];
		size = 0;
		heap[0] = Integer.MIN_VALUE;
	}
	
	private int leftchild(int pos) 
	{
		return 2*pos;
	}
	private int rightchild(int pos) 
	{
		return 2*pos + 1;
	}

	private int parent(int pos) 
	{
		return  (pos) / 2;
	}

	

	private void swap(int first, int second) 
	{
		int tmp;
		tmp = heap[first];
		heap[first] = heap[second];
		heap[second] = tmp;
	}

	public void add(int elem) 
	{
		size++;
		if(size == maxsize)
		{
			growArray(); //size will always grow outside length of array (maxsize), so using grow function
		}		
		heap[size] = elem;
		int current = size;

		while (heap[current] < heap[parent(current)]) 
		{
			swap(current, parent(current));
			current = parent(current);
		}	
	}
	
	private void growArray()
	{
		int[] growth = new int[maxsize*2];  //arbitrary growth rate, could have been plus 2
		maxsize *= 2;
		System.arraycopy(heap, 0, growth, 0, heap.length);
		heap = growth;
	}

	public int remove()
	{
		if(size == 0)
		{
			throw new ArithmeticException ("size is 0, so throwing exception");
		}
		//Swap pos 1 (head) with the last position (size), then re-heap
		swap(1,size);
		size--;
		if (size != 0)
		{
			siftdown(1);
		}
		//size+1 is the old head, so return
		int minNum = heap[size+1];
		heap[size+1] = Integer.MIN_VALUE; 	//psuedo "delete" of this position
		return minNum;
	}

	private void siftdown(int position) 
	{
		while (!isleaf(position)) 
		{
			int smallestchildpos = leftchild(position);
			if ((smallestchildpos < size))
			{
				//If smallest child is bigger than the one above, set smallestchildpos to the next one
				if(heap[smallestchildpos] > heap[smallestchildpos+1])
				{
					smallestchildpos = smallestchildpos + 1;
				}
			}
			//To keep as a heap, break the siftdown before swapping if the value at position is less than the smallestchild
			if (heap[position] <= heap[smallestchildpos])
			{
				return;
			}
			swap(position,smallestchildpos);
			position = smallestchildpos;
		}
	}
	
	private boolean isleaf(int pos) 
	{
		//make sure position is a root (at least halfway up)
		if(pos > size/2)
		{
			//position stays inside array (size)
			if(pos <= size)
			{
				return true;
			}
		}
		return false;
	}

	//For testing purposes
	public void print() 
	{
		for (int i=1; i<=size; i++)
		{
			System.out.println("index: " + i + "\t value: " + heap[i]);
			System.out.println("Parent:"+ parent(i) + ":  lchild:"+ leftchild(i) + ":  rchild:" + rightchild(i)+":");
			System.out.println("++++++++++++++++++++++++++++++++++++++++++");
		}
			
		System.out.println();
	}
}


