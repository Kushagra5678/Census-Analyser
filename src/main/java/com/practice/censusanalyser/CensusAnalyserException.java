package com.practice.censusanalyser;

public class CensusAnalyserException extends Exception{
	enum ExceptionType{
		INCORRECT_PATH, 
		INCORRECT_STATE, 
		INCORRECT_DELIMITER, 
		INCORRECT_CSV_HEADER;
	}
	
	ExceptionType type;
	
	public CensusAnalyserException(String msg, ExceptionType type) {
		super(msg);
		this.type = type;
	}
}
