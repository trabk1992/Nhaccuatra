package tra.com.nhaccuatra;

import android.Manifest;
import android.app.TabActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.widget.TabHost;

import tra.com.nhaccuatra.main.album.view.AlbumActivity;
import tra.com.nhaccuatra.main.artists.view.ArtistActivity;
import tra.com.nhaccuatra.main.playlist.PlayListActivity;
import tra.com.nhaccuatra.main.songs.view.SongsActivity;
import tra.com.nhaccuatra.service.SongService;

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
        startService(new Intent(getApplicationContext(), SongService.class));
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(new Intent(getApplicationContext(), SongService.class));
    }
}
