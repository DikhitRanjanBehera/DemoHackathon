package demoLog;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.application.basePackage.BaseClass;

public class LoggerDemo extends BaseClass {

	public static Logger logger = LogManager.getLogger(LoggerDemo.class);
	
	public static void main(String[] args) {
		
		System.out.println("\n  hello \n");
		
		logger.info("this is information message");
		logger.error("this is error message");
		logger.warn("this is warning message");
		logger.fatal("this is fatal message");
		
		System.out.println("\n  Completed \n");
	}

} 
