package Chapter08;

import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LinearSearch
{
	private static final Logger logger = Logger.getLogger(LinearSearch.class.getName());

	public static void main(String[] args) throws InterruptedException
	{
		logger.log(Level.INFO, "Iterative linear search on arrays.");
		Thread.sleep(005);
		LinearSearch runtime = new LinearSearch();

		int[] a = runtime.createArray(100, 100);
		System.out.println(Arrays.toString(a));

		Random prn = new Random();
		int searchValue = prn.nextInt(100);

		System.out.printf("%s %s\n", "linearSearchBoolean searched for " + searchValue + " and returned", runtime.iterativeLinearSearchBoolean(a, searchValue));
		System.out.printf("%s %s\n", "linearSearchIndex searched for " + searchValue + " and returned", runtime.iterativeLinearSearchIndex(a, searchValue));
		System.out.printf("%s %s\n", "linearSearchValue searched for " + searchValue + " and returned", runtime.iterativeLinearSearchValue(a, searchValue));

		logger.log(Level.INFO, "Recursive linear search on arrays.");
		Thread.sleep(005);
		System.out.printf("%s %s\n", "recursiveLinearSearchBoolean searched for " + searchValue + " and returned", runtime.recursiveLinearSearchBoolean(a, searchValue, 0));
		System.out.printf("%s %s\n", "recursiveLinearSearchIndex searched for " + searchValue + " and returned", runtime.recursiveLinearSearchIndex(a, searchValue, 0));
		System.out.printf("%s %s\n", "recursiveLinearSearchValue searched for " + searchValue + " and returned", runtime.recursiveLinearSearchValue(a, searchValue, 0));
	}

	public int[] createArray(int size, int prnLimit)
	{
		Random prn = new Random();
		int[] a = new int[size];

		for (int i = 0; i < size; i++) {
			a[i] = prn.nextInt(prnLimit);
		}
		return a;
	}

	public boolean iterativeLinearSearchBoolean(int[] inputArray, int searchValue)
	{
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] == searchValue) {
				return true;
			}
		}
		return false;
	}

	public int iterativeLinearSearchIndex(int[] inputArray, int searchValue)
	{
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] == searchValue) {
				return i;
			}
		}
		return -1;
	}

	public Integer iterativeLinearSearchValue(int[] inputArray, int searchValue)
	{
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] == searchValue) {
				return inputArray[i];
			}
		}
		return null;
	}

	public boolean recursiveLinearSearchBoolean(int[] inputArray, int searchValue, int searchIndex) {
		boolean result = false;
		if(searchIndex < inputArray.length) {
			if (inputArray[searchIndex] == searchValue) {
				return true;
			}
			else {
				result = recursiveLinearSearchBoolean(inputArray, searchValue, searchIndex + 1);
			}
		}
		return result;
	}

	public int recursiveLinearSearchIndex(int[] inputArray, int searchValue, int searchIndex) {
		int index = -1;
		if(searchIndex < inputArray.length) {
			if (inputArray[searchIndex] == searchValue) {
				return searchIndex;
			}
			else {
				index = recursiveLinearSearchIndex(inputArray, searchValue, searchIndex + 1);
			}
		}
		return index;
	}

	public Integer recursiveLinearSearchValue(int[] inputArray, int searchValue, int searchIndex) {
		Integer value = null;
		if(searchIndex < inputArray.length) {
			if (inputArray[searchIndex] == searchValue) {
				return inputArray[searchIndex];
			}
			else {
				value = recursiveLinearSearchValue(inputArray, searchValue, searchIndex + 1);
			}
		}
		return value;
	}
}
