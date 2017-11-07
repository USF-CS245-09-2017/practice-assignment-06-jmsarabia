
public class PersonalTest {

	public static void main(String[] args)
	{
		BinaryHeap binheap = new BinaryHeap();
		
		binheap.add(10);
		binheap.add(20);
		binheap.add(30);
		binheap.print();
		System.out.println("-------------------------------------------------------");
		binheap.add(25);
		binheap.print();
		System.out.println("-------------------------------------------------------");
		binheap.add(23);
		binheap.print();
		System.out.println("-------------------------------------------------------");
		System.out.println("Removal");
		binheap.remove();
		binheap.print();
		System.out.println("-------------------------------------------------------");
		System.out.println("Removal");
		binheap.remove();
		binheap.print();
		
		
		
	}
}
