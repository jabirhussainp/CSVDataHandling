package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import filereading.FileReading;
import filereading.PersonData;

class FileReadingTest {

	ArrayList<PersonData> list;
	@Test
	void testGetMax() {
		FileReading fr = new FileReading();
		PersonData pd = new PersonData();
		pd.getAge();
		assertEquals(fr.getMax(list), 0);
		
	}

	@Test
	void testGetMin() {
		FileReading fr = new FileReading();
		PersonData pd = new PersonData();
		pd.getAge();
		assertEquals(fr.getMin(list), 100);
	}

	@Test
	void testGetMaxFare() {
		FileReading fr = new FileReading();
		PersonData pd = new PersonData();
		pd.getAge();
		assertEquals(fr.getMaxFare(list), 0.6);
	}

	@Test
	void testGetMinFare() {
		FileReading fr = new FileReading();
		PersonData pd = new PersonData();
		pd.getAge();
		assertEquals(fr.getMinFare(list), 230);
	}

}
