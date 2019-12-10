package com.example.spring.study.designpatterns.adapter.impl;

import com.example.spring.study.designpatterns.adapter.AdvancedMediaPlayer;

/**
 * Created by jianglei on 2019/12/9.
 */
public class VlcAdvancedMediaPlayer implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        System.out.println("Play vlc file name:" + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //什么也不做
    }
}
