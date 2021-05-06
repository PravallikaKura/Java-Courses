package com.java.second.course;

import java.util.ArrayList;

import edu.duke.FileResource;

public class WordFrequencies {
 private ArrayList<String> myWords;
 private ArrayList<Integer> myFreqs;
 public WordFrequencies() {
	 myWords = new ArrayList<String>();
     myFreqs = new ArrayList<Integer>();
 }
 
 public void findUnique() {
	 
	 myWords.clear();
	 myFreqs.clear();
	 
	 FileResource Resource = new FileResource();
	 for(String str: Resource.words()){
         str = str.toLowerCase();
         int index = myWords.indexOf(str);
         if(index == -1){
             myWords.add(str);
             myFreqs.add(1);
         }
         else {
             int freq = myFreqs.get(index);
             myFreqs.set(index,freq+1); 
         }
     }
	 
 }
 
 public void tester() {
     findUnique();
     System.out.println("Unique Words"+ myWords.size());
     
     for ( int k =0; k < myWords.size();k++)
         System.out.println(myFreqs.get(k)+ "   "+ myWords.get(k));
     
     int index = findIndexOfMax();
     System.out.println("max word/freq: " +myWords.get(index)+ " "+ myFreqs.get(index));
 }
  
 public int findIndexOfMax() {
     int max = myFreqs.get(0);
     int maxIndex = 0;
     for(int i=0; i < myFreqs.size(); i++) {
         if (myFreqs.get(i) >max) {
             max = myFreqs.get(i);
             maxIndex = i;
         }
         
     }
     return maxIndex;
 }
 
 public static void main(String[] args) {
	 WordFrequencies freqs = new WordFrequencies();
	 freqs.tester();
 }
	
}
