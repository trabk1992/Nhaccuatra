package tra.com.nhaccuatra.main.album.model;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;

import tra.com.nhaccuatra.R;
import tra.com.nhaccuatra.database.Song;
import tra.com.nhaccuatra.database.SongHelper;
import tra.com.nhaccuatra.main.album.Album;

/**
 * Created by Admin on 10/10/2017.
 */

public class AlbumModel {

    private SongHelper helper;
    private Context context;

    public AlbumModel(Context context) {
        this.context = context;
        helper = SongHelper.getInstance(context);
    }

    public ArrayList<Album> getAllAlbum() {
        ArrayList<Album> albumArrayList = new ArrayList<>();
        ArrayList<Song> songs = helper.getAllSong();
        Drawable icon = context.getDrawable(R.drawable.ic_launcher);

        for (Song song : songs) {
           String albumName = song.getAlbumName();
           Album album = new Album(albumName, icon);
           albumArrayList.add(album);
        }

        return albumArrayList;
    }

}
