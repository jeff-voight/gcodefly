/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.voight.gcodefly.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Jeffrey Voight <jeff.voight@gmail.com>
 */
public class GCode {
    private final List<String> lines;
    private final File inputFile;
    private boolean isChanged=false;
    private final BufferedReader reader;
    private int currentLine=0;
    Iterator<String> it;
    
    public GCode(File inputFile) throws FileNotFoundException, IOException{
	this.inputFile=inputFile;
	reader=new BufferedReader(new FileReader(inputFile));
	lines=new ArrayList();
	while(reader.ready()){
	    lines.add(reader.readLine());
	}
	it=lines.iterator();
    }
    
    public void ignoreCodes(List<String> ignoreLines){
	
    }
    
    public String next(){
	String line=it.next();
	currentLine++;
	if(containsUnsupportedGCode(line)){
	    // TODO: Error message?
	    return "";
	} else {
	    return line;
	}
    }
    
    public boolean isChanged(){
	return isChanged;
    }
    
    private void isChanged(boolean isChanged){
	this.isChanged=isChanged;
    }
    
    public boolean containsUnsupportedGCode(String line){
	return false;
    }
}
