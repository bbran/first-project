package com.example.demo.models;

public class Yeller {
	String messageToYell;
	
	public Yeller(String message)	{
		messageToYell = message;
	}
	
	public String yell()	{
		return messageToYell.toUpperCase();
	}

}
