/**
 * 
 * @author BChekuri
 *
 */
package com.seic.exception;

/**
 * 
 * <p>
 * 		This ServiceException class is custom user exception, will be thrown from service class.
 * </p>
 *
 */
public class ServiceException extends Exception {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * <p>
	 * 		constructor for ServiceException class
	 * </p>
	 * 
	 * @param message - user message
	 */
	public ServiceException(String message) {
		super(message);
	}
	
}
