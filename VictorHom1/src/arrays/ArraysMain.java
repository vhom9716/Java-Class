package arrays;

import java.util.Arrays;

public class ArraysMain {

	private int[] testArray;
	private int[] intRay;
	
	public ArraysMain() {
		int[] consectTest = {7,8,9,10,11,12,13,14,15,16,17,18,19,20,3,8,1,2,3,4,5,6,7,8,9};
		//intRay = new int[10];
		//populate(intRay);
		//checkOccurences(intRay, 3, 18);
		//populate1ToN(intRay);
		//shuffle(intRay);
		//reverseOrder(intRay);
		//frontToBack(intRay);
		//cycleThrough(intRay, 4);
		//Arrays is a utility class included in Java for formating
		//System.out.println(Arrays.toString(intRay));
		
		int[] randomRolls = new int[1000];
		populate(randomRolls);
		//int result[] = longestConsecSeqAndPos(consectTest);
		int result[] = longestConsecSeqAndPos(randomRolls);
		System.out.print("The longest seq was " + result[0] + " at position " + (result[1] + 1) + " starting with a roll of " + randomRolls[result[1]]);
		//System.out.print("The longest consequtive integer chain is " + longestConsecutiveSequence(consectTest));
		
	}
	
	private void shuffle(int[] intRay) {
		for(int i = 0; i < intRay.length; i++) {
			swap(intRay, (int)(Math.random() * intRay.length), (int)(Math.random() * intRay.length));
		}
	}

	private void populate1ToN(int[] intRay) {
		for(int i = 0; i < intRay.length; i++) {
			intRay[i] = i + 1;
		}
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	private void checkOccurences(int[] arr, int start, int end) {
		int[] counter = new int[end-start + 1];
		for(int value: arr) {
			counter[value-start]++; //element at the corresponding index is increased
		}
		for(int i = 0; i < counter.length; i++) {
			System.out.println("A " + (start + i) + " was rolled " + counter[i] + " times.");
		}
	}

	private void populate(int[] intRay) {
		for(int i = 0; i < intRay.length; i++) {
			intRay[i] = diceRoll(1);
		}
		//This does not work
		/**
		for(int value:intRay) {
			value = diceRoll(2);
		}
		**/
	}

	public static void main(String[] args) {
		ArraysMain arrayPractice = new ArraysMain();
	}
	
	//returns sum from rolling numberOfDice dice rolls
	public int diceRoll(int numberOfDice) {
		int result = 0;
		for(int i = 0; i < numberOfDice; i++) {
			result = (int) (result + 1 + Math.random() * 6);
		}
		return result;
	}
	
	public int[] reverseOrder(int[] arr) {
		int[] reversed = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			reversed[i] = arr[arr.length - i - 1];
		}
		return reversed;
	}
	
	public int countLessThan(int[] arr, int n) {
		int count = 0;
		for(int value:arr) {
			if(value < n)
				count++;
		}
		return count;
	}
	
	//removes element at index zero, push every other element up by one
	//put element at index zero at the end of the array
	public void frontToBack(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			swap(arr, i, i+1);
		}
	}
	
	//moves front to the back repeatedly, exactly n times
	public void cycleThrough(int[] arr, int n) {
		for(int i = 0; i < n; i++) {
			frontToBack(arr);
		}
	}
	
	public int[] longestConsecSeqAndPos(int[] arr){
		int[] data = new int[2];
		data[0] = longestConsecutiveSequence(arr);
		data[1] = findIndexOfLongestConseqInt(arr);
		return data;
	}
	
	//returns length of the longest sequence of consecutive integers
	// ex: lCS({1,2,3,7,8,9,10}) returns 4 since 7,8,9,10 is the longest sequence
	public int longestConsecutiveSequence(int[] arr) {
		int count = 1;
		int longest = 0;
		for(int i = 0; i < arr.length - 1; i++) {
			if(checkSequential(arr[i], arr[i + 1])) {
				count++;
			}else {
				if(count > longest) {
					longest = count;
					count = 1;
				}
			}
		}
		if(count > longest) {
			longest = count;
		}
		return longest;
	}
	
	public int findIndexOfLongestConseqInt(int[] arr) {
		int index = 0;
		int longest = 0;
		int count = 0;
		for(int i = 0; i < arr.length - 1; i++) {
			if(checkSequential(arr[i], arr[i + 1])) {
				count++;
			}else {
				if(count > longest) {
					longest = count;
					index = i - count;
					count = 1;
				}
			}
		}
		if(count > longest) {
			longest = count;
			index = arr.length - count;
		}
		return index;
	}
	
	public boolean checkSequential(int x, int y) {
		if(x+1 == y) {
			return true;
		}
		return false;
	}
	
	public void notes() {
		//collection of primitives or objects
				//SPECIAL NOTE: This is the only collection of primitives
				
				//size cannot be modified
				
				//elements of an array are REFERENCES to objects.
				//In other words, changing an element of an array, changes the REFERENCE,
				//NOT the object.
				
				
				
				//There are two types of constructors, the first we've already seen
				//int[] firstType = {3, 4234, 3424};
				//this can only be used at the declaration. Error:
				//firstType = {12, 231, 3123, 13};
				
				//the second type
				testArray = new int[50]; //parameter is the size of the array
				//SPECIAL NOTE: For primitive arrays, when they are instantiated,
				//they are automatically populated with zeros. This is not the case with object arrays
				//object arrays are populated with nulls
				
				//standard for loop
				for(int i = 0; i < testArray.length; i++) {
					System.out.println(testArray[i]);
				}
				
				//for each loop (useful only when you don't need to keep track of the index
				for(int value:testArray) {
					//for each int in testArray
					System.out.println(value);
				}
	}
	
	
}
