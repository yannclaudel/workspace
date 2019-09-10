package com.structural.proxy;

import com.model.MusicInstrument;

public class Test {
	public static void main(String[] args) {
		MusicInstrument instrument = new ProxyGuitar();
		instrument.playMusic();
	}
}
