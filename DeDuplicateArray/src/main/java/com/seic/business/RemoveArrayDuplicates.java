/**
 * 
 * @author BChekuri
 *
 */
package com.seic.business;

import static com.seic.app.resource.MessageManager.getMessage;
import static com.seic.constant.MessageKey.NULL_EMPTY_INPUT_EXCEPTION_MSG;
import static java.util.Arrays.stream;
import static org.apache.commons.lang.ArrayUtils.isEmpty;

import com.seic.app.logconfig.LogManager;


/**
 * <p>
 *		The RemoveArrayDuplicates includes method related to remove duplicates values in integer array. 
 *		Class implements DeDuplicate interface and uses streams inbuilt method to get distinct values.
 * </p>
 * 
 */
public class RemoveArrayDuplicates implements DeDuplicate {
    
	/**
	 * A logger static variable used to log the user info to console
	 */
	public static final LogManager logger = LogManager.getLogger(RemoveArrayDuplicates.class);
	
	/**
	 * <p>
	 * 		Returns unique set of values from the input primitive integer array which contains duplicate values. 
	 * 		This implementation uses Java stream for resolving issues with other implementation to handle huge volumes.
	 * 		Stream are good for huge volumes. This implementation can be quicker as well for high volumes. Results will 
	 * 		be in the same order of input array list. Also, it takes into consideration #4 of the Team Lead Problem set 
	 * 		of retaining the insertion order.
	 * </p>
	 * 
	 * <h2>
	 * 		Use case
	 * </h2>
	 * <p>
	 * 		Create method to remove the duplicate values in the primitive integer array, implementation should be able 
	 * 		to handle huge volumes and should return the unique value in the same order of input array. 
	 * 		Implementation should validate <code>null</code> inputs and should throw user exception accordingly.
	 * </p>
	 * 
	 * @param duplicateValuedArray array - the array to remove the duplicates, may not be null
	 * @return array - the array which contains no duplicate values
	 * @throws IllegalArgumentException if input is <code>null</code>
	 */
	@Override
	public int[] getDistinctValues(int[] duplicateValuedArray) {
		logger.info("Enter getDistinctValues method");
		if(isEmpty(duplicateValuedArray)) {
			throw new IllegalArgumentException(getMessage(NULL_EMPTY_INPUT_EXCEPTION_MSG));
		}
		logger.info("Exit getDistinctValues method");
		return stream(duplicateValuedArray).distinct().toArray();
	}	
}
