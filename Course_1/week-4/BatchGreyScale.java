package com.java.first.course;

import java.io.File;

import edu.duke.DirectoryResource;
import edu.duke.ImageResource;
import edu.duke.Pixel;

public class BatchGreyScale {

	 public ImageResource makeGray(ImageResource inImage) {
	        ImageResource outImage = new ImageResource(inImage);
	        
	        for (Pixel pixel : outImage.pixels()) {
	            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
	            int red = inPixel.getRed();
	            int green = inPixel.getGreen();
	            int blue = inPixel.getBlue();
	            int average = (red + green + blue) / 3;
	            
	            pixel.setRed(average);
	            pixel.setGreen(average);
	            pixel.setBlue(average);
	        }
	        
	        return outImage;
	    }
	    
	    public void selectAndConvert() {
	        DirectoryResource dr = new DirectoryResource();
	        
	        for (File f : dr.selectedFiles()) {
	            ImageResource inImage = new ImageResource(f);
	            ImageResource outImage = makeGray(inImage);
	            
	            String fileName = inImage.getFileName();
	            String newFileName = "gray-" + fileName;
	            
	            outImage.setFileName(newFileName);
	            outImage.save();
	        }
	    }
	public static void main(String[] args) {
		BatchGreyScale bscale = new BatchGreyScale();
		bscale.selectAndConvert();

	}

}
