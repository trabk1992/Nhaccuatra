package tra.com.nhaccuatra.main.songs.view;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import tra.com.nhaccuatra.R;
import tra.com.nhaccuatra.main.songs.model.Songs;

/**
 * Created by Admin on 10/10/2017.
 */

public class SongAdapter extends ArrayAdapter<Songs>{

    private Activity activity;
    private ArrayList<Songs> songList;

    public SongAdapter(Context context, int resource, ArrayList<Songs> objects) {
        super(context, resource, objects);
        activity = (Activity) context;
        songList = objects;
    }

    @Override
    public int getCount() {
        return songList.size();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) activity.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_song, parent, false);
        }

        TextView title = (TextView) view.findViewById(R.id.songs_title);
        TextView singer = (TextView) view.findViewById(R.id.songs_singer);

        Songs songs = songList.get(position);
        title.setText(songs.getSongsName());
        singer.setText(songs.getSingerName());

        return view;
    }
}
