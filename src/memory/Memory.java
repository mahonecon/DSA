package memory;

import list.*;

public class Memory 
{
	List<Block> free = new LinkedList<Block>();
	List<Block> allocated = new LinkedList<Block>();
	static final int MAX = 4096;	//size of all memory
	
	public Memory()
	{
		free.add(new Block(0, MAX));
		//initially all memory is available
	}
	
	public int allocate(int size)
	{
		//find a block of the given size, on the free list
		Block b, newBlock;
		b = null;
		Iterator<Block> it = free.iterator();
		int lastSize = 0;
		while(it.hasNext())
		{
			b = it.next();	//free block
			if(b.size >= size)	//big enough?
			{
				if(lastSize == 0) { //If lastSize has not been initialized.
					lastSize = b.size; //Initialize lastSize.
				}
				if(b.size < lastSize) { //If b.size is smaller than lastSize.
					lastSize = b.size; //Set lastSize to b.size.
				}
			}
		}
		if(lastSize > 0 && b != null) {
			newBlock = new Block(b.start, size);
			allocated.add(newBlock);
			b.start = b.start + size;
			b.size = b.size - size;
			if(b.size == 0)
			{	it.remove();	}
			return newBlock.start;
		}
		return -1;
	}
	
	/**free the block at given start address.
	 * @return true if ok, false if no such block 
	 * allocated */
	public boolean free(int start)
	{
		Block b;
		b = null;
		Iterator<Block> it = allocated.iterator();
		while(it.hasNext())
		{
			b = it.next();
			if(b.start == start)
			{
				free.add(b);
				it.remove();
				coalesce();
				return true;
			}
		}
//		if(b != null && free.size() > 1) {
//			Iterator<Block> itty = free.iterator();
//			Block x;
//			while(itty.hasNext()) {
//				x = itty.next();
//				if(x.isNeigbor(b)) {
//				}
//				if(x.start == (b.size + b.start)) {
//					free.remove(b);
//					free.remove(x);
//					free.add(new Block(b.start, (x.start + x.size)));
//				}
//			}
//		}
		return false;
	}
	
	public void coalesce() { //NOT WORKING AT ALL
		Iterator<Block> it = free.iterator();
		Block x = null;
		Block z = null;
		while(it.hasNext()) {
			x = it.next();
			Iterator<Block> itty = free.iterator();
			while(itty.hasNext()) {
				z = itty.next();
				if(z != null && x != null) {
					if(z.isNeighbor(x)) {
						free.remove(x);
						free.remove(z);
						free.add(new Block(z.start, (x.start + x.size)));
					}
					if(x.isNeighbor(z)) {
						free.remove(z);
						free.remove(x);
						free.add(new Block(x.start, (z.start + z.size)));
					}
				}
			}
		}
	}
	
	public String toString() {
		String str = "";
		str += "Free: " + free.toString();
		str += "\nAllocated: " + allocated.toString();
		return str;
	}
}
