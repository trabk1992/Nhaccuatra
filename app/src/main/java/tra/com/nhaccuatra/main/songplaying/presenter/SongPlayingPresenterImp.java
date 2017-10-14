package tra.com.nhaccuatra.main.songplaying.presenter;

import android.content.Context;
import android.net.Uri;

import tra.com.nhaccuatra.main.songplaying.model.SongPlayingModel;

/**
 * Created by Admin on 10/13/2017.
 */

public class SongPlayingPresenterImp {

    private SongPlayingModel songPlayingModel;

    public SongPlayingPresenterImp(Context context) {
        songPlayingModel = new SongPlayingModel(context);
    }

    public void createSong(Uri uri) {
        songPlayingModel.OnCreate(uri);
    }
    public void playSong() {
        songPlayingModel.OnStart();
    }

    public void pauseSong() {
        songPlayingModel.OnPause();
    }
}
