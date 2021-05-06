package com.java.first.course;

public class FindingManyGenes {

    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        int index = 0;
        
        while(true) {
            index = dna.indexOf(stopCodon, startIndex + 3);
            
            if (index == -1 || (index - startIndex) % 3 == 0) {
                break;
            }
            
            startIndex += 3;
        }
        
        if (index != -1) {
            return index;
        } else {
            return dna.length();            
        }
    }
    
    public void testfindStopCodon() {
        String dna = "AATGCCGTAAAATGCCGTAAAATGCCG";
        
        int index = findStopCodon(dna, 0, "TAA");
        System.out.println("Index = " + index);
        
        index = findStopCodon(dna, 2, "TAA");
        System.out.println("Index = " + index);
                
        index = findStopCodon(dna, 1, "TAA");
        System.out.println("Index = " + index);
                
        index = findStopCodon(dna, 0, "TAG");
        System.out.println("Index = " + index);
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
    
    public void testfindGene() {
        String dnaStrand = "GTTAATGTAGCTTAAACCTTTAAAGCAAGGCACTGAAAATGCCTAGATGA";
        int index = 0;
        
        System.out.println("Gene: " + findGene(dnaStrand, index));
        
        dnaStrand = "GTGAGCTCACTCCATAGACACAAAGGTTTGGTCCTGGCCTTCTTATTAGT";
        System.out.println("Gene: " + findGene(dnaStrand, index));
        
        
        dnaStrand = "AGCTCACAACACCTTGCTTAGCCACACCCCCACGGGATACAGCAGTGATA";
        System.out.println("Gene: " + findGene(dnaStrand, index));
    }
    
    public void printAllGenes(String dnaStrand) {
        int start = 0;
        
        while (true) {
            String gene = findGene(dnaStrand, start);
            
            if (gene.isEmpty()) {
                break;
            }
            
            System.out.println("Gene: " + gene);
            
            start = dnaStrand.indexOf(gene, start) + gene.length();
        }
    }
    
    public void testPrintAllGenes() {
        String dna = "ATGATCTAATTTATGCTGCAACGGTGAAGA";
        printAllGenes(dna);
    }

    
    public int howManyOccurences(String stringa, String stringb) {
        int totalOccurences = 0;
        int startIndex = 0;
        
        while (true) {
            int index = stringb.indexOf(stringa, startIndex);
            
            if (index == -1) {
                break;
            }
            
            totalOccurences++;
            startIndex = index + stringa.length();
        }
        
        return totalOccurences;
    }
    
    public void testHowManyOccurences() {
        String stringa = "TAA";
        String stringb = "ATGATAACTAATTTAATC";
        System.out.println("Total occurences of " + stringa + " in " + stringb + " = " + howManyOccurences(stringa, stringb));
        
        stringa = "AA";
        stringb = "AGAATAAAA";
        System.out.println("Total occurences of " + stringa + " in " + stringb + " = " + howManyOccurences(stringa, stringb));
    }
    
    public int countGenes(String dna) {
        int startIndex = 0;
        int totalGenes = 0;
        
        while (true) {
            String gene = findGene(dna, startIndex);
            
            if (gene.isEmpty())
                break;
            
            
            totalGenes++;
            startIndex = dna.indexOf(gene, startIndex) + gene.length();
        }
        
        return totalGenes;
    }
    
    public void testCountGenes() {
        String dna = "ATGTAAGATG";
        System.out.println("Gene count on " + dna + " = " + countGenes(dna));
    }
	
	public static void main(String[] args) {
		FindingManyGenes  manyGenes = new FindingManyGenes();
		manyGenes.testPrintAllGenes();
		manyGenes.testHowManyOccurences();
		manyGenes.testCountGenes();
		

	}

}
