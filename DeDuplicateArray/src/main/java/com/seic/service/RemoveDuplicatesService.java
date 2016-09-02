/**
 * 
 * @author BChekuri
 *
 */
package com.seic.service;




import com.seic.app.logconfig.LogManager;
import com.seic.business.DeDuplicate;
import com.seic.business.DistinctArrayData;
import com.seic.business.RemoveArrayDuplicates;
import com.seic.business.UniqueArrayValues;
import com.seic.constant.ImplementationType;
import com.seic.exception.ServiceException;

/**
 * 
 * <p>
 * 		The RemoveDuplicatesService includes service method to remove duplicates from the input array.
 * 		End user can just use this service class to call different types of implementations based on the 
 * 		environment, performance and volume.
 * </p>
 *
 */
public class RemoveDuplicatesService  {
    
	/**
	 * A logger static variable used to log the user info to console
	 */
	public static final LogManager logger = LogManager.getLogger(RemoveDuplicatesService.class);
	
	
	/**
	 * <p>
	 * 		Returns unique set of values from duplicate array by calling business implementations
	 * 		based on implementation type input given by end user. If user provides invalid implementation 
	 * 		type system will call best implementation to process input array.
	 * <p>
	 * 
	 * 
	 * @param duplicateValuedArray - input array which contains duplicate values
	 * @param type - type of implementation needs to be called
	 * @return array - distinct values of input array
	 * @throws ServiceException - throws service exception
	 */
	public int[] getDistinctValues(int[] duplicateValuedArray, ImplementationType type) throws ServiceException {
		logger.info("Enter getDistinctValues service method");
		DeDuplicate deDuplicate;
		try {
			if(type == null) {
				deDuplicate = new UniqueArrayValues();
				return deDuplicate.getDistinctValues(duplicateValuedArray);
			}
			switch (type) {
			case LOW_MEMORY_SPACE_UTIL_IMPLEMENTATION:
				deDuplicate = new DistinctArrayData();
				break;
			case HIGH_SPEED_IMPLEMENTATION:
				deDuplicate = new UniqueArrayValues();
				break;
			case HUGE_VOLUME_SPEED_STREAM_IMPLEMENTATION:
				deDuplicate = new RemoveArrayDuplicates();
				break;
			default:
				logger.info("Processing in default mode");
				deDuplicate = new UniqueArrayValues();
				break;
			}
			logger.info("Exit getDistinctValues service method");
			return deDuplicate.getDistinctValues(duplicateValuedArray);
		} catch(IllegalArgumentException e) {
			logger.error("Error message" + e.getMessage());
			throw new ServiceException(e.getMessage());
		}
	}
	
	
}
