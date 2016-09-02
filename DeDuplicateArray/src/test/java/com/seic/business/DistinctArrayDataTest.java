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
 * 		This class is test class for the DistinctArrayData class, Implementation in the 
 * 		DistinctArrayData is tested in this class using JUnit4. Test Driven Development (TDD) is 
 * 		the key methodology followed to develop this implementations.
 * </p>
 *	
 */
public class DistinctArrayDataTest {

	private DistinctArrayData distinctArrayData;
	
	/**
	 * <p>
	 * 		Method is for initializing the test method execution requirements. 
	 * 		This method gets called before @Test method.
	 * </p>
	 */
	@Before
	public void setup() {
		distinctArrayData = new DistinctArrayData();
	}
	
	
	@Test
	public void test_getDistinctValues_withnullinput(){
		try {
			distinctArrayData.getDistinctValues(null);
		} catch(IllegalArgumentException illegalArgumentException) {
			assertThat(illegalArgumentException).hasMessage("The input array must be not null");
		}
	}
	
	@Test
	public void test_getDistinctValues_withinputnotnull() {
		int[] duplicateValuedArray = {1, 2, 3, 4, 1, 2, 5, 3, 200, 1000, 40, 1000};
		assertThat(distinctArrayData.getDistinctValues(duplicateValuedArray)).containsExactly(1, 2, 3, 4, 5, 200, 1000, 40);
	}
	
	@Test
	public void test_getDistinctValues_withinputnotnullAndNoValues() {
		int[] duplicateValuedArray = new int[20];
		assertThat(distinctArrayData.getDistinctValues(duplicateValuedArray)).containsExactly(0);
	}
	
	@Test
	public void test_shiftLeft_withnullinput() {
		try {
			distinctArrayData.shiftLeft(null, 1, 2);
		} catch(IllegalArgumentException illegalArgumentException) {
			assertThat(illegalArgumentException).hasMessage("The input array must be not null");
		}
	}
	
	@Test
	public void test_shiftLeft_withinvalidstartandendindex() {
		try {
			int[] duplicateValuedArray = {1, 2, 3, 4, 1, 2, 5, 3, 9, 0, 99, 100, 200, 99, 200};
			distinctArrayData.shiftLeft(duplicateValuedArray, 2, 1);
		} catch(IllegalArgumentException illegalArgumentException) {
			assertThat(illegalArgumentException).hasMessage("End index must be higher or equal to start index");
		}
	}
	
	@Test
	public void test_shiftLeft_withvalidinput() {
		int[] duplicateValuedArray = {1, 2, 3, 4, 1, 2, 5, 3};
		distinctArrayData.shiftLeft(duplicateValuedArray, 1, 7);
		assertThat(duplicateValuedArray).containsExactly(1, 3, 4, 1, 2, 5, 5, 3);
	}

	
}
