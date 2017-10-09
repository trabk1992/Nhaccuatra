package tra.com.nhaccuatra;

import android.Manifest;
import android.app.Activity;
import android.app.TabActivity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;

import tra.com.nhaccuatra.main.album.AlbumActivity;
import tra.com.nhaccuatra.main.artists.ArtistActivity;
import tra.com.nhaccuatra.main.playlist.PlayListActivity;
import tra.com.nhaccuatra.main.songs.SongsActivity;

public class MainActivity extends TabActivity {

    private final static int MY_REQUEST_PERMISSION  = 1;
    private TabHost tabHost;
    //trabkpro
    //change 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabHost = (TabHost) findViewById(android.R.id.tabhost);
        if (ContextCompat.checkSelfPermission(MainActivity.this ,
                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this ,
                    new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, MY_REQUEST_PERMISSION);
        } else {
            //getMusic();

        }
        inital();
    }

    private void inital() {


        TabHost.TabSpec playListTab = tabHost.newTabSpec("playList");
        playListTab.setIndicator("PlayList");
        playListTab.setContent(new Intent(this, PlayListActivity.class));

        TabHost.TabSpec songsTab = tabHost.newTabSpec("Songs");
        songsTab.setIndicator("Songs");
        songsTab.setContent(new Intent(this, SongsActivity.class));

        TabHost.TabSpec artistTab = tabHost.newTabSpec("artist");
        artistTab.setIndicator("Artist");
        artistTab.setContent(new Intent(this, ArtistActivity.class));

        TabHost.TabSpec albumTab = tabHost.newTabSpec("album");
        albumTab.setIndicator("Album");
        albumTab.setContent(new Intent(this, AlbumActivity.class));
        //tabHost.setup();

        tabHost.addTab(playListTab);
        tabHost.addTab(songsTab);
        tabHost.addTab(artistTab);
        tabHost.addTab(albumTab);
        tabHost.setCurrentTab(1);

    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_REQUEST_PERMISSION :
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(MainActivity.this ,
                            Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                        //getMusic();
                    }
                } else {
                    finish();
                }
        }
    }
}
