package com.java.first.course;


import org.slf4j.*;

public class FindingGeneSimplifiedAlgorithm {
	
	private static Logger logger = LoggerFactory.getLogger(FindingGeneSimplifiedAlgorithm.class);
	
	
	public String findSimpleGene(String DNAStrand) {
		
		String gene = "";
		int startIndex = DNAStrand.indexOf("ATG");
		if(startIndex == -1)
			gene = "";
		int stopIndex = DNAStrand.indexOf("TAA", startIndex+3);
		if(stopIndex == -1)
			gene = "";
		if ((stopIndex - startIndex) % 3 == 0)
			gene = DNAStrand.substring(startIndex, stopIndex+3);
		
		return gene;
		
	  }
	
	public void testfindSimpleGene() {
		String dnaStrand1 = "AATGCCGTAATAGGT";
		String dnaStrand2 = "ATGTAA";
		String dnaStrand3 = "AATGCTAGGGTAATATGGT";
		String dnaStrand4 = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
		
		System.out.println("DNA Gene of " +dnaStrand1 + "is " + findSimpleGene(dnaStrand1));
		System.out.println("DNA Gene of " +dnaStrand2 + "is " + findSimpleGene(dnaStrand2));
		System.out.println("DNA Gene of " +dnaStrand3 + "is " + findSimpleGene(dnaStrand3));
		System.out.println("DNA Gene of " +dnaStrand4 + "is " + findSimpleGene(dnaStrand4));
		
		
		
	}
	
	public static void main(String[] args) {
		
		FindingGeneSimplifiedAlgorithm simpleAlgo = new FindingGeneSimplifiedAlgorithm();
		
		simpleAlgo.testfindSimpleGene();
		
	}

}
