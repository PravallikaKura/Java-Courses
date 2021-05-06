package com.java.first.course;

public class FindingSimpleGeneReorganised {

	
	
public String findSimpleGene(String DNAStrand, String startCodon, String stopCodon) {
		
		String gene = "";
		
		if(DNAStrand.charAt(0) >= 'A' && DNAStrand.charAt(0) <= 'Z') {
			startCodon = startCodon.toUpperCase();
			stopCodon = stopCodon.toUpperCase();
		} else {
			startCodon = startCodon.toLowerCase();
			stopCodon = stopCodon.toLowerCase();
			
		}
		int startIndex = DNAStrand.indexOf(startCodon);
		if(startIndex == -1)
			gene = "";
		int stopIndex = DNAStrand.indexOf(stopCodon, startIndex+3);
		if(stopIndex == -1)
			gene = "";
		if ((stopIndex - startIndex) % 3 == 0)
			gene = DNAStrand.substring(startIndex, stopIndex+3);
		
		return gene;
		
	  }
	
	public void testfindSimpleGene() {
		String dnaStrand1 = "AATGCCGTAATAGGT";
		String dnaStrand2 = "atgtaa";
		String dnaStrand3 = "AATGCTAGGGTAATATGGT";
		String dnaStrand4 = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
		
		System.out.println("DNA Gene of " +dnaStrand1 + "is " + findSimpleGene(dnaStrand1, "ATG", "TAA"));
		System.out.println("DNA Gene of " +dnaStrand2 + "is " + findSimpleGene(dnaStrand2, "ATG", "TAA"));
		System.out.println("DNA Gene of " +dnaStrand3 + "is " + findSimpleGene(dnaStrand3, "ATG", "TAA"));
		System.out.println("DNA Gene of " +dnaStrand4 + "is " + findSimpleGene(dnaStrand4, "ATG", "TAA"));
		
		
		
	}
	
	public static void main(String[] args) {
		FindingSimpleGeneReorganised geneReorganised = new FindingSimpleGeneReorganised();
		geneReorganised.testfindSimpleGene();
	}

}
