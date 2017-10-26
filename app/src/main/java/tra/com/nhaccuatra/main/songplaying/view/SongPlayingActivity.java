package tra.com.nhaccuatra.main.songplaying.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import tra.com.nhaccuatra.R;
import tra.com.nhaccuatra.main.songplaying.presenter.SongPlayingPresenterImp;

/**
 * Created by Admin on 10/13/2017.
 */

public class SongPlayingActivity extends Activity implements View.OnClickListener, SongPlayingView{

    private ImageButton playingButton;
    private ImageButton pauseButton;
    private SongPlayingPresenterImp songPlayingPresenterImp;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_playing);

        playingButton = (ImageButton) findViewById(R.id.playing_button);
        pauseButton = (ImageButton) findViewById(R.id.pause_button);
        playingButton.setOnClickListener(this);
        pauseButton.setOnClickListener(this);

        initalView();
        intent = getIntent();
        String uri = intent.getStringExtra("uri");
        songPlayingPresenterImp = new SongPlayingPresenterImp(getApplicationContext(), uri, this);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        songPlayingPresenterImp.destroyService();
        songPlayingPresenterImp = null;
    }

    public void initalView() {
        playingButton.setVisibility(View.GONE);
        pauseButton.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.playing_button :
                songPlayingPresenterImp.playingButtonClick();
                break;
            case R.id.pause_button :
                songPlayingPresenterImp.pauseButtonClick();
                break;
        }
    }

    @Override
    public void updateViewState(String action) {
        if (action.equals("playing")) {
            playingButton.setVisibility(View.GONE);
            pauseButton.setVisibility(View.VISIBLE);
        } else if (action.equals("pause")) {
            playingButton.setVisibility(View.VISIBLE);
            pauseButton.setVisibility(View.GONE);
        }
    }
}
