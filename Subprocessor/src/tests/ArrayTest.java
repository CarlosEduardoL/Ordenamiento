package tests;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import model.Array;

public class ArrayTest {
	
	private Array myArray;
	
	void setupEstage1() {
		myArray = new Array();
		
	}
	
	//Test for Integers sorted by Radix algorithm with a regular input
	@Test
	void testRegularIntRadix() {
		
		//Testing RadixSort for small inputs
		setupEstage1();
		myArray.randomWithoutRepetitionOI(1, 100, 90);
		myArray.randomizeOrderI();
		
		int[] inputArray = myArray.getInArrayI();
		//When the input is smaller than 10000, the algorithm choose RadixSort (Method that we're actually testing)
		myArray.chooseIntAlgorithm(myArray.getInArrayI());
		//After choosing the algorithm, outArray changes its state and now is sorted
		int[] outArray = myArray.getOutArrayI();
		
		for (int i = 0; i < inputArray.length; i++) {
			
			if(i+1 < inputArray.length)
			assertTrue(outArray[i] < outArray[i+1]);
		}
		

	}
	
	//Test for Integers sorted by Radix algorithm  with an input wich is in the limit
	@Test
	void testIntRadixInLimit() {
		
		setupEstage1();
		//Testing RadixSort for our limit (10x10^-4)
		myArray.randomWithoutRepetitionOI(2, 800000000, 10000);
		myArray.randomizeOrderI();
		int[] inputArray = myArray.getInArrayI();
		
		inputArray = myArray.getInArrayI();
		//When the input is smaller than 10000, the algorithm choose RadixSort (Method that we're actually testing)
		myArray.chooseIntAlgorithm(inputArray);
		//After choosing the algorithm, outArray changes its state and now is sorted
		int[] outArray = myArray.getOutArrayI();
		
		
		for (int k = 0; k < inputArray.length; k++) {
			
			if(k+1 < inputArray.length)
			assertTrue(outArray[k] < outArray[k+1]);
		}
	}
	
	@Test
	void testRegularIntMerge() {
		
		//Testing RadixSort for small inputs
		setupEstage1();
		myArray.randomWithoutRepetitionOI(1, 1000000000, 900000);
		myArray.randomizeOrderI();
		
		int[] inputArray = myArray.getInArrayI();
		//When the input is bigger than 10000, the algorithm choose MergeSort (Method that we're actually testing)
		myArray.chooseIntAlgorithm(myArray.getInArrayI());
		//After choosing the algorithm, outArray changes its state and now is sorted
		int[] outArray = myArray.getOutArrayI();
		
		for (int i = 0; i < inputArray.length; i++) {
			
			if(i+1 < inputArray.length)
			assertTrue(outArray[i] < outArray[i+1]);
		}
	}
}
