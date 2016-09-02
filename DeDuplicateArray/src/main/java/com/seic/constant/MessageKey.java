/**
 * 
 * @author BChekuri
 *
 */
package com.seic.constant;

/**
 * <p>
 * 		The MessageKey enum contains key value constants for message resource bundle.
 * 		Key value will be mapped to actual message in resource bundle file.
 * </p>
 *
 */
public enum MessageKey {

	NULL_EMPTY_INPUT_EXCEPTION_MSG("invalid.array.input"),
	
	END_VALUE_HIGHER_OR_EQUAL_TO_START_MSG("invalid.end.index"),
	
	START_AND_END_SHOULD_BE_LESSER("invalid.start.end.index");
	
	
	String key;
	
	MessageKey(String messageKey) {
		this.key = messageKey;
	}
	
	/**
	 * <p>
	 * 		Returns equal string value for given enum constant.
	 * 		Same string can be used to find the actual message string from resource bundle
	 * </p>
	 * 
	 * @return string - key string value of given enum constant
	 */
	public String getMessageKeyValue() {
		return this.key;
	}
	
}
