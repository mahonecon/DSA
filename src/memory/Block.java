package memory;

public class Block 
{
	int start;	//initial byte address
	int size;	//in bytes
	
	public Block (int start, int size)
	{
		this.start = start;
		this.size = size;
	}
	
	public String toString() {
		String str = "";
		str += "Start: " + start;
		str += " - Size: ";
		str += size;
		return str;
	}
	
	public boolean equals(Block b) {
		if(b.start == start && b.size == size) {
			return true;
		}
		return false;
	}
	public boolean isNeighbor(Block b) {
		if((b.start + b.size) == start) {
			return true;
		}
		return false;
	}

}
