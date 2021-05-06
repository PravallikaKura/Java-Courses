package com.java.first.course;
import edu.duke.*;
import java.io.File;
import java.lang.System.Logger;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
    	
    	int count = 0;
    	for(Point p : s.getPoints())
    		count += 1;
    		
        return count;
    }

    public double getAverageLength(Shape s) {
        
        return getPerimeter(s)/(double) getNumPoints(s);
    }

    public double getLargestSide(Shape s) {
        // Put code here
    	
    	double largestSide = 0.0;
    	Point lastPoint = s.getLastPoint();
    	double current_distance = 0.0;
    	
    	for(Point p: s.getPoints()) {
    		current_distance = lastPoint.distance(p);
    		if(current_distance > largestSide)
    			largestSide = current_distance;
    		lastPoint = p;
    	}
    		
    	
        return largestSide;
    }

    public double getLargestX(Shape s) {
    	double largestXparam  = (double) s.getLastPoint().getX();
        for(Point p: s.getPoints()) {
        	if(p.getX() > largestXparam)
        		largestXparam = p.getX();
        }	
        return largestXparam;
    }

    public double getLargestPerimeterMultipleFiles() {
    	
    	DirectoryResource dr = new DirectoryResource();
    	double largestPerimeter = 0.0;
    	double currentPerimeter = 0.0;

    	
        for (File f : dr.selectedFiles()) {
            FileResource currentFile = new FileResource(f);
            Shape currentShape = new Shape(currentFile);
            currentPerimeter = getPerimeter(currentShape);
            if(currentPerimeter > largestPerimeter)
            	largestPerimeter = currentPerimeter;
            
        }
        // Put code here
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
    	DirectoryResource dr = new DirectoryResource();
    	double largestPerimeter = 0.0;
    	double currentPerimeter = 0.0;
    	FileResource currentFile;
    	File largestFile = null;
    	
        for (File f : dr.selectedFiles()) {
            currentFile = new FileResource(f);
            Shape currentShape = new Shape(currentFile);
            currentPerimeter = getPerimeter(currentShape);
            if(currentPerimeter > largestPerimeter) {
            	largestPerimeter = currentPerimeter;
            	largestFile = f;
            }
            
        }
        return largestFile.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
    }
    
    public void testPerimeterMultipleFiles() {
    	
    	double largestPerimeter = getLargestPerimeterMultipleFiles();
    	System.out.println("Largest Perimeter of all is " +largestPerimeter);
    	
    	
       
    }

    public void testFileWithLargestPerimeter() {
        
    	String largestPerimeterfileName = getFileWithLargestPerimeter();
    	System.out.println("Largest Perimeter file of all is " +largestPerimeterfileName);
    	
    	
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        
        Shape s = new Shape();
        
        
        s.addPoint(new Point(-3,3));
        s.addPoint(new Point(-4,-3));
        s.addPoint(new Point(4,-2));
        s.addPoint(new Point(6,5));
        
        pr.testPerimeter();
        pr.testFileWithLargestPerimeter();
        pr.testPerimeterMultipleFiles();
        
        
        
    }
}
