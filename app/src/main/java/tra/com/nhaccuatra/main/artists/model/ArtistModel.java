package tra.com.nhaccuatra.main.artists.model;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;

import tra.com.nhaccuatra.R;
import tra.com.nhaccuatra.database.Song;
import tra.com.nhaccuatra.database.SongHelper;
import tra.com.nhaccuatra.main.artists.Artist;

/**
 * Created by Admin on 10/10/2017.
 */

public class ArtistModel {

    private SongHelper helper;
    private Context context;

    public ArtistModel(Context context) {
        helper = SongHelper.getInstance(context);
        this.context = context;
    }

    public ArrayList<Artist> getAllArtist() {
        ArrayList<Artist> artists = new ArrayList<>();
        ArrayList<Song> songs = helper.getAllSong();
        Drawable icon = context.getDrawable(R.drawable.ic_launcher);
        for (Song song : songs) {
            String singer = song.getSingerName();
            Artist artist = new Artist(singer , icon);
            artists.add(artist);
        }

        return artists;
    }
}
