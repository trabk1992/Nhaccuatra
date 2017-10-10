package tra.com.nhaccuatra.main.album;

import android.graphics.drawable.Drawable;

/**
 * Created by Admin on 10/10/2017.
 */

public class Album {

    private String name;
    private Drawable icon;

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

    public Album(String name, Drawable icon) {

        this.name = name;
        this.icon = icon;
    }
}
