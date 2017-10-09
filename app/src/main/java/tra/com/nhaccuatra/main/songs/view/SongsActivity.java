package tra.com.nhaccuatra.main.songs.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import tra.com.nhaccuatra.R;
import tra.com.nhaccuatra.main.songs.model.Songs;
import tra.com.nhaccuatra.main.songs.presenter.SongsPresenterImp;

/**
 * Created by Admin on 10/3/2017.
 */

public class SongsActivity extends Activity{

    private SongsPresenterImp presenterImp;
    private ListView songsListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_songs);
        presenterImp = new SongsPresenterImp(this);
        songsListView = (ListView) findViewById(R.id.songs_listView);
        ArrayList<Songs> songsArrayList = presenterImp.getAllSong();
        SongAdapter adapter = new SongAdapter(this, R.layout.item_song, songsArrayList );
        songsListView.setAdapter(adapter);
    }

}
