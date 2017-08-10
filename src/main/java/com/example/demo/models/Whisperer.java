package com.example.demo.models;

public class Whisperer {
	String messageToWhisper;
	
	public Whisperer(String message)	{
		messageToWhisper = message;
	}
	
	public String whisper()	{
		return messageToWhisper.toLowerCase();
	}

}
