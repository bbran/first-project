package com.example.demo.models;

public class Exponentiator {
	double num1;
	double num2;
	
	public Exponentiator (double first, double second)	{
		num1 = first;
		num2 = second;
	}
	
	public double calculate()	{
		return Math.pow(num1, num2);
	}

}
