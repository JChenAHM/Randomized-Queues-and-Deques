import java.util.Iterator;
 
public class RandomizedQueue<Item> implements Iterable<Item>
{
    private Item[] items;
    private int size = 0;
    
    /*
     * construct an empty randomized queue
     */
	@SuppressWarnings("unchecked")
	public RandomizedQueue() 
    {
        items = (Item[]) new Object[2];
        size = 0;
    }
    
	/*
	 * is the queue empty?
	 */
    public boolean isEmpty() 
    {
        return size == 0;
    }
    
    /*
     * return the number of items on the queue
     */
    public int size() 
    {
        return size;
    }
    
    /*
     * resize the array
     */
    private void resize(int capacity)
    {
        assert capacity >= size;
        
        @SuppressWarnings("unchecked")
        Item[] temp = (Item[]) new Object[capacity];
        for(int i = 0; i < size; i++)
        {
        	temp[i] = items[i];
        }
        items = temp;
    }
    
    /*
     * add the item
     */
    public void enqueue(Item item) 
    {
    	if(item == null) 
    		throw new java.lang.NullPointerException();
    	if(size == items.length)
    		resize(2*items.length);
    	items[size++] = item;
    }
    
    /*
     * delete and return a random item
     */
    public Item dequeue() 
    {
        if(isEmpty()) 
        	throw new java.util.NoSuchElementException();
        int ix = (int) (Math.random() * size);
        Item item = items[ix];
        if(ix != size - 1) 
        	items[ix] = items[size - 1];
        items[size - 1] = null;
        size--;
        if(size > 0 && size == items.length/4) 
        	resize(items.length/2);
        return item;
    }

    /*
     * return (but do not delete) a random item
     */
    public Item sample() 
    {
    	if(isEmpty())
    		throw new java.util.NoSuchElementException();
    	int ix = (int) (Math.random() * size);
    	Item item = items[ix];
    	return item;
    }
    
    /*
     * print all the Item objects in the Deque using the iterator
     */
    public void printAll() 
    {
        Iterator<Item> iter = iterator();
        StringBuilder builder = new StringBuilder();

        while (iter.hasNext()) 
        {
            builder.append(iter.next()).append(' ');
        }
        builder.setLength(builder.length() - 1);

        StdOut.println(builder);
    }
    
    /*
     * return an independent iterator over items in random order
     */
    public Iterator<Item> iterator() 
    {
    	return new itemsIterator();
    }

    private class itemsIterator implements Iterator<Item> 
    {
        private int ix = 0;
        private Item[] rq;
        
        @SuppressWarnings("unchecked")
        public itemsIterator()
        {
            rq = (Item[]) new Object[size];
            for(int i=0; i < size; i++)
            	rq[i] = items[i];
            StdRandom.shuffle(rq);
        }
        
        public boolean hasNext()
        {
        	return ix < size;
        }
        
        public void remove() 
        {
        	throw new java.lang.UnsupportedOperationException();
        }
        
        public Item next() 
        {
        	if(!hasNext()) 
        		throw new java.util.NoSuchElementException();
        	Item item = rq[ix++];
        	return item;
        }
    }
    
    /*
     * unit testing
     */
    public static void main(String[] args) 
    {
        RandomizedQueue<String> queue = new RandomizedQueue<String>();

        while (!StdIn.isEmpty()) 
        {
        	switch (StdIn.readInt()) 
        	{
                case 2:
                	queue.isEmpty();
                    break;
                case 3:
                    queue.size();
                    break;
                case 4:
                    queue.enqueue(StdIn.readString());
                    break;
                case 5:
                    queue.dequeue();
                    break;
                case 6:
                    queue.sample();
                    break;
                default:
                	break;
            }
        }
        
        queue.printAll();
    }
}
