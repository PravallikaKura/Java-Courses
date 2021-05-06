package com.java.first.course;

import edu.duke.*;

public class FindingWebLinks {
	    public void checkyoutubeUrl(String url) {
	    	
	    	
	        URLResource myurl = new URLResource(url);
	        for(String word : myurl.words()) {
	            if(word.toLowerCase().indexOf("youtube.com") != -1) {
	                int startQuoteIndex = word.indexOf("\"");
	                int stopQuoteIndex = word.indexOf("\"", startQuoteIndex+1);
	                System.out.println(word.substring(startQuoteIndex+1, stopQuoteIndex));
	                
	            }
	        }
	    }
	    
	    public void testUrl() {
	    	checkyoutubeUrl("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
	    }
	    

	public static void main(String[] args) {
		FindingWebLinks webLinks = new FindingWebLinks();
		webLinks.testUrl();

	}

}
