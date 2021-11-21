package com.mega.mobile12;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    MediaPlayer mediaPlayer;

    public MyService() {
    }

    @Override
    public void onCreate() {
        Log.d("백그라운드 서비스>>", "서비스 객체 생성됨.!!!");

        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("백그라운드 서비스>>", "서비스 명령어 실행됨.!!!");
        mediaPlayer = MediaPlayer.create(this, R.raw.m2);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d("백그라운드 서비스>>", "서비스 객체 소멸됨.!!!");
        mediaPlayer.stop();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not Yet Implemented!!");
    }
}