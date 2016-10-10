package queueDriver;

import queue.*;

/**
 * A Printer has a speed, in blocks of printing per step, and a queue of Docs to be printed
 * 
 * @author (sdb) 
 */
public class Printer
{
    private int speed;      // speed of this printer, blocks per step
    private QueueADT<Doc> docs;    // Queue of documents waiting to be printed
    private String id;      // name of this Printer
    private int counter;
    
    /**
     * Constructor for objects of class Printer
     */
    public Printer(int speed, String id) {
        this.speed = speed;
        docs = new Queue <Doc> ();            
        this.id = id;
    }
    /** Add a document to this printer's queue 
      * Display a pertinent message.
    */
    public void add (Doc doc) {    
    	docs.add(doc);
    	System.out.println(doc + "added to " + this);
    }
    
    /** Print several blocks, if necessary, determined by this printer's speed
      * Report when a document is finished printing.
     *  
     */
    public void print() {
    	if(docs.size() > 0) {
        	Doc temp = docs.peek();
    		counter = counter + speed;
        	if(counter >= temp.size()) {
        		System.out.println("Print task completed on " + id + " for: " + temp);
        		docs.remove();
        		counter = 0;
        	}
    	}    	
    }
    
    /** @return the number of documents in this Printer's queue */
    public int size()
    {   return docs.size();  }
    
    public String toString()
    {   return id + ", speed: " + speed + ", docs in queue: " + size();  }
                         
    
}