/**
 * 
 * @author BChekuri
 *
 */
package com.seic.business;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.seic.business.RemoveArrayDuplicates;


/**
 * 
 * <p>
 * 		This class is test class for the RemoveArrayDuplicates class, Implementation in the 
 * 		RemoveArrayDuplicates is tested in this class using JUnit4. Test Driven Development (TDD) is 
 * 		the key methodology followed to develop all these implementations.
 * </p>
 *	
 */
public class RemoveArrayDuplicatesTest {
    
	private RemoveArrayDuplicates  removeArrayDuplicates;
	
	/**
	 * <p>
	 * 		Method is for initializing the test method execution requirements. 
	 * 		This method gets called before @Test method.
	 * </p>
	 */
	@Before
	public void setup() {
		removeArrayDuplicates = new RemoveArrayDuplicates();
	}
	
	@Test
	public void test_getDistinctValues_withinputnull() {
		try {
			removeArrayDuplicates.getDistinctValues(null);
		} catch(IllegalArgumentException illegalArgumentException) {
			assertThat(illegalArgumentException).hasMessage("The input array must be not null");
		}
	}
	
	@Test
	public void test_getDistinctValues_withinputnotnull() {
		int[] duplicateValuedArray = {1, 2, 3, 4, 1, 2, 5, 3};
		assertThat(removeArrayDuplicates.getDistinctValues(duplicateValuedArray)).containsExactly(1, 2, 3, 4, 5);
	}
	
	@Test
	public void test_getDistinctValues_withinputnotnullandExtraValues() {
		int[] duplicateValuedArray = {1, 2, 3, 4, 1, 2, 5, 3, 9, 0};
		assertThat(removeArrayDuplicates.getDistinctValues(duplicateValuedArray)).containsExactly(1, 2, 3, 4, 5, 9, 0);
	}
	
	@Test
	public void test_getDistinctValues_withinputnotnullandNoValues() {
		int[] duplicateValuedArray = new int[20];
		assertThat(removeArrayDuplicates.getDistinctValues(duplicateValuedArray)).containsExactly(0);
	}
	
	
		
}
