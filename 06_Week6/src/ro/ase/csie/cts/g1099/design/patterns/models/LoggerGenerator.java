package ro.ase.csie.cts.g1099.design.patterns.models;

import java.util.HashMap;

import ro.ase.csie.cts.g1099.design.patterns.exceptions.InvalidArgumentException;
import ro.ase.csie.cts.g1099.design.patterns.interfaces.ILogging;

public class LoggerGenerator {
	
	private static HashMap<LoggerType, ILogging> loggers = new HashMap<>();
	
	public static ILogging getLogger(LoggerType type) {
		
		ILogging logger = loggers.get(type);
		
		if(logger == null) {
			try {
			logger = Logger.getLogger(type.getFilename(), type.getMessagePattern());
			loggers.put(type, logger);
			} catch (InvalidArgumentException) {
				
			}
		}
	}
}
