package com.sampling;

/*
 * Sampling (#39)
 * 
The challenge is to implement a program called "sample" that takes exactly two
integer inputs. The first of those should be the number of members chosen at 
random you would like included in the sample. The second is the upper boundary 
(exclusive) of the range of integers members can be selected from. The lower 
boundary is zero (inclusive).
Your program should output exactly the requested number of members from the 
defined range to STDOUT, one number per line. Each member must be unique and 
they should appear in sorted order.
 */

/*
 * The program makes use of reservoir sampling to select random sample of k elements
 * with each number upto limit having equal probability of getting selected.
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Main Class
 * @author biplap
 *
 */
public class Sample {

	public static void main(String[] args) throws IOException {
		BufferedReader br = null;
		if(args.length==0){			// no command line arguments, take input from standard input
			br = new BufferedReader(new InputStreamReader(System.in));
			String input = br.readLine();
			args = input.trim().split("\\s+");
		}
	    int memberCount = Integer.parseInt(args[0]);
	    int limit = Integer.parseInt(args[1]);
	    Sample sampleObj = new Sample();
	    int []sample = sampleObj.getSample(memberCount, limit);
	    for(int i=0;i<sample.length;i++)
	    	System.out.println(sample[i]);
	    
	}
	
	/**
	 * Returns a sample of memberCount integers randomly within the upper
	 * bound of limit in sorted order.
	 * It implements reservoir sampling to get a sample of memberCount integers
	 * and then sorts them to achieve time complexity of O(n+klog(k)), where
	 * n is the upper bound and k is the sample size.
	 * 
	 * @param memberCount:- number of members in the sample, ie sample size
	 * @param limit:- upper bound of the sample elements
	 * @return randomly chosen sample as array of int
	 */
	public int[] getSample(int memberCount, int limit){
		int [] sample = new int[memberCount];	/* The use of array of primitive data type instead of
												   wrapped Integers improves memory efficiency and speed
		 										   in case the limit is very large.
		 										*/
		int swapIndex;
		for(int i=0;i<memberCount;i++)			/* Initialize the reservoir array */
			sample[i]=i;
		for(int i=memberCount;i<limit;i++){
			swapIndex = ThreadLocalRandom.current().nextInt(0,i);
			if(swapIndex<memberCount)
				sample[swapIndex]=i;
		}
		Arrays.sort(sample);	/* 	Sorting the array after getting the sample 
									allows the program to run in O(n + klog(k))
									where n is the upper bound and k is sample size.
									Instead of sorting later and using a heap to
									maintain sorted order of the selected elements
									would have costed O(nlog(k)) which is higher
									than current complexity assuming n >> k
								*/ 
		return sample;
	}

}
