package com.java.second.course;

import edu.duke.FileResource;

public class TestCaeserCipher {
	
	public int[] CountLetters(String message) {
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] count = new int[26];
        for(int k=0; k < message.length();k++) {
           char ch = Character.toLowerCase(message.charAt(k));
           int index = alph.indexOf(ch);
           if(index!=-1) {
               count[index]++;
           }

           }
       return count;
   }
	public int indexOfMax(int[] values) {

        int max = 0;
        int currPosition = 0;
            for (int i = 0; i <values.length;i++) 
              {
                  if (values[i] > max) 
                    {
                        max = values[i];
                       currPosition = i;
                    } 
              }
        
      return currPosition; 
        
    }
	public void simpleTests() {
	      FileResource fr = new FileResource();
	      String message = fr.asString();
	      ObjectOrientedCaeserCipher cc = new ObjectOrientedCaeserCipher(18);
	      String encrypted = cc.encrypt(message);
	      System.out.println("The encryption result is "+ encrypted);
	     
	      String breakCaesarCipher = breakCaesarCipher(encrypted);
	      System.out.println("The decryption outcome is "+ breakCaesarCipher);
	     }
	     
	       
	public String breakCaesarCipher(String input) {
	    
	    int [] freqs = CountLetters(input);
	    int maxIndex = indexOfMax(freqs);
	    int decryptkey = maxIndex - 4;
	    if (decryptkey < 0)
	    	decryptkey = 26 - (4 - maxIndex);
	    ObjectOrientedCaeserCipher cc = new ObjectOrientedCaeserCipher(decryptkey);
	    String message = cc.decrypt(input);
	    return message;
	}
	    
	public static void main(String[] args) {
		
      TestCaeserCipher testCaeser = new TestCaeserCipher();
      testCaeser.simpleTests();
	}

}
