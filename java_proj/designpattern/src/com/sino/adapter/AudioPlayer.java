package com.sino.adapter;

public class AudioPlayer implements MediaPlayer {
	MediaAdapter mediaAdapter;
	@Override
	public void play(String audioType, String fileName) {
		//播放mp3音乐文件
		if(audioType.equalsIgnoreCase("MP3")){
			System.out.println("playing mp3 file" + fileName);
		}
		else if(audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")){
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
		}
		else{
			System.out.println("invalid media" + audioType + "format not supported");
		}
	}

}
