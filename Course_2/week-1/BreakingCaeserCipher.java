package com.java.second.course;

import edu.duke.FileResource;

public class BreakingCaeserCipher {

	
	public void countWordLengths(FileResource Resource, int[] counts) { 
		  
        for (String word : Resource.words()){
            int Wordlength = word.length();
            for (int i = 0; i< word.length();i++){
                char currChar = word.charAt(i);
                if ((i==0) || (i==word.length()-1)){
                    if (!Character.isLetter(currChar)) 
                    	Wordlength--;
                }
            }  
            counts[Wordlength]++;   
            System.out.println(" Words of length "+ Wordlength +" "+ word);
        }
        
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
       
    
	public void testCountWordLengths(){
     FileResource Resource = new FileResource();
      int [] counts = new int[35];
        countWordLengths(Resource,counts);     
        indexOfMax(counts);    
     }              
    

    public String decrypt(String encrypted, int Key) {
       CaeserCipher cipher = new CaeserCipher();
       String decrypted = cipher.encrypt(encrypted, 26-Key);
       return decrypted;
    
    }
    
    
    public String decryptTwoKeys(String encrypted){
        
       CaeserCipher cipher1  = new CaeserCipher();
       
       String message1 = halfOfString(encrypted,0);
       String message2 = halfOfString(encrypted,1);
       
       StringBuilder decrypt_two_keys = new StringBuilder(encrypted);
       
       int key1 = getKey(message1);
       int key2 = getKey(message2);
       
       String encryptedMessage1 = cipher1.encrypt(message1,(26-key1));
       String encryptedMessage2 = cipher1.encrypt(message2,(26-key2));
       
      
       
       for (int i=0; i < message1.length();i++)
    	   decrypt_two_keys.setCharAt((2*i), encryptedMessage1.charAt(i));
           
       for (int i=0; i< message2.length();i++)
    	   decrypt_two_keys.setCharAt((2*i)+1, encryptedMessage2.charAt(i));
       
       
       return  decrypt_two_keys.toString();    
    
    
    }
    
    public String halfOfString(String message, int start){
        String result = new String();
        for (int i = start; i < message.length();i += 2) 
          result = result + message.charAt(i);
        
        return result;
    }
    
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
    public int getKey(String s) {
    	
    	
       int[] freqs = CountLetters(s);
       int maxindex = indexOfMax(freqs);
       int decryptedKey = maxindex-4;
       if (maxindex < 4)
    	   decryptedKey = 26 - (4 -maxindex);
       
       return decryptedKey;
        
    }
    
    public void decryptTwoKeysTest() {
        
       FileResource resource = new FileResource();
       String message = resource.asString();
       String decrypted_message = decryptTwoKeys(message); 
       System.out.println(message);
       System.out.println(decrypted_message);
    }

	public static void main(String[] args) {
		BreakingCaeserCipher cipher = new BreakingCaeserCipher();
		cipher.testCountWordLengths();
		cipher.decryptTwoKeysTest();

	}

}
