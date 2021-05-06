package com.java.first.course;

import edu.duke.FileResource;
import org.apache.commons.csv.*;


public class ParsingExportData {

	 public String countryInfo(CSVParser parser, String country) {
	        for (CSVRecord record : parser) {
	            String currentCountry = record.get("Country");
	            
	            if (currentCountry.equalsIgnoreCase(country)) {
	                String exports = record.get("Exports");
	                String value = record.get("Value (dollars)");
	                
	                String result = currentCountry + " : " + exports + ": " + value;
	                return result;
	            }
	        }
	        
	        return "NOT FOUND";
	    }
	    
	    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
	         for (CSVRecord record : parser) {
	            String exports = record.get("Exports");
	            
	            if (exports.contains(exportItem1) && exports.contains(exportItem2)) {
	                String country = record.get("Country");
	                System.out.println(country);
	            }
	        }
	    }
	    
	    public int numberOfExporters(CSVParser parser, String exportItem) {
	        int totalCountry = 0;
	        
	        for (CSVRecord record : parser) {
	            String exports = record.get("Exports");
	            
	            if (exports.contains(exportItem)) {
	                totalCountry++;
	            }
	        }
	        
	        return totalCountry;
	    }
	    
	    public void bigExporters(CSVParser parser, String amount) {
	        for (CSVRecord record : parser) {
	            String currentAmount = record.get("Value (dollars)");
	            
	            if (currentAmount.length() > amount.length()) {
	                String country = record.get("Country");
	                System.out.println(country + " " + currentAmount);
	            }
	        }
	    }
	    
	    public void testcsvdata() {
	        FileResource fr = new FileResource();
	        
	        CSVParser parser = fr.getCSVParser();
	        System.out.println(countryInfo(parser, "Peru"));
	        
	        parser = fr.getCSVParser();
	        listExportersTwoProducts(parser, "gold", "diamonds");
	        
	        parser = fr.getCSVParser();
	        System.out.println(numberOfExporters(parser, "coffee"));
	        
	        parser = fr.getCSVParser();
	        bigExporters(parser, "$999,999,900");
	    }
	
	
	public static void main(String[] args) {
		ParsingExportData exportData = new ParsingExportData();
		exportData.testcsvdata();

	}

}
