package com.sino.adapter;
/**
 * mediaPlayer可以播放mp3格式，advanceMediaPlayer播放mp4等格式。
 * 为了让meidiaPlayer播放mp4等高级格式，添加mediaPlayer的适配器(适配器中包含mp4等格式类型)
 *然后创建一个audio的类，支持mp3,也支持mp4
 */
public interface MediaPlayer {
	void play(String audioType,String fileName);

}
