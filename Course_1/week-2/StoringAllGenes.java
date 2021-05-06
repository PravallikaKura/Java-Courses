package com.java.first.course;

import edu.duke.StorageResource;

public class StoringAllGenes {

	
       public int findStopCodon(String dna, int startIndex, String stopCodon) {
        int index = 0;
        
        while(true) {
            index = dna.indexOf(stopCodon, startIndex + 3);
            
            if (index == -1 || (index - startIndex) % 3 == 0) {
                break;
            }
            
            startIndex += 3;
        }
        
        if (index != -1) 
            return index;
        else 
            return dna.length();            
        
     }
	    public String findGene(String dna, int start) {
        String startCodon = "ATG";
        int startIndex = dna.indexOf(startCodon, start);

        
        String gene = "";
        
        if (startIndex == -1)
        	gene = "";
            
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        
        int minIndex = Math.min(taaIndex, Math.min(tagIndex, tgaIndex));
        
        if (minIndex == dna.length()) 
            gene = "";
         else 
            gene = dna.substring(startIndex, minIndex + 3);
        return gene;
        
        
    }
    
	public StorageResource getAllGenes(String dna) {
        int startIndex = 0;
        StorageResource geneList = new StorageResource();
        
        while (true) {
            String gene = findGene(dna, startIndex);
            
            if (gene.isEmpty()) {
                break;
            }
            
            geneList.add(gene);
            
            startIndex = dna.indexOf(gene, startIndex) + gene.length();
        }
        
        return geneList;
    }
    
    public void testGetAllGenes() {
        String dna = "ATGATCTATCCTATGCTTCGGCTGCTCTAATATGGT";
        StorageResource geneList = getAllGenes(dna);
        
        System.out.println("Testing getAllGenes on " + dna);
        for(String gene : geneList.data()) {
            System.out.println("Gene: " + gene);
        }
    }
    
    public double cgRatio(String dna) {
        int totalOccurences = 0;
        
        for (int i = 0; i < dna.length(); i++) {
            if (dna.toUpperCase().charAt(i) == 'C' || dna.toUpperCase().charAt(i) == 'G') {
                totalOccurences++;
            }
         }
         
         return (double) totalOccurences / dna.length();
    }
    
    public void testcgRatio() {
        String dna = "ATGATCTATCCTATGCTTCGGCTGCTCTAATATGGT";
        System.out.println("cgRatio on " + dna + " = " + cgRatio(dna));
    }
    
    public int countCTG(String dna) {
        int totalOccurences = 0;
        int start = 0;
        
        while(true) {
            int index = dna.toUpperCase().indexOf("CTG", start);
            
            if (index == -1) 
                break;
            
            
            totalOccurences++;
            start = index + 3;
        }
        
        return totalOccurences;
    }
    
    public void testCountCTG() {
        String dna = "CTGCCTGGCTGCTGATGATCTATCCTATGCTTCGGCTGCTCTAATATGGT";
        System.out.println("CTG occurences on " + dna + " = " + countCTG(dna));
    }
	public static void main(String[] args) {
		StoringAllGenes allGenes = new StoringAllGenes();
		allGenes.testGetAllGenes();
		allGenes.testCountCTG();
		allGenes.testcgRatio();

	}

}
