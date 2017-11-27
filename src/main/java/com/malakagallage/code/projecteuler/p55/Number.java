package com.malakagallage.code.projecteuler.p55;

/**
 * @author : maal (Malaka Gallage)
 * @since : 24/11/17
 */
public class Number {
	
	private double value;
	private int iteration = 0;
	
	public Number(double value) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}

	public int getIteration() {
		return iteration;
	}
	
	public void increseItr() {
		iteration++;
	}


}
