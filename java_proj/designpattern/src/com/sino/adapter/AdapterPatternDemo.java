package com.sino.adapter;

public class AdapterPatternDemo {

	public static void main(String[] args) {
		AudioPlayer audioPlayer = new AudioPlayer();
		audioPlayer.play("mp3", "byond.mp3");
		audioPlayer.play("mp4", "away.mp4");
		audioPlayer.play("vlc", "fra.vlc");
		audioPlayer.play("avi", "mind.avi");
	}

}
