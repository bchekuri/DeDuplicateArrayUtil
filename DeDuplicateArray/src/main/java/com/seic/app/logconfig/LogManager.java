/**
 * 
 * @author BChekuri
 *
 */
package com.seic.app.logconfig;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;


/**
 * 
 * <p>
 * 		The LogManager class contains methods to log the user messages to console and static block to 
 * 		initiate Log4j configuration without accessing log configuration XML file. All the logs will be 
 * 		logged to console, which is default log4j configuration.
 * </p>
 *
 */
public class LogManager {

	/**
	 * <p>
	 * 		A logger static variable used to log the user info to console
	 * </p>
	 */
	private Logger logger;
	
	/**
	 * <p>
	 * 		Constructor to creating LogManager object
	 * </p>
	 * 
	 * @param logger - log4j logger
	 */
	public LogManager(Logger logger) {
		this.logger =  logger;
	}
	
	/**
	 * <p>
	 * 		Static block to set the Log4j Configurator level to TRACE
	 * </p>
	 */
	static {
		Configurator.setLevel("com.seic", Level.TRACE);
	}
	
	/**
	 * <p>
	 * 		Return Logger for writing user message to console
	 * </P>
	 * 
	 * @param classDetails - class of which logger gets initialized
	 * @return Logger - logger to log the user information to console
	 */
	public static LogManager getLogger(Class classDetails) {
		return new LogManager(org.apache.logging.log4j.LogManager.getLogger(classDetails));
	}

	/**
	 * <p>
	 * 		Get method for logger
	 * </p>
	 * 
	 * @return Logger - log4j logger
	 */
	public Logger getLogger() {
		return logger;
	}

	/**
	 * <p>
	 * 		Set method for logger
	 * </p>
	 * 
	 * @param logger - log4j logger
	 */
	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	
	/**
	 * <p>
	 * 		Log information to console
	 * </p>
	 * 
	 * @param msg - string user message
	 */
	public void info(String msg) {
		this.logger.info(msg);
	}
	
	
	/**
	 * <p>
	 * 		Log error message to console
	 * </p>
	 * 
	 * @param msg - string user message
	 */
	public void error(String msg) {
		this.logger.error(msg);
	}
	
	
	/**
	 * <p>
	 * 		Log trace message to console
	 * </p>
	 * 
	 * @param msg - string user message
	 */
	public void trace(String msg) {
		this.logger.trace(msg);
	}
	
}
