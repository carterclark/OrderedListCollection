/**
 * Class that holds multiple TechJobs
 * @author Carter Clark
 */

import java.util.Iterator;

public class TJCollection implements Iterable<TechJob>, DataCollection<TechJob> {
	
	//instance variables
	private TechJob[] data;
	private int manyItems;
	
	/*
	 * Invariant of this TJCollection implementation:
	 * 
	 * 1. The number of items contained in the TJCollection is
	 * stored in an instance variable called manyItems. 
	 * 0 <= manyItems <= maximum capacity of data
	 * 
	 * 2. The TJCollection entries are stored in an instance array
	 * variable called data, from position data[0] to position 
	 * data[manyItems - 1] and sorted in descending alphabetical order
	 */
	
	/**
	 * Constructor
	 * @param capacity, number of items in array
	 */
	TJCollection(int capacity){
		data = new TechJob[capacity];
		this.manyItems = 0;
	}
	
	TJCollection(){
		data = new TechJob[10];
		this.manyItems = 0;
	}
	
	/**
	 * Inserts a new job into the TechJob[] array in 
	 * descending alphabetical order
	 * 
	 * @param newJob, new TechJob to be added
	 * @return 	TRUE if TechJob was added successfully
	 * 			FALSE if TechJob could not be added
	 * @throws Exception errors
	 */
	@Override
	public boolean insert(TechJob newJob) {
		
		//if array is empty
		if(manyItems == 0) {
			data[0] = newJob;
			manyItems++;
			return true;
		}
		
		//taken from sample D2L code---------------
		
		//if the array is full
		if (manyItems == data.length) {
			System.out.println("Error! Array full, did not add: " + newJob.getJob());
			return false;
			
		}
		
		//the array is not full and not empty
		
		int i = 0;
		
		//finding the index for removal
		//if value is less than or equal to zero then break out of loop
		while(i < manyItems && data[i].compareTo(newJob) > 0){
			i++;
		}
		
		
		//i is the index for insertion
		try {
			for(int move = manyItems; move > i; move--) {
				data[move] = data[move -1];
			}
			
			//insert
			data[i] = newJob;
			manyItems++;
		} catch (ArrayIndexOutOfBoundsException e) {
			throw e;
		}  catch (Exception e) {
			System.out.println(e);
			throw e;
		}
		
		return true;
	}

	/**
	 * Counts the size of the TechJob[] array
	 * @return the size
	 */
	@Override
	public int size() {
		return manyItems;
	}
	
	/**
	 * 
	 * @return Returns formatted string containing the contents of the collection
	 */
	@Override
	public String toString() {
		
		String str =  "\nJob" + "\t\t\t\t" + "Percent Growth"
		+ "\t\t" + "Average Salary\n"
		+ "---------------------------------------------------------------------\n";
		
		for(int i=0; i<manyItems; i++) {
			str += data[i].toString();
		}
		
		return str;
	}
	
	/**
	 * takes as input a String value and returns the first 
	 * object with a search key that matches the input search value
	 * 
	 * @param name, String name of TechJob to be found
	 * @return	the object if it is found
	 * 			null if the object is not found
	 */
	@Override
	public TechJob find(String name) {
		int index = findIndex(name);
		
		if(index > -1) {
			return data[index];
		}
		
		else {
			return null;
		}
	}
	
	/**
	 * Searches through an array for a name and returns an integer indicating
	 * the index where it was found
	 * 
	 * @param name, String name of TechJob to be found
	 * @return 	the index of the string if it is found
	 * 			-1 if the name was not found
	 */
	public int findIndex(String name) {
		
		TechJob temp = new TechJob(name);
		
		for(int i=0; i<manyItems; i++) {
			if(data[i].compareTo(temp) == 0) {
				return i;
			}
		}
		return -1;
		
	}
	
	/**
	 * counts the occurrences of a name in the array
	 * 
	 * @param name, name of the TechJob to be counted
	 * @return the number of times the TechJob appears
	 */
	@Override
	public int countOccurrences(String name) {
		TechJob temp = new TechJob(name);
		int count = 0;
		
		for(int i=0; i<manyItems; i++) {
			if(data[i].compareTo(temp) == 0) {
				count++;
			}
		}
		
		return count;
	}
	
	/**
	 * determines whether a TechJob is in the array
	 * 
	 * @param job, TechJob to be searched
	 * @return	TRUE if TechJob was found
	 * 			FALSE if the TechJob was not found
	 */
	@Override
	public boolean contains(TechJob job) {
		
		for(int i=0; i<manyItems; i++) {
			if(data[i].equals(job)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * counts the total number of percent increases for all TechJobs in array
	 * 
	 * @return the integer value
	 */
	@Override
	public int total() {
		int count = 0;
		for(int i=0; i<manyItems; i++) {
			count += data[i].getPercentGrowth();
		}
		
		return count;
	}
	
	/**
	 * counts how many TechJobs in the list have a value that lies in the 
	 * given range including the end points
	 * 
	 * @param low, lower end point
	 * @param high, upper end point
	 * @return, the number of TechJobs in the range
	 */
	@Override
	public int countRange(int low, int high) {
		
		if(low > high) {
			return 0;
		}
		
		int count = 0;
		
		for(int i=0; i < manyItems; i++) {
			if(low <= data[i].getPercentGrowth() && 
					data[i].getPercentGrowth() <= high) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * searches the collection for the first TechJob that equals 
	 * the input TechJob and deletes its occurrence if found
	 * 
	 * @param job, TechJob to be deleted
	 */
	@Override
	public void delete(TechJob job) {
		
		int index = this.findIndex(job.getJob());
		
		try {
			
			for(int shift = index; shift < manyItems - 1; shift++) {
				data[shift] = data[shift + 1];
			}
			manyItems--;
		} catch(ArrayIndexOutOfBoundsException e) {
			throw e;
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}
		
//		if(index == -1) {
//		}
//		
//		else {
//			for(int shift = index; shift < manyItems - 1; shift++) {
//				data[shift] = data[shift + 1];
//			}
//			manyItems--;
//			
//		}
	}

	/**
	 *  iterates through the collection in reverse order
	 */
	@Override
	public Iterator<TechJob> iterator() {
		return new TJReverseIterator();
	}
	
	public class TJReverseIterator implements Iterator<TechJob>{
		private int cursor = manyItems - 1;		// keeps track of the current position

		/**
		 * determines if there is a next object
		 * @return	TRUE if there is a next object
		 * 			FALSE if there is no next object
		 */
		@Override
		public boolean hasNext() {
			// we want to start at the end and move backwards
			if (cursor >= 0)
				return true;
			else
				return false;
		}

		/**
		 * retrieves the next object in the collection
		 * @return the next object of type TechJob
		 */
		@Override
		public TechJob next() {
			TechJob output = data[cursor];
			cursor--;
			return output;
		}
		
	}
	
	
}
