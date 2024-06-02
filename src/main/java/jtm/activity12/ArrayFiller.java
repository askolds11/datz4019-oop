package jtm.activity12;

import java.util.Random;

public class ArrayFiller implements Runnable {

	int latency; // required latency time (in miliseconds) to simulate real
					// environment
	int startValue; // min and max allowed values for array cells
	int from, to; // range which should be filled by this filler
	Random random; // Pseudo-random generator

	public ArrayFiller(int latency, int startValue) {
		// from this constructor call another constructor with more
		// parameters and fill missing values from beginning till to the end of an array
		this(latency, startValue, 0, ArrayFillerManager.array.length - 1);
	}

	public ArrayFiller(int latency, int startValue, int from, int to) {
		// save passed values to created filler object
		this.latency = latency;
		this.startValue = startValue;
		this.from = from;
		this.to = to;
	}

	@Override
	public void run() {
		// when invoked, put filler to sleep for required amount of latency using
		// Thread.sleep(latency) method
        try {
            Thread.sleep(latency);
        } catch (InterruptedException e) {
        }
        // fill ArrayFillerManager.array from..to cells with pseudo random values
		// initialize new Random(startValue + arrayCellNo) and then use
		// random.nextInt() to get value for given cell
		// Look at http://docs.oracle.com/javase/7/docs/api/java/util/Random.html
		for (int i = from; i <= to; i++) {
			random = new Random(startValue + i);
			ArrayFillerManager.array[i] = random.nextInt();
		}
	}

}
