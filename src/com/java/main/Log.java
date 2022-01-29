package com.java.main;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



public class Log{

	
		
	public static void methodEntry(String methodname, Object ... params) {
		PropertyConfigurator.configure(System.getProperty("user.dir")+new User().loadProperties().getProperty("Log_Config_Path"));
		Logger Log = Logger.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
		StringBuilder _logGen = new StringBuilder("Entered " + methodname + "(");
		for (int i = 0; i<params.length; i++) {
			if (i != (params.length - 1))
				_logGen.append(params[i] + ", ");
			else
				_logGen.append(params[i]);
		}
		_logGen.append(")");
		Log.info(_logGen.toString());
	}
	
	public static void methodExit(String methodname) {
		PropertyConfigurator.configure(System.getProperty("user.dir")+new User().loadProperties().getProperty("Log_Config_Path"));
		Logger Log = Logger.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
		Log.info("Exiting " + methodname);
	}

	public static void endTestCase(String sTestCaseName) {
		PropertyConfigurator.configure(System.getProperty("user.dir")+new User().loadProperties().getProperty("Log_Config_Path"));
		Logger Log = Logger.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
		Log.info(" ----------------- "+" Test Case Execution completed for "+sTestCaseName+" -----------------");
	}

	public static void info(String message) {
		PropertyConfigurator.configure(System.getProperty("user.dir")+new User().loadProperties().getProperty("Log_Config_Path"));
		Logger Log = Logger.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
		Log.info(message);
	}
	
	
	public static void info(Object[][] obj) {
		PropertyConfigurator.configure(System.getProperty("user.dir")+new User().loadProperties().getProperty("Log_Config_Path"));
		Logger Log = Logger.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
		Log.info("Database Returns: " + ToStringBuilder.reflectionToString(obj));
	}
	
	public static void info(String methodname, Object[] obj) {
		PropertyConfigurator.configure(System.getProperty("user.dir")+new User().loadProperties().getProperty("Log_Config_Path"));
		Logger Log = Logger.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
		Log.info(methodname + " Returns: " + ToStringBuilder.reflectionToString(obj));
		}
	
	public static void debug(String methodname, Object[][] obj) {
		PropertyConfigurator.configure(System.getProperty("user.dir")+new User().loadProperties().getProperty("Log_Config_Path"));
		Logger Log = Logger.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
		Log.info(methodname + " Returns: " + ToStringBuilder.reflectionToString(obj));
	}


	public static void warn(String message) {
		PropertyConfigurator.configure(System.getProperty("user.dir")+new User().loadProperties().getProperty("Log_Config_Path"));
		Logger Log = Logger.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
		Log.warn(message);
	}
	
	public static void failNode(String message) {
		PropertyConfigurator.configure(System.getProperty("user.dir")+new User().loadProperties().getProperty("Log_Config_Path"));
		Logger Log = Logger.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
		Log.error(message);
		}

	public static void error(String message) {
		PropertyConfigurator.configure(System.getProperty("user.dir")+new User().loadProperties().getProperty("Log_Config_Path"));
		Logger Log = Logger.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
		Log.error(message);
		}

	public static void fatal(String message) {
		PropertyConfigurator.configure(System.getProperty("user.dir")+new User().loadProperties().getProperty("Log_Config_Path"));
		Logger Log = Logger.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
		Log.fatal(message);
		}

	public static void debug(String message) {
		PropertyConfigurator.configure(System.getProperty("user.dir")+new User().loadProperties().getProperty("Log_Config_Path"));
		Logger Log = Logger.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
		Log.info(message);
	}
	
	
    public static void writeStackTrace(Exception e)
    {
    	Logger Log = Logger.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
        StringWriter stack = new StringWriter();
        e.printStackTrace(new PrintWriter(stack));
        Log.info(stack.toString());
     }
    
    public static void skip(String message) {
    	PropertyConfigurator.configure(System.getProperty("user.dir")+new User().loadProperties().getProperty("Log_Config_Path"));
		Logger Log = Logger.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
		Log.info(message);
    }
    
}
