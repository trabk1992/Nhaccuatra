package tra.com.nhaccuatra.main.songplaying.presenter;

import android.content.Context;
import android.net.Uri;

import tra.com.nhaccuatra.main.songplaying.model.SongPlayingModel;
import tra.com.nhaccuatra.main.songplaying.view.SongPlayingView;

/**
 * Created by Admin on 10/13/2017.
 */

public class SongPlayingPresenterImp {

    private SongPlayingModel songPlayingModel;
    private SongPlayingView songPlayingView;

    public SongPlayingPresenterImp(Context context,String uri, SongPlayingView songPlayingView) {
        this.songPlayingView = songPlayingView;
        songPlayingModel = new SongPlayingModel(context);
        Uri mUri = Uri.parse(uri);
        songPlayingModel.OnCreate(mUri);
        songPlayingModel.OnStart();
    }


    public void playingButtonClick() {
        songPlayingModel.OnStart();
        songPlayingView.updateViewState("playing");
    }


    public void pauseButtonClick() {
        songPlayingModel.OnPause();
        songPlayingView.updateViewState("pause");
    }
}
