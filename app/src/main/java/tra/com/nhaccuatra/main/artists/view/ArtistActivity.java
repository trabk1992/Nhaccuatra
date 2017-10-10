package tra.com.nhaccuatra.main.artists.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import tra.com.nhaccuatra.MainActivity;
import tra.com.nhaccuatra.R;
import tra.com.nhaccuatra.main.artists.Artist;
import tra.com.nhaccuatra.main.artists.presenter.ArtistPresenterImp;

/**
 * Created by Admin on 10/9/2017.
 */

public class ArtistActivity extends Activity{

    private ListView artistListView;
    private ArtistPresenterImp presenterImp;
    private ArtistAdapter artistAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_artists);
        artistListView = (ListView) findViewById(R.id.artist_listView);
        presenterImp = new ArtistPresenterImp(getApplicationContext());
        ArrayList<Artist> artistArrayList = presenterImp.getAllArtist();
        artistAdapter = new ArtistAdapter(getApplicationContext(), R.layout.item_artist,
                artistArrayList);
        artistListView.setAdapter(artistAdapter);
    }
}
