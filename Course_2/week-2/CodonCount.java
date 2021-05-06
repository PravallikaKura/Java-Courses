package com.java.second.course;

import java.util.HashMap;

import edu.duke.FileResource;

public class CodonCount {

	private HashMap<String,Integer> DNA_Count;

	public CodonCount() {
		DNA_Count = new HashMap<String,Integer>();
	}
	
	
	public void buildCodonMap(int start, String dna) {
		
		
		    DNA_Count.clear();
	        int codons = 0; 
	        int i = 0;
	        int index = 0;
	        int num_dnas = (dna.length()-start)/3;
	        String current;
	        while (i < codons) {
	        	index = i*3+start;
	            current = dna.substring(index, index+3);
	            if (!DNA_Count.containsKey(current))
	                DNA_Count.put(current, 1);
	            else 
	                DNA_Count.put(current, DNA_Count.get(current)+1);
	            i += 1;
	        }
	        
	    }
		
	 public String getMostCommonCodon() {
		    
	        int largest = 0;
	        int current = 0;
	        String largest_count = null;
	        for (String index : DNA_Count.keySet()) {
	            current = DNA_Count.get(index);
	            if (largest < current) {
	                largest = current;
	                largest_count = index;
	            }
	        }
	        return largest_count;
	    }
	    
	    public void printCodonCounts(int start, int end) {
	        int current = 0;
	        for (String index : DNA_Count.keySet()) {
	            current = DNA_Count.get(index);
	            if (current >= start && current <= end) 
	                System.out.println(index+" : "+current);
	        }
	        
	    }
	    
	 
}
