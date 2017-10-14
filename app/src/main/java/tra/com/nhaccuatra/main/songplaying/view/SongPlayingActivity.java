package tra.com.nhaccuatra.main.songplaying.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import tra.com.nhaccuatra.R;
import tra.com.nhaccuatra.main.songplaying.presenter.SongPlayingPresenterImp;

/**
 * Created by Admin on 10/13/2017.
 */

public class SongPlayingActivity extends Activity implements View.OnClickListener{

    private Button startSong;
    private Button stopSong;
    private SongPlayingPresenterImp presenterImp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        startSong = (Button) findViewById(R.id.start_button);
        stopSong = (Button) findViewById(R.id.stop_button);
        startSong.setOnClickListener(this);
        stopSong.setOnClickListener(this);


        presenterImp = new SongPlayingPresenterImp(getApplicationContext());


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start_button :
                break;
            case R.id.stop_button :
                break;
        }
    }
}
