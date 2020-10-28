package com.practice.censusanalyser;

import com.opencsv.bean.CsvBindByName;

public class StateCode {
	@CsvBindByName(column = "State Name")
	public String stateName;
	
	@CsvBindByName(column = "StateCode")
	public String stateCode;
	
	public StateCode(String stateName, String stateCode) {
		this.stateName = stateName;
		this.stateCode = stateCode;
	}
	@Override
    public String toString() {
        return "CSVStateCode{" +
                ", stateName='" + stateName + '\'' +
                ", stateCode='" + stateCode + '\'' +
                '}';
    }
}
