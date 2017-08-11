package com.example.demo.models;

public class Multiplier {
	double num1;
	double num2;
	
	public Multiplier (double first, double second) {
		num1 = first;
		num2 = second;
	}
	
	public double calculate()	{
		return num1 * num2;
	}
}
