package tra.com.nhaccuatra.main.songs.model;

import android.content.Context;

import java.util.ArrayList;

import tra.com.nhaccuatra.database.Song;
import tra.com.nhaccuatra.database.SongHelper;

/**
 * Created by Admin on 10/4/2017.
 */

public class SongsModel {

    private SongHelper helper;
    public SongsModel(Context context) {
        helper = SongHelper.getInstance(context);
    }
    public ArrayList<Songs> getAllSong() {
        ArrayList<Song> songList = helper.getAllSong();
        ArrayList<Songs> songses = new ArrayList<>();

        for (int i = 0; i < songList.size(); i++) {
            Songs song = new Songs(songList.get(i).getSongsName(), songList.get(i).getSingerName(),
                    songList.get(i).getUri());
            songses.add(song);
        }

        return songses;
    }
}
