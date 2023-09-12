package edu.sdmesa.cisc191;

/**
 * Lead Author(s):
 * @author 
 * @author 
 * <<add additional lead authors here, with a full first and last name>>
 * 
 * Other contributors:
 * <<add additional contributors (mentors, tutors, friends) here, with contact information>>
 * 
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * <<add more references here>>
 *  
 * Version/date: 
 * 
 * Responsibilities of class:
 * 
 */
/**
 */
public class M2ArrayChallenge
{
	/**
	 * Purpose: Find a given value in the array given
	 * 
	 * @param array to search
	 * @return true if the value is in the array, otherwise false
	 */
	public static boolean contains(int[] array, int value)
	{
		// TODO: return the correct value
		boolean containsValue = false;
		for (int i = 0; i < array.length; i++) 
		{
			if (array[i] == value)
			{
				containsValue = true;
			}
		}
		return containsValue;
	}
	
	// Use this template for the methods
	/**
	 * Purpose: Return the first index value in the array
	 * 
	 * @param array
	 * @return
	 */
	public static int find(int[] array, int value)
	{
		for(int i = 0; i < array.length; i++) 
		{
			if(array[i] == value)
			{
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Purpose: Count Values
	 * 
	 * @param array
	 * @return
	 */
	public static int countValues(int[] array, int value)
	{
		int count = 0;
		for(int i = 0; i < array.length; i++) 
		{
			if(array[i] == value)
			{
				count++;
			}
		}
		return count;
	}

	/**
	 * Purpose: In Order
	 * 
	 * @param array
	 * @return
	 */
//	public static ??? ???(???[] array)
//	{
//		return ???;
//	}
	
	/**
	 * Purpose: Swap
	 * 
	 * @param array
	 * @return
	 */
//	public static ??? ???(???[] array)
//	{
//		return ???;
//	}
	
	/**
	 * Purpose: Bubble Up
	 * 
	 * @param array
	 * @return
	 */
//	public static ??? ???(???[] array)
//	{
//		return ???;
//	}
	
	/**
	 * Purpose: Bubble Sort
	 * 
	 * @param array
	 * @return
	 */
//	public static ??? ???(???[] array)
//	{
//		return ???;
//	}
	
	/**
	 * Purpose: Array Elements Equal
	 * 
	 * @param array
	 * @return
	 */
//	public static ??? ???(???[] array)
//	{
//		return ???;
//	}
	
	/**
	 * Purpose: Backwards
	 * 
	 * @param array
	 * @return
	 */
//	public static ??? ???(???[] array)
//	{
//		return ???;
//	}
	
	/**
	 * Purpose: is Palendrome
	 * 
	 * @param array
	 * @return
	 */
//	public static ??? ???(???[] array)
//	{
//		return ???;
//	}
	
	/**
	 * Purpose: Get Element
	 * 
	 * @param array
	 * @return
	 */
//	public static ??? ???(???[] array)
//	{
//		return ???;
//	}
	
	/**
	 * Purpose: Add Row
	 * 
	 * @param array
	 * @return
	 */
//	public static ??? ???(???[] array)
//	{
//		return ???;
//	}
	
	
	
}
