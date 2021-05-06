package com.java.second.course;

public class ObjectOrientedCaeserCipher {

	private String Alphabet;
	private String lowercaseAlphabets;
    private String shiftedAlphabet;
    private String shiftedlowercaseAlphabets;
	private int encryptionkey;
	public ObjectOrientedCaeserCipher(int key) {
		encryptionkey = key;
		Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		lowercaseAlphabets = Alphabet.toLowerCase();

        
        shiftedAlphabet = Alphabet.substring(key)+ Alphabet.substring(0,key);
        shiftedlowercaseAlphabets = lowercaseAlphabets.substring(key)+ lowercaseAlphabets.substring(0,key);
		  
	}
	
	public String encrypt(String input) {
		StringBuilder encrypted = new StringBuilder(input);
		
        
		  
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
	
	public String decrypt(String input) {
		ObjectOrientedCaeserCipher  cc = new ObjectOrientedCaeserCipher(26 - encryptionkey);
	    String message = cc.encrypt(input);
	    return message;
	 }
	
}
