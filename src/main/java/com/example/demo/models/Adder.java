package com.example.demo.models;

public class Adder {
//	int secret1;
//	double secret2;
	public double sum;
	
	public Adder (double first, double second)	{
//		secret1 = first;
//		secret2 = second;
		sum = first + second;
	}
	
	public double calculate()	{
//		return secret1 + secret2;
		return sum;
	}

}
