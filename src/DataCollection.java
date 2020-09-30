
public interface DataCollection<E> {
	
	public boolean insert(E oneThing);
	public int size();
	public String toString();
	public E find(String key);
	public int countOccurrences(String key);
	public boolean contains(E oneThing);
	public int total();
	public int countRange(int low, int high);
	public void delete (E oneThing);
}
