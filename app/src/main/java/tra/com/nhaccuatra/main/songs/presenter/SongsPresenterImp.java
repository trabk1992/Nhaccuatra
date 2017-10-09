package tra.com.nhaccuatra.main.songs.presenter;

import android.content.Context;

import java.util.ArrayList;

import tra.com.nhaccuatra.main.songs.model.Songs;
import tra.com.nhaccuatra.main.songs.model.SongsModel;

/**
 * Created by Admin on 10/4/2017.
 */

public class SongsPresenterImp {
    private SongsModel model;
    public SongsPresenterImp(Context context) {
        model = new SongsModel(context);
    }

    public ArrayList<Songs> getAllSong() {
        return model.getAllSong();
    }
}
