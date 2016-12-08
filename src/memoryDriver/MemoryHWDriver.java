package memoryDriver;
import memory.*;

public class MemoryHWDriver 
{
	public static void main(String[] args)
	{
		Memory memory = new Memory();
		memory.allocate(2000);
		memory.allocate(48);
		memory.allocate(48);
		memory.allocate(2000);
		
		memory.free(2000);
		memory.free(2048);
		
		memory.allocate(72);
	}

}
