package com.java.second.course;

import edu.duke.FileResource;

public class VignereBreaker {
	
	  public String sliceString(String message, int whichSlice, int totalSlices) {
	        
	        StringBuilder slicing = new StringBuilder(message);
	        String result = new String();
	        for(int i = whichSlice;i <slicing.length(); i +=totalSlices){
	            result += slicing.charAt(i);
	        }
	        
	        return result;
	    }

	    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
	        CaeserCracker CaesarCracker = new CaeserCracker('e');
	        int aKey;
	        int[] key = new int[klength];
	        for(int k =0;k<klength;k++){
	           aKey = CaesarCracker.getKey(sliceString(encrypted,k,klength));
	           key[k] = aKey;
	        }
	        return key;
	    }

	    public String breakVigenere() {
	        FileResource resource = new FileResource();
	        String message = resource.asString();
	        return message;
	    }

}
