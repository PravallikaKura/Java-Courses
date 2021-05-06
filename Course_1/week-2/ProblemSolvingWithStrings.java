package com.java.first.course;

public class ProblemSolvingWithStrings {

	
	public boolean twoOccurrences(String stringa, String stringb) {
        int index1 = stringb.indexOf(stringa);
        if(index1 != -1) {
            int index2 = stringb.indexOf(stringa, index1+1);
            if( index2 != -1) 
                return true;
            
        } else 
            return false;
        
        return false;
    }
    
    public void testing() {
    	
    	String stringa = "by";
    	String stringb = "A story by Abby Long";
        System.out.println(twoOccurrences(stringa,stringb));
        
        stringa = "a";
        stringb = "banana";
        System.out.println(twoOccurrences(stringa,stringb));
        
        stringa = "atg";
        stringb = "ctgtatgta";
        System.out.println(twoOccurrences(stringa,stringb));
        
        stringa = "an";
        stringb = "banana";
        System.out.println("The part of the string after " +stringa + " in " + stringb +" is  " +lastPart(stringa,stringb));
        
        stringa = "zoo";
        stringb = "forest";
        System.out.println("The part of the string after " +stringa + " in " + stringb + " is " +lastPart(stringa,stringb));
    }
    
    public String lastPart(String stringa, String stringb) {
        if(stringb.indexOf(stringa) != -1) {
            int index = stringb.indexOf(stringa);
            return stringb.substring(index+stringa.length(), stringb.length());
        } else {
            return stringb;
        }
    }
    
   

	public static void main(String[] args) {
		ProblemSolvingWithStrings stringsSums = new ProblemSolvingWithStrings();
	    stringsSums.testing();
	}

}
