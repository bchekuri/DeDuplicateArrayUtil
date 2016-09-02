/**
 * 
 * @author BChekuri
 *
 */
package com.seic.app.resource;

import static com.seic.app.resource.MessageManager.getMessage;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.seic.constant.MessageKey;

/**
 * 
 * <p>
 * 		The MessageManagerTest class includes method to test MessageManager behavior.
 * </p>
 *
 */
public class MessageManagerTest {

	@Test
	public void test_getMessage_string_input() {
		assertThat(getMessage("invalid.array.input")).isEqualTo("The input array must be not null");
	}
	
	@Test
	public void test_getMessage_enum_contant_input() {
		assertThat(getMessage(MessageKey.NULL_EMPTY_INPUT_EXCEPTION_MSG)).isEqualTo("The input array must be not null");
	}
	
}
