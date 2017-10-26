package tra.com.nhaccuatra.main.songs.model;

/**
 * Created by Admin on 10/4/2017.
 */

public class Songs {
    private String songsName;
    private String singerName;
    private String uri;

    public Songs(String songsName, String singerName, String uri) {
        this.songsName = songsName;
        this.singerName = singerName;
        this.uri = uri;
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

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }
}
