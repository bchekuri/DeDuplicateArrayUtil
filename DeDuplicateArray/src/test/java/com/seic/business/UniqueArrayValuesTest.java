/**
 * 
 * @author BChekuri
 *
 */
package com.seic.business;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * <p>
 * 		This class is test class for the UniqueArrayValues class, Implementation in the 
 * 		UniqueArrayValues is tested in this class using JUnit4. Test Driven Development (TDD) is 
 * 		the key methodology followed to develop this implementations.
 * </p>
 *	
 */
public class UniqueArrayValuesTest {

	private UniqueArrayValues uniqueArrayValues;
	
	/**
	 * <p>
	 * 		Method is for initializing the test method execution requirements. 
	 * 		This method gets called before @Test method.
	 * </p>
	 */
	@Before
	public void setup() {
		uniqueArrayValues = new UniqueArrayValues();
	}
	
	@Test
	public void test_getDistinctValues_withinputnull() {
		try {
			uniqueArrayValues.getDistinctValues(null);
		} catch(IllegalArgumentException illegalArgumentException) {
			assertThat(illegalArgumentException).hasMessage("The input array must be not null");
		}
	}
	
	@Test
	public void test_getDistinctValues_withinputnotnull() {
		int[] duplicateValuedArray = {1, 2, 3, 4, 1, 2, 5, 3};
		assertThat(uniqueArrayValues.getDistinctValues(duplicateValuedArray)).contains(1, 2, 3, 4, 5);
	}
	
	@Test
	public void test_getDistinctValues_withinputnotnullandNoValues() {
		int[] duplicateValuedArray = new int[20];
		assertThat(uniqueArrayValues.getDistinctValues(duplicateValuedArray)).contains(0);
	}
	
	
	@Test
	public void test_getDistinctValues_withinputnotnullandAllSamevalues() {
		int[] duplicateValuedArray = {1, 1, 1, 1, 1, 1, 1, 1};
		assertThat(uniqueArrayValues.getDistinctValues(duplicateValuedArray)).contains(1);
	}
	
	@Test
	public void test_getDistinctValues_withinputnotnullandExtraValues() {
		int[] duplicateValuedArray = {1, 2, 3, 4, 1, 2, 5, 3, 9, 0, 99, 100, 200, 99, 200};
		assertThat(uniqueArrayValues.getDistinctValues(duplicateValuedArray)).contains(0, 1, 2, 3, 4, 5, 9, 99, 100, 200);
	}
	
}
