/**
 * 
 * @author BChekuri
 *
 */
package com.seic.service;


import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import com.seic.constant.ImplementationType;
import com.seic.exception.ServiceException;

/**
 * <p>
 * 		The RemoveDuplicatesServiceTest includes methods to test RemoveDuplicatesService class functions
 * 		using JUnit4. followed TDD to build this service.
 * </p>
 *
 */
public class RemoveDuplicatesServiceTest {
    
	public RemoveDuplicatesService removeDuplicatesService;
	
	@Before
	public void setup() {
		removeDuplicatesService = new RemoveDuplicatesService();
	}
	
	@Test
	public void test_getDistinctValues_withnullInput() {
		int[] duplicateValuedArray = null;
		try {
			removeDuplicatesService.getDistinctValues(duplicateValuedArray, 
					ImplementationType.LOW_MEMORY_SPACE_UTIL_IMPLEMENTATION);
		} catch(ServiceException serviceException) {
			assertThat(serviceException).hasMessage("The input array must be not null");
		}
	}
	
	@Test
	public void test_getDistinctValues_withnotnullAndLessMemory() throws ServiceException {
		int[] duplicateValuedArray = {1, 2, 3, 4, 1, 2, 5, 3};
		Assertions.assertThat(removeDuplicatesService.getDistinctValues(duplicateValuedArray, 
				ImplementationType.LOW_MEMORY_SPACE_UTIL_IMPLEMENTATION)).containsExactly(1, 2, 3, 4, 5);
	}
	
	
	@Test
	public void test_getDistinctValues_withnotnullAndQuicker() throws ServiceException {
		int[] duplicateValuedArray = {1, 2, 3, 4, 1, 2, 5, 3};
		Assertions.assertThat(removeDuplicatesService.getDistinctValues(duplicateValuedArray, 
				ImplementationType.HIGH_SPEED_IMPLEMENTATION)).contains(1, 2, 3, 4, 5);
	}
	
	@Test
	public void test_getDistinctValues_withnotnullAndHugeVolume() throws ServiceException {
		int[] duplicateValuedArray = {1, 2, 3, 4, 1, 2, 5, 3};
		Assertions.assertThat(removeDuplicatesService.getDistinctValues(duplicateValuedArray, 
				ImplementationType.HUGE_VOLUME_SPEED_STREAM_IMPLEMENTATION)).containsExactly(1, 2, 3, 4, 5);
	}
	
	@Test
	public void test_getDistinctValues_withnotnullAndnullImplementationType() throws ServiceException {
		int[] duplicateValuedArray = {1, 2, 3, 4, 1, 2, 5, 3};
		Assertions.assertThat(removeDuplicatesService.getDistinctValues(duplicateValuedArray, 
				null)).containsExactly(1, 2, 3, 4, 5);
	}
	
}
