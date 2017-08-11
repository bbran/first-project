package com.example.demo.models;

public class Divider {
	double num1;
	double num2;
	
	public Divider (double first, double second)	{
		num1 = first;
		num2 = second;
	}
	
	public double calculate()	{
		return num1 / num2;
	}

}
