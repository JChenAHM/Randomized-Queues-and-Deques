import java.util.Iterator;
 
public class Deque<Item> implements Iterable<Item> 
{
	private int size; 
	private Node first; 
    private Node last;  
   
    private class Node 
    {
    	Item item;
    	Node previous;
    	Node next;
    }
    
    /* 
     * construct an empty deque
     */
    public Deque() 
    {
    	first = null;
    	last = null;
    	size = 0;
    }
    
    /*
     * is the deque empty?
     */
    public boolean isEmpty()
    {
    	return size == 0;
    }

    /*
     * return the number of items on the deque
     */
    public int size() 
    {
    	return size;
    }

    /*
     * insert the item at the front
     */
    public void addFirst(Item item) 
    {
    	if(item == null) 
    		throw new java.lang.NullPointerException();
    	
    	Node oldFirst = first;
    	first = new Node();
    	first.item = item;
    	first.next = oldFirst;
    	
    	if(isEmpty()) 
    	{
    		last = first;
    		first.next = null;
    	}
    	else 
    	{
    		oldFirst.previous = first;
    		first.next = oldFirst;
    	}
    	size++;
    }

    /*
     * insert the item at the end
     */
    public void addLast(Item item) 
    {
    	if(item == null) 
    		throw new java.lang.NullPointerException();
    	
    	Node oldLast = last;
    	last = new Node();
    	last.item = item;
    	last.previous = oldLast;
    	
    	if(isEmpty()) 
    	{
    		first = last;
    		last.previous = null;
    	}
    	else 
    	{
    		oldLast.next = last;
    		last.previous = oldLast; 
    	}
    	size++;
    }
    
    /*
     * delete and return the item at the front
     */
    public Item removeFirst() 
    {
    	if(isEmpty()) 
    		throw new java.util.NoSuchElementException();
        
    	Item item = first.item;
        first = first.next;
        size--;
       
        if(isEmpty())
        {
        	last = null;
        	first = null;
        }
        else 
        	first.previous = null;

        return item;
    }

    /*
     * delete and return the item at the end
     */
    public Item removeLast() 
    {
    	if(isEmpty()) 
    		throw new java.util.NoSuchElementException();
    	
    	Item item = last.item;
    	last = last.previous;
    	size--;
    	
    	if(isEmpty()) 
    	{
    		first = null;
    		last = null;
    	}
    	else 
    		last.next = null;
    	
    	return item;
    }
    
    /*
     * print all the Item objects in the Deque using the iterator
     */
    public void printAll()
    {
    	
    }
    
    /*
     * return an iterator over items in order from front to end
     */
    public Iterator<Item> iterator()
    {
    	return new ListIterator();
    }
    
    private class ListIterator implements Iterator<Item>
    {
    	private Node current = first;
    	
    	public boolean hasNext() 
    	{
    		return current != null;
    	}
    	
    	public Item next() 
    	{
    		if(!hasNext()) 
    			throw new java.util.NoSuchElementException();
    		
    		Item item = current.item;
    		current = current.next;
    		return item;
        }
    	
    	public void remove() 
    	{
    		throw new java.lang.UnsupportedOperationException();
    	}    		
    }
    
    public static void main(String[] args)
    {
   
    }
}
