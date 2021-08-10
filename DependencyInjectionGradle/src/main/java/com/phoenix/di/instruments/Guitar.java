package com.phoenix.di.instruments;
/*
 * @author md.faisal
 * @version 2.0
 * @creation date 29-july-2021
 * @description Spring bean class
 */
import org.springframework.stereotype.Component;

@Component
public class Guitar implements Instrument {

	@Override
	public void play() {
		// TODO Auto-generated method stub

		System.out.println("Ting Ting ting...");
	}

}
