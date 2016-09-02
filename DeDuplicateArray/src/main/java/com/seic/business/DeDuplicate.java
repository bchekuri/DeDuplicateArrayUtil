/**
 * 
 * @author BChekuri
 *
 */
package com.seic.business;


/**
 * 
 * <p>
 * 		The root interface for all implementations to remove duplicate values from integer array.
 * 		business implementations uses this interface as specification.
 * </p>
 *
 */
@FunctionalInterface
public interface DeDuplicate {

	
	/**
	 * <p>
	 * 		Returns distinct values of input integer array.
	 * <p>
	 * 
	 * 
	 * @param duplicateValuedArray - input array which contains duplicate values
	 * @return array - distinct values of input array
	 */
	public int[] getDistinctValues(int[] duplicateValuedArray);
	
}
