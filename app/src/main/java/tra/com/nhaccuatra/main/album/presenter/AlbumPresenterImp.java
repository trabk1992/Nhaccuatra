package tra.com.nhaccuatra.main.album.presenter;

import android.content.Context;

import java.util.ArrayList;

import tra.com.nhaccuatra.main.album.Album;
import tra.com.nhaccuatra.main.album.model.AlbumModel;

/**
 * Created by Admin on 10/11/2017.
 */

public class AlbumPresenterImp {

    private AlbumModel model;

    public AlbumPresenterImp(Context context) {
        model = new AlbumModel(context);
    }

    public ArrayList<Album> getAllAlbum() {
        return model.getAllAlbum();
    }
}
