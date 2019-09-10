package com.structural.proxy;

import java.util.Calendar;

import com.model.Guitar;
import com.model.MusicInstrument;

public class ProxyGuitar implements MusicInstrument{
	
	@Override
	public void playMusic() {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if (hour>8 && hour <22) {
			Guitar guitar = new Guitar();
			guitar.playMusic();
		}		
	}

}
