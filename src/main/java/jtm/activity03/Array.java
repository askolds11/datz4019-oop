package jtm.activity03;

import java.util.Arrays;

public class Array {
	static int[] array;

	public static void main(String[] args) {
		// Use passed parameters for main method to initialize array
		// Hint: use Run— Run configurations... Arguments to pass parameters to
		// main method when calling from Eclipse
		// Sort elements in this array in ascending order
		// Hint: use Integer.parseInt(args[n]) to convert passed
		// parameters from String to int
		// Hint: use Arrays.sort(...) from
		// https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html
		array = new int[args.length];
		for (int i = 0; i < args.length; i++) {
			array[i] = Integer.parseInt(args[i]);
		}
	}

	public static void printSortedArray() {
		// print content of array on standard output
		// Hint: use Arrays.toString(array) method for this
		System.out.println(Arrays.toString(Array.array));
	}

	public static int[] returnSortedArray() {
		// return reference to this array
		Arrays.sort(Array.array);
		return Array.array;
	}

}
