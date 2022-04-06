package ro.ase.csie.cts.g1099.design.patterns.models;

public enum LoggerType {
	ERROR("error.log", "*Error"), INFO("info.log","<Info>");
	
	String filname;
	String messagePattern;
	
	
	private LoggerType(String filname, String messagePattern) {
		this.filname = filname;
		this.messagePattern = messagePattern;
	}


	public String getFilname() {
		return filname;
	}

	public String getMessagePattern() {
		return messagePattern;
	}


	
}
