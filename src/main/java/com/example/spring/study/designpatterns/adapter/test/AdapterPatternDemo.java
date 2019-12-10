package com.example.spring.study.designpatterns.adapter.test;

import com.example.spring.study.designpatterns.adapter.impl.AudioMediaPlayer;

/**
 * Created by jianglei on 2019/12/9.
 */
public class AdapterPatternDemo {

    public static void main(String[] args) {
        AudioMediaPlayer audioPlayer = new AudioMediaPlayer();
        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}
