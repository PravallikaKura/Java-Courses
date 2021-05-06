package com.java.second.course;

import edu.duke.FileResource;

public class CaeserCipher {

	public boolean isVowel(char ch) {
		ch = Character.toLowerCase(ch);
		if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
			return true;
		else
			return false;
		
	}
	
	public void testisVowel() {
		char testchar = 'a';
		System.out.println(isVowel(testchar));
		
		char testchar1 = 'b';
		System.out.println(isVowel(testchar1));
		
		char testchar2 = 'D';
		System.out.println(isVowel(testchar2));
		
		char testchar3 = 'O';
		System.out.println(isVowel(testchar3));
	}
	
	public String replaceVowels(String str, char ch) {
		
		StringBuilder s = new StringBuilder(str);
       
		for(int i = 0;i < s.length();i++) {
			if(isVowel(s.charAt(i)))
				 s.setCharAt(i, ch);
		}
		return s.toString();
	}
	
	public void testreplaceVowels() {
		String s = "ABCD";
		char ch = '&';
		System.out.println(replaceVowels(s,ch));
		
		s = "AEIOU";
		ch = '*';
		System.out.println(replaceVowels(s,ch));
		
		s = "CDEF";
		ch = '(';
		System.out.println(replaceVowels(s,ch));
		
		
	}
	
	public String emphasize(String str, char ch) {
		int index = str.indexOf(ch);
		
		StringBuilder s = new StringBuilder(str);
		
		if(index % 2 == 0) {
			for(int i = 0;i < s.length();i++) {
				if(s.charAt(i) == ch)
					 s.setCharAt(i, '*');
			}
		}
		else {
			for(int i = 0;i < s.length();i++) {
				if(s.charAt(i) == ch)
					 s.setCharAt(i, '+');
			}
		}
		return s.toString();
			
			
	}
	
	public void testEmphasize() {
		
		System.out.println(emphasize("dna ctgaaactga", 'a')); 
		System.out.println(emphasize("Mary Bella Abracadabra", 'a'));
		
		
	}
	
	public String encrypt(String input, int key) {
		StringBuilder encrypted = new StringBuilder(input);
		
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        String shiftedAlphabet = alphabet.substring(key)+ alphabet.substring(0,key);
        
        for ( int i = 0; i < encrypted.length();i++){
        
        char currChar = encrypted.charAt(i);
        
        int idx = alphabet.indexOf(currChar);
       
        if (idx !=-1){
           
            char newChar = shiftedAlphabet.charAt(idx);
            
            encrypted.setCharAt(i,newChar);
		
	    }
     }
        
        return encrypted.toString();
	}
	
	public void testCaeser() {
		int key = 5;
		FileResource fr = new FileResource();
		String message = fr.asString();
		String encrypted = encrypt(message, key);
		System.out.println("key is " + key + "\n" + encrypted);
		
	}
	
	public String encryptCaseInsensitive(String input,int key) {
		
		
        StringBuilder encrypted = new StringBuilder(input);
       
		
		String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowercaseAlphabets = Alphabet.toLowerCase();
        
        String shiftedAlphabet = Alphabet.substring(key)+ Alphabet.substring(0,key);
        String shiftedlowercaseAlphabets = lowercaseAlphabets.substring(key)+ lowercaseAlphabets.substring(0,key);
        
        
        for ( int i = 0; i < encrypted.length();i++){
        
        char currChar = encrypted.charAt(i);
        if(currChar >= 'a' && currChar <= 'z') {
        
           int idx = lowercaseAlphabets.indexOf(currChar);
       
           if (idx !=-1){
           
            char newChar = shiftedlowercaseAlphabets.charAt(idx);
            encrypted.setCharAt(i,newChar);
		
	       }
         } else {
        	 int idx = Alphabet.indexOf(currChar);
             
             if (idx !=-1){
             
              char newChar = shiftedAlphabet.charAt(idx);
              encrypted.setCharAt(i,newChar);
            }
         }
        
        }
        return encrypted.toString();
			
	}
	
	public void testencryptCaseInsensitive() {
		
		System.out.println(encryptCaseInsensitive("First Legion", 23)); 
		System.out.println(encryptCaseInsensitive("First Legion", 17));  
		
	}
	
	
	public String encryptTwoKeys(String input,int key1,int key2) {
		
		StringBuilder encrypted = new StringBuilder(input);
		String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowercaseAlphabets = Alphabet.toLowerCase();
        
        String shiftedAlphabet1 = Alphabet.substring(key1)+ Alphabet.substring(0,key1);
        String shiftedAlphabet2 = Alphabet.substring(key2)+ Alphabet.substring(0,key2);
        String shiftedlowercaseAlphabets1 = lowercaseAlphabets.substring(key1)+ lowercaseAlphabets.substring(0,key1);
        String shiftedlowercaseAlphabets2 = lowercaseAlphabets.substring(key2)+ lowercaseAlphabets.substring(0,key2);
        
        
        for ( int i = 0; i < encrypted.length();i+=2){
        
        char currChar = encrypted.charAt(i);
        if((i % 2 == 0) && currChar >= 'a' && currChar <= 'z') {
        
           int idx = lowercaseAlphabets.indexOf(currChar);
       
           if (idx !=-1){
           
            char newChar = shiftedlowercaseAlphabets1.charAt(idx);
            encrypted.setCharAt(i,newChar);
		
	       }
         } else if((i % 2 == 0) && currChar >= 'A' && currChar <= 'Z') {
        	 int idx = Alphabet.indexOf(currChar);
             
             if (idx !=-1){
             
              char newChar = shiftedAlphabet1.charAt(idx);
              encrypted.setCharAt(i,newChar);
            }
         }
        
        }
        
        for ( int i = 1; i < encrypted.length();i+=2){
            
            char currChar = encrypted.charAt(i);
            if((i % 2 != 0) && currChar >= 'a' && currChar <= 'z') {
            
               int idx = lowercaseAlphabets.indexOf(currChar);
           
               if (idx !=-1){
               
                char newChar = shiftedlowercaseAlphabets2.charAt(idx);
                encrypted.setCharAt(i,newChar);
    		
    	       }
             } else if((i % 2 != 0) && currChar >= 'A' && currChar <= 'Z') {
            	 int idx = Alphabet.indexOf(currChar);
                 
                 if (idx !=-1){
                 
                  char newChar = shiftedAlphabet2.charAt(idx);
                  encrypted.setCharAt(i,newChar);
                }
             }
            
            }
        return encrypted.toString();
			
	}
	
	public void testencryptTwoKeys() {
		
		System.out.println(encryptTwoKeys("First Legion",23,17));
		
	}
	public static void main(String[] args) {
		CaeserCipher cipher = new CaeserCipher();
		cipher.testisVowel();
		cipher.testreplaceVowels();
		cipher.testEmphasize();
		cipher.testencryptCaseInsensitive();
		cipher.testencryptTwoKeys();

	}

}
