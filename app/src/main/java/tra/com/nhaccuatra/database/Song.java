package tra.com.nhaccuatra.database;

/**
 * Created by Admin on 10/4/2017.
 */

public class Song {

    private String songsName;
    private String singerName;
    private String albumName;
    private String songsTime;

    public Song(String songsName, String singerName, String albumName, String songsTime) {
        this.songsName = songsName;
        this.singerName = singerName;
        this.albumName = albumName;
        this.songsTime = songsTime;
    }

    public String getSongsName() {
        return songsName;
    }

    public String getSingerName() {
        return singerName;
    }

    public String getSongsTime() {
        return songsTime;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setSongsName(String songsName) {
        this.songsName = songsName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public void setSongsTime(String songsTime) {
        this.songsTime = songsTime;
    }
}
