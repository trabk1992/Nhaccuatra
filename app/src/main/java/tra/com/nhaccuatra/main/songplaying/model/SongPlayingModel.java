package tra.com.nhaccuatra.main.songplaying.model;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

/**
 * Created by Admin on 10/13/2017.
 */

public class SongPlayingModel {

    private MediaPlayer mediaPlayer;
    private Context context;

    public SongPlayingModel(Context context){
        this.context = context;
    }

    public void OnCreate(Uri uri) {
       mediaPlayer = MediaPlayer.create(context,uri);
    }

    public void OnStart() {
        mediaPlayer.start();
    }

    public void OnPause() {
        mediaPlayer.pause();
    }
}
