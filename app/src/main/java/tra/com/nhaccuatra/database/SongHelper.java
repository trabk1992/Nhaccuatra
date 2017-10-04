package tra.com.nhaccuatra.database;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Admin on 10/4/2017.
 */

public class SongHelper {
    private Context context;
    private ArrayList<Song> songsList;
    public static SongHelper songHelper = null;
    public SongHelper(Context context) {
        this.context = context;
        songsList = getAllSong();
    }

    public static SongHelper getInstance(Context context) {
        if (songHelper == null) {
            songHelper = new SongHelper(context);
        }

        return songHelper;
    }
    public ArrayList<Song> getAllSong() {
        ArrayList<Song> songArrayList = new ArrayList<>();
        ContentResolver contentResolver = context.getContentResolver();
        Uri songsUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor songsCursor = contentResolver.query(songsUri, null, null, null, null);

        if (songsCursor != null && songsCursor.moveToFirst()) {
            int titleIndex = songsCursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
            int albumIndex = songsCursor.getColumnIndex(MediaStore.Audio.Media.ALBUM);
            int singerIndex = songsCursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);
            int timeIndex = songsCursor.getColumnIndex(MediaStore.Audio.Media.SIZE);

            do {

                String songsTitle = songsCursor.getString(titleIndex);
                String songsAlbum = songsCursor.getString(albumIndex);
                String singer = songsCursor.getString(singerIndex);
                String time = songsCursor.getString(timeIndex);

                Song song = new Song(songsTitle, singer, songsAlbum, time);
                songArrayList.add(song);

                Log.d("tra.nta", " title "+songsTitle);
                Log.d("tra.nta", " album "+songsAlbum);
            } while (songsCursor.moveToNext());
        }

        return songArrayList;
    }
}
