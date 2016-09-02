/**
 * 
 * @author BChekuri
 *
 */
package com.seic.business;

import static com.seic.app.resource.MessageManager.getMessage;
import static com.seic.constant.MessageKey.END_VALUE_HIGHER_OR_EQUAL_TO_START_MSG;
import static com.seic.constant.MessageKey.NULL_EMPTY_INPUT_EXCEPTION_MSG;
import static com.seic.constant.MessageKey.START_AND_END_SHOULD_BE_LESSER;
import static org.apache.commons.lang.ArrayUtils.isEmpty;

import com.seic.app.logconfig.LogManager;

/**
 * <p>
 *		The DistinctArrayData includes method related to remove duplicate values in primitive integer array.
 *		This class implements DeDuplicate interface. Implementation uses primitive array data structures to remove duplicates.
 * </p>
 * 
 */
public class DistinctArrayData implements DeDuplicate {

	/**
	 * A logger static variable used to log the user info to console
	 */
	public static final LogManager logger = LogManager.getLogger(DistinctArrayData.class);
	
	
	/**
	 * <p>
	 * 		Returns unique set of values from the input integer array in the same order of input
	 * 		If this method input array has duplicates values, results of this method contains unique values.
	 *      Result array contains the unique values in the same order of input array. 
	 *      Result array will be same as input array if this method input array has no duplicate values.
	 *      Also, it takes into consideration #4 of the Team Lead Problem set of retaining the insertion order
	 * </p>
	 * 
	 * <h2>
	 * 		Use case
	 * </h2>
	 * <p>
	 * 		Method should return unique set of value from the input array by eliminating duplicate values. 
	 * 		Method should return distinct values in the same order of input array. 
	 * 		Implementation should be able to complete the operation with very low memory environment constrains.
	 * 		Algorithm should not take extra bit of space other than result array memory allocation.
	 * 		Should throw valid exception for invalid inputs. Implementation should throw valid user exception to 
	 * 		called function in case of invalid input.
	 * </p>
	 * 
	 * @param duplicateValuedArray - array input
	 * @return array - the array which contains no duplicate values
	 * @throws IllegalArgumentException if input is <code>null</code>
	 */
	@Override
	public int[] getDistinctValues(int[] duplicateValuedArray) {
		logger.info("Enter removeDuplicates method");
		if(isEmpty(duplicateValuedArray)) {
			logger.error("Input array is null or empty");
			throw new IllegalArgumentException(getMessage(NULL_EMPTY_INPUT_EXCEPTION_MSG));
		}
		int endIndex = duplicateValuedArray.length;
	    for (int i = 0; i < endIndex; i++) {
	        for (int j = i + 1; j < endIndex; j++) {
	            if (duplicateValuedArray[i] == duplicateValuedArray[j]) {                  
	                shiftLeft(duplicateValuedArray, j, endIndex);
	                endIndex--;
	                j--;
	            }
	        }
	    }
	    int[] results = new int[endIndex];
	    for(int i = 0; i < endIndex; i++){
	    	results[i] = duplicateValuedArray[i];
	    }
	    logger.info("Exit removeDuplicates method");
	    return results;
	}
	
	
	/**
	 * <p>
	 * 		Shift the integer array value index to left. index of integer array will be shifted to left from given start index to end index.
	 * </p>
	 * 
	 * @param array - the array needs shift left
	 * @param startIndex - the integer value to start index
	 * @param endIndex - the integer value to end index
	 * @throws IllegalArgumentException if null array input or start index grater than end index 
	 *         or start index lesser than 1 
	 * 		   or start index grater than length of array or end index lesser than length of array
	 */
	public void shiftLeft(int[] array, int startIndex, int endIndex) {
		logger.info("Enter shiftLeft method");
		if(isEmpty(array)) {
			logger.info("Input array is empty or null");
			throw new IllegalArgumentException(getMessage(NULL_EMPTY_INPUT_EXCEPTION_MSG));
		}
		if(startIndex > endIndex) {
			throw new IllegalArgumentException(getMessage(END_VALUE_HIGHER_OR_EQUAL_TO_START_MSG));
		}
		if(startIndex > array.length || endIndex > array.length) {
			throw new IllegalArgumentException(getMessage(START_AND_END_SHOULD_BE_LESSER));
		}
		int shiftLeft = startIndex;
		for(int k = startIndex+1; k < endIndex; k++, shiftLeft++) {
			array[shiftLeft] = array[k];
		}
		logger.info("Exit shiftLeft method");
	}

}
