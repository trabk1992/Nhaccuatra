package tra.com.nhaccuatra.main.album.view;

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
import tra.com.nhaccuatra.main.album.Album;

/**
 * Created by Admin on 10/10/2017.
 */

public class AlbumAdapter extends ArrayAdapter<Album>{

    private Context context;
    private int layout;
    private ArrayList<Album> albumArrayList;

    public AlbumAdapter(Context context, int resource, ArrayList<Album> objects) {
        super(context, resource, objects);

        this.context = context;
        layout = resource;
        albumArrayList = objects;
    }

    @Override
    public int getCount() {
        return albumArrayList.size();
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

        TextView albumName = view.findViewById(R.id.album_name);
        ImageView albumIcon = view.findViewById(R.id.album_icon);

        Album album = albumArrayList.get(position);
        albumName.setText(album.getName());
        albumIcon.setImageDrawable(album.getIcon());

        return view;
    }
}
