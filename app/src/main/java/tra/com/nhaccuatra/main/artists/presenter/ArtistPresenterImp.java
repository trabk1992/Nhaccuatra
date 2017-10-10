package tra.com.nhaccuatra.main.artists.presenter;

import android.content.Context;

import java.util.ArrayList;

import tra.com.nhaccuatra.main.artists.Artist;
import tra.com.nhaccuatra.main.artists.model.ArtistModel;

/**
 * Created by Admin on 10/10/2017.
 */

public class ArtistPresenterImp {

    private ArtistModel model;

    public ArtistPresenterImp(Context context) {
        model = new ArtistModel(context);
    }

    public ArrayList<Artist> getAllArtist() {
        return model.getAllArtist();
    }
 }
