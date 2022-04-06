package ro.ase.csie.cts.g1099.design.patterns.main;

import java.io.IOException;

import ro.ase.csie.cts.g1099.design.patterns.exceptions.InvalidArgumentException;
import ro.ase.csie.cts.g1099.design.patterns.models.Logger;
import ro.ase.csie.cts.g1099.design.patterns.models.LoggerGenerator;
import ro.ase.csie.cts.g1099.design.patterns.models.LoggerType;

public class Main {

	public static void main(String[] args) throws InvalidArgumentException, IOException {
//		Logger logger = new Logger("info.log", "<Info>");
//		logger.log("Hello");
//		
//		Logger logger = Logger.getLogger("info.log", "<Singleton>");
//		logger.log("Hello again");
		
		Logger infoLogger = (Logger) LoggerGenerator.getLogger(LoggerType.ERROR);
		infoLogger.log("Testing the singleton registry");

	}

}
