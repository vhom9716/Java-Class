package arrays;

import java.util.Arrays;

public class ArraysMain {

	private int[] testArray;
	private int[] intRay;
	
	public ArraysMain() {
		intRay = new int[100];
		//populate(intRay);
		//checkOccurences(intRay, 3, 18);
		populate1ToN(intRay);
		shuffle(intRay);

		//Arrays is a utility class included in Java for formating
		System.out.println(Arrays.toString(intRay));

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
			intRay[i] = diceRoll(3);
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
