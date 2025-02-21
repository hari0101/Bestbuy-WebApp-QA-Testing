package com.utilities.CommonUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerManager {

	//==================================== FIELDS & CONSTRUCTOR ====================================
	
	private static volatile LoggerManager loggerInstance;
	private LoggerManager() { }
	
	//=========================================== METHODS ===========================================
	
	public static LoggerManager getInstance() {
		if(loggerInstance == null) {
			synchronized(LoggerManager.class) {
				if(loggerInstance == null) {
					loggerInstance = new LoggerManager();
				}
			
			}
		}
		
		return loggerInstance;
	}
	
	public Logger getLogger(Class<?> classname) {
		Logger log = null;
		
		if(log == null) {
			log = LogManager.getLogger(classname);
		}
		
		return log;
	}


}
