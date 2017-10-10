package tra.com.nhaccuatra.main.album.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import tra.com.nhaccuatra.R;
import tra.com.nhaccuatra.main.album.Album;
import tra.com.nhaccuatra.main.album.presenter.AlbumPresenterImp;

/**
 * Created by Admin on 10/9/2017.
 */

public class AlbumActivity extends Activity{

    private ListView albumListView;
    private ArrayList<Album> albumArrayList;
    private AlbumPresenterImp presenterImp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_album);

        albumListView = (ListView) findViewById(R.id.album_listView);
        presenterImp = new AlbumPresenterImp(getApplicationContext());
        ArrayList<Album> albumArrayList = presenterImp.getAllAlbum();
        AlbumAdapter albumAdapter = new AlbumAdapter(getApplicationContext(), R.layout.item_album,
                albumArrayList);
        albumListView.setAdapter(albumAdapter);
    }
}
