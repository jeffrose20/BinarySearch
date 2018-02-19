package chapterTwo;

/**
 * Recursive and iterative implementations of a binary search array.
 * @author Jeff
 * @since 2018-02-18
 */
public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Test case 1
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		//Both should return -1 (the int is not in the array)
		System.out.println(iterativeBinarySearch(numbers, 11));
		System.out.println(recursiveBinarySearch(numbers, 0, numbers.length-1, 11));
	
		
		//Test case 2
		int[] numbers2 = new int[100];

		for(int i = 0; i < 100; i++) {
			numbers2[i] = i;
		}
		//Both should return 56 (index is the same is the number in the array)
		System.out.println(iterativeBinarySearch(numbers2, 56));
		System.out.println(recursiveBinarySearch(numbers2, 0, numbers2.length-1, 56));		
		
		

	}
	
	/**
	 * Recursive implementation of a binary search.  
	 * Return a -1 if the searchFor number is not found, otherwise return the 
	 * index it was found at	  
	 * 
	 * @param numbers 		array to be searched
	 * @param start			starting index of array
	 * @param end			final index of array
	 * @param searchFor		int to be searched for
	 * @return int			index where the number was found (or -1)
	 */
	
	public static int recursiveBinarySearch(int[] numbers, int start, int end, int searchFor) {
		int midPoint = start + ((end - start) / 2);
		if (numbers[midPoint] == searchFor) 
			return midPoint;
		else if (start >= end) 
			return -1;
		else if (numbers[midPoint] > searchFor) 
			return recursiveBinarySearch(numbers, 0, midPoint - 1, searchFor);			
		 else if (numbers[midPoint] < searchFor) 
			return recursiveBinarySearch(numbers, midPoint + 1, end, searchFor);		  
		return -1;
					
	}
	
	/**
	 * Iterative implementation of a binary search. 
	 * Return a -1 if the searchFor number is not found, otherwise return the 
	 * index it was found at
	 * 
	 * @param numbers			array to be searched
	 * @param searchFor			int to be searched for
	 * @return int				index where the number was found (or -1)
	 */
	public static int iterativeBinarySearch(int[] numbers, int searchFor) {
		int midpoint = (numbers.length-1) / 2;
		int startpoint = 0;
		int endpoint = numbers.length -1;
		
		while (startpoint <= endpoint) {
			
			if (numbers[midpoint] == searchFor)			//Number found 
				return midpoint; 
			else if (numbers[midpoint] > searchFor) {
				startpoint = 0;
				endpoint = midpoint - 1;				
			}
			else 
				startpoint = midpoint + 1;	

			//Point to the new midpoint of the search array (halfway btwn start and end)
			midpoint = startpoint + ((endpoint - startpoint) / 2);
		}
		return -1;
	}

}
