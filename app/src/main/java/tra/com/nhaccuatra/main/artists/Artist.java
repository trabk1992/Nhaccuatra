package tra.com.nhaccuatra.main.artists;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Created by Admin on 10/10/2017.
 */

public class Artist {
    private String name;
    private Drawable icon;

    public Artist(String name, Drawable icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }
}
