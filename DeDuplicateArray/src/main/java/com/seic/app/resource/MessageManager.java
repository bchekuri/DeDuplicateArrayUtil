/**
 * 
 * @author BChekuri
 *
 */
package com.seic.app.resource;

import java.util.Locale;
import java.util.ResourceBundle;

import com.seic.constant.MessageKey;

/**
 * 
 * <p>
 * 		The MessageManager includes method for getting message string for given key value.
 * 		Uses Java ResourceBundle class for getting message string.
 * </p>
 *
 */
public class MessageManager {

	/**
	 * <p>
	 * 		ResourceBundle static variable is used for accessing resource property file of default language from class path.
	 * </p>
	 */
	private static ResourceBundle resourceBundle = ResourceBundle.getBundle("DeDuplicateMessages", Locale.getDefault());

	private MessageManager() {
		
	}
	
	/**
	 * <p>
	 * 		Return actual message string from the resource bundle for given input key value.
	 * </p>
	 * 
	 * @param key - string key value of message
	 * @return message - Actual message for given input key from resource bundle
	 */
	public static String getMessage(String key) {
		return resourceBundle.getString(key);
	}
	
	/**
	 * <p>
	 * 		Return actual message string from the resource bundle for given input MessageKey enum constant value.
	 * </p>
	 * 
	 * @param key - MessageKey enum will be used as input key
	 * @return message - Actual message for given input key from resource bundle
	 */
	public static String getMessage(MessageKey key) {
		return getMessage(key.getMessageKeyValue());
	}
	
	
}
