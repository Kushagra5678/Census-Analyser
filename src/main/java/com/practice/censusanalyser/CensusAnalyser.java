package com.practice.censusanalyser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CensusAnalyser {
	public Path csvFilePath;

	// Constructor
	public CensusAnalyser(Path csvFilePath) {
		this.csvFilePath = csvFilePath;
	}

	// Read the number of records in CSV file
	public int readStateCensusCsvRecords() throws CensusAnalyserException {
		Reader reader = null;
		try {
			reader = Files.newBufferedReader(csvFilePath);

			int noOfRecords = 0;
			Iterator<StateCensus> stateCensusIterator = getCSVIterator(reader, StateCensus.class);
			while (stateCensusIterator.hasNext()) {
				noOfRecords++;
				StateCensus csvReader = stateCensusIterator.next();
				System.out.println(csvReader.toString());
			}
			return noOfRecords;
		} catch (IOException E1) {
			throw new CensusAnalyserException("Invalid Path Provided",
					CensusAnalyserException.ExceptionType.INCORRECT_PATH);
		} catch (IllegalStateException E2) {
			throw new CensusAnalyserException("Invalid state found",
					CensusAnalyserException.ExceptionType.INCORRECT_STATE);
		}

	}

	// Read the number of records in the state code file
	public int readStateCodeCsvRecords() throws CensusAnalyserException {
		Reader reader = null;
		try {
			reader = Files.newBufferedReader(csvFilePath);
	
			int noOfRecords = 0;
			Iterator<StateCode> stateCodeIterator = getCSVIterator(reader, StateCode.class);
			while (stateCodeIterator.hasNext()) {
				noOfRecords++;
				StateCode codeReader = stateCodeIterator.next();
				System.out.println(codeReader.toString());
			}
			return noOfRecords;
		} catch (IOException E1) {
			throw new CensusAnalyserException("Invalid Path Provided",
					CensusAnalyserException.ExceptionType.INCORRECT_PATH);
		} catch (IllegalStateException E2) {
			throw new CensusAnalyserException("Invalid state found",
					CensusAnalyserException.ExceptionType.INCORRECT_STATE);
		}

	}

	private <E> Iterator<E> getCSVIterator(Reader reader, Class<E> csvClass) throws CensusAnalyserException {
		try {
			CsvToBeanBuilder<E> builder = new CsvToBeanBuilder<E>(reader);
			CsvToBean<E> csvToBean = builder.withType(csvClass).withIgnoreLeadingWhiteSpace(true).build();
			return csvToBean.iterator();
		} catch (IllegalStateException e) {
			throw new CensusAnalyserException("Invalid state present",
					CensusAnalyserException.ExceptionType.INCORRECT_STATE);
		}

	}
	
}
