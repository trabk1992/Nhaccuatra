package tra.com.nhaccuatra.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by Admin on 10/18/2017.
 */

public class SongService extends Service{

    private MediaPlayer mediaPlayer;
    private String uri;
    private IBinder binder = new PlayingSongBinder();

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Create service", Toast.LENGTH_SHORT).show();
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
        Toast.makeText(this, "Destroy service", Toast.LENGTH_SHORT).show();
    }


    public void createSong() {
        Uri uri = Uri.parse(this.uri);
        mediaPlayer = MediaPlayer.create(this.getApplicationContext(), uri);
    }

    public void start() {
        mediaPlayer.start();
    }

    public void pause() {
        mediaPlayer.pause();
    }

    public class PlayingSongBinder extends Binder {

        public SongService getService() {
            return SongService.this;
        }
    }
}
