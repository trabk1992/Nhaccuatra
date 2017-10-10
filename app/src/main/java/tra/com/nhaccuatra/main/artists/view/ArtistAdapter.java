package tra.com.nhaccuatra.main.artists.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import tra.com.nhaccuatra.R;
import tra.com.nhaccuatra.main.artists.Artist;

/**
 * Created by Admin on 10/10/2017.
 */

public class ArtistAdapter extends ArrayAdapter<Artist>{

    private Context context;
    private ArrayList<Artist> artistArrayList;
    private int layout;

    public ArtistAdapter(Context context, int resource, ArrayList<Artist> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layout = resource;
        this.artistArrayList = objects;
    }

    @Override
    public int getCount() {
        return artistArrayList.size();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view ==null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, parent, false);
        }

        TextView artistName = view.findViewById(R.id.artist_name);
        ImageView artistIcon = view.findViewById(R.id.artist_icon);

        Artist artist = artistArrayList.get(position);
        artistName.setText(artist.getName());
        artistIcon.setImageDrawable(artist.getIcon());

        return view;
    }
}
