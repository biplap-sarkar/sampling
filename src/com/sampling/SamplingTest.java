package com.sampling;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

/**
 * JUnit test class
 * @author biplap
 *
 */
public class SamplingTest {

	@Test
	/**
	 * Test if the sample contains correct number of members
	 */
	public void testSampleCount() {
		Sample tester = new Sample();
		int sampleSize = 150;
		int limit = 1000;
		int arr[] = tester.getSample(sampleSize, limit);
		assertEquals("Sample should contain "+sampleSize+" integers",sampleSize,arr.length);
	}
	
	@Test
	/**
	 * Test if the sample contains elements in sorted order
	 */
	public void testSampleOrder() {
		Sample tester = new Sample();
		int sampleSize = 200;
		int limit = 10000;
		int arr[] = tester.getSample(sampleSize, limit);
		for(int i=1;i<arr.length;i++)
			assertTrue("Sample elements should be in increasing order", arr[i-1] < arr[i]);
	}
	
	@Test
	/**
	 * Test if the sample contains an element only once
	 */
	public void testSampleElementUniqueness() {
		Sample tester = new Sample();
		int sampleSize = 250;
		int limit = 10000;
		int arr[] = tester.getSample(sampleSize, limit);
		HashMap<Integer, Integer> sampleMap = new HashMap<Integer, Integer>();
		for(int i=0;i<arr.length;i++){
				assertNull("The elements in sample should be unique", sampleMap.get(Integer.valueOf(i)));
				sampleMap.put(Integer.valueOf(i), Integer.valueOf(i));
		}
	}
	
	/**
	 * Test if the elements in sample are bounded by the limit
	 */
	@Test
	public void testElementBound() {
		Sample tester = new Sample();
		int sampleSize = 150;
		int limit = 10000;
		int arr[] = tester.getSample(sampleSize, limit);
		for(int i=0;i<arr.length;i++){
			assertTrue("The elements should be between 0 to "+(limit-1),arr[i]>=0 && arr[i]<limit);
		}
	}
	
	/**
	 * Test if a big sample contains correct number of members
	 */
	@Test
	public void testBigSampleCount() {
		Sample tester = new Sample();
		int sampleSize = 5000000;
		int limit = 1000000000;
		int arr[] = tester.getSample(sampleSize, limit);
		assertEquals("Sample should contain "+sampleSize+" integers",sampleSize,arr.length);
	}
	
	@Test
	/**
	 * Test if a big sample contains elements in sorted order
	 */
	public void testBigSampleOrder() {
		Sample tester = new Sample();
		int sampleSize = 4000000;
		int limit = 1000000000;
		int arr[] = tester.getSample(sampleSize, limit);
		for(int i=1;i<arr.length;i++)
			assertTrue("Sample elements should be in increasing order", arr[i-1] < arr[i]);
	}
	
	/**
	 * Test if a big sample contains an element only once
	 */
	@Test
	public void testBigSampleElementUniqueness() {
		Sample tester = new Sample();
		int sampleSize = 1000000;
		int limit = 200000000;
		int arr[] = tester.getSample(sampleSize, limit);
		HashMap<Integer, Integer> sampleMap = new HashMap<Integer, Integer>();
		for(int i=0;i<arr.length;i++){
				assertNull("The elements in sample should be unique", sampleMap.get(Integer.valueOf(i)));
				sampleMap.put(Integer.valueOf(i), Integer.valueOf(i));
		}
	}
	
	/**
	 * Test if the elements in the big sample are bounded by the limit
	 */
	@Test
	public void testBigElementBound() {
		Sample tester = new Sample();
		int sampleSize = 200000;
		int limit = 300000000;
		int arr[] = tester.getSample(sampleSize, limit);
		for(int i=0;i<arr.length;i++){
			assertTrue("The elements should be between 0 to "+(limit-1),arr[i]>=0 && arr[i]<limit);
		}
	}

}
