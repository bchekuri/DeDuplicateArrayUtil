/**
 * 
 * @author BChekuri
 *
 */
package com.seic.business;

import static com.seic.app.resource.MessageManager.getMessage;
import static com.seic.constant.MessageKey.NULL_EMPTY_INPUT_EXCEPTION_MSG;
import static org.apache.commons.lang.ArrayUtils.isEmpty;
import static org.apache.commons.lang.ArrayUtils.toPrimitive;

import java.util.HashSet;
import java.util.Set;

import com.seic.app.logconfig.LogManager;

/**
 * <p>
 *		The UniqueArrayValues includes method related to remove duplicates values in integer array. 
 *		Class implements DeDuplicate interface and uses HashSet to process input array and get distinct 
 *		values.
 * </p>
 * 
 */
public class UniqueArrayValues implements DeDuplicate {

	
	/**
	 * A logger static variable used to log the user info to console
	 */
	public static final LogManager logger = LogManager.getLogger(UniqueArrayValues.class);
	
	/**
	 * <p>
	 * 		Returns unique set of values from the input integer array. Results will be in the order of 
	 * 		how it was stored in hash set. Method uses java collection and suitable for good performance.
	 * </p>
	 * 
	 * <h2>
	 * 		Use case
	 * </h2>
	 * <p>
	 * 		Implementation should return unique set of value from the input array by eliminating duplicate values; 
	 * 		Implementation can return distinct values in any order, should be able to complete the task quicker
	 * 		Extra memory space can be used to make user job faster. Implementation should throw valid user exception to called function
	 * 		in case of invalid input.
	 * </p>
	 * 
	 * @param duplicateValuedArray array - the array to remove the duplicates, may not be null
	 * @return array - the array which contains no duplicate values
	 * @throws IllegalArgumentException if input is <code>null</code>
	 */
	@Override
	public int[] getDistinctValues(int[] duplicateValuedArray) {
		logger.info("Start getDistinctValues method");
		if(isEmpty(duplicateValuedArray)) {
			throw new IllegalArgumentException(getMessage(NULL_EMPTY_INPUT_EXCEPTION_MSG));
		}
		/*
		 * Hash set has been initialize to actual size of input array with load factor 1 to
		 * avoid internal multiple copies happens in java hash algorithm, by saying that customer 
		 * will benefit in performance.
		 */
		Set<Integer> results = new HashSet<Integer>(duplicateValuedArray.length, 1);
		for(int i = 0; i < duplicateValuedArray.length; i++) {
			results.add(Integer.valueOf(duplicateValuedArray[i]));
		}
		logger.info("Exit getDistinctValues method");
		return toPrimitive(results.toArray(new Integer[results.size()]));
	}

}
