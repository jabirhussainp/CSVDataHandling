package main;

import filereading.FileReading;
import filereading.PersonData;
import gui.FormDesign;



/**
 * @author jabirhussain
 *
 */
public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileReading fr = new FileReading();
		PersonData pd = new PersonData();
		FormDesign fd = new FormDesign();
		
		fd.setVisible(true);
		

	}

}
