package com.practice.censusanalyser;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest {
	private static final String INDIA_CSV_FILE_PATH = "E:\\Capg_training\\eclipse_work\\IndiaCensusAnalyser\\IndiaStateCensus.csv";
	private static final String WRONG_CSV_FILE_PATH = "E:\\Capg_training\\eclipse_work\\IndiaStateCensus.csv";
	private static final String WRONG_CSV_FILE_TYPE = "E:\\Capg_training\\eclipse_work\\IndiaCensusAnalyser\\IndiaStateCensus.txt";
	private static final String WRONG_DELIMITER_FILE_PATH = "E:\\Capg_training\\eclipse_work\\IndiaCensusAnalyser\\WrongDelimiterCensus.csv";
	private static final String WRONG_HEADER_FILE_PATH = "E:\\Capg_training\\eclipse_work\\IndiaCensusAnalyser\\WrongHeaderCensus.csv";
	
	private static final String STATECODE_CSV_FILE_PATH = "E:\\Capg_training\\eclipse_work\\IndiaCensusAnalyser\\IndiaStateCode.csv";
	private static final String WRONG_STATECODE_PATH = "E:\\Capg_training\\eclipse_work\\IndiaStateCode.csv";
	private static final String WRONG_STATECODE_TYPE = "E:\\Capg_training\\eclipse_work\\IndiaCensusAnalyser\\IndiaStateCode.txt";
	private static final String WRONG_DELIMITER_STATECODE_PATH = "E:\\Capg_training\\eclipse_work\\IndiaCensusAnalyser\\WrongDelimiterCode.csv";
	private static final String WRONG_HEADER_STATECODE_PATH = "E:\\Capg_training\\eclipse_work\\IndiaCensusAnalyser\\WrongHeaderCode.csv";

	// Happy test case to find the number of records
	@Test
	public void givenIndianCensusFile_FindNumberOfRecords() throws CensusAnalyserException {
		Path pathname = Paths.get(INDIA_CSV_FILE_PATH);
		CensusAnalyser censusAnalyzer = new CensusAnalyser(pathname);
		int noOfRecords = censusAnalyzer.readStateCensusCsvRecords();
		Assert.assertEquals(29, noOfRecords);
	}

	// TC 1.1
	@Test
	public void givenIndianCensusFile_FindNumberOfRecords_WrongTC() throws CensusAnalyserException {
		Path pathname = Paths.get(INDIA_CSV_FILE_PATH);
		CensusAnalyser censusAnalyzer = new CensusAnalyser(pathname);
		int noOfRecords = censusAnalyzer.readStateCensusCsvRecords();
		Assert.assertTrue(20 != noOfRecords);
	}

	// Sad test case tc 1.2
	@Test
	public void givenIndianCensusFile_WrongFilePath() throws CensusAnalyserException {
		try {
			Path pathname = Paths.get(WRONG_CSV_FILE_PATH);
			ExpectedException exceptionRule=ExpectedException.none();
	        exceptionRule.expect(CensusAnalyserException.class);
			CensusAnalyser censusAnalyzer = new CensusAnalyser(pathname);
			censusAnalyzer.readStateCensusCsvRecords();
		}
		catch(CensusAnalyserException e)
		{
			Assert.assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_PATH, e.type);
		}
	}
	
	// sad test tc 1.3
	@Test
	public void givenIndianCensusFile_WrongFileType() throws CensusAnalyserException{
		try {
			Path pathname = Paths.get(WRONG_CSV_FILE_TYPE);
			ExpectedException exceptionRule=ExpectedException.none();
	        exceptionRule.expect(CensusAnalyserException.class);
			CensusAnalyser censusAnalyzer = new CensusAnalyser(pathname);
			censusAnalyzer.readStateCensusCsvRecords();
		}
		catch(CensusAnalyserException e)
		{
			Assert.assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_STATE, e.type);
		}
	}
	
	// SAD TESTCASE TC 1.4
//	@Test
//	public void givenIndianCensusFile_WrongDelimiterFile() throws CensusAnalyserException{
//		try {
//			Path pathname = Paths.get(WRONG_DELIMITER_FILE_PATH);
//			ExpectedException exceptionRule=ExpectedException.none();
//	        exceptionRule.expect(CensusAnalyserException.class);
//			CensusAnalyser censusAnalyzer = new CensusAnalyser(pathname);
//			censusAnalyzer.readStateCensusCsvRecords();
//		}
//		catch(CensusAnalyserException e)
//		{
//			Assert.assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_DELIMITER, e.type);
//		}
//	}
	
	//SAD TESTCASE TC 1.5
	@Test
	public void givenIndianCensusFile_WrongHeader() throws CensusAnalyserException{
		try {
			Path pathname = Paths.get(WRONG_HEADER_FILE_PATH);
			ExpectedException exceptionRule=ExpectedException.none();
	        exceptionRule.expect(CensusAnalyserException.class);
	        CensusAnalyser censusAnalyzer = new CensusAnalyser(pathname);
			censusAnalyzer.readStateCensusCsvRecords();
		}
		catch(CensusAnalyserException e)
		{
			Assert.assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_CSV_HEADER, e.type);
		}
	}
	//TC 2 happy test case
	@Test
	public void givenStateCodeFile_FindNumberOfRecords()throws CensusAnalyserException {
		Path pathname = Paths.get(STATECODE_CSV_FILE_PATH);
		CensusAnalyser censusAnalyzer = new CensusAnalyser(pathname);
		int noOfRecords = censusAnalyzer.readStateCensusCsvRecords();
		Assert.assertEquals(37, noOfRecords);
	}
	
	// TC 2.1
	@Test
	public void givenStateCodeFile_FindNumberOfRecords_WrongTC() throws CensusAnalyserException {
		Path pathname = Paths.get(STATECODE_CSV_FILE_PATH);
		CensusAnalyser censusAnalyzer = new CensusAnalyser(pathname);
		int noOfRecords = censusAnalyzer.readStateCensusCsvRecords();
		Assert.assertTrue(20 != noOfRecords);
	}
	
	// Sad test case tc 2.2
	@Test
	public void givenStateCodeFile_WrongFilePath() throws CensusAnalyserException {
		try {
			Path pathname = Paths.get(WRONG_STATECODE_PATH);
			ExpectedException exceptionRule=ExpectedException.none();
	        exceptionRule.expect(CensusAnalyserException.class);
			CensusAnalyser censusAnalyzer = new CensusAnalyser(pathname);
			censusAnalyzer.readStateCensusCsvRecords();
		}
		catch(CensusAnalyserException e)
		{
			Assert.assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_PATH, e.type);
		}
	}
		
	// sad test tc 2.3
	@Test
	public void givenStateCodeFile_WrongFileType() throws CensusAnalyserException{
		try {
			Path pathname = Paths.get(WRONG_STATECODE_TYPE);
			ExpectedException exceptionRule=ExpectedException.none();
	        exceptionRule.expect(CensusAnalyserException.class);
			CensusAnalyser censusAnalyzer = new CensusAnalyser(pathname);
			censusAnalyzer.readStateCensusCsvRecords();
		}
		catch(CensusAnalyserException e)
		{
			Assert.assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_STATE, e.type);
		}
	}
	
	// SAD TESTCASE TC 2.4
//	@Test
//	public void givenStateCodeFile_WrongDelimiterFile() throws CensusAnalyserException{
//		try {
//			Path pathname = Paths.get(WRONG_DELIMITER_STATECODE_PATH);
//			ExpectedException exceptionRule=ExpectedException.none();
//	        exceptionRule.expect(CensusAnalyserException.class);
//			CensusAnalyser censusAnalyzer = new CensusAnalyser(pathname);
//			censusAnalyzer.readStateCensusCsvRecords();
//		}
//		catch(CensusAnalyserException e)
//		{
//			Assert.assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_DELIMITER, e.type);
//		}
//	}
	
	//SAD TESTCASE TC 2.5
	@Test
	public void givenStateCodeFile_WrongHeader() throws CensusAnalyserException{
		try {
			Path pathname = Paths.get(WRONG_HEADER_STATECODE_PATH);
			ExpectedException exceptionRule=ExpectedException.none();
	        exceptionRule.expect(CensusAnalyserException.class);
			CensusAnalyser censusAnalyzer = new CensusAnalyser(pathname);
			censusAnalyzer.readStateCensusCsvRecords();
		}
		catch(CensusAnalyserException e)
		{
			Assert.assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_CSV_HEADER, e.type);
		}
	}
}
