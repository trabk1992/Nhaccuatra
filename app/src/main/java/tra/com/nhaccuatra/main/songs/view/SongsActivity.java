package tra.com.nhaccuatra.main.songs.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import tra.com.nhaccuatra.MainActivity;
import tra.com.nhaccuatra.R;
import tra.com.nhaccuatra.main.songplaying.view.SongPlayingActivity;
import tra.com.nhaccuatra.main.songs.model.Songs;
import tra.com.nhaccuatra.main.songs.presenter.SongsPresenterImp;

/**
 * Created by Admin on 10/3/2017.
 */

public class SongsActivity extends Activity{

    private SongsPresenterImp presenterImp;
    private ListView songsListView;
    ArrayList<Songs> songsArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_songs);
        presenterImp = new SongsPresenterImp(this);
        songsListView = (ListView) findViewById(R.id.songs_listView);
        songsArrayList = presenterImp.getAllSong();
        SongAdapter adapter = new SongAdapter(this, R.layout.item_song, songsArrayList );
        songsListView.setAdapter(adapter);

        songsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String uri = songsArrayList.get(i).getUri();
                Intent intent = new Intent(SongsActivity.this, SongPlayingActivity.class);
                intent.putExtra("uri", uri);
                startActivity(intent);
            }
        });
    }



}
