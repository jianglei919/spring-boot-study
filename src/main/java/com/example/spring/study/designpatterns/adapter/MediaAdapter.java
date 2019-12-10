package com.example.spring.study.designpatterns.adapter;

import com.example.spring.study.designpatterns.adapter.impl.Mp4AdvancedMediaPlayer;
import com.example.spring.study.designpatterns.adapter.impl.VlcAdvancedMediaPlayer;

/**
 * 媒体适配器类，让AudioMediaPlayer也有AdvancedMediaPlayer的功能
 * Created by jianglei on 2019/12/9.
 */
public class MediaAdapter implements MediaPlayer {

    protected AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer = new VlcAdvancedMediaPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer = new Mp4AdvancedMediaPlayer();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}
