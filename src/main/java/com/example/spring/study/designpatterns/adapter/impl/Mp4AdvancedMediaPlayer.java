package com.example.spring.study.designpatterns.adapter.impl;

import com.example.spring.study.designpatterns.adapter.AdvancedMediaPlayer;

/**
 * Created by jianglei on 2019/12/9.
 */
public class Mp4AdvancedMediaPlayer implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        //什么也不做
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Play mp4 file name:" + fileName);
    }
}
