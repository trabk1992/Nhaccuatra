package tra.com.nhaccuatra.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import tra.com.nhaccuatra.notification.SongNotification;

/**
 * Created by Admin on 10/18/2017.
 */

public class SongService extends Service implements MediaPlayer.OnCompletionListener{

    private MediaPlayer mediaPlayer;
    private String uri;
    private IBinder binder = new PlayingSongBinder();
    private ArrayList<TimeChange> listener = new ArrayList<>();
    private Handler handler = new Handler();
    private boolean isPause = false;
    private int finalTime =0;
    private SongNotification notification;
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //Toast.makeText(context, "display", Toast.LENGTH_SHORT).show();

            String action = intent.getAction();
            Log.d("tra.nta","action service "+action);
            if(action.equals("play")) {
                start();
            } else if (action.equals("pause")) {
                pause();
            }
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        //mediaPlayer = new MediaPlayer();
        Toast.makeText(this, "Create service", Toast.LENGTH_SHORT).show();
        registerReceiver(broadcastReceiver, new IntentFilter("play"));
        registerReceiver(broadcastReceiver, new IntentFilter("pause"));
        notification = new SongNotification(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Start Service", Toast.LENGTH_SHORT).show();
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this, "Bind Service", Toast.LENGTH_SHORT).show();
        uri = intent.getStringExtra("uri");
        createSong();
        return binder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(this, "Unbind Service", Toast.LENGTH_SHORT).show();
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Toast.makeText(this, "Unbind Service", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(broadcastReceiver != null) {
           unregisterReceiver(broadcastReceiver);
        }
        Toast.makeText(this, "Destroy service", Toast.LENGTH_SHORT).show();
    }


    public void createSong() {
        Uri uri = Uri.parse(this.uri);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), uri);
        mediaPlayer.setOnCompletionListener(this);
        start();

    }

    public void registerTimeChange(TimeChange timeChange) {
        listener.add(timeChange);
    }

    public void unRegisterTimeChange(TimeChange timeChange) {
       listener.remove(timeChange);
    }

    public void start() {
        isPause = false;
        mediaPlayer.start();
        handler.postDelayed(updateSongTime, 1000);
        notification.setVisiblePlayButton(false);
    }

    public int getFinalTime() {
        finalTime =   mediaPlayer.getDuration();
        return finalTime;
    }

    public int getCurrentTime() {
        return mediaPlayer.getCurrentPosition();
    }

    public void pause() {
        isPause = true;
        mediaPlayer.pause();
        notification.setVisiblePlayButton(true);
    }

    public void release() {
        mediaPlayer.release();
        mediaPlayer = null;
    }

    public void repeat(boolean isRepeat) {
        mediaPlayer.setLooping(isRepeat);
    }

    public void seekTo(int time) {
        if(mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            mediaPlayer.seekTo(time);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mediaPlayer.start();
                }
            },300);
        }else {
            mediaPlayer.seekTo(time);
        }

    }

    private Runnable updateSongTime = new Runnable() {
        @Override
        public void run() {
            if (mediaPlayer != null && !isPause ) {
                Log.d("tra.nta","getCurrentPosition");
                int currentTime = mediaPlayer.getCurrentPosition();
                for (TimeChange o : listener) {
                    o.dataChange(currentTime);
                }

                handler.postDelayed(this, 1000);
            }
        }
    };

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        isPause = true;
        notification.setVisiblePlayButton(true);
        for (TimeChange o : listener) {
            o.OnCompletion();
        }
    }

    public class PlayingSongBinder extends Binder {

        public SongService getService() {
            return SongService.this;
        }
    }
}
