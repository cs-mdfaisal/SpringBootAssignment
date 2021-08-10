package com.phoenix.di.performers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.phoenix.di.instruments.Instrument;

@Component("Pyaare_Raghav")
public class Instrumentalist implements Performer {

	@Autowired
	private Instrument instrument;
	
	@Value("Awara Hu....")
	private String song;
	
	@Override
	public void perform() {
		// TODO Auto-generated method stub
		System.out.println("Instrumentalist is playing a song "+song);
		instrument.play();
	}

}
