package com.sino.adapter;

public class VlcPlayer implements AdvanceMediaPlayer {

	@Override
	public void playVlc(String fileName) {
		System.out.println("playing vlc fileName" + fileName);
	}

	@Override
	public void playMp4(String fileName) {

	}

}
