package tra.com.nhaccuatra.main.songs.model;

/**
 * Created by Admin on 10/4/2017.
 */

public class Songs {
    private String songsName;
    private String singerName;

    public Songs(String songsName, String singerName) {
        this.songsName = songsName;
        this.singerName = singerName;
    }

    public String getSongsName() {
        return songsName;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSongsName(String songsName) {
        this.songsName = songsName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }
}
