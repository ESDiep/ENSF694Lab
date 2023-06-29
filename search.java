
/* Author : Eric Sieu Diep
 * ENSF694 Lab2
 * 
 * 
 * 
 */
package lab2;

import java.util.Scanner;
import java.util.Arrays;

public class search {

	//raw linear search
	public static int linearSearch(int[] inputList, int searchKey) {
		
		int indexFound = -1;
		for(int i = 0; i< inputList.length; i++) {
			
			if(searchKey == inputList[i])｛
				indexFound = i;
				break;
			｝
		}
		
		return indexFound;
	}
	
	//sort the input array before linear search
	public static int sortedLinear(int[] inputList, int searchKey) {
		int indexFound = -1;
		Arrays.sort(inputList);
		
		for(int i = 0; i< inputList.length; i++) {
			
			if(searchKey == inputList[i]){
				indexFound = i;
				break;
			}
		}
		
		return indexFound;
	}
	
	//sorted the array and split the array into half
	public static int fastLinear(int[] inputList, int searchKey) {
		
		int indexFound = -1;
		Arrays.sort(inputList);
		int mid = inputList.length/2;
		
		// searchKey out of bound checking
		if(searchKey > inputList[inputList.length -1] || searchKey < inputList[0] ) {
			return indexFound;
		}
		else {
		
			if (searchKey < inputList[mid]) {
				for(int i = 0; i<= mid; i++) {
					
					if(searchKey == inputList[i])
						indexFound = i;
				}
			}
			else {
				for(int i = mid; i< inputList.length; i++) {
					
					if(searchKey == inputList[i])
						indexFound = i;
				}
		
			}
		}
		
		return indexFound;
	}
	
	//intepolarSearch using the position formula in the lecture
	public static int intepolarSearch(int[] inputList, int searchKey) {
		int indexFound = -1;
		
		int mid, pos ;
		int high = inputList.length -1;
		int low = 0;
		
		Arrays.sort(inputList);
				
		while(low <= high) {
					
			pos = (searchKey - inputList[0]) / (inputList[high] - inputList[low]);
			mid = low + ((high - low) * pos);
										
			if(searchKey == inputList[mid]) {
				indexFound = mid;
				return indexFound;			
			}
			else if(searchKey < inputList[mid]) {
				high = mid -1;
			}
			else {
				low = mid + 1;
			}
					
		}		
		return indexFound;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner reader = new Scanner(System.in);
		int inputSize = 0;
		int searchKey = 0;
		int indexFound = -1;
		
		
		System.out.println("Please enter the number of inputs");
		inputSize = Integer.parseInt(reader.nextLine());
		
		System.out.println("Your input is " + inputSize);
		
		int[] inputList = new int[inputSize];
		
		System.out.println("Please enter a number ");
		
		//prompting user input to fill up the array
		for(int i = 0; i < inputSize; i++) {
			inputList[i] = Integer.parseInt(reader.nextLine());
			
		}
		
		System.out.println("Please enter a search key ");		
		searchKey = Integer.parseInt(reader.nextLine());
		
		long start1 = System.nanoTime();
		//raw linear search
		indexFound = linearSearch(inputList, searchKey);		
		long end1 = System.nanoTime();		
		long t1 = end1-start1;
		
		System.out.println("***Search Result of Unsorted Array***");
		
		if(indexFound == -1) {
			System.out.println("The search key was not found.");
		}
		else {
			System.out.println("The search key was found in index " + indexFound);
		}
		
		//Interpolar search
		long start2 = System.nanoTime();
		indexFound = intepolarSearch(inputList,searchKey);		
		long end2 = System.nanoTime();
		long t2 = end2-start2;
		
			
		long start3 = System.nanoTime();
		indexFound = sortedLinear(inputList, searchKey);
		long end3 = System.nanoTime();
		long t3 = end3 - start3;
		
		long start4 = System.nanoTime();
		indexFound = fastLinear(inputList, searchKey);		
		long end4 = System.nanoTime();		
		long t4 = end4-start4;
		
		
		System.out.println("   ");
		System.out.println("***Search Result of Sorted Array***");
		
		if(indexFound == -1) {
			System.out.println("The search key was not found.");
		}
		else {
			System.out.println("The search key was found in index " + indexFound);
		}
		
		System.out.println("");
		System.out.println("*** Runtime Analysis ***");
		
		System.out.println("Runtime of linear search with unsorted array is " + t1 + "nano seconds");
		
		System.out.println("Run time of intepolar search is " +t2 + "nano seconds");
		
		System.out.println("Runtime of linear search with sorted array is " + t3 + "nano seconds");
		System.out.println("Runtime of fast linear search is " + t4 + "nano seconds");
		
		
		
	}

}
